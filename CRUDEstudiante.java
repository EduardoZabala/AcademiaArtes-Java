
package academiaartes;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;


public class CRUDEstudiante 
{
     /*Metodo que busca un codigo de estudiante en el archivo plano y si lo encuentra
    retorna verdadero, sino lo encuentra retorna falso*/
    public boolean Buscar(Archivos objArch, String id) {
        boolean sw = false;
        try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema,  IdA, Estad;
            double prom;
            LocalDate fechI;
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            objArch.AbrirArchivoModoLectura("Estudiante.txt");
            //se invoca al metodo de leer registro con 9 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(11);
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
                prom=Double.parseDouble(Reg[8]);
                IdA = Reg[9];
                Estad=Reg[10];
                //si el id del estudiante que extraimos del archivo en Reg es igual al id estudiante que se esta buscando
                if (Ident.equals(id)) 
                {
                    sw = true;
                }//fin si
                //se lee el otro registro para que termine secuencialmente la lectura del archivo texto
                Reg = objArch.LeerRegistro(11);
            }//fin mientras
            //cerramos el archivo plano de texto en modo lectura
            objArch.CerrarArchivoModoLectura();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }
        return sw;

    }//fin de buscar

    //--------------------------------------------------------------    
    /*metodo que a partir de un id o codigo de estudiante lo busca en el archivo y si no lo encuentra
     lo graba fisicamente con sus otros datos en el archivo y si lo encuentra muestra un mensaje 
     y no graba de nuevo estudiante porque estaría repetido*/
    public void IngresarEstudiante(Archivos objArch, String id) {
        Estudiantes objE = new Estudiantes();
        //se invoca el metodo buscar   
        if (Buscar(objArch, id) == false) {
            //se llama el metodo de ingresar datos de estudiante que recibe id y retorna el objeto estudiante  
            objE = objE.EntrarDatos(id);
            //se invoca el metodo que graba fisicamente en el archivo
            GrabarEstudiante(objArch, objE);
        } else {
            JOptionPane.showMessageDialog(null, "*****estudiante YA existe en el archivo*****");

        }

    }//fin de ingresar estudiante
    //metodo que graba fisicamente el registro en el archivo

    public void GrabarEstudiante(Archivos objArchivos, Estudiantes objE) {
        try {
            String cadena = "";
            objArchivos.AbrirArchivoModoEscritura("Estudiante.txt");
            /*con el objeto estudiante que llega se invoca el metodo para la estructura del registro
            separado por comas y se recibe en la cadena para grabarla en el archivo*/
            cadena = objE.EstructuraReg();
            //la cadena separada por comas se graba persistentemente en memoria
            objArchivos.EscribirRegistro("" + cadena);
            objArchivos.CerrarArchivoModoEscritura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "*****SE GRABA EN El ARCHIVO DE ESTUDIANTES*****");
        }

    }//fin de grabar estudiante

    //metodo que muestra todo el contenido del archivo
    public String MostrarTodo(Archivos objArch) {
        String cadena = "";
        try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema,  IdA, Estad;
            double prom;
            LocalDate fechI;
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Estudiante.txt"));
            //se invoca al metodo de leer registro con 6 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(11);
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
                prom=Double.parseDouble(Reg[8]);
                IdA = Reg[9];
                Estad=Reg[10];
                Estudiantes objE = new Estudiantes(Ident, nom, apell, dire, te, ce, ema, fechI,prom,IdA,Estad);
                cadena = cadena + objE.toString() + "\n";
                Reg = objArch.LeerRegistro(11);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
     }//fin de mostrar todo el archivo

   /*Clase CRUDEstudiantes
Publico cadena Consultar(Archivos objar, cadena id)
Cadena Reg, Texto=””
Si(Buscar(objar, id)=verdadero) entonces
objar.AbrirArchivoModoLectura(“Estudiantes.txt”)
Reg=objar.LeerRegistro()
Mientras (Reg<>null)
Si(Reg.obtenerIdentifi()=id)
	Texto=Reg.ImprimirDatos()
Fin si
	Reg=objar.LeerRegistro()
Fin mientras
objar.CerrarArchivoModoLectura(“Estudiantes.txt”)
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
            String Ident, nom, apell, dire, te, ce, ema,  IdA, Estad;
            double prom;
            LocalDate fechI;
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objar.AbrirArchivoModoLectura("Estudiante.txt"));
            //se invoca al metodo de leer registro con 6 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objar.LeerRegistro(11);
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
                prom=Double.parseDouble(Reg[8]);
                IdA = Reg[9];
                Estad=Reg[10];
                if(Ident.equals(id))//se encuentra el id en el registro
                {
                    Estudiantes objE = new Estudiantes(Ident, nom, apell, dire, te, ce, ema, fechI,prom,IdA,Estad);
                    Texto= objE.toString() ;//tomamos los datos del estudiante que buscamos
                }//fin si
                Reg = objar.LeerRegistro(11);
            }//fin mientras  
            objar.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
     }else{//No se encuentra
         JOptionPane.showMessageDialog(null,"Dato a consultar en el archivo NO existe");
     }//fin si
  return Texto;//retorna en blanco o el estudiante
 }//fin consultar
 
    /*Este metodo busca en el archivo por el id del estudiante
    y si lo encuentra retorna el estado y sino retorna vacio*/
   public String ConsultarEstado(Archivos objar,String id)   
    {
     String  Texto="";//variable locales para el retorno
     if(Buscar(objar, id)==true)//se encuentra el dato en el archivo
     {
         try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema,  IdA, Estad;
            double prom;
            LocalDate fechI;
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objar.AbrirArchivoModoLectura("Estudiante.txt"));
            //se invoca al metodo de leer registro con 6 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objar.LeerRegistro(11);
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
                prom=Double.parseDouble(Reg[8]);
                IdA = Reg[9];
                Estad=Reg[10];
                if(Ident.equals(id))//se encuentra el id en el registro
                {
                    Texto=Estad;//tomamos el estado del estudiante que buscamos
                }//fin si
                Reg = objar.LeerRegistro(11);
            }//fin mientras  
            objar.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
     }else{//No se encuentra
         JOptionPane.showMessageDialog(null,"Dato a consultar en el archivo NO existe");
     }//fin si
  return Texto;//retorna en blanco o el estado
 }//fin consultar estado
   
 //metodo que retorna el numero de registros del archivo
