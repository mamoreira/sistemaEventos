package sistemaevento.frame;

import javax.swing.JLabel;
import javax.swing.JTextField;

import sistemaevento.plantillas.frame.PlantillaFRM;

public class UsuarioFRM extends PlantillaFRM {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1043986676041504683L;

	public UsuarioFRM(){
		setSize(400,330);
		setLocationRelativeTo(null);
	}
	
	
	
	public void agregarFiltros(){
		nuevoFiltro(new JTextField(20),new JLabel("id: "));
	}
	
}
