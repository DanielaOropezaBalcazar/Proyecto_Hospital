package Clases;

import java.time.LocalDate;
import java.util.Date;

public class doctor extends empleado{

    private String especialidad;

    // Constructor
    public doctor(int codigo, int ci, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
    		String cargo, int salario, String especialidad) {
    	super(codigo, ci, nombre, apellido, fechaNacimiento, fechaIngreso, cargo, salario);
    	this.especialidad = especialidad;
    }
   

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

	public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}

