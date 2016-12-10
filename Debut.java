/*
 * Debut.java
 * @author Qian Junwen
 * 01/12/2016
 * version 1.0 
 * 1.Interface obligatoire des executeurs pour le compte des boutons
 * 2.écoute aux boutons, table et textField
 */

//	Java-Langage
//	
import java.io.*;
import java.util.*;

//	Java-une bibliothèque graphique
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

//	Java-Graphisme
//
import java.awt.*;
import java.awt.event.*;

/**
 *	Interface obligatoire des executeurs pour le compte des boutons.
 */
interface Executeur {
	// debut d'interface
	// ----------------------------------------------------------------------

	public void executer(int p);

	// ----------------------------------------------------------------------
	// fin d'interface
}

// ----------------------------------------------------------------------
// ----------------------------------------------------------------------


/**
 *	Bouton ordinaire qui est son propre 'ActionListener'.
 */
class MyButton extends Button implements ActionListener {
	// debut de classe
	// ----------------------------------------------------------------------

	int mission;
	Executeur xeq;

	MyButton(int m, Executeur x, String s) {
		super(s);
		mission = m;
		xeq = x;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		xeq.executer(mission);
	}

	// ----------------------------------------------------------------------
	// fin de classe
}

/**
 *	JTable ordinaire qui est son propre 'ListSelectionListener'.
 */
class MyTable extends JTable implements ListSelectionListener {
	// debut de classe
	// ----------------------------------------------------------------------

	int mission;
	Executeur xeq;
	
	
	MyTable(int m, MyTableModel dataModel, Executeur x) {
		super(dataModel);
		mission = m;
		xeq = x;
		
		this.getSelectionModel().addListSelectionListener(this);

	}

	
	public void valueChanged(ListSelectionEvent e) {
		xeq.executer(mission);
      }

	// ----------------------------------------------------------------------
	// fin de classe
}

// ----------------------------------------------------------------------
// ----------------------------------------------------------------------

/**
 *	JTextField ordinaire qui est son propre 'DocumentListener'.
 */

class MyTextField extends JTextField implements DocumentListener {
	// debut de classe
	// ----------------------------------------------------------------------

	int mission;
	Executeur xeq;

	MyTextField(int m, Executeur x, String s) {
		super(s);
		mission = m;
		xeq = x;
		this.getDocument().addDocumentListener(this);
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		xeq.executer(mission);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		xeq.executer(mission);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		xeq.executer(mission);
	}

	// ----------------------------------------------------------------------
	// fin de classe
}

// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
