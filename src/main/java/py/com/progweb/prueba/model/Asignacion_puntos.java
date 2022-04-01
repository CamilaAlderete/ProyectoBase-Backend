package py.com.progweb.prueba.model;

/*
create table asignacion_puntos(
	id_asignacion Serial Primary Key,
	limite_inferior Integer NOT NULL,
	limite_superior Integer NOT NULL,
	monto Integer NOT NULL
);
* */

import javax.persistence.*;

@Entity
@Table(name="asignacion_puntos")
public class Asignacion_puntos {

    @Id
    @Column(name = "id_asignacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Column(name = "limite_inferior")
    @Basic(optional = false)
    private Integer limite_inferior;


    @Column(name = "limite_superior")
    @Basic(optional = false)
    private Integer limite_superior;

    @Column(name = "monto")
    @Basic(optional = false)
    private Integer monto;

    public Asignacion_puntos() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLimite_inferior() {
        return limite_inferior;
    }

    public void setLimite_inferior(Integer limite_inferior) {
        this.limite_inferior = limite_inferior;
    }

    public Integer getLimite_superior() {
        return limite_superior;
    }

    public void setLimite_superior(Integer limite_superior) {
        this.limite_superior = limite_superior;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Asignacion_puntos{" +
                "id=" + id +
                ", limite_inferior=" + limite_inferior +
                ", limite_superior=" + limite_superior +
                ", monto=" + monto +
                '}';
    }
}
