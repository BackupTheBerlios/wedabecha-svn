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
    @author Matthias Tylkowski

	diese Klasse dient zur Berechnung der Verschiedenen Mittelwerte die dann
	als Diagramm dargestellt werden können.
 */

import java.util.*;

public class berechneMittelwerte {

    private ArrayList werte;
    private ArrayList datum;

    // z�hler f�r die stelle im datum
    //private int zaehler1 = 0;
    // z�hler f�r die stelle in der Methode wochenMittel
    private int zaehler2 = 0;
    // z�hler f�r die teilende anzahl
    private int zaehler3 = 0;

    private double summe = 0;
    // start dient der zu Bestimmung, wann ein Monat/ Jahr zu ende ist
    private int start = 0;
	
	private ArrayList tagesMittel;
	private double[] statArray;
	private double zeilenSumme = 0;

    public berechneMittelwerte(ArrayList werte, ArrayList datum){

	this.datum = datum;
	this.werte = werte;

	/*System.out.println(
			"Jahresmittel = "+berechneJahresMittel()+
			"\nWochenmittel = "+berechneWochenMittel()+
			"\nMonatsmittel = "+berechneMonatsMittel()+
			"\nTagesmittel = "+berechneTagesMittel()
	);
	 */
    }

    /* Diese Methode berechnet die Mittelwerte der einzelnen Tage, die ja meistens
     * in Tagesanfang, Tagesschluss, Hoch und Tief eingeteilt sind.
     */

    public ArrayList berechneTagesMittel(){
	// ArrayList in der die berechneten Tagesmittel zusammengefasst werden.
	this.tagesMittel = new ArrayList();

	/* Diese Schleife liest die Zeilen aus der ArrayList werte aus und speichert
	 * sie in dem statischen Array statArray...
	 */
	for (int i = 0; i < this.werte.size(); i++){
		/* dient als vorrübergehender Speicherort für das Array, welches in
		 * jeder Zeile der werte steht
		 */
	    this.statArray = (double[])this.werte.get(i);
	    

	    /* ...in dieser Schleife werden dann die einzelnen werte aus dem statArray
	     * ausgelesen, addiert und in der Variable zeilenSumme gespeichert...
	     */

	    for (int j = 0; j < this.statArray.length; j++){
			this.zeilenSumme += this.statArray[j];
	    }// for()

	    /* ...an dieser Stelle wird die summe durch die länge des statArrays geteilt,
	     * welches einer Zeile in der ArrayList werte entspricht, und zur ArrayList
	     * tagesMittel hinzugefügt.
	     */
	    this.tagesMittel.add(new Double(this.zeilenSumme/this.statArray.length));
		this.zeilenSumme = 0;
	}// for ()
	return this.tagesMittel;
    }// berechneTagesMittel()

    /* Diese Methode berechnet die Monatsmittelwerten aus den zuvor berechneten
     * Tagesmittelwerten.
     */

    public ArrayList berechneMonatsMittel() {
		String monat;
		String naechsterMonat;
		// vor�bergehend verwendetes Array zum herausfiltern des Monats
		String[] tempDatum = new String[3];
		// enth�lt die Mittelwerte f�r jeden Monat
		ArrayList monatsMittel = new ArrayList();
		// enthält das Datum zum dazugerhörigen Mittelwert
		ArrayList datumMonatsMittel = new ArrayList();

		int zaehler1 = 0;
		zaehler3 = 0;
		summe = 0;
		start = 0;

		// der Monat steht immer an zweiter Stelle in der ArrayList datum
		tempDatum = (String[])this.datum.get(0);
		monat = tempDatum[1];


		/* Diese Schleife berechnet den Mittelwert der Tagesmittel für einen Monat.
		 * Die Schleife läuft so lange, bis sie jeden Tag aus der ArrayList datum
		 * geprüft hat. Am Anfang wird die Variable naechterMonat festgelegt, sie
		 * wird mit jedem Durchlauf der Schleife neu festgelegt und bestimmt, wann
		 * ein Monat zu Ende ist. Die Variable start wird bei jedem Durchlauf der
		 * Schleife erhöht und liest somit immer eine höhere Zeilennummer aus der
		 * ArrayList datum aus, welche dann das tempDatum bestimmt.
		 */

		for(zaehler1 = 0; zaehler1 < this.datum.size(); zaehler1++){
		    zaehler3++;
		    tempDatum = (String[])this.datum.get(start++);
		    naechsterMonat = tempDatum[1];

		    /* solange der die Variable naechterMonat der Variable monat gleicht
		     * wird aus den berechneten Tagesmittel die jeweilige Zeile ausgelen
		     * und aufsummiert. Wenn die Variablen nicht mehr gleich sind, wird
		     * die Summe durch den zaehler3 geteilt und man erhält den Mittelwert
		     * für den jeweiligen Monat, dieser Wert wird dann der ArrayList
		     * monatsMittel hinzugefügt. Das jeweilige Datum des neuen Monats wird
		     * in die ArrayList datumMonatsMittel eingefügt. Zum Schluss wird dann
		     * noch der nächste Monat als Referenz festgelegt und die Schleife be-
		     * ginnt von neuem.
		     */

		    if(naechsterMonat.equals(monat)){
				System.out.println(zaehler1);
				summe += ((Double)berechneTagesMittel().get(zaehler1)).doubleValue();
		    } else {
				monatsMittel.add(new Double(summe/(zaehler3-1)));
				datumMonatsMittel.add(this.datum.get(zaehler1));
				zaehler3 = 0;
				summe = 0;
				zaehler1--;
				start--;
				tempDatum = (String[])this.datum.get(start);
				monat = tempDatum[1];
		    } // else
		} // for

		/* da sich nich unbedingt beim letzten wert des Arrays der Monat ändern muss,
		 * muss man diesen Wert mit diser if-Anweisung hinzufügen
		 */

		if(zaehler1 - 1 < this.datum.size()){
		    monatsMittel.add(new Double(summe/(zaehler3)));
		    datumMonatsMittel.add(this.datum.get(zaehler1-1));
		} // if

		return monatsMittel;
    } // berechneMonatsMittel()


