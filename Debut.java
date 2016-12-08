//----------------------------------------------------------------------
//----------------------------------------------------------------------
//
//		-------------------------------------
//		 Exercice de plus en plus complique:
//		-------------------------------------
//
//----------------------------------------------------------------------
//----------------------------------------------------------------------

//	Java-Langage
//	
import java.io.*;
import java.util.*;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

//----------------------------------------------------------------------
//----------------------------------------------------------------------

interface Executeur {
	// debut d'interface
	// ----------------------------------------------------------------------

	public void executer(int p);

	// ----------------------------------------------------------------------
	// fin d'interface
}

// ----------------------------------------------------------------------
// ----------------------------------------------------------------------

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
		/*
		addMouseListener(new MouseAdapter(){	    
		    public void mouseClicked(MouseEvent e) {
		       if(e.getClickCount()==2){
		    	   xeq.executer(mission);  
		       }
		    }
		   });*/
	}

	
	public void valueChanged(ListSelectionEvent e) {
		xeq.executer(mission);
      }

	// ----------------------------------------------------------------------
	// fin de classe
}

// ----------------------------------------------------------------------
// ----------------------------------------------------------------------

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
		// TODO Auto-generated method stub
		xeq.executer(mission);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		xeq.executer(mission);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		xeq.executer(mission);
	}

	// ----------------------------------------------------------------------
	// fin de classe
}

// ----------------------------------------------------------------------
// ----------------------------------------------------------------------
