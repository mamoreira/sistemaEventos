package sistemaevento.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaevento.dtos.ArticuloDTO;

public interface InventarioDAO {

	public List<ArticuloDTO> buscarArticulo(ArticuloDTO articuloFilter) throws SQLException;

	public ArticuloDTO obtenerArticuloPorId(Long id) throws SQLException;

}
