package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Uso_puntos_cabecera;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class Uso_puntos_cabeceraDAO extends BaseDAO<Uso_puntos_cabecera> {

    public Uso_puntos_cabeceraDAO() {
        super(Uso_puntos_cabecera.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/



}

