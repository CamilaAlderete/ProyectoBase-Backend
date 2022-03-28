package py.com.progweb.prueba.model;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @Column(name="id_persona")
    @Basic(optional = false)
    @GeneratedValue(generator = "personaSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "personaSeq",sequenceName = "persona_seq", allocationSize = 0)
    private Integer id;

    @Column(name="nombre", length = 50)
    @Basic(optional = false)
    private String nombre;

    @Column(name="apellido", length = 50)
    @Basic(optional = false)
    private String apellido;

    public Persona() {
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
