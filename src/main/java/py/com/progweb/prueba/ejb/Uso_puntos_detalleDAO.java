package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Uso_puntos_detalle;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class Uso_puntos_detalleDAO extends BaseDAO<Uso_puntos_detalle> {

    public Uso_puntos_detalleDAO() {
        super(Uso_puntos_detalle.class);
    }

    /*aqui se agregan mas metodos en caso de necesitarlos*/


}

