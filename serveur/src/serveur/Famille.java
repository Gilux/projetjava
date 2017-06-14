package serveur;

import java.io.Serializable;

public class Famille implements Serializable {
	private int id;
	private String nom;
	
	
	public Famille(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Famille()
	{
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Famille [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	
}
