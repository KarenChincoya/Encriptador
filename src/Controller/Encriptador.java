package Controller;


import Utilidades.Archivo;
import Utilidades.KeyException;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karen Velasco
 */
//
public class Encriptador {
    public void EncriptarArchivo(String path, String key) throws IOException, FileNotFoundException, ClassNotFoundException, KeyException {
        //Archivo archivo = new Archivo();
        
//        String path = "C:\\Users\\Karen Velasco\\Desktop\\Proyectos POO\\Tareas\\SopaDeLetras\\INPUT.txt" ; //Java no crea directorios
        
        
      
//        String path2 = "C:\\Users\\Karen Velasco\\Desktop\\Proyectos POO\\Tareas\\SopaDeLetras\\Encriptacion JAVA\\INPUT.txt"; //Java no crea directorios
        
    }
    
    public void DesencriptarArchivo(String path, String key) throws IOException, FileNotFoundException, ClassNotFoundException{
        //Archivo archivo = new Archivo();
        Archivo.desencriptarArchivo(path, key);
    }
}
