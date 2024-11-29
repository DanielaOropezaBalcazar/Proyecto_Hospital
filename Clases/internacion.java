package Clases;

import java.util.Date;

public class internacion {

    private int codigo;
    private Date fechaIngreso;
    private int duracion;
    private int historialCodigo;
    private int habitacionCodigo;

    public internacion(int codigo, Date fechaIngreso, int duracion, int historialCodigo, int habitacionCodigo) {
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.duracion = duracion;
        this.historialCodigo = historialCodigo;
        this.habitacionCodigo = habitacionCodigo;
    }

  
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getHistorialCodigo() {
        return historialCodigo;
    }

    public void setHistorialCodigo(int historialCodigo) {
        this.historialCodigo = historialCodigo;
    }

    public int getHabitacionCodigo() {
        return habitacionCodigo;
    }

    public void setHabitacionCodigo(int habitacionCodigo) {
        this.habitacionCodigo = habitacionCodigo;
    }
}

