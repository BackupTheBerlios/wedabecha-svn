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

package importiereTabelle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class subImportDialogUI extends JDialog {
	/*
		bestandteile des dialogs erzeugen
	*/
	private Container fenster = getContentPane();
		private JPanel topPanel = new JPanel(new GridLayout(3,2));
		private JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		private JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

			private JPanel label1Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			private JPanel label2Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			private JPanel label3Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			private JPanel edit1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			private JPanel edit2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			private JPanel edit3Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

	private JLabel lokalLabel = new JLabel("lokale Datei");
	private JLabel datumsFormatLabel = new JLabel("DatumsFormat");
	private JLabel trennzeichenLabel = new JLabel("Trennzeichen");


	private JComboBox trennzeichenBox = new JComboBox(importiereTabelle.getTrennzeichenStr());

	private JButton durchsuchenKnopf = new JButton("Durchsuchen ...");
	private JButton datumsFormatKnopf = new JButton("Datum"); // die beschriftung muss dynamisch anngepasst werden

	private JLabel pfadLabel = new JLabel("Pfad:");
	private JTextField pfadField = new JTextField(30);

	private JButton okKnopf = new JButton("OK");
	private JButton abbrechenKnopf = new JButton("Abbrechen");

	private int tabellenNummer;

	// konstruktor
	public subImportDialogUI(int tabellenNummer){
		/**
			der konstruktor erwartet als parameter die tabellenNummer,
			damit bestimmt werden kann, für welche Tabelle (1-5)
			die eigenschaften festgelegt werden
		*/

		setTitle("Tabelle " + tabellenNummer + " f\u00fcr den Import vorbereiten - wedabecha");
		this.tabellenNummer = tabellenNummer;
		this.pack();
	} // subImportDialogUI()

	public void pack(){
		/**
			pack() setzt den dialog aus den einzelnen bestandteilen zusammen
		*/
		this.fenster.setLayout(new FlowLayout());
		this.fenster.add(this.topPanel);
		this.fenster.add(this.middlePanel);
		this.fenster.add(this.bottomPanel);

		this.topPanel.add(this.label1Panel);
			this.label1Panel.add(this.lokalLabel);
		this.topPanel.add(this.edit1Panel);
			this.edit1Panel.add(this.durchsuchenKnopf);
				this.durchsuchenKnopf.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						 chooseFile();
					}
				});

		this.topPanel.add(this.label2Panel);
			this.label2Panel.add(this.datumsFormatLabel);
		this.topPanel.add(this.edit2Panel);
			this.edit2Panel.add(this.datumsFormatKnopf);
				this.datumsFormatKnopf.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						new definiereDatumUI(tabellenNummer);
					}
				});

		this.topPanel.add(this.label3Panel);
			this.label3Panel.add(this.trennzeichenLabel);
		this.topPanel.add(this.edit3Panel);
			this.edit3Panel.add(this.trennzeichenBox);
				this.trennzeichenBox.setEditable(false);

		this.middlePanel.add(this.pfadLabel);
		this.middlePanel.add(this.pfadField);

		this.bottomPanel.add(this.okKnopf);
			this.okKnopf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					//System.out.println( event.getActionCommand());

					mainImportDialogUI.setPfad(
						importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).getImportPfad(),
						tabellenNummer
					);

					importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).setInternerSpeicherName(
						importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).getImportName()
					);

					importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).setTrennzeichenIndex(
						trennzeichenBox.getSelectedIndex()
					);

					// entkäfern
					System.out.println(importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).toString());

					setVisible(false);
				}
			});
		this.bottomPanel.add(this.abbrechenKnopf);
			this.abbrechenKnopf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					setVisible(false);
				}
			});

		/*
			standard zum erzeugen und positionieren des dialogs
		*/
		int bildSchirmBreite = getToolkit().getScreenSize().width;
		int bildSchirmHoehe = getToolkit().getScreenSize().height;
		int Xposition = (bildSchirmBreite - 600) / 2;
		int Yposition = (bildSchirmHoehe - 280) / 2;
		setSize(400,225);
		setLocation(Xposition,Yposition);
		setResizable(false);
		setModal(true);
		setVisible(true);
	} // pack()


	public void chooseFile(){
		JFileChooser auswahlDialog = new JFileChooser();
    	int returnVal = auswahlDialog.showOpenDialog(this);
    	if(returnVal == JFileChooser.APPROVE_OPTION) {
			this.pfadField.setText(auswahlDialog.getSelectedFile().getPath());
			importiereTabelleUI.getHinterGrundKlasse(this.tabellenNummer).setImportPfad(
				auswahlDialog.getSelectedFile().getPath()
			);

			importiereTabelleUI.getHinterGrundKlasse(this.tabellenNummer).setImportName(
				auswahlDialog.getSelectedFile().getName()
			);
		} // fi

	} // chooseFile()


	/*public static void main(String args[]){
		new subImportDialogUI(1);
	}*/

} // subImportiereTabelleUI