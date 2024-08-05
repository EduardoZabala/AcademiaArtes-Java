package academiaartes;

import javax.swing.JOptionPane;

public class AcademiaArtes {

    public static void main(String[] args) {
        AcademiaArtes objAca = new AcademiaArtes();
        CRUDEstudiante objCRUDEst=new CRUDEstudiante();
        CRUDProfesor objCRUDProf=new CRUDProfesor();
        CRUDAcudiente objCRUDAcud=new CRUDAcudiente();
        Archivos objArch=new Archivos();
        Pagos objPag = new Pagos();
        
        
        int opPpal, opArch, opEstru, opMatricu, opCur, opPag, opPro, opCRUDPag, opCRUDEst, opCRUDProf, opCRUDAcud, opCRUDCur;
        int opPilCur, opColAcu, opLisSimPro, opLisDobEst, opLisDobPag, opMatHor;
        String id, Texto;
        
        do {//menu principal
            opPpal = Validaciones.LeerEntero(objAca.MenuPrincipal());
            switch (opPpal)//caso del menu principal 
            {
                case 1:do {//menu archivos
                          opArch=Validaciones.LeerEntero(objAca.MenuArchivos());
                          switch(opArch)//caso del menu de archivos
                          {
                              case 1:do{//menu de crud de pagos
                                     opCRUDPag=Validaciones.LeerEntero(objAca.MenuCRUDPagos());
                                     switch(opCRUDPag)//caso del menu de CRUD de pagos
                                     {
                                         case 1:
                                                break;
                                     }//fin caso de crud de pagos
                                  
                                      }while(opCRUDPag<5);//fin ciclo de crud de pagos
                                     break;
                              case 2:do{//menu de crud de estudiantes
                                     opCRUDEst=Validaciones.LeerEntero(objAca.MenuCRUDEstudiantes());
                                     switch(opCRUDEst)//caso del menu de CRUD de estudiantes
                                     {
                                         case 1:id=Validaciones.LeerString("Ingrese Id del estudiante a grabar: ");
                                                objCRUDEst.IngresarEstudiante(objArch, id);
                                                break;
                                         case 2:id=Validaciones.LeerString("Ingrese Id del estudiante a consultar: ");
                                                Texto=objCRUDEst.Consultar(objArch, id);//se coloca en variable local porque necesitamos llamar dos veces el mismo metodo
                                                if(!Texto.equals(""))
                                                    JOptionPane.showMessageDialog(null,"El Estudiante  se encuentra en el archivo: \n"+Texto);
                                                break;  
                                         case 3:Texto=objCRUDEst.MostrarTodo(objArch);//se coloca en variable local porque necesitamos llamar dos veces el mismo metodo
                                                if(!Texto.equals(""))
                                                    JOptionPane.showMessageDialog(null,"El archivo: \n"+Texto);
                                                break;          
                                     }//fin caso de crud de estudiantes
                                  
                                      }while(opCRUDEst<5);//fin ciclo de crud de estudiantes
                                     break;      
                              case 3:do{//menu de crud de pROFESORES
                                     opCRUDProf=Validaciones.LeerEntero(objAca.MenuCRUDProfesores());
                                     switch(opCRUDProf)//caso del menu de CRUD de profesores
                                     {
                                         case 1:id=Validaciones.LeerString("Ingrese Id del profesor a grabar: ");
                                                objCRUDProf.IngresarProfesores(objArch, id);
                                                break;
                                         case 2:id=Validaciones.LeerString("Ingrese Id del profesor a consultar: ");
                                                Texto=objCRUDProf.Consultar(objArch, id);
                                                if(!Texto.equals(""))
                                                    JOptionPane.showMessageDialog(null,"El profesor se encuentra en el archivo: \n"+Texto);
                                                break; 
                                         case 3:Texto=objCRUDProf.MostrarTodo(objArch);//se coloca en variable local porque necesitamos llamar dos veces el mismo metodo
                                                if(!Texto.equals(""))
                                                   JOptionPane.showMessageDialog(null,"El archivo: \n"+Texto);
                                                break;          
                                     }//fin caso de crud de profesores
                                  
                                      }while(opCRUDProf<5);//fin ciclo de crud de acudientes
                                     break;     
                             case 4:do{//menu de crud de acudientes
                                     opCRUDAcud=Validaciones.LeerEntero(objAca.MenuCRUDAcudientes());
                                     switch(opCRUDAcud)//caso del menu de CRUD de acudientess
                                     {
                                         case 1:id=Validaciones.LeerString("Ingrese Id del acudiente a grabar: ");
                                                objCRUDAcud.IngresarAcudiente(objArch, id);
                                                break;
                                         case 2:id=Validaciones.LeerString("Ingrese Id del acudiente a consultar: ");
                                                Texto=objCRUDAcud.Consultar(objArch, id);
                                                if(!Texto.equals(""))
                                                    JOptionPane.showMessageDialog(null,"El acudiente se encuentra en el archivo: \n"+Texto);
                                                break; 
                                         case 3:Texto=objCRUDAcud.MostrarTodo(objArch);//se coloca en variable local porque necesitamos llamar dos veces el mismo metodo
                                                if(!Texto.equals(""))
                                                   JOptionPane.showMessageDialog(null,"El archivo: \n"+Texto);
                                                break;          
                                     }//fin caso de crud de profesores
                                  
                                      }while(opCRUDAcud<5);//fin ciclo de crud de acudientes
                                     break;
                             case 5:
                                 id=Validaciones.LeerString("Ingrese el id: ");
                                 objCRUDEst.EliminarRegistro(objArch, id);
                                 break;
                                     
                          }//fin caso del menu de archivos
                    
                           }while(opArch<6);//fin ciclo de archivos
                       break;
                       
            }//fin caso del menu principal 
        } while (opPpal < 7);//fin ciclo principal
    }//FIN DEL MAIN

