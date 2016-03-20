package sistemaevento.frame;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistemaevento.dtos.PersonaDTO;
import sistemaevento.plantillas.frame.PlantillaFRM;
import sistemaevento.util.Combobox;
import sistemaevento.util.GenericoDTO;
import sistemaevento.util.InputNumber;
import sistemaevento.util.InputText;

public class PersonaFRM extends PlantillaFRM {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5616855064630810972L;

	private PersonaDTO PersonaFilter;
	private PersonaDTO Persona;
    private int filaActual;
    private List<PersonaDTO> resultados;
    private InputNumber textFieldId;
    private InputNumber textFieldCedula;
    private InputText textFieldNombre;
    private InputText textFieldApellido;
    private Combobox comboboxEstado;
    private Combobox SNCombobox;
    private JLabel labelId;
    private JLabel labelCedula;
    private JLabel labelNombres;
    private JLabel labelApellidos;
    private JLabel labelEstado;
    private JLabel labelCliente;
    private JLabel labelProveedor;
    private JLabel labelEmpleado;
    

    
	public PersonaFRM(){

	}
	
	/*
	 * INICIALIZA COMPONENTES
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#inicializaComponentes()
	 */
	public void inicializaComponentes() {
		setBackground(new java.awt.Color(102, 51, 255));
		setMinimumSize(new java.awt.Dimension(1000, 599));
		PersonaFilter=new PersonaDTO();
		//****INICIALIZAR COMPONENTES****//
		comboboxEstado = GenericoDTO.EstadoCombobox();
		SNCombobox = GenericoDTO.SNCombobox();
		textFieldId=new InputNumber(15);
		textFieldCedula=new InputNumber(10);
		textFieldNombre=new InputText(10);
		textFieldApellido=new InputText(10);
		labelId=new JLabel(         "Id : ");
		labelCedula=new JLabel(     "Cedula : ");
		labelNombres=new JLabel("Nombres : ");
		labelApellidos=new JLabel("Apellidos : ");
		labelEstado=new JLabel(     "Estado : ");
		labelCliente=new JLabel(     "Cliente : ");
		labelProveedor=new JLabel(     "Proveedor : ");
		labelEmpleado=new JLabel(     "Empleado : ");

    }
	
	/*
	 * DEFINIR FILTROS
	 * @see sistemaevento.plantillas.frame.PlantillaFRM#agregarFiltros()
	 */
	public void agregarFiltros(){
		nuevoFiltro(textFieldId,labelId);
		nuevoFiltro(textFieldCedula,labelCedula);
		nuevoFiltro(textFieldNombre,labelNombres);
		nuevoFiltro(textFieldApellido,labelApellidos);
		nuevoFiltro(comboboxEstado,labelEstado);
		nuevoFiltro(SNCombobox,labelCliente);
		nuevoFiltro(SNCombobox,labelProveedor);
		nuevoFiltro(SNCombobox,labelEmpleado);
		
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
        PersonaFilter.setId(textFieldId.getLong());
        PersonaFilter.setCedula(textFieldCedula.getText());
        PersonaFilter.setNombres(textFieldNombre.getText());
        PersonaFilter.setApellidos(textFieldApellido.getText());
        PersonaFilter.setEstado(GenericoDTO.StringToEstado(comboboxEstado.getSelectedItem().toString()));
        PersonaFilter.setCliente(GenericoDTO.StringToSN(SNCombobox.getSelectedItem().toString()));
        PersonaFilter.setProveedor(GenericoDTO.StringToSN(SNCombobox.getSelectedItem().toString()));
        PersonaFilter.setEmpleado(GenericoDTO.StringToSN(SNCombobox.getSelectedItem().toString()));
        resultados=inventarioG.buscarPersona(PersonaFilter);
        mostrarTablaResultado(resultados);
        
    }
    private boolean mostrarTablaResultado(List<PersonaDTO> lista) {
        Object [] o={"",""};
        limpiarTabla(tableResultados);
        DefaultTableModel temp = (DefaultTableModel) tableResultados.getModel();
        for (int i = 0; i < 20; i++) {
            if(i<lista.size()){
                temp.addRow(o);
                PersonaDTO dto=lista.get(filaActual);
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
            PersonaNavegateFRM PersonaEditar= new PersonaNavegateFRM();
            Persona=inventarioG.obtenerPersonaPorId((Long) tableResultados.getModel().getValueAt(tableResultados.getSelectedRow(),0));
            PersonaEditar.editarPersona(Persona);
        }
        else{
            mensaje.error("No ha seleccionado ningun elemento");
        }
    }*/
}
