package hospital;

public class enfermero {
    private String areaAsignada;
    private int codigo;
    private String empleadoCodigo;

    // Constructor
    public enfermero(String areaAsignada, int codigo, String empleadoCodigo) {
        this.areaAsignada = areaAsignada;
        this.codigo = codigo;
        this.empleadoCodigo = empleadoCodigo;
    }

    // Getters y Setters
    public String getAreaAsignada() {
        return areaAsignada;
    }

    public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmpleadoCodigo() {
        return empleadoCodigo;
    }

    public void setEmpleadoCodigo(String empleadoCodigo) {
        this.empleadoCodigo = empleadoCodigo;
    }
}

