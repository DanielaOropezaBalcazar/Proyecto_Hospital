package Clases;

import java.util.Date;

public class receta {
    private int codigo;
    private Date fecha;

    public receta(int codigo, Date fecha) {
        this.codigo = codigo;
        this.fecha = fecha;
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

}
