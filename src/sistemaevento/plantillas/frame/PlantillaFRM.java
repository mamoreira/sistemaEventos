package sistemaevento.plantillas.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistemaevento.run.MenuPrincipalFRM;
import sistemaevento.util.MensajeLbl;

public class PlantillaFRM extends AbstractFRM {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3633473789439841695L;
	
	private javax.swing.JButton buttonAnterior;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JButton buttonPrimero;
    private javax.swing.JButton buttonSiguiente;
    private javax.swing.JButton buttonUltimo;
    protected javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollPanelTable;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField paginacionTxt;
    private javax.swing.JPanel panelBotonesTabla;
    protected javax.swing.JTable tableResultados;
	private JPanel panelLbl;
	private JPanel panelComp;
    private JScrollPane scrollPaneFiltros;
    protected static MensajeLbl mensaje;
    protected Object[][] dataTableResult;

    protected List<String> columnTableResult;
    public PlantillaFRM() {
    	initComponents();
    }
    private void initComponents() {
        panelPrincipal = new javax.swing.JPanel();
        buttonBuscar = new javax.swing.JButton();
        buttonNuevo = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        panelBotones=new javax.swing.JPanel();
        panelFiltros = new javax.swing.JPanel();
        panelResultados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        scrollPanelTable = new javax.swing.JScrollPane();
        tableResultados = new javax.swing.JTable();
        panelBotonesTabla = new javax.swing.JPanel();
        paginacionTxt = new javax.swing.JTextField(5);
        buttonSiguiente = new javax.swing.JButton();
        buttonAnterior = new javax.swing.JButton();
        buttonUltimo = new javax.swing.JButton();
        buttonPrimero = new javax.swing.JButton();
        scrollPaneFiltros = new JScrollPane();
        panelLbl=new javax.swing.JPanel();
        panelComp=new javax.swing.JPanel();
        inicializaComponentes();
        
        paginacionTxt.setEditable(false);
        setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth(), MenuPrincipalFRM.tabPanel.getHeight()));
        setLayout(new BorderLayout());
		 panelLbl.setLayout(new BoxLayout(panelLbl,BoxLayout.Y_AXIS));
		 panelComp.setLayout(new BoxLayout(panelComp,BoxLayout.Y_AXIS));
        panelResultados.setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth()-330, MenuPrincipalFRM.tabPanel.getHeight()-200));
        panelResultados.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultado de Busqueda")); 
        panelFiltros.setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth()-820, MenuPrincipalFRM.tabPanel.getHeight()-200));
        panelFiltros.setLayout(new FlowLayout(FlowLayout.LEADING));
        scrollPaneFiltros.setBorder(BorderFactory.createTitledBorder("Filtros de Busqueda"));
        scrollPaneFiltros.setViewportView(panelFiltros);
        panelBotones.setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth(), 60));
        panelBotones.setLayout(new FlowLayout(FlowLayout.LEADING));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Acciones"));
        panelBotonesTabla.setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth()-330, 50));
        panelBotonesTabla.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        MenuPrincipalFRM.tabPanel.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth(), MenuPrincipalFRM.tabPanel.getHeight()));
                panelBotonesTabla.setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth()-panelFiltros.getWidth()
                		, panelBotonesTabla.getHeight()));
                panelResultados.setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth()-330, MenuPrincipalFRM.tabPanel.getHeight()-200));
                scrollPanelTable.setPreferredSize(panelResultados.getPreferredSize());
                panelBotonesTabla.setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth()-330, 50));
