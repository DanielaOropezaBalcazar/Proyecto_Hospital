package hospital;

import java.util.Date;

public class historial {
    private String codigo;
    private Date fechaInicio;
    private String pacienteCodigo;

 
    public historial(String codigo, Date fechaInicio, String pacienteCodigo) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.pacienteCodigo = pacienteCodigo;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getPacienteCodigo() {
        return pacienteCodigo;
    }

    public void setPacienteCodigo(String pacienteCodigo) {
        this.pacienteCodigo = pacienteCodigo;
    }
}
