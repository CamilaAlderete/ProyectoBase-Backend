package py.com.progweb.prueba.rest;

//import py.com.progweb.prueba.ejb.OperacionesPuntosDAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import py.com.progweb.prueba.ejb.Asignacion_puntosDAO;
import py.com.progweb.prueba.ejb.BolsaDAO;
import py.com.progweb.prueba.ejb.ClienteDAO;
import py.com.progweb.prueba.ejb.Concepto_puntosDAO;
import py.com.progweb.prueba.model.Bolsa;
import py.com.progweb.prueba.model.CargaPuntos;
import py.com.progweb.prueba.model.Cliente;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;


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

            return Response.ok("Bolsa de puntos creada exitosamente").build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

//    @POST
//    @Path("/uso-de-puntos")
//    public Response usoDePuntos(String jsonString){
//
//
//        try {
//
//            ObjectMapper mapper = new ObjectMapper();
//
//            //json a objeto
//            UsoPuntos usoPuntos = mapper.readValue(jsonString, UsoPuntos.class);
//
//            Cliente cliente = clienteDAO.get( usoPuntos.getIdCliente() );
//
//            Concepto_puntos conceptoPuntos = concepto_puntosDAO.get( usoPuntos.getIdConceptoUso() );
//
//            List<Bolsa> bolsas = bolsaDAO.getBolsasPorCliente(cliente);
//
//            return Response.ok().build();
//
//        }catch(Exception e){
//            return Response.serverError().build();
//        }
//    }


}
