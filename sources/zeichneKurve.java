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
		Matthias Tylkowski (micron at users.berlios.de)
	@since 2005-02-01
	@version 0.0.1
*/

import java.awt.Graphics;
import java.awt.*;
import javax.swing.JComponent;
import java.util.ArrayList;


class zeichneKurve extends JComponent{

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
	private Color farbe;
	private int abstand;

	protected int dateBeginIndex;
	protected int dateEndIndex;


	private double multiplikator;
	private double max;


	public zeichneLinienKurve(ArrayList werte, Color farbe) {
		this.farbe = farbe;
		this.werte = werte;
		this.setSize(hauptFensterUI.fensterBreite, hauptFensterUI.fensterHoehe);
	} // zeichneKurve()


	public void setGroesse(int breite, int hoehe){
		this.setSize(breite, hoehe);
	} // setGroesse()


	protected void getMax(){
		for(int i = 0; i < this.werte.size(); i++){
			double tempArray = ((Double)this.werte.get(i)).doubleValue();
			this.max = Math.max(this.max, tempArray);
 		} // for
		this.multiplikator =	(hauptFensterUI.layeredPane.getHeight() - 100) /
								this.max;
	} // getMax()

	public void paintComponent(Graphics kurve){
		getMax();
		int zaehler = 25;
		if(	Math.round( (hauptFensterUI.layeredPane.getWidth() -
			25) / this.werte.size() ) < 1){
			this.abstand  = 1;
		} else {
			this.abstand = 	Math.round( (hauptFensterUI.layeredPane.getWidth() -
						25) / this.werte.size());
		} // if


		for(int i = dateBeginIndex; i < dateEndIndex; i++){
			kurve.setColor(this.farbe);
			kurve.drawLine(	zaehler,
							(hauptFensterUI.layeredPane.getHeight() -
							25) - (int)(this.multiplikator *
								((Double)this.werte.get(i)).doubleValue()),
							zaehler += abstand,
							(hauptFensterUI.layeredPane.getHeight() -
							25) - (int)(this.multiplikator *
								((Double)this.werte.get(i+1)).doubleValue())
			); // drawLine
		} // for
	} // paintComponent()


} // zeichneLinienKurve


class zeichneAktienKurve extends JComponent{
	private ArrayList werte;
	private Color farbe;

	private int abstand = 25;
	private double[] kurse;

	private double multiplikator;
	private double max;

	private int hoch;
	private int tief;
	private int start;
	private int ende;

	public zeichneAktienKurve(ArrayList werte, Color farbe){
		this.werte = werte;
		this.farbe = farbe;
		this.setSize(hauptFensterUI.fensterBreite,  hauptFensterUI.fensterHoehe);
	}// zeichneAktienKurve


	protected void setGroesse(int breite, int hoehe){
		this.setSize(breite, hoehe);
	}// setGroesse()


	protected void getMax(){
		double[] tempArray = new double[this.werte.size()];
		for(int i = 0; i < this.werte.size(); i++){
			tempArray = (double[])this.werte.get(i);
			for(int j = 0; j < tempArray.length; j++){
				this.max = Math.max(this.max, tempArray[j]);
			} // for
 		} // for
		this.multiplikator =	(hauptFensterUI.layeredPane.getHeight() - 100) /
								this.max;
	} // getMax
	public void paintComponent(Graphics kurve){
		getMax();
		kurve.setColor(farbe);
		for(int i = 0; i < this.werte.size(); i++){
			this.kurse = (double[])this.werte.get(i);
			this.start = (int)this.kurse[0];
			this.ende = (int)this.kurse[1];
			this.hoch = (int)this.kurse[2];
			this.tief = (int)this.kurse[3];

			kurve.drawLine(this.abstand,
				hauptFensterUI.layeredPane.getHeight() - 25 -
				(int)(this.multiplikator * this.start),
				this.abstand,
				hauptFensterUI.layeredPane.getHeight() - 25 -
				(int)(this.multiplikator * this.hoch)
			);
			kurve.drawLine(this.abstand,
				hauptFensterUI.layeredPane.getHeight() - 25 -
				(int)(this.multiplikator * this.hoch),
				this.abstand,
				hauptFensterUI.layeredPane.getHeight() - 25 -
				(int)(this.multiplikator * this.tief)
			);
			kurve.drawLine(this.abstand,
				hauptFensterUI.layeredPane.getHeight() - 25 -
				(int)(this.multiplikator * this.tief),
				this.abstand,
				hauptFensterUI.layeredPane.getHeight() - 25 -
				(int)(this.multiplikator * this.ende)
			);
			kurve.drawLine(this.abstand,
				hauptFensterUI.layeredPane.getHeight() - 25 -
				(int)(this.multiplikator * this.ende),
				this.abstand + 2,
				hauptFensterUI.layeredPane.getHeight() - 25 -
				(int)(this.multiplikator * this.ende)
			);
			this.abstand += 2;
		}//for()
		this.abstand = 25;
	}// paintComponent()
}// zeichneAktienKurve