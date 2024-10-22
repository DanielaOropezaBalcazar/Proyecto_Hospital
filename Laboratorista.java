package hospital;

import java.util.Date;

public class Laboratorista extends Empleado{
    private String especialidad;
    private int id_laboratorista;
    private int id_empleado;

    // Constructor
    public Laboratorista(int id_empleado, int ci, String nombre, String apellido, Date fechaNacimiento,
			Date fechaIngreso, String cargo, int salario, String especialidad, int id_laboratorista, int id_empleado2) {
		super(id_empleado, ci, nombre, apellido, fechaNacimiento, fechaIngreso, cargo, salario);
		this.especialidad = especialidad;
		this.id_laboratorista = id_laboratorista;
		id_empleado = id_empleado2;
	}

    public Laboratorista() { }
    
    // Getters y Setters
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getId_laboratorista() {
		return id_laboratorista;
	}

	public void setId_laboratorista(int id_laboratorista) {
		this.id_laboratorista = id_laboratorista;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}      
        
}

