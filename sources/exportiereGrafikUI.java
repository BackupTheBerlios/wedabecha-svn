/*
 * Created on 19.11.2004
 * @author Martin M�ller
 */

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
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class exportiereGrafikUI {
	private exportiereGrafik export = new exportiereGrafik();
	
	public exportiereGrafikUI () {
		//erzeugen eines neuen Objekts "fc"
		JFileChooser fc = new JFileChooser();
		
		fc.setDialogTitle("Grafik exportieren");	
		fc.setDialogType(JFileChooser.SAVE_DIALOG);
		
    
		fc.setFileFilter( new FileFilter() {
			public boolean accept( File f ) {
				return 	f.isDirectory() ||
						f.getName().toLowerCase().endsWith(".png");
  			} // accept()
			
			public String getDescription() {
				return "Portierbare NetzwerkGrafik (*.png)";
  			}
  		} ); //zeigt nur Dateien mit der Endung .png an
    
		int returnVal = fc.showSaveDialog( null );
		
		if ( returnVal == JFileChooser.APPROVE_OPTION ) {
			//R�ckgabe der gew�hlten Datei als "file"
			File file = fc.getSelectedFile();
			System.out.println( file.getName() );
			export.setFile(file.getAbsolutePath());
			
			try{
			export.export(); // muss mit try-catch abgefangen werden!!! 
			}
			
			//Datei gibt's nich'
			catch ( Exception e ) {
					System.err.println( "Datei gibt's nicht." );
					}

		} else {
			System.out.println( "Auswahl abgebrochen" );
		} // fi
	}//exportiereGrafikUI()
	
	public static void main(String args[]){
		new exportiereGrafikUI();	
	}
	
}//exportiereGrafikUI()