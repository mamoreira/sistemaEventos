package sistemaevento.frame;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistemaevento.dtos.TransporteDTO;
import sistemaevento.plantillas.frame.PlantillaFRM;
import sistemaevento.util.Combobox;
import sistemaevento.util.GenericoDTO;
import sistemaevento.util.InputNumber;
import sistemaevento.util.InputText;

public class TransporteFRM extends PlantillaFRM {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2117883453528839208L;


	private TransporteDTO TransporteFilter;
	private TransporteDTO Transporte;
    private int filaActual;
    private List<TransporteDTO> resultados;
    private InputNumber textFieldId;
    private JTextField textFieldObservacion;
    private JTextField textFieldPlaca;
    private InputText textFieldDescripcion;
    private Combobox comboboxEstado;
    private JLabel labelId;
    private JLabel labelObservacion;
    private JLabel labelDescripcion;
    private JLabel labelEstado;
    private JLabel labelPlaca;
    

    
	public TransporteFRM(){

	}
	
	/*
	 * INICIALIZA COMPONENTES
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#inicializaComponentes()
	 */
	public void inicializaComponentes() {
		setBackground(new java.awt.Color(102, 51, 255));
		setMinimumSize(new java.awt.Dimension(1000, 599));
		TransporteFilter=new TransporteDTO();
		//****INICIALIZAR COMPONENTES****//
		comboboxEstado = TransporteDTO.EstadoTransporteCombobox();
		textFieldId=new InputNumber(15);
//		textFieldId.setMaximumSize(new Dimension(5,3));
		textFieldObservacion= new JTextField(10);
		textFieldPlaca= new JTextField(10);
		textFieldDescripcion=new InputText(10);
		labelId=new JLabel(         "Id : ");
		labelObservacion=new JLabel(     "Observacion : ");
		labelDescripcion=new JLabel("Descripcion : ");
		labelEstado=new JLabel(     "Estado : ");
		labelPlaca=new JLabel(     "Placa : ");

    }
	
	/*
	 * DEFINIR FILTROS
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#agregarFiltros()
	 */
	public void agregarFiltros(){
		nuevoFiltro(textFieldId,labelId);
		nuevoFiltro(textFieldPlaca, labelPlaca);
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
		columnTableResult.add("Descripcion");
		columnTableResult.add("Placa");
		columnTableResult.add("Observacion");
		columnTableResult.add("Estado");
		columnTableResult.add("Año Compra");
	 }
	
	
	/**
	 * ACCIONES
	 * @throws SQLException 
	 */
    public void accionBuscar(java.awt.event.ActionEvent evt) throws SQLException {   
    	filaActual=0;
        TransporteFilter.setId(textFieldId.getLong());
        TransporteFilter.setPlaca(textFieldPlaca.getText());
        TransporteFilter.setDescripcion(textFieldDescripcion.getText());
        TransporteFilter.setEstadoTransporte(TransporteFilter.StringToEstadoTransporte(comboboxEstado.getSelectedItem().toString()));
        resultados=inventarioG.buscarTransporte(TransporteFilter);
        mostrarTablaResultado(resultados);
        // first commit
        
    }
    private boolean mostrarTablaResultado(List<TransporteDTO> lista) {
        Object [] o={"",""};
        limpiarTabla(tableResultados);
        DefaultTableModel temp = (DefaultTableModel) tableResultados.getModel();
        for (int i = 0; i < 20; i++) {
            if(i<lista.size()){
                temp.addRow(o);
                TransporteDTO dto=lista.get(filaActual);
                tableResultados.setValueAt(dto.getId(),i,0);
                tableResultados.setValueAt(dto.getDescripcion(),i,1);
                tableResultados.setValueAt(dto.getPlaca(),i,2);
                tableResultados.setValueAt(dto.getObservacion(),i,3);
                tableResultados.setValueAt(dto.getEstadoTransporte(),i,4);
                tableResultados.setValueAt(dto.getAnioCompra(),i,5);
                filaActual++;
            }else i=21;
        } 
        tableResultados.setModel(temp);
        return lista.isEmpty();
    } 
    
    /*
    public void accionEditar(ActionEvent evt) throws SQLException{
        if(tableResultados.getSelectedRow()!=-1){
            TransporteNavegateFRM TransporteEditar= new TransporteNavegateFRM();
            Transporte=inventarioG.obtenerTransportePorId((Long) tableResultados.getModel().getValueAt(tableResultados.getSelectedRow(),0));
            TransporteEditar.editarTransporte(Transporte);
        }
        else{
            mensaje.error("No ha seleccionado ningun elemento");
        }
    }
    */
    
    
}
