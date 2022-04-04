package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.BolsaDAO;
import py.com.progweb.prueba.ejb.ClienteDAO;
import py.com.progweb.prueba.model.Bolsa;
import py.com.progweb.prueba.model.Cliente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("bolsa")
@Consumes("application/json")
@Produces("application/json")
//@RequestScoped
public class BolsaRest {
    @Inject
    private BolsaDAO bolsaDAO;

    @Inject
    private ClienteDAO clienteDAO;

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

    @GET
    @Path("/cliente/{id}")
    public Response getByCliente( @PathParam("id") int id ){
        try {

            Cliente cliente = clienteDAO.get(id);
            List<Bolsa> lista = bolsaDAO.getBolsasPorCliente(cliente);
            return Response.ok( lista ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/rango/{li}/{ls}")
    public Response getByRango( @PathParam("li") int li, @PathParam("ls") int ls ){
        try {

            List<Bolsa> lista = bolsaDAO.getBolsasPorRango(li,ls);
            return Response.ok( lista ).build();

        }catch(Exception e){
            return Response.serverError().build();
        }
    }



}