    public String MenuPrincipal() {
        return "MENU PRINCIPAL\n\n"
                + "1. Manejo de Archivos\n"
                + "2. Manejo de Estructuras\n"
                + "3. Matricular Estudiantes\n"
                + "4. Crear Cursos\n"
                + "5. Manejo de Pagos\n"
                + "6. Manejo de Profesores\n"
                + "7. Terminar";
    }//fin menu principal

    public String MenuArchivos() {
        return "MENU ARCHIVOS\n\n"
                + "1. CRUD de Pagos\n"
                + "2. CRUD de Estudiantes\n"
                + "3. CRUD de Profesores\n"
                + "4. CRUD de Acudientes\n"
                + "5. CRUD de Cursos\n"
                + "6. Volver al Menu principal\n";

    }//fin menu archivos

    public String MenuEstructuras() {
        return "MENU ESTRUCTURAS\n\n"
                + "1. Pila Cursos\n"
                + "2. Cola Acudientes\n"
                + "3. Lista Simple de Profesores\n"
                + "4. Lista Doble de Estudiantes\n"
                + "5. Lista Doble de Pagos\n"
                + "6. Matriz de Horarios\n"
                + "7. Volver al Menu principal\n";

    }//fin menu de estructuras

    public String MenuMatricular() {
        return "MENU MATRÍCULAS\n\n"
                + "1. Matricular Estudiantes\n"
                + "2. Buscar cursos\n"
                + "3. Ingresar acudientes\n"
                + "4. \n"
                + "5. Volver al Menu principal\n";

    }//fin menu de matricular

    public String MenuCursos() {
        return "MENU CURSOS\n\n"
                + "1. Ingresar Cursos\n"
                + "2. Listar Cursos\n"
                + "3. Validar Cupos\n"
                + "4. Consultar Horarios\n"
                + "5. Volver al Menu principal\n";

    }//fin menu de cursos

    public String MenuPagos() {
        return "MENU PAGOS\n\n"
                + "1. Ingresar Pago\n"
                + "2. Generar Recibo\n"
                + "3. Validar Mora\n"
                + "4. Mostrar Total Pagos\n"
                + "5. Volver al Menu principal\n";

    }//fin menu de pagos

    public String MenuContratarProfesores() {
        return "MENU CONTRATACIÓN\n\n"
                + "1. Contratar Profesores\n"
                + "2. Buscar cursos\n"
                + "3. Asignar cursos\n"
                + "4. \n"
                + "5. Volver al Menu principal\n";

    }//fin menu de contratar 

    public String MenuCRUDPagos() {
        return "MENU ARCHIVO PAGOS\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un Pago\n"
                + "3. Mostrar todos los pagos\n"
                + "4. \n"
                + "5. Volver al Menu anterior\n";

    }//fin menu de crud de pagos

    public String MenuCRUDEstudiantes() {
        return "MENU ARCHIVO ESTUDIANTES\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un Estudiante\n"
                + "3. Mostrar todos los Estudiantes\n"
                + "4. \n"
                + "5. Volver al Menu anterior\n";

    }//fin menu de crud de estudiantes

