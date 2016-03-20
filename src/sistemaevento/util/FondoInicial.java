/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaevento.util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class FondoInicial extends JPanel{
    private Image fondo;
    
    public FondoInicial(){
    
        fondo = new ImageIcon(getClass().getResource("/Imagenes/fondo_gig4.jpg")).getImage();

    
    }
       @Override
    public void paint(Graphics g) {
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
        } else {
            setOpaque(true);
        }

        super.paint(g);
    }



}




