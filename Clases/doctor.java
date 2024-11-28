package Clases;

import java.util.Date;

public class doctor extends empleado{

    private String especialidad;

    // Constructor
    public doctor(int codigo, int ci, String nombre, String apellido, Date fechaNacimiento, Date fechaIngreso,
    		String cargo, int salario) {
    	super(codigo, ci, nombre, apellido, fechaNacimiento, fechaIngreso, cargo, salario);
    }    

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

	public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}