    public String MenuCRUDProfesores() {
        return "MENU ARCHIVO PROFESORES\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un Profesores\n"
                + "3. Mostrar todos los Profesores\n"
                + "4. \n"
                + "5. Volver al Menu anterior\n";

    }//fin menu de crud de Profesores

    public String MenuCRUDAcudientes() {
        return "MENU ARCHIVO ACUDIENTES\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un Acudiente\n"
                + "3. Mostrar todos los Acudientes\n"
                + "4. \n"
                + "5. Volver al Menu anterior\n";

    }//fin menu de crud de Acudientes

    public String MenuCRUDCursos() {
        return "MENU ARCHIVO CURSOS\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un curso\n"
                + "3. Mostrar todos los cursos\n"
                + "4. \n"
                + "5. Volver al Menu anterior\n";

    }//fin menu de crud de cursos

    public String MenuPilaCursos() {
        return "MENU PILA DE CURSOS\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un curso\n"
                + "3. Mostrar todos los cursos de Pila\n"
                + "4. Desapilar\n"
                + "5. Eliminar un curso\n"
                + "6. \n"
                + "10. Volver al Menu anterior\n";

    }//fin menu de pila de cursos

    public String MenuColaAcudientes() {
        return "MENU COLA DE ACUDIENTES\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un acudiente\n"
                + "3. Mostrar todos los acudiente de Cola\n"
                + "4. Desencolar\n"
                + "5. Eliminar un acudiente\n"
                + "6. \n"
                + "10. Volver al Menu anterior\n";

    }//fin menu de cola de acudientes

    public String MenuListaSimpleProfesores() {
        return "MENU LISTA SIMPLE DE PROFESORES\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un profesor\n"
                + "3. Mostrar todos los  profesores de lista\n"
                + "4. Eliminar un profesor\n"
                + "5. Actualizar un profesor\n"
                + "6. Insertar de primero\n"
                + "7. Insertar de ultimo\n"
                + "8. Insertar antes de un dato referencia\n"
                + "9. Insertar despues de un dato referencia\n"
                + "10. Actualizar el archivo (pasar los datos de la lista al archivo)\n"
                + "11. Pasar el archivo a la lista\n"
                + "12. Organizar ascendentemente la lista de profesores\n"
                + "20. Volver al Menu anterior\n";

    }//fin menu de lista simple profesores

    public String MenuListaDobleEstudiantes() {
        return "MENU LISTA DOBLE DE ESTUDIANTES\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un Estudiante\n"
                + "3. Mostrar todos los  Estudiantes de lista\n"
                + "4. Eliminar un Estudiante\n"
                + "5. Actualizar un Estudiante\n"
                + "6. Insertar de primero\n"
                + "7. Insertar de ultimo\n"
                + "8. Insertar antes de un dato referencia\n"
                + "9. Insertar despues de un dato referencia\n"
                + "10. Actualizar el archivo (pasar los datos de la lista al archivo)\n"
                + "11. Pasar el archivo a la lista\n"
                + "12. Organizar ascendentemente la lista de Estudiantes\n"
                + "20. Volver al Menu anterior\n";

    }//fin menu de lista doble Estudiantes

    public String MenuListaDoblePagos() {
        return "MENU LISTA DOBLE DE PAGOS\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un Pago\n"
                + "3. Mostrar todos los  Pagos de lista\n"
                + "4. Eliminar un Pago\n"
                + "5. Actualizar un Pago\n"
                + "6. Insertar de primero\n"
                + "7. Insertar de ultimo\n"
                + "8. Insertar antes de un dato referencia\n"
                + "9. Insertar despues de un dato referencia\n"
                + "10. Actualizar el archivo (pasar los datos de la lista al archivo)\n"
                + "11. Pasar el archivo a la lista\n"
                + "12. Organizar ascendentemente la lista de Pagos\n"
                + "20. Volver al Menu anterior\n";

    }//fin menu de lista doble de Pagos

    public String MenuMatrizHorarios() {
        return "MENU MATRIZ DE HORARIOS\n\n"
                + "1. Ingresar Datos\n"
                + "2. Consultar un Horario\n"
                + "3. Mostrar todos los horarios disponibles\n"
                + "4. Actualizar un horario\n"
                + "5. \n"
                + "8. Volver al Menu anterior\n";

    }//fin menu de cola de acudientes
}//fin clase academia
