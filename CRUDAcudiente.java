
package academiaartes;

import java.time.LocalDate;
import javax.swing.JOptionPane;


public class CRUDAcudiente 
{
    /*Metodo que busca un codigo de Acudiente en el archivo plano y si lo encuentra
    retorna verdadero, sino lo encuentra retorna falso*/
    public boolean Buscar(Archivos objArch, String id) {
        boolean sw = false;
        try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema;
            LocalDate fechI;
           
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            objArch.AbrirArchivoModoLectura("Acudiente.txt");
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
                fechI =LocalDate.parse(Reg[7]);
              
                //si el id del Acudiente que extraimos del archivo en Reg es igual al id Acudiente que se esta buscando
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
    /*metodo que a partir de un id o codigo de Acudiente lo busca en el archivo y si no lo encuentra
     lo graba fisicamente con sus otros datos en el archivo y si lo encuentra muestra un mensaje 
     y no graba de nuevo Acudiente porque estaría repetido*/
    public void IngresarAcudiente(Archivos objArch, String id) {
        Acudientes objA = new Acudientes();
        //se invoca el metodo buscar   
        if (Buscar(objArch, id) == false) {
            //se llama el metodo de ingresar datos de Acudiente que recibe id y retorna el objeto Acudiente  
            objA = objA.EntrarDatos(id);
            //se invoca el metodo que graba fisicamente en el archivo
            GrabarAcudiente(objArch, objA);
        } else {
            JOptionPane.showMessageDialog(null, "*****Acudiente YA existe en el archivo*****");

        }

    }//fin de ingresar Acudiente
    //metodo que graba fisicamente el registro en el archivo

    public void GrabarAcudiente(Archivos objArchivos, Acudientes objE) {
        try {
            String cadena = "";
            objArchivos.AbrirArchivoModoEscritura("Acudiente.txt");
            /*con el objeto Acudiente que llega se invoca el metodo para la estructura del registro
            separado por comas y se recibe en la cadena para grabarla en el archivo*/
            cadena = objE.EstructuraReg();
            //la cadena separada por comas se graba persistentemente en memoria
            objArchivos.EscribirRegistro("" + cadena);
            objArchivos.CerrarArchivoModoEscritura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "*****SE GRABA EN El ARCHIVO DE ACUDIENTES*****");
        }

    }//fin de grabar Acudiente

    //metodo que muestra todo el contenido del archivo
    public String MostrarTodo(Archivos objArch) {
        String cadena = "";
        try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema;
            LocalDate fechI;
           
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Acudiente.txt"));
            //se invoca al metodo de leer registro con 6 atributos para el vector de la linea o registro del archivo plano 
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
                fechI =LocalDate.parse(Reg[7]);
               
                Acudientes objA = new Acudientes(Ident, nom, apell, dire, te, ce, ema, fechI);
                cadena = cadena + objA.toString() + "\n";
                Reg = objArch.LeerRegistro(8);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
     }//fin de mostrar todo el archivo

   /*Clase CRUDAcudientes
Publico cadena Consultar(Archivos objar, cadena id)
Cadena Reg, Texto=””
Si(Buscar(objar, id)=verdadero) entonces
objar.AbrirArchivoModoLectura(“Acudientes.txt”)
Reg=objar.LeerRegistro()
Mientras (Reg<>null)
Si(Reg.obtenerIdentifi()=id)
	Texto=Reg.ImprimirDatos()
Fin si
	Reg=objar.LeerRegistro()
Fin mientras
objar.CerrarArchivoModoLectura(“Acudientes.txt”)
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
            JOptionPane.showMessageDialog(null, "" + objar.AbrirArchivoModoLectura("Acudiente.txt"));
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
                fechI =LocalDate.parse(Reg[7]);
              
                if(Ident.equals(id))//se encuentra el id en el registro
                {
                    Acudientes objA = new Acudientes(Ident, nom, apell, dire, te, ce, ema, fechI);
                    Texto= objA.toString() ;//tomamos los datos del Acudiente que buscamos
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
  return Texto;//retorna en blanco o el Acudiente
 }//fin consultar
 
 //metodo que retorna el numero de registros del archivo
public int ContarRegistros(Archivos objArch) {
        int cont = 0;
        try {
            String Ident, nom, apell, dire, te, ce, ema;
            LocalDate fechI;
            
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Acudiente.txt"));
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
                fechI =LocalDate.parse(Reg[7]);
              
                cont++;
                Reg = objArch.LeerRegistro(8);
            }
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }
        return cont;
    }

    
}
