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

// Diese Klasse dient zum Aufruf des "Speichern"-Dialoges


import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.util.regex.*;

public class exportiereGrafikUI {
	private exportiereGrafik export = new exportiereGrafik();

	public exportiereGrafikUI () {
		// erzeugen eines neuen Objekts "fc"
		JFileChooser fc = new JFileChooser();

		fc.setDialogTitle("Grafik exportieren");
		fc.setDialogType(JFileChooser.SAVE_DIALOG);


		fc.setFileFilter( new FileFilter() {
			public boolean accept( File f ) {
				return 	f.isDirectory() ||
						f.getName().toLowerCase().endsWith(".jpg");
  			} // accept()

			public String getDescription() {
				return "JPEG-Bilddatei (*.jpg)";
  			}
  		} ); //zeigt nur Dateien mit der Endung .jpg an

		int returnVal = fc.showSaveDialog( null );

		if ( returnVal == JFileChooser.APPROVE_OPTION ) {
			// Rückgabe der gew�lten Datei als "file"
			File file = fc.getSelectedFile();
			System.out.println( file.getName() );

			//Prüfung, ob Dateiname & Endung eigegeben wurden
			String filename  = file.getName();
			boolean isjpg = filename.endsWith( ".jpg" );

			if (isjpg == true) {
				export.setFile(file.getAbsolutePath());
			} else {
				export.setFile(file.getAbsolutePath()+".jpg");
			}//if

			export.export();

		} else {
			System.out.println( "Auswahl abgebrochen" );
		} // fi

		fc.setVisible(false); // is klar, ne
	} // exportiereGrafikUI()


	protected static void showEncodeError(){
		JOptionPane.showMessageDialog(null,
		"Die JPEG-Datei konnte nicht encodiert werden.","Dateifehler",
		JOptionPane.ERROR_MESSAGE );
	} // showEncodeError()


	protected static void showCouldNotCloseError(){
		JOptionPane.showMessageDialog(null,
		"Konnte den JPEG-Output-Stream nicht schliessen.","Dateifehler",
		JOptionPane.ERROR_MESSAGE );
	} // showCouldNotCloseError()


	protected static void showFileNotFoundError(String dateiname){
		JOptionPane.showMessageDialog(null,
		"Die Datei " + dateiname + "konnte nicht geschrieben werden","Dateifehler",
		JOptionPane.ERROR_MESSAGE );
	} // showFileNotFoundError()


	/*
	public static void main(String args[]){
		new exportiereGrafikUI();
	}
	*/

} // exportiereGrafikUI()
