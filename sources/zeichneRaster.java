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

import java.awt.*;
import javax.swing.*;

public class zeichneRaster extends JComponent {
	private int breite;
	private int hoehe;

	protected void setBreite(int breite){
		this.breite = breite;
	} // setBreite()

	protected void setHoehe(int hoehe){
		this.hoehe = hoehe;
	} // setHoehe()

    public zeichneRaster(){

    } // zeichneRaster()

	public void paint(Graphics raster){
		this.update(raster);

		int abstand = 25;

		for(int i=0; i<this.breite;i+=abstand){
	    	for(int j=0; j<this.hoehe; j+=abstand){
				raster.drawLine(i, 0, i, this.hoehe);
				raster.drawLine(0, j, this.breite, j);
	    	} // for(j)
		} // for(i)
	} // paint()

	public void update(Graphics raster){

	}

} // zeichneRaster