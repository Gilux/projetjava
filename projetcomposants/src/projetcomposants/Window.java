package projetcomposants;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import java.awt.Label;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.SpringLayout;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
	
public class Window {

	private JFrame frmGestionDeStock;
	private JTable tableArticle;
	private JTextField textField_refProduit;
	
	private JPanel panelDetailsProduit = null;
	private JTable tableContenuPanier;
	private JTextField textFieldNomRecherche;
	private JTextField textFieldNewNom;
	private JTable table_1;
	private JTextField textFieldNewAdresse;
	
	private Application application;
	private JTextField textFieldNewPrenom;
	private JTextField textFieldNewCP;
	private JTextField textFieldNewVille;


	/**
	 * Create the application.
	 */
	public Window(Application app) {
		this.application = app;
		initialize();
	}
	
	public enum FamillesComposants {
	    RESISTANCES,
	    CONDENSATEURS,
	    PILES,
	    LED;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeStock = new JFrame();
		frmGestionDeStock.setTitle("Gestion de stock");
		frmGestionDeStock.setBounds(100, 100, 979, 660);
		frmGestionDeStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lbl_titre = new JLabel("Mon magasin");
		lbl_titre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_titre.setHorizontalAlignment(SwingConstants.CENTER);
		frmGestionDeStock.getContentPane().add(lbl_titre, BorderLayout.NORTH);
		
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		frmGestionDeStock.getContentPane().add(tabbedPanel, BorderLayout.CENTER);
		
		
		Panel panelStock = new Panel();
		tabbedPanel.addTab("Gestion du stock", null, panelStock, null);
		panelStock.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHeader = new JPanel();
		panelStock.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblRechercherUnProduit = new JLabel("Rechercher un produit :");
		panelHeader.add(lblRechercherUnProduit);
		
		textField_refProduit = new JTextField();
		panelHeader.add(textField_refProduit);
		textField_refProduit.setColumns(10);
		
		JLabel lblFiltrerParFamille = new JLabel("Filtrer par famille de composants :");
		panelHeader.add(lblFiltrerParFamille);
		
		JComboBox comboBox_familleComposant = new JComboBox();
		comboBox_familleComposant.setModel(new DefaultComboBoxModel(new String[] {"Condensateurs", "Piles", "R\u00E9sistances", "LED", "Diodes"}));
		panelHeader.add(comboBox_familleComposant);
		
		JButton btnRechercher = new JButton("Rechercher");
		panelHeader.add(btnRechercher);
		
		JPanel panelDroite = new JPanel();
		panelStock.add(panelDroite, BorderLayout.CENTER);
		SpringLayout sl_panelDroite = new SpringLayout();
		panelDroite.setLayout(sl_panelDroite);
		
