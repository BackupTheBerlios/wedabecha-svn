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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.filechooser.*;

public class mainImportDialogUI extends JDialog  {
	private Container importDialog = getContentPane();
	private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel topPanel = new JPanel(new GridLayout(5,1));
	private JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	// objekte für oben
	private JPanel LTzeile1 = new JPanel(new FlowLayout());
	private JPanel LTzeile2 = new JPanel(new FlowLayout());
	private JPanel LTzeile3 = new JPanel(new FlowLayout());
	private JPanel LTzeile4 = new JPanel(new FlowLayout());
	private JPanel LTzeile5 = new JPanel(new FlowLayout());

	private JLabel tabelle1Label = new JLabel("Tabelle 1 :");
	private JLabel tabelle2Label = new JLabel("Tabelle 2 :");
	private JLabel tabelle3Label = new JLabel("Tabelle 3 :");
	private JLabel tabelle4Label = new JLabel("Tabelle 4 :");
	private JLabel tabelle5Label = new JLabel("Tabelle 5 :");

	private JButton oeffneTabelle1 = new JButton("\u00D6ffnen");
	private JButton oeffneTabelle2 = new JButton("\u00D6ffnen");
	private JButton oeffneTabelle3 = new JButton("\u00D6ffnen");
	private JButton oeffneTabelle4 = new JButton("\u00D6ffnen");
	private JButton oeffneTabelle5 = new JButton("\u00D6ffnen");

	private JTextField pfadTabelle1 = new JTextField(20);
	private JTextField pfadTabelle2 = new JTextField(20);
	private JTextField pfadTabelle3 = new JTextField(20);
	private JTextField pfadTabelle4 = new JTextField(20);
	private JTextField pfadTabelle5 = new JTextField(20);

	private JButton darstellungTabelle1 = new JButton("Darstellung");
	private JButton darstellungTabelle2 = new JButton("Darstellung");
	private JButton darstellungTabelle3 = new JButton("Darstellung");
	private JButton darstellungTabelle4 = new JButton("Darstellung");
	private JButton darstellungTabelle5 = new JButton("Darstellung");

	// objekte unten
	private JButton okKnopf = new JButton("OK");
	private JButton abbrechenKnopf = new JButton("Abbrechen");

	public void pack(){
		// pack() setzt das dialogfeld zusammen
		// zuerst die grundstruktur
		this.mainPanel.add(this.topPanel);
		this.mainPanel.add(this.bottomPanel);
		this.importDialog.add(this.mainPanel);

		// das Panel links oben, enthaelt die meisten Objekte
		// zeile 1
		this.topPanel.add(this.LTzeile1);
			this.LTzeile1.add(this.tabelle1Label);
			this.LTzeile1.add(this.oeffneTabelle1);
				this.oeffneTabelle1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(1);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile1.add(this.pfadTabelle1);
			this.LTzeile1.add(this.darstellungTabelle1);
		// zeile 2
		this.topPanel.add(this.LTzeile2);
			this.LTzeile2.add(this.tabelle2Label);
			this.LTzeile2.add(this.oeffneTabelle2);
				this.oeffneTabelle2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(2);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile2.add(this.pfadTabelle2);
			this.LTzeile2.add(this.darstellungTabelle2);
		// zeile 3
		this.topPanel.add(this.LTzeile3);
			this.LTzeile3.add(this.tabelle3Label);
			this.LTzeile3.add(this.oeffneTabelle3);
				this.oeffneTabelle3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(3);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile3.add(this.pfadTabelle3);
			this.LTzeile3.add(this.darstellungTabelle3);
		// zeile 4
		this.topPanel.add(this.LTzeile4);
			this.LTzeile4.add(this.tabelle4Label);
			this.LTzeile4.add(this.oeffneTabelle4);
				this.oeffneTabelle4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(4);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile4.add(this.pfadTabelle4);
			this.LTzeile4.add(this.darstellungTabelle4);
		// zeile 5
		this.topPanel.add(this.LTzeile5);
			this.LTzeile5.add(this.tabelle5Label);
			this.LTzeile5.add(this.oeffneTabelle5);
				this.oeffneTabelle5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(5);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile5.add(this.pfadTabelle5);
			this.LTzeile5.add(this.darstellungTabelle5);

		// das Panel unten nur die Buttons für Ok und Abbrechen
		this.bottomPanel.add(this.okKnopf);
			this.okKnopf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					//
					setVisible(false);
				} //  actionPerformed(ActionEvent event)
			});
		this.bottomPanel.add(this.abbrechenKnopf);
			this.abbrechenKnopf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					setVisible(false);
				} // actionPerformed(ActionEvent event)
			});

		int bildSchirmBreite = getToolkit().getScreenSize().width;
		int bildSchirmHoehe = getToolkit().getScreenSize().height;
		int Xposition = (bildSchirmBreite - 600) / 2;
		int Yposition = (bildSchirmHoehe - 280) / 2;
		setSize(600,280);
		setLocation(Xposition,Yposition);
		setResizable(false);
		setModal(true);
		setTitle("Tabellen importieren - wedabecha");
		setVisible(true);
	} // pack()


	// konstruktor
	public mainImportDialogUI(){
		this.pack();
	} // importiereTabelleUI


	private void showSubDialog(int tabellenNummer) {
		new subImportDialogUI(tabellenNummer);
		/*switch (tabellenNummer){
			case 1: pfadTabelle1.setText();
				break;
			case 2: pfadTabelle2.setText(auswahlDialog.getSelectedFile().getName());
				break;
			case 3: pfadTabelle3.setText(auswahlDialog.getSelectedFile().getName());
				break;
			case 4: pfadTabelle4.setText(auswahlDialog.getSelectedFile().getName());
				break;
			case 5: pfadTabelle5.setText(auswahlDialog.getSelectedFile().getName());
				break;
		} // switch*/
	} // showSubDialog


	public void setPfad(String pfad, int nr){
		switch (nr){
			case 1: this.pfadTabelle1.setText(pfad);break;
			case 2: this.pfadTabelle2.setText(pfad);break;
			case 3: this.pfadTabelle3.setText(pfad);break;
			case 4: this.pfadTabelle4.setText(pfad);break;
			case 5: this.pfadTabelle5.setText(pfad);break;
		}
	} // setPfad

} // importiereTabelleUI