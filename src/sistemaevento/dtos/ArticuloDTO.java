
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.dtos;

import java.math.BigDecimal;
import java.util.Objects;

import sistemaevento.util.Generic.Estado;

/**
 *
 * @author Mayra
 */
public class ArticuloDTO extends GenericoDTO{
    private String codigo;
    private String descripcion;
    private Long stock;
    private BigDecimal costo;
    private BigDecimal precioAlquiler;
    private Long cantidadBuenEstado; 
    private Long cantidadReparacion;
    private Estado estado;

    public ArticuloDTO() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(BigDecimal precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public Long getCantidadBuenEstado() {
        return cantidadBuenEstado;
    }

    public void setCantidadBuenEstado(Long cantidadBuenEstado) {
        this.cantidadBuenEstado = cantidadBuenEstado;
    }

    public Long getCantidadReparacion() {
        return cantidadReparacion;
    }

    public void setCantidadReparacion(Long cantidadReparacion) {
        this.cantidadReparacion = cantidadReparacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ArticuloDTO other = (ArticuloDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    
}
