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

/**
	@author
		Dominic Hopf (dmaphy at users.berlios.de),
		Robert Exner (ashrak at users.berlios.de)
	@since 2005-01-31
	@version 0.0.1

*/

// in dieser Klasse brauchen wir nur Swing, da sie
// von der hauptFensterUI aus weiterverwendet wird
import javax.swing.*;
import java.awt.event.*;


public class hauptMenuUI {
	// alle Bestandteile des Menüs als Klassenatrribute deklarieren
	private JMenuBar mainMenuBar = new JMenuBar();
		private JMenu dateiMenu = new JMenu("Datei");
			private JMenuItem oeffneDateiItem = new JMenuItem("\u00D6ffnen");
			private JMenuItem importiereTabelleMenuItem = new JMenuItem("Tabelle importieren");
			private JMenuItem verknuepfeTabelleMenuItem = new JMenuItem("Tabellen verkn\u00fcpfen");
			private JMenuItem exportiereTabelleMenuItem = new JMenuItem("Tabelle exportieren");
			private JMenuItem exportiereGrafikMenuItem = new JMenuItem("Grafik exportieren");
			private JMenuItem druckenMenuItem = new JMenuItem("Drucken");
			private JMenuItem beendenMenuItem = new JMenuItem("Programm beenden");

		/*
			Menu [Kurve] : hat fünf einträge, für maximal fünf kurven,
			also machen wir ne liste von einträgen für das menu,
			das können wir per for-schleife besser packen,
			und eine methode einfacher schreiben, mit denen wir die
			Menueinträge schneller umd mit weniger code aktiveren und deaktivieren können...
		*/
		private JMenu kurveMenu = new JMenu("Kurve");
			private JMenu kurveMenuList[] = {
				new JMenu("Kurve 1"),
				new JMenu("Kurve 2"),
				new JMenu("Kurve 3"),
				new JMenu("Kurve 4"),
				new JMenu("Kurve 5")
			};

			private JMenuItem kurveOeffnenMenuItem[] = {
				new JMenuItem("Oeffnen"),
				new JMenuItem("Oeffnen"),
				new JMenuItem("Oeffnen"),
				new JMenuItem("Oeffnen"),
				new JMenuItem("Oeffnen")
			};

			private JMenuItem kurveSpeichernMenuItem[] = {
				new JMenuItem("Speichern"),
				new JMenuItem("Speichern"),
				new JMenuItem("Speichern"),
				new JMenuItem("Speichern"),
				new JMenuItem("Speichern")
			};

			private JMenuItem kurveDarstellungMenuItem[] = {
				new JMenuItem("Darstellung"),
				new JMenuItem("Darstellung"),
				new JMenuItem("Darstellung"),
				new JMenuItem("Darstellung"),
				new JMenuItem("Darstellung")
			};

			private JMenuItem kurveNeuZeichnenMenuItem[] = {
				new JMenuItem("Neu Zeichnen"),
				new JMenuItem("Neu Zeichnen"),
				new JMenuItem("Neu Zeichnen"),
				new JMenuItem("Neu Zeichnen"),
				new JMenuItem("Neu Zeichnen")
			};

			private int kurveIt;

		private JMenu annotationMenu = new JMenu("Annotation");
			private JMenuItem annotationPfeilMenuItem = new JMenuItem("Pfeil zeichnen");
			private JMenuItem annotationLinieMenuItem = new JMenuItem("Linie zeichnen");
			private JMenuItem annotationTextMenuItem = new JMenuItem("Text einf\u00fcgen");
		private JMenu bearbeitenMenu = new JMenu("Bearbeiten");
		private JMenu ansichtMenu = new JMenu("Ansicht");
			private JCheckBoxMenuItem zeigeGitterMenuItem = new JCheckBoxMenuItem("Gitter anzeigen");
			private JCheckBoxMenuItem zeigeToolBarItem = new JCheckBoxMenuItem("Werkzeugleiste anzeigen");
		private JMenu hilfeMenu = new JMenu("Hilfe");
			private JMenuItem kurzAnleitungMenuItem = new JMenuItem("Kurzanleitung");
			private JMenuItem dokuMenuItem = new JMenuItem("Dokumentation");
			private JMenuItem aboutMenuItem = new JMenuItem("\u00dcber");

		private int actionCounter;

	// konstruktor
	public hauptMenuUI(){
		this.pack();
	} // hauptMenuUI

