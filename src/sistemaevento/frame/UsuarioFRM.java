package sistemaevento.frame;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistemaevento.dtos.UsuarioDTO;
import sistemaevento.plantillas.frame.PlantillaFRM;
import sistemaevento.util.Combobox;
import sistemaevento.util.GenericoDTO;
import sistemaevento.util.InputNumber;
import sistemaevento.util.InputText;

public class UsuarioFRM extends PlantillaFRM {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3816074730854270950L;
	/**
	 * 
	 */

	

	private UsuarioDTO UsuarioFilter;
	private UsuarioDTO Usuario;
    private int filaActual;
    private List<UsuarioDTO> resultados;
    private InputNumber textFieldId;
    private InputText textFieldCodigo;
    private Combobox comboboxEstado;
    private JLabel labelId;
    private JLabel labelCodigo;
    private JLabel labelEstado;
    

    
	public UsuarioFRM(){

	}
	
	/*
	 * INICIALIZA COMPONENTES
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#inicializaComponentes()
	 */
	public void inicializaComponentes() {
		setBackground(new java.awt.Color(102, 51, 255));
		setMinimumSize(new java.awt.Dimension(1000, 599));
		UsuarioFilter=new UsuarioDTO();
		//****INICIALIZAR COMPONENTES****//
		comboboxEstado = GenericoDTO.EstadoCombobox();
		textFieldId=new InputNumber(15);
		textFieldCodigo=new InputText(10);
		labelId=new JLabel("Id : ");
		labelCodigo=new JLabel("Codigo : ");
		labelEstado=new JLabel("Estado : ");

    }
	
	/*
	 * DEFINIR FILTROS
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#agregarFiltros()
	 */
	public void agregarFiltros(){
		nuevoFiltro(textFieldId,labelId);
		nuevoFiltro(textFieldCodigo,labelCodigo);
		nuevoFiltro(comboboxEstado,labelEstado);

	}
	
	/*
	 * DEFINIR CABECERA DE TABLA DE RESULTADOS
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#llenarCabeceraTabla()
	 */
	public void llenarCabeceraTabla(){
		columnTableResult=new ArrayList<>();
		columnTableResult.add("Id");
		columnTableResult.add("Codigo");
		columnTableResult.add("Estado");
	
	 }
	
	
	/**
	 * ACCIONES
	 * @throws SQLException 
	 */
    public void accionBuscar(java.awt.event.ActionEvent evt) throws SQLException {   
    	filaActual=0;
        UsuarioFilter.setId(textFieldId.getLong());
        UsuarioFilter.setCodigo(textFieldCodigo.getText());
        UsuarioFilter.setEstado(GenericoDTO.StringToEstado(comboboxEstado.getSelectedItem().toString()));
        resultados=inventarioG.buscarUsuario(UsuarioFilter);
        mostrarTablaResultado(resultados);
        
    }
    private boolean mostrarTablaResultado(List<UsuarioDTO> lista) {
        Object [] o={"",""};
        limpiarTabla(tableResultados);
        DefaultTableModel temp = (DefaultTableModel) tableResultados.getModel();
        for (int i = 0; i < 20; i++) {
            if(i<lista.size()){
                temp.addRow(o);
                UsuarioDTO dto=lista.get(filaActual);
                tableResultados.setValueAt(dto.getId(),i,0);                
                tableResultados.setValueAt(dto.getCodigo(),i,1);
                tableResultados.setValueAt(GenericoDTO.EstadoToString(dto.getEstado()),i,2);
                filaActual++;
            }else i=21;
        } 
        tableResultados.setModel(temp);
        return lista.isEmpty();
    } 
   /* public void accionEditar(ActionEvent evt) throws SQLException{
        if(tableResultados.getSelectedRow()!=-1){
            UsuarioNavegateFRM UsuarioEditar= new UsuarioNavegateFRM();
            Usuario=inventarioG.obtenerUsuarioPorId((Long) tableResultados.getModel().getValueAt(tableResultados.getSelectedRow(),0));
            UsuarioEditar.editarUsuario(Usuario);
        }
        else{
            mensaje.error("No ha seleccionado ningun elemento");
        }
    }*/
}
