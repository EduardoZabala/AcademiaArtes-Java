
package academiaartes;

import java.time.LocalDate;


public class Acudientes extends Persona
{

    public Acudientes() {
    }

    public Acudientes(String Identifi, String nombre, String apellidos, String direcc, String tel, String cel, String email, LocalDate fechIngreso) {
        super(Identifi, nombre, apellidos, direcc, tel, cel, email, fechIngreso);
    }

    public Acudientes EntrarDatos(String iden)
    {
        IngresarDatos(iden);
        Acudientes obja=new Acudientes(Identifi, nombre, apellidos, direcc, tel, cel, email, fechIngreso);
        return obja;
    }
    
    
    @Override
    public String toString() {
        return super.toString();
    }
    public String EstructuraReg() {
        return Identifi+"," + nombre + "," + apellidos+ "," + direcc + "," + tel + ","+ cel + "," + email + "," + fechIngreso;
    }
    
    
    
}
