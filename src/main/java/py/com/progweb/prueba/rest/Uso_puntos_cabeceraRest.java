package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.Uso_puntos_cabeceraDAO;
import py.com.progweb.prueba.model.Uso_puntos_cabecera;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("uso_puntos_cabecera")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class Uso_puntos_cabeceraRest {
    @Inject
    private Uso_puntos_cabeceraDAO cabeceraDAO;


    @GET
    @Path("/")
    public Response listar(){
        try {
            return Response.ok( cabeceraDAO.getAll() ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Uso_puntos_cabecera cabecera){

        try {
            this.cabeceraDAO.persist(cabecera);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/")
    public Response editar(Uso_puntos_cabecera cabecera){

        try {
            this.cabeceraDAO.merge(cabecera);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar( @PathParam("id") int id){

        try {

            this.cabeceraDAO.delete(id);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/concepto/{idConcepto}")
    public Response getByConcepto(@PathParam("idConcepto") int idConcepto) {
        try {

            List<Uso_puntos_cabecera> lista = cabeceraDAO.getUsoPuntosByConcepto(idConcepto);
            return Response.ok( lista ).build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }


    @GET
    @Path("/cliente/{idCliente}")
    public Response getByCliente(@PathParam("idCliente") int idCliente){
        try {

            List<Uso_puntos_cabecera> lista = cabeceraDAO.getUsoPuntosByCliente(idCliente);
            return Response.ok(lista).build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/fecha/{stringFecha}")
    public Response getByFecha(@PathParam("stringFecha") String stringFecha){
        try {

            List<Uso_puntos_cabecera> lista = cabeceraDAO.getUsoPuntosByFecha(stringFecha);
            return Response.ok(lista).build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }


}
