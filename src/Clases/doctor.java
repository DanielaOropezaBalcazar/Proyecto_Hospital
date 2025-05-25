package Clases;

import java.time.LocalDate;

public class doctor {

    private int codigo;
    private int ci;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    protected LocalDate fechaIngreso;
    private String cargo;
    private int salario;
    private String especialidad;

    
    @Override
    public String toString() {
        return "Doctor{codigo=" + getCodigo() + ", nombre=" + getNombre();
    }
    
    // Constructores
    public doctor(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public doctor(int ci, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			String cargo, int salario, String especialidad) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.cargo = cargo;
		this.salario = salario;
		this.especialidad = especialidad;
	}

	public doctor(int codigo, int ci, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			String cargo, int salario, String especialidad) {
		super();
		this.codigo = codigo;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.cargo = cargo;
		this.salario = salario;
		this.especialidad = especialidad;
	}
	
	// Getters y Setters
    public int getCodigo() {
        return codigo;
    }

	public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}

