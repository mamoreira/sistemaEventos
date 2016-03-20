/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.util;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JTextField;

import sistemaevento.dao.ConfiguracionDAO;
import sistemaevento.dao.ConfiguracionDAOImpl;
import sistemaevento.dtos.GenericoDTO;

/**
 *
 * @author Mayra
 */
public class ComboboxFilter extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7007826066153275219L;
	protected ConfiguracionDAO configuracionG=new ConfiguracionDAOImpl();
	private javax.swing.JScrollPane scrollPanel;
	private javax.swing.JList<String> list;
	private javax.swing.JTextField filter;
	private String  metodoAutoBusqueda;
    public ComboboxFilter(String metodoAutoBusqueda)
    {   
    	scrollPanel=new  javax.swing.JScrollPane();
    	list= new javax.swing.JList<String>();
    	filter= new javax.swing.JTextField();
    	filter.addKeyListener(new java.awt.event.KeyAdapter() {
             public void keyReleased(java.awt.event.KeyEvent evt) {
                 jTextField_ProductoKeyReleased(evt);
             }
         });
    	scrollPanel.setViewportView(list);
    }
    private void jTextField_ProductoKeyReleased(java.awt.event.KeyEvent evt) {                                                
        JTextField j=(JTextField)evt.getSource();
        if(!j.getText().equals("")){ 
			DefaultListModel<String> modelo = new DefaultListModel<String>();
        	try {
				List<GenericoDTO> listGenerico=configuracionG.obtenereListElementos(metodoAutoBusqueda);
	        	for (GenericoDTO generico : listGenerico) {
	        		modelo.addElement(generico.getDescripcion());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}     
            list.setModel(modelo);
            scrollPanel.setVisible(true);
        }else{
        	scrollPanel.setVisible(false);
        }
    }
    
}   