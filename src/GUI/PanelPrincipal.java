/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Karen Velasco
 */
public class PanelPrincipal extends JPanel{
    private JLabel titulo;
    private JButton encriptar;
    private JButton desencriptar;
    private PanelPrincipalListener listener;
    
    public PanelPrincipal(){
        super();
        super.setLayout(new BoxLayout(PanelPrincipal.this, BoxLayout.Y_AXIS));
        
        System.out.println("Panel principal");
        
        titulo = new JLabel("Encriptador");
        titulo.setText("Encriptador");
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 25));
        titulo.setBackground(Color.BLUE);
        
        encriptar = new JButton("Encriptar");
        encriptar.setBorder(new LineBorder(Color.BLACK));
        
        encriptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick(1); //1 es encriptar
            }
        });
        
        desencriptar = new JButton("Desencriptar");
        desencriptar.setBorder(new LineBorder(Color.BLACK));
        
        desencriptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick(2);
            }
        });
        
        super.add(titulo);
        super.add(encriptar);
        super.add(desencriptar);
    }
    
    public void setListener(PanelPrincipalListener listener){
        this.listener = listener;
    }
}
