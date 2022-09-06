package py.com.progweb.prueba.ejb;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

@Singleton
public class BolsaScheduler {

    @Inject
    BolsaDAO bolsaDAO;

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    //@Schedule(dayOfWeek="*" ,hour = "*/1",persistent = false)
    @Schedule(hour = "*",minute = "*/5",persistent = false)

    public  void updateBolsaPuntos(){

        Date hoy= new Date();

        Query q= this.em.createQuery("update Bolsa b SET b.saldoPuntos=0 where b.fechaCaducidad < :hoy");
        q.setParameter("hoy",hoy).executeUpdate();

    }
}