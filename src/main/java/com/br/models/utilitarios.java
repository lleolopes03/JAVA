/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.models;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class utilitarios {
    
    public void LimpaTela(JPanel container){
        Component components[]=container.getComponents();
        for(Component component : components){
            if(component instanceof JTextField){
            ((JTextField)component).setText(null);
        }
            
        }
    }
    
}
