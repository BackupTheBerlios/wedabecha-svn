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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class importiereTabelleUI extends JDialog  {
	/*
		die bestandteile des dialogs erzeugen
	*/

	private Container importDialog = getContentPane();
	private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
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

	private static JTextField pfadTabelle1 = new JTextField(20);
	private static JTextField pfadTabelle2 = new JTextField(20);
	private static JTextField pfadTabelle3 = new JTextField(20);
	private static JTextField pfadTabelle4 = new JTextField(20);
	private static JTextField pfadTabelle5 = new JTextField(20);

	private JCheckBox speicherTabelle1 = new JCheckBox("Speichern");
	private JCheckBox speicherTabelle2 = new JCheckBox("Speichern");
	private JCheckBox speicherTabelle3 = new JCheckBox("Speichern");
	private JCheckBox speicherTabelle4 = new JCheckBox("Speichern");
	private JCheckBox speicherTabelle5 = new JCheckBox("Speichern");

	private JButton darstellungsTypButton1 = new JButton("Darstellung");
	private JButton darstellungsTypButton2 = new JButton("Darstellung");
	private JButton darstellungsTypButton3 = new JButton("Darstellung");
	private JButton darstellungsTypButton4 = new JButton("Darstellung");
	private JButton darstellungsTypButton5 = new JButton("Darstellung");


	// objekte unten
	private JButton okKnopf = new JButton("OK");
	private JButton abbrechenKnopf = new JButton("Abbrechen");


	// konstruktor
	public importiereTabelleUI(){
		this.pack();
	} // importiereTabelleUI()


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
			this.LTzeile1.add(pfadTabelle1);
			this.LTzeile1.add(this.speicherTabelle1);
			this.LTzeile1.add(this.darstellungsTypButton1);
				this.darstellungsTypButton1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){

					}
				});
		// zeile 2
		this.topPanel.add(this.LTzeile2);
			this.LTzeile2.add(this.tabelle2Label);
			this.LTzeile2.add(this.oeffneTabelle2);
				this.oeffneTabelle2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(2);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile2.add(pfadTabelle2);
			this.LTzeile2.add(this.speicherTabelle2);
			this.LTzeile2.add(this.darstellungsTypButton2);
		// zeile 3
		this.topPanel.add(this.LTzeile3);
			this.LTzeile3.add(this.tabelle3Label);
			this.LTzeile3.add(this.oeffneTabelle3);
				this.oeffneTabelle3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(3);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile3.add(pfadTabelle3);
			this.LTzeile3.add(this.speicherTabelle3);
			this.LTzeile3.add(this.darstellungsTypButton3);
		// zeile 4
		this.topPanel.add(this.LTzeile4);
			this.LTzeile4.add(this.tabelle4Label);
			this.LTzeile4.add(this.oeffneTabelle4);
				this.oeffneTabelle4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(4);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile4.add(pfadTabelle4);
			this.LTzeile4.add(this.speicherTabelle4);
			this.LTzeile4.add(this.darstellungsTypButton4);
		// zeile 5
		this.topPanel.add(this.LTzeile5);
			this.LTzeile5.add(this.tabelle5Label);
			this.LTzeile5.add(this.oeffneTabelle5);
				this.oeffneTabelle5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						showSubDialog(5);
					} // actionPerformed(ActionEvent event)
				});
			this.LTzeile5.add(pfadTabelle5);
			this.LTzeile5.add(this.speicherTabelle5);
			this.LTzeile5.add(this.darstellungsTypButton5);

		// das Panel unten nur die Buttons für Ok und Abbrechen
		this.bottomPanel.add(this.okKnopf);
			this.okKnopf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					setVisible(false);
				} //  actionPerformed(ActionEvent event)
			});

		this.bottomPanel.add(this.abbrechenKnopf);
			this.abbrechenKnopf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					setVisible(false);
				} // actionPerformed(ActionEvent event)
			});


		/*
			standard zum erzeugen und positionieren des dialogs
		*/
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


	private void showSubDialog(int tabellenNummer) {
		new subImportDialogUI(tabellenNummer);
	} // showSubDialog


	private void showDarstellungsDialog(int tabellenNummer){
		new darstellungsTypUI(tabellenNummer);
	}


	public static void setPfad(String pfad, int nr){
		/**
			setPfad setzt den Text der Textfelder im mainImportDialogUI,
			die Funktion wird von subImportDialogUI aufgerufen,
			sobald dieser mit OK geschlossen wurde
		*/
		switch (nr){
			case 1: pfadTabelle1.setText(pfad);break;
			case 2: pfadTabelle2.setText(pfad);break;
			case 3: pfadTabelle3.setText(pfad);break;
			case 4: pfadTabelle4.setText(pfad);break;
			case 5: pfadTabelle5.setText(pfad);break;
		}
	} // setPfad()

} // importiereTabelleUI