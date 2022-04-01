package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.Concepto_puntosDAO;
import py.com.progweb.prueba.model.Concepto_puntos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("concepto_puntos")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class Concepto_puntosRest {
    @Inject
    private Concepto_puntosDAO concepto_puntosDAO;

    @GET
    @Path("/")
    public Response listar(){
        try {
            return Response.ok( concepto_puntosDAO.getAll() ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Concepto_puntos concepto_puntos){

        try {
            this.concepto_puntosDAO.persist(concepto_puntos);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/")
    public Response editar(Concepto_puntos concepto_puntos){

        try {
            this.concepto_puntosDAO.merge(concepto_puntos);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar( @PathParam("id") int id){

        try {

            this.concepto_puntosDAO.delete(id);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

}
