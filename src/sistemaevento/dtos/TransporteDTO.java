/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.dtos;

import java.util.ArrayList;

import sistemaevento.util.Combobox;

/**
 *
 * @author Mayra
 */
public class TransporteDTO extends GenericoDTO{
    private String placa;
    private String descripcion;
    private String observacion;
    private EstadoTransporte EstadoTransporte;
    private String anioCompra;
    private PersonaDTO empleado;
    
    public TransporteDTO() {
        EstadoTransporte=EstadoTransporte.A;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public PersonaDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(PersonaDTO empleado) {
        this.empleado = empleado;
    }

    public EstadoTransporte getEstadoTransporte() {
        return EstadoTransporte;
    }

    public void setEstadoTransporte(EstadoTransporte estado) {
        this.EstadoTransporte = estado;
    }
    
  
    public String getAnioCompra() {
        return anioCompra;
    }

    public void setAnioCompra(String anioCompra) {
        this.anioCompra = anioCompra;
    }

    public boolean validarCampos() {
        return id!= null && EstadoTransporte !=null ;
    }

   
    public static Combobox EstadoTransporteCombobox(){
        String[] rutas={"/Imagenes/activo_icon.png","/Imagenes/inactivo_icon.png","/Imagenes/inactivo_icon.png"}; 
        ArrayList lista=new ArrayList();
        lista.add("ACTIVO");
        lista.add("INACTIVO");
        lista.add("REPARACION");
        Combobox comboboxEstado = new Combobox(lista.size(), lista, 206,26, rutas);
        return comboboxEstado;
    }

    
    public EstadoTransporte StringToEstadoTransporte(String text) {
        switch (text) {
            case "ACTIVO":
            case "A":
                return EstadoTransporte.A;
            case "INACTIVO":
            case "P":
                return EstadoTransporte.P;
            case "REPARACION":
            case "R":
                return EstadoTransporte.R;
        }
       return null;
    }
    public enum  EstadoTransporte{
        A,R,P;
    }
}

