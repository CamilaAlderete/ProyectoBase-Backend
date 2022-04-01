package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.BolsaDAO;
import py.com.progweb.prueba.model.Bolsa;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("bolsa")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class BolsaRest {
    @Inject
    private BolsaDAO bolsaDAO;

    @GET
    @Path("/")
    public Response listar(){
        try {
            return Response.ok( bolsaDAO.getAll() ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Bolsa bolsa){

        try {
            this.bolsaDAO.persist(bolsa);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/")
    public Response editar(Bolsa bolsa){

        try {
            this.bolsaDAO.merge(bolsa);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar( @PathParam("id") int id){

        try {

            this.bolsaDAO.delete(id);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

}
