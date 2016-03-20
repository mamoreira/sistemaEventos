package sistemaevento.run;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sistemaevento.dtos.UsuarioDTO;
import sistemaevento.plantillas.frame.AbstractFRM;
import sistemaevento.util.Fecha;

public class RunFRM extends AbstractFRM{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3802081358912913692L;
	
	/** DECLARACION DE VARIABLES  **/
    private MenuPrincipalFRM principal;
    private UsuarioDTO usuario;
    private Fecha fechaSesion;

    /** COMPONENTES GRAFICOS **/
    private javax.swing.JButton okBtn;
    private javax.swing.JLabel fechaLbl;
    private javax.swing.JPasswordField claveTxt;
    private javax.swing.JTextField usuarioTxt;
    private javax.swing.JLabel claveLbl;
    private javax.swing.JLabel usuarioLbl;
    private javax.swing.JLabel fondoLbl;
    
    /**
     * Construsctor del programa principal
     * @throws SQLException
     */
    public RunFRM() throws SQLException {//pantalla de login
        setSize(400,330);
        setLayout(null);
        initComponents();
        principal=new MenuPrincipalFRM();//Pantalla Principal
        usuario=new UsuarioDTO();
        fechaLbl.setText(Fecha.getFechaActual());
        setLocationRelativeTo(null);
    }
        
    /** INICIALIZACION DE COMPONENTES GRAFICOS **/
        
    public final void initComponents()throws SQLException{
        usuarioLbl = new javax.swing.JLabel();
        claveLbl = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();
        fechaLbl = new javax.swing.JLabel();
        claveTxt = new javax.swing.JPasswordField();
        fondoLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setResizable(false);
        getContentPane().setLayout(null);

        usuarioLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        usuarioLbl.setForeground(new java.awt.Color(240, 240, 240));
        usuarioLbl.setText("USUARIO:");
        getContentPane().add(usuarioLbl);
        usuarioLbl.setBounds(30, 80, 140, 27);

        claveLbl.setFont(new java.awt.Font("Tahoma", 1, 24));
        claveLbl.setForeground(new java.awt.Color(240, 240, 240));
        claveLbl.setText("CLAVE: ");
        getContentPane().add(claveLbl);
        claveLbl.setBounds(30, 150, 110, 29);
        getContentPane().add(usuarioTxt);
        usuarioTxt.setBounds(190, 80, 174, 34);

        okBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/visto.png")));
        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        getContentPane().add(okBtn);
        okBtn.setBounds(160, 220, 90, 60);

        fechaLbl.setFont(new java.awt.Font("Times New Roman", 1, 18));
        fechaLbl.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(fechaLbl);
        fechaLbl.setBounds(250, 0, 150, 30);

        claveTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                claveTxtKeyPressed(evt);
            }
        });
        getContentPane().add(claveTxt);
        claveTxt.setBounds(190, 140, 180, 30);

        fondoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_gig4.jpg")));
        getContentPane().add(fondoLbl);
        fondoLbl.setBounds(0, 0, 420, 300);

    }
    
    /** LISTENERS **/
    
    @SuppressWarnings("deprecation")
	private void claveTxtKeyPressed(java.awt.event.KeyEvent evt){                                     
      if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            try {
            	usuario.setClave(claveTxt.getText());
            	usuario.setCodigo(usuarioTxt.getText());
				usuario=configuracionG.obtenerUsuario(usuario);
	            if(usuario != null && usuario.getClave() != null && usuario.getCodigo() != null &&
	            		(usuario.getCodigo().equals("") || usuario.getClave().equals(""))){
	                 JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "ERROR INGRESO", JOptionPane.ERROR_MESSAGE);
	                 limpiar();
	            }else{
	                if (usuario == null){
	                    JOptionPane.showMessageDialog(null, "Usuario/Clave no válidos", "ERROR INGRESO", JOptionPane.ERROR_MESSAGE); 
	                }
	                else
	                {
	                    validarRoles();
	                    this.limpiar();
	                    this.setVisible(false);
	                    this.dispose(); //cerrar la ventana
	                    principal.setVisible(true);
	                }
	            }
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
    }
    @SuppressWarnings("deprecation")
	private void okBtnActionPerformed(ActionEvent evt){
            try {
            	usuario.setClave(claveTxt.getText());
            	usuario.setCodigo(usuarioTxt.getText());
				usuario=configuracionG.obtenerUsuario(usuario);
	            if(this.usuarioTxt.getText().equals("") || claveTxt.getText().equals("")){
	                 JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "ERROR INGRESO", JOptionPane.ERROR_MESSAGE);
	                 limpiar();
	            }else{
	                if (usuario == null){
	                    JOptionPane.showMessageDialog(null, "Usuario/Clave no válidos", "ERROR INGRESO", JOptionPane.ERROR_MESSAGE); 
	                }else{
	                    validarRoles();
	                    this.limpiar();
	                    this.setVisible(false);
	                    this.dispose(); //cerrar la ventana
	                    principal.setVisible(true);
	                }
	            }
            } catch (SQLException e) {
				e.printStackTrace();
			}
    }
    
    /** METODOS ADICIONALES  **/
    
    public void limpiar (){
        this.claveTxt.setText("");
        this.usuarioTxt.setText("");
    }
   
    public void validarRoles (){
        
    }
    
    /**
     * METODOS GETTER Y SETTER
     */
    public Fecha getFechaSesion() {
		return fechaSesion;
	}

	public void setFechaSesion(Fecha fechaSesion) {
		this.fechaSesion = fechaSesion;
	}
    
	/**
	 * PROGRAMA PRINCIPAL
	 * @param args
	 */
    public static void main(String args[]) {
        try {
			new RunFRM().setVisible(true);
		} catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexion", "ERROR INGRESO", JOptionPane.ERROR_MESSAGE); 
			e.printStackTrace();
		}
    }

	
}
