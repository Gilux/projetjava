package projetcomposants;

import java.util.List;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import projetrmi.RMI;
import serveur.Article;

public class Application {
	
	private Window fen;
	
	public Application() {
		this.fen = new Window(this);
	}
	
	public static void main(String[] args) {
		Application client = new Application();
		client.updateTable();
		//fen.hidePan();
	}
	
	public void connectServer() {
		
	}
	
	public void updateTable() {
		try{
			JTextField search = this.fen.getSearchTextField();
			System.out.println(search.getText());
			
			Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099);
			RMI rmi = (RMI) reg.lookup("server");
			System.out.println("Connected to server");
			//String text = rmi.getData("gilux");
			//System.out.println(text);
			
			List<Article> listeArticles = rmi.getListeArticles(search.getText());
			
			JTable tableArticles = this.fen.getTableArticles();
			
			DefaultTableModel model = (DefaultTableModel) tableArticles.getModel();
			model.setRowCount(0);
			
			
			for (Article temp : listeArticles) {
				model.addRow(new Object[]{temp.getNom(), temp.getFamille(), temp.getPrix(), temp.getStock()});
			}
			
			//List<Article> listeArticles = rmi.getListeArticles();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
