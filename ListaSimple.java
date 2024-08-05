
package academiaartes;

import javax.swing.JOptionPane;


public class ListaSimple 
{
    //atributos propios y privados
    private Nodo Start, End;

    //auxiliares para movimiento y busqueda
    Nodo q, p, t;
    
    //condiciones iniciales de lista simple
    public ListaSimple() 
    {
        Start=null;
        End=null;
    }

    /*metodo para validar si la lista esta vacia 
    o tiene datos, retorna verdadero si no hay datos*/
    public boolean IsEmpty()
    {
        if(Start==null)
            return true;
        else
            return false;
    }//fin de IsEmpty
    
    /*este metodo recibe un dato tipo object y crea los 
    nodos simples por el inicio o sea queda señalado por 
    el apuntador start el que va ingresando*/
    public void CrearInicio(Object d)
    {
        if(IsEmpty()==true)//lista vacia se crea primer nodo
        {
          setStart(new Nodo(d)); 
          setEnd(getStart());
        }
        else
        {
            setStart(new Nodo(d,getStart()));
        }//fin si
    }//fin de crear por inicio
    
     /*este metodo recibe un dato tipo object y crea los 
    nodos simples por el final o sea queda señalado por 
    el apuntador end el que va ingresando*/
    public void CrearFinal(Object d)
    {
         if(IsEmpty()==true)//lista vacia se crea primer nodo
        {
          setStart(new Nodo(d)); 
          setEnd(getStart());
        }
        else
        {
            getEnd().setSig(new Nodo(d));
            setEnd(getEnd().getSig());
        }//fin si
       
    }//fin de crear por final
 

   
 //retorna una cadena con toda la información de la lista desde el inicio
 public String ImprimirDesdeInicio()      
 {
     String texto="";
      if(IsEmpty()==false)//lista NO esta vacia, hay datos
      {
          q=getStart();
          while(q!=null)//mientras existan datos para señalar
          {
              texto=texto+q.getDato().toString()+"\n";
              q=q.getSig();//adelanto en la lista, si falta esta instruccion NO avanza ni llega a null
          }//fin mientras
          
      }
      return texto;    
 }//fin imprimir desde inicio
    
 //retorna una cadena con toda la información de la lista desde el FINAL END
 public String ImprimirDesdeFinal()      
 {
     String texto="";
      if(IsEmpty()==false)//lista NO esta vacia, hay datos
      {
          q=getEnd();
          while(q!=null)//mientras existan datos para señalar
          {
              texto=q.getDato().toString()+"\n"+texto;
              q=q.getSig();//adelanto en la lista, si falta esta instruccion NO avanza ni llega a null
          }//fin mientras
          
      }
      return texto;    
 }//fin imprimir desde inicio   
    
 /*metodo que busca por la id un estudiante en la lista,
 retorna verdadero si lo encuentra y ademas deja el apuntador
 p en el dato, y al apuntador t atras de p, y retorna falso en 
 caso de no encontrarlo*/
    public boolean Buscar(String id)
    {
       if(IsEmpty()==false)//si hay datos
       {
         String Iddato;  
         p=getStart();//colocamos el apuntador al inicio
         Iddato=((Estudiantes)p.getDato()).getIdentifi();
         while(p!=null&&!(Iddato.equals(id)))
         {
             t=p;//ubicamos al apuntador t atras de p
             p=p.getSig();//adelanta en la lista
             if(p!=null)//si hay aun datos para tomar id
                 Iddato=((Estudiantes)p.getDato()).getIdentifi();
         }//fin mientras
       }
       if(p==null)//recorrió toda la lista y no lo encuentra
           return false;
       else//p quedo ubicada en la lista en el dato buscado
           return true;
    }//fin buscar
    
