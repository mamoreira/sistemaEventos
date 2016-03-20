/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import sistemaevento.dao.ConfiguracionDAO;
import sistemaevento.dao.ConfiguracionDAOImpl;
import sistemaevento.dtos.GenericoDTO;

/**
 *
 * @author Mayra
 */
public class ComboboxFilter extends JComboBox<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7007826066153275219L;
	protected ConfiguracionDAO configuracionG=new ConfiguracionDAOImpl();
	
	private String  metodoAutoBusqueda;
    public ComboboxFilter(String metodoAutoBusqueda)
    {   
    	this.metodoAutoBusqueda=metodoAutoBusqueda;
    	setEditable(true);
        getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = getEditor().getItem().toString();
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                   if(comparar(cadenaEscrita)){
                	   getList(cadenaEscrita);
                   }else{
                	   getList(getItemAt(0).toString());
                    setSelectedIndex(0);
                    }
                }


                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    setModel(getList(cadenaEscrita));
                    if (getItemCount() > 0) {
                        getEditor().setItem(cadenaEscrita);
                        showPopup();                     

                    } else {
                        addItem(cadenaEscrita);
                    }
                }
            }
        });
    }
    private boolean comparar(String cadena){
    Object [] lista=getComponents();
    boolean encontrado=false;
        for (Object object : lista) {
            if(cadena.equals(object)){
                encontrado=true;
              break;
            }

        }
       return encontrado;
    }
    private DefaultComboBoxModel<String> getList(String cadena) {                                                
    	DefaultComboBoxModel<String> model=new DefaultComboBoxModel<>();
        try {
				List<GenericoDTO> listGenerico=configuracionG.obtenereListElementos(metodoAutoBusqueda,cadena);
	        	for (GenericoDTO generico : listGenerico) {
	        		model.addElement(generico.getDescripcion());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}     
         return model;
    }
    public static void main(String arg[]){
    	JFrame j=new JFrame("DDD");
    	j.add(new ComboboxFilter("auto_busqueda_producto"));
    	j.setVisible(true);
    }
}   