
package academiaartes;

import java.time.LocalDate;

public class Profesores extends Persona
{

    public Profesores() {
    }

    public Profesores(String Identifi, String nombre, String apellidos, String direcc, String tel, String cel, String email, LocalDate fechIngreso) {
        super(Identifi, nombre, apellidos, direcc, tel, cel, email, fechIngreso);
    }
    
    public Profesores EntrarDatos(String iden)
    {
        IngresarDatos(iden);
        Profesores objp=new Profesores(Identifi, nombre, apellidos, direcc, tel, cel, email, fechIngreso);
        return objp;
    }
    

    @Override
    public String toString() {
        return super.toString();
    }
    
    public String EstructuraReg() {
        return Identifi+"," + nombre + "," + apellidos+ "," + direcc + "," + tel + ","+ cel + "," + email + "," + fechIngreso;
    }
    
    
}
