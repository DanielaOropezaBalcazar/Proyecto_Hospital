package hospital;

public class recetamedicacion {
    private String recetaCodigo;
    private String medicacionCodigo;

    
    public recetamedicacion(String recetaCodigo, String medicacionCodigo) {
        this.recetaCodigo = recetaCodigo;
        this.medicacionCodigo = medicacionCodigo;
    }

    
    public String getRecetaCodigo() {
        return recetaCodigo;
    }

    public void setRecetaCodigo(String recetaCodigo) {
        this.recetaCodigo = recetaCodigo;
    }

    public String getMedicacionCodigo() {
        return medicacionCodigo;
    }

    public void setMedicacionCodigo(String medicacionCodigo) {
        this.medicacionCodigo = medicacionCodigo;
    }
}
