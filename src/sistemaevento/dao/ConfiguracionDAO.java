package sistemaevento.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistemaevento.dtos.ArticuloDTO;
import sistemaevento.dtos.OpcionDTO;
import sistemaevento.dtos.UsuarioDTO;

public interface ConfiguracionDAO {

	public List<OpcionDTO> obtenerModulos() throws SQLException;

	public List<OpcionDTO> obtenerOpcionesPorModulo(OpcionDTO modulo)throws SQLException;

	public UsuarioDTO obtenerUsuario(UsuarioDTO usuario)throws SQLException;

	public List<Object> obtenereListElementos(String metodoAutoBusqueda) throws SQLException;
	

}
