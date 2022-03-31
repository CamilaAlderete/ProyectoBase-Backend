package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.Uso_puntos_cabeceraDAO;
import py.com.progweb.prueba.model.Uso_puntos_cabecera;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("cabecera")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class Uso_puntos_cabeceraRest {
    @Inject
    private Uso_puntos_cabeceraDAO cabeceraDAO;



    @GET
    @Path("/concepto/{idConcepto}")
    public Response getByConcepto(@PathParam("idConcepto") Integer idConcepto) {
        try {
            return Response.ok(cabeceraDAO.get(idConcepto)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(404).entity("No se encontro Uso de Puntos en este Concepto").build();
        }
    }

 /*   @GET
    @Path("/fecha/{fecha}")
    public Response getByFecha(@PathParam("fecha") String fecha){
        try {
            return Response.ok(cabeceraDAO.get(fecha)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(404).entity("No se encontro Uso de Puntos en esta Fecha").build();
        }
    }
 */
    @GET
    @Path("/cliente/{idCliente}")
    public Response getByCliente(@PathParam("idCliente") Long idCliente){
        try {
            return Response.ok(cabeceraDAO.get(idCliente)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(404).entity("No se encontro Uso de Puntos en este Cliente").build();
        }
    }


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

}
