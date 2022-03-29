package py.com.progweb.prueba.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCliente;

    @Column(name = "nombre",length =100)
    @Basic(optional = false)
    private String nombre;

    @Column(name = "apellido",length =100)
    @Basic(optional = false)
    private String apellido;

    @Column(name = "numero_documento", unique = true)
    @Basic(optional = false)
    private Integer ci;

    @Column(name = "tipo_documento",length =100)
    @Basic(optional = false)
    private String tipoDocumento;

    @Column(name = "nacionalidad",length =100)
    @Basic(optional = false)
    private String nacionalidad;

    @Column(name = "email",length =100)
    @Basic(optional = false)
    private  String email;

    @Column(name = "telefono")
    @Basic(optional = true)
    private  Integer telefono;

    @Column(name = "fecha_nacimiento")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date fechaNacimiento;

    public  Cliente(){

    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getCi() {
        return ci;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ci=" + ci +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