public int ContarRegistros(Archivos objArch) {
        int cont = 0;
        try {
            String Ident, nom, apell, dire, te, ce, ema,  IdA, Estad;
            double prom;
            LocalDate fechI;
            String Reg[];//para tomar la linea String como vector de datos y facilitar el trabajo con el registro
            //se abre el archivo modo lectura y se imprime el mensaje de apertura que retorna
            JOptionPane.showMessageDialog(null, "" + objArch.AbrirArchivoModoLectura("Estudiante.txt"));
            //se invoca al metodo de leer registro con 9 atributos para el vector de la linea o registro del archivo plano 
            //se recibe el texto en Reg
            Reg = objArch.LeerRegistro(11);
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
                prom = Double.parseDouble(Reg[8]);
                IdA = Reg[9];
                Estad=Reg[10];
                cont++;
                Reg = objArch.LeerRegistro(11);
            }
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leido y cerrado correctamente*****");
        }
        return cont;
    }//Fin Contar Registros
    /*Este metodo recibe un id del estudiante y crea una copia en una lista 
    *doble auxiliar,despues en la lista doble pasa su contenido al archivo 
    *sin el id del estudiante que recibe como parametro.
    */
    public void EliminarRegistro(Archivos objArc,String id){
        ListaDoble objLDAux = new ListaDoble();//ListaDoble auxliar
        ManejoListas objManLD = new ManejoListas();
        if(Buscar(objArc,id)==true){//Validacion de que el id del estudiante exista
            objManLD.CopiarArchivoListaD(objArc, objLDAux);//Crea la copia del archivo en la listaDoble
            objArc.BorrarContenido("Estudiante.txt");//Llama al metodo borrarContenido
            objLDAux.q=objLDAux.getStart();
            while(objLDAux.q!=null){//Mientras que llega Eof
                //Validacion
                if(!((Estudiantes)objLDAux.q.getDato()).getIdentifi().equals(id) ){
                    GrabarEstudiante(objArc,((Estudiantes)objLDAux.q.getDato()));
                }//Fin Si
                objLDAux.q=objLDAux.q.getSig();
            }//Fin Mientras
            objLDAux=null;//Libera los datos de la lista auxiliar
        }else{
            JOptionPane.showMessageDialog(null,"El dato no se encuentra en el archivo");
        }//Fin Si
    }//Fin EliminarRegistro

}//FIN CLASE CRUD


