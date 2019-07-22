package ui.gui.swing.models;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
//import javax.swing.table;
import valueObjects.Artikel;

public class ArtikelTabellenModel extends AbstractTableModel {
	private List<Artikel> artikel;
	private String[] spaltenNamen = { "Artikelnummer", "Artikelname", "Preis", "Packungsinhalt", "Bestand",
			"Verfuegbarkeit" };

	public ArtikelTabellenModel(List<Artikel> aktuelleArtikel) {
		super();
		artikel = new Vector<Artikel>();
		artikel.addAll(aktuelleArtikel);
	}

	public void setArtikel(List<Artikel> aktuelleArtikel) {
		artikel.clear();
		artikel.addAll(aktuelleArtikel);
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return artikel.size();
	}

	@Override
	public int getColumnCount() {
		return spaltenNamen.length;
	}


	    @Override
	    public String getColumnName(int col) {
	        return spaltenNamen[col];
	    }
	    
	    @Override
	    public Class<?> getColumnClass(int col) {
			if (artikel.isEmpty()) {
	            return Object.class;
	        }
			return getValueAt(0, col).getClass();
//			if(col == 4) {
//				f
//			}
		    
	    }

	    @Override
	    public Object getValueAt(int row, int col) {
	    	
	        Artikel gewaehlterArtikel = artikel.get(row);
	        switch (col) {
	            case 0:
	                return gewaehlterArtikel.getArtikelNummer();
	            case 1:
	                return gewaehlterArtikel.getArtikelName();
	            case 2:
	                return gewaehlterArtikel.getPreis();
	            case 3: 
	            	if(gewaehlterArtikel.getPack() == 0) {
//	            		return ("Keine Packung");
	            		int pack = 1;	
	            		return pack;
	            		
	            	}else {
	            	   	return gewaehlterArtikel.getPack(); 
	            	}
	            case 4:
	            	return gewaehlterArtikel.getAnzahl();
	            case 5: 
	            	if(gewaehlterArtikel.isVerfuegbar()) {
	            		return("Auf Lager");
	            	}else {
	            		return ("nicht verf�gbar"); 
	            	}
	            default:
	                return null;
	        }
	    }

}
