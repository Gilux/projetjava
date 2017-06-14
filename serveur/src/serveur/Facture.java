package serveur;

import java.io.Serializable;

public class Facture implements Serializable{
	private int id;
	private int client;
	private float total;
	private String paiement;
	
	
	public Facture(int id, int client, float total, String paiement) {
		super();
		this.id = id;
		this.client = client;
		this.total = total;
		this.paiement = paiement;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getClient() {
		return client;
	}


	public void setClient(int client) {
		this.client = client;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public String getPaiement() {
		return paiement;
	}


	public void setPaiement(String paiement) {
		this.paiement = paiement;
	}
}
