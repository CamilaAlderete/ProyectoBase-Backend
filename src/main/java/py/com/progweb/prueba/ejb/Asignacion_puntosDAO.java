package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Asignacion_puntos;

import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
public class Asignacion_puntosDAO extends BaseDAO<Asignacion_puntos> {

    public Asignacion_puntosDAO() {
        super(Asignacion_puntos.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/

    public Boolean verificar_solapamiento(Asignacion_puntos asignacion_puntos) throws Exception{

        Query q1 = this.em.createQuery("select ap from Asignacion_puntos  ap where :li between ap.limite_inferior and ap.limite_superior");
        Query q2= this.em.createQuery("select ap from Asignacion_puntos  ap where :ls between ap.limite_inferior and ap.limite_superior");

        q1.setParameter("li",asignacion_puntos.getLimite_inferior());
        q2.setParameter("ls",asignacion_puntos.getLimite_superior());

        //el limite inferior y superior no se solapan con otros existentes
        if (q1.getResultList().isEmpty() && q2.getResultList().isEmpty() ){
            return false;
        }

        //hay solapamiento
        return true;
    }

    public int puntaje_equivalente( int monto) throws Exception{

        try {

            Query query = this.em.createQuery("select ap.monto from Asignacion_puntos  ap where :monto between ap.limite_inferior and ap.limite_superior");
            query.setParameter("monto", monto);
            Integer monto_del_rango = (Integer) query.getSingleResult();
            return monto/monto_del_rango;

        }catch (Exception e){
            throw new Exception("Monto fuera del rango");
        }

    }

}