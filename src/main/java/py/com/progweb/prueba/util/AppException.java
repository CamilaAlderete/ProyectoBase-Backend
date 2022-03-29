//package py.com.progweb.prueba.util;
//
//import org.apache.commons.lang3.exception.ExceptionUtils;
//
//import javax.ws.rs.core.Response;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class AppException extends Exception{
//    //CodigoError codigoError;d
//    String mensajeError;
//    String mensajeErrorDetallado;
//    Response.Status codigoEstadoHTTP;
//    public static final Logger LOGGER = Logger.getLogger("conciliacion");
//
//    public AppException(String mensajeError) {
//        super(mensajeError);
//        this.mensajeError = mensajeError;
//        this.codigoEstadoHTTP= Response.Status.INTERNAL_SERVER_ERROR;
//    }
//    public AppException(String mensajeError, String mensajeErrorDetallado) {
//        super(mensajeError);
//        this.mensajeError = mensajeError;
//        this.mensajeErrorDetallado=mensajeErrorDetallado;
//        this.codigoEstadoHTTP= Response.Status.INTERNAL_SERVER_ERROR;
//    }
//    public AppException(String mensajeError,  Response.Status codigoEstadoHTTP) {
//        super(mensajeError);
//        this.mensajeError = mensajeError;
//        this.codigoEstadoHTTP= codigoEstadoHTTP;
//    }
//
//    public AppException(String mensajeError, String mensajeErrorDetallado, Response.Status codigoEstadoHTTP) {
//        super(mensajeError);
//        this.mensajeError = mensajeError;
//        this.mensajeError = mensajeErrorDetallado;
//        this.codigoEstadoHTTP= codigoEstadoHTTP;
//    }
//
//
//    public String getMensajeError() {
//        return mensajeError;
//    }
//
//    public void setMensajeError(String mensajeError) {
//        this.mensajeError = mensajeError;
//    }
//
//    public String getMensajeErrorDetallado() {
//        return mensajeErrorDetallado;
//    }
//
//    public void setMensajeErrorDetallado(String mensajeErrorDetallado) {
//        this.mensajeErrorDetallado = mensajeErrorDetallado;
//    }
//
//    public Response.Status getCodigoEstadoHTTP() {
//        return codigoEstadoHTTP;
//    }
//
//    public void setCodigoEstadoHTTP(Response.Status codigoEstadoHTTP) {
//        this.codigoEstadoHTTP = codigoEstadoHTTP;
//    }
//
//    public void toLog(Level level){
//        LOGGER.log(level,"Ocurrió un un un error en la ejecución.");
//        LOGGER.log(level,"Mensaje Error: "+this.getMensajeError());
//        LOGGER.log(level,"Detalle Error: "+this.getMensajeErrorDetallado());
//        LOGGER.log(level, ExceptionUtils.getStackTrace(this));
//    }
//    public void toLog(){
//        LOGGER.log(Level.SEVERE,"Ocurrió un un un error en la ejecución.");
//        LOGGER.log(Level.SEVERE,"Mensaje Error: "+this.getMensajeError());
//        LOGGER.log(Level.SEVERE,"Detalle Error: "+this.getMensajeErrorDetallado());
//        LOGGER.log(Level.SEVERE, ExceptionUtils.getStackTrace(this));
//    }
//    public void toLog(Level level, Long tipoOperacion,Long appRes, Long dbRes, Long respTotal){
//        LOGGER.log(level,"Mensaje Error: "+this.getMensajeError());
//        LOGGER.log(level,"Detalle Error: "+this.getMensajeErrorDetallado());
//        LoggerHandler.generarLog(level,tipoOperacion, appRes, dbRes, respTotal, this.getMensajeError());
//    }
//    public void toLog(Long tipoOperacion,Long appRes, Long dbRes, Long respTotal){
//        LOGGER.log(Level.SEVERE,"Mensaje Error: "+this.getMensajeError());
//        LOGGER.log(Level.SEVERE,"Detalle Error: "+this.getMensajeErrorDetallado());
//        LoggerHandler.generarLog(Level.SEVERE,tipoOperacion, appRes, dbRes, respTotal, this.getMensajeError());
//    }
//    public void toLog(Long appRes, Long dbRes, Long respTotal){
//        LOGGER.log(Level.SEVERE,"Mensaje Error: "+this.getMensajeError());
//        LOGGER.log(Level.SEVERE,"Detalle Error: "+this.getMensajeErrorDetallado());
//        LoggerHandler.generarLog(Level.SEVERE,LoggerHandler.TRANSACCION_ABORTADA, appRes, dbRes, respTotal, this.getMensajeError());
//    }
//    public void toLog(Level level, Long appRes, Long dbRes, Long respTotal){
//        LOGGER.log(level,"Mensaje Error: "+this.getMensajeError());
//        LOGGER.log(level,"Detalle Error: "+this.getMensajeErrorDetallado());
//        LoggerHandler.generarLog(level,this.getMensajeError());
//    }
//}
