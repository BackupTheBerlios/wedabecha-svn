/****************************************************************************
 *   Copyright (C) 2004 by BTU SWP GROUP 04/6.1										*
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

/**Diese Datei enthält die Hintergrundfunktionen für importiereTabelle*/

package importiereTabelle;

public class importiereTabelle {
	private String importName; // enthält nur den Namen der Datei
	private String importPfad; // enthält Pfad UND Namen der Datei, also den kompletten Pfad
	private String internerSpeicherName; // ist normalerweise gleich importName
	private String internerSpeicherPfad = "./daten/"; // wird aus ProgrammPfad und internerSpeicherName zusammengesetzt
	private String trennzeichen;
	private String datumsFormat;
	private boolean isDatumsPosFirstColumn;
	private int datumsPos;
	private String inkZahlRep;

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
	} // getDatum()


	protected void getIsoDateForm(String datum){

	} // getIsoForm(String datum)


	protected void setDatumsPos(int pos){
		this.datumsPos = pos;
	} // setDatumsPos(int pos)


	protected int getDatumsPos(){
		return this.datumsPos;
	} // getDatumsPos()


	public int[][] getDaten(){
		/**liefert ausschliesslich die zu verarbeitenden Daten zurück.
		das Datum für die jeweilige Zeile kann über die Methode getDates() aufgerufen werden*/

		// fake-code um dem missing-return-statement aus dem weg zu gehen
		int I[][] = {{0},{0}};
		return I;
		// hier kommt der letztliche Code für den Import
	}


	public String[] getDates(){
		/**liefert eine Liste von Strings mit dem Datum für die jeweilige Zeile zurück.
		Die Liste ist genauso lang wie die, die getDaten zurückliefert*/

		// fake-code um dem missing-return-statement aus dem weg zu gehen
		String text[] = {"text"};
		return text;
	} // getDates()


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
} // importiereTabelle
