package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.sql.Date;
import java.util.Calendar;
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
            String sql = "select c from Cliente c where LOWER(c.nombre) like LOWER( :nombre )";
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
            String sql = "select c from Cliente c where LOWER(c.apellido) like LOWER(:apellido)";
            Query query = getEm().createQuery(sql);
            query.setParameter("apellido", apellido);
            List<Cliente> lista = query.getResultList();

            return lista;

        }catch (Exception e){
            throw new Exception("Ocurrió un error al ejecutar la consulta en la BD.");
        }


    }

    public List<Cliente> getClienteByCumple(String fechaStr) throws Exception {

        try {

            Date fecha = Date.valueOf(fechaStr);

            String sql = "select c from Cliente c where c.fechaNacimiento = :fecha";
            Query query = getEm().createQuery(sql);
            query.setParameter("fecha", fecha);

            List<Cliente> lista = query.getResultList();

            return lista;

        }catch (Exception e){
            throw new Exception("Ocurrió un error al ejecutar la consulta en la BD.");
        }


    }

    public List<Cliente> getClientesPuntosPorVencer( int dias){

        //hoy
        java.util.Date hoy = new java.util.Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hoy);
        calendar.add(Calendar.DATE, dias );

        //hoy + nro de dias
        java.util.Date fechaCaducidad = calendar.getTime();

        Query q = this.em.createQuery("select b.cliente from Bolsa b where b.fechaCaducidad = :fechaCaducidad");
        q.setParameter("fechaCaducidad",fechaCaducidad);

        return (List<Cliente>) q.getResultList();

    }





}

