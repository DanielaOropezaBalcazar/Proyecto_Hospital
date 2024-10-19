package hospital;

public class habitacion {
    private String codigo;
    private int piso;
    private int cantCamas;
    private String tipoHabitacion;
    private int enfermeroCodigo;

    // Constructor
    public habitacion(String codigo, int piso, int cantCamas, String tipoHabitacion, int enfermeroCodigo) {
        this.codigo = codigo;
        this.piso = piso;
        this.cantCamas = cantCamas;
        this.tipoHabitacion = tipoHabitacion;
        this.enfermeroCodigo = enfermeroCodigo;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getEnfermeroCodigo() {
        return enfermeroCodigo;
    }

    public void setEnfermeroCodigo(int enfermeroCodigo) {
        this.enfermeroCodigo = enfermeroCodigo;
    }
}
