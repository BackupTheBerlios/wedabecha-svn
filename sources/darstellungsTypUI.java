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
import java.awt.event.*;
import java.awt.*;

class darstellungsTypUI extends JDialog {
	private Container fenster = getContentPane();
	private FlowLayout fensterLayout = new FlowLayout();

	private JPanel topPanel = new JPanel( new GridLayout(2,2) );
		private JPanel topLeftPanel = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
		private JPanel topRightPanel = new JPanel( new FlowLayout(FlowLayout.LEFT) );
		private JPanel bottomLeftPanel = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
		private JPanel bottomRightPanel = new JPanel( new FlowLayout(FlowLayout.LEFT) );

	private JPanel bottomPanel = new JPanel( new FlowLayout() );

	private JLabel stilLabel = new JLabel("Kurvenstil:");

	private JComboBox stilCombo = new JComboBox(kurve.getKurvenStile());

	JLabel farbeLabel = new JLabel("Farbe:");
	JButton farbeButton = new JButton("w\u00e4hlen...");

	JButton okKnopf = new JButton("OK");

	private int tabellenNummer;


	// Konstruktor
	public darstellungsTypUI(int tabellenNummer){
		this.tabellenNummer = tabellenNummer;
		this.pack();
	}


	public void pack(){
		this.fenster.setLayout(this.fensterLayout);
		this.fenster.add(this.topPanel);
			this.topPanel.add(this.topLeftPanel);
				this.topLeftPanel.add(this.stilLabel);
			this.topPanel.add(this.topRightPanel);
				this.topRightPanel.add(this.stilCombo);
			this.topPanel.add(this.bottomLeftPanel);
				this.bottomLeftPanel.add(this.farbeLabel);
			this.topPanel.add(this.bottomRightPanel);
				this.bottomRightPanel.add(this.farbeButton);
		this.fenster.add(this.bottomPanel);
			this.bottomPanel.add(this.okKnopf);
				this.okKnopf.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
						wedabecha.getKurve(tabellenNummer).setKurvenStilIndex(
							stilCombo.getSelectedIndex()
						);
						wedabecha.getKurve(tabellenNummer).setFarbe(""); // hier muss noch ein string übergeben werden
						setVisible(false);
					}
				});

		/*
			standard zum erzeugen und positionieren des dialogs
		*/
		int bildSchirmBreite = getToolkit().getScreenSize().width;
		int bildSchirmHoehe = getToolkit().getScreenSize().height;
		int Xposition = (bildSchirmBreite - 350) / 2;
		int Yposition = (bildSchirmHoehe - 150) / 2;
		setSize(350,150);
		setLocation(Xposition,Yposition);
		setResizable(false);
		setModal(true);
		setTitle("Darstellungstyp - wedabecha");
		setVisible(true);

	} // pack()


	/*
	// debuggen
	public static void main(String args[]){
		new darstellungsTypUI();
	}
	*/

} // darstellungsTypUI