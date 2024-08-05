
package academiaartes;


import java.time.LocalDate;
import javax.swing.JOptionPane;


public class ManejoMatriz 
{
    //ingresar datos tipo estudiantes en la matriz 
    public Object[][] IngresarDatosMatriz(Object matest[][], int f, int c)
    {
    	int i,j;
        String id;
        Estudiantes objE=new Estudiantes();
        JOptionPane.showMessageDialog(null,"la matriz se esta llenando por filas...");
    	for(i=0;i<f;i=i+1)
    	{
    		for(j=0;j<c;j=j+1)
    		{
                    id=JOptionPane.showInputDialog("Ingrese identificación del estudiante: ");
    		    matest[i][j]=objE.EntrarDatos(id);
    		}//fin ciclo j
    	}//fin ciclo i
    	return matest;
    }//fin de crear matriz
    
/*metodo para retornar la diagonal principal de
    la matriz de estudiantes en caso de ser cuadrada*/    
public String MostrarDiagonalPpal(Object Mat[][], int f, int c)
{
    String texto="";
    int i;
    if(f==c)//si es cuadrada
    {
        for(i=0;i<f;i++)
        {

            texto=texto+Mat[i][i].toString()+"\n";
        }//fin para
    }
    else
    {
        texto="La matriz NO es cuadrada no tiene diagonal";//se retorna para que lo muestre o imprima el que lo llame
    }//fin si
    return texto;
    
}//fin de mostrar diagonal

public String MostrarDiagonalSecundaria(Object Mat[][], int f, int c)
{
    String texto="";
    int i;
    if(f==c)//si es cuadrada
    {
        for(i=0;i<f;i++)
        {
            texto=texto+Mat[i][(f-1)-i].toString()+"\n";
        }//fin para
    }
    else
    {
        texto="La matriz NO es cuadrada no tiene diagonal";//se retorna para que lo muestre o imprima el que lo llame
    }//fin si
    return texto;
    
}//fin de mostrar diagonal

/*este metodo recibe la matriz y el id del acudiente para buscar los estudiantes
relacionados con este y contarlos, retorna el contador*/
public int ContarEstudiantesMismoAcudiente(Object Mat[][], int f, int c, String IdA)
{
    int cont=0,i,j;
    for(i=0;i<f;i++)//ciclo de filas
    {
        for(j=0;j<c;j++)//ciclo de columnas
        {
            /* es un procedimiento para transformar una variable primitiva 
            de un tipo a otro, o transformar un objeto de una clase a otra clase*/
            if(((Estudiantes)Mat[i][j]).getIdAcudiente().equals(IdA))
              cont=cont+1;  
        }//fin para j
    }//fin para i
    return cont;        
}//fin de contar

/*este metodo recibe la matriz y el id del acudiente para buscar los estudiantes
relacionados con este y retornarlos en una cadena*/
public String MostrarEstudiantesMismoAcudiente(Object Mat[][], int f, int c, String IdA)
{
    int i,j;
    String AcumEs="";
    if(ContarEstudiantesMismoAcudiente(Mat,f,c,IdA)!=0)
    {
        for(i=0;i<f;i++)//ciclo de filas
        {
            for(j=0;j<c;j++)//ciclo de columnas
            {
                 /* es un procedimiento para transformar una variable primitiva 
                 de un tipo a otro, o transformar un objeto de una clase a otra clase*/
                if(((Estudiantes)Mat[i][j]).getIdAcudiente().equals(IdA))
                  AcumEs=AcumEs+Mat[i][j].toString()+"\n";  
            }//fin para j
        }//fin para i
    }
    else
    {
        AcumEs="El acudiente con id "+IdA+" NO tiene estudiantes relacionados";
    }
    return AcumEs;        
}//fin de contar

/*este metodo intercambia dos filas validas de la matriz, recibe la matriz 
y retorna la matriz con posibles cambios*/
public Object[][] IntercambiarFilas(Object Mat[][], int f, int c)
{
    int x,y,i;
    Object aux;
    x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese primera fila a intercambiar: "));
    y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese segunda fila a intercambiar por : "+x));
    if(x<f&&x>=0&&y<f&&y>=0)
    {
        for(i=0;i<c;i++)//ciclo de columnas
        {
            aux=Mat[x][i];
            Mat[x][i]=Mat[y][i];
            Mat[y][i]=aux;
        }//fin para i
        JOptionPane.showMessageDialog(null,"Filas "+x+" y "+y+" se intercambiaron con éxito");
    }
    else
        JOptionPane.showMessageDialog(null,"Filas no estan en el rango de la matriz, no se puede intercambiar");
    //fin si
    return Mat;
}//fin de intercambiar

//Mostrar el promedio de los estudiantes por columnas
public String PromediarEstudiantesPorColumna(Object Mat[][],int f, int c)
{
    String texto="";
    double acum;
    int i,j;
    //se recorre la matriz por columnas o sea el ciclo mas interno es el de las filas
     for(j=0;j<f;j++)//ciclo de columnas
        {
         acum=0;//acumulador para el promedio
         
            for(i=0;i<c;i++)//ciclo de filas
            {
                /* es un procedimiento para transformar una variable primitiva 
                 de un tipo a otro, o transformar un objeto de una clase a otra clase*/
                acum=acum+((Estudiantes)Mat[i][j]).getPromGral();
                
            }//fin para i
            texto=texto+" Columna "+j+" Promedio: "+(acum/f)+" \n";
            
        }//fin para j

return texto;
}//Fin metodo Promedio estudiantes por columna

//Metodo Promedio general mayor por filas
  public String MostrarMayorPromedioGeneralPorFila(Object mat[][], int f, int c){
      
      //variables para guardar el nombre del estudiante y su promedio
      
      String Texto="",EstMayor;
      double PromMayor;
      
      //ciclos para recorrer la matriz
      for(int i=0;i<f;i++){
           //guardamos el nombre y promedio del primer estudiante
             
              /* es un procedimiento para transformar una variable primitiva 
              de un tipo a otro, o transformar un objeto de una clase a otra clase*/
              EstMayor=((Estudiantes)mat[i][0]).getNombre()+" "+((Estudiantes)mat[i][0]).getApellidos();
              PromMayor=((Estudiantes)mat[i][0]).getPromGral();
                  
          for(int j=0; j<c; j++){
              //comparamos con el siguiente estudiante    
              if(PromMayor<((Estudiantes)mat[i][j]).getPromGral())
              {
                  EstMayor=((Estudiantes)mat[i][j]).getNombre()+" "+((Estudiantes)mat[i][j]).getApellidos();
                  PromMayor=((Estudiantes)mat[i][j]).getPromGral();
              }//fin si
              
          }//fin para j
        
          //inicializamos a 0 las variables para pasar a la otra fila
          Texto = Texto +"El estudiante con promedio mayor de la fila "+i+" es: "+EstMayor+" y su promedio es "+PromMayor+"\n";
          
      }//fin para i
  
  return Texto;
  }//fin metodo Mayor promedio general por fila
  
