package sistemaevento.plantillas.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sistemaevento.run.MenuPrincipalFRM;

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
         inicializarExtraComponentes();
         setTitle(titulo);
         this.setSize(new Dimension(400,400) );
         this.setLayout(new BorderLayout());
         panelBotones.setPreferredSize(new Dimension(300,60));
         panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));
         panelBotones.setBorder(BorderFactory.createTitledBorder("Acciones")); 
         panelDatos.setLayout(new FlowLayout(FlowLayout.LEFT));
         panelDatos.setBorder(BorderFactory.createTitledBorder("Datos")); 
         panelComponentes.setLayout(new FlowLayout(FlowLayout.LEFT));
         panelDescripcion.setLayout(new FlowLayout(FlowLayout.LEFT));
         
         
         buttonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar_icon.png"))); // NOI18N
         buttonGuardar.setText("Guardar");
         buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 try {
// 					accionBuscar(evt);
// 				} catch (SQLException e) {
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				}
             }
         });
         buttonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar_icon.png"))); // NOI18N
         buttonLimpiar.setText("Limpiar");
         buttonLimpiar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 try {
// 					accionBuscar(evt);
// 				} catch (SQLException e) {
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				}
             }
         });
         buttonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar_icon.png"))); // NOI18N
         buttonEliminar.setText("Eliminar");
         buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 try {
// 					accionBuscar(evt);
// 				} catch (SQLException e) {
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				}
             }
         });
         panelBotones.add(buttonGuardar);
         panelBotones.add(buttonLimpiar);
         panelBotones.add(buttonEliminar);
         add(panelBotones,BorderLayout.NORTH);
         add(panelDatos,BorderLayout.CENTER);
         setLocationRelativeTo(null);

    }
	protected void inicializarExtraComponentes() {
		
	}
	public void nuevoComponente(JLabel descripcion,Component componente){
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(descripcion,BorderLayout.WEST);
		panel.add(componente,BorderLayout.CENTER);
		panelDatos.add(panel);
	}
}
