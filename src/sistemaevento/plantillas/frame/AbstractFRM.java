package sistemaevento.plantillas.frame;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import sistemaevento.dao.ConfiguracionDAO;
import sistemaevento.dao.ConfiguracionDAOImpl;
import sistemaevento.dao.FacturacionDAO;
import sistemaevento.dao.FacturacionDAOImpl;
import sistemaevento.dao.InventarioDAO;
import sistemaevento.dao.InventarioDAOImpl;
import sistemaevento.dtos.OpcionDTO;

public class AbstractFRM extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2606256832924224004L;
	
	protected ConfiguracionDAO configuracionG=new ConfiguracionDAOImpl();
	protected FacturacionDAO facturacionG=new FacturacionDAOImpl();
	protected InventarioDAO inventarioG=new InventarioDAOImpl();
	
    protected javax.swing.JPanel panelFiltros;
    protected javax.swing.JPanel panelResultados;
    protected javax.swing.JPanel panelBotones;
    
	private OpcionDTO opcion;
	
	
	public AbstractFRM(){	
		

			
	}
	public OpcionDTO getOpcion() {
		return opcion;
	}


	public void setOpcion(OpcionDTO opcion) {
		this.opcion = opcion;
	}
	
	
}
