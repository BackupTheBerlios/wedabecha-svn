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
import javax.swing.JComponent;
import java.util.ArrayList;

class zeichneKurve {

	private int kurvenNummer;

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


    public zeichneLinienKurve(ArrayList werte) {
	this.werte = werte;
    }// zeichneKurve()


    public void paintComponent(Graphics kurve){
	int zaehler = 0;

	for(int i = 0; i < this.werte.size()-1; i++){
	    kurve.drawLine(zaehler, ((Integer)this.werte.get(i)).intValue(),
			   zaehler += 5, ((Integer)this.werte.get(i+1)).intValue());
	}// for
    }// paintComponent()


}// zeichneLinienKurve