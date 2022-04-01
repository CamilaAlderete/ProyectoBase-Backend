package py.com.progweb.prueba.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


/*

    table bolsa_puntos(
        id_bolsa Serial Primary Key,
        id_cliente Integer NOT NULL,
        fecha_asignacion date NOT NULL,
        fecha_caducidad date NOT NULL,
        puntajes_asignado Integer NOT NULL,
        puntaje_utilizado Integer NOT NULL,
        saldo_puntos Integer NOT NULL,
        monto Integer NOT NULL,
        FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
    );


* */

@Entity
@Table(name = "bolsa_puntos")
public class Bolsa {
    @Id
    @Column(name = "id_bolsa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Column(name = "fecha_asignacion")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date fechaAsignacion;

    @Column(name = "fecha_caducidad")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date fechaCaducidad;

    @Column(name = "puntajes_asignado")
    @Basic(optional = false)
    private Integer puntajeAsignado;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @Column(name = "saldo_puntos")
    @Basic(optional = false)
    private Integer saldoPuntos;

    @Column(name = "monto")
    @Basic(optional = false)
    private Integer monto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    public Bolsa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Integer getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public void setPuntajeAsignado(Integer puntajeAsignado) {
        this.puntajeAsignado = puntajeAsignado;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(Integer saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Bolsa{" +
                "id=" + id +
                ", fechaAsignacion=" + fechaAsignacion +
                ", fechaCaducidad=" + fechaCaducidad +
                ", puntajeAsignado=" + puntajeAsignado +
                ", puntajeUtilizado=" + puntajeUtilizado +
                ", saldoPuntos=" + saldoPuntos +
                ", monto=" + monto +
                ", cliente=" + cliente +
                '}';
    }
}
