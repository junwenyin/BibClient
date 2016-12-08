/*
 * BibFrameControler.java
 * @author Qian Junwen
 * 01/12/2016
 * version 1.0 
 * 
 * 1. construction des frames-login, table, detail.
 * 2. Actions des differents boutons de l'application.
 */


//	Java-Graphisme
//	
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import java.util.Vector;

//	Java-une bibliothèque graphique
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BibFrameControler implements Executeur {

// debut de classe			
//----------------------------------------------------------------------
	
	
	public static BibFrameControler theAppli;
	MyTable table;
	MyTableModel myTableModel;
	JScrollPane scrollpane;
	MyTextField textFieldID;
	MyTextField textFieldName;
	MyTextField textFieldAuteur;
	MyButton bGo;
	MyButton buttonAffichier;
	String str_id;
	String str_Server="";
	JFrame myFrame;
	JPanel myPanel;

	JFrame loginFrame;
	MyTextField text_user;
	MyTextField text_pass;
	Label userlb;
	Label passlb;
	MyButton bLogin;
	MyButton bInscire;

	Frame dFrame;
	TextArea ta12;

/**
 *	Raccourci d'ecriture sur la sortie standard.
 */	
	public static void a(String s) {
		System.out.println(s);
	}
/**	
*	 construction de frame du contenu de livre 
*/
	void intDFrame() {
		Panel pDetail;
		Panel pTxt;
		Label tf11;

		dFrame = new Frame("DETAIL");
		dFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dFrame.setVisible(false);
				;
			}
		});
		dFrame.setBounds(500, 300, 800, 600);
		pDetail = new Panel();
		pTxt = new Panel();
		tf11 = new Label("DETAIL");

		ta12 = new TextArea(30, 100);
		pDetail.add(tf11);
		pTxt.add(ta12);

		dFrame.add(pDetail, BorderLayout.NORTH);
		dFrame.add(pTxt, BorderLayout.CENTER);

		dFrame.setSize(800, 600);
		dFrame.validate();

		dFrame.setVisible(true);
	}

/**	
*	 construction de frame-login
*/
	void initLoginFrame() {
		loginFrame = new JFrame("Login");
		loginFrame.setTitle("Please Login");
		loginFrame.setLayout(null);
		loginFrame.setSize(260, 170);
		loginFrame.setResizable(false);
		userlb = new Label("UserName:");
		passlb = new Label("PassWord:");
		bLogin = new MyButton(1, this, "Login");
		bInscire = new MyButton(2, this, "S'inscrire");
		text_user = new MyTextField(11, this, "user");
		text_pass = new MyTextField(12, this, "pass");
		userlb.setBounds(30, 53, 70, 20);
		passlb.setBounds(30, 83, 70, 20);
		text_user.setBounds(110, 50, 120, 20);
		text_pass.setBounds(110, 80, 120, 20);
		bLogin.setBounds(42, 120, 80, 25);
		bInscire.setBounds(135, 120, 80, 25);
		loginFrame.add(text_user);
		loginFrame.add(text_pass);
		loginFrame.add(bLogin);
		loginFrame.add(bInscire);
		loginFrame.setVisible(true);
		loginFrame.validate();
	}
/**	
*	 construction de frame-table
*/
	void initMyFrame() {
		myFrame = new JFrame();
		myPanel = new JPanel();
		myFrame.setTitle("BIB Client");
		myPanel.setLayout(null);
		myFrame.setSize(1200, 700);
		myFrame.setResizable(false);
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		JLabel labelA = new JLabel("ID: ");
		textFieldID = new MyTextField(4, this, "");
		JLabel labelB = new JLabel("NOM: ");
		textFieldName = new MyTextField(5, this, "");
		JLabel labelC = new JLabel("AUTEUR: ");
		textFieldAuteur = new MyTextField(6, this, "");

		bGo = new MyButton(3, this, "CherCher");
		myPanel.add(labelA);

		buttonAffichier = new MyButton(8, this, "Affichier");
		myPanel.add(buttonAffichier);
		buttonAffichier.setBounds(910, 30, 100, 20);

		labelA.setBounds(50, 30, 20, 20);
		myPanel.add(labelB);
		labelB.setBounds(280, 30, 50, 20);
		myPanel.add(labelC);
		labelC.setBounds(530, 30, 80, 20);
		myPanel.add(bGo);
		bGo.setBounds(800, 30, 100, 20);
		myPanel.add(textFieldID);
		textFieldID.setBounds(70, 30, 200, 20);
		myPanel.add(textFieldName);
		textFieldName.setBounds(320, 30, 200, 20);
		myPanel.add(textFieldAuteur);
		textFieldAuteur.setBounds(590, 30, 200, 20);
		
		myTableModel = new MyTableModel();
		table = new MyTable(7,myTableModel,this); 
		scrollpane = new JScrollPane(table); 
		scrollpane.setBounds(50, 80, 1100, 520);
		myPanel.add(scrollpane); 

		myFrame.add(myPanel);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(false);
		myFrame.validate();

	}