  //Cuál estudiante obtiene el menor promedio general?
  public String BuscarPromMenorGeneral(Object Mat[][], int f, int c) 
  {
        double Menor=0;
        String NomMenor="";//se inicializan solo porque son el retorno
        
        if(Mat!=null)//si hay matriz
        {
         //inicializamos con el primer dato de la estructura
           Menor = ((Estudiantes)Mat[0][0]).getPromGral();
           NomMenor=((Estudiantes)Mat[0][0]).getNombre()+" "+((Estudiantes)Mat[0][0]).getApellidos();
            for (int i = 0; i < f; i++) 
            {
                for (int j = 0; j < c; j++) 
                {
                     if (Menor > ((Estudiantes)Mat[i][j]).getPromGral()) 
                     {
                            Menor = ((Estudiantes)Mat[i][j]).getPromGral();
                            NomMenor= ((Estudiantes)Mat[i][j]).getNombre()+" "+((Estudiantes)Mat[0][0]).getApellidos();
                      }//fin si
                 }//fin para j
            }//fin para i
        }//fin si
        return NomMenor+" "+Menor;
        
  }//fin de promedio general    

  //Este método muestra cual estudiante obtiene el mayor promedio general 
  public String BuscarPromMayorGeneral(Object Mat[][], int f, int c) 
  {
        double Mayor=0;
        String NomMayor="";//se inicializan solo porque son el retorno
        
        if(Mat!=null)//si hay matriz
        {
         //inicializamos con el primer dato de la estructura
           Mayor = ((Estudiantes)Mat[0][0]).getPromGral();
           NomMayor=((Estudiantes)Mat[0][0]).getNombre()+" "+((Estudiantes)Mat[0][0]).getApellidos();
            for (int i = 0; i < f; i++) 
            {
                for (int j = 0; j < c; j++) 
                {
                     if (Mayor < ((Estudiantes)Mat[i][j]).getPromGral()) 
                     {
                            Mayor = ((Estudiantes)Mat[i][j]).getPromGral();
                            NomMayor= ((Estudiantes)Mat[i][j]).getNombre()+" "+((Estudiantes)Mat[0][0]).getApellidos();
                      }//fin si
                 }//fin para j
            }//fin para i
        }//fin si
        return NomMayor+" "+Mayor;
 }//fin de promedio general    
    
   
    /*metodo booleano para validar si existe o no un estudiante en la matriz*/
    public boolean Buscar(Object mat[][], int f, int c, String id)
    {
        
     boolean sw=false;//variable para el retorno
        for (int i = 0; i < f; i++) 
            {
                for (int j = 0; j < c; j++) 
                {
                     if (id.equals(((Estudiantes)mat[i][j]).getIdentifi()) )
                         sw=true;
                }//fin para j
            }//fin para i
     return sw;   
    }//fin  buscar
    
