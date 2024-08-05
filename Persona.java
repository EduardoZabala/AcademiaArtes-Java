
package academiaartes;

import java.time.LocalDate;


public class Persona 
{
    protected String Identifi, nombre, apellidos, direcc, tel, cel, email;
    LocalDate fechIngreso;
    
    
    public Persona() {
    }

    public Persona(String Identifi, String nombre, String apellidos, String direcc, String tel, String cel, String email, LocalDate fechIngreso) {
        this.Identifi = Identifi;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direcc = direcc;
        this.tel = tel;
        this.cel = cel;
        this.email = email;
        this.fechIngreso = fechIngreso;
                
    }
 
    public void IngresarDatos(String Ident)
    {
        Identifi=Ident;
        nombre=Validaciones.LeerString("Ingrese nombre: ");
        apellidos=Validaciones.LeerString("Ingrese apellido: ");
        direcc=Validaciones.LeerString("Ingrese direccion: ");
        tel=Validaciones.LeerString("Ingrese telefono: ");
        cel=Validaciones.LeerString("Ingrese número de celular: ");
        email=Validaciones.LeerString("Ingrese email: ");
        fechIngreso=Validaciones.leerfecha("Ingrese fecha de ingreso: ");
   }
    
    /*este metodo nos sirve para la actualizacion de los estudiantes en todas las estructuras*/
    public Object Editar(Object dato)
    {
            //variables auxiliares para el cambio de informacion y asi permitirle al usuario arrepentirse de los cambios
               String id,nom, apell, dire, te, ce, ema;
               LocalDate fechI;
              
               int op;      
               Persona objE;
           //pasamos a las variables auxiliares locales los datos del estudiante
            id=((Persona)dato).getIdentifi();
            nom=((Persona)dato).getNombre();
            apell=((Persona)dato).getApellidos();
            dire=((Persona)dato).getDirecc();
            te=((Persona)dato).getTel();
            ce=((Persona)dato).getCel();
            ema=((Persona)dato).getEmail();
            fechI=((Persona)dato).getFechIngreso();
          
            do{//mientras para el menu
               op=Validaciones.LeerEntero("Menu Cambios\n"
                        +"\n1. Nombre "+nom
                        +"\n2. Apellido "+apell
                        +"\n3. Dirección "+dire
                        +"\n4. Telefono "+te
                        +"\n5. Celular "+ce
                        +"\n6. Email "+ema
                        +"\n7. Fecha de ingreso "+fechI
                        +"\n10. Terminar o salir");
               switch(op)
               {
                   case 1:nom=Validaciones.LeerString("Nombre: ");
                         break;
                   case 2:apell=Validaciones.LeerString("Apellidos: ");
                         break;
                   case 3:dire=Validaciones.LeerString("dirección: ");
                         break;
                   case 4:te=Validaciones.LeerString("Telefono: ");
                         break; 
                   case 5:ce=Validaciones.LeerString("Celular: ");
                         break;
                   case 6:ema=Validaciones.LeerString("Email: ");
                         break;
                   case 7:fechI=Validaciones.leerfecha("Fecha de ingreso: ");
                         break;
                  
                         
               }//fin caso
                
            }while(op<10);//fin mientras del menu
            //instanciamos un objeto para los nuevos datos
                objE=new Persona(id, nom,apell,dire,te,ce, ema,fechI);
            return objE;
    }//fin editar
       
    @Override
    public String toString() {
        return Identifi+" " + nombre + " " + apellidos+ " " + direcc + " " + tel + " "+ cel + " " + email + " " + fechIngreso+" " ;
    }
    
    /*public String EstructuraReg() {
        return Identifi+"," + nombre + "," + apellidos+ "," + direcc + "," + tel + ","+ cel + "," + email + "," + fechIngreso;
    }*/
    

    public String getIdentifi() {
        return Identifi;
    }

    public void setIdentifi(String Identifi) {
        this.Identifi = Identifi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechIngreso() {
        return fechIngreso;
    }

    public void setFechIngreso(LocalDate fechIngreso) {
        this.fechIngreso = fechIngreso;
    }

    
    
}
