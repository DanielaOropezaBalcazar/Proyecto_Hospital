package Clases;

import java.util.Date;

public class laboratorio {
	
	private int codigo;
    private String tipoMuestra;
    private String tipoLaboratorio;
    private Date fechaIngreso;
    private Date fechaEntrega;
    private int doctorCodigo;
    private int historialCodigo;

    // Constructor
    public laboratorio(int codigo, String tipoMuestra, String tipoLaboratorio, Date fechaIngreso, Date fechaEntrega, 
                       int doctorCodigo, int historialCodigo) {
        this.codigo = codigo;
        this.tipoMuestra = tipoMuestra;
        this.tipoLaboratorio = tipoLaboratorio;
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.doctorCodigo = doctorCodigo;
        this.historialCodigo = historialCodigo;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public String getTipoLaboratorio() {
        return tipoLaboratorio;
    }

    public void setTipoLaboratorio(String tipoLaboratorio) {
        this.tipoLaboratorio = tipoLaboratorio;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getDoctorCodigo() {
        return doctorCodigo;
    }

    public void setDoctorCodigo(int doctorCodigo) {
        this.doctorCodigo = doctorCodigo;
    }

    public int getHistorialCodigo() {
        return historialCodigo;
    }

    public void setHistorialCodigo(int historialCodigo) {
        this.historialCodigo = historialCodigo;
    }

}