    /*metodo para actualizar o cambiar los datos a un estudiante de la matriz*/
    
    public Object[][] Actualizar(Object mat[][], int f, int c, String id)
    {
     Estudiantes obje=new Estudiantes()   ;//para llamar al editar
     boolean sw=false;//variable para validar si existe o no el estudiante
     Object dato;
     int resp;
        for (int i = 0; i < f; i++) 
            {
                for (int j = 0; j < c; j++) 
                {
                     if (id.equals(((Estudiantes)mat[i][j]).getIdentifi()) )
                     {
                         sw=true;//se ecuentra el estudinte en la matriz 
                         dato=obje.Editar(mat[i][j]);
                          resp=JOptionPane.showConfirmDialog(null,"Actualizar definitivamente?","Cambio de información",JOptionPane.YES_NO_OPTION);
                          if(resp==JOptionPane.YES_OPTION)
                          {
                              mat[i][j]=dato;
                              JOptionPane.showMessageDialog(null,"Datos actualizados con éxito");
                          }//fin si
                     }//fin si 
                         
                }//fin para j
            }//fin para i
        if(sw==false)
            JOptionPane.showMessageDialog(null,"Estudiante a actualizar NO se encuentra en la matriz");
        return mat;                 
    }//fin actualizar       
                         

public Object[][] PruebaEscritorio(Object mat[][])//para matriz de estudiantes de 4*4
    {
        mat[0][0]=new Estudiantes("1010","Ana","Lopez","Calle10","23456","300300","ana@23",LocalDate.parse("02/02/2022"),3,"3434","Activo");
    	mat[0][1]=new Estudiantes("1020","Beto","Perez","Cra45","23456","300300","BEto@23",LocalDate.parse("02/02/2022"),3,"3435","Activo");
        mat[0][2]=new Estudiantes("1030","Carla","Mesa","Calle 100","23456","300300","lolo@23",LocalDate.parse("02/02/2022"),4,"3434","Activo");
        mat[0][3]=new Estudiantes("1040","Deo","Rua","Calle 10","23456","300300","dio@23",LocalDate.parse("02/02/2022"),5,"3435","Activo");
        mat[1][0]=new Estudiantes("1050","Elena","Pinto","Cra 45","23456","300300","ele@23",LocalDate.parse("02/03/2022"),5,"3436","Activo");
        mat[1][1]=new Estudiantes("1060","Fer","Gomez","Calle 12","23456","300300","fer@23",LocalDate.parse("02/03/2022"),3,"3437","Activo");
       	mat[1][2]=new Estudiantes("1070","Gonza","Lopez","Calle 10","23456","300300","zao@23",LocalDate.parse("02/03/2022"),3,"3438","Activo");
    	mat[1][3]=new Estudiantes("1080","Hybe","Perez","Cra 45","23456","300300","h@23",LocalDate.parse("02/02/2022"),2,"3439","Activo");
        mat[2][0]=new Estudiantes("1090","Isaac","Mesa","Calle 100","23456","300300","iss@23",LocalDate.parse("02/05/2022"),1,"3434","Activo");
        mat[2][1]=new Estudiantes("1100","Jimin","Rua","Calle 10","23456","300300","jim@23",LocalDate.parse("02/02/2022"),3,"3434","Activo");
        mat[2][2]=new Estudiantes("1110","Kook","Pinto","Cra 45","23456","300300","jona@23",LocalDate.parse("02/06/2022"),2,"3435","Activo");
        mat[2][3]=new Estudiantes("1120","Olga","Gomez","Calle 12","23456","300300","lin@23",LocalDate.parse("02/03/2022"),3,"3440","Activo");
        mat[3][0]=new Estudiantes("1130","Muse","Mesa","Calle 100","23456","300300","fred@23",LocalDate.parse("02/06/2022"),3,"3441","Activo");
        mat[3][1]=new Estudiantes("1140","Nandu","Rua","Calle 10","23456","300300","nji@23",LocalDate.parse("02/03/2022"),4,"3442","Activo");
        mat[3][2]=new Estudiantes("1150","Olga","Pinto","Cra 45","23456","300300","aluc@23",LocalDate.parse("02/06/2022"),5,"3434","Activo");
        mat[3][3]=new Estudiantes("1160","Pedro","Gomez","Calle 12","23456","300300","peter@23",LocalDate.parse("02/07/2022"),2,"3435","Activo");
        return mat;
    }


}//fin clase manejo de matriz