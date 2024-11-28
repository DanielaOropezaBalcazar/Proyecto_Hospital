package Clases;

public class recetaMedicacion {

	private int codigo;
    private int recetaCodigo;
    private int medicacionCodigo;
    
	public recetaMedicacion(int codigo, int recetaCodigo, int medicacionCodigo) {
		this.codigo = codigo;
		this.recetaCodigo = recetaCodigo;
		this.medicacionCodigo = medicacionCodigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getRecetaCodigo() {
		return recetaCodigo;
	}
	public void setRecetaCodigo(int recetaCodigo) {
		this.recetaCodigo = recetaCodigo;
	}
	public int getMedicacionCodigo() {
		return medicacionCodigo;
	}
	public void setMedicacionCodigo(int medicacionCodigo) {
		this.medicacionCodigo = medicacionCodigo;
	}

    
}
