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
	Diese Datei enthält die Hintergrundfunktionen für importiereTabelle
*/

package importiereTabelle;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class importiereTabelle {

	// enthält nur den Namen der Datei
	private String importName;

	// der pfad setzt sich aus absolutem verzeichnis UND dateinamen zusammen
	private String importPfad;

	// wird gleich dem importNamen gesetzt
	private String internerSpeicherName;

	// internerSpeicherPfad is das verzeichnis relativ zum programm, wo .weda-dateien abgespeichert werden
	private String internerSpeicherPfad = "./daten/";

	private String trennzeichen;
	private String datumsFormat;
	static String datenFormate[] = {"YYYY-MM-DD","DD.MM.YYYY","MM.DD.YYYY","DD/MM/YYYY","MM/DD/YYYY"};

	// an welcher stelle der ascii-datei das datum steht...
	// erste spalte->true
	// letzte spalte->false
	private boolean isDatumsPosFirstColumn;

	// stelle, an welcher das datum in der ascii-datei steht
	// als zahl (letzte spalte muss ja dynamisch bleiben)
	private int datumsPos;

	// falls das datum nur eine inkrementierende Zahl ist,
	// enthält diese Variable einen String, was die Zahl repräsentiert
	private String inkZahlRep;

	// ob dieses instanz der tabelle gespeichert werden soll
	private boolean speichern;

	// erstellt ein Array mit dem Datum
	private ArrayList datumAL = new ArrayList();
	private ListIterator datumALIt = datumAL.listIterator();


	/*
		im folgenden alle nötigen get-und set-methoden, um die variabeln zu verändern
	*/
	protected void setImportName(String name){
		this.importName = name;
	} // setImportName(String name)


	protected String getImportName(){
		return this.importName;
	} // getImportName()


	protected void setImportPfad(String pfad){
		this.importPfad = pfad;
	} // setImportPfad(String pfad)


	protected String getImportPfad(){
		return this.importPfad;
	} // getImportPfad()


	protected void setInternerSpeicherName(String name){
		this.internerSpeicherName = name;
	}


	protected String getInternerSpeicherName(){
		return this.internerSpeicherName;
	} // getInternerSpeicherName()


	protected void setTrennzeichen(String zeichen){
		this.trennzeichen = zeichen;
	} // setTrennzeichen(char zeichen)


	protected String getTrennzeichen(){
		return this.trennzeichen;
	}


	protected void setDatumsFormat(String datumsFormat){
		this.datumsFormat = datumsFormat;
	} // setDatum(Datum datum)


	protected String getDatumsFormat(){
		return this.datumsFormat;
	} // getDatumsFormat()


	protected static String[] getDatenFormate(){
		return datenFormate;
	} // getDatenFormate()


	protected void setDatumsPos(int pos){
		this.datumsPos = pos;
	} // setDatumsPos(int pos)


	protected int getDatumsPos(){
		return this.datumsPos;
	} // getDatumsPos()


	protected void setDatumsPosFirstColumn(boolean bla){
		this.isDatumsPosFirstColumn = bla;
	} // setDatumsPosFirstColumn(boolean bla)


	protected boolean isDatumsPosFirstColumn(){
		return this.isDatumsPosFirstColumn;
	} // isDatumsPosFirstColumn()


	protected void setInkZahlRep(String blo){
		this.inkZahlRep = blo;
	} // setInkZahlRep(boolean blo)


	protected String getInkZahlRep(){
		return this.inkZahlRep;
	} // getInkZahlRep()


	protected void setSpeichern(boolean speichern){
		this.speichern = speichern;
	} // setSpeichern()


	protected boolean isSpeichern(){
		return this.speichern;
	} // isSpeichern()


	public String toString(){
		String toString = new String(
			"importName: \t\t\t" + this.importName +
			",\n importPfad: \t\t\t" + this.importPfad +
			",\n internerSpeicherName: \t\t" + this.internerSpeicherName +
			",\n internerSpeicherPfad: \t\t" + this.internerSpeicherPfad +
			",\n trennzeichen: \t\t\t" + this.trennzeichen +
			",\n datumsFormat \t\t\t" + this.datumsFormat +
			",\n isDatumsPosFirstColumn: \t" + this.isDatumsPosFirstColumn +
			",\n datumsPos \t\t\t" + this.datumsPos +
			",\n inkZahlRep \t\t\t" + this.inkZahlRep
		);

		return toString;
	} // toString()


	// destruktor
	protected void zerstoeren(){
		this.importPfad = "";
	} // finalize()


	public ArrayList getDaten(){

		// liefert ausschliesslich die zu verarbeitenden Daten zurück.
		// das Datum für die jeweilige Zeile kann über die Methode getDates() aufgerufen werden

		// letztendliches array welches zurückgeliefert werden soll.
		ArrayList resAL = new ArrayList();
		ListIterator resALIt = resAL.listIterator();

		// zeile als Zeichenkette
		String zeile;

		// die Zeile gesplittet am Trennzeichen als statisches Array
		String zeileL[];

		// die am Trennzeichen gesplittete Zeile als dynamisches Array
		ArrayList zeileAL = new ArrayList();
		ListIterator zeileALIt = zeileAL.listIterator();

		int zeilenlaenge;

		// if Abfrage setzt die Position des Datums,
		// ob in der ersten oder letzten Spalte der Tabelle
		if(this.isDatumsPosFirstColumn){
			this.setDatumsPos(0);
		} else {
			this.setDatumsPos(resAL.size());
		} // if() else

		try {
			// 1. datei auslesen
			FileReader readfile = new FileReader(this.importPfad);

			// 2. datei im puffer zwischenspeichern
			BufferedReader bufferread = new BufferedReader(readfile);


/**Beraterecke...

			class liste {
				liste next;
				litem firstofrow;
			}

			class litem {
				litem next, prev = null;
				int data;
			}

			struktur der liste:

			//Erstes Item der Zeilenverwaltung initialisieren
			liste myList = new liste();
			//zusätzliche referenz auf 1. zeile
			liste firstofrows = myList;
			//... zeigt jetzt auf die erste Zeile...
			//erste Zeile initialisieren
			litem row = new litem();
			//z.b. daten des ersten datensatzes, erste spalte schreiben:
			row.data = gelesenes zeugs...
			//referenz auf dieses erste spaltenitem...
			myList.firstofrow = row;
			//eine spalte weiterrücken
			row.next = new litem();
			row = row.next;
			//daten der 2. spalte 1. datensatz schreiben
			row.data = geleseneszeugs....;
			//angenommen, hier ist datensatz fertig gelesen...
			//dann 2. zeil initialisieren#
			myList.next = new liste();
			//erstes element dieser Zeile anlegen
			myList = myList.next;
			//jetzt erstes zeilenitem initialisieren#
			myList.firstofrow = new litem();
			//iterator dieses item referenzieren lassen, um daten zu schreiben und weiter zu rutschen
			row = myList.firstofrow;
			//... wieder daten schreiben
			row.data = gelesenes zeugs...;
			//neues element#
			row.next = new litem();
			//vorrücken#
			row = row.next;#
			//daten schreiben
			row.data = geleseneszeugs;

			//auslesen der gerade geschreibenen datenstruktur:#
			for (liste ml = firstofrows; ml != null; ml=ml.next)
				for (litem it = ml.firstofrows; it != null; it = it.next)
					System.out.println(it.data);


//--------------------------------------------------------*/

			// Tabelle wird Zeile für Zeile eingelesen
			// Zeilen werden im Puffer zwischengespeichert
			while(bufferread.readLine() != null){
				zeile = bufferread.readLine();

				// !!! this.trennzeichen enthält noch KEIN separates Trennzeichen,
				// sondern eine Zeichkette aus mehreren Zeichen (Leerzeichen)
				zeileL = zeile.split(this.trennzeichen);

				for( int i = 0 ; i < zeileL.length ; i++){
					zeileALIt.add(zeileL[i]);
					// Datum aus Array kopieren
					this.datumALIt.add(zeileAL.get(this.datumsPos));
					// Datum an datumsPos entfernen
					zeileAL.remove(this.datumsPos);
					// zeileALIt.set(Integer.parseInt((String)zeileALIt.next()));
					// fügt der zu übergebenden Liste die Daten hinzu

					while (zeileALIt.hasNext()){
						zeileALIt.set( Integer.parseInt( (String)zeileALIt.next() ) );
					} // while()
				} // for()

				resALIt.add(zeileAL);

			} // while()

		} catch (IOException except){
			JOptionPane.showMessageDialog(null,
            	"Datei konnte nicht gelesen werden!","Dateifehler",
            	JOptionPane.ERROR_MESSAGE );
        } // try catch()

		return resAL;

	} // getDaten()


	public void getDatum(){
		/**
		liefert eine Liste von Strings mit dem Datum für die jeweilige Zeile zurück.
		Die Liste ist genauso lang wie die, die getDaten zurückliefert
		*/

		String splittedDate[];
		String ergebnisDate[]; // splittedDate richtig sortiert nach YYYY MM DD
		ArrayList ergebnis =  new ArrayList();
		ListIterator ergebnisIt =  new ListIterator();

		// char datumsTrennzeichen = {'-','.','.','/','/'}; // gleiche länge wie datenFormate[]

		while (datumALIt.hasNext()){
			if (datumsFormat.matches(".")){
				splittedDate = datumsFormat.split(".");
			} else if (datumsFormat.matches("/")){
				splittedDate = datumsFormat.split("/");
			} else if (datumsFormat.matches("-")){
				splittedDate = datumsFormat.split("-");
			} // if

			for (int i = 0; i < splittedDate.length; i++){
				switch (i){
					case 0:
// hier geht's weiter
					break;

					case 1:

					break;

					case 2:

					break;
				} // switch
			} // for

			ergebnis.add(splittedDate);

		} // while()

		for (int i = 0; i < this.datenFormate.length; i++){


		}
	} // getDatum()

} // importiereTabelle