package sistemaevento.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistemaevento.conexion.Conexion;
import sistemaevento.dtos.ArticuloDTO;
import sistemaevento.dtos.PersonaDTO;
import sistemaevento.dtos.TransporteDTO;
import sistemaevento.dtos.UsuarioDTO;
import sistemaevento.util.Criteria;
import sistemaevento.util.GenericoDTO;

public class InventarioDAOImpl implements InventarioDAO {
	
	private Connection userConn;

	public List<ArticuloDTO> buscarArticulo(ArticuloDTO articulo) throws SQLException{
		Connection conn=null;
		Statement stmt=null;
		ResultSet datos=null;
		ArrayList<ArticuloDTO> articulos=new ArrayList<ArticuloDTO>();
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.createStatement();
			Criteria criteria=new Criteria("articulo");
            criteria.addEqualsIfNotNull("id",articulo.getId());
			criteria.addLikeIfNotNull("codigo",articulo.getCodigo());
            criteria.addLikeIfNotNull("descripcion",articulo.getDescripcion());
            criteria.addEqualsIfNotNull("estado",articulo.getEstado()); 
            datos=stmt.executeQuery(criteria.getQuery());
            while(datos.next()){
                ArticuloDTO temp=new ArticuloDTO();
                temp.setId(datos.getLong(1));
                temp.setCodigo(datos.getString(2));
                temp.setDescripcion(datos.getString(3));
                temp.setCosto(datos.getBigDecimal(4));
                temp.setPrecioAlquiler(datos.getBigDecimal(5));
                temp.setStock(datos.getLong(6));
                temp.setCantidadBuenEstado(datos.getLong(7));
                temp.setCantidadReparacion(datos.getLong(8));
                temp.setEstado(GenericoDTO.StringToEstado(datos.getString(9)));
                articulos.add(temp); 
            }
		}
		finally{
			Conexion.close(stmt);
			if(this.userConn==null){
				Conexion.close(conn);
			}
		} 
        return articulos;
	}
	public ArticuloDTO obtenerArticuloPorId(Long id) throws SQLException{
		Connection conn=null;
		Statement stmt=null;
		ResultSet datos=null;
		ArticuloDTO articulo=new ArticuloDTO();
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.createStatement();
			Criteria criteria=new Criteria("articulo");
            criteria.addEqualsIfNotNull("id",id);
            datos=stmt.executeQuery(criteria.getQuery());
            while(datos.next()){
            	articulo.setId(datos.getLong(1));
                articulo.setCodigo(datos.getString(2));
                articulo.setDescripcion(datos.getString(3));
                articulo.setCosto(datos.getBigDecimal(4));
                articulo.setPrecioAlquiler(datos.getBigDecimal(5));
                articulo.setStock(datos.getLong(6));
                articulo.setCantidadBuenEstado(datos.getLong(7));
                articulo.setCantidadReparacion(datos.getLong(8));
                articulo.setEstado(GenericoDTO.StringToEstado(datos.getString(9))); 
            }
		}
		finally{
			Conexion.close(stmt);
			if(this.userConn==null){
				Conexion.close(conn);
			}
		} 
        return articulo;
	}
	

	
	public List<TransporteDTO> buscarTransporte(TransporteDTO articulo) throws SQLException{
		Connection conn=null;
		Statement stmt=null;
		ResultSet datos=null;
		ArrayList<TransporteDTO> articulos=new ArrayList<TransporteDTO>();
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.createStatement();
			Criteria criteria=new Criteria("vehiculo");
            criteria.addEqualsIfNotNull("id",articulo.getId());
			criteria.addLikeIfNotNull("placa",articulo.getPlaca());
            criteria.addLikeIfNotNull("descripcion",articulo.getDescripcion());
            criteria.addEqualsIfNotNull("estado",articulo.getEstadoTransporte()); 
            datos=stmt.executeQuery(criteria.getQuery());
            while(datos.next()){
                TransporteDTO temp=new TransporteDTO();
                temp.setId(datos.getLong(1));
                temp.setDescripcion(datos.getString(2));
                temp.setPlaca(datos.getString(3));
                temp.setObservacion(datos.getString(4));
                temp.setEstadoTransporte(temp.StringToEstadoTransporte(datos.getString(5)));
                temp.setAnioCompra(datos.getString(6));
                articulos.add(temp); 
            }
		}
		finally{
			Conexion.close(stmt);
			if(this.userConn==null){
				Conexion.close(conn);
			}
		} 
        return articulos;
	}
	
	
	public List<UsuarioDTO> buscarUsuario(UsuarioDTO articulo) throws SQLException{
		Connection conn=null;
		Statement stmt=null;
		ResultSet datos=null;
		ArrayList<UsuarioDTO> articulos=new ArrayList<UsuarioDTO>();
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.createStatement();
			Criteria criteria=new Criteria("usuario");
            criteria.addEqualsIfNotNull("id",articulo.getId());
			criteria.addLikeIfNotNull("codigo",articulo.getCodigo());
            criteria.addEqualsIfNotNull("estado",articulo.getEstado()); 
            datos=stmt.executeQuery(criteria.getQuery());
            while(datos.next()){
            	UsuarioDTO temp=new UsuarioDTO();
                temp.setId(datos.getLong(1));
                temp.setCodigo(datos.getString(2));
                temp.setEstado(GenericoDTO.StringToEstado(datos.getString(4)));
                articulos.add(temp); 
            }
		}
		finally{
			Conexion.close(stmt);
			if(this.userConn==null){
				Conexion.close(conn);
			}
		} 
        return articulos;
	}
	

    
	public List<PersonaDTO> buscarPersona(PersonaDTO articulo) throws SQLException{
		Connection conn=null;
		Statement stmt=null;
		ResultSet datos=null;
		ArrayList<PersonaDTO> articulos=new ArrayList<PersonaDTO>();
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.createStatement();
			Criteria criteria=new Criteria("persona");
            criteria.addEqualsIfNotNull("id",articulo.getId());
			criteria.addLikeIfNotNull("nombre",articulo.getNombres());
			criteria.addLikeIfNotNull("apellido",articulo.getApellidos());
            criteria.addLikeIfNotNull("cedula",articulo.getCedula());          
            criteria.addEqualsIfNotNull("estado",articulo.getEstado());
            criteria.addEqualsIfNotNull("cliente",articulo.getCliente());
            criteria.addEqualsIfNotNull("proveedor",articulo.getProveedor());
            criteria.addEqualsIfNotNull("empleado",articulo.getEmpleado());
            
            datos=stmt.executeQuery(criteria.getQuery());
            while(datos.next()){
            	PersonaDTO temp=new PersonaDTO();
                temp.setId(datos.getLong(1));
                temp.setNombres(datos.getString(2));
                temp.setApellidos(datos.getString(3));
                temp.setCedula(datos.getString(3));
                temp.setDireccion(datos.getString(4));
                temp.setTelefono(datos.getString(5));
                temp.setEmail(datos.getString(9));
                temp.setEstado(GenericoDTO.StringToEstado(datos.getString(11)));      
                articulos.add(temp); 
            }
		}
		finally{
			Conexion.close(stmt);
			if(this.userConn==null){
				Conexion.close(conn);
			}
		} 
        return articulos;
	}
    
}

