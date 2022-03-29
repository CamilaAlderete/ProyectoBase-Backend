package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.ClienteDAO;
import py.com.progweb.prueba.model.Cliente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("cliente")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class ClienteRest {
    @Inject
    private ClienteDAO clienteDAO;

    @GET
    @Path("/")
    public Response listar(){
        try {
            return Response.ok( clienteDAO.getAll() ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response crear(Cliente cliente){

        try {
            this.clienteDAO.persist(cliente);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/")
    public Response editar(Cliente cliente){

        try {
            this.clienteDAO.merge(cliente);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar( @PathParam("id") int id){

        try {

            this.clienteDAO.delete(id);
            return Response.ok().build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

}
