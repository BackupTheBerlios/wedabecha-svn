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
	private static String importName; // enthält nur den Namen der Datei
	private static String importPfad; // enthält Pfad UND Namen der Datei, also den kompletten Pfad
	private static String internerSpeicherName; // ist normalerweise gleich importName
	private static String internerSpeicherPfad; // wird aus ProgrammPfad und internerSpeicherName zusammengesetzt
	private static char trennzeichen;
	private static String datumsFormat;
	private static boolean isDatumsPosFirstColumn;
	private static int datumsPos;
	private static String inkZahlRep;

	protected static void setImportName(String name){
		this.importName = name;
	} // setImportName(String name)

	protected static String getImportName(){
		return this.importName;
	} // getImportName()

	protected static void setImportPfad(String pfad){
		this.importPfad = pfad;
	} // setImportPfad(String pfad)

	protected static String getImportPfad(){
		return this.importPfad;
	} // getImportPfad()

	protected static void setInternerSpeicherName(String name){
		this.internerSpeicherName = name;
	}

	protected static String getInternerSpeicherName(){
		return this.internerSpeicherName;
	} // getInternerSpeicherName()

	protected static void setTrennzeichen(char zeichen){
		this.trennzeichen = zeichen;
	} // setTrennzeichen(char zeichen)

	protected static char getTrennzeichen(){
		return this.trennzeichen;
	}

	protected static void setDatumsFormat(String datumsFormat){
		this.datumsFormat = datumsFormat;
	} // setDatum(Datum datum)

	protected static String getDatumsFormat(){
		return this.datumsFormat;
	} // getDatum()

	protected static void getIsoDateForm(String datum){

	} // getIsoForm(String datum)

	protected static void setDatumsPos(int pos){
		this.datumsPos = pos;
	} // setDatumsPos(int pos)

	protected static int getDatumsPos(){
		return this.datumsPos;
	} // getDatumsPos()

	public static int[][] getDaten(){
		/**liefert ausschliesslich die zu verarbeitenden Daten zurück.
		das Datum für die jeweilige Zeile kann über die Methode getDates() aufgerufen werden*/

		// hier kommt der letztliche Code für den Import
	}

	public static String[] getDates(){
		/**liefert eine Liste von Strings mit dem Datum für die jeweilige Zeile zurück.
		Die Liste ist genauso lang wie die, die getDaten zurückliefert*/
	} // getDates()

	protected static void setDatumsPosFirstColumn(boolean bla){
		this.isDatumsPosFirstColumn = bla;
	} // setDatumsPosFirstColumn(boolean bla)


	protected static boolean isDatumsPosFirstColumn(){
		return this.isDatumsPosFirstColumn;
	} // isDatumsPosFirstColumn()


	protected static void setInkZahlRep(String blo){
		this.inkZahlRep = blo;
	} // setInkZahlRep(boolean blo)


	protected static String getInkZahlRep(){
		return this.inkZahlRep;
	} // getInkZahlRep()


	public static String toString(){
		String toString = new String("importName:"+this.importName+",\n importPfad:"+this.importPfad+",\n internerSpeicherName:"+this.internerSpeicherPfad+
		",\n internerSpeicherPfad:"+this.internerSpeicherPfad+",\n trennzeichen"+this.trennzeichen+",\n datumsFormat"+this.datumsFormat+",\n " +
		"isDatumsPosFirstColumn:"+this.isDatumsPosFirstColumn+",\n datumsPos"+this.datumsPos+",\n inkZahlRep"+this.inkZahlRep);
		return toString;
	} // toString()

} // importiereTabelle
