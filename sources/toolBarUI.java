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


public class toolBarUI /*implements ActionListener*/{
	protected JToolBar toolBar = new JToolBar("Werkzeugleiste");
		private ImageIcon oeffnen = new ImageIcon("Images/oeffnen.gif");
			private JButton oeffnenbutton = new JButton(oeffnen);
		private ImageIcon speichern = new ImageIcon("Images/speichern.gif");
			private JButton speichernbutton = new JButton(speichern);
		private ImageIcon undo = new ImageIcon("Images/undo.gif");
			private JButton undobutton = new JButton(undo);
		private ImageIcon redo = new ImageIcon("Images/redo.gif");
			private JButton redobutton = new JButton(redo);
		private ImageIcon gitter = new ImageIcon("Images/gitter.gif");
			private JToggleButton gitterbutton = new JToggleButton(gitter);
		private ImageIcon liniezeichnen = new ImageIcon("Images/linie.gif");
			protected JToggleButton liniezeichnenbutton = new JToggleButton(liniezeichnen);
		private ImageIcon pfeilzeichnen = new ImageIcon("Images/pfeil.gif");
			protected JToggleButton pfeilzeichnenbutton = new JToggleButton(pfeilzeichnen);
		private ImageIcon textzeichnen = new ImageIcon("Images/text.gif");
			protected JToggleButton textzeichnenbutton = new JToggleButton(textzeichnen);
		private JToggleButton tabelle1Button = new JToggleButton("Tabelle 1");
		private JToggleButton tabelle2Button = new JToggleButton("Tabelle 2");
		private JToggleButton tabelle3Button = new JToggleButton("Tabelle 3");
		private JToggleButton tabelle4Button = new JToggleButton("Tabelle 4");
		private JToggleButton tabelle5Button = new JToggleButton("Tabelle 5");
				
		private int breite;
		

	// Konstruktor
	public toolBarUI(int breite){
		this.pack();
		this.toolBar.setSize(breite, 35);
	} // toolBarUI()

	
	protected void setBreite(int breite){
	    this.toolBar.setSize(breite, 35);
	}// setBreite(int breite)

	
	// Setzt die ToolBar zusammen
	public void pack(){
		this.toolBar.add(oeffnenbutton);
			this.oeffnenbutton.setContentAreaFilled(true);
		this.toolBar.add(speichernbutton);
			this.speichernbutton.setContentAreaFilled(true);
		/* werden vielleicht noch Implementiert wenn noch Zeit ist */
		//this.toolBar.add(undobutton);
			//this.undobutton.setContentAreaFilled(true);
		//this.toolBar.add(redobutton);
			//this.redobutton.setContentAreaFilled(true);
		//this.toolBar.addSeparator();
		//this.toolBar.add(gitterbutton);
			//this.gitterbutton.setContentAreaFilled(true);
		this.toolBar.addSeparator();
		this.toolBar.add(liniezeichnenbutton);
			this.liniezeichnenbutton.setContentAreaFilled(true);
			this.liniezeichnenbutton.addActionListener(new linieButtonListener());
		this.toolBar.add(pfeilzeichnenbutton);
			this.pfeilzeichnenbutton.setContentAreaFilled(true);
			this.pfeilzeichnenbutton.addActionListener(new pfeilButtonListener());
		this.toolBar.add(textzeichnenbutton);
			this.textzeichnenbutton.setContentAreaFilled(true);
			this.textzeichnenbutton.addActionListener(new textButtonListener());
		/* die TabellenButtons werden erst gebraucht wenn mehrere Tabellen angezeigt werden können
		this.toolBar.addSeparator();
		this.toolBar.addSeparator();
		this.toolBar.add(tabelle1Button);
			this.tabelle1Button.setEnabled(false);
		this.toolBar.add(tabelle2Button);
			this.tabelle2Button.setEnabled(false);
		this.toolBar.add(tabelle3Button);
			this.tabelle3Button.setEnabled(false);
		this.toolBar.add(tabelle4Button);
			this.tabelle4Button.setEnabled(false);
		this.toolBar.add(tabelle5Button);
			this.tabelle5Button.setEnabled(false);
		*/
		
		this.toolBar.setFloatable(false);
		this.toolBar.setBorderPainted(true);
	} // pack()

	public JToolBar getToolBar(){
		return this.toolBar;
	} // getToolBar()


	class linieButtonListener implements ActionListener{

	    public void actionPerformed(ActionEvent e) {
		if(linieGewaehlt()){
		    abwaehlen(3);
		}// if
	    }// actionPerformed(ActionEvent e)

	}// linienButtonListener


	class pfeilButtonListener implements ActionListener{

	    public void actionPerformed(ActionEvent e) {
		if(pfeilGewaehlt()){
		    abwaehlen(1);
		}// if
	    }// actionPerformed(ActionEvent e)

	}// pfeilButtonListener


	class textButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		    if(textGewaehlt()){
			abwaehlen(2);
		    }//if
		}// actionPerformed(ActionEvent e)

	}// textButtonListener


	public void abwaehlen(int aus){
	    switch(aus){
		case 1:
		    this.textzeichnenbutton.setSelected(false);
		    this.liniezeichnenbutton.setSelected(false);
		    break;
		case 2:
		    this.liniezeichnenbutton.setSelected(false);
		    this.pfeilzeichnenbutton.setSelected(false);
		    break;
		case 3:
		    this.pfeilzeichnenbutton.setSelected(false);
		    this.textzeichnenbutton.setSelected(false);
		    break;
	    }// switch
	}// abwählen()


	public boolean textGewaehlt(){
	    return textzeichnenbutton.isSelected();
	}// textGewählt()


	public boolean gitterGewaehlt(){
	    return gitterbutton.isSelected();
	}// gitterGewaehlt()


	public boolean pfeilGewaehlt(){
	    return pfeilzeichnenbutton.isSelected();
	}// pfeilGewaehlt()


	public boolean linieGewaehlt(){
	    return liniezeichnenbutton.isSelected();
	}// linieGewaehlt
} // toolBarUI