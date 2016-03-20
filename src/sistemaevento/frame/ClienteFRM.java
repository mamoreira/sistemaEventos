package sistemaevento.frame;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import sistemaevento.dtos.ClienteDTO;
import sistemaevento.plantillas.frame.PlantillaFRM;
import sistemaevento.util.Combobox;
import sistemaevento.util.GenericoDTO;
import sistemaevento.util.InputNumber;
import sistemaevento.util.InputText;

public class ClienteFRM extends PlantillaFRM {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7600973393484979659L;

	private ClienteDTO ClienteFilter;
    private int filaActual;
    private List<ClienteDTO> resultados;
    private InputNumber textFieldId;
    private InputNumber textFieldCedula;
    private InputText textFieldNombres;
    private InputText textFieldApellidos;
    private Combobox comboboxEstado;
    private JLabel labelId;
    private JLabel labelCedula;
    private JLabel labelNombres;
    private JLabel labelApellidos;
    private JLabel labelEstado;
    

    
	public ClienteFRM(){

	}
	
	/*
	 * INICIALIZA COMPONENTES
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#inicializaComponentes()
	 */
	public void inicializaComponentes() {
		setBackground(new java.awt.Color(102, 51, 255));
		setMinimumSize(new java.awt.Dimension(1000, 599));
		ClienteFilter=new ClienteDTO();
		//****INICIALIZAR COMPONENTES****//
		comboboxEstado = GenericoDTO.EstadoCombobox();
		textFieldId=new InputNumber(15);
		textFieldCedula=new InputNumber(10);
		textFieldNombres=new InputText(10);
		textFieldApellidos=new InputText(10);
		labelId=new JLabel(         "Id : ");
		labelCedula=new JLabel(     "Cedula : ");
		labelNombres=new JLabel("Nombres : ");
		labelApellidos=new JLabel("Apellidos : ");
		labelEstado=new JLabel(     "Estado : ");

    }
	
	/*
	 * DEFINIR FILTROS
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#agregarFiltros()
	 */
	public void agregarFiltros(){
		nuevoFiltro(textFieldId,labelId);
		nuevoFiltro(textFieldCedula,labelCedula);
		nuevoFiltro(textFieldNombres,labelNombres);
		nuevoFiltro(textFieldApellidos,labelApellidos);
		nuevoFiltro(comboboxEstado,labelEstado);
	}
	
	/*
	 * DEFINIR CABECERA DE TABLA DE RESULTADOS
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#llenarCabeceraTabla()
	 */
	public void llenarCabeceraTabla(){
		columnTableResult=new ArrayList<>();
		columnTableResult.add("Id");
		columnTableResult.add("Cedula");
		columnTableResult.add("Nombres");
		columnTableResult.add("Apellidos");
		columnTableResult.add("Estado");
	
	 }
	
	
	/**
	 * ACCIONES
	 * @throws SQLException 
	 */
    public void accionBuscar(java.awt.event.ActionEvent evt) throws SQLException {   
    	filaActual=0;
        ClienteFilter.setId(textFieldId.getLong());
        ClienteFilter.setCedula(textFieldCedula.getText());
        ClienteFilter.setNombres(textFieldNombres.getText());
        ClienteFilter.setApellidos(textFieldApellidos.getText());
        ClienteFilter.setEstado(GenericoDTO.StringToEstado(comboboxEstado.getSelectedItem().toString()));
        resultados=inventarioG.buscarCliente(ClienteFilter);
        mostrarTablaResultado(resultados);
        
    }
    private boolean mostrarTablaResultado(List<ClienteDTO> lista) {
        Object [] o={"",""};
        limpiarTabla(tableResultados);
        DefaultTableModel temp = (DefaultTableModel) tableResultados.getModel();
        for (int i = 0; i < 20; i++) {
            if(i<lista.size()){
                temp.addRow(o);
                ClienteDTO dto=lista.get(filaActual);
                tableResultados.setValueAt(dto.getId(),i,0);                
                tableResultados.setValueAt(dto.getCedula(),i,1);
                tableResultados.setValueAt(dto.getNombres(),i,2);
                tableResultados.setValueAt(dto.getApellidos(),i,3);
                tableResultados.setValueAt(GenericoDTO.EstadoToString(dto.getEstado()),i,4);
                filaActual++;
            }else i=21;
        } 
        tableResultados.setModel(temp);
        return lista.isEmpty();
    } 
   /* public void accionEditar(ActionEvent evt) throws SQLException{
        if(tableResultados.getSelectedRow()!=-1){
            ClienteNavegateFRM ClienteEditar= new ClienteNavegateFRM();
            Cliente=inventarioG.obtenerClientePorId((Long) tableResultados.getModel().getValueAt(tableResultados.getSelectedRow(),0));
            ClienteEditar.editarCliente(Cliente);
        }
        else{
            mensaje.error("No ha seleccionado ningun elemento");
        }
    }*/
}
