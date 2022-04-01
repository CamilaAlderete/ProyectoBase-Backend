package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Concepto_puntos;

import javax.ejb.Stateless;


@Stateless
public class Concepto_puntosDAO extends BaseDAO<Concepto_puntos> {

    public Concepto_puntosDAO() {
        super(Concepto_puntos.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/

}