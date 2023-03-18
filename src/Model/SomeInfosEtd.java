package Model;

public class SomeInfosEtd {
	private int idCc;
	private String dateCc;
	private String nomMod;
	private float note;
	public SomeInfosEtd(int idCc, String dateCc, String nomMod, float note) {
		super();
		this.idCc = idCc;
		this.dateCc = dateCc;
		this.nomMod = nomMod;
		this.note = note;
	}
	public int getIdCc() {
		return idCc;
	}
	public void setIdCc(int idCc) {
		this.idCc = idCc;
	}
	public String getDateCc() {
		return dateCc;
	}
	public void setDateCc(String dateCc) {
		this.dateCc = dateCc;
	}
	public String getNomMod() {
		return nomMod;
	}
	public void setNomMod(String nomMod) {
		this.nomMod = nomMod;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	
	
}
