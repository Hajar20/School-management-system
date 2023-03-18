package Model;

public class Specialite {
     private int idSp;
     private String nomSp;
     private int idNv;
     private String niv;
     public Specialite(int idNv, int idSp,String nomSp,String niv) {
  		super();
  		this.idSp = idSp;
  		this.nomSp = nomSp;
  		this.niv= niv;
  		this.idNv=idNv;
  	} 
    public Specialite(int idSp, String nomSp,int idNv) {
 		super();
 		this.idSp = idSp;
 		this.nomSp = nomSp;
 		this.idNv=idNv;
 	} 
	public Specialite(int idSp, String nomSp) {
		super();
		this.idSp = idSp;
		this.nomSp = nomSp;
	}
	public Specialite(String nomSp) {
		super();
		this.nomSp = nomSp;
	}
	
	public String getNiv() {
		return niv;
	}
	public void setNiv(String niv) {
		this.niv = niv;
	}
	public int getIdNv() {
		return idNv;
	}
	public void setIdNv(int idNv) {
		this.idNv = idNv;
	}
	public int getIdSp() {
		return idSp;
	}
	public void setIdSp(int idSp) {
		this.idSp = idSp;
	}
	public String getNomSp() {
		return nomSp;
	}
	public void setNomSp(String nomSp) {
		this.nomSp = nomSp;
	}
     
     
}
