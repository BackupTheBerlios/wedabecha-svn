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

// Diese Klasse dient zum Erstellen und Speichern eines Screenshots


import com.sun.image.codec.jpeg.JPEGCodec;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class exportiereGrafik {
	private String dateiname;

	public void export() throws Exception {

		Dimension     size  = hauptFensterUI.hauptFenster.getSize();
		BufferedImage image = (BufferedImage)hauptFensterUI.hauptFenster.createImage(size.width, size.height);
		
		OutputStream  out  = new FileOutputStream( this.dateiname );
		JPEGCodec.createJPEGEncoder( out ).encode( image );
		out.close();
		} // export()

	protected void setFile(String name){
		this.dateiname = name;
 	} // setFile()

	protected String getFile(){
		return this.dateiname;
	}
} // exportiereGrafik

