package sistemaevento.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaevento.dtos.ArticuloDTO;
import sistemaevento.dtos.PersonaDTO;
import sistemaevento.dtos.TransporteDTO;
import sistemaevento.dtos.UsuarioDTO;

public interface InventarioDAO {

	public List<ArticuloDTO> buscarArticulo(ArticuloDTO articuloFilter) throws SQLException;

	public ArticuloDTO obtenerArticuloPorId(Long id) throws SQLException;
	
	public List<TransporteDTO> buscarTransporte(TransporteDTO transporteFilter) throws SQLException;

	public List<PersonaDTO> buscarPersona(PersonaDTO personaFilter) throws SQLException;

	public void guardarArticulo(ArticuloDTO articulo) throws SQLException;

	public List<UsuarioDTO> buscarUsuario(UsuarioDTO usuarioFilter) throws SQLException;

}
