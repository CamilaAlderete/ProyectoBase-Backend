package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Bolsa;
import py.com.progweb.prueba.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class BolsaDAO extends BaseDAO<Bolsa> {

    public BolsaDAO() {
        super(Bolsa.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/

    public List<Bolsa> getBolsasPorCliente(Cliente cliente){

        Query q = this.em.createQuery("select b from Bolsa b where b.cliente = :cliente order by  b.fechaAsignacion asc");
        q.setParameter("cliente",cliente);

        return (List<Bolsa>) q.getResultList();

    }

    //falta probar ********************************************
    public List<Bolsa> getBolsasPorRango( int limiteInferior, int limiteSuperior){

        Query q = this.em.createQuery("select b from Bolsa b where b.saldoPuntos between :li and :ls");
        q.setParameter("li",limiteInferior);
        q.setParameter("ls",limiteSuperior);

        return (List<Bolsa>) q.getResultList();

    }


}

