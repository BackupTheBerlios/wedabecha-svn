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
	@since 2005-01-26
	@version 0.0.1

*/

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Koordinatensystem extends JComponent {

	private int startX, endX, startY, endY;  // Zeichenbereich in xyKoordinaten
	private int maxWert;
	private int maxDate;
	private int dx, dy; // Distanz zwischen Nullpunkt und dem Maximalpunkt auf den Achsen
	private int einheitx, einheity; // Abstand der einzelnen Achseneinteilungsstriche
	private int zeichenBreite, zeichenHoehe; // Zeichenbereich in Pixelkoordinaten

	//Konstruktor
	Koordinatensystem(){

	}


	protected void setGroesse(int breite, int hoehe){
		this.zeichenBreite = breite;
		this.zeichenHoehe = hoehe;
		this.startY = this.zeichenHoehe - 25;
		this.endY = 60;
		this.startX = 25;
		this.endX = this.zeichenBreite - 25;
		this.dx = this.endX - this.startX; // Breite
   		this.dy = this.endY - this.startY; // Hoehe
		this.setSize(breite, hoehe);
	} // setGroesse()


	protected void zeichnen() {
		this.setGroesse(
			hauptFensterUI.layeredPane.getWidth(),
			hauptFensterUI.layeredPane.getHeight()
		);

		// Grösse der Zeichnungsfläche einstellen
		System.out.println(zeichenBreite + "|" + zeichenHoehe);
		this.setSize(zeichenBreite ,zeichenHoehe);

		this.berechneMaxima();
// 		this.zeichneKoordinatenachsen();

		setGroesse(hauptFensterUI.layeredPane.getWidth()-25,hauptFensterUI.layeredPane.getHeight()-50);
		this.setVisible(true); // sichtbar machen
	} // zeichneKoordinatensystem


	public void paintComponent(Graphics g){
		g.drawLine(startX,startY,endX,startY);
		g.drawLine(startX,startY,startX,endY);
		// Pfeilspitze Y-Achse
		g.drawLine(21,(endY + 8),25,endY);
		g.drawLine(29,(endY + 8),25,endY);

		// Pfeilspitze X-Achse
		g.drawLine((endX - 8),(startY + 4),endX,startY);
		g.drawLine((endX - 8),(startY - 4),endX,startY);
	}


	private void berechneMaxima(){
		/**
			berechnet die Endpunkte der Achsen anhand der Maximalwerte
			die in den Tabellen vorkommen.
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
			for(i) geht die Kurven naacheinander durch,
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
		this.maxWert = (int)maxKurvenWerte[maxKurvenWerte.length - 1];
// 		this.maxDate = das;

	} // berechneMaxima()


	public String toString() {
		return	" Zeichenbereich:\n" +
				" X-Achse: |" + this.startX + " - " + this.endX + "| = " + this.dx + "\n" +
				" Y-Achse: |" + this.startY + " - " + this.endY + "| = " + this.dy + "\n";
	}
} // Koordinatensystem