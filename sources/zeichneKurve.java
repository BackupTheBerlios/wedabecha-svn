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

import java.awt.Graphics;
import java.awt.*;
import javax.swing.JComponent;
import java.util.ArrayList;

class zeichneKurve extends JComponent{

	private int kurvenNummer;
	private Color farbe;

	// konstruktoren werden überladen, da man ja nich gleich zum Programmstart
	// die Werte hat und zeichnen kann
	public zeichneKurve(){
		// konstruktor ohne Parameter
		// hier passiert nichts weiter
	} // zeichneKurve
	

	public zeichneKurve(int kurvenNummer){
		// kontruktor, welcher die berechnung durchführt,
		// sobald ein objekt mit kurvenNummer erzeugt wird...
		this.kurvenNummer = kurvenNummer;
	
	} // zeichneKurve()	
} // zeichneKurve

class zeichneLinienKurve extends JComponent {
    private ArrayList werte;
    private Color farbe;

    public zeichneLinienKurve(ArrayList werte, Color farbe) {
	this.farbe = farbe;
	this.werte = werte;
	this.setSize(700,  500);
    }// zeichneKurve()


    public void paintComponent(Graphics kurve){
	int zaehler = 0;

	for(int i = 0; i < this.werte.size()-1; i++){
	    kurve.setColor(this.farbe);
	    kurve.drawLine(zaehler, ((Double)this.werte.get(i)).intValue(),
			   zaehler += 5, ((Double)this.werte.get(i+1)).intValue());
	}// for
    }// paintComponent()


}// zeichneLinienKurve
