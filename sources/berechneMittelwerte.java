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

import java.util.*;

public class berechneMittelwerte {

    /*
	diese Klasse dient zur Berechnung der Verschiedenen Mittelwerte die dann
    als Diagramm dargestellt werden können.
	*/

    // Datum im Format [Zeile][jjjj,mm,tt]
	// array zu testzwecken
    private int[][] neuesDatum = {
		{2004,9,1},
		{2004,9,2},
		{2004,10,3},
		{2004,10,4},
		{2005,11,5},
		{2005,11,6},
		{2005,12,7},
		{2006,12,8},
		{2006,12,9},
		{2006,12,10},
		{2006,12,11},
		{2007,12,12},
		{2007,12,13},
		{2007,12,14},
		{2007,12,14},
		{2008,12,15},
		{2008,12,16},
		{2008,12,17},
		{2008,12,18},
		{2008,12,19},
		{2008,12,20}
	};


    private int[] werte = {1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7};

    // zähler für die stelle im datum[]
    private int zaehler1 = 0;
    // zähler für die stelle im monatsMittel[]
    private int zaehler2 = 0;
    // zähler für die teilende anzahl
    private int zaehler3 = 0;

    private int summe = 0;
    // start dient der zu Bestimmung, wann ein Monat zu ende ist
    private int start = 0;
    // Länge des neuen zu erstellenden arrays
    private int neueLaenge = 0;

    public berechneMittelwerte(){
		System.out.println(
			"JahresMittel = "+berechneJahresMittel()+
			"\nWochenmittel = "+berechneWochenMittel()+
			"\nMonatsmittel = "+berechneMonatsMittel()
		);
    }

    public ArrayList berechneMonatsMittel() {
		int monat;
		int naechsterMonat;
		ArrayList monatsMittel = new ArrayList();

		zaehler1 = 0;
		zaehler2 = 0;
		zaehler3 = 0;
		summe = 0;
		start = 0;

		// der Monat steht immer an zweiter Stelle im zweiten Array
		monat = this.neuesDatum[0][1];

		for(zaehler1 = 0; zaehler1 < this.neuesDatum.length; zaehler1++){
		    zaehler3++;
	    	naechsterMonat = this.neuesDatum[start++][1];

	    	if(naechsterMonat == monat){
				summe += werte[zaehler1];
	    	} else {
				monatsMittel.add(""+summe/(zaehler3-1));
				zaehler2++;
				zaehler3 = 0;
				summe = 0;
				zaehler1--;
				start--;
				monat = this.neuesDatum[start][1];
	    	} // else
		} // for

		/*
			da sich nich unbedingt beim letzten wert des Arrays der Monat ändern muss,
	 		muss man diesen Wert mit diser if-Schleife hinzufügen
		*/

		if(zaehler1 == this.neuesDatum.length){
		    monatsMittel.add(""+summe/(zaehler3));
		} // if

		return monatsMittel;
    } // berechneMonatsMittel()

    public ArrayList berechneJahresMittel(){
		ArrayList jahresMittel = new ArrayList();
		int jahr;
		int naechstesJahr;

		zaehler1 = 0;
		zaehler2 = 0;
		zaehler3 = 0;
		summe = 0;
		start = 0;

		// das Jahr steht immer an der ersten Stelle des Arrays
		jahr = neuesDatum[0][0];

		for(zaehler1 = 0; zaehler1 < neuesDatum.length; zaehler1++){
	    	zaehler3++;
	    	naechstesJahr = neuesDatum[start++][0];

	    	if(naechstesJahr == jahr){
				summe += werte[zaehler1];
	    	} else {
				jahresMittel.add(""+summe/(zaehler3-1));
				zaehler2++;
				zaehler3 = 0;
				summe = 0;
				zaehler1--;
				start--;
				jahr = this.neuesDatum[start][0];
	    	} //else
		} //for

		/*
			da sich nich unbedingt beim letzten wert des Arrays der Monat ändern muss,
	 		muss man diesen Wert mit diser if-Schleife hinzufügen
		*/

		if(zaehler1 == this.neuesDatum.length){
	    	jahresMittel.add(""+summe/(zaehler3));
		} // if


		return jahresMittel;
    } // berechneJahresMittel()

    public ArrayList berechneWochenMittel(){
		ArrayList wochenMittel = new ArrayList();
		zaehler1 = 0;
		zaehler2 = 0;
		zaehler3 = 0;
		summe = 0;

		for(zaehler1=0; zaehler1<neuesDatum.length; zaehler1++){
			zaehler2++;
			summe += werte[zaehler1];

			if(zaehler2 >= 7){
				wochenMittel.add(""+summe/7);
				zaehler3++;
				zaehler2 = 0;
				summe = 0;
	    	} // if
		} // for

		return wochenMittel;
	} // berechneWochenMittel

    public static void main(String args[]){
		new berechneMittelwerte();
    }
} // berechneMittelwerte

