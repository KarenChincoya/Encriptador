/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Archivo;
import Utilidades.FileChooser;
import Utilidades.KeyException;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.FilerException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Karen Velasco
 */
public class MainFrame extends JFrame {

    PanelPrincipal panel;
    PasswordDialog passwordDialog;

    String path;

    public MainFrame() {
        super("Encriptador");
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 400);

        panel = new PanelPrincipal();

        panel.setListener(new PanelPrincipalListener() {

            @Override
            public void onBtnClick(Integer n) {

                System.out.println("Panel principal listener -> OnBtnClick ");
                System.out.println("n = " + n);

                System.out.println("Lectura del archivo");

                path = FileChooser.getFilePath();

                System.out.println("Creacion del passwordDialog");

                passwordDialog = new PasswordDialog(MainFrame.this);

                passwordDialog.setVisible(true);

                passwordDialog.setPasswordListener(new PasswordListener(){
                    @Override
                    public void onBtnClick(){//si hay que agregar
                        if (passwordDialog.getKey().length() < 3) {//otra vez la ventana de texto
                            JOptionPane.showMessageDialog(passwordDialog, "The mininum leght for the password is 3",
                                    "Inane error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            
                            try {
                                System.out.println("Password Listener");
                                System.out.println("Path: " + path);
                                System.out.println("Key: " + passwordDialog.getKey());

                                if (n == 1) {
                                    Archivo.encriptarArchivo(path, passwordDialog.getKey());
                                } else {
                                    Archivo.desencriptarArchivo(path, passwordDialog.getKey());
                                }
                            } catch (Exception e) {
                                System.out.println("Hubo un error en la lectura");
                                e.printStackTrace();
                            } 

                        }
                        
                        passwordDialog.setVisible(false);

                    }
                });

            }
        });

        super.add(panel);
        super.setVisible(true);
    }

}
