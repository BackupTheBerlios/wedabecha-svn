/***************************************************************************
 *   Copyright (C) 2004 by BTU SWP GROUP 04/6.1                            *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 ***************************************************************************/

/*hauptklasse die als programm aufgerufen wird*/
class wedabecha {
	private static kurve kurve[] = {
		new kurve(),
		new kurve(),
		new kurve(),
		new kurve(),
		new kurve()
	};

	private static zeichneKurve zeichneKurve[] = {
		new zeichneKurve(),
		new zeichneKurve(),
		new zeichneKurve(),
		new zeichneKurve(),
		new zeichneKurve()
	};


	protected static kurve getKurve(int nummer){
		/**
			parameter nummer muss zahl von 1 bis 5 sein
		*/
		return kurve[nummer - 1];
	} // getKurve()


	protected static zeichneKurve getZeichneKurve(int nummer){
		/**
			parameter nummer muss zahl von 1 bis 5 sein...
		**/

		return zeichneKurve[nummer - 1];
	} // getZeichneKurve()


	protected static void setZeichneKurve(int kurvenNummer, zeichneKurve kurve){
		zeichneKurve[kurvenNummer - 1] = kurve;
	} // setZeichneKurve


	//konstruktor
	public wedabecha(){
		hauptFensterUI hauptFenster = new hauptFensterUI();
	} //wedabecha()

	public static void main(String args[]){
		//einstiegspunkt für das programm
		new wedabecha();
	} // main(String args[])
} // wedabecha