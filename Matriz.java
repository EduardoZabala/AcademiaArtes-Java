package academiaartes;

public class Matriz 
{
 
   //atributos propios y privados 
   private Object mat[][];//matriz que tendra toda la informacion
   private int fil,col;//tamaño de la matriz en filas y columnas
      
//constructor vacio de clase
   public Matriz() {}
    
   public Object[][] CrearMatriz(int n,int m)//metodo para pedir el tamaño deseado y exacto de matriz
    {
        fil=n;
        col=m;
    	mat=new Object[fil][col];
    	return mat;
    }//fin de crear matriz
    
       
    
    public String ImprimirMatrizEstudiantesFilas(Object mat[][], int f, int c)
    {
    	int i,j;
    	String texto="";
        fil=f;
        col=c;
    	for(i=0;i<fil;i=i+1)
    	{
    		for(j=0;j<col;j=j+1)
    		{
    		     texto=texto+mat[i][j].toString()+" - ";
    		}//fin para j
    		texto=texto+"\n";
    	}//fin para i
    	return texto;
    }//fin de imprimir matriz
  
    public String ImprimirMatrizEstudiantesColumnas(Object matest[][], int f, int c)
    {
    	int i,j;
    	String texto="";
        fil=f;
        col=c;
    	for(i=0;i<col;i=i+1)
    	{
    		for(j=0;j<fil;j=j+1)
    		{
    		     texto=texto+matest[j][i].toString()+" - ";
    		}//fin para j
    		texto=texto+"\n";
    	}//fin para i
    	return texto;
    }//fin de imprimir matriz de estudiantes
    
 
    
    
}//fin clase matriz