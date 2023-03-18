package Model;

public class SomeInfos {
	private String fullName;
	private String matricule;
	private String role;
	private String niveau;
	private String filière;
	public SomeInfos(String fullName, String matricule, String role,
			String niveau, String filière) {
		super();
		this.fullName = fullName;
		this.matricule = matricule;
		this.role = role;
		this.niveau = niveau;
		this.filière = filière;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getFilière() {
		return filière;
	}
	public void setFilière(String filière) {
		this.filière = filière;
	}
	
	
}
