package Clases;

import java.time.LocalDate;
import java.util.Date;

public class paciente {
    private int codigo;
    private int ci;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String tipoSangre;
    private boolean genero;

    
    public paciente(int codigo, int ci, String nombre, String apellido, String tipoSangre, boolean genero) {
		super();
		this.codigo = codigo;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoSangre = tipoSangre;
		this.genero = genero;
	}


	public paciente(int codigo, String nombre, String apellido, LocalDate fechaNacimiento, String tipoSangre, boolean genero) {
        this.codigo = codigo;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.genero = genero;
    }


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

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
}
