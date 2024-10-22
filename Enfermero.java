package hospital;

public class Enfermero extends Empleado{
    private String areaAsignada;
    private int id_enfermero;
    private int id_empleado;

    // Constructor
    public Enfermero(String areaAsignada, int id_enfermero, int id_empleado) {
        this.areaAsignada = areaAsignada;
        this.id_enfermero = id_enfermero;
        this.id_empleado = id_empleado;
    }
    
    public Enfermero() { } 

    // Getters y Setters
    public String getAreaAsignada() {
        return areaAsignada;
    }

    public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }

	public int getId_enfermero() {
		return id_enfermero;
	}

	public void setId_enfermero(int id_enfermero) {
		this.id_enfermero = id_enfermero;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
}

