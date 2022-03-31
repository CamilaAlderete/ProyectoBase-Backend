package py.com.progweb.prueba.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vencimiento_puntos")
public class Vencimiento_puntos {
    @Id
    @Column(name = "id_vencimiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idVencimiento;

    @Column(name = "fecha_inicio")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date fechaFin;

    @Column(name = "duracion")
    @Basic(optional = false)
    private Integer duracion;



    public Vencimiento_puntos(){

    }

    public void setIdVencimiento(Integer idVencimiento) {
        this.idVencimiento = idVencimiento;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fechaInicio = fecha_inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fechaFin = fecha_fin;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getIdVencimiento() {
        return idVencimiento;
    }

    public Date getFecha_inicio() {
        return fechaInicio;
    }

    public Date getFecha_fin() {
        return fechaFin;
    }

    public Integer getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Vencimiento_puntos{" +
                "idVencimiento=" + idVencimiento +
                ", fecha_inicio=" + fechaInicio +
                ", fecha_fin=" + fechaFin +
                ", duracion=" + duracion +
                '}';
    }
}
