package hospital;

import java.util.Date;

public class internacion {
    private String codigo;
    private Date fechaIngreso;
    private int duracion;
    private String historialCodigo;
    private String habitacionCodigo;


    public internacion(String codigo, Date fechaIngreso, int duracion, String historialCodigo, String habitacionCodigo) {
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.duracion = duracion;
        this.historialCodigo = historialCodigo;
        this.habitacionCodigo = habitacionCodigo;
    }

  
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public String getHistorialCodigo() {
        return historialCodigo;
    }

    public void setHistorialCodigo(String historialCodigo) {
        this.historialCodigo = historialCodigo;
    }

    public String getHabitacionCodigo() {
        return habitacionCodigo;
    }

    public void setHabitacionCodigo(String habitacionCodigo) {
        this.habitacionCodigo = habitacionCodigo;
    }
}
