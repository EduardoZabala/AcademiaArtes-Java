
package academiaartes;

import java.time.LocalDate;
import javax.swing.JOptionPane;


public class CRUDProfesor 
{
     /*Metodo que busca un codigo de profesor en el archivo plano y si lo encuentra
    retorna verdadero, sino lo encuentra retorna falso*/
    public boolean Buscar(Archivos objArch, String id) {
        boolean sw = false;
        try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema;
            LocalDate fechI;
           
            
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            objArch.AbrirArchivoModoLectura("Profesores.txt");
            //se invoca al metodo de leer registro con 8 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(8);
            //mientras existan datos en el archivo
            while (Reg != null) //mientras not EOF()
            {
                /*los datos del Reg que se obtiene del archivo plano de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                Ident = Reg[0];
                nom = Reg[1];
                apell = Reg[2];
                dire = Reg[3];
                te = Reg[4];
                ce = Reg[5];
                ema = Reg[6];
                fechI = LocalDate.parse(Reg[7]);
                
                //si el id del profesor que extraimos del archivo en Reg es igual al id profesor que se esta buscando
                if (Ident.equals(id)) 
                {
                    sw = true;
                }//fin si
                //se lee el otro registro para que termine secuencialmente la lectura del archivo texto
                Reg = objArch.LeerRegistro(8);
            }//fin mientras
            //cerramos el archivo plano de texto en modo lectura
            objArch.CerrarArchivoModoLectura();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }
        return sw;

    }//fin de buscar

    //--------------------------------------------------------------    
    /*metodo que a partir de un id o codigo de profesor lo busca en el archivo y si no lo encuentra
     lo graba fisicamente con sus otros datos en el archivo y si lo encuentra muestra un mensaje 
     y no graba de nuevo profesor porque estaría repetido*/
    public void IngresarProfesores(Archivos objArch, String id) {
        Profesores objP = new Profesores();
        //se invoca el metodo buscar   
        if (Buscar(objArch, id) == false) {
            //se llama el metodo de ingresar datos de profesor que recibe id y retorna el objeto mascota  
            objP = objP.EntrarDatos(id);
            //se invoca el metodo que graba fisicamente en el archivo
            GrabarProfesores(objArch, objP);
        } else {
            JOptionPane.showMessageDialog(null, "*****profesor YA existe en el archivo*****");

        }

    }//fin de ingresar profesor
    //metodo que graba fisicamente el registro en el archivo

    public void GrabarProfesores(Archivos objArchivos, Profesores objP) {
        try {
            String cadena = "";
            objArchivos.AbrirArchivoModoEscritura("Profesores.txt");
            /*con el objeto profesor que llega se invoca el metodo para la estructura del registro
            separado por comas y se recibe en la cadena para grabarla en el archivo*/
            cadena = objP.EstructuraReg();
            //la cadena separada por comas se graba persistentemente en memoria
            objArchivos.EscribirRegistro("" + cadena);
            objArchivos.CerrarArchivoModoEscritura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "*****SE GRABA EN El ARCHIVO DE PROFESORES*****");
        }

    }//fin de grabar profesor

    //metodo que muestra todo el contenido del archivo
    public String MostrarTodo(Archivos objArch) {
        
        //Archivos objArch=new Archivos();
                
        String cadena = "";
        try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema;
            LocalDate fechI;
           
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Profesores.txt"));
            //se invoca al metodo de leer registro con 8 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(8);
            //mientras existan datos en el archivo
            while (Reg!=null) //mientras not EOF()
            {
               /*los datos del Reg que se obtiene del archivo plano de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                //Reg = objArch.LeerRegistro(8);
                Ident = Reg[0];
                nom = Reg[1];
                apell = Reg[2];
                dire = Reg[3];
                te = Reg[4];
                ce = Reg[5];
                ema = Reg[6];
                fechI = LocalDate.parse(Reg[7]);
                
                Profesores objP = new Profesores(Ident, nom, apell, dire, te, ce, ema, fechI);
                cadena = cadena + objP.toString() + "\n";
                                
                Reg = objArch.LeerRegistro(8);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
     }//fin de mostrar todo el archivo

   /*Clase CRUDProfesores
Publico cadena Consultar(Archivos objar, cadena id)
Cadena Reg, Texto=””
Si(Buscar(objar, id)=verdadero) entonces
objar.AbrirArchivoModoLectura(“Profesores.txt”)
Reg=objar.LeerRegistro()
Mientras (Reg<>null)
Si(Reg.obtenerIdentifi()=id)
	Texto=Reg.ImprimirDatos()
Fin si
	Reg=objar.LeerRegistro()
Fin mientras
objar.CerrarArchivoModoLectura(“Profesores.txt”)
sino
Imprimir “Dato a consultar en el archivo NO existe”
Fin si
Retornar texto
Fin consultar
*/
    
 public String Consultar(Archivos objar,String id)   
 {
     String  Texto="";//variable locales para el retorno
     if(Buscar(objar, id)==true)//se encuentra el dato en el archivo
     {
         try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema;
            LocalDate fechI;
            
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objar.AbrirArchivoModoLectura("Profesores.txt"));
            //se invoca al metodo de leer registro con 6 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objar.LeerRegistro(8);
            //mientras existan datos en el archivo
            while (Reg != null) //mientras not EOF()
            {
               /*los datos del Reg que se obtiene del archivo plano de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                Ident = Reg[0];
                nom = Reg[1];
                apell = Reg[2];
                dire = Reg[3];
                te = Reg[4];
                ce = Reg[5];
                ema = Reg[6];
                fechI = LocalDate.parse(Reg[7]);
               
                if(Ident.equals(id))//se encuentra el id en el registro
                {
                    Profesores objP = new Profesores(Ident, nom, apell, dire, te, ce, ema, fechI);
                    Texto= objP.toString() ;//tomamos los datos del profesor que buscamos
                }//fin si
                Reg = objar.LeerRegistro(8);
            }//fin mientras  
            objar.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
     }else{//No se encuentra
         JOptionPane.showMessageDialog(null,"Dato a consultar en el archivo NO existe");
     }//fin si
  return Texto;//retorna en blanco o el profesor
 }//fin consultar
 
 //metodo que retorna el numero de registros del archivo
public int ContarRegistros(Archivos objArch) {
        int cont = 0;
        try {
            String Ident, nom, apell, dire, te, ce, ema;
            LocalDate fechI;
          
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Profesores.txt"));
            //se invoca al metodo de leer registro con 9 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(8);
            //mientras existan datos en el archivo
            while (Reg != null) //mientras not EOF()
            {
                /*los datos del Reg que se obtiene del archivo plano de texto se 
                asignan a las variables auxiliares locales para su facil manejo 
                como posiciones del vector String*/
                Ident = Reg[0];
                nom = Reg[1];
                apell = Reg[2];
                dire = Reg[3];
                te = Reg[4];
                ce = Reg[5];
                ema = Reg[6];
                fechI = LocalDate.parse(Reg[7]);
               
                cont++;
                Reg = objArch.LeerRegistro(8);
            }
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }
        return cont;
    }

    
    
    
    
}//fin curd de profesor
