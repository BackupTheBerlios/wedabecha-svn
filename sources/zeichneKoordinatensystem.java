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
	@author Martin Müller (mrtnmueller at users.berlios.de), Dominic Hopf (dmaphy at users.berlios.de)
	@since 2005-01-26
	@version 0.0.1

*/

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class zeichneKoordinatensystem extends JComponent {

	private int startX, endX, startY, endY;  // Zeichenbereich in xyKoordinaten
	private int maxWert;
	private int maxDate;
	private int dx, dy; // Distanz zwischen Nullpunkt und dem Maximalpunkt auf den Achsen
	private int einheitx, einheity; // Abstand der einzelnen Achseneinteilungsstriche
	private int zeichenBreite, zeichenHoehe; // Zeichenbereich in Pixelkoordinaten

	private Graphics g; // wird von paint gesetzt, von drawLine benutzt

	// Konstruktor
	zeichneKoordinatensystem(int zeichenBreite, int zeichenHoehe) {
		this.zeichenBreite = zeichenBreite;
		this.zeichenHoehe = zeichenHoehe;
		// Grösse der Zeichnungsfläche einstellen
		this.setSize(zeichenBreite ,zeichenHoehe);
		this.berechneMaxima();
		this.setzeEinheiten(endX-startX, endY-startY); // xy-Bereich setzen
		this.zeichneKoordinatenachsen();
		this.setVisible(true); // sichtbar machen
		this.setOpaque(true); // transparent machen
	} // zeichneKoordinatensystem


	protected void setGroesse(int breite, int hoehe){
		this.zeichenBreite = breite;
		this.zeichenHoehe = hoehe;
		this.setSize(breite, hoehe);
	} // setGroesse()


	public void setzeEinheiten(int xachse, int yachse) {

		// Einheiten auf der x- bzw. y-Achse bestimmen
		einheitx = 12; // wenn die ganze Achse ein Jahr is, teilen wir nach Monaten auf
		if (dx >= 240) einheitx = 12; // is die Achse grösser als ein Jahr auhc nach Monaten
		if (dx <= 20) einheitx = 1; // is die achse kleiner oder gleich einem Monat teilen wir sie nach tagen
		if ( (dx > 20) && (dx < 240) ) einheitx = 10;
		einheity = 100;
		if (dy < 300) einheity =10;
		if (dy < 30) einheity = 1;
		if (dy < 3) einheity = 3;
		if (dy < 2) einheity = 2;
		if (dy < 1) einheity = 1;
	} // setzeEinheiten()




	private void drawLine(int x1,int y1, int x2,int y2) {
		// Wandelt die xy-Koordinaten in Pixelkoordinaten um und zeichnet eine
		// Gerade zwischen den beiden Punkten
	}


	private int convertXToPixel(double x) { // konvertiert x-Koordinaten in Pixel
		return (int)((x-this.startX)/this.dx*this.zeichenBreite);
	}


	private int convertYToPixel(double y) { // Konvertiert y-Koordinaten in Pixel
		return (int)((endY-y)/dy*zeichenHoehe); // beachte, dass y-Koord. und Pixel in
		// unterschiedliche Richtung zeigen
	}


	private void zeichneKoordinatenachsen() {

		this.startY = zeichenHoehe - 25;
		this.endY = (zeichenHoehe - 25) - this.maxWert;
		this.startX = 25;
		this.endX = zeichenBreite - 25;
		dx = endX - startX; // Breite
   		dy = endY - startY; // Hoehe

		// x-Achse mit Pfeil
		drawLine( (int)(startX * 0.975), 0, (int)(endX * 0.975), 0);
		g.drawLine(convertXToPixel(endX * 0.975) - 15,convertYToPixel(0) - 10,
		convertXToPixel(endX * 0.975),convertYToPixel(0) );
		g.drawLine(convertXToPixel(endX * 0.975) - 15,convertYToPixel(0) + 10,
		convertXToPixel(endX * 0.975),convertYToPixel(0));

		// y-Achse mit Pfeil
		drawLine(0, (int)(startY * 0.975),0, (int)(endY*0.975));
		g.drawLine(convertXToPixel(0)+10,convertYToPixel(endY*0.975)+15,
		convertXToPixel(0),convertYToPixel(endY*0.975));
		g.drawLine(convertXToPixel(0)-10,convertYToPixel(endY*0.975)+15,
		convertXToPixel(0),convertYToPixel(endY*0.975));

		// Einheiten auf den Achsen
		g.drawLine(convertXToPixel(einheitx),convertYToPixel(0)+5,
		convertXToPixel(einheitx),convertYToPixel(0)-5);
		g.drawLine(convertXToPixel(0)+5,convertYToPixel(einheity),
		convertXToPixel(0)-5,convertYToPixel(einheity));
	} // zeichneKoordinatenachsen()


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
		} // for(i)

		java.util.Arrays.sort(maxKurvenWerte);
		this.maxWert = (int)maxKurvenWerte[maxKurvenWerte.length - 1];
// 		this.maxDate = das;

	} // berechneMaxima()


	public void paint(Graphics g) {
		this.g = g; // wird von drawLine benötigt
// 		bestimmePixelangabenDesFensters(); // diese könnten sich geändert haben
		g.setColor(Color.black);
		zeichneKoordinatenachsen();
		g.drawString("Einheit x = " + einheitx + " / y = " + einheity,10,20);
/*
		for (int i=0; i<funktionanzahl;i++) {
			if (i==0) g.setColor(Color.red);
			else if (i==1) g.setColor(Color.green);
			else g.setColor(Color.blue);
			funk[i].zeichneDich(this);
			g.drawString(""+funk[i], 10, 20+15*(i+1) );
		} // for*/

	} // paint()


	public String toString() {
		return	" Zeichenbereich:\n" +
				" X-Achse: |" + this.startX + " - " + this.endX + "| = " + this.dx + "\n" +
				" Y-Achse: |" + this.startY + " - " + this.endY + "| = " + this.dy + "\n";
	}
} // zeichneKoordinatensystem

/*
* Diese Klasse basiert auf der Grundlage, eines bereits existierenden Programms,
* welches ohne Hinweise auf Urheberrecht o.ä. im Internet gefunden wurde.
* @author W.Seyboldt, GZG
* @version 1.1, Dez03, Sep 01 <br>
*/