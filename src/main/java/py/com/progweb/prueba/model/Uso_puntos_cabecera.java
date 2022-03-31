package py.com.progweb.prueba.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "uso_puntos_cabecera")
public class Uso_puntos_cabecera {
    @Id
    @Column(name = "id_cabecera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCabecera;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional=false)
    private Cliente cliente;

    //SOLE DEBE CREAR EL MODELO Y DEMAS DE CONCEPTO_PUNTOS...

   // @JoinColumn(name = "id_concepto", referencedColumnName = "id_concepto")
   // @ManyToOne(optional=false)
   // private Concepto_puntos conceptoPuntos;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private  Integer puntajeUtilizado;

    @Column(name = "fecha")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date fecha;



    public Uso_puntos_cabecera(){

    }

    public void setIdCabecera(Integer idCabecera) {
        this.idCabecera = idCabecera;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

 //   public void setConceptoPuntos(Concepto_puntos concepto) { this.conceptoPuntos = concepto; }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdCabecera() {
        return idCabecera;
    }

    public Cliente getCliente() {
        return cliente;
    }

//   public void getConceptoPuntos() { return conceptoPuntos; }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Uso_puntos_cabecera{" +
                "idCabecera=" + idCabecera +
                ", cliente=" + cliente +
                ", puntajeUtilizado=" + puntajeUtilizado +
                ", fecha=" + fecha +
                '}';
    }
}
