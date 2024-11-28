package Clases;

import java.util.Date;

public class receta {
    private int codigo;
    private Date fecha;
    private int duracion;


    public receta(int codigo, Date fecha, int duracion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.duracion = duracion;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
