package py.com.progweb.prueba.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import py.com.progweb.prueba.ejb.*;
import py.com.progweb.prueba.model.*;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Path("operaciones-con-puntos")
@Consumes("application/json")
@Produces("application/json")

/*

    -carga de puntos (POST): se recibe el identificador de cliente y el monto de la
    operación, y se asigna los puntos (genera datos con la estructura del punto 5)

    - utilizar puntos (POST): se recibe el identificador del cliente y el identificador del
    concepto de uso y se descuenta dicho puntaje al cliente registrando el uso de puntos
    (genera datos con la estructura del punto 6 y actualiza la del punto 5)
    o además debe enviar un correo electrónico al cliente como comprobante

    - consultar cuantos puntos equivale a un monto X (GET): es un servicio informativo
    que devuelve la cantidad de puntos equivalente al monto proporcionado como
    parámetro utilizando la configuración del punto 3

*/

public class OperacionesPuntosRest {

    @Inject
    private ClienteDAO clienteDAO;

    @Inject
    private Asignacion_puntosDAO asignacion_puntosDAO;

    @Inject
    private BolsaDAO bolsaDAO;

    @Inject
    private Concepto_puntosDAO concepto_puntosDAO;

    @Inject
    private Uso_puntos_cabeceraDAO uso_puntos_cabeceraDAO;

    @Inject
    private Uso_puntos_detalleDAO uso_puntos_detalleDAO;


    @POST
    @Path("/carga-de-puntos")
    public Response cargaDePuntos(String jsonString){

        /* se recibe el id del cliente, el monto gastado
         y los dias de duracion de los puntos que seran asignados
         al cliente por su compra, en formato json
        */


        try {

            ObjectMapper mapper = new ObjectMapper();

            //json a objeto
            CargaPuntos cargaPuntos = mapper.readValue(jsonString, CargaPuntos.class);

            Date fechaAsignacion = new Date();

            //calculo de fecha de caducidad de acuerdo a los dias de duracion
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaAsignacion);
            calendar.add(Calendar.DATE, cargaPuntos.getDiasDuracion() );

            Date fechaCaducidad = calendar.getTime();

            Cliente cliente = clienteDAO.get( cargaPuntos.getIdCliente() );

            Integer puntajeAsignado = asignacion_puntosDAO.puntaje_equivalente( cargaPuntos.getMonto() );

            Integer monto = cargaPuntos.getMonto();

            Bolsa bolsa = new Bolsa(fechaAsignacion, fechaCaducidad,puntajeAsignado,0,puntajeAsignado,monto,cliente);

            bolsaDAO.persist(bolsa);

            return Response.ok("Bolsa de puntos creada exitosamente, se generaron "+puntajeAsignado.toString()+" puntos").build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }



    /****************************************************/

    @POST
    @Path("/uso-de-puntos")
    public Response usoDePuntos(String jsonString){


        try {

            ObjectMapper mapper = new ObjectMapper();

            //json a objeto
            UsoPuntos usoPuntos = mapper.readValue(jsonString, UsoPuntos.class);

            Cliente cliente = clienteDAO.get( usoPuntos.getIdCliente() );

            Concepto_puntos conceptoPuntos = concepto_puntosDAO.get( usoPuntos.getIdConceptoUso() );

            List<Bolsa> bolsas = bolsaDAO.getBolsasPorCliente(cliente);

             Uso_puntos_cabecera uso_puntos_cabecera = utilizarPuntos(cliente, conceptoPuntos, bolsas);

            Email.enviarConGMail( cliente.getEmail(), "Comprobante de uso de puntos", uso_puntos_cabecera.toString() );

            return Response.ok().build();

        }catch(Exception e){
            return Response.status(404).entity(e.getMessage()).build();
            //return Response.serverError().build();
        }
    }






    public Uso_puntos_cabecera utilizarPuntos(Cliente cliente, Concepto_puntos conceptoPuntos, List<Bolsa> bolsas) throws Exception{

        try{

            List<Bolsa> bolsas_a_usar = new ArrayList<Bolsa>();

            int puntosRequeridos = conceptoPuntos.getPuntos_requeridos();
            int sumaPuntos = 0;
            int puntos;

            //se calcula si se tiene el puntaje requerido
            for ( Bolsa bolsa : bolsas){

                puntos = bolsa.getSaldoPuntos();
                sumaPuntos += puntos;
                bolsas_a_usar.add(bolsa);

                if (sumaPuntos >= puntosRequeridos){
                    break;
                }

            }

            //se tiene los puntos requeridos
            if ( sumaPuntos >= puntosRequeridos && sumaPuntos!=0){

                //se crea cabecera
                java.util.Date fecha = new java.util.Date();
                Uso_puntos_cabecera uso_puntos_cabecera = new Uso_puntos_cabecera(cliente,conceptoPuntos,puntosRequeridos,fecha);
                uso_puntos_cabeceraDAO.persist(uso_puntos_cabecera);


                //se itera sobre todas las bolsas para crear los detalles
                for (Bolsa bolsa: bolsas_a_usar){

                    puntos = bolsa.getSaldoPuntos();

                    if (puntos == 0){
                        continue;
                    }

                    if ( puntosRequeridos >= puntos ){

                        puntosRequeridos = puntosRequeridos - puntos;

                        int puntajeUtilizadoEnBolsa = bolsa.getPuntajeUtilizado();
                        bolsa.setPuntajeUtilizado( puntajeUtilizadoEnBolsa + puntos);
                        bolsa.setSaldoPuntos(0);

                        //se guarda cambios en bolsa
                        bolsaDAO.merge(bolsa);

                        //se crear detalle de uso de puntos
                        Uso_puntos_detalle uso_puntos_detalle = new Uso_puntos_detalle(uso_puntos_cabecera,bolsa,puntos);
                        uso_puntos_detalleDAO.persist(uso_puntos_detalle);





                    }else if (puntosRequeridos < puntos){

                        int diferencia = puntos - puntosRequeridos;

                        int puntajeUtilizadoEnBolsa = bolsa.getPuntajeUtilizado();
                        bolsa.setPuntajeUtilizado( puntajeUtilizadoEnBolsa + puntosRequeridos);
                        bolsa.setSaldoPuntos(diferencia);

                        //guarda cambios en bolsa
                        bolsaDAO.merge(bolsa);

                        //se crear detalle de uso de puntos
                        Uso_puntos_detalle uso_puntos_detalle = new Uso_puntos_detalle(uso_puntos_cabecera,bolsa,puntosRequeridos);
                        uso_puntos_detalleDAO.persist(uso_puntos_detalle);

                        puntosRequeridos =0;


                    }

                    if(puntosRequeridos == 0){
                        break;
                    }

                }

                return uso_puntos_cabecera;


            }else{
                throw new Exception("No se tienen los puntos necesarios");
            }

        }catch (Exception e){
            throw new Exception("No se pudieron utilizar los puntos");
        }

    }





}
