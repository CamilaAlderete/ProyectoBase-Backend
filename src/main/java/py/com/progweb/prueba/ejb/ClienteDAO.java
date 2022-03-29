package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class ClienteDAO extends BaseDAO<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/

    public List<Cliente> getClienteByNombre(String nombre) throws Exception {

        try {

            nombre = nombre + "%";
            String sql = "select c from Cliente c where LOWER(c.nombre) like :nombre";
            Query query = getEm().createQuery(sql);
            query.setParameter("nombre", nombre);
            List<Cliente> lista = query.getResultList();

            return lista;

        }catch (Exception e){
            throw new Exception("Ocurrió un error al ejecutar la consulta en la BD.");
        }


    }

    public List<Cliente> getClienteByApellido(String apellido) throws Exception {

        try {

            apellido = apellido + "%";
            String sql = "select c from Cliente c where LOWER(c.apellido) like :apellido";
            Query query = getEm().createQuery(sql);
            query.setParameter("apellido", apellido);
            List<Cliente> lista = query.getResultList();

            return lista;

        }catch (Exception e){
            throw new Exception("Ocurrió un error al ejecutar la consulta en la BD.");
        }


    }



}