/**
 *	Actions des differents boutons de l'application.
 *	(avec erreurs, parfois)
 */
	@Override
	public void executer(int mission) {
		// TODO Auto-generated method stub
		switch (mission) {
		case 1: // apres log-in, on passe de frame-login à frame-table
		{
			String user = text_user.getText();
			String pass = text_pass.getText();

			if (user.equals("") || pass.equals("")) {//	si vous n'avez pas entré les informations complètes
				JOptionPane.showMessageDialog(null, "saisir l'information, SVP!");
				return;
			} else {//	on passe de frame-login à frame-table avec sucèes
				loginFrame.setVisible(false);
				myFrame.setVisible(true);
			}

		}
			break;
		case 2: // S'inscrire
		{
		}
			break;
		case 3: // appuyez le bouton-chercher
		{
			a("chercher");
			doChercher();
			textFieldID.setEditable(true);
			textFieldName.setEditable(true);
			textFieldAuteur.setEditable(true);
		}
			break;
		case 4: // entre dans le textfield de id
		{
			a("textFieldID");
			textFieldName.setEditable(false);
			textFieldAuteur.setEditable(false);
			textFieldID.setEditable(true);
		}
			break;
		case 5: //  entre dans le textfield de nom de livre
		{
			a("textFieldName");
			textFieldName.setEditable(true);
			textFieldID.setEditable(false);
			textFieldAuteur.setEditable(false);
		}
			break;
		case 6: //  entre dans le textfield de auteur de livre
		{
			a("textFieldAuteur");
			textFieldAuteur.setEditable(true);
			textFieldID.setEditable(false);
			textFieldName.setEditable(false);
		}
			break;
		case 7: // vous avez cliqué un ligne
		{
			a("table");
			
			int row = table.getSelectedRow();
			str_id = table.getValueAt(row, 0).toString();
			str_Server = table.getValueAt(row, 4).toString();
			table.updateUI();
			a(str_id);
		}
			break;
		case 8: // vous avez appuyez le bouton-affchier
		{
			a("affichier");
			doAfichier();
		}
			break;
		default:
			break;
		}
	}
	
/**
 *	Affichier le contenu de livre dans le frame de detail
 *	
 */
	
	private void doAfichier() {
		int port = 5000;
		switch (str_Server) {
		case "BJ":
			port = 5000;
			break;
		case "WH":
			port = 5001;
			break;
		case "Paris":
			port = 5003;
			break;
		case "Cergy":
			port = 5002;
			break;
		default:
			break;
		}
		ArrayList<String> str = ClientSocket.getInstance().myGo("TYPE=0003;ID=" + str_id + ";TOKEN=Junwen;", port);
		intDFrame();
		for (String l : str) {
			ta12.append(l);
		}
		dFrame.validate();
	}
/**
 *	chercher un livre par id, auteur ou name
 *	
 */
	void doChercher() {
		try {

			ArrayList<String> list = new ArrayList<String>();
			if (textFieldID.isEditable()) {
				list = ClientSocket.getInstance()
						.myGo("TYPE=0002;ID=" + textFieldID.getText().trim() + ";TOKEN=Junwen;", 5000);
			} else if (textFieldName.isEditable()) {
				list = ClientSocket.getInstance()
						.myGo("TYPE=0002;NAME=" + textFieldName.getText().trim() + ";TOKEN=Junwen;", 5000);
			} else if (textFieldAuteur.isEditable()) {
				list = ClientSocket.getInstance()
						.myGo("TYPE=0002;AUTEUR=" + textFieldAuteur.getText().trim() + ";TOKEN=Junwen;", 5000);
			} else {
				list = ClientSocket.getInstance().myGo("TYPE=0001;TOKEN=Junwen;", 5000);
			}
			myTableModel.setData(list);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void myGo() {
		initMyFrame();
		initLoginFrame();
	}

	public static void main(String[] args) throws Exception {
		theAppli = new BibFrameControler();
		theAppli.myGo();
	}

//----------------------------------------------------------------------
// fin de classe	
	}

//----------------------------------------------------------------------
//----------------------------------------------------------------------
