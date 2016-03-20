package sistemaevento.run;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

import sistemaevento.dtos.OpcionDTO;
import sistemaevento.plantillas.frame.AbstractFRM;
import sistemaevento.util.FondoInicial;

public class MenuPrincipalFRM extends AbstractFRM{
	    /**
	 * 
	 */
	private static final long serialVersionUID = -6067100163887189211L;
	
		private JMenuBar barraDeMenu;
	    private JMenu inicio,reportes,ayuda;
	    private ArrayList <JMenu> menus;
	    private ArrayList <JMenuItem> menuItems;
	    private FondoInicial fondo;
	    public static javax.swing.JTabbedPane tabPanel=null;
	    private int CIEN=120;
	    
	    public MenuPrincipalFRM() throws SQLException {
	    	tabPanel = new javax.swing.JTabbedPane();
	        initComponents();
	    }
	    
	    
	    public final void initComponents() throws SQLException{
	    	setLayout(new BorderLayout());
	        setTitle(".::SISTEMA DE EVENTOS");
	        //setLayout(null);
	        Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 
	    	setSize((pantallaTamano.width-100), (pantallaTamano.height-100)); 
	        //setSize(1300,700);        
	        menus=new ArrayList<>();
	        menuItems=new ArrayList<>();
	        fondo=new FondoInicial();
	        llenarMenu();
	        add(barraDeMenu);
	        tabPanel.setBounds(100, 50, pantallaTamano.width-150, pantallaTamano.height-CIEN);
	        fondo.setBounds(0,26, 1300,700);
	        add(tabPanel,BorderLayout.CENTER);
	        add(fondo);
	        setLocationRelativeTo(null);
	        this.addComponentListener(new ComponentAdapter() {
	            public void componentResized(ComponentEvent e) {
	            	Dimension d=getSize();
	            	tabPanel.setBounds(100, 50,d.width-150, d.height-CIEN);
	            }
	        });
	    }

	    private void llenarMenu()  throws SQLException{
	        barraDeMenu=new JMenuBar();
	        barraDeMenu.setBounds(0, 0,1300,25);
	        inicio=new JMenu("Inicio");
	        reportes=new JMenu("Reportes");
	        ayuda=new JMenu("Ayuda");
	        List<OpcionDTO> modulos=configuracionG.obtenerModulos();
	        for (OpcionDTO modulo : modulos) {
	            JMenu subMenu=new JMenu(modulo.getDescripcion());
//	            subMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource(modulo.getRutaImagen())));
	            List<OpcionDTO> opciones=configuracionG.obtenerOpcionesPorModulo(modulo);
	            for (OpcionDTO opcion : opciones) {
	                JMenuItem item=new JMenuItem(opcion.getDescripcion());
	                item.addActionListener(new java.awt.event.ActionListener() {
	                    @Override
	                    public void actionPerformed(java.awt.event.ActionEvent evt) {
	                        obtenerOpcionSeleccionada(opcion);
	                    }
	                });
	          //      item.setIcon(new javax.swing.ImageIcon(getClass().getResource(opcion.getRutaImagen())));
	                subMenu.add(item);
	                menuItems.add(item);
	            }
	            inicio.add(subMenu);
	            menus.add(subMenu);
	        }
	        barraDeMenu.add(inicio);
	        barraDeMenu.add(reportes);
	        barraDeMenu.add(ayuda);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }

	    public void obtenerOpcionSeleccionada(OpcionDTO opcion){
	    	String title=opcion.getDescripcion();        
	    	try {	
	    		if(!validarTapRepetida(title)){
	    			AbstractFRM frame;
	    			JButton buttonCloseTap ;
	    			buttonCloseTap=new JButton("");
	    			buttonCloseTap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close_icon.png")));
	    			buttonCloseTap.setPreferredSize(new Dimension(30,20));
	    			buttonCloseTap.setContentAreaFilled(false);
	    			buttonCloseTap.setBorderPainted(false);
					frame = (AbstractFRM) Class.forName(opcion.getObjeto()).newInstance();
					frame.setOpcion(opcion);
		            tabPanel.addTab(title,null, frame.getContentPane());
		    		buttonCloseTap.addActionListener(new java.awt.event.ActionListener() {
		  	          public void actionPerformed(java.awt.event.ActionEvent evt) {
		  	              removeTap(opcion.getDescripcion());
		  	          }
		  	        });
		            JPanel pnl = new JPanel();
		            pnl.setOpaque(false);
		            JLabel label=new JLabel(title);
		            pnl.add(label);
		            pnl.add(buttonCloseTap);
		            tabPanel.setTabComponentAt(tabPanel.getTabCount() - 1, pnl);
		            tabPanel.setSelectedIndex(tabPanel.getTabCount() - 1);
	        }else{
	            tabPanel.setSelectedIndex(obtenerIndiceTap(title));
	        }
	        } catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }
	    
	    public boolean removeTap(String title) {
	        int i = tabPanel.getTabCount();
	        for (int index = 0; index < i; index++) {
	            String temp = tabPanel.getTitleAt(index);
	            if (temp.equals(title)) {
	                tabPanel.removeTabAt(index);
	                return true;
	            }
	        }
	        return false;
	    }

	    public boolean validarTapRepetida(String title) {
	        int i = tabPanel.getTabCount();
	        for (int index = 0; index < i; index++) {
	            String temp = tabPanel.getTitleAt(index);
	            if (temp.equals(title)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	     public int obtenerIndiceTap(String title) {
	        int i = tabPanel.getTabCount();
	        for (int index =0; index < i; index++) {
	            String temp = tabPanel.getTitleAt(index);
	            if (temp.equals(title)) {
	                return index;
	            }
	        }
	        return -1;
	    }


		public javax.swing.JTabbedPane getTabPanel() {
			return tabPanel;
		}
	    

}
