/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utilidades.Archivo;
import Utilidades.FileChooser;
import Utilidades.KeyException;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author Karen Velasco
 */
public class MainFrame extends JFrame{
    PanelPrincipal panel;
    PasswordDialog passwordDialog;
    
    String path; 
    
    public MainFrame(){
        super("Encriptador");
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 400);
        
        panel = new PanelPrincipal();     
        
        panel.setListener(new PanelPrincipalListener() {
            
            @Override
            public void onBtnClick(Integer n) {
                
                System.out.println("Panel principal listener -> OnBtnClick ");
                System.out.println("n = "+n);
                
                System.out.println("Lectura del archivo");
                path = FileChooser.getFilePath();
                
                System.out.println("Creacion del passwordDialog");
                
                passwordDialog = new PasswordDialog(MainFrame.this);
                
                passwordDialog.setVisible(true);
                
                passwordDialog.setPasswordListener(new PasswordListener() {
                    @Override
                    public void onBtnClick() {//si hay que agregar
                        System.out.println("Password Listener");
                        if(n==1){
                            //encriptar
                            try{
                                Archivo.encriptarArchivo(path, passwordDialog.getKey());                            
                            }catch(Exception e){
                                System.out.println("ERROR.");
                            }
                            
                        }else{
                            Archivo.desencriptarArchivo(path, passwordDialog.getKey());
                        
                        }
                    }
                });
                
                
            }
        });
        
        super.add(panel);
        super.setVisible(true);
    }
    
}
