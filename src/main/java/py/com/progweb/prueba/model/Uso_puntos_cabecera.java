package py.com.progweb.prueba.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/*
 create table uso_puntos_cabecera(
	id_cabecera Serial Primary Key,
	id_cliente Integer NOT NULL,
	id_concepto Integer NOT NULL,
	puntaje_utilizado Integer NOT NULL,
	fecha date NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
	FOREIGN KEY(id_concepto) REFERENCES concepto_puntos (id_concepto)
);

* */
@Entity
@Table(name = "uso_puntos_cabecera")
public class Uso_puntos_cabecera {
    @Id
    @Column(name = "id_cabecera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCabecera;

    @JoinColumn(name = "id_cliente")
    @ManyToOne(optional=false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_concepto")
    private Concepto_puntos conceptoPuntos;

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

    public Uso_puntos_cabecera(Cliente cliente, Concepto_puntos conceptoPuntos, Integer puntajeUtilizado, Date fecha) {
        this.cliente = cliente;
        this.conceptoPuntos = conceptoPuntos;
        this.puntajeUtilizado = puntajeUtilizado;
        this.fecha = fecha;
    }

    public Integer getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(Integer idCabecera) {
        this.idCabecera = idCabecera;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Concepto_puntos getConceptoPuntos() {
        return conceptoPuntos;
    }

    public void setConceptoPuntos(Concepto_puntos conceptoPuntos) {
        this.conceptoPuntos = conceptoPuntos;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Uso_puntos_cabecera{" +
                "idCabecera=" + idCabecera +
                ", cliente=" + cliente +
                ", conceptoPuntos=" + conceptoPuntos +
                ", puntajeUtilizado=" + puntajeUtilizado +
                ", fecha=" + fecha +
                '}';
    }
}
