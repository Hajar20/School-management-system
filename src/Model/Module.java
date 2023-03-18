package Model;

public class Module {
    private int idMod;
    private String nomMod;
    private int coiff;
    private String unite;
    private String professeur;
	public Module(int idMod, String nomMod,int coiff ,String unite,String professeur) {
		super();
		this.idMod = idMod;
		this.nomMod = nomMod;
		this.unite = unite;
		this.coiff = coiff;
		this.professeur = professeur;
	}
	public Module(int idMod, String nomMod) {
		super();
		this.idMod = idMod;
		this.nomMod = nomMod;
	}
	
	public Module(String nomMod, int coiff, String unite, String professeur) {
		super();
		this.nomMod = nomMod;
		this.coiff = coiff;
		this.unite = unite;
		this.professeur = professeur;
	}

	public String getProfesseur() {
		return professeur;
	}

	public void setProfesseur(String professeur) {
		this.professeur = professeur;
	}

	public int getCoiff() {
		return coiff;
	}

	public void setCoiff(int coiff) {
		this.coiff = coiff;
	}

	public int getIdMod() {
		return idMod;
	}
	public void setIdMod(int idMod) {
		this.idMod = idMod;
	}
	public String getNomMod() {
		return nomMod;
	}
	public void setNomMod(String nomMod) {
		this.nomMod = nomMod;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	
    

}
