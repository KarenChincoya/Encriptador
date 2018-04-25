
import Controller.Encriptador;
import GUI.MainFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karen Velasco
 */
public class Main {
    
    public static void main(String[] args) {
        new MainFrame();
        
    }
    public static void maineeee(){
        Encriptador encriptador = new Encriptador();
        
        String direccion = System.getProperty("user.dir"); //user.dir dentro de ENCRIPTADOR muajajajajajaajajajaja
        
         String path = "C:\\Users\\Karen Velasco\\Desktop\\Proyectos POO\\Tareas\\SopaDeLetras\\INPUT.txt" ; 
//         encriptador.EncriptarArchivo(path, "KEY");
         encriptador.EncriptarArchivo(direccion+"\\INPUT.TXT", "KEY");

         
         String path2 = "C:\\Users\\Karen Velasco\\Desktop\\Proyectos POO\\Tareas\\SopaDeLetras\\Encriptacion JAVA\\INPUT.txt";
//         encriptador.DesencriptarArchivo(path2, "KEY");
         encriptador.DesencriptarArchivo(direccion+"\\Encriptacion JAVA\\INPUT.txt", "KEY");
         
         
         Archivo.encriptarArchivo(path, key);
    }
}
