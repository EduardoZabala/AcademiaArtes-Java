
package academiaartes;

import java.time.LocalDate;
import javax.swing.JOptionPane;


public class ManejoListas 
{
    /*este metodo ingresa varios datos en la lista simple
    por el inicio o por el final, mientras que el usuario quiera,
    la opcion 1 esta ingresando por el inicio, de lo contrario
    se esta ingresando por el final*/
 public ListaSimple IngresarDatos(ListaSimple objl,int op)   
 {
     int resp;
     String id;
     Estudiantes objE;
     resp=JOptionPane.showConfirmDialog(null,"Ingresar datos?","Lista simple",JOptionPane.YES_NO_OPTION);
     while(resp==JOptionPane.YES_OPTION)
     {
         id=Validaciones.LeerString("Identificación del estudiante: ");
         objE=new Estudiantes();
         objE=objE.EntrarDatos(id);
         if(op==1)//creando por el inicio
             objl.CrearInicio(objE);
         else//creando por el final...son excluyentes
             objl.CrearFinal(objE);
         resp=JOptionPane.showConfirmDialog(null,"Ingresar mas datos?","Lista simple",JOptionPane.YES_NO_OPTION);
     }//fin mientras
     return objl;
 }//fin de ingresar
 
 /*este metodo ingresa varios datos en la lista doble
    por el inicio o por el final, mientras que el usuario quiera,
    la opcion 1 esta ingresando por el inicio, de lo contrario
    se esta ingresando por el final*/
 public ListaDoble IngresarDatos(ListaDoble objl,int op)   
 {
     int resp;
     String id;
     Estudiantes objE;
     resp=JOptionPane.showConfirmDialog(null,"Ingresar datos?","Lista Doble",JOptionPane.YES_NO_OPTION);
     while(resp==JOptionPane.YES_OPTION)
     {
         id=Validaciones.LeerString("Identificación del estudiante: ");
         objE=new Estudiantes();
         objE=objE.EntrarDatos(id);
         if(op==1)//creando por el inicio
             objl.CrearInicio(objE);
         else//creando por el final...son excluyentes
             objl.CrearFinal(objE);
         resp=JOptionPane.showConfirmDialog(null,"Ingresar mas datos?","Lista doble",JOptionPane.YES_NO_OPTION);
     }//fin mientras
     return objl;
 }//fin de ingresar
 
//metodo que copia todo el contenido del archivo a la lista simple
    public void CopiarArchivoListaS(Archivos objArch, ListaSimple objLS) {
        
        try {
            //locales auxiliares para extraer la informacion del archivo
            String Ident, nom, apell, dire, te, ce, ema, IdA, Estad;
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
                Estad=Reg[10];
                Estudiantes objE = new Estudiantes(Ident, nom, apell, dire, te, ce, ema, fechI,prom,IdA,Estad);
                objLS.CrearFinal(objE);
                Reg = objArch.LeerRegistro(11);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        
     }//fin de copiar todo el archivo

    
    //metodo que copia todo el contenido del archivo a la lista doble
    public void CopiarArchivoListaD(Archivos objArch, ListaDoble objLD) {
        
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
                objLD.CrearFinal(objE);
                Reg = objArch.LeerRegistro(11);
            }//fin mientras  
            objArch.CerrarArchivoModoLectura();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "***Archivo leído y cerrado correctamente*****");
        }
        
     }//fin de copiar todo el archivo

/*este metodo permite cambiar o actualizar la informacion de un estudiante existente en la 
lista doble, lo realiza Sebastian*/

  public ListaDoble CambiarDato(ListaDoble ObjLD, String id) 
  {
      Estudiantes objE=new Estudiantes();//para llamar al metodo editar que es el de actualizacion
      Object dato;//para el retorno del editar y tome el dato encontrado
        if (ObjLD.IsEmpty() == false) {//si hay datos en la lista doble
            if (ObjLD.Buscar(id) == true) //si encuentra el dato p esta ubicado
            {//si se encuentra el dato
                dato=objE.Editar(ObjLD.p.getDato());//se manda a editar para cambios el dato señalado por p
                            int Confirmacion;//recibe la respuesta del usuario para actualizar el dato
                            Confirmacion = JOptionPane.showConfirmDialog(null, "¿ Desea guardar los cambios realizados ? ", "", JOptionPane.YES_NO_OPTION);
                            if (Confirmacion == JOptionPane.YES_OPTION) {
                                ObjLD.p.setDato(dato);
                                JOptionPane.showMessageDialog(null, "Se edito el estudiante a " + ObjLD.p.getDato().toString());
                            }
                            //Si la confirmacion es falsa simplemente se mantendra la lista como llego

                          
            }//finsi
            else {
                JOptionPane.showMessageDialog(null, "No se encuentra el estudiante con la id " + id);
            }
        }//finsi
        return ObjLD;
    } // FIN ACTUALIZAR LISTA
         
      
  public ListaSimple CambiarDato(ListaSimple ObjLS, String id) 
  {
      Estudiantes objE=new Estudiantes();//para llamar al metodo editar que es el de actualizacion
      Object dato;//para el retorno del editar y tome el dato encontrado
        if (ObjLS.IsEmpty() == false) {//si hay datos en la lista simple
            if (ObjLS.Buscar(id) == true) //si encuentra el dato p esta ubicado
            {//si se encuentra el dato
                dato=objE.Editar(ObjLS.p.getDato());//se manda a editar para cambios el dato señalado por p
                            int Confirmacion;//recibe la respuesta del usuario para actualizar el dato
                            Confirmacion = JOptionPane.showConfirmDialog(null, "¿ Desea guardar los cambios realizados ? ", "", JOptionPane.YES_NO_OPTION);
                            if (Confirmacion == JOptionPane.YES_OPTION) {
                                ObjLS.p.setDato(dato);
                                JOptionPane.showMessageDialog(null, "Se edito el estudiante a " + ObjLS.p.getDato().toString());
                            }
                            //Si la confirmacion es falsa simplemente se mantendra la lista como llego

                          
            }//finsi
            else {
                JOptionPane.showMessageDialog(null, "No se encuentra el estudiante con la id " + id);
            }
        }//finsi
        return ObjLS;
    } // FIN ACTUALIZAR LISTA
 

