package sistemaevento.frame;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

import sistemaevento.dtos.ArticuloDTO;
import sistemaevento.plantillas.frame.PlantillaNavegateFRM;
import sistemaevento.util.Combobox;
import sistemaevento.util.GenericoDTO;

public class ArticuloNavegateFRM extends PlantillaNavegateFRM{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4785599002381634767L;

	    private ArticuloDTO articulo;
	    private JTextField textFieldId;
	    private JTextField textFieldCodigo;
	    private JTextField textFieldDescripcion;
	    private JTextField textFieldStock;
	    private JTextField textFieldCosto;
	    private JTextField textFieldPrecioAlquiler;
	    private JTextField textFieldCantidadReparacion;
	    private Combobox comboboxEstado;
	    private JLabel labelId;
	    private JLabel labelCodigo;
	    private JLabel labelDescripcion;
	    private JLabel labelStock;
	    private JLabel labelCosto;
	    private JLabel labelPrecioAlquiler;
	    private JLabel labelCantidadReparacion;
	    private JLabel labelEstado;
	    
	public ArticuloNavegateFRM(){
        
	}
	
	public void inicializarExtraComponentes(){
	        articulo=new ArticuloDTO();
	         //****INICIALIZAR COMPONENTES****//
	        titulo="Nuevo Articulo";
	        comboboxEstado = GenericoDTO.EstadoCombobox();
	        textFieldId=new JTextField(19);
	        textFieldStock=new JTextField(19);
	        textFieldCantidadReparacion=new JTextField(19);
	        textFieldPrecioAlquiler=new JTextField(19);
	        textFieldCodigo=new JTextField(19);
	        textFieldDescripcion=new JTextField(19);
	        textFieldCosto=new JTextField(19);
	        labelId=new JLabel("Id* ");
	        labelStock=new JLabel("Stock* ");
	        labelCantidadReparacion=new JLabel("Cant. Reparacion ");
	        labelCosto=new JLabel("Costo ");
	        labelCodigo=new JLabel("Codigo    ");
	        labelDescripcion=new JLabel("Descripcion    ");
	        labelEstado=new JLabel("Estado*    ");
	        labelPrecioAlquiler=new JLabel("Precio Alquier ");

	        //****AGREGAR COMPONENTES****//
	        nuevoComponente(labelId,textFieldId);
	        nuevoComponente(labelCodigo,textFieldCodigo);
	        nuevoComponente(labelStock,textFieldStock);
	        nuevoComponente(labelDescripcion,textFieldDescripcion);
	        nuevoComponente(labelCantidadReparacion,textFieldCantidadReparacion);
	        nuevoComponente(labelPrecioAlquiler,textFieldPrecioAlquiler);
	        nuevoComponente(labelCosto,textFieldCosto);
	        nuevoComponente(labelEstado,comboboxEstado);
     
	        textFieldId.setText("0");
	        textFieldId.setEnabled(false);

	}
	public void editarArticulo(ArticuloDTO articulo) {
         textFieldId.setText(GenericoDTO.LongToString(articulo.getId()));
         textFieldStock.setText(articulo.getStock().toString());  
         textFieldCodigo.setText(articulo.getCodigo());
         textFieldDescripcion.setText(articulo.getDescripcion());
         textFieldCosto.setText(articulo.getCosto().toPlainString());
         textFieldPrecioAlquiler.setText(articulo.getPrecioAlquiler().toPlainString());
         textFieldCantidadReparacion.setText(articulo.getCantidadReparacion().toString());
         comboboxEstado.setSelectItem(GenericoDTO.Estado.A);   
         
         //RESTRINCCIONES
         textFieldId.setEnabled(false);
         textFieldStock.setEnabled(false);
         setVisible(true);
		
	}
}
