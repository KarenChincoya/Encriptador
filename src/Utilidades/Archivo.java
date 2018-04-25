package Utilidades;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karen
 */
public class Archivo {
    //File file;
    
    public static String leerArchivo(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File file = new File(path);
                
        FileReader reader = new FileReader(file);
        
        String texto = "";
        int caracter = 0;
        char c;
        
        while(caracter!=-1){
            caracter = reader.read();
            
            c = (char) caracter;
            
            if(caracter!=-1)
                texto = texto.concat(String.valueOf(c));
            
        }
        
        return texto;
        
    }
    
    public static File escribirArchivo(String path, String texto) throws FileNotFoundException, IOException{
         
        System.out.println("Funcion escribir archivo recibe una cadena de texto");
        File file = new File(path);
         
          try ( //crear un archivo
                FileWriter writer = new FileWriter(file); //pide un file, input output error
          ) {
            //writer.append("Hola mundo \r\nSalto de linea\r\n");
            writer.append(texto);
          }

        return file;
    }
   
    
  
        public static void encriptarArchivo(String path,String key) throws FileNotFoundException, IOException, ClassNotFoundException, KeyException{
        //debe operar dentro del archivo
            
        System.out.println("Funcion encriptar ");
        //Transformacion de la clavee
        char[] clave = key.toCharArray();
        //Creacion del file
        File file = new File(path);
        FileReader reader = new FileReader(file);
   
        String contenido = Archivo.leerArchivo(file.getAbsolutePath());
        char[] cadena = contenido.toCharArray();
    
        System.out.println("Caracteres del archivo = "+ cadena.length);
        
        String texto = "";
        int valor;
        int aux;
        int suma;
        char caracter;
                
        //ahora, mientras
        int contadorKey = 0;
            System.out.println("Antes del ciclo que encripta cada caracter");
        for(int i=0; i<cadena.length; i++){
            valor = (int) cadena[i]; //Se puede castear de char a entero
            
            suma = valor + clave[contadorKey];
            System.out.println("    suma = "+suma);
            if(suma<255){
                caracter = (char) suma;
            }else{
                caracter = (char) (suma-255);
            }
            
            System.out.println("    Caracter = "+caracter);
            texto = texto.concat(String.valueOf(caracter));
            
            contadorKey++;
            
            if(! (contadorKey<key.length())){
                contadorKey = 0;
            }
        }
        
        System.out.println(texto);
        
        
        String newPath = Archivo.crearDirectorio(path, "Encriptacion JAVA");
        
        Archivo.escribirArchivo(newPath, texto);
        
        
    }
        
    public static String crearDirectorio(String path, String dirName){//El path es el del archivo
       String keys = "/";
       
       String[] tokens = path.split(keys);
       
       for(int i=0;i<tokens.length;i++){
           System.out.println(tokens[i]);
       }
       
       String pathname = "";
       
       for(int i=0; i < (tokens.length-1) ;i++){
           pathname = pathname.concat("/");
           pathname = pathname.concat(tokens[i]);
           }
        System.out.println(pathname);
               
       String directory = pathname + dirName;
       new File(directory).mkdirs();
       
       //La direccion del directorio llega hasta Encriptacion JAVA, para el archivo, debe tener el mismo nombre 
        System.out.println("Nombre del archivo: "+tokens[tokens.length-1]);
        
        System.out.println("Se ha creado un directorio nuevo: Encriptacion JAVA con el mismo nombre del archivo original");
        System.out.println("Direccion final: "+directory+tokens[tokens.length-1]);
        
        
       return directory+"\\"+tokens[tokens.length-1];
       
    }
    
    public static void desencriptarArchivo(String path,String key) throws FileNotFoundException, IOException, ClassNotFoundException{
        //debe operar dentro del archivo
        
        System.out.println("Funcion desencriptar ");
        //Transformacion de la clavee
        char[] clave = key.toCharArray();
        //Creacion del file
        File file = new File(path);
        FileReader reader = new FileReader(file);
   
        String contenido = Archivo.leerArchivo(file.getAbsolutePath());
        char[] cadena = contenido.toCharArray();
        
        System.out.println("Caracteres del archivo = "+ cadena.length);
        
        String texto = "";
        int valor;
        int aux;
        int suma;
        char caracter;
                
        //ahora, mientras
        int contadorKey = 0;
            System.out.println("Antes del ciclo que encripta cada caracter");
        for(int i=0; i<cadena.length; i++){
            valor = (int) cadena[i]; //Se puede castear de char a entero
            
            suma = valor - clave[contadorKey];
            System.out.println("    suma = "+suma);
            if(suma<0){
                caracter = (char) (suma+255);
            }else{
                caracter = (char) suma;
            }
            
            System.out.println("    Caracter = "+caracter);
            texto = texto.concat(String.valueOf(caracter));
            
            contadorKey++;
            
            if(! (contadorKey<key.length())){
                contadorKey = 0;
            }
        }
        
        System.out.println(texto);
            
        String newPath = Archivo.crearDirectorio(path, "Desencriptacion JAVA");
        
        Archivo.escribirArchivo(newPath, texto);
        
    }
}


