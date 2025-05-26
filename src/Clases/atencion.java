package Clases;

public class atencion {
    private String detalle;
    private String paciente;
    private String nivelUrgencia;

    public atencion(String detalle, String paciente, String nivelUrgencia) {
        this.detalle = detalle;
        this.paciente = paciente;
        this.nivelUrgencia = nivelUrgencia;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(String nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }
}

