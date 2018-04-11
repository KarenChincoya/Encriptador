
import Controller.Encriptador;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Encriptador encriptador = new Encriptador();
        
         String path = "C:\\Users\\Karen Velasco\\Desktop\\Proyectos POO\\Tareas\\SopaDeLetras\\INPUT.txt" ; 
         encriptador.EncriptarArchivo(path, "KEY");
         
         String path2 = "C:\\Users\\Karen Velasco\\Desktop\\Proyectos POO\\Tareas\\SopaDeLetras\\Encriptacion JAVA\\INPUT.txt";
         encriptador.DesencriptarArchivo(path2, "KEY");
    }
}
