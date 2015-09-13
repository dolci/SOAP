package tn.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "user.getAllUser",query="SELECT b FROM User b" ),
@NamedQuery(name = "user.findUser",query="SELECT u FROM User u WHERE u.login = :login and u.password = :password" )
})
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String login;
	String password;
	String email;
	String nom;
	String prenom;
	String role_user;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getRole_user() {
		return role_user;
	}

	public void setRole_user(String role_user) {
		this.role_user = role_user;
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

	public User(String login, String password) {
		
		this.login = login;
		this.password = password;
	}

	public User(String login, String password, String email, String nom,
			String prenom) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	public User(){};
}
