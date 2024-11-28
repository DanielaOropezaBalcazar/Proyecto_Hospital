package Clases;

import java.util.Date;

public class consulta {

    private int codigo;
    private Date fecha;
    private String detalle;
    private int doctorCodigo;
    private int historialCodigo;


    public consulta(int codigo, Date fecha, String detalle, int doctorCodigo, int historialCodigo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.detalle = detalle;
        this.doctorCodigo = doctorCodigo;
        this.historialCodigo = historialCodigo;
    }

 
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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
