package sistemaevento.plantillas.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlantillaTransaccionFRM extends AbstractFRM {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2327812023917579154L;
	private javax.swing.JButton buttonGuardar;
    private javax.swing.JButton buttonProcesar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelFooter;
    protected javax.swing.JPanel panelCabecera;
    protected javax.swing.JPanel panelDetalle;
    private javax.swing.JScrollPane scrollPanel;
    protected String titulo;
    
    public PlantillaTransaccionFRM() {
        initComponents();
    }
    public void initComponents(){
    	 buttonProcesar = new javax.swing.JButton();
         buttonGuardar = new javax.swing.JButton();
         buttonEliminar = new javax.swing.JButton();
         panelBody = new javax.swing.JPanel();
         panelBotones = new javax.swing.JPanel();
         panelFooter=new javax.swing.JPanel();
         panelDetalle = new javax.swing.JPanel();
        
         scrollPanel=new JScrollPane();
         inicializarExtraComponentes();
         setTitle(titulo);
         this.setSize(new Dimension(400,400) );
         this.setLayout(new BorderLayout());
         
         panelBotones.setPreferredSize(new Dimension(800,60));
         panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));
         panelBotones.setBorder(BorderFactory.createTitledBorder("Acciones")); 
         panelBody.setLayout(new FlowLayout(BoxLayout.Y_AXIS));
         panelBody.setBorder(BorderFactory.createTitledBorder("Datos")); 
         panelDetalle.setLayout(new BorderLayout());
         panelFooter.setLayout(new FlowLayout(FlowLayout.LEFT));
 		 
         buttonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar_icon.png"))); // NOI18N
         buttonGuardar.setText("Guardar");
         buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
 					accionGuardar();
 				} catch (SQLException e) {
 					e.printStackTrace();
 				}
             }
         });
         buttonProcesar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar_icon.png"))); // NOI18N
         buttonProcesar.setText("Limpiar");
         buttonProcesar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
 					accionLimpiar();
 				} catch (SQLException e) {
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
        panelBotones.add(buttonGuardar);
        panelBotones.add(buttonProcesar);
        panelBotones.add(buttonEliminar);
        add(panelBotones,BorderLayout.NORTH);
        add(panelBody,BorderLayout.CENTER);
        add(panelFooter,BorderLayout.SOUTH);
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
	public void addComponentHeader(JLabel descripcion,Component componente){
		
	}
	public void addComponentFooter(JLabel descripcion,Component componente,JPanel panel){
		
	}
}