	public void pack(){
		/**
			Die Methode setzt das HauptMenue aus den Klassenattributen zusammen.
		*/
		// die elemente des menues werden "rückwärts" zusammengesetzt
		// d.h. erst setze ich das dateimenü zusammen, bevor ich es zur MenuBar adde usw.

		// beginn dateiMenu
			this.dateiMenu.add(this.oeffneDateiItem);
			this.dateiMenu.add(this.importiereTabelleMenuItem);
				this.importiereTabelleMenuItem.addActionListener(new importiereTabelleListener());
// 			this.dateiMenu.add(this.verknuepfeTabelleMenuItem);
// 				this.verknuepfeTabelleMenuItem.addActionListener(new verknuepfeTabelleListener());
			this.dateiMenu.add(this.exportiereTabelleMenuItem);
				this.exportiereTabelleMenuItem.addActionListener(new exportiereTabelleListener());
			this.dateiMenu.add(this.exportiereGrafikMenuItem);
				this.exportiereGrafikMenuItem.addActionListener(new exportiereGrafikListener());
			this.dateiMenu.add(this.oeffneDateiItem);
				this.oeffneDateiItem.addActionListener(new oeffnenListener());
			this.dateiMenu.add(this.druckenMenuItem);
				this.druckenMenuItem.setEnabled(false);
			this.dateiMenu.add(this.beendenMenuItem);
				this.beendenMenuItem.addActionListener(new beendenListener());
		this.mainMenuBar.add(this.dateiMenu);
		// ende dateiMenu

		// beginn kurve-menues
			for (kurveIt = 0; kurveIt < 5; kurveIt++){
				this.kurveMenu.add(this.kurveMenuList[kurveIt]);
// 					this.kurveMenuList[kurveIt].add(this.kurveOeffnenMenuItem[kurveIt]);
// 						this.kurveOeffnenMenuItem[kurveIt].setEnabled(false);
// 					this.kurveMenuList[kurveIt].add(this.kurveSpeichernMenuItem[kurveIt]);
// 						this.kurveSpeichernMenuItem[kurveIt].setEnabled(false);
					this.kurveMenuList[kurveIt].add(this.kurveDarstellungMenuItem[kurveIt]);
						this.kurveDarstellungMenuItem[kurveIt].setEnabled(false);

					this.kurveMenuList[kurveIt].add(this.kurveNeuZeichnenMenuItem[kurveIt]);
						this.kurveNeuZeichnenMenuItem[kurveIt].setEnabled(false);
						this.kurveNeuZeichnenMenuItem[kurveIt].addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent event){
									int datenLaengen[] = new int[5];

									for(int i = 1; i <= 5; i++){
							    		// alle importierten Tabellen als Kurve zeichnen
										if(wedabecha.getKurve(i).isset()){
											wedabecha.getKurve(i).zeichneKurve();
											datenLaengen[i] = wedabecha.getKurve(i).getDaten().size();
										} // if

										java.util.Arrays.sort(datenLaengen);
										hauptFensterUI.maxDate = datenLaengen[4];
									} // for

									hauptFensterUI.layeredPane.repaint();
								} // actionPerformed()
							} // ActionListener()
						);

			} // for


//			for (actionCounter=1; actionCounter<6; actionCounter++){
				actionCounter = 1;
				this.kurveDarstellungMenuItem[actionCounter - 1].addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event){
								new darstellungsTypUI(actionCounter);
							}
						});
//			}
		this.mainMenuBar.add(this.kurveMenu);
		// ende kurve-menues


		// beginn annotationMenu
// 			this.annotationMenu.add(this.annotationPfeilMenuItem);
// 			this.annotationMenu.add(this.annotationLinieMenuItem);
// 			this.annotationMenu.add(this.annotationTextMenuItem);
// 		this.mainMenuBar.add(annotationMenu);
		// ende annotationMenu

		// beginn bearbeitenMenu
// 		this.mainMenuBar.add(this.bearbeitenMenu);
		// ende bearbeitenMenu

		/*
			wird vielleicht noch Implementiert werden
		*/

		// beginn ansichtMenu
// 		this.ansichtMenu.add(this.zeigeGitterMenuItem);
// 			this.zeigeGitterMenuItem.addActionListener(new zeichneRasterListener());
// 		this.ansichtMenu.add(this.zeigeToolBarItem);
// 			this.zeigeToolBarItem.addActionListener(new zeigeToolBarListener());
// 		this.mainMenuBar.add(this.ansichtMenu);
		// ende ansichtMenu

		// beginn hilfeMenu
			this.hilfeMenu.add(this.kurzAnleitungMenuItem);
				this.kurzAnleitungMenuItem.addActionListener(new hauptMenuKurzAnleitungListener());
			this.hilfeMenu.add(this.dokuMenuItem);
				this.dokuMenuItem.addActionListener(new hauptMenuDokumentationListener());
			this.hilfeMenu.add(this.aboutMenuItem);
		this.mainMenuBar.add(this.hilfeMenu);
		// ende hilfeMenu
	} // pack()

	public void setKurveEditable(int kurvenNummer, boolean wasnjetz){
		/**
			setKurveEditable setzt die einzelnen Menueinträge für eine Kurve
			aktiv oder deaktiv... wird z.b. vom import bei klick auf ok
			des subImportDialoges true gesetzt bzw. beim klick auf abbrechen false
		*/
		this.kurveDarstellungMenuItem[kurvenNummer - 1].setEnabled(wasnjetz);
		this.kurveNeuZeichnenMenuItem[kurvenNummer - 1].setEnabled(wasnjetz);
	}


	public JMenuBar getHauptMenu(){
		// wird von der hauptFensterUI aufgerufen und
		// liefert das hauptmenu zurück
		return this.mainMenuBar;
	}
} // hauptMenuUI