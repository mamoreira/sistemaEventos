/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.dtos;

import java.util.Objects;

import sistemaevento.util.GenericoDTO.Estado;
import sistemaevento.util.GenericoDTO.Rol;


/**
 *
 * @author Mayra
 */
public class UsuarioDTO { 
    private Long id;
    private String codigo;
    private String clave;
    private Estado estado; 
    private Rol rol;

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "" + codigo ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioDTO other = (UsuarioDTO) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    /**
     * Metodo que valida si se han ingresado todos los campos requeridos del usuario
     * @return true si esta bien ingresado false si algun campo q es requerido no esta ingresado
     */
    public boolean validarUsuario(){
        return id != null && codigo != null && estado != null && clave != null && rol != null;
    }

    public boolean validarCampos() {
        return codigo != null && estado != null && clave != null && rol != null;
    }
    
    
    
    
  
}
