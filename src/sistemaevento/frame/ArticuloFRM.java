package sistemaevento.frame;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistemaevento.dtos.ArticuloDTO;
import sistemaevento.plantillas.frame.PlantillaFRM;
import sistemaevento.util.Combobox;
import sistemaevento.util.GenericoDTO;
import sistemaevento.util.InputNumber;
import sistemaevento.util.InputText;

public class ArticuloFRM extends PlantillaFRM {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1043986676041504683L;

	private ArticuloDTO articuloFilter;
	private ArticuloDTO articulo;
    private int filaActual;
    private List<ArticuloDTO> resultados;
    private InputNumber textFieldId;
    private JTextField textFieldCodigo;
    private InputText textFieldDescripcion;
    private Combobox comboboxEstado;
    private JLabel labelId;
    private JLabel labelCodigo;
    private JLabel labelDescripcion;
    private JLabel labelEstado;
    

    
	public ArticuloFRM(){

	}
	
	/*
	 * INICIALIZA COMPONENTES
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#inicializaComponentes()
	 */
	public void inicializaComponentes() {
		setBackground(new java.awt.Color(102, 51, 255));
		setMinimumSize(new java.awt.Dimension(1000, 599));
		articuloFilter=new ArticuloDTO();
		//****INICIALIZAR COMPONENTES****//
		comboboxEstado = GenericoDTO.EstadoCombobox();
		textFieldId=new InputNumber(18);
//		textFieldId.setMaximumSize(new Dimension(5,3));
		textFieldCodigo=new JTextField(15);
		textFieldDescripcion=new InputText(15);
		labelId=new JLabel(         "Id : ");
		labelCodigo=new JLabel(     "Codigo : ");
		labelDescripcion=new JLabel("Descripcion : ");
		labelEstado=new JLabel(     "Estado : ");

    }
	
	/*
	 * DEFINIR FILTROS
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#agregarFiltros()
	 */
	public void agregarFiltros(){
		nuevoFiltro(textFieldId,labelId);
		nuevoFiltro(textFieldCodigo,labelCodigo);
		nuevoFiltro(textFieldDescripcion,labelDescripcion);
		nuevoFiltro(comboboxEstado,labelEstado);
	}
	
	/*
	 * DEFINIR CABECERA DE TABLA DE RESULTADOS
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#llenarCabeceraTabla()
	 */
	public void llenarCabeceraTabla(){
		columnTableResult=new ArrayList<>();
		columnTableResult.add("Id");
		columnTableResult.add("Estado");
		columnTableResult.add("Codigo");
		columnTableResult.add("Descripcion");
		columnTableResult.add("Stock");
		columnTableResult.add("Costo");
		columnTableResult.add("Cant. en Buen Estado");
	 }
	
	
	/**
	 * ACCIONES
	 * @throws SQLException 
	 */
    public void accionBuscar(java.awt.event.ActionEvent evt) throws SQLException {   
    	filaActual=0;
        articuloFilter.setId(textFieldId.getLong());
        articuloFilter.setCodigo(textFieldCodigo.getText());
        articuloFilter.setDescripcion(textFieldDescripcion.getText());
        articuloFilter.setEstado(GenericoDTO.StringToEstado(comboboxEstado.getSelectedItem().toString()));
        resultados=inventarioG.buscarArticulo(articuloFilter);
        mostrarTablaResultado(resultados);
        
    }
    private boolean mostrarTablaResultado(List<ArticuloDTO> lista) {
        Object [] o={"",""};
        limpiarTabla(tableResultados);
        DefaultTableModel temp = (DefaultTableModel) tableResultados.getModel();
        for (int i = 0; i < 20; i++) {
            if(i<lista.size()){
                temp.addRow(o);
                ArticuloDTO dto=lista.get(filaActual);
                tableResultados.setValueAt(dto.getId(),i,0);
                tableResultados.setValueAt(GenericoDTO.EstadoToString(dto.getEstado()),i,1);
                tableResultados.setValueAt(dto.getCodigo(),i,2);
                tableResultados.setValueAt(dto.getDescripcion(),i,3);
                tableResultados.setValueAt(dto.getStock(),i,4);
                tableResultados.setValueAt(dto.getCosto(),i,5);
                tableResultados.setValueAt(dto.getCantidadBuenEstado(),i,6);
                filaActual++;
            }else i=21;
        } 
        tableResultados.setModel(temp);
        return lista.isEmpty();
    } 
    public void accionEditar(ActionEvent evt) throws SQLException{
        if(tableResultados.getSelectedRow()!=-1){
            ArticuloNavegateFRM articuloEditar= new ArticuloNavegateFRM();
            articulo=inventarioG.obtenerArticuloPorId((Long) tableResultados.getModel().getValueAt(tableResultados.getSelectedRow(),0));
            articuloEditar.editarArticulo(articulo);
        }
        else{
            mensaje.error("No ha seleccionado ningun elemento");
        }
    }
}
