package Clases;

import java.time.LocalDate;
import java.util.Date;

public class enfermero extends empleado{

    private String areaAsignada;

    // Constructor
    	public enfermero(int codigo, int ci, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, String cargo, int salario, String areaAsignada) {
		super(codigo, ci, nombre, apellido, fechaNacimiento, fechaIngreso, cargo, salario);
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
