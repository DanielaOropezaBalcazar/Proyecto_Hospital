package hospital;

public class Medicacion {
    private int id_medicacion;
    private String nombre;
    private String laboratorio;
    private String detalle;
    private int precio;

    // Constructor
    public Medicacion(int id_medicacion, String nombre, String laboratorio, String detalle, int precio) {
        this.id_medicacion = id_medicacion;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.detalle = detalle;
        this.precio = precio;
    }
    
    public Medicacion() { }

    // Getters y Setters
    public int getId_medicacion() {
        return id_medicacion;
    }

    public void setId_medicacion(int id_medicacion) {
        this.id_medicacion = id_medicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

