package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.Asignacion_puntosDAO;
import py.com.progweb.prueba.model.Asignacion_puntos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("asignacion_puntos")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class Asignacion_puntosRest {
    @Inject
    private Asignacion_puntosDAO asignacion_puntosDAO;

    @GET
    @Path("/")
    public Response listar(){
        try {
            return Response.ok( asignacion_puntosDAO.getAll() ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Asignacion_puntos asignacion_puntos){

        try {
            this.asignacion_puntosDAO.persist(asignacion_puntos);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/")
    public Response editar(Asignacion_puntos asignacion_puntos){

        try {
            this.asignacion_puntosDAO.merge(asignacion_puntos);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar( @PathParam("id") int id){

        try {

            this.asignacion_puntosDAO.delete(id);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

}
