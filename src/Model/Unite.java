package Model;

public class Unite {
     private int idUni;
     private String nomUni;
     private int coeffUni;
     
	public Unite(String nomUni, int coeffUni) {
		super();
		this.nomUni = nomUni;
		this.coeffUni = coeffUni;
	}
	public Unite(int idUni, String nomUni, int coeffUni) {
		super();
		this.idUni = idUni;
		this.nomUni = nomUni;
		this.coeffUni = coeffUni;
	}
	public int getIdUni() {
		return idUni;
	}
	public void setIdUni(int idUni) {
		this.idUni = idUni;
	}
	public String getNomUni() {
		return nomUni;
	}
	public void setNomUni(String nomUni) {
		this.nomUni = nomUni;
	}
	public int getCoeffUni() {
		return coeffUni;
	}
	public void setCoeffUni(int coiffUni) {
		this.coeffUni = coiffUni;
	}
     
}
