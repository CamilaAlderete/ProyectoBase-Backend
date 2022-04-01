package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Bolsa;

import javax.ejb.Stateless;


@Stateless
public class BolsaDAO extends BaseDAO<Bolsa> {

    public BolsaDAO() {
        super(Bolsa.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/

}

