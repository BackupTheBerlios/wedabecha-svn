/****************************************************************************
 *   Copyright (C) 2005 by BTU SWP GROUP 04/6.1                             *
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
	Dies ist eine das "Basisklassen" für wedabecha.
	hier werden alle Eigenschaften und Informationen einer Kurve gespeichert.
	Die meisten UI's verändern diese Eigenschaften.
	Damit können dann weitere Berechnungen angestellt werden,
	um die letztendliche grafische Darstellung zu berechnen und auf dem Bildschirm
	auszugeben...
*/

import java.util.ArrayList;
import java.awt.*;

public class kurve {
	// Klassenvariablen

	// Diese Liste wird von der DarstellungsTypUI für die JComboBox benötigt
	private static String kurvenStile[] = {
		"Aktienkurve",
		"Linienkurve (Tagesmittelwerte)",
		"Linienkurve (Wochenmittelwerte)",
		"Linienkurve (Monatsmittelwerte)",
		"Linienkurve (Jahresmittelwerte)"/*,
		"gepunktete Linie",
		"Balkendiagramm",
		"gleitende Kurve"*/
	};

	protected static String[] getKurvenStile(){
		return kurvenStile;
	}

	// Objekt-Variablen
	// fünf verschiedene Kurven, jede hat eine Nummer
	private int nummer;

	public void kurve(int nummer){
		this.nummer = nummer;
	} // kurve()

	/*
		ob eine Kurve mit einer bestimmten Nummer von
		1 bis 5 existiert oder nicht
		wird vom subImportDialog auf true oder false gesetzt,
		da nur dieser bestimmen kann, ob die benötigten
		Werte für die Kurve existieren
	*/
	private boolean exists = false;

	private Color farbe;

	private int kurvenStilIndex; // enthält Index-wert für kurvenStile

	private ArrayList werte = new ArrayList(1);
	private ArrayList daten = new ArrayList(1); // Mehrzahl von Datum

	private ArrayList tagesMittel = new ArrayList(1);
	private ArrayList wochenMittel = new ArrayList(1);
	private ArrayList monatsMittel = new ArrayList(1);
	private ArrayList jahresMittel = new ArrayList(1);

	private ArrayList datumMonatsMittel = new ArrayList(1);
	private ArrayList datumJahresMittel = new ArrayList(1);
	private ArrayList datumWochenMittel = new ArrayList(1);

	// set- und get-Methoden für die Attribute der Kurve
	protected void setExists(boolean exists){
		this.exists = exists;
	} // setExists()


	protected boolean isset(){
		return this.exists;
	} // isset()


	protected Color getFarbe(){
		return this.farbe;
	} // getFarbe()


	protected void setFarbe(Color farbe){
		this.farbe = farbe;
	} // setFarbe()


	protected int getKurvenStilIndex(){
		return this.kurvenStilIndex;
	} // getKurvenStilIndex()


	protected String getKurvenStil(){
		return this.kurvenStile[this.kurvenStilIndex];
	} // getKurvenStil()


	protected void setKurvenStilIndex(int index){
		this.kurvenStilIndex = index;
	} // setKurvenStilIndex()


	protected ArrayList getWerte(){
		return this.werte;
	} // getWerte()


	protected void setWerte(ArrayList werte){
		this.werte = werte;
	} // setWerte()


	protected ArrayList getDaten(){
		return this.daten;
	} // getDaten()


	protected void setDaten(ArrayList daten){
		this.daten = daten;
	} // setDaten()


	// set- und get-Methoden für tagesMittel

	protected ArrayList getTagesMittel(){
		return this.tagesMittel;
	} // getTagesMittel()


	protected void setTagesMittel(ArrayList tagesMittel){
		this.tagesMittel = tagesMittel;
	} // setTagesMittel()


	// set- und get-Methoden für wochenMittel und datumWochenMittel

	protected ArrayList getWochenMittel(){
		return this.wochenMittel;
	} // getWochenMittel()


	protected void setWochenMittel(ArrayList wochenMittel){
		this.wochenMittel = wochenMittel;
	} // setWochenMittel()


	protected ArrayList getDatumWochenMittel(){
		return this.datumWochenMittel;
	} // getDatumWochenMittel()


	protected void setDatumWochenMittel(ArrayList datumWochenMittel){
		this.datumWochenMittel = datumWochenMittel;
	} // setDatumWochenMittel()


	// set- und get-Methoden für monatsMittel und datumMonatsMittel

	protected ArrayList getMonatsMittel(){
		return this.monatsMittel;
	} // getMonatsMittel()


	protected void setMonatsMittel(ArrayList monatsMittel){
		this.monatsMittel = monatsMittel;
	} //setMonatsMittel()


	protected ArrayList getDatumMonatsMittel(){
		return this.datumMonatsMittel;
	} // getDatumMonatsMittel()


	protected void setDatumMonatsMittel(ArrayList datumMonatsMittel){
		this.datumMonatsMittel = datumMonatsMittel;
	} // setDatumMonatsMittel()


	//set- und get-Methoden für jahresMittel und datumJahresMittel

	protected ArrayList getJahresMittel(){
		return this.jahresMittel;
	} // getJahresMittel()


	protected void setJahresMittel(ArrayList jahresMittel){
		this.jahresMittel = jahresMittel;
	} // setJahresMittel()


	protected ArrayList getDatumJahresMittel(){
		return this.datumJahresMittel;
	} // getDatumJahresMittel()


	protected void setDatumJahresMittel(ArrayList datumJahresMittel){
		this.datumJahresMittel = datumJahresMittel;
	} // setDatumJahresMittel()


	protected void zeichneKurve(){
		berechneMittelwerte berechneMittelwerte = new berechneMittelwerte(this.getWerte(), this.getDaten());
		switch(this.getKurvenStilIndex()){
		    case 0:
				hauptFensterUI.layeredPane.add(
					new zeichneLinienKurve(
						// wird später durch aktienkurve ersetzt
						berechneMittelwerte.berechneJahresMittel(),
						this.getFarbe()
					),
					new Integer(nummer+2)
				);
			    break;
		    case 1:
				hauptFensterUI.layeredPane.add(
					new zeichneLinienKurve(
						berechneMittelwerte.berechneTagesMittel(),
						this.getFarbe()
					),
					new Integer(nummer+2)
				);
			    break;
		    case 2:
				hauptFensterUI.layeredPane.add(
					new zeichneLinienKurve(
						berechneMittelwerte.berechneWochenMittel(),
						this.getFarbe()
					),
					new Integer(nummer+2)
				);
			    break;
		    case 3:
				hauptFensterUI.layeredPane.add(
					new zeichneLinienKurve(
						berechneMittelwerte.berechneMonatsMittel(),
						this.getFarbe()
					),
					new Integer(nummer+2)
				);
			    break;
		    case 4:
				hauptFensterUI.layeredPane.add(
					new zeichneLinienKurve(
						berechneMittelwerte.berechneJahresMittel(),
						this.getFarbe()
					),
					new Integer(nummer+2)
				);
			    break;
		}// switch()

	} // zeichneKurve()


} // kurve
