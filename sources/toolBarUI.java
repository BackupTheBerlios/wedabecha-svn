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


public class toolBarUI /*implements ActionListener*/{
	JToolBar toolBar = new JToolBar("Werkzeugleiste");
		ImageIcon oeffnen = new ImageIcon("Images/oeffnen.gif");
			JButton oeffnenbutton = new JButton(oeffnen);
		ImageIcon speichern = new ImageIcon("Images/speichern.gif");
			JButton speichernbutton = new JButton(speichern);
		ImageIcon undo = new ImageIcon("Images/undo.gif");
			JButton undobutton = new JButton(undo);
		ImageIcon redo = new ImageIcon("Images/redo.gif");
			JButton redobutton = new JButton(redo);
		ImageIcon gitter = new ImageIcon("Images/gitter.gif");
			JButton gitterbutton = new JButton(gitter);
		ImageIcon liniezeichnen = new ImageIcon("Images/linie.gif");
			JButton liniezeichnenbutton = new JButton(liniezeichnen);
		ImageIcon pfeilzeichnen = new ImageIcon("Images/pfeil.gif");
			JButton pfeilzeichnenbutton = new JButton(pfeilzeichnen);
		ImageIcon textzeichnen = new ImageIcon("Images/text.gif");
			JButton textzeichnenbutton = new JButton(textzeichnen);
		
	
	// Konstruktor
	public toolBarUI(){
		this.pack();
	} // toolBarUI()
	
	
	public void pack(){
		this.toolBar.add(oeffnenbutton);
			this.oeffnenbutton.setContentAreaFilled(false);
		this.toolBar.add(speichernbutton);
			this.speichernbutton.setContentAreaFilled(false);
		this.toolBar.add(undobutton);
			this.undobutton.setContentAreaFilled(false);
		this.toolBar.add(redobutton);
			this.redobutton.setContentAreaFilled(false);
		this.toolBar.addSeparator();
		this.toolBar.add(gitterbutton);
			this.gitterbutton.setContentAreaFilled(false);
		this.toolBar.addSeparator();
		this.toolBar.add(liniezeichnenbutton);
			this.liniezeichnenbutton.setContentAreaFilled(false);
		this.toolBar.add(pfeilzeichnenbutton);
			this.pfeilzeichnenbutton.setContentAreaFilled(false);
		this.toolBar.add(textzeichnenbutton);
			this.textzeichnenbutton.setContentAreaFilled(false);
		
		this.toolBar.setFloatable(true);
		this.toolBar.setBorderPainted(true);
	} // pack()
	
	public JToolBar getToolBar(){
		return this.toolBar;
	} // getToolBar()
} // toolBarUI