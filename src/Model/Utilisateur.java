package Model;

import java.io.*;

public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idUser;
	private String nom;
	private String prenom;
	private String email;
	private String matricule;
	private String dateN;
	private String lieu;
	private String adresse;
	private String login;
	private String password;
	private String role;
	
	private String fullName;
public Utilisateur(String login, String password) {
	this.login = login;
	this.password = password;
}
public Utilisateur(int idUser, String fullName) {
	this.idUser = idUser;
	this.fullName = fullName;
}
public Utilisateur(int idUser, String nom, String prenom, String email,
		String matricule, String dateN, String lieu, String adresse,
		String login, String password, String role) {
	this.idUser = idUser;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.matricule = matricule;
	this.dateN = dateN;
	this.lieu = lieu;
	this.adresse = adresse;
	this.login = login;
	this.password = password;
	this.role = role;
}
public Utilisateur(int idUser, String nom, String prenom,String matricule) {
	this.idUser = idUser;
	this.nom = nom;
	this.prenom = prenom;
	this.matricule = matricule;
}
public Utilisateur(String nom, String prenom, String email, String matricule,
		String dateN, String lieu, String adresse, String login, String password,
		String role) {
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.matricule = matricule;
	this.dateN = dateN;
	this.lieu = lieu;
	this.adresse = adresse;
	this.login = login;
	this.password = password;
	this.role = role;
}

public int getIdUser() {
	return idUser;
}
public void setIdUser(int id){
	this.idUser = id;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName){
	this.fullName = fullName;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMatricule() {
	return matricule;
}

public void setMatricule(String matricule) {
	this.matricule = matricule;
}

public String getDateN() {
	return dateN;
}

public void setDateN(String dateN) {
	this.dateN = dateN;
}

public String getLieu() {
	return lieu;
}

public void setLieu(String lieu) {
	this.lieu = lieu;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
   
}
