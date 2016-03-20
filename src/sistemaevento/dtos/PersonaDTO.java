/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.dtos;

import sistemaevento.util.Fecha;
import sistemaevento.util.Generic.BanderaSiNo;
import sistemaevento.util.Generic.Estado;




/**
 *
 * @author Mayrita
 */
public class PersonaDTO extends GenericoDTO{
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String movil1;
    private String movil2;
    private String email;
    private Fecha fechaNacimiento;
    private BanderaSiNo cliente;
    private BanderaSiNo proveedor;
    private BanderaSiNo empleado;
    private Estado estado;

    public PersonaDTO (){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getMovil1() {
        return movil1;
    }

    public String getMovil2() {
        return movil2;
    }

    public String getEmail() {
        return email;
    }
    

    public String getDireccion() {
        return direccion;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setMovil1(String movil1) {
        this.movil1 = movil1;
    }

    public void setMovil2(String movil2) {
        this.movil2 = movil2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

	public BanderaSiNo getCliente() {
		return cliente;
	}

	public void setCliente(BanderaSiNo cliente) {
		this.cliente = cliente;
	}

	public BanderaSiNo getProveedor() {
		return proveedor;
	}

	public void setProveedor(BanderaSiNo proveedor) {
		this.proveedor = proveedor;
	}

	public BanderaSiNo getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BanderaSiNo empleado) {
		this.empleado = empleado;
	}

    
}
