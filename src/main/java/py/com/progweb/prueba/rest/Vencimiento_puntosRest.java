package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.Vencimiento_puntosDAO;
import py.com.progweb.prueba.model.Vencimiento_puntos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("vencimiento")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class Vencimiento_puntosRest {
    @Inject
    private Vencimiento_puntosDAO vencimientoDAO;

    @GET
    @Path("/")
    public Response listar(){
        try {
            return Response.ok(vencimientoDAO.getAll() ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Vencimiento_puntos vencimiento){

        try {
            this.vencimientoDAO.persist(vencimiento);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/")
    public Response editar(Vencimiento_puntos vencimiento){

        try {
            this.vencimientoDAO.merge(vencimiento);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar( @PathParam("id") int id){

        try {

            this.vencimientoDAO.delete(id);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

}
