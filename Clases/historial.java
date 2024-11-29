package Clases;

import java.util.Date;

public class historial {

    private int codigo;
    private Date fechaInicio;
    private int pacienteCodigo;

 
    public historial(int codigo, Date fechaInicio, int pacienteCodigo) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.pacienteCodigo = pacienteCodigo;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getPacienteCodigo() {
        return pacienteCodigo;
    }

    public void setPacienteCodigo(int pacienteCodigo) {
        this.pacienteCodigo = pacienteCodigo;
    }
}
