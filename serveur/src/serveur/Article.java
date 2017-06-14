package serveur;

import java.io.Serializable;

public class Article implements Serializable {
	public int id;
	public int stock;
	public String nom;
	public String famille;
	public double prix;
	
	
	public Article(int id, int stock, String nom, String famille, double prix) {
		super();
		this.id = id;
		this.stock = stock;
		this.nom = nom;
		this.famille = famille;
		this.prix = prix;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getFamille() {
		return famille;
	}


	public void setFamille(String famille) {
		this.famille = famille;
	}

	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", stock=" + stock + ", nom=" + nom + ", famille=" + famille + ", prix=" + prix
				+ "]";
	}
}
