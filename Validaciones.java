package academiaartes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Validaciones {
    
    	//Metodo para leer numeros enteros
	public static int LeerEntero(String mensaje)
	{
	int num = 0;
        do{
	       try
                {
				      	    
			 num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		         if(num<=0)
		             JOptionPane.showMessageDialog(null,"ERROR, el Numero debe ser mayor que cero");
			                       
	        }catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null,"ERROR - OJO la Excepcion es: " + e);
		}
            }while(num<=0);
		return num;
	}//fin leer entero

	//Metodo para leer numeros reales
	public static double LeerReal(String mensaje)
	{
		double num = 0;
	        do{
			try
			{
		      	   num = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	               if(num<=0)
	                  JOptionPane.showMessageDialog(null,"ERROR, el Numero debe ser mayor que cero");
	                       
	        }catch (Exception e)
			{
				JOptionPane.showMessageDialog(null,"ERROR - OJO la Excepcion es: " + e);
			}
        }while(num<=0);
		return num;
	}//fin leer real
	
    //Metodo para leer cadenas de texto y que no las dejen en blanco
	public static String LeerString(String mensaje)
	{
		String cadena= "";
        do{
		try
			{
		       cadena = JOptionPane.showInputDialog(mensaje);
	           if(cadena.equals(""))
	                        JOptionPane.showMessageDialog(null,"ERROR, NO debe dejarla en blanco, \n¡DEBE ingresar informacion!");
	                       
	        }catch (Exception e)
			{
				JOptionPane.showMessageDialog(null,"ERROR - OJO la Excepcion es: " + e);
			}
        }while(cadena.equals(""));
		return cadena;
	}//fin de ller cadena
      
        //Metodo para leer numeros reales entre 0 y 5
	public static double LeerNota(String mensaje)
	{
		double num = 0;
	        do{
			try
			{
		      	   num = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	               if(num<0||num>5)
	                  JOptionPane.showMessageDialog(null,"ERROR, el Numero debe ser entre 0 y 5");
	                       
	        }catch (Exception e)
			{
				JOptionPane.showMessageDialog(null,"ERROR - OJO la Excepcion es: " + e);
			}
        }while(num<0||num>5);
		return num;
	}//fin leer real
        
          /*metodo que lee una fecha sin el campo de tiempo, la lee como String
    valida que no dejen en blanco el String, luego este String lo pasa a
    fecha en dia,mes,año y lo retorna como tipo de dato LocalDate*/
     public static LocalDate leerfecha(String mensaje) {
        String Cfecha = "";
        do {
            try {

                Cfecha = JOptionPane.showInputDialog(mensaje+ " (dd/MM/yyyy):");
                if (Cfecha.equals("")) {
                    JOptionPane.showMessageDialog(null, "ERROR, NO debe dejarla en blanco, \n¡DEBE ingresar informacion!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR - OJO la Excepcion es: " + e);
            }
        } while (Cfecha.equals(""));
        //lectura de entrada de teclado almacenada en String
        //se da el formato establecido       
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        //se pasa el String a LocalDate que es el tipo de fecha sin hora
        LocalDate fecha = LocalDate.parse(Cfecha, formato); 
        return fecha;
    }
     
     public static String LeerEstado()
     {
        //lectura de estado, tambien se puede hacer de otra forma
        Object opciones;//las opciones del selector deben ser tipo object
        //se crea un vector tipo object que llamé gen con las opciones que necesito
        Object [] est ={"Activo","Inactivo","Otro"};
        do{//este ciclo esta validando cuando seleccionan el boton cancel... sino se coloca el cancel se sale abruptamente del programa
           opciones = JOptionPane.showInputDialog(null,"Se identifica con Género:", "Seleccione una opción",JOptionPane.QUESTION_MESSAGE,null,est, est[0]);
           //se pide la variable opciones para pasarlo a genero que es string, se selecciona solo una de las que queremos
        }while(opciones==null);//validando el CANCEL, si alguno sabe quitarlo de la ventana nos muestra!!!
        String Estado=opciones.toString();//pasamos la opcion tipo Object a string
        return Estado;
     }//fin de leer estado
        
}//fin clase validaciones
