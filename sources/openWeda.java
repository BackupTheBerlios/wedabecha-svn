import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/****************************************************************************
 *   Copyright (C) 2004 by BTU SWP GROUP 04/6.1                             *
 *                                                                          *
 *   This program is free software; you can redistribute it and/or modify   *
 *   it under the terms of the GNU General Public License as published by   *
 *   the Free Software Foundation; either version 2 of the License, or	    *
 *   (at your option) any later version                                     *
 *                                                                          *
 *   This program is distributed in the hope that it will be useful,        *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of         *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the          *
 *   GNU General Public License for more details                            *
 *                                                                          *
 *   You should have received a copy of the GNU General Public License      *
 *   along with this program; if not, write to the                          *
 *   Free Software Foundation, Inc.,                                        *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.              *
 ***************************************************************************/

/**
	@author
		Martin Müller (mrtnmueller at users.berlios.de),
	@since 2005-01-28
	@version 0.7
*/

// Diese Klasse dient zum Öffnen der .weda-Dateien

import java.io.File;
import java.util.ArrayList;

public class openWeda {
	public openWeda () {
		
			//Tabellennummer abfragen
			String input = JOptionPane.showInputDialog("Bitte die darzustellende Kurvennummer angeben:" );
			
			try{	
				//wandelt den Eingabestring in eine int-Zahl um
				int kurvennummer = Integer.parseInt( input );
				
				//Abfrage, ob eine gültige Tabellennummer eingegeben wurde
				if (kurvennummer > 0 & kurvennummer < 6) {
					
						JFileChooser auswahlDialog = new JFileChooser();
						
						auswahlDialog.setFileFilter( new FileFilter() {
							//akzeptiert nur Dateien mit .jpg als Endung
							public boolean accept( File f ) {
								return 	f.isDirectory() ||
										f.getName().toLowerCase().endsWith(".weda");
							} // accept()
				
							//Beschreibung des Dateityps im Speichern-Dialog
							public String getDescription() {
								return "WeDaBeCha Tabellendatei (*.weda)";
							}//getDescription()
							
						} ); //setFileFilter()
						
				    	int returnVal = auswahlDialog.showOpenDialog(auswahlDialog);
				    	if(returnVal == JFileChooser.APPROVE_OPTION){
				    		
							importiereTabelle.setImportPfad(auswahlDialog.getSelectedFile().getPath());
							importiereTabelle.setTrennzeichenIndex(0);
							importiereTabelle.setDatumsFormatIndex(0);
							importiereTabelle.setDatumsPosFirstColumn(true);
							ArrayList resAL = importiereTabelle.getWerte();
							ArrayList ergebnis = importiereTabelle.getDaten();
				    	}//if
				
				}else {
				   	JOptionPane.showMessageDialog( null, "Die Tabellennummer war falsch !" );
				   } // if

				
			} catch(NumberFormatException error){
				JOptionPane.showMessageDialog
				(null,"Auswahl abgebrochen !","Fehler",JOptionPane.ERROR_MESSAGE );
			}; //try
			
	}//openWeda()
}//class openWeda