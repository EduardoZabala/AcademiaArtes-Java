

package academiaartes;

import java.time.LocalDate;
import javax.swing.JOptionPane;


public class ManejoPila 
{
    
    public Pila IngresarDato(Pila objP)
    {
        Estudiantes objE=new Estudiantes();
        int resp;//para confirmacion de ingreso de datos
        String id;
        resp=JOptionPane.showConfirmDialog(null,"Ingresar datos en pila?","Apilando",JOptionPane.YES_NO_OPTION);
        while(resp==JOptionPane.YES_OPTION)
        {
            id=Validaciones.LeerString("Ingrese el id del estudiante: ");
            objE=objE.EntrarDatos(id);//el dato que vamos a apilar
            objP.Push(objE);//se apila el estudiante ingresado
            resp=JOptionPane.showConfirmDialog(null,"Ingresar mas datos en pila?","Apilando",JOptionPane.YES_NO_OPTION);
         
        }//fin mientras
        return objP;
    }//fin ingresar datos
    
    /*este metodo recibe dos pilas y la primera la apila o pasa todo a la segunda pila*/
    public void PasarPila(Pila p1,Pila p2)
    {
        while(p1.IsEmpty()==false)//mientras existan datos en p1
        {
            p2.Push(p1.Pop());//se desapila en p1 y se apila en p2
        }//fin mientras
    }//fin de pasar pila
    
    /*este metodo retorna en una cadena todos los datos de la pila*/
    public String Imprimir(Pila objp, Pila objpa)
    {
        Object dato;//para usar el dato desapilado
        String texto=""; //variable local para el retorno
        while(objp.IsEmpty()==false)//mientras existan datos en objp
        {
            dato=objp.Pop();//desapilamos el dato y se guarda en la variable local
            texto=texto+dato.toString()+"\n";//colocamos el dato en la variable local del retorno
            objpa.Push(dato);//lo apilamos en la pila auxiliar
        }//fin mientras
        PasarPila(objpa,objp);//la pila que tiene los datos es la auxiliar, se coloca de primero y se pasa a la original
        return texto;
        
    }//fin imprimir
    
    public Pila EliminarDato(Pila p1, Pila p2, String id)
    {
        Object dato;//para usar el dato desapilado
        boolean sw=false; //variable local booleana para saber si se borra o no el dato
        while(p1.IsEmpty()==false)//mientras existan datos en p1
        { 
            dato=p1.Pop();//desapilamos el dato y se guarda en la variable local
            if(!((Estudiantes)dato).getIdentifi().equals(id))//si el id desapilado es diferente al buscado
                p2.Push(dato);//como es diferente se apila en la auxiliar
            else
                sw=true;//se cambia el sw para validar que si se elimina el dato, y NO se pasa a la pila auxiliar
            //fin si
        } //fin mientras
        PasarPila(p2,p1);//la pila que tiene los datos es la p2, se coloca de primero y se pasa a la original p1
        if(sw==false)
            JOptionPane.showMessageDialog(null,"Dato a eliminar NO se encuentra en la pila");
        else
            JOptionPane.showMessageDialog(null,"Dato se eliminar de la pila "+id);
        return p1;
    }//fin eliminar datos
    
    //metodo que copia todo el contenido del archivo a la pila
    public void CopiarArchivoPila(Archivos objArch, Pila objp) {
        
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
                fechI = LocalDate.parse(Reg[7]);
                prom=Double.parseDouble(Reg[8]);
                IdA = Reg[9];
                Estad = Reg[10];
                Estudiantes objE = new Estudiantes(Ident, nom, apell, dire, te, ce, ema, fechI,prom,IdA,Estad);
                objp.Push(objE);
                Reg = objArch.LeerRegistro(11);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        
     }//fin de copiar todo el archivo
public Pila ActualizarDato(Pila p1, Pila p2, String id)
{
    Object dato,datoActualizado;//dato para desapilar
    Estudiantes obje=new Estudiantes();
    boolean sw=false; //booleano para saber si se encuentra o no el dato
    while(p1.IsEmpty()==false)//mientras pila tenga datos
    {
        dato=p1.Pop();//se desapila
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
        p2.Push(dato);//se apila el dato en la pila auxiliar
    }//fin mientras
    PasarPila(p2,p1);
    if(sw==false)
        JOptionPane.showMessageDialog(null,"Estudiante No se encuentra en la pila");
    return p1;
}//fin de actualizar
   
 /*este metodo nos retorna el numero de nodos que tiene la estructura pila
    es el equivalente al atributo privado size de la clase pila */
    public int ContarNodos(Pila p1, Pila p2)
    {
        int con=0;//variable local para el retorno
        while(p1.IsEmpty()==false)//mientra hay datos en p1
        {
            p2.Push(p1.Pop());//se desapila en p1 y se apila en p2
            con=con+1;//contamos el dato desapilado en p1
        }//fin mientras
        PasarPila(p2,p1);
        return con;
        
    }     //fin de contar nodos
    
    public boolean Buscar(Pila p1, Pila p2, String id)
    {
        Object dato;//para usar el dato desapilado
        boolean sw=false; //variable local booleana para saber si se borra o no el dato
        while(p1.IsEmpty()==false)//mientras existan datos en p1
        { 
            dato=p1.Pop();//desapilamos el dato y se guarda en la variable local
            if(((Estudiantes)dato).getIdentifi().equals(id))//si el id desapilado es igual al buscado
                sw=true;//se cambia el sw para validar que si se encuentra el dato
            p2.Push(dato);//se apila en la auxiliar para que no se pierda el dato
        } //fin mientras
        PasarPila(p2,p1);//la pila que tiene los datos es la p2, se coloca de primero y se pasa a la original p1
        
        return sw;
    }//fin buscar
    
    
   
    
}//fin clase manejo de pila
