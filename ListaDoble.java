
package academiaartes;

import javax.swing.JOptionPane;

public class ListaDoble 
{
    //atributos propios y privados
    private Nodo Start, End;

    
    //apuntadores auxiliares, q para cualquier metodo y p SOLO para buscar
    Nodo q,p;
    
    //constructor vacio con condiciones iniciales de lista doble
    public ListaDoble() 
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
    
    /*este metodo crea la lista en caso de que no exista y coloca
    nuevos datos por el apuntador Start, quedando de ultimo el primero
    que ingresa*/
    public void CrearInicio(Object d)
    {
        if(IsEmpty()==true)//si esta vacia la lista
        {
            setStart(new Nodo(null,d,null));//pedimos memoria para el primer nodo
            setEnd(getStart());//colocamos el apuntador end en el mismo nodo
        }
        else//ya hay algun dato en la lista
        {
            getStart().setAnt(new Nodo(null,d,getStart()));//se enlaza el nuevo nodo con el anterior de start
            setStart(getStart().getAnt());//se mueve al apuntador Start para el nuevo nodo
        }//fin si
        
    }//fin de crear por inicio

    /*este metodo crea la lista en caso de que no exista y coloca
    nuevos datos por el apuntador End, quedando el primero
    que ingresa de primero y los demas por el final*/
    public void CrearFinal(Object d)
    {
        if(IsEmpty()==true)//si esta vacia la lista
        {
            setStart(new Nodo(null,d,null));//pedimos memoria para el primer nodo
            setEnd(getStart());//colocamos el apuntador end en el mismo nodo
        }
        else//ya hay algun dato en la lista
        {
            getEnd().setSig(new Nodo(getEnd(),d,null));//se enlaza el nuevo nodo con el siguiente del ultimo
            setEnd(getEnd().getSig());//se mueve al apuntador End para el nuevo nodo
        }//fin si
        
    }//fin de crear por final
    
    /*metodo que retorna una cadena con los datos de la lista NO imprime*/
    public String ImprimirDesdeStart()
    {
        String Texto="";//para el retorno
        if(IsEmpty()==false)//si existen datos en la lista
        {
            //colocamos el apuntador auxiliar en el primer nodo
            q=getStart();
            while(q!=null)//mientras q este apuntando algun dato alojado en el nodo
            {
                Texto=Texto+q.toString()+"\n";
                q=q.getSig();//adelantamos en la lista para que salga del ciclo
            }//fin mientras
        }//fin si
        return Texto;
    }//fin de imprimir desde inicio
    
      /*metodo que retorna una cadena con los datos de la lista NO imprime*/
    public String ImprimirDesdeEnd()
    {
        String Texto="";//para el retorno
        if(IsEmpty()==false)//si existen datos en la lista
        {
            //colocamos el apuntador auxiliar en el ultimo nodo
            q=getEnd();
            while(q!=null)//mientras q este apuntando algun dato alojado en el nodo
            {
                Texto=Texto+q.toString()+"\n";
                q=q.getAnt();//retrocedemos en la lista para que salga del ciclo
            }//fin mientras
        }//fin si
        return Texto;
    }//fin de imprimir desde end
    
    /*este metodo inserta un nodo de primero y SIEMPRE parte de 
    la base de tener informacion la lista, o sea NO crea la lista desde 
    cero*/
    public void InsertarStart(Object d)
    {
        
        if(IsEmpty()==false)
        {//si hay datos en la lista
           getStart().setAnt(new Nodo(null,d,getStart()));
           setStart(getStart().getAnt());
        }
       
    }//fin insertarStart
    
    /*este metodo inserta un nodo de primero y SIEMPRE parte de 
    la base de tener informacion la lista, o sea NO crea la lista desde 
    cero*/
    public void InsertarEnd(Object d)
    {
        if(IsEmpty()==false)
        {
            getEnd().setSig(new Nodo(getEnd(),d,null));
            setEnd(getEnd().getSig());
        }
    
    }//fin insertarEnd
    
