package sistemaevento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistemaevento.conexion.Conexion;
import sistemaevento.dtos.GenericoDTO;
import sistemaevento.dtos.OpcionDTO;
import sistemaevento.dtos.UsuarioDTO;

public class ConfiguracionDAOImpl implements ConfiguracionDAO {
	
	private Connection userConn;
	
	private final String PRO_OBTENER_MODULOS="call obtener_modulos()";
	private final String PRO_OBTENER_OPCIONES_POR_MODULO="call obtener_opcion_por_modulo(?)";
	private final String PRO_OBTENER_USUARIO="call obtener_usuario(?,?)";
	
	/**
	 * Metodo para obtener modulos para llenar el menu
	 */
	@Override
    public List<OpcionDTO> obtenerModulos() throws SQLException {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<OpcionDTO> opciones=new ArrayList<>();
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.prepareStatement(PRO_OBTENER_MODULOS);
			rs=stmt.executeQuery();
	        while (rs.next()) {
	            OpcionDTO opcion=new OpcionDTO();
	            opcion.setId(rs.getLong(1));
	            opcion.setCodigo(rs.getString(2));
	            opcion.setObjeto(rs.getString(3));
	            opcion.setDescripcion(rs.getString(4));
	            opcion.setRutaImagen(rs.getString(5));
	            opciones.add(opcion);
	        }
		}
		finally{
			Conexion.close(stmt);
			if(this.userConn==null){
				Conexion.close(conn);
			}
		}        
        return opciones;
    }
	
	/**
	 * Metodo para obtener las opciones de un modulo
	 */
	@Override
	public List<OpcionDTO> obtenerOpcionesPorModulo(OpcionDTO modulo) throws SQLException {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<OpcionDTO> opciones=new ArrayList<>();
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.prepareStatement(PRO_OBTENER_OPCIONES_POR_MODULO);
			stmt.setLong(1, modulo.getId());
			rs=stmt.executeQuery();
			while(rs.next()){
				OpcionDTO opcion=new OpcionDTO();
				opcion.setId(rs.getLong(1));
				opcion.setCodigo(rs.getString(2));
				opcion.setObjeto(rs.getString(3));
				opcion.setDescripcion(rs.getString(4));
				opcion.setRutaImagen(rs.getString(5));
				opciones.add(opcion);
			}
		}
		finally{
			Conexion.close(conn);
			if(this.userConn == null){
				Conexion.close(conn);
			}
		}
		return opciones;
	}

	/**
	 * Obtener usuario para autenticacion
	 */
	@Override
	public UsuarioDTO obtenerUsuario(UsuarioDTO usuario) throws SQLException {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		UsuarioDTO usu=null;
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.prepareStatement(PRO_OBTENER_USUARIO);
			stmt.setString(1, usuario.getCodigo());
			stmt.setString(2, usuario.getClave());
			rs=stmt.executeQuery();
            usu=new UsuarioDTO();
	        while (rs.next()) {
	        	usu.setId(rs.getLong(1));
	        	usu.setCodigo(rs.getString(2));
	        	usu.setClave(rs.getString(3));
	        }
		}
		finally{
			Conexion.close(stmt);
			if(this.userConn==null){
				Conexion.close(conn);
			}
		} 
        return usu;
	}

	public List<GenericoDTO> obtenereListElementos(String metodoAutoBusqueda) throws SQLException{
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<GenericoDTO> objetos=new ArrayList<>();
		try{
			conn=(this.userConn!=null)?this.userConn:Conexion.getConnection();
			stmt=conn.prepareStatement("call "+metodoAutoBusqueda+"(?)");
			rs=stmt.executeQuery();
	        while (rs.next()) {
	        	GenericoDTO generico= new GenericoDTO();
	        	generico.setId(rs.getLong(1));
	        	generico.setDescripcion(rs.getString(2));
	            objetos.add(generico);
	        }
		}
		finally{
			Conexion.close(stmt);
			if(this.userConn==null){
				Conexion.close(conn);
			}
		}        
        return objetos;
	}

}
