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

// hier brauchen wir alle Imports für die GUI,
// dies ist das Hauptfenster.
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class hauptFensterUI extends JFrame {
	static JFrame hauptFenster = new JFrame("wedabecha");
	protected static JLayeredPane mainPane = new JLayeredPane();
	protected static JLayeredPane layeredPane = new JLayeredPane();
	protected static JLayeredPane toolbarPane = new JLayeredPane();

	Dimension d;

	protected static int fensterBreite = 700;
	protected static int fensterHoehe = 500;

	protected static toolBarUI toolBar = new toolBarUI(fensterBreite);
	protected static zeichneRaster zeichneRaster = new zeichneRaster(fensterBreite, fensterHoehe);
	protected static zeichneKoordinatensystem koordSys = new zeichneKoordinatensystem(fensterBreite,fensterHoehe);
	protected kontextMenuUI kontext = new kontextMenuUI();

	// konstruktor
	public hauptFensterUI(){
	    this.fensterBreite = 700;
	    this.fensterHoehe = 500;
	    this.pack();
	} // hauptFensterUI()


	public static void setGroesse(int breite, int hoehe){
	    mainPane.setSize(breite, hoehe);
	    layeredPane.setSize(breite, hoehe);
	    toolbarPane.setSize(breite, hoehe);
	} //setGroesse()


	public void pack(){
		/**
		pack() setzt das Fenster als Ganzes aus den einzelnen
		Bestandteilen zusammen
		*/

		// Hauptmenu initialisieren
		hauptMenuUI hauptMenu = new hauptMenuUI();

		// Hauptmenu in das Fenster einbinden
		hauptFensterUI.hauptFenster.setJMenuBar(hauptMenu.getHauptMenu());

		// Listener zum Fensterschliessen per "wegkreuzen"
		hauptFensterUI.hauptFenster.addWindowListener(new beendenListener());

		int bildSchirmBreite = getToolkit().getScreenSize().width;
		int bildSchirmHoehe = getToolkit().getScreenSize().height;
		int Xposition = (bildSchirmBreite - this.fensterBreite) / 2;
		int Yposition = (bildSchirmHoehe - this.fensterHoehe) / 2;
		hauptFensterUI.hauptFenster.setSize(this.fensterBreite,this.fensterHoehe);

		hauptFensterUI.hauptFenster.setContentPane(mainPane);

		mainPane.add(toolbarPane, JLayeredPane.PALETTE_LAYER);
		mainPane.add(layeredPane, JLayeredPane.DEFAULT_LAYER);

		mainPane.setSize(this.fensterBreite,this.fensterHoehe);
		mainPane.setVisible(true);

		// JLayeredPane wird als neue ContentPane eingesetzt
		layeredPane.setOpaque(true); // ContentPane muss durchsichtig sein

// 		toolbarPane.setSize(this.fensterBreite,35);

		layeredPane.setSize(this.fensterBreite,this.fensterHoehe);
		// !!! warum is das toolBarPane hier nich sichtbar???
		toolbarPane.setVisible(false);
		layeredPane.setVisible(true);

		// Raster der neuen ContentPane adden
		hauptFensterUI.layeredPane.add(zeichneRaster, JLayeredPane.DEFAULT_LAYER);

		// Koordinatensystem der neuen ContentPane adden
		hauptFensterUI.layeredPane.add(koordSys, JLayeredPane.DEFAULT_LAYER);

		// Werkzeugleiste einbinden
		hauptFensterUI.mainPane.add(toolBar.getToolBar(), JLayeredPane.PALETTE_LAYER);

		hauptFensterUI.hauptFenster.setLocation(Xposition,Yposition);
		hauptFensterUI.hauptFenster.setResizable(true);
		hauptFensterUI.hauptFenster.setVisible(true);

// 		hauptFensterUI.layeredPane.add(kontext.getKontextMenu(), JLayeredPane.POPUP_LAYER);


// 		hauptFensterUI.layeredPane.addMouseListener(new MouseAdapter() {
// 			public void mouseReleased(MouseEvent me ) {
// 				if ( me.getButton() == MouseEvent.BUTTON3) {
// 					kontext.getKontextMenu().show( layeredPane, me.getX(), me.getY() );
// 				} // if()
// 			} // mouseReleased(MouseEvent me)
// 		} ); // addMouseListener()
//

		// dieser MouseListener sorgt dafür, dass die Textfelder dem Hauptfenster hinzugefügt werden können
		hauptFensterUI.layeredPane.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent me) {
			    // wenn der ToggleButton in der Toolbar aktiviert ist...
			    if(toolBar.textGewaehlt()){
				// ...reagiert erst der MouseListener auf den Linksklick
				if(me.getButton() == MouseEvent.BUTTON1){
				    String text = JOptionPane.showInputDialog(null,
								"Bitte den darzustellenden Text eingeben",
								"neues Textfeld erstellen.",
								JOptionPane.QUESTION_MESSAGE);
				    if(text != null){
					zeichneText zeichneText = new zeichneText(text, me.getX(), me.getY());
					layeredPane.add(zeichneText, new Integer(8));
					System.out.println(text);
				    }// if
				}// if
			    }// if
			}// mouseReleased(MouseEvent me)
		}// MouseAdapter
		);// addMouseListener()


		//dieser MouseListener sorgt dafür, dass die Linien im Hauptfenster gezeichnet werden können
		hauptFensterUI.layeredPane.addMouseListener(new MouseAdapter(){
			private int startX;
			private int endX;
			private int startY;
			private int endY;
			private int zaehler; // legt die koordinaten für start- und endpunkte fest


			public void mouseReleased(MouseEvent me) {
			    // wenn der ToggleButton in der Toolbar aktiviert ist...
			    if(toolBar.linieGewaehlt()){
				// ...reagiert erst der MouseListener auf den Linksklick
				if(me.getButton() == MouseEvent.BUTTON1){
				    /* beim ersten klick werden die Startwerte gesetzt, beim
				     *zweiten die endwerte*/
				    switch(zaehler){
					case 0:
					    startX = me.getX();
					    startY = me.getY();
					    zaehler = 1;
					    break;
					case 1:
					    endX = me.getX();
					    endY = me.getY();
					    zaehler = 0;

					    /* mit den so gewonnenen werten wird dann die linie gezeichnet
					    und der leyeredPane geadded */

					    zeichneLinie zeichneLinie = new zeichneLinie(startX, startY, endX, endY);
					    layeredPane.add(zeichneLinie, new Integer(7));
					    startX = startY = endX = endY = 0;
					    break;
				    }// switch(zaehler)
				}// if()
			    }// if()
			}// mouseReleased(MouseEvent me)
		}// MouseAdapter
		);// addMouseListener()


		// dieser MouseListener sorgt dafür, dass die Pfeile im Hauptfenster gezeichnet werden können
		hauptFensterUI.layeredPane.addMouseListener(new MouseAdapter(){
			private int startX = 0;
			private int endX = 0;
			private int startY = 0;
			private int endY = 0;
			private int zaehler; // legt die koordinaten für start- und endpunkte fest


			public void mouseReleased(MouseEvent me) {
			    // wenn der ToggleButton in der Toolbar aktiviert ist...
			    if(toolBar.pfeilGewaehlt()){
				// ...reagiert erst der MouseListener auf den Linksklick
				if(me.getButton() == MouseEvent.BUTTON1){
				    /* beim ersten klick werden die Startwerte gesetzt, beim
				     *zweiten die endwerte*/
				    switch(zaehler){
					case 0:
					    startX = me.getX();
					    startY = me.getY();
					    zaehler = 1;
					    break;
					case 1:
					    endX = me.getX();
					    endY = me.getY();
					    zaehler = 0;

					    /* mit den so gewonnenen werten wird dann die linie gezeichnet
					    und der leyeredPane geadded */

					    zeichnePfeil zeichnePfeil = new zeichnePfeil(startX, startY, endX, endY);
					    layeredPane.add(zeichnePfeil, new Integer(6));
					    break;
				    }// switch(zaehler)
				}// if()
			    }// if()
			}// mouseReleased(MouseEvent me)
		}// MouseAdapter
		);// addMouseListener()


		// Klasse zur dynamischen Größenbestimmung des Frames
		hauptFensterUI.mainPane.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent event){
			if(event.getID() == ComponentEvent.COMPONENT_RESIZED){
				JLayeredPane layeredPane = (JLayeredPane) event.getComponent();
				d = layeredPane.getSize();
				zeichneRaster.setGroesse(d.width, d.height);
				hauptFensterUI.setGroesse(d.width, d.height);
				koordSys.setGroesse(d.width,d.height);
				toolBar.setBreite(d.width);
				System.out.println(d);
			} // if
		   } // componentResized()
		} // addComponentListener()
		);

	} // pack()


	public static void main(String args[]){
		hauptFensterUI wedabecha = new hauptFensterUI();
	} // main(String args[])

} // hauptFensterUI