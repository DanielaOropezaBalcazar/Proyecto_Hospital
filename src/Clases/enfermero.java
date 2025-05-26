package Clases;

public class enfermero extends doctor{

	private String areaAsignada;

    // Constructor
	public enfermero(int codigo, String nombre, String areaAsignada) {
		super(codigo, nombre);
		this.areaAsignada = areaAsignada;
	}	
    

    // Getters y Setters
    public String getAreaAsignada() {
        return areaAsignada;
    }


	public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }
}
