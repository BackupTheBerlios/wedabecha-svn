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

import java.awt.event.*;
import javax.swing.*;


public class kontextMenuUI extends JPopupMenu {
	// alle Menuepunkte des Popup-Menues als Klassenatrribute deklarieren
	private JPopupMenu popup = new JPopupMenu();
		private JMenuItem undo = new JMenuItem("R\u00dcckg\u00e4ngig");
		private JMenuItem redo = new JMenuItem("Wiederherstellen");

		private JCheckBoxMenuItem gitteranzeigen = new JCheckBoxMenuItem("Gitter anzeigen");

		private JMenuItem liniezeichnen = new JMenuItem("Linie zeichnen");
		private JMenuItem schreibenItem = new JMenuItem("Text einf\u00dcgen");
		private JMenuItem pfeilzeichnen = new JMenuItem("Pfeil zeichnen");


	// konstruktor
	public kontextMenuUI(){
		this.pack();
	} // kontextMenuUI()

	public void pack(){
		this.popup.add(this.undo);
		this.popup.add(this.redo);
		this.popup.addSeparator();
		this.popup.add(this.gitteranzeigen);
		this.popup.addSeparator();
		this.popup.add(this.liniezeichnen);
		this.popup.add(this.schreibenItem);
		this.popup.add(this.pfeilzeichnen);

		setSize(200,300);
		setVisible(true);


	} // pack()


	public JPopupMenu getKontextMenu(){
		return this.popup;
	} // getKontextMenu()

/*	public static void main(String args[]){
		new kontextMenuUI();
	} // main()
*/
} // kontextMenuUI