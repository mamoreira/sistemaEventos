package sistemaevento.plantillas.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlantillaNavegateFRM extends AbstractFRM {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7068637637336498231L;
	private javax.swing.JButton buttonGuardar;
    private javax.swing.JButton buttonLimpiar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JPanel panelBotones;
    protected javax.swing.JPanel panelComponentes;
    protected javax.swing.JPanel panelDescripcion;
    protected javax.swing.JPanel panelDatos;
    private javax.swing.JScrollPane scrollPanel;
	private JPanel panelLbl;
	private JPanel panelComp;
    protected String titulo;
    
    public PlantillaNavegateFRM() {
        initComponents();
    }
    public void initComponents(){
         buttonLimpiar = new javax.swing.JButton();
         buttonGuardar = new javax.swing.JButton();
         buttonEliminar = new javax.swing.JButton();
         panelComponentes = new javax.swing.JPanel();
         panelBotones = new javax.swing.JPanel();
         panelDescripcion=new javax.swing.JPanel();
         panelDatos = new javax.swing.JPanel();
         panelLbl=new javax.swing.JPanel();
         panelComp=new javax.swing.JPanel();
         scrollPanel=new JScrollPane();
         inicializarExtraComponentes();
         setTitle(titulo);
         this.setSize(new Dimension(400,400) );
         this.setLayout(new BorderLayout());
         
         panelBotones.setPreferredSize(new Dimension(300,60));
         panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));
         panelBotones.setBorder(BorderFactory.createTitledBorder("Acciones")); 
         panelDatos.setLayout(new FlowLayout(FlowLayout.CENTER));
         scrollPanel.setBorder(BorderFactory.createTitledBorder("Datos")); 
         panelComponentes.setLayout(new FlowLayout(FlowLayout.LEFT));
         panelDescripcion.setLayout(new FlowLayout(FlowLayout.LEFT));
 		 panelLbl.setLayout(new BoxLayout(panelLbl,BoxLayout.Y_AXIS));
 		 panelComp.setLayout(new BoxLayout(panelComp,BoxLayout.Y_AXIS));
 		 scrollPanel.setPreferredSize(panelDatos.getPreferredSize());
 		 
         buttonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar_icon.png"))); // NOI18N
         buttonGuardar.setText("Guardar");
         buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
 					accionGuardar();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
             }
         });
         buttonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar_icon.png"))); // NOI18N
         buttonLimpiar.setText("Limpiar");
         buttonLimpiar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
 					accionLimpiar();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
             }
         });
         buttonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_icon.png"))); // NOI18N
         buttonEliminar.setText("Eliminar");
         buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
 					accionEliminar();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
             }
         });
 		panelDatos.add(panelLbl);
 		panelDatos.add(panelComp);
 		scrollPanel.setViewportView(panelDatos);
        panelBotones.add(buttonGuardar);
        panelBotones.add(buttonLimpiar);
        panelBotones.add(buttonEliminar);
        add(panelBotones,BorderLayout.NORTH);
        add(scrollPanel,BorderLayout.CENTER);
        setLocationRelativeTo(null);

    }
	protected void accionEliminar() throws SQLException{
		// TODO Auto-generated method stub
		
	}
	protected void accionLimpiar()throws SQLException {
		// TODO Auto-generated method stub
		
	}
	protected void accionGuardar() throws SQLException{
		
	}
	protected void inicializarExtraComponentes() {
		
	}
	public void nuevoComponente(JLabel descripcion,Component componente){
		panelLbl.add(descripcion);
		panelLbl.add(Box.createVerticalStrut(10));
		panelComp.add(componente);
		panelComp.add(Box.createVerticalStrut(5));
	}
}
