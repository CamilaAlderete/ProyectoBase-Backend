package py.com.progweb.prueba.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/*
    Clase generica con metodos para guardar, modificar, eliminar y listar objetos.
*/
public class BaseDAO<T> {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;
    private Class<T> tipoClase;

    public BaseDAO(Class<T> tipoClase) {
        this.tipoClase = tipoClase;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class<T> getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(Class<T> tipoClase) {
        this.tipoClase = tipoClase;
    }

    public EntityManager getEm() {
        return em;
    }

    public T get(Object id) throws Exception {
        try {
            return getEm().find(tipoClase, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Hubo un error al buscar el objeto.");
        }
    }

    public void persist(T entity) throws Exception {
        try {
            getEm().persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Hubo un error al guardar el objeto.");
        }
    }

    public T merge(T entity) throws Exception {
        try {
            return getEm().merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Hubo un error al modificar el objeto.");
        }
    }

    public void delete(Object id) throws Exception {
        try {
            T entity = this.get(id);
            this.getEm().remove(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Hubo un error al eliminar objeto");
        }
    }

    public List<T> getAll() throws Exception {

        try{
            Query query = getEm().createQuery("from " + tipoClase.getName());
            return (List<T>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Hubo un error al obtener la lista");
        }

    }

    /*public List<T> getAll(Class<T> entityClass) throws Exception {

        try{
            Query query = getEm().createQuery("from " + entityClass.getName());
            return (List<T>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Hubo un error al obtener la lista");
        }

    }*/


}