package Model;

public class SomeInfos {
	private String fullName;
	private String matricule;
	private String role;
	private String niveau;
	private String fili�re;
	public SomeInfos(String fullName, String matricule, String role,
			String niveau, String fili�re) {
		super();
		this.fullName = fullName;
		this.matricule = matricule;
		this.role = role;
		this.niveau = niveau;
		this.fili�re = fili�re;
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
	public String getFili�re() {
		return fili�re;
	}
	public void setFili�re(String fili�re) {
		this.fili�re = fili�re;
	}
	
	
}
