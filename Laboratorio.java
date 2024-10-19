package hospital;

import java.util.Date;

public class Laboratorio {
    private String codigo;
    private String tipoMuestra;
    private String tipoLaboratorio;
    private Date fechaIngreso;
    private Date fechaEntrega;
    private String doctorCodigo;
    private String laboratoristaCodigo;
    private String historialCodigo;

    // Constructor
    public Laboratorio(String codigo, String tipoMuestra, String tipoLaboratorio, Date fechaIngreso, Date fechaEntrega, 
                       String doctorCodigo, String laboratoristaCodigo, String historialCodigo) {
        this.codigo = codigo;
        this.tipoMuestra = tipoMuestra;
        this.tipoLaboratorio = tipoLaboratorio;
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.doctorCodigo = doctorCodigo;
        this.laboratoristaCodigo = laboratoristaCodigo;
        this.historialCodigo = historialCodigo;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public String getDoctorCodigo() {
        return doctorCodigo;
    }

    public void setDoctorCodigo(String doctorCodigo) {
        this.doctorCodigo = doctorCodigo;
    }

    public String getLaboratoristaCodigo() {
        return laboratoristaCodigo;
    }

    public void setLaboratoristaCodigo(String laboratoristaCodigo) {
        this.laboratoristaCodigo = laboratoristaCodigo;
    }

    public String getHistorialCodigo() {
        return historialCodigo;
    }

    public void setHistorialCodigo(String historialCodigo) {
        this.historialCodigo = historialCodigo;
    }
}
