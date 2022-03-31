package py.com.progweb.prueba.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

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

   // @ManyToOne(optional = false)
   // @JoinColumn(name = "id_bolsa", referencedColumnName = "id_bolsa")
   // private Bolsa_puntos bolsaPuntos;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private  Integer puntajeUtilizado;

    public Uso_puntos_detalle(){

    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public void setUsoPuntosCabecera(Uso_puntos_cabecera usoPuntosCabecera) {
        this.usoPuntosCabecera = usoPuntosCabecera;
    }

  //  public void setbolsaPuntos(Bolsa_Puntos bolsa) {
  //      this.bolsaPuntos = bolsa;
  //  }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public Uso_puntos_cabecera getUsoPuntosCabecera() {
        return usoPuntosCabecera;
    }

    //  public void getbolsaPuntos() {
    //      return bolsaPuntos;
    //  }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    @Override
    public String toString() {
        return "Uso_puntos_detalle{" +
                "idDetalle=" + idDetalle +
                ", usoPuntosCabecera=" + usoPuntosCabecera +
                ", puntajeUtilizado=" + puntajeUtilizado +
                '}';
    }
}
