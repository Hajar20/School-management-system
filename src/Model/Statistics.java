package Model;

import java.util.Date;

public class Statistics {
   private int idCc;
   private Date dateCc;
   private String major,level,subject;
   private float maxGrade;
   private float minGrade; 
   
   
   



public Statistics(int idCc, Date dateCc, String major, String level,
		String subject, float maxGrade, float minGrade) {
	super();
	this.idCc = idCc;
	this.dateCc = dateCc;
	this.major = major;
	this.level = level;
	this.subject = subject;
	this.maxGrade = maxGrade;
	this.minGrade = minGrade;
}


public float getMinGrade() {
	return minGrade;
}


public void setMinGrade(float minGrade) {
	this.minGrade = minGrade;
}


public int getIdCc() {
	return idCc;
}
public void setIdCc(int idCc) {
	this.idCc = idCc;
}
public Date getDateCc() {
	return dateCc;
}
public void setDateCc(Date dateCc) {
	this.dateCc = dateCc;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public float getMaxGrade() {
	return maxGrade;
}
public void setMaxGrade(float maxGrade) {
	this.maxGrade = maxGrade;
}
   
}
