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

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class toolBarUI /*implements ActionListener*/{
	private JToolBar toolBar = new JToolBar("Werkzeugleiste");
		private ImageIcon oeffnen = new ImageIcon("Images/oeffnen.gif");
			private JButton oeffnenbutton = new JButton(oeffnen);
		private ImageIcon speichern = new ImageIcon("Images/speichern.gif");
			private JButton speichernbutton = new JButton(speichern);
		private ImageIcon undo = new ImageIcon("Images/undo.gif");
			private JButton undobutton = new JButton(undo);
		private ImageIcon redo = new ImageIcon("Images/redo.gif");
			private JButton redobutton = new JButton(redo);
		private ImageIcon gitter = new ImageIcon("Images/gitter.gif");
			private JButton gitterbutton = new JButton(gitter);
		private ImageIcon liniezeichnen = new ImageIcon("Images/linie.gif");
			private JButton liniezeichnenbutton = new JButton(liniezeichnen);
		private ImageIcon pfeilzeichnen = new ImageIcon("Images/pfeil.gif");
			private JButton pfeilzeichnenbutton = new JButton(pfeilzeichnen);
		private ImageIcon textzeichnen = new ImageIcon("Images/text.gif");
			private JButton textzeichnenbutton = new JButton(textzeichnen);


	// Konstruktor
	public toolBarUI(){
		this.pack();
	} // toolBarUI()


	// Setzt die ToolBar zusammen
	public void pack(){
		this.toolBar.add(oeffnenbutton);
			this.oeffnenbutton.setContentAreaFilled(true);
		this.toolBar.add(speichernbutton);
			this.speichernbutton.setContentAreaFilled(true);
		this.toolBar.add(undobutton);
			this.undobutton.setContentAreaFilled(true);
		this.toolBar.add(redobutton);
			this.redobutton.setContentAreaFilled(true);
		this.toolBar.addSeparator();
		this.toolBar.add(gitterbutton);
			this.gitterbutton.setContentAreaFilled(true);
		this.toolBar.addSeparator();
		this.toolBar.add(liniezeichnenbutton);
			this.liniezeichnenbutton.setContentAreaFilled(true);
		this.toolBar.add(pfeilzeichnenbutton);
			this.pfeilzeichnenbutton.setContentAreaFilled(true);
		this.toolBar.add(textzeichnenbutton);
			this.textzeichnenbutton.setContentAreaFilled(true);

		this.toolBar.setFloatable(false);
		this.toolBar.setBorderPainted(true);
	} // pack()

	public JToolBar getToolBar(){
		return this.toolBar;
	} // getToolBar()
} // toolBarUI