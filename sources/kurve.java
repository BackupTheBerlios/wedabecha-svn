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

import java.util.ArrayList;

public class kurve {
	// Klassenvariablen
	private static String kurvenStile[] = {
		"Aktienkurve",
		"durchgezogene Linie"/*,
		"gepunktete Linie",
		"Balkendiagramm",
		"gleitende Kurve"*/
	};

	protected static String[] getKurvenStile(){
		return kurvenStile;
	}

	// Objekt-Variablen

	private boolean exists = false;

	private String farbe;
	private int kurvenStilIndex; // enthält Index-wert für kurvenStile
	private ArrayList werte = new ArrayList(
		new ArrayList(1)
	);

	private ArrayList daten = new ArrayList(1);// Mehrzahl von Datum

	private ArrayList mittelWerte = new ArrayList(1);
	private ArrayList mittelDaten = new ArrayList(1); // Mehrzahl von Datums

	protected void setExists(boolean exists){
		this.exists = exists;
	}


	protected boolean isset(){
		return this.exists;
	}


	protected String getFarbe(){
		return this.farbe;
	}


	protected void setFarbe(String farbe){
		this.farbe = farbe;
	}


	protected int getKurvenStilIndex(){
		return this.kurvenStilIndex;
	}


	protected String getKurvenStil(){
		return this.kurvenStile[this.kurvenStilIndex];

	}


	protected void setKurvenStilIndex(int index){
		this.kurvenStilIndex = index;
	}


	protected ArrayList getWerte(){
		return this.werte;
	}


	protected void setWerte(ArrayList werte){
		this.werte = werte;
	}


	protected ArrayList getDaten(){
		return this.daten;
	}


	protected void setDaten(ArrayList daten){
		this.daten = daten;
	}


	protected ArrayList getMittelWerte(){
		return this.mittelWerte;
	}


	protected void setMittelWerte(ArrayList mittelWerte){
		this.mittelWerte = mittelWerte;
	}


	protected ArrayList getMittelDaten(){
		return this.mittelDaten;
	}


	protected void setMittelDaten(ArrayList mittelDaten){
		this.mittelDaten = mittelDaten;
	}



} // kurve
