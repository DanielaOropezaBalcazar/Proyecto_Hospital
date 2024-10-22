package hospital;

public class Habitacion {
    private int id_habitacion;
    private int piso;
    private int cantCamas;
    private String tipoHabitacion;
    private int id_enfermero;

    // Constructor
    public Habitacion(int id_habitacion, int piso, int cantCamas, String tipoHabitacion, int id_enfermero) {
        this.id_habitacion = id_habitacion;
        this.piso = piso;
        this.cantCamas = cantCamas;
        this.tipoHabitacion = tipoHabitacion;
        this.id_enfermero = id_enfermero;
    }
    
    public Habitacion() { }

    // Getters y Setters
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

	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}
	
	public int getId_enfermero() {
		return id_enfermero;
	}

	public void setId_enfermero(int id_enfermero) {
		this.id_enfermero = id_enfermero;
	}
}
