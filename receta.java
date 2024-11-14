package hospital;

import java.util.Date;

public class receta {
    private String codigo;
    private Date fecha;
    private int duracion;


    public receta(String codigo, Date fecha, int duracion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.duracion = duracion;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
