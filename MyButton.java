import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 *	Bouton ordinaire qui est son propre 'ActionListener'.
 */

public class MyButton  extends Button implements ActionListener {
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
