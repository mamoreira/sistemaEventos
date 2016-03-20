/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.util;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Mayra
 */
public class MensajeLbl extends JLabel{

    public MensajeLbl() {
    }
    public void error(String mensaje){
        this.setFont(new java.awt.Font("Arial", 1, 14));
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/error_icon.png")));
        this.setForeground(Color.RED);
        this.setText(mensaje);
    }
    public void info(String mensaje){
        this.setFont(new java.awt.Font("Arial", 1, 14));
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/info_icon.png")));
        this.setForeground(Color.BLUE);
        this.setText(mensaje);
    }
    public void succes(String mensaje){
        this.setFont(new java.awt.Font("Arial", 1, 14));
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/success_icon.png")));
        this.setForeground(Color.BLACK);
        this.setText(mensaje);
    }
   
    public void warning(String mensaje){
        this.setFont(new java.awt.Font("Arial", 1, 14));
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/warning_icon.png")));
        this.setForeground(Color.YELLOW);
        this.setText(mensaje);
    }
}
