package academiaartes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class Pruebas {
    
    File Arch;//archivo logico
    FileReader ArchLectura;//objeto para modo lectura del archivo
    BufferedReader BufferAlm;//objeto que reserva un espacio en memoria donde se guarda la informaci�n
    FileWriter ArchEscritura;//objeto para modo escritura del archivo
    PrintWriter objImpresion;//objeto para grabar directamente en el archivo tipo texto
    public static void main(String[] args) {
        Pruebas objPruebas = new Pruebas();
        ListaDoble objLD = new ListaDoble();
        ManejoListas objManLD = new ManejoListas();
        //objPruebas.CrearArchivo("Estudiantes.txt","");
        objPruebas.EliminarArchivo("Estudiante.txt");
        objPruebas.CrearArchivo("Estudiante.txt", "1110,Kook,Pinto,Cra 45,23456,300300,jona@23,02/06/2022,2.0,3435");
    
    }
    public void EliminarArchivo(String ruta){
        File Arch = new File(ruta);

        if (Arch.delete())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
            System.out.println("El fichero no pudó ser borrado");
    }
    public void CrearArchivo(String ruta,String contenido){
        try {
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
		
    
}
