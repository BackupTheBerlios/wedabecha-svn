/****************************************************************************
 *   Copyright (C) 2004 by BTU SWP GROUP 04/6.1				    *
 *									    *
 *   This program is free software; you can redistribute it and/or modify   *
 *   it under the terms of the GNU General Public License as published by   *
 *   the Free Software Foundation; either version 2 of the License, or	    *
 *   (at your option) any later version.				    *
 *									    *
 *   This program is distributed in the hope that it will be useful,	    *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of	    *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the	    *
 *   GNU General Public License for more details.			    *
 *									    *
 *   You should have received a copy of the GNU General Public License	    *
 *   along with this program; if not, write to the			    *
 *   Free Software Foundation, Inc.,					    *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.		    *
 ***************************************************************************/

// hier brauchen wir alle Imports für die GUI,
// dies ist das Hauptfenster.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class hauptFensterUI extends JFrame{
	static JFrame hauptFenster = new JFrame("wedabecha");
	private static kontextMenuUI popupMenu = new kontextMenuUI();
	private JPanel mainPanel = new JPanel();
	private JLayeredPane layeredPane;
	private zeichneRaster zeichneRaster = new zeichneRaster();
	Dimension d;
	
	private int fensterBreite;
	private int fensterHoehe;
	
	// konstruktor
	public hauptFensterUI(){
	    this.fensterBreite = 700;
	    this.fensterHoehe = 500;
	    this.zeichneRaster.setBreite(this.fensterBreite);
	    this.zeichneRaster.setHoehe(this.fensterHoehe);
	    this.pack();
		
	} // hauptFensterUI()


	public void pack(){
		/**
		pack() setzt das Fenster als Ganzes aus den einzelnen
		Bestandteilen zusammen
		*/
		hauptMenuUI hauptMenu = new hauptMenuUI(); // Hauptmenu initialisieren
		this.hauptFenster.setJMenuBar(hauptMenu.getHauptMenu()); // Hauptmenu in das Fenster einbinden
		
		toolBarUI toolBar = new toolBarUI();
		this.hauptFenster.getContentPane().add(toolBar.getToolBar(), BorderLayout.NORTH); // Werkzeugleiste einbinden
		//this.hauptFenster.getContentPane().add(this.mainPanel, BorderLayout.CENTER);
		
		// Listener zum Fensterschliessen per "wegkreuzen"
		this.hauptFenster.addWindowListener(new beendenListener());

		int bildSchirmBreite = getToolkit().getScreenSize().width;
		int bildSchirmHoehe = getToolkit().getScreenSize().height;
		int Xposition = (bildSchirmBreite - this.fensterBreite) / 2;
		int Yposition = (bildSchirmHoehe - this.fensterHoehe) / 2;
		this.hauptFenster.setSize(this.fensterBreite,this.fensterHoehe);
		
		this.hauptFenster.getContentPane().add(zeichneRaster, BorderLayout.CENTER);
		
		this.hauptFenster.setLocation(Xposition,Yposition);
		this.hauptFenster.setResizable(true);
		this.hauptFenster.setVisible(true);

		final kontextMenuUI kontext = new kontextMenuUI();
		
		this.hauptFenster.getContentPane().add(kontext.getKontextMenu());
		
		this.hauptFenster.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me ) {
				//if ( me.isPopupTrigger() ) {
					kontext.getKontextMenu().show( hauptFenster, me.getX(), me.getY() );
				//} // if()
			} // mouseReleased(MouseEvent me)
		} ); // addMouseListener()
		
		/*Klasse zur dynamischen Größenbestimmung des Frames*/
		this.hauptFenster.addComponentListener(new ComponentAdapter(){
		    public void componentResized(ComponentEvent event){
			if(event.getID() == ComponentEvent.COMPONENT_RESIZED){
			    JFrame hauptFenster = (JFrame) event.getComponent();
			    d = hauptFenster.getSize();
			    zeichneRaster.setBreite(d.width);
			    zeichneRaster.setHoehe(d.height);
			    zeichneRaster.repaint();
			    System.out.println(d);
			}//if
		   }//componentResized()
		}//addComponentListener()
		);
		
	} // pack()
	
	public static void main(String args[]){
		hauptFensterUI wedabecha = new hauptFensterUI();
	} // main(String args[])
	
} // hauptFensterUI