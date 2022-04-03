//package py.com.progweb.prueba.ejb;
//
//import py.com.progweb.prueba.model.Bolsa;
//import py.com.progweb.prueba.model.CargaPuntos;
//
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
//@Stateless
//public class OperacionesPuntosDAO {
//
//    @Inject BolsaDAO bolsaDAO;
//
//    public OperacionesPuntosDAO() {
//
//    }
//
//    public void asignarPuntos(CargaPuntos cargaPuntos){
//
//        int monto = cargaPuntos.getMonto();
//        int puntos = 0;
//
//        //puntos de acuerdo al monto
//        if ( monto >= 0 && monto <=199999){
//            puntos = monto / 50000;
//        }else if( monto >= 200000 && monto <=499999 ){
//            puntos = monto / 30000;
//        }else if ( monto >= 500000){
//            puntos = monto / 20000;
//        }
//
//        //fecha de hoy
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(new Date());
//
//
//        Bolsa bolsa = new Bolsa();
//
//
//
//    }
//
//
//}
//
