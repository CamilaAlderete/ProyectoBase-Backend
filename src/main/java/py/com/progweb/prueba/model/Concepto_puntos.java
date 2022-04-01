package py.com.progweb.prueba.model;

/*
*
* create table concepto_puntos(
	id_concepto Serial Primary Key,
	descripcion Varchar (100) NOT NULL,
	puntos_requeridos Integer NOT NULL
);
* */

import javax.persistence.*;

@Entity
@Table(name="concepto_puntos")
public class Concepto_puntos {

    @Id
    @Column(name = "id_concepto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Column(name = "descripcion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private String descripcion;

    @Column(name = "puntos_requeridos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer puntos_requeridos;

    public Concepto_puntos() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntos_requeridos() {
        return puntos_requeridos;
    }

    public void setPuntos_requeridos(Integer puntos_requeridos) {
        this.puntos_requeridos = puntos_requeridos;
    }

    @Override
    public String toString() {
        return "Concepto_puntos{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", puntos_requeridos=" + puntos_requeridos +
                '}';
    }
}
