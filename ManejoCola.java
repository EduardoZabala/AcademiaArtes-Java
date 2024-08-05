
package academiaartes;

import java.time.LocalDate;
import javax.swing.JOptionPane;


public class ManejoCola 
{
    public Cola IngresarDato(Cola objC)
    {
        Estudiantes objE=new Estudiantes();
        int resp;//para confirmacion de ingreso de datos
        String id;
        resp=JOptionPane.showConfirmDialog(null,"Ingresar datos en cola?","Encolando",JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_OPTION)
        {
            id=Validaciones.LeerString("Ingrese el id del estudiante: ");
            objE=objE.EntrarDatos(id);//el dato que vamos a encolar
            objC.Push(objE);//se encola el estudiante ingresado
            resp=JOptionPane.showConfirmDialog(null,"Ingresar mas datos en cola?","Encolando",JOptionPane.YES_NO_OPTION);
         
        }//fin mientras
        return objC;
    }//fin ingresar datos
    
    /*este metodo recibe dos colas y la primera la encola o pasa todo a la segunda cola*/
    public void PasarCola(Cola c1,Cola c2)
    {
        while(c1.IsEmpty()==false)//mientras existan datos en c1
        {
            c2.Push(c1.Pop());//se desencola en c1 y se encola en c2
        }//fin mientras
    }//fin de pasar cola
    
    /*este metodo retorna en una cadena todos los datos de la cola*/
    public String Imprimir(Cola objc, Cola objca)
    {
        Object dato;//para usar el dato desencolado
        String texto=""; //variable local para el retorno
        while(objc.IsEmpty()==false)//mientras existan datos en objc
        {
            dato=objc.Pop();//desencolamos el dato y se guarda en la variable local
            texto=texto+dato.toString()+"\n";//colocamos el dato en la variable local del retorno
            objca.Push(dato);//lo encolamos en la cola auxiliar
        }//fin mientras
        PasarCola(objca,objc);//la cola que tiene los datos es la auxiliar, se coloca de primero y se pasa a la original
        return texto;
        
    }//fin imprimir
    
    public Cola EliminarDato(Cola c1, Cola c2, String id)
    {
        Object dato;//para usar el dato desencolado
        boolean sw=false; //variable local booleana para saber si se borra o no el dato
        while(c1.IsEmpty()==false)//mientras existan datos en c1
        { 
            dato=c1.Pop();//desencolamos el dato y se guarda en la variable local
            if(!((Estudiantes)dato).getIdentifi().equals(id))//si el id desencolado es diferente al buscado
                c2.Push(dato);//como es diferente se encola en la auxiliar
            else
                sw=true;//se cambia el sw para validar que si se elimina el dato, y NO se pasa a la cola auxiliar
            //fin si
        } //fin mientras
        PasarCola(c2,c1);//la cola que tiene los datos es la c2, se coloca de primero y se pasa a la original c1
        if(sw==false)
            JOptionPane.showMessageDialog(null,"Dato a eliminar NO se encuentra en la cola");
        else
            JOptionPane.showMessageDialog(null,"Dato se eliminar de la cola "+id);
        return c1;
    }//fin eliminar datos
    
    //metodo que copia todo el contenido del archivo a la pila
    public void CopiarArchivoCola(Archivos objArch, Cola objc) {
        
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
                objc.Push(objE);
                Reg = objArch.LeerRegistro(11);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        
     }//fin de copiar todo el archivo
    
    public Cola ActualizarDato(Cola c1, Cola c2, String id)
{
    Object dato,datoActualizado;//dato para desencolar
    Estudiantes obje=new Estudiantes();
    boolean sw=false; //booleano para saber si se encuentra o no el dato
    while(c1.IsEmpty()==false)//mientras cola tenga datos
    {
        dato=c1.Pop();//se desencola
        if(((Estudiantes)dato).getIdentifi().equals(id))//si se encuentra el id buscado
        {//pasamos a las variables auxiliares locales los datos del estudiante
            sw=true;//se prende el sw para validar que lo encuentra
            datoActualizado=obje.Editar(dato);
            int resp;//respuesta para validar los cambios
            resp=JOptionPane.showConfirmDialog(null,"Grabar cambios?","Actualizar estudiante",JOptionPane.YES_NO_OPTION);
            if(resp==JOptionPane.YES_OPTION)//si se actualiza
            {
                //se actualizan los datos de las variables auxiliares para el objeto
                dato=datoActualizado;
                JOptionPane.showMessageDialog(null,"Datos actualizados con éxito");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No se actualizaron los datos");
            }
            
        }//fin si
        c2.Push(dato);//se encola el dato en la cola auxiliar
    }//fin mientras
    PasarCola(c2,c1);
    if(sw==false)//no se encuentra
        JOptionPane.showMessageDialog(null,"Estudiante No se encuentra en la cola");
    return c1;
}//fin de actualizar
    
    /*este metodo nos retorna el numero de nodos que tiene la estructura cola
    es el equivalente al atributo privado size de la clase cola */
    public int ContarNodos(Cola c1, Cola c2)
    {
        int con=0;//variable local para el retorno
        while(c1.IsEmpty()==false)//mientra hay datos en c1
        {
            c2.Push(c1.Pop());//se desencola en c1 y se encola en c2
            con=con+1;//contamos el dato desencolado en c1
        }//fin mientras
        PasarCola(c2,c1);
        return con;
        
    }     //fin de contar nodos
    
    public boolean Buscar(Cola c1, Cola c2, String id)
    {
        Object dato;//para usar el dato desencolado
        boolean sw=false; //variable local booleana para saber si se borra o no el dato
        while(c1.IsEmpty()==false)//mientras existan datos en c1
        { 
            dato=c1.Pop();//desencolamos el dato y se guarda en la variable local
            if(((Estudiantes)dato).getIdentifi().equals(id))//si el id desencolado es igual al buscado
                sw=true;//se cambia el sw para validar que si se encuentra el dato
            c2.Push(dato);//se encola en la auxiliar para que no se pierda el dato
        } //fin mientras
        PasarCola(c2,c1);//la cola que tiene los datos es la c2, se coloca de primero y se pasa a la original c1
        
        return sw;
    }//fin buscar
    
}//fin clase manejo de cola
