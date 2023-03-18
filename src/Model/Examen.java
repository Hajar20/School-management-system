package Model;



public class Examen {
	   private int idEx;
	   private String nomEx;
	   private String dateEx;
	   private String schoolYear;
	public Examen(int idEx, String nomEx, String dateEx, String schoolYear) {
		super();
		this.idEx = idEx;
		this.nomEx = nomEx;
		this.dateEx = dateEx;
		this.schoolYear = schoolYear;
	}
	public Examen(String nomEx, String dateEx, String schoolYear) {
		super();
		this.nomEx = nomEx;
		this.dateEx = dateEx;
		this.schoolYear = schoolYear;
	}
	public int getIdEx() {
		return idEx;
	}
	public void setIdEx(int idEx) {
		this.idEx = idEx;
	}
	public String getNomEx() {
		return nomEx;
	}
	public void setNomEx(String nomEx) {
		this.nomEx = nomEx;
	}
	public String getDateEx() {
		return dateEx;
	}
	public void setDateEx(String dateEx) {
		this.dateEx = dateEx;
	}
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	
}
