/****************************************************************************
 *   Copyright (C) 2004 by BTU SWP GROUP 04/6.1								*
 *																			*
 *   This program is free software; you can redistribute it and/or modify	*
 *   it under the terms of the GNU General Public License as published by	*
 *   the Free Software Foundation; either version 2 of the License, or		*
 *   (at your option) any later version.									*
 *																			*
 *   This program is distributed in the hope that it will be useful,		*
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of			*
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the			*
 *   GNU General Public License for more details.							*
 *																			*
 *   You should have received a copy of the GNU General Public License		*
 *   along with this program; if not, write to the							*
 *   Free Software Foundation, Inc.,										*
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.				*
 ***************************************************************************/

package importiereTabelle;

public class importiereTabelleUI {
	private static importiereTabelle hinterGrundKlasse[] = {new importiereTabelle(),
															new importiereTabelle(),
															new importiereTabelle(),
															new importiereTabelle(),
															new importiereTabelle(),
															};

	//konstruktor
	public importiereTabelleUI(){
		new mainImportDialogUI();
	} // importiereTabelleUI()


	protected static importiereTabelle getHinterGrundKlasse(int tabellenNr){
		/**tabellenNr kann nur eine ganze Zahl von 0 bis 4 sein */
		return hinterGrundKlasse[tabellenNr];
	} // getHinterGrundKlasse()
} // importiereTabelleUI