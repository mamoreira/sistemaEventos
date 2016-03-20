package sistemaevento.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaevento.dtos.ArticuloDTO;
import sistemaevento.dtos.TransporteDTO;

public interface InventarioDAO {

	public List<ArticuloDTO> buscarArticulo(ArticuloDTO articuloFilter) throws SQLException;

	public ArticuloDTO obtenerArticuloPorId(Long id) throws SQLException;
	
	public List<TransporteDTO> buscarTransporte(TransporteDTO transporteFilter) throws SQLException;

}
