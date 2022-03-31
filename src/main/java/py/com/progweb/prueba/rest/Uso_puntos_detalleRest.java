package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.Uso_puntos_detalleDAO;
import py.com.progweb.prueba.model.Uso_puntos_detalle;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("detalle")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class Uso_puntos_detalleRest {
    @Inject
    private Uso_puntos_detalleDAO detalleDAO;

    @GET
    @Path("/")
    public Response listar(){
        try {
            return Response.ok( detalleDAO.getAll() ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Uso_puntos_detalle detalle){

        try {
            this.detalleDAO.persist(detalle);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/")
    public Response editar(Uso_puntos_detalle detalle){

        try {
            this.detalleDAO.merge(detalle);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar( @PathParam("id") int id){

        try {

            this.detalleDAO.delete(id);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

}
