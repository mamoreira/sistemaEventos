/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.util;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Mayra
 */
public class Combobox extends JComboBox<Object>{
    
    public Combobox( int numeroItems,ArrayList<String> lista,int ancho,int alto,String[]rutas)
    {   
        Dimension d = new Dimension(ancho,alto);
        this.setSize(d);
        this.setPreferredSize(d);
        //Indices para las imagenes
        for( int i=0; i<numeroItems; i++)
        {
            this.addItem(lista.get(i));
        }   
        ComboboxRenderer render = new ComboboxRenderer( rutas,lista );
        this.setRenderer(render);      
        this.setVisible(true);
    }

    public int setSelectItem(GenericoDTO.Estado estado){
        if(estado.equals(GenericoDTO.Estado.A))
            return 1;
        else {
          if(estado.equals(GenericoDTO.Estado.I))
            return 2;
          else
            return 0;
        }    
    } 
//    public int setSelectItem(UsuarioDTO.Rol rol){
//        if(rol.isSecretaria())
//            return 0;
//        else {
//          if(rol.isBodeguero())
//            return 1;
//          else
//            return 2;
//        }    
//    } 
//        public int setSelectItem(TransporteDTO.EstadoTransporte estado){
//        if(estado.equals(TransporteDTO.EstadoTransporte.A))
//            return 1;
//        else {
//          if(estado.equals(TransporteDTO.EstadoTransporte.P))
//            return 2;
//          else
//            return 3;
//        }
//            
//    } 
}

 class ComboboxRenderer  extends JLabel implements ListCellRenderer{

      /** Para guardar los iconos por cada item. El item es la clave y el valor
     * es el icono.
     */
     Hashtable<String, ImageIcon> elementos;

    /**
     * Construye el Hashtable con los iconos seleccionados, asociándolos a los
     * items que tendrá el JComboBox "uno", "dos", "tres" y "cuatro"
     */
    public ImageIcon[] items;

    
    public ComboboxRenderer(String[] rutas,ArrayList<String> lista) {
        setOpaque(true);
        items=new ImageIcon[rutas.length];
        elementos = new Hashtable<String, ImageIcon>();
        for (int i=0 ;i<lista.size() ; i++) {
            items[i]=  new ImageIcon(getClass().getResource(rutas[i]));
            elementos.put(lista.get(i), items[i]);
        }
    }

    /**
     * En función del value que se pasa (el item del JComboBox), se pone el icono
     * y se devuelve el JLabel.
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value,int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) 
        {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        if(elementos.get(value)!=null){
            setIcon(elementos.get(value));
            setText(""+value);
        }else{
     // setIcon(imgnull);
        }
        return this;
    }
    
}   