   /* Este método parte de que hay algún dato en la lista, e inserta el dato
que recibe de primero en la lista existente (mueve el apuntador Start)*/
public void InsertStart( Object d)
{
    if (IsEmpty()==false) //si hay algun dato
    {
        q=new Nodo(d,getStart());
	setStart(q);
    }//fin si 
}//fin insertar en start

/*Este método parte de que hay algún dato en la lista, e inserta 
el dato que recibe de último en la lista existente (mueve el apuntador End)*/
public void InsertEnd(Object d)
{
    if (IsEmpty()==false) 
    {
 	getEnd().setSig(new Nodo(d));
	setEnd(getEnd().getSig());
    }//fin si 
}//fin insertar en el final

/*Este método parte de que hay algún dato en la lista, recibe un dato referencia 
para buscar en la lista y si se encuentra inserta el dato d  “después” 
del dato referencia, de lo contrario se muestra un mensaje de NO insertado 
porque el dato referencia no se encuentra*/
public void InsertarDespues(String IdRef,  Object d)
{
if(IsEmpty()==false)//si hay datos en la lista
{
    if (Buscar(IdRef)==true)//si se encuentra el dato referencia en la lista
    {
        if(p==getEnd())//si p quedo ubicado en el ultimo
		InsertEnd(d);
	else
 		p.setSig(new Nodo(d,p.getSig()));
	//fin si
    }
    
    //fin si
}//fin si
}//fin de insertar después

/*Este método parte de que hay algún dato en la lista, recibe un dato referencia 
para buscar en la lista y si se encuentra inserta el dato d  “antes” 
del dato referencia, de lo contrario se muestra un mensaje de NO insertado 
porque el dato referencia no se encuentra*/
public void InsertarAntes(String IdRef,  Object d)
{
if(IsEmpty()==false)//si hay datos en la lista
{
    if (Buscar(IdRef)==true)//si se encuentra el dato referencia en la lista
    {
        if(p==getStart())//si p quedo ubicado en el primero
		InsertStart(d);
	else
 		t.setSig(new Nodo(d,t.getSig()));
	//fin si
    }
    
    //fin si
}//fin si
}//fin de insertar antes


/*Este método parte de que hay algún dato en la lista, y borra el primer dato de 
la lista se “libera” el espacio de memoria, retorna el dato borrado 
para que el usuario sepa que se borró ya que no es una búsqueda, sino que solo 
es eliminar el primer dato de la lista, se debe tener en cuenta que la lista 
puede quedar vacia y alertar al usuario de este hecho*/
public Object LiberarStart()
{
Object dato=null;//variable para el retorno
if(IsEmpty()==false)//si hay datos
{
    dato=getStart().getDato();//estamos tomando los datos del primer nodo
    //if(getStart()==getEnd()) //un solo dato
    if(getStart().getSig()==null)//si hay un solo dato en la lista
    {
	getStart().finalize();//llamada al destructor
	setStart(null);
        setEnd(null);//condiciones iniciales de lista vacia
        JOptionPane.showMessageDialog(null,"La lista quedo vacia");
    }
    else//hay mas de un dato en la lista
    {
	q= getStart();//se inicializa q en start para poder liberar el espacio de memoria
	setStart(getStart().getSig());//se pasa a start para el siguiente nodo
	q.finalize();//se invoca al destructor para limpieza
    }//	fin si
}//fin si
return dato;//retornamos el dato que eliminamos o null
}//fin liberar start

public Object LiberarEnd()
{
Object dato=null;//variable para el retorno
if(IsEmpty()==false)//si hay datos
{
    dato=getEnd().getDato();//estamos tomando los datos del primer nodo
    //if(getStart()==getEnd()) //un solo dato
    if(getStart().getSig()==null)//si hay un solo dato en la lista
    {
	getStart().finalize();//llamada al destructor
	setStart(null);
        setEnd(null);//condiciones iniciales de lista vacia
        JOptionPane.showMessageDialog(null,"La lista quedo vacia");
    }
    else//hay mas de un dato en la lista
    {
        
        //ubicamos con el metodo buscar a t y p
        Buscar(((Estudiantes)getEnd().getDato()).getIdentifi());//perdiendo el retorno
        setEnd(t);
        p.finalize();
        t.setSig(null);
    }//fin si
}//fin si
return dato;
}//fin de liberar end
  
public void LiberarDato(String id)
{
    if(IsEmpty()==false)//si hay datos
    {
       if(Buscar(id)==true)//se encontro el dato
       {
           if(p==getStart())//esta de primero en la lista
               LiberarStart();
           else
           {
               if (p==getEnd())//esta de ultimo en la lista
                   LiberarEnd();
               else
               {
                   t.setSig(p.getSig());
                   p.finalize();
               }//fin si
                   
           }//fin si
           
       }
       else
           JOptionPane.showMessageDialog(null,"No se encuentra el dato a eliminar en la lista");
       //fin si
 }//fin si
    
}//fin de liberar dato

public int ContarNodos() {//metodo para contar los datos que hay en la lista
        int cont = 0;
        if (IsEmpty() == false) {
            q = getStart();
            while (q != null) {
                cont++;
                q = q.getSig();
            }
        }
        return cont;//retornamos el tamaño
    }
 
 
    public Nodo getStart() {
        return Start;
    }

    public void setStart(Nodo Start) {
        this.Start = Start;
    }

    public Nodo getEnd() {
        return End;
    }

    public void setEnd(Nodo End) {
        this.End = End;
    }
    
    
    
    
    
    
    
}//fin de lista simple
