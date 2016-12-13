import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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