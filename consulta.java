package hospital;

import java.util.Date;

public class consulta {
    private String codigo;
    private Date fecha;
    private String detalle;
    private String doctorCodigo;
    private String historialCodigo;


    public consulta(String codigo, Date fecha, String detalle, String doctorCodigo, String historialCodigo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.detalle = detalle;
        this.doctorCodigo = doctorCodigo;
        this.historialCodigo = historialCodigo;
    }

 
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public String getDoctorCodigo() {
        return doctorCodigo;
    }

    public void setDoctorCodigo(String doctorCodigo) {
        this.doctorCodigo = doctorCodigo;
    }

    public String getHistorialCodigo() {
        return historialCodigo;
    }

    public void setHistorialCodigo(String historialCodigo) {
        this.historialCodigo = historialCodigo;
    }
}
