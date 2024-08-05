
package academiaartes;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Pagos {
    private String NroRecibo,idEst;
    private LocalDate FechaPago;
    private double vlrPagado;

   //Constructor vacio
    public Pagos(){
    
    }
    
    //Constructor General
    public Pagos(String NroRecibo, String idEst, LocalDate FechaPago, double vlrPagado) {
        this.NroRecibo = NroRecibo;
        this.idEst = idEst;
        this.FechaPago = FechaPago;
        this.vlrPagado = vlrPagado;
    }//Fin Si
    
    public Pagos IngresarDatos(String id){
        NroRecibo=Validaciones.LeerString("Ingrese el Nro de recibo: ");
        idEst = id;
        FechaPago = Validaciones.leerfecha("Ingrese la fecha de pago: ");
        vlrPagado = Validaciones.LeerReal("Ingrese el valor pagado: ");
        Pagos objP = new Pagos(NroRecibo,idEst,FechaPago,vlrPagado);
        return objP;
    }//Fin IngresarDatos
    
    /*
    *Este metodo valida si el estudiante existe y su estado esta activo,
    *Si lo encuentra y el estudiante esta activo , retorna su objeto,
    *sino retorna el objeto en null
    */
    public Pagos IngresarPagos(String id){
        Archivos objArch = new Archivos();
        CRUDEstudiante objCRUDEst = new CRUDEstudiante();
        Pagos objP = new Pagos();
        if(objCRUDEst.Buscar(objArch, id)&& objCRUDEst.ConsultarEstado(objArch, id).equals("Activo")){
            objP=IngresarDatos(id);//Retorna el objeto 
        }else{
            JOptionPane.showMessageDialog(null,"El estudiante no existe");
            objP = null;//Retorna vacio sino lo encuentra
        }
        return objP;
    }
    @Override
    public String toString() {
        return "Pagos " + "NroRecibo=" + NroRecibo + ", idEst=" + idEst + ", FechaPago=" + FechaPago + ", vlrPagado=" + vlrPagado + '}';
    }
    public String EstructuraReg(){
        return NroRecibo +","+idEst+","+FechaPago+","+vlrPagado; 
    }
    
    public String getNroRecibo() {
        return NroRecibo;
    }

    public void setNroRecibo(String NroRecibos) {
        this.NroRecibo = NroRecibos;
    }

    public String getIdEst() {
        return idEst;
    }

    public void setIdEst(String idEst) {
        this.idEst = idEst;
    }

    public LocalDate getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(LocalDate FechaPago) {
        this.FechaPago = FechaPago;
    }

    public double getVlrPagado() {
        return vlrPagado;
    }

    public void setVlrPagado(double vlrPagado) {
        this.vlrPagado = vlrPagado;
    }
    
     
}//Fin Clase
