package Model;

public class NoteEtd {
      private String nomMod;
      private float grade;
	public NoteEtd(float grade,String nomMod) {
		super();
		this.nomMod = nomMod;
		this.grade = grade;
	}
	public String getNomMod() {
		return nomMod;
	}
	public void setNomMod(String nomMod) {
		this.nomMod = nomMod;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
      
      
}
