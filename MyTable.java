import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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