package hospital;

public class Laboratorista {
    private String especialidad;
    private String codigo;
    private String empleadoCodigo;

    // Constructor
    public Laboratorista(String especialidad, String codigo, String empleadoCodigo) {
        this.especialidad = especialidad;
        this.codigo = codigo;
        this.empleadoCodigo = empleadoCodigo;
    }

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpleadoCodigo() {
        return empleadoCodigo;
    }

    public void setEmpleadoCodigo(String empleadoCodigo) {
        this.empleadoCodigo = empleadoCodigo;
    }
}

