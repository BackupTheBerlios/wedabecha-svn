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
	JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
		ImageIcon oeffnen = new ImageIcon("oeffnen.jpg");
			JButton oeffnenbutton = new JButton("oeffnen");
		ImageIcon speichern = new ImageIcon("schliessen.jpg");
			JButton speichernbutton = new JButton(speichern);
		ImageIcon undo = new ImageIcon("undo.jpg");
			JButton undobutton = new JButton(undo);
		ImageIcon redo = new ImageIcon("redo.jpg");
			JButton redobutton = new JButton(redo);
		ImageIcon gitter = new ImageIcon("gitter.jpg");
			JButton gitterbutton = new JButton(gitter);
		ImageIcon liniezeichnen = new ImageIcon("linie.jpg");
			JButton liniezeichnenbutton = new JButton(liniezeichnen);
		ImageIcon pfeilzeichnen = new ImageIcon("pfeil.jpg");
			JButton pfeilzeichnenbutton = new JButton(pfeilzeichnen);
		ImageIcon textzeichnen = new ImageIcon("text.jpg");
			JButton textzeichnenbutton = new JButton(textzeichnen);
		
	
	public toolBarUI(){
		this.pack();
	} // toolBarUI()

	
	public void pack(){
		this.toolBar.add(oeffnenbutton);
		this.toolBar.add(speichernbutton);
		this.toolBar.add(undobutton);
		this.toolBar.add(redobutton);
		this.toolBar.add(gitterbutton);
		this.toolBar.add(liniezeichnenbutton);
		this.toolBar.add(pfeilzeichnenbutton);
		this.toolBar.add(textzeichnenbutton);
		
	} // pack()
	
	public JToolBar getToolBar(){
		return this.toolBar;
	} // toolBar()
} // toolBarUI