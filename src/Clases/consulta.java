package Clases;

import java.time.LocalDate;

public class consulta {

    private int codigo;
    private LocalDate fecha;
    private String detalle;
    private int precio;
    private int doctorCodigo;
    private int pacienteCodigo;
    //private String paciente;
    private String nivelUrgencia;  
    
	public consulta(int codigo, LocalDate fecha, String detalle, int precio, int doctorCodigo, int pacienteCodigo) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.detalle = detalle;
		this.precio = precio;
		this.doctorCodigo = doctorCodigo;
		this.pacienteCodigo = pacienteCodigo;
	}

	public consulta(LocalDate fecha, String detalle, int precio, int doctorCodigo, int pacienteCodigo) {
		super();
		this.fecha = fecha;
		this.detalle = detalle;
		this.precio = precio;
		this.doctorCodigo = doctorCodigo;
		this.pacienteCodigo = pacienteCodigo;
	}

	public consulta(String detalle, int pacienteCodigo, String nivelUrgencia) {
		super();
		this.detalle = detalle;
		this.pacienteCodigo = pacienteCodigo;
		this.nivelUrgencia = nivelUrgencia;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getDoctorCodigo() {
		return doctorCodigo;
	}
	public void setDoctorCodigo(int doctorCodigo) {
		this.doctorCodigo = doctorCodigo;
	}
	public int getPacienteCodigo() {
		return pacienteCodigo;
	}
	public void setPacienteCodigo(int pacienteCodigo) {
		this.pacienteCodigo = pacienteCodigo;
	}

//
//
//	public String getPaciente() {
//		return paciente;
//	}
//
//	public void setPaciente(String paciente) {
//		this.paciente = paciente;
//	}
    
    
	

    
}