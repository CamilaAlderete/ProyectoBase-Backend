package py.com.progweb.prueba.model;
import javax.persistence.*;

/*

 create table uso_puntos_detalle(
	id_detalle Serial Primary Key,
	id_cabecera Integer NOT NULL,
	id_bolsa Integer NOT NULL,
	puntaje_utilizado Integer NOT NULL,
	FOREIGN KEY (id_cabecera) REFERENCES uso_puntos_cabecera(id_cabecera),
	FOREIGN Key( id_bolsa) REFERENCES bolsa_puntos (id_bolsa)
 );


 */

@Entity
@Table(name = "uso_puntos_detalle")
public class Uso_puntos_detalle {
    @Id
    @Column(name = "id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idDetalle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cabecera", referencedColumnName = "id_cabecera")
    private Uso_puntos_cabecera usoPuntosCabecera;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_bolsa", referencedColumnName = "id_bolsa")
    private Bolsa bolsaPuntos;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private  Integer puntajeUtilizado;

    public Uso_puntos_detalle(){

    }

    public Uso_puntos_detalle(Uso_puntos_cabecera usoPuntosCabecera, Bolsa bolsaPuntos, Integer puntajeUtilizado) {
        this.usoPuntosCabecera = usoPuntosCabecera;
        this.bolsaPuntos = bolsaPuntos;
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Uso_puntos_cabecera getUsoPuntosCabecera() {
        return usoPuntosCabecera;
    }

    public void setUsoPuntosCabecera(Uso_puntos_cabecera usoPuntosCabecera) {
        this.usoPuntosCabecera = usoPuntosCabecera;
    }

    public Bolsa getBolsaPuntos() {
        return bolsaPuntos;
    }

    public void setBolsaPuntos(Bolsa bolsaPuntos) {
        this.bolsaPuntos = bolsaPuntos;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    @Override
    public String toString() {
        return "Uso_puntos_detalle{" +
                "idDetalle=" + idDetalle +
                ", usoPuntosCabecera=" + usoPuntosCabecera +
                ", bolsaPuntos=" + bolsaPuntos +
                ", puntajeUtilizado=" + puntajeUtilizado +
                '}';
    }
}
