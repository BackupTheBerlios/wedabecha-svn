/****************************************************************************
 *   Copyright (C) 2005 by BTU SWP GROUP 04/6.1                             *
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
	speichert die Daten in Programmeigenem (CSV :D ) Format, das verknüpft werden kann.
	wird von exportiereTabelle und von importiereTabelle aufgerufen...
*/

import java.io.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;


class toWeda {

	protected static void writeFile(String fileName, int tabellenNummer){
		ArrayList werteAL;
		ArrayList datenAL;

		String zeile = new String("");
		String subZeile = new String("");
		double werteA[];
		String datenA[];

		werteAL = wedabecha.getKurve(tabellenNummer).getWerte();
		datenAL = wedabecha.getKurve(tabellenNummer).getDaten();

		// das erste mal...rofl....ne die datei schreiben... :D

		try {
			FileWriter fw = new FileWriter( fileName );
			fw.write("");
			fw.close();
		} catch (IOException except){
			toWedaErrorUI.showWriteError(fileName);
		} // try

		// zeilenweises anhängen der zeilen an die datei
		try {
			FileWriter fa = new FileWriter(fileName, true);

			for (int i = 0; i < werteAL.size(); i++){
				werteA = (double[])werteAL.get(i);
				datenA = (String[])datenAL.get(i);
				for (int j = 0; j < werteA.length; j++){

						subZeile += werteA[j];
						if (j != werteA.length - 1 )subZeile += ";";

				}
 				zeile += datenA[0] + ";" + datenA[1] + ";" + datenA[2] + ";" + subZeile;
				if (i != werteAL.size() - 1) zeile += "\n";
				fa.write(zeile);
				zeile = "";
				subZeile = "";
			} // for(i)

			fa.close();
		} catch (IOException except){
			toWedaErrorUI.showAppendError(fileName);
		} // try

	} // writeFile()


} // toWeda

class FileWriter extends OutputStreamWriter {
	public FileWriter(String fileName) throws FileNotFoundException {
			super(new FileOutputStream(fileName));
	} // fileWriter

	public FileWriter(String fileName, boolean append)  throws FileNotFoundException {
			super(new FileOutputStream(fileName, append));
	}
} // fileWriter


class toWedaErrorUI {

	protected static void showWriteError(String fileName){
		JOptionPane.showMessageDialog(null,
		"Datei" + fileName + "konnte nicht geschrieben werden.","Dateifehler",
		JOptionPane.ERROR_MESSAGE );
	} // showWriteError()


	protected static void showAppendError(String fileName){
		JOptionPane.showMessageDialog(null,
		"Datei " + fileName + "konnte nicht verändert werden","Dateifehler",
		JOptionPane.ERROR_MESSAGE );
	} // showAppendError()


	protected static void showFNFE(String fileName){
		JOptionPane.showMessageDialog(null,
		"Datei" + fileName + "konnte nicht gefunden werden.","Dateifehler",
		JOptionPane.ERROR_MESSAGE );
	} // showFNFE()
} // toWedaErrorUI