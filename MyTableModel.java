/*
 * MyTableModel.java
 * @author Qian Junwen
 * 01/12/2016
 * version 1.0 
 * 
 * données analytiques
 * 
 */


import java.util.ArrayList;
import java.util.Vector;

//	Java-une bibliothèque graphique
import javax.swing.table.AbstractTableModel;


public class MyTableModel extends AbstractTableModel  
{  
// debut de classe
// ----------------------------------------------------------------------
    /* 
     *  Définition de la tête de ligne et objet colonne
     */  
    String[] columnNames =  
    { "ID", "Name", "Auteur", "Special", "Server","Choix" };  
    Object[][] data = new Object[1][6];  

    /** 
     * valeur du table par défaut
     */  
    public MyTableModel()  
    {   
    	data[0][0]="ID";
		data[0][1]= "Name";
		data[0][2]="Auteur";
		data[0][3]="Special";
		data[0][4]="Server";
		data[0][5]=new Boolean(false); 
    }  

    /** 
     * données analytiques
     */ 
    public void setData(ArrayList<String> list){
    	data = new Object[list.size()-1][6];
    	for (int i = 1; i < list.size(); i++) {
			Vector<String> vector = new Vector<String>();
			String str = list.get(i);
			System.out.println("*******" + str);

			String bookInfo = str.substring(0, str.length() - 1);
			String[] fields = bookInfo.split(",");
			Book book = new Book();
			for (String info : fields) {
				String[] pair = info.split("=");
				{
					if (pair.length == 2) {
						String key = pair[0];
						String value = pair[1];
						if (key.equals("ID")) {
							book.setId(value);
						} else if (key.equals("Name")) {
							book.setName(value);
						} else if (key.equals("Auteur")) {
							book.setAuteur(value);
						} else if (key.equals("Dir")) {
							book.setDir(value);
						} else if (key.equals("SERVER")) {
							book.setServer(value);
						} else if (key.equals("Special")) {
							book.setSpecial(value);
						}
					}
				}
			}
			data[i-1][0]=book.getId();
			data[i-1][1]=book.getName();
			data[i-1][2]=book.getAuteur();
			data[i-1][3]=book.getSpecial();
			data[i-1][4]=book.getServer();
			data[i-1][5]=new Boolean(false);  
		}
    	
    	fireTableDataChanged();//	données sont changé
    }
    /** 
     * Obtenez le nom de colonnes
     */  
    @Override  
    public String getColumnName(int column)  
    {  
        return columnNames[column];  
    }  
      
    /** 
     * Obtenez le nombre de colonnes
     */  
    @Override  
    public int getColumnCount()  
    {  
        return columnNames.length;  
    }  

    /** 
     * Obtenez le nombre de lignes
     */  
    @Override  
    public int getRowCount()  
    {  
        return data.length;  
    }  

    /** 
     * Obtenez les données du table
     */  
    @Override  
    public Object getValueAt(int rowIndex, int columnIndex)  
    {  
        return data[rowIndex][columnIndex];  
    }  

    /** 
     * Définissez le type de la valeur de retour de données
     */  
    @Override  
    public Class<?> getColumnClass(int columnIndex)  
    {  
        return data[0][columnIndex].getClass();  
    }  

    /** 
     * le table ne peut pas être modifié
     */  
    @Override  
    public boolean isCellEditable(int rowIndex, int columnIndex)  
    {  
            return false;  
    }  
      
    /** 
     * on met les valeurs de aValue dans rowIndex et columnIndex
     * Mise à jour le table
     */  
    @Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)  
    {  
        data[rowIndex][columnIndex] = aValue;  
        
        fireTableCellUpdated(rowIndex, columnIndex);  
    }  

//----------------------------------------------------------------------
// fin de classe	
	}

//----------------------------------------------------------------------
//----------------------------------------------------------------------