/*este metodo ubica a q en el nodo de antes de la mitad y al apuntador t atras de q*/
public void UbicarMitad(ListaSimple objLS,int tama)
{
    if(objLS.IsEmpty()==false)//hay datos en la lista
    {
    objLS.q=objLS.getStart();//ubicamos el apuntador t al inicio de la LS
    for(int i=1;i<(tama/2) ;i++)//ciclo hasta la mitad de los nodos
    {
        objLS.t=objLS.q;//colocamos a t atras de q
        objLS.q=objLS.q.getSig();//adelantamos en la lista
    }//fin para
       
    }//fin si
}//fin ubicar 

/*este metodo ubica a q en el nodo de antes de la mitad y al apuntador t atras de q*/
public void UbicarMitad(ListaDoble objLD,int tama)
{
    if(objLD.IsEmpty()==false)//hay datos en la lista
    {
    objLD.q=objLD.getStart();//ubicamos el apuntador t al inicio de la LD
    for(int i=1;i<(tama/2) ;i++)//ciclo hasta la mitad de los nodos
    {
       objLD.q=objLD.q.getSig();//adelantamos en la lista
    }//fin para
       
    }//fin si
}//fin ubicar 
  
/*metodo que retorna y cuenta los pares en la lista */ 
public int ContarPares(ListaDoble objLD)
{
    Nodo a;
    int con=0;//variable local de retorno
     if(objLD.IsEmpty()==false)//hay datos en la lista
     {
         a=objLD.getStart();//colocamos el apuntador al inicio de la lista
         while(a!=null)//mientras al apuntador llegue a null
         {
             if(((Estudiantes)a.getDato()).getPromGral()%2==0)//si el promdio es par
             {
                 con++;//se cuenta el par
             }//fin si
             a=a.getSig();//adelantamos al apuntador a
         }//fin mientras
         
     }//fin si
     return con;
}//fin contar pares

/*este metodo cuenta y retorna el numero de promedios pares de la lista doble*/
public int ContarPromediosPares(ListaDoble objLD)
{
int cont=0;//variable local para contar pares
Nodo k;
if (objLD.IsEmpty()==false) //hay datos en la lista
{
	k=objLD.getStart();//se inicia el apuntador en el primer dato de la lista
	while(k!=null)//mientra k apunta a nodo
        {
		if(((Estudiantes)k.getDato()).getPromGral() %2 == 0)//si es par
			cont=cont+1;
		//fin si
		k=k.getSig();
        }//fin mientras
}//fin si
return cont;
}//fin contar pares

/*este metodo pasa toda la informacion de la estructura cola a la lista doble
la cola queda sin datos*/
public ListaDoble PasarColaLista(ListaDoble objLD, Cola c1)
{
if(c1.IsEmpty()==false) //si hay datos en cola
{
	while(c1.IsEmpty()==false)//mientras cola tenga datos
        {
		objLD.CrearFinal(c1.Pop());//se desencola el dato y se pasa inmediatamente a la lista
        }//fin mientras
        JOptionPane.showMessageDialog(null,"Se pasaron los datos de la cola a la lista");
}
else 
      JOptionPane.showMessageDialog(null,"Cola vacia, NO se pasaron datos a la lista");
//Fin si
return objLD;
}//Fin pasar cola lista

/*este metodo recorre la lista y elimina los repetidos que esten en pila*/
public ListaDoble EliminarListaRepetidosPila(ListaDoble objLD, Pila p1, Pila p2)
{
Nodo k;
boolean sw=false;//si eliminamos en lista repetidos de pila
ManejoPila objManP=new ManejoPila();//para la llamada del buscar en pila
if(objLD.IsEmpty()==false) //si hay datos en lista
{
    k=objLD.getStart();//colocamos el apuntador en el primer datos de la lista
    while(k!=null)//mientras k este apuntando a un nodo
    {
    if(objManP.Buscar(p1,p2,((Estudiantes)k.getDato()).getIdentifi())==true)//invocamos el buscar de pila
    {
          objLD.LiberarDato(((Estudiantes)k.getDato()).getIdentifi());//invocamos el liberar de lista doble
          sw=true;//prendemos el sw que indica eliminar dato repetido
    }//fin si
    k=k.getSig();
    }//fin mientras
    if(sw==false)
            JOptionPane.showMessageDialog(null,"No hay datos repetidos en lista y pila");
    else
            JOptionPane.showMessageDialog(null,"Se eliminaron los datos repetidos de pila en la lista");
    //fin si
}//fin si
return objLD;
}//fin de eliminar repetidos


}//FIN CLASE MANEJO DE LISTA