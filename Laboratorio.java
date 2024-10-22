package hospital;

import java.util.Date;

public class Laboratorio {
    private int id_laboratorio;
    private String tipoMuestra;
    private String tipoLaboratorio;
    private Date fechaIngreso;
    private Date fechaEntrega;
    private int id_doctor;
    private int id_laboratorista;
    private int id_historial;

    // Constructor
    public Laboratorio(int id_laboratorio, String tipoMuestra, String tipoLaboratorio, Date fechaIngreso,
			Date fechaEntrega, int id_doctor, int id_laboratorista, int id_historial) {
		super();
		this.id_laboratorio = id_laboratorio;
		this.tipoMuestra = tipoMuestra;
		this.tipoLaboratorio = tipoLaboratorio;
		this.fechaIngreso = fechaIngreso;
		this.fechaEntrega = fechaEntrega;
		this.id_doctor = id_doctor;
		this.id_laboratorista = id_laboratorista;
		this.id_historial = id_historial;
	}
    
    public Laboratorio() { }
    
    // Getters y Setters
	public int getId_laboratorio() {
		return id_laboratorio;
	}

	public void setId_laboratorio(int id_laboratorio) {
		this.id_laboratorio = id_laboratorio;
	}

	public String getTipoMuestra() {
		return tipoMuestra;
	}

	public void setTipoMuestra(String tipoMuestra) {
		this.tipoMuestra = tipoMuestra;
	}

	public String getTipoLaboratorio() {
		return tipoLaboratorio;
	}

	public void setTipoLaboratorio(String tipoLaboratorio) {
		this.tipoLaboratorio = tipoLaboratorio;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getId_doctor() {
		return id_doctor;
	}

	public void setId_doctor(int id_doctor) {
		this.id_doctor = id_doctor;
	}

	public int getId_laboratorista() {
		return id_laboratorista;
	}

	public void setId_laboratorista(int id_laboratorista) {
		this.id_laboratorista = id_laboratorista;
	}

	public int getId_historial() {
		return id_historial;
	}

	public void setId_historial(int id_historial) {
		this.id_historial = id_historial;
	}    

}
