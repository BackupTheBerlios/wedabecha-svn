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

public class definiereDatumUI extends JDialog {
	private Container dialog = getContentPane();
	private JPanel	topPanel = new JPanel(new GridLayout(3,1));
		private JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		private JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		private JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel buttonPanel = new JPanel(new FlowLayout());

	private ButtonGroup gruppeRB = new ButtonGroup();

	// code für die erste zeile
	private JLabel spaltePreLabel = new JLabel("Datum steht in der ");
	private String spalten[] = {"ersten","letzten"};
	private JComboBox spalteCombo = new JComboBox(this.spalten);
	private JLabel spalteSufLabel = new JLabel(" Spalte der Datei in Form");
	// code für zweite zeile
	private JRadioButton inkRB = new JRadioButton("einer inkrementierenden Zahl, welche",true);
	private String inkRepraesentiert[] = {"einen Tag","eine Woche","einen Monat","ein Jahr"};
	private JComboBox inkZahlCombo = new JComboBox(this.inkRepraesentiert);
	private JLabel repraesentLabel = new JLabel("repr\u00e4sentiert.");
	// code für dritte zeile
	private JRadioButton konkretRB = new JRadioButton("eines anderen konkreten Datumsformates :");
	private String datenFormate[] = {"YYYY-MM-DD","DD.MM.YYYY","MM.DD.YYYY","DD/MM/YYYY","MM/DD/YYYY"};
	private JComboBox datumCombo = new JComboBox(this.datenFormate);


	private JButton okKnopf = new JButton("OK");
	private JButton abbrechenKnopf = new JButton("Abbrechen");

	private String datumsFormat;

	private int tabellenNummer;

	// konstruktor
	public definiereDatumUI(int tabellenNummer){
		this.tabellenNummer = tabellenNummer;
		this.pack();
	} // definiereDatumUI


	public void pack(){
		this.dialog.setLayout(new FlowLayout());

		// radiobuttons in einer gruppe
		this.gruppeRB.add(this.inkRB);
		this.gruppeRB.add(this.konkretRB);

		this.dialog.add(this.topPanel);
			this.topPanel.add(this.panel1);
			this.topPanel.add(this.panel2);
			this.topPanel.add(this.panel3);
		this.dialog.add(this.buttonPanel);

		// zeile1 zusammensetzen
		this.panel1.add(this.spaltePreLabel);
		this.panel1.add(this.spalteCombo);
		this.panel1.add(this.spalteSufLabel);

		// zeile2 zusammensetzen
		this.panel2.add(this.inkRB);
		this.panel2.add(this.inkZahlCombo);
			this.inkZahlCombo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					inkRB.setSelected(true);
				}
			});
		this.panel2.add(this.repraesentLabel);

		// zeile3 zusammensetzen
		this.panel3.add(this.konkretRB);
		this.panel3.add(this.datumCombo);
			this.datumCombo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					konkretRB.setSelected(true);
				}
			});


		// buttons für den dialog

			this.buttonPanel.add(this.okKnopf);
				this.okKnopf.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						if(spalteCombo.getSelectedIndex() == 0){
							importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).setDatumsPosFirstColumn(true);
						} else {
							importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).setDatumsPosFirstColumn(false);
						} // if() else
						if(inkRB.isSelected()){
							importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).setInkZahlRep(inkZahlCombo.getSelectedItem().toString());
						} else {
							importiereTabelleUI.getHinterGrundKlasse(tabellenNummer).setDatumsFormat(datumCombo.getSelectedItem().toString());
						} // if() else
						setVisible(false);
					}
				});
			this.buttonPanel.add(this.abbrechenKnopf);
				this.abbrechenKnopf.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						setVisible(false);
					}
				});

		int bildSchirmBreite = getToolkit().getScreenSize().width;
		int bildSchirmHoehe = getToolkit().getScreenSize().height;
		int Xposition = (bildSchirmBreite - 600) / 2;
		int Yposition = (bildSchirmHoehe - 280) / 2;
		setSize(500,200);
		setLocation(Xposition,Yposition);
		setResizable(false);
		setModal(true);
		setTitle("Format des Datums f\u00fcr den Tabellenimport festlegen - wedabecha");
		setVisible(true);
	} // pack()

	/*public static void main(String args[]){
		new definiereDatumUI();
	} // main(String args[])*/
} // definiereDatumUI