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
		Dominic Hopf (dmaphy at users.berlios.de),
		Robert Exner (ashrak at users.berlios.de)

*/

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Koordinatensystem extends JComponent {

	/*
		auf geht's. heute zeichnen wir ein koordinatensystem.
		dazu brauchen wir erstmal die start- und endpunkte
		für die beiden achsen...
	*/
	private int startX, endX, startY, endY;

	/*
		für die einteilung der achsen müssen wir die maximalen werte kennen.
		maxWert für die Y-Achse
		maxDate für die x-Achse
	*/
	private double maxWert, maxDate;

	private int dx, dy; // Distanz zwischen Nullpunkt und dem Maximalpunkt auf den Achsen
	private int einheitx = 25; // Abstand der einzelnen Achseneinteilungsstriche
	private int einheity = 20; // Abstand der einzelnen Achseneinteilungsstriche
	private int zeichenBreite, zeichenHoehe; // Zeichenbereich in Pixelkoordinaten
	
	private int yBeschriftung;
	private double multiplikator;
	//Konstruktor
	Koordinatensystem(){
	}


	protected void setGroesse(int breite, int hoehe){
		/**
			setGroesse legt die Grösse für das Koordinatensystem
			fest. Diese Methode wird von verschiedenen Punkten aufgerufen.
			Einmal vom Konstruktor, beim erzeugen,
			und einmal von dem ActionListener der hauptFensterUI,
			welcher für die Grössenänderung des Fensters verantwortlich ist.
			Die Werte, die wir für das System benötigen, können wir erst anhand
			der Fenstergrösse berechnen...
		*/
		this.zeichenBreite = breite;
		this.zeichenHoehe = hoehe;
		// Start- und Endpunkt der Y-Achse in vertikaler Richtung
		this.startY = hoehe - 25;
		this.endY = 60;
		// Start- und Endpunkt der X-Achse in horizontaler Richtung
		this.startX = 25;
		this.endX = breite - 25;

		this.dx = this.endX - this.startX; // Breite
   		this.dy = this.endY - this.startY; // Hoehe
		this.setSize(breite, hoehe);
		this.multiplikator =	(hauptFensterUI.layeredPane.getHeight() - 100) /
								this.maxWert;
	} // setGroesse()


	protected void zeichnen() {
		/**
			die Methode zeichnen() rufen wir vom ActionListener für den
			[OK] - Button in importiereTabelleUI auf.
			das Koordinatensystem kann ja erst gezeichnet werden,
			wenn wir die Werte aus den Tabellen kennen und maximalWerte etc.
			berechnen können
		*/

		// Grösse der Zeichnungsfläche einstellen
		this.berechneMaxima();
		
		this.yBeschriftung = (int)((Math.round(this.maxWert / 10)) * 10);
		this.multiplikator =	(hauptFensterUI.layeredPane.getHeight() - 100) /
								this.maxWert;
		this.setGroesse(690,452);
		this.setVisible(true); // sichtbar machen
	} // zeichneKoordinatensystem


	protected void paintComponent(Graphics g){
		/**
			Mit paintComponent() zeichnen wir das letztendliche Koordinatensystem.
			Erst Achsen, dann Pfeilspitzen für die Achsen,
			dann noch die Einteilung...
		*/

		g.drawLine(startX, startY, endX, startY); // X-Achse
		g.drawLine(startX, startY, startX, endY); // Y-Achse
		// Pfeilspitze Y-Achse
		g.drawLine(21, (endY + 8), 25, endY);
		g.drawLine(29, (endY + 8), 25, endY);

		// Pfeilspitze X-Achse
		g.drawLine((endX - 8), (startY + 4), endX, startY);
		g.drawLine((endX - 8), (startY - 4), endX, startY);

		// Achseneinteilungsstriche zeichnen
		// auf der X-Achse
		for (int i = startX; i < (endX - 50); i+= einheitx){
			g.drawLine( (startX + i) , (startY - 4) , (startX + i) , (startY + 4) );
		} // for
		
		int tempBeschriftung = 0;
		System.out.println(yBeschriftung);
		// auf der Y-Achse
		for (int j = startY; j >= 75; j -= (startY - 75) / 10){
			g.drawString(""+tempBeschriftung, 0, j + 5);
			g.drawLine( (startX - 4) , j ,  (startX + 4) , j );
			tempBeschriftung += yBeschriftung / 10;
		} // for
	} // paintComponent()


	private void berechneMaxima(){
		/**
			hier berechnen wir die Maximalwerte,
			die brauchen wir für die Einteilung der Achsen.
		*/

		double maximalWert;
		ArrayList werte;
		ArrayList daten;
		double wertZeile[];
		double maxZeilenWerte[];
		double maxKurvenWerte[] = new double[5];
		String datenZeile[];

		/*
			Maximalwerte der Kurven bestimmen
			for(i) geht die Kurven nacheinander durch,
			for(j) geht die Zeilen einer Kurve nacheinander durch
		*/

		for (int i = 1; i < 6;i++){
			if (wedabecha.getKurve(i).isset()){
				werte = wedabecha.getKurve(i).getWerte();
				daten = wedabecha.getKurve(i).getDaten();
				maxZeilenWerte = new double[werte.size()];

				for (int j = 0; j < werte.size(); j++){
					wertZeile = (double[])werte.get(j);
					java.util.Arrays.sort(wertZeile);
					// der letzte wert der aufsteigend sortierten liste, ist der maximale
					maxZeilenWerte[j] = wertZeile[wertZeile.length - 1];
				} // for(j)

				java.util.Arrays.sort(maxZeilenWerte);
				maxKurvenWerte[i] = maxZeilenWerte[maxZeilenWerte.length - 1];
			} // if
		} // for(i)

		java.util.Arrays.sort(maxKurvenWerte);
		this.maxWert = maxKurvenWerte[maxKurvenWerte.length - 1];
// 		this.maxDate = da kommt noch was rein (vielleicht);

	} // berechneMaxima()


	public String toString() {
		return	" Zeichenbereich:\n" +
				" X-Achse: |" + this.startX + " - " + this.endX + "| = " + this.dx + "\n" +
				" Y-Achse: |" + this.startY + " - " + this.endY + "| = " + this.dy + "\n";
	}
} // Koordinatensystem