package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.ClienteDAO;
import py.com.progweb.prueba.model.Cliente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

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


    @GET
    @Path("/nombre/{nombre}")
    public Response getByNombre( @PathParam("nombre") String nombre){

        try {

            List<Cliente> lista =  this.clienteDAO.getClienteByNombre(nombre);
            return Response.ok(lista).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/apellido/{apellido}")
    public Response getByApellido( @PathParam("apellido") String apellido){

        try {

            List<Cliente> lista =  this.clienteDAO.getClienteByApellido(apellido);
            return Response.ok(lista).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/cumple/{fecha}")
    public Response getByCumple( @PathParam("fecha") String fecha){

        try {

            List<Cliente> lista =  this.clienteDAO.getClienteByCumple(fecha);
            return Response.ok(lista).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/puntos-a-vencer/{dias}")
    public Response getByPuntajePorVencer( @PathParam("dias") int dias){

        try {

            List<Cliente> lista =  this.clienteDAO.getClientesPuntosPorVencer(dias);
            return Response.ok(lista).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }


}
