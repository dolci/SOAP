package tn.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "article.getAllArticle",query="SELECT a FROM Article a" )
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String reference;
	String libelle;
	int quantite;
	double prix;
	int tva;
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	public Article(String libelle, double prix, int quantite,String reference, int tva)  {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.quantite = quantite;
		this.prix = prix;
		this.tva = tva;
	}
	
	public Article(){};
	
}
