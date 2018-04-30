/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.processing.FilerException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class PasswordDialog extends JDialog {

    private JButton aceptar;
    private JButton cancelar;
    private JTextField password;
    private JLabel instrucciones;

    private PasswordListener listener;

    public PasswordDialog(JFrame parent) {
        super(parent, "Password", true);
        super.setSize(200, 200);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());

        instrucciones = new JLabel("Input the password (min. Lenght = 3)");
        password = new JTextField();//password
        password.setPreferredSize(new Dimension(100,30));

        aceptar = new JButton("Aceptar");
        
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                listener.onBtnClick(); //To change body of generated methods, choose Tools | Templates.                    
                
                //PasswordDialog.this.setVisible(false);//cierra la ventana                                     
            }
        });

        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordDialog.this.setVisible(false);//cierra la ventana 
            }
        });

        super.add(instrucciones);
        super.add(password);
        super.add(aceptar);
        super.add(cancelar);
    }

    public void setPasswordListener(PasswordListener listener) {
        this.listener = listener;
    }

    public String getKey() {
        return password.getText();
    }
}
