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

class importiereTabelleUI {
	/*
		es kann fünf tabellen mit verschiedenen eigenschaften geben, die importiert werden können,
		also braucht es fünf instanzen (im array von 0 bis 4) der hinterGrundKlasse
	*/
	private static importiereTabelle hinterGrundKlasse[] = {new importiereTabelle(),
															new importiereTabelle(),
															new importiereTabelle(),
															new importiereTabelle(),
															new importiereTabelle(),
															};

	//konstruktor
	public importiereTabelleUI(){
		/*
			erzeugt den Import-Dialog
		*/
		new mainImportDialogUI();
	} // importiereTabelleUI()


	protected static importiereTabelle getHinterGrundKlasse(int tabellenNr){
		/**
			getHinterGrundKlasse(int tabellenNr) liefert die jeweilig
			angeforderte instanz der tabelle zurück.
			die funktion erwartet als parameter eine zahl von 1 bis 5
			für die erste bzw. die fünfte tabelle
		*/
		return hinterGrundKlasse[tabellenNr-1];
	} // getHinterGrundKlasse()
} // importiereTabelleUI