		JPanel panel_6 = new JPanel();
		sl_panelDroite.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panelDroite);
		sl_panelDroite.putConstraint(SpringLayout.WEST, panel_6, 0, SpringLayout.WEST, panelDroite);
		sl_panelDroite.putConstraint(SpringLayout.SOUTH, panel_6, 157, SpringLayout.NORTH, panelDroite);
		sl_panelDroite.putConstraint(SpringLayout.EAST, panel_6, 656, SpringLayout.WEST, panelDroite);
		panelDroite.add(panel_6);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);
		
		JLabel lblProduitSlectionn = new JLabel("Produit s\u00E9lectionn\u00E9");
		sl_panel_6.putConstraint(SpringLayout.NORTH, lblProduitSlectionn, 0, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, lblProduitSlectionn, 49, SpringLayout.NORTH, panel_6);
		panel_6.add(lblProduitSlectionn);
		
		JLabel lblNomProduit = new JLabel("------------");
		sl_panel_6.putConstraint(SpringLayout.EAST, lblProduitSlectionn, -82, SpringLayout.WEST, lblNomProduit);
		sl_panel_6.putConstraint(SpringLayout.NORTH, lblNomProduit, 0, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, lblNomProduit, 328, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, lblNomProduit, 0, SpringLayout.EAST, panel_6);
		panel_6.add(lblNomProduit);
		
		JLabel lblPrixUnitaire = new JLabel("Prix Unitaire");
		sl_panel_6.putConstraint(SpringLayout.NORTH, lblPrixUnitaire, 6, SpringLayout.SOUTH, lblProduitSlectionn);
		sl_panel_6.putConstraint(SpringLayout.WEST, lblProduitSlectionn, 0, SpringLayout.WEST, lblPrixUnitaire);
		sl_panel_6.putConstraint(SpringLayout.WEST, lblPrixUnitaire, 82, SpringLayout.WEST, panel_6);
		panel_6.add(lblPrixUnitaire);
		
		JLabel labelPU = new JLabel("------------");
		sl_panel_6.putConstraint(SpringLayout.NORTH, labelPU, 55, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, lblPrixUnitaire, 0, SpringLayout.WEST, labelPU);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, lblNomProduit, -6, SpringLayout.NORTH, labelPU);
		sl_panel_6.putConstraint(SpringLayout.WEST, labelPU, 328, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, labelPU, 0, SpringLayout.EAST, panel_6);
		panel_6.add(labelPU);
		
		JPanel panelAchat = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.SOUTH, lblPrixUnitaire, -6, SpringLayout.NORTH, panelAchat);
		sl_panel_6.putConstraint(SpringLayout.NORTH, panelAchat, 110, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, panelAchat, 0, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panelAchat, 2, SpringLayout.SOUTH, panel_6);
		panel_6.add(panelAchat);
		
		JSpinner spinner = new JSpinner();
		panelAchat.add(spinner);
		
		JButton btnAchat = new JButton("Achat");
		panelAchat.add(btnAchat);
		
		JPanel panelAjout = new JPanel();
		sl_panel_6.putConstraint(SpringLayout.NORTH, panelAjout, 110, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, panelAchat, 0, SpringLayout.WEST, panelAjout);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, labelPU, -6, SpringLayout.NORTH, panelAjout);
		sl_panel_6.putConstraint(SpringLayout.WEST, panelAjout, 0, SpringLayout.WEST, lblNomProduit);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, panelAjout, 2, SpringLayout.SOUTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, panelAjout, 656, SpringLayout.WEST, panel_6);
		panel_6.add(panelAjout);
		
		JSpinner spinner_1 = new JSpinner();
		panelAjout.add(spinner_1);
		
		JButton btnAjoutAuStock = new JButton("Ajout au stock");
		panelAjout.add(btnAjoutAuStock);
		
		JPanel panelPanier = new JPanel();
		sl_panelDroite.putConstraint(SpringLayout.NORTH, panelPanier, 6, SpringLayout.SOUTH, panel_6);
		sl_panelDroite.putConstraint(SpringLayout.WEST, panelPanier, 0, SpringLayout.WEST, panelDroite);
		sl_panelDroite.putConstraint(SpringLayout.SOUTH, panelPanier, 530, SpringLayout.NORTH, panelDroite);
		sl_panelDroite.putConstraint(SpringLayout.EAST, panelPanier, 656, SpringLayout.WEST, panelDroite);
		panelDroite.add(panelPanier);
		panelPanier.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panelPanier.add(panel_9, BorderLayout.NORTH);
		
		JLabel lblPanier = new JLabel("Panier");
		panel_9.add(lblPanier);
		
		JButton btnViderPanier = new JButton("Vider Panier");
		panel_9.add(btnViderPanier);
		
		JButton btnPasserCommande = new JButton("Passer commande");
		panel_9.add(btnPasserCommande);
		
		JPanel panel_10 = new JPanel();
		panelPanier.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_10.add(scrollPane, BorderLayout.CENTER);
		
		tableContenuPanier = new JTable();
		tableContenuPanier.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Composant", "Quantit\u00E9", "Prix Unitaire", "Prix Total"
			}
		));
		scrollPane.setViewportView(tableContenuPanier);
		
		
		JPanel panelListeArticle = new JPanel();
		panelStock.add(panelListeArticle, BorderLayout.WEST);
		panelListeArticle.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panelListeArticle.add(panel_4, BorderLayout.CENTER);
		panel_4.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel_4.setLayout(new BorderLayout(0, 0));
		
		tableArticle = new JTable();
		tableArticle.setModel(new DefaultTableModel(
			new Object[][] {
				{"R50", null, new Double(0.06), new Integer(11)},
				{"R60", null, new Double(0.09), new Integer(4)},
				{"R70", null, new Double(0.11), new Integer(16)},
				{"R80", null, new Double(0.12), new Integer(22)},
				{"R90", null, new Double(0.16), new Integer(1)},
				{"R100", null, new Double(0.23), new Integer(4)},
				{"R200", null, new Double(0.4), new Integer(33)},
			},
			new String[] {
				"R\u00E9f\u00E9rence", "Famille", "P.U", "Stock"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		panel_4.add(tableArticle);
		tableArticle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableArticle.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		panel_4.add(tableArticle.getTableHeader(), BorderLayout.NORTH);
		
		ListSelectionModel listModel = tableArticle.getSelectionModel();
		
		listModel.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
	            System.out.println(tableArticle.getValueAt(tableArticle.getSelectedRow(), 0).toString());
	        }
		});
		
		Panel panelFacturation = new Panel();
		tabbedPanel.addTab("Facturation", null, panelFacturation, null);
		panelFacturation.setLayout(null);
		
		JPanel panelNewClient = new JPanel();
		panelNewClient.setBounds(0, 0, 911, 172);
		panelFacturation.add(panelNewClient);
		panelNewClient.setLayout(null);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(12, 82, 46, 16);
		panelNewClient.add(lblAdresse);
		
		JLabel lblMontantDeLa = new JLabel("Montant de la facture :");
		lblMontantDeLa.setBounds(12, 111, 131, 16);
		panelNewClient.add(lblMontantDeLa);
		
		JLabel labelMontantPanier = new JLabel("40.5");
		labelMontantPanier.setBounds(155, 111, 25, 16);
		panelNewClient.add(labelMontantPanier);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setBounds(203, 111, 25, 16);
		panelNewClient.add(label_1);
		
		JComboBox comboBoxMoyenPayement = new JComboBox();
		comboBoxMoyenPayement.setBounds(145, 137, 275, 22);
		panelNewClient.add(comboBoxMoyenPayement);
		
		JLabel lblMoyenDePayement = new JLabel("Moyen de payement");
		lblMoyenDePayement.setBounds(12, 140, 115, 16);
		panelNewClient.add(lblMoyenDePayement);
		
		JLabel lblNom_1 = new JLabel("Nom");
		lblNom_1.setBounds(12, 53, 56, 16);
		panelNewClient.add(lblNom_1);
		
		JLabel lblNouveauClient = new JLabel("Nouveau Client");
		lblNouveauClient.setBounds(487, 13, 131, 16);
		panelNewClient.add(lblNouveauClient);
		
		textFieldNewNom = new JTextField();
		textFieldNewNom.setBounds(82, 50, 184, 22);
		panelNewClient.add(textFieldNewNom);
		textFieldNewNom.setColumns(10);
		
		JButton btnPayerLaFacture = new JButton("Payer la facture");
		btnPayerLaFacture.setBounds(653, 136, 153, 25);
		panelNewClient.add(btnPayerLaFacture);
		
		JButton btnEnregistrerFacture = new JButton("Enregistrer facture");
		btnEnregistrerFacture.setBounds(452, 136, 166, 25);
		panelNewClient.add(btnEnregistrerFacture);
		
		textFieldNewAdresse = new JTextField();
		textFieldNewAdresse.setBounds(82, 79, 404, 22);
		panelNewClient.add(textFieldNewAdresse);
		textFieldNewAdresse.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(278, 53, 56, 16);
		panelNewClient.add(lblPrenom);
		
		textFieldNewPrenom = new JTextField();
		textFieldNewPrenom.setBounds(339, 50, 147, 22);
		panelNewClient.add(textFieldNewPrenom);
		textFieldNewPrenom.setColumns(10);
		
		JLabel lblCodePostal = new JLabel("Code postal");
		lblCodePostal.setBounds(554, 53, 84, 16);
		panelNewClient.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(562, 82, 56, 16);
		panelNewClient.add(lblVille);
		
		textFieldNewCP = new JTextField();
		textFieldNewCP.setBounds(650, 50, 213, 22);
		panelNewClient.add(textFieldNewCP);
		textFieldNewCP.setColumns(10);
		
		textFieldNewVille = new JTextField();
		textFieldNewVille.setBounds(650, 79, 213, 22);
		panelNewClient.add(textFieldNewVille);
		textFieldNewVille.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 185, 911, 358);
		panelFacturation.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(23, 28, 56, 16);
		panel_1.add(lblNom);
		
		textFieldNomRecherche = new JTextField();
		textFieldNomRecherche.setBounds(75, 25, 245, 22);
		panel_1.add(textFieldNomRecherche);
		textFieldNomRecherche.setColumns(10);
		
		JButton btnRechercherClient = new JButton("Rechercher");
		btnRechercherClient.setBounds(12, 57, 97, 25);
		panel_1.add(btnRechercherClient);
		
		JComboBox comboBoxResultRecheClient = new JComboBox();
		comboBoxResultRecheClient.setBounds(121, 60, 759, 22);
		panel_1.add(comboBoxResultRecheClient);
		
		JScrollPane scrollPanelFactureClient = new JScrollPane();
		scrollPanelFactureClient.setBounds(23, 110, 860, 197);
		panel_1.add(scrollPanelFactureClient);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Mode de payement", "Montant"
			}
		));
		scrollPanelFactureClient.setViewportView(table_1);
		
		JButton btnPayerLaFactureAncienne = new JButton("Payer la facture selectinn\u00E9e");
		btnPayerLaFactureAncienne.setBounds(23, 320, 319, 25);
		panel_1.add(btnPayerLaFactureAncienne);
		
		JLabel lblClientConnu = new JLabel("Client connu");
		lblClientConnu.setBounds(487, 13, 107, 16);
		panel_1.add(lblClientConnu);
		btnRechercherClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frmGestionDeStock.setVisible(true);
	}
	
	public void hidePan()
	{
		this.panelDetailsProduit.hide();
	}
	
	public JTable getTableArticles()
	{
		return this.tableArticle;
	}
	
	public JTextField getSearchTextField()
	{
		return this.textField_refProduit;
	}
}
