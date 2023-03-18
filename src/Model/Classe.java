package Model;

public class Classe {
    private int idClass;
    private String niveau;
    private int idF;
	public Classe(int idClass, String niveau, int idF) {
		super();
		this.idClass = idClass;
		this.niveau = niveau;
		this.idF = idF;
	}
	public Classe(String niveau, int idF) {
		super();
		this.niveau = niveau;
		this.idF = idF;
	}
	public int getIdClass() {
		return idClass;
	}
	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
    
}
