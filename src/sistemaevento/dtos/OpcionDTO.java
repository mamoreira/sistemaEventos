/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaevento.dtos;

import sistemaevento.util.GenericoDTO.Estado;

/**
 *
 * @author Mayra
 */
public class OpcionDTO {
    private Long id;
    private String codigo;
    private String descripcion;
    private String objeto;
    private Tipo tipo;
    private OpcionDTO papa;
    private String rutaImagen;
    private Estado Estado;

    public OpcionDTO() {
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

    public String getObjeto() {
        return objeto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public OpcionDTO getPapa() {
        return papa;
    }

    public void setPapa(OpcionDTO papa) {
        this.papa = papa;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Estado getEstado() {
        return Estado;
    }

    public void setEstado(Estado Estado) {
        this.Estado = Estado;
    }
    
    
    public enum Tipo{
       M,//MODULO
       O;//OPCION
   }
}