    /*busca por id un estudiante y si lo encuentra retorna verdadero y deja ubucado en el dato 
    al nodo p ....y si no lo encuentra retorna falso y p no apunta a nada*/
     public boolean Buscar(String id)
        {
            String aux;
            p=getStart();//se comienza desde el primer dato
            aux=((Estudiantes)(p.getDato())).getIdentifi();//se toma solo el id de estudiante
            while(p!=null&&!(aux.equals(id)))//se sale por p=null no lo encuentra o por que se encuentra el dato
            {
                p=p.getSig();//se adelanta en la lista
                if(p!=null)//si hay datos que asignar a aux
                    aux=((Estudiantes)(p.getDato())).getIdentifi();
                    
            }//fin mientras
            if(p==null)//no lo encuentra
                return false;
            else//queda ubicado p en el dato
                return true;
      }//fin de buscar
        
   public void InsertarAntes(Object d, String IdBus)
    {
         if(IsEmpty()==false)//si hay datos
         {
             if(Buscar(IdBus)==false)
             {
                 JOptionPane.showMessageDialog(null,"Estudiante referencia no esta en la lista, NO se inserta");
             }
             else//si está en la lista el dato referencia
                     {
                         if(p==getStart())//si el dato referencia se encuentra de primero en la lista
                         {
                             InsertarStart(d);//se invoca el metodo que inserta de primero en la lista
                         }
                         else//el dato referencia no esta de primero en la lista
                         { 
                             p.setAnt(new Nodo(p.getAnt(),d,p));
                             p.getAnt().getAnt().setSig(p.getAnt());
                         }//fin si
                        
                     }//fin si
          }
           
      }//fin de insertar antes

     public void InsertarDespues( Object d, String IdBus)
    {
         if(IsEmpty()==false)//si hay datos
         {
             if(Buscar(IdBus)==false)
             {
                 JOptionPane.showMessageDialog(null,"Estudiante referencia no esta en la lista, NO se inserta");
             }
             else
                     {
                         if(p==getEnd())
                         {
                             InsertarEnd(d);
                         }
                         else
                         {  
                             p.setSig(new Nodo(p,d,p.getSig()));
                             p.getSig().getSig().setAnt(p.getSig());
                         }//fin si
                        
                     }//fin si
          }//fin si
                   
      }//fin de insertar despues

     
     public Object LiberarStart ()
     {
    Object Aux=null;
    if(IsEmpty()==false) //si hay datos
    {
        Aux=getStart().getDato();//se toma el dato para retornar
	if(getStart()==getEnd())//lista de un solo nodo
        {
		JOptionPane.showMessageDialog(null,"la lista va a quedar vacia");
		getStart().finalize();
		setStart(null);
		setEnd(null);
        }
        else{
                setStart(getStart().getSig());
                getStart().getAnt().finalize();
                getStart().setAnt(null);
        }//fin si
    }
   
    return Aux;
     }//fin de liberar start

public Object LiberarEnd ()
{
Object Aux=null;
if(IsEmpty()==false)
{
            Aux=getEnd().getDato();
            if(getStart()==getEnd())//lista de un solo nodo
            {
                JOptionPane.showMessageDialog(null,"la lista va a quedar vacia");
		getStart().finalize();
		setStart(null);
		setEnd(null);
            }
            else
            {
                setEnd(getEnd().getAnt());
                getEnd().getSig().finalize();
                getEnd().setSig(null);
            }//fin si
}
    
    return Aux;
}//fin de liberar End


public void LiberarDato(String id)
{
if(IsEmpty()==false) 
{
	if(Buscar(id)==false)//no se encuentra el dato a eliminar
		JOptionPane.showMessageDialog(null,"dato no esta en la lista, no se libera");
	else//si se encuentra el dato a eliminar en la lista
        {
		if(p==getStart())//si se encuentra de primero
                {
			LiberarStart();
                }
                else{//si se encuentra de ultimo
			if(p==getEnd())	
                        {
				LiberarEnd();
                        }
			else//si se encuentra entre dos datos
                        {
				p.getAnt().setSig(p.getSig());
                                p.getSig().setAnt(p.getAnt());
                                p.finalize();
                        }//fin si
                }//fin si
        }//fin si
}//fin si
    
}//fin liberar dato

public int ContarNodos()
    {
        int con=0;
        if(IsEmpty()==false)//hay datos
        {
            q=getStart();
            while(q!=null)
            {
                con=con+1;
                q=q.getSig();
            }//fin mientras
        }//fin si
        
        return con;
        
    }     //fin de contar nodos





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
    
    
}//fin clase lista doble