//                if(panelFiltros.getPreferredSize().getWidth()>225 || MenuPrincipalFRM.tabPanel.getWidth()>1034){
//                	panelFiltros.setPreferredSize(new java.awt.Dimension(MenuPrincipalFRM.tabPanel.getWidth()-850, MenuPrincipalFRM.tabPanel.getHeight()-200));
//                }
                System.out.println(MenuPrincipalFRM.tabPanel.getWidth()-850+":"+ MenuPrincipalFRM.tabPanel.getWidth());
            }
        });
        
        buttonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar_icon.png"))); // NOI18N
        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					accionBuscar(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        buttonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo_icon.png"))); // NOI18N
        buttonNuevo.setText("Nuevo");
        buttonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionNuevo(evt);
            }
        });

        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar_icon.png"))); // NOI18N
        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					accionEditar(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        buttonSiguiente.setText(">");
        buttonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });

        buttonAnterior.setText("<");
        buttonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnteriorActionPerformed(evt);
            }
        });

        buttonUltimo.setText(">>");

        buttonPrimero.setText("<<");
        buttonPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrimeroActionPerformed(evt);
            }
        });
        
        panelBotones.add(buttonBuscar);
        panelBotones.add(buttonEditar);
        panelBotones.add(buttonNuevo);
        
        panelBotonesTabla.add(buttonPrimero);
        panelBotonesTabla.add(buttonAnterior);
        panelBotonesTabla.add(paginacionTxt);
        panelBotonesTabla.add(buttonSiguiente);
        panelBotonesTabla.add(buttonUltimo);
        
        agregarFiltros();
        
        llenarCabeceraTabla();
        setTableModel();
        tableResultados.setAutoscrolls(false);
        tableResultados.setFillsViewportHeight(true);
        tableResultados.setPreferredSize(panelResultados.getPreferredSize());
        scrollPanelTable.setPreferredSize(panelResultados.getPreferredSize());
        scrollPanelTable.setViewportView(tableResultados);
 		panelFiltros.add(panelLbl);
 		panelFiltros.add(panelComp);
        panelResultados.add(scrollPanelTable);
        panelResultados.add(panelBotonesTabla);
        mensaje=new MensajeLbl();mensaje.setText("hojjjjjj");
        mensaje.setBounds(2,540,900,40);
        panelPrincipal.add(mensaje);
        //Agregar paneles a tab
        add(panelBotones,BorderLayout.NORTH);
        add(scrollPaneFiltros,BorderLayout.WEST);
        add(panelResultados,BorderLayout.CENTER);
        add(mensaje,BorderLayout.SOUTH);
      

        
	  	
   }
   
   private void setTableModel() {
	   if( columnTableResult== null)
		   return;
	   tableResultados.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            },
	            columnTableResult.toArray()
	        ) {

				/**
				 * 
				 */
				private static final long serialVersionUID = 375743800090126721L;
//	            boolean[] canEdit = new boolean [] {
//	                false, false, false, false, false, false, false, false, false
//	            };
//
//	            public Class getColumnClass(int columnIndex) {
//	                return types [columnIndex];
//	            }

//	            public boolean isCellEditable(int rowIndex, int columnIndex) {
//	                return canEdit [columnIndex];
//	            }
	        });
		
	}
protected void inicializaComponentes() {
		
	}
   protected void agregarFiltros(){

   }
    
   protected void llenarCabeceraTabla(){
	
   }
    protected void buttonPrimeroActionPerformed(ActionEvent evt) {                                              
    	
    }                                             

    protected void buttonSiguienteActionPerformed(ActionEvent evt) {                                                

    }                                               

    protected void buttonAnteriorActionPerformed(ActionEvent evt) {                                               
       
    }                                              

    protected void accionBuscar(java.awt.event.ActionEvent evt) throws SQLException {                                             
    
    }
    protected void accionNuevo(ActionEvent evt) {                                            
		
	}
    protected void accionEditar(ActionEvent evt) throws SQLException {                                             
    
    }
    public void nuevoFiltro(Component componente,JLabel descripcion){
		panelLbl.add(descripcion);
		panelLbl.add(Box.createVerticalStrut(10));
		panelComp.add(componente);
		panelComp.add(Box.createVerticalStrut(5));
    }
	public static void limpiarTabla(JTable tabla){

		  try {
		      DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
		      int filas=tabla.getRowCount();
		      for (int i = 0;filas>i; i++) {
		          modelo.removeRow(0);
		      }
		  } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
		  }
	}

}
