package Model;



public class ConCont {
private int idModCC;
private int idClasseCC;
private int idCC;
private int idUser;
private String dateCC;
private String nomModCC;
private String nomFCC;
private String annCC;
private String fullName;
private Float note;

public ConCont(String fullName,int idUser,int idCC,Float note) {
	super();
	this.idUser = idUser;
	this.fullName = fullName;
	this.idCC = idCC;
	this.note = note;
}

public String getDateCC() {
	return dateCC;
}

public void setDateCC(String dateCC) {
	this.dateCC = dateCC;
}

public String getAnnCC() {
	return annCC;
}

public void setAnnCC(String annCC) {
	this.annCC = annCC;
}

public String getfullName() {
	return fullName;
}

public void setfullName(String fullName) {
	this.fullName = fullName;
}

public Float getnote() {
	return note;
}

public void setnote(Float note) {
	this.note = note;
}

public ConCont(String nomModCC, String dateCC,String nomFCC,String annCC,int idCC) {
	super();
	this.nomModCC = nomModCC;
	this.dateCC = dateCC;
	this.nomFCC = nomFCC;
	this.annCC = annCC;
	this.idCC=idCC;
}
public ConCont(String nomModCC, String dateCC,String nomFCC,String annCC,int idCC,int idClasseCC) {
	super();
	this.nomModCC = nomModCC;
	this.dateCC = dateCC;
	this.nomFCC = nomFCC;
	this.annCC = annCC;
	this.idCC=idCC;
	this.idClasseCC=idClasseCC;
}
public ConCont(String nomModCC,int idClasseCC, int idCC, int idUser, String dateCC,String nomFCC,String annCC) {
	super();
	this.idClasseCC = idClasseCC;
	this.idCC = idCC;
	this.idUser = idUser;
	this.dateCC = dateCC;
	this.nomModCC = nomModCC;
	this.nomFCC = nomFCC;
	this.nomModCC = annCC;
}

public String getNomFCC() {
	return nomFCC;
}
public void setNomFCC(String nomFCC) {
	this.nomFCC = nomFCC;
}
public String getannCC() {
	return annCC;
}
public void setannCC(String annCC) {
	this.annCC = annCC;
}
public String getNomModCC() {
	return nomModCC;
}
public void setNomModCC(String nomModCC) {
	this.nomModCC = nomModCC;
}
public ConCont(int idModCC, int idClasseCC, int idCC, int idUser, String dateCC) {
	super();
	this.idModCC = idModCC;
	this.idClasseCC = idClasseCC;
	this.idCC = idCC;
	this.idUser = idUser;
	this.dateCC = dateCC;
}
public int getIdModCC() {
	return idModCC;
}
public void setIdModCC(int idModCC) {
	this.idModCC = idModCC;
}
public int getIdClasseCC() {
	return idClasseCC;
}
public void setIdClasseCC(int idClasseCC) {
	this.idClasseCC = idClasseCC;
}
public int getIdCC() {
	return idCC;
}
public void setIdCC(int idCC) {
	this.idCC = idCC;
}
public int getidUser() {
	return idUser;
}
public void setidUser(int idUser) {
	this.idUser = idUser;
}
public String getdateCC() {
	return this.dateCC;
}
public void setdateCC(String dateCC) {
	this.dateCC = dateCC;
}


}
