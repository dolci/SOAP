package tn.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String login;
	String password;
	String email;
	String nom;
	String prenom;
	String role;
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public UserDTO(){};
	public UserDTO(String login, String password) {
		
		this.login = login;
		this.password = password;
	}

	public UserDTO(String login, String password, String email, String nom,
			String prenom, String role) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}
	

}
