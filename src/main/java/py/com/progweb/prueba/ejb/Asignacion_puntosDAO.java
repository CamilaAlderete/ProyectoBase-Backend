package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Asignacion_puntos;

import javax.ejb.Stateless;


@Stateless
public class Asignacion_puntosDAO extends BaseDAO<Asignacion_puntos> {

    public Asignacion_puntosDAO() {
        super(Asignacion_puntos.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/

}