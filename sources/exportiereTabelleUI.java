/****************************************************************************
 *   Copyright (C) 2004 by BTU SWP GROUP 04/6.1								*
 *																			*
 *   This program is free software; you can redistribute it and/or modify	*
 *   it under the terms of the GNU General Public License as published by	*
 *   the Free Software Foundation; either version 2 of the License, or		*
 *   (at your option) any later version.									*
 *																			*
 *   This program is distributed in the hope that it will be useful,		*
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of			*
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the			*
 *   GNU General Public License for more details.							*
 *																			*
 *   You should have received a copy of the GNU General Public License		*
 *   along with this program; if not, write to the							*
 *   Free Software Foundation, Inc.,										*
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.				*
 ***************************************************************************/

//Diese Klasse dient zum Aufruf des "Speichern"-Dialoges


import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class exportiereTabelleUI {
	private exportiereTabelle export = new exportiereTabelle();
	
	public exportiereTabelleUI () {
		//erzeugen eines neuen Objekts "fc"
		JFileChooser fc = new JFileChooser();
		
		fc.setDialogTitle("Tabellendaten exportieren");	
		fc.setDialogType(JFileChooser.SAVE_DIALOG);
		
    
		fc.setFileFilter( new FileFilter() {
			public boolean accept( File f ) {
				return 	f.isDirectory() ||
						f.getName().toLowerCase().endsWith(".weda");
  			} // accept()
			
			public String getDescription() {
				return "WeDaBeCha Tabellendatei (*.weda)";
  			}
  		} ); //zeigt nur Dateien mit der Endung .jpg an
    
		int returnVal = fc.showSaveDialog( null );
		
		if ( returnVal == JFileChooser.APPROVE_OPTION ) {
			//Rückgabe der gewählten Datei als "file"
			File file = fc.getSelectedFile();
			System.out.println( file.getName() );
			export.setFile(file.getAbsolutePath());
			
			try{
			export.export(); // muss mit try-catch abgefangen werden!!! 
			}
			
			// io-Fehler abfangen
			catch ( Exception e ) {
					System.err.println( "Fehler beim Export!" );
					}

		} else {
			System.out.println( "Auswahl abgebrochen" );
		} // fi
		
		fc.setVisible(false); //is klar, ne
	}
	
	public static void main(String args[]){
		new exportiereTabelleUI();	
	}
	
}//exportiereTabelleUI()