package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Uso_puntos_cabecera;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;


@Stateless
public class Uso_puntos_cabeceraDAO extends BaseDAO<Uso_puntos_cabecera> {

    public Uso_puntos_cabeceraDAO() {
        super(Uso_puntos_cabecera.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/


    public List<Uso_puntos_cabecera> getUsoPuntosByConcepto(int idConcepto){

        String sql = "select u from Uso_puntos_cabecera u where u.conceptoPuntos.id = :id";
        Query query = getEm().createQuery(sql);
        query.setParameter("id", idConcepto);

        return (List<Uso_puntos_cabecera>) query.getResultList();

    }

    public List<Uso_puntos_cabecera> getUsoPuntosByFecha(String fechaString){

        Date fecha = Date.valueOf(fechaString);

        String sql = "select u from Uso_puntos_cabecera u where u.fecha = :fecha";
        Query query = getEm().createQuery(sql);
        query.setParameter("fecha", fecha);

        return (List<Uso_puntos_cabecera>) query.getResultList();

    }

    public List<Uso_puntos_cabecera> getUsoPuntosByCliente(int idCliente){


        String sql = "select u from Uso_puntos_cabecera u where u.cliente.idCliente = :id";
        Query query = getEm().createQuery(sql);
        query.setParameter("id", idCliente);

        return (List<Uso_puntos_cabecera>) query.getResultList();

    }



}