    // Diese Methode berechnet die Jahresmittelwerte aus den Tagesmittelwerten.
    public ArrayList berechneJahresMittel(){
		// Mittelwerte für jedes Jahr
		ArrayList jahresMittel = new ArrayList();
		// dazugehöriges Datum
		ArrayList datumJahresMittel = new ArrayList();
		// temporär verwendetes Array zur Ermittlung des Jahres
		String[] tempDatum = new String[3];
		String jahr;
		String naechstesJahr;

		int zaehler1 = 0;
		this.zaehler3 = 0;
		this.summe = 0;
		this.start = 0;

		// das Jahr steht immer an der ersten Stelle des Arrays
		tempDatum = (String[])this.datum.get(0);
		jahr = tempDatum[0];

		/* Diese Schleife arbeit nach dem gleichen Prinzip, wie das bei der
		 * Methode berechneMonatsMittel der Fall ist. Nur werden hier die
		 * Werte erst zur ArrayList jahresMittel hinzugefügt, wenn ein neues
		 * Jahr bestimmt wurde.
		 */

		for(zaehler1 = 0; zaehler1 < datum.size(); zaehler1++){
		    this.zaehler3++;
		    tempDatum = (String[])this.datum.get(start++);
		    naechstesJahr = tempDatum[0];

		    if(naechstesJahr.equals(jahr)){
				this.summe += ((Double)berechneTagesMittel().get(zaehler1)).doubleValue();
		    } else {
				jahresMittel.add(new Double(this.summe/(this.zaehler3-1)));
				datumJahresMittel.add(this.datum.get(zaehler1-1));
				this.zaehler3 = 0;
				this.summe = 0;
				zaehler1--;
				this.start--;
				tempDatum = (String[])this.datum.get(this.start);
				jahr = tempDatum[0];
		    } //else
		} //for

		/* da sich nich unbedingt beim letzten wert des Arrays das Jahr ändern muss,
		 * muss man diesen Wert mit diser if-Abfrage hinzufügen
		 */
		if(zaehler1 - 1 < this.datum.size()){
		    jahresMittel.add(new Double(summe/(zaehler3)));
		    datumJahresMittel.add(this.datum.get(zaehler1-1));
		} // if
		
		return jahresMittel;
    } // berechneJahresMittel()


    // Diese Methode dient zur Berechnung der Wochenmittelwerte aus den Tagesmittelwerten
    public ArrayList berechneWochenMittel(){
		// enthält die Mittelwerte für eine Woche
		ArrayList wochenMittel = new ArrayList();
		// enthält das dazugehörige Datum
		ArrayList datumWochenMittel = new ArrayList();
		int zaehler1 = 0;
		zaehler2 = 0;
		zaehler3 = 0;
		summe = 0;

		/* Diese Schleife durchläuft die ArrayList mit dem Datum bis zum Ende, liest
		 * bei jedem Durchlauf den jeweiligen Wert aus der ArrayList tagesMittel und
		 * addiert diese zusammen. Bei jeden Durchlauf wird die Variable zaehler2
		 * inkrementiert, diese bestimmt, wann eine Woche zuende ist. Da diese
		 * Software für Aktiernkurse ausgelegt sind, und die Börse Samstags und Sonn-
		 * tags nicht arbeitet, endet zaehler2 bei 5. Dann wird die summe durch  ge-
		 * teilt und der ArrayList wochenMittel hinzugefügt. Das jeweilige Datum wird
		 * dann der ArrayList datumWochenMittel hinzugefügt.
		 */

		for(zaehler1=0; zaehler1<this.datum.size(); zaehler1++){
		    zaehler2++;
		    summe += ((Double)berechneTagesMittel().get(zaehler1)).doubleValue();

		    if(zaehler2 >= 5){
				wochenMittel.add(new Double(summe/5));
				datumWochenMittel.add(this.datum.get(zaehler1-1));
				zaehler3++;
				zaehler2 = 0;
				summe = 0;
		    } // if
		} // for


		/* falls die ArrayList mit dem Datum mitten in der woche enden sollte, wo
		 * zaehler2 kleiner als 5 ist, wird trotzdem die summe gebildet und der
		 * ArrayList wochenMittel hinzugefügt. Das jeweilige Datum wird dann der
		 * ArrayList datumWochenMittel hinzugefügt.
		 */

		if(zaehler1 - 1 < this.datum.size()){
		    wochenMittel.add(new Double(summe/zaehler2));
		    datumWochenMittel.add(this.datum.get(zaehler1-1));
		}// if

		return wochenMittel;
	} // berechneWochenMittel


} // berechneMittelwerte