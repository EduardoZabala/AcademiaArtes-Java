
package academiaartes;

import java.time.LocalDate;


public class Estudiantes extends Persona
{
    private double PromGral;
    private String IdAcudiente, Estado;

    public Estudiantes() {
    }

    public Estudiantes(String Identifi, String nombre, String apellidos, String direcc, String tel, String cel, String email, LocalDate fechIngreso,double PromGral, String IdAcudiente, String Estado) {
        super(Identifi, nombre, apellidos, direcc, tel, cel, email, fechIngreso);
        this.PromGral = PromGral;
        this.IdAcudiente = IdAcudiente;
        this.Estado = Estado;
    }

    public Estudiantes EntrarDatos(String iden)
    {
        IngresarDatos(iden);
        PromGral=Validaciones.LeerNota("Ingrese promedio general del estudiante:");
        IdAcudiente=Validaciones.LeerString("ingrese identificacion del acudiente: ");//NOS FALTA ELABORAR VALIDACION
        Estado=Validaciones.LeerEstado();//nos falta hacer metodos
        Estudiantes obje=new Estudiantes(Identifi, nombre, apellidos, direcc, tel, cel, email, fechIngreso,PromGral,IdAcudiente,Estado);
        return obje;
    }
    
    @Override
    public String toString() {
        return "PromGral=" + PromGral + ", IdAcudiente=" + IdAcudiente + ", Estado=" + Estado +super.toString();
    }

    public String EstructuraReg() {
        return Identifi+"," + nombre + "," + apellidos+ "," + direcc + "," + tel + ","+ cel + "," + email + "," + fechIngreso+ ","+PromGral+","+IdAcudiente+","+Estado;
    }
    
    public double getPromGral() {
        return PromGral;
    }

    public void setPromGral(double PromGral) {
        this.PromGral = PromGral;
    }

    public String getIdAcudiente() {
        return IdAcudiente;
    }

    public void setIdAcudiente(String IdAcudiente) {
        this.IdAcudiente = IdAcudiente;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
    
}
