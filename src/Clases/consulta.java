package Clases;

import java.time.LocalDate;
import java.util.Date;

public class consulta {

    private int codigo;
    private LocalDate fecha;
    private String detalle;
    private int precio;
    private int doctorCodigo;
    private int pacienteCodigo;
    
	public consulta(int codigo, LocalDate fecha, String detalle, int precio, int doctorCodigo, int historialCodigo) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.detalle = detalle;
		this.precio = precio;
		this.doctorCodigo = doctorCodigo;
		this.pacienteCodigo = historialCodigo;
	}


	public consulta(LocalDate fecha, String detalle, int precio, int doctorCodigo, int pacienteCodigo) {
		super();
		this.fecha = fecha;
		this.detalle = detalle;
		this.precio = precio;
		this.doctorCodigo = doctorCodigo;
		this.pacienteCodigo = pacienteCodigo;
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
    
    
	

    
}