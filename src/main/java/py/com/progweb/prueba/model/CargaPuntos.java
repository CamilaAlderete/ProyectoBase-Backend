package py.com.progweb.prueba.model;

/*Clase que sirve para guardar temporalmente la informacion necesaria para crear una bolsa de puntos*/

public class CargaPuntos {

    private Integer idCliente;

    private Integer monto;

    private Integer diasDuracion;

    public CargaPuntos() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getDiasDuracion() {
        return diasDuracion;
    }

    public void setDiasDuracion(Integer diasDuracion) {
        this.diasDuracion = diasDuracion;
    }

    @Override
    public String toString() {
        return "CargaPuntos{" +
                "idCliente=" + idCliente +
                ", monto=" + monto +
                ", diasDuracion=" + diasDuracion +
                '}';
    }
}


























//
//
///*
//
//    table carga_puntos(
//        id Serial Primary Key,
//        id_cliente Integer NOT NULL,
//        monto Integer NOT NULL,
//        FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
//    );
//
//
//* */
//
//@Entity
//@Table(name = "bolsa_puntos")
//public class CargaPuntos {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    private Integer id;
//
//
//    @Column(name = "monto")
//    @Basic(optional = false)
//    private Integer monto;
//
//    @Column(name = "dias_duracion")
//    @Basic(optional = false)
//    private Integer diasDuracion;
//
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "id_cliente")
//    private Cliente cliente;
//
//
//    public CargaPuntos() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getMonto() {
//        return monto;
//    }
//
//    public void setMonto(Integer monto) {
//        this.monto = monto;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public Integer getDiasDuracion() {
//        return diasDuracion;
//    }
//
//    public void setDiasDuracion(Integer diasDuracion) {
//        this.diasDuracion = diasDuracion;
//    }
//
//    @Override
//    public String toString() {
//        return "CargaPuntos{" +
//                "id=" + id +
//                ", monto=" + monto +
//                ", diasDuracion=" + diasDuracion +
//                ", cliente=" + cliente +
//                '}';
//    }
//}
