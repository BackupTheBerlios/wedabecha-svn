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

//Diese Klasse dient zum Speichern der .weda-Dateien


import java.io.*;


public class exportiereTabelle {
	private String dateiname;


		public void export () throws Exception {
	    	//hier fehlt wohl noch was
		
			
			    fileWriter fw = null;
			    try
			    {
			      fw = new fileWriter( this.dateiname );
			      fw.write( "Hallo Welt geht in eine Datei" );
			    }
			    catch ( IOException e ) {
			      System.out.println( "Konnte Datei nicht erstellen" );
			    }
			    finally {
			      try {
			        if ( fw != null ) fw.close();
			      } catch (IOException e) {}
			    }
			  }
	  
	
	protected void setFile(String name){
		this.dateiname = name;
 	} // setFile()
	
	protected String getFile(){
		return this.dateiname;
	} // getFile()

}//exportiereTabelle
