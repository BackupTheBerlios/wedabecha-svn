/****************************************************************************
 *   Copyright (C) 2004 by BTU SWP GROUP 04/6.1 - Matthias Tylkowski        *
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


/*
	Diese Klasse dient zur Darstellung der Dokumentation, Kurzanleitung und der
 	Hilfe. je nach bergebenen Werten wird der gewnschte Text in der TexrArea
 	dargestellt
*/


import javax.swing.*; //brauche ich um die Swing Objekte darzustellen
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.*;
import java.awt.*; //wird fuer das Layout benoetigt
import java.awt.event.*;
import java.io.*; //wird benoeigt um die textdateien einzulesen
import java.io.File.*;
import java.net.URI;
import java.net.URL;

public class dokuUI extends JFrame {
    private JEditorPane doku = new JEditorPane();
    private JButton schliessenButton;
    private String text;
    File path;

    public dokuUI(String title) {
		/*
			der konstruktor soll noch zwei parameter erhalten (siehe
			HauptMenuListener) die parameter sind vom Typ String und
			können folgende Werte enthalten: "Kurzanleitung" und "Dokumentation"
		*/

		setTitle(title);
		if(title.equals("Kurzanleitung")){
		    path = new File("../dokumentation/html/hilfe/anleitung.html");
		}else if(title.equals("Dokumentation")){
		    path = new File("../dokumentation/html/hilfe/anleitung.html");
		}// else if()
		
		try {
		    doku.setContentType("text/html");
		    doku.setEditable(false);
	    
		    URL url = path.toURI().toURL();
		    doku.setPage(url);
	    	    
		    
		    /*Der HyperlinkListener dient, wie der Name schon sagt, dazu, die html-Links
		     *in der geladenen Seite anzusteuern.*/
		    
		    doku.addHyperlinkListener(new HyperlinkListener(){
			public void hyperlinkUpdate( HyperlinkEvent event ){
			    HyperlinkEvent.EventType typ = event.getEventType();
			    if ( typ == HyperlinkEvent.EventType.ACTIVATED ){
			        try{
				    setTitle( ""+event.getURL() );
				    doku.setPage( event.getURL() );
				} catch( IOException e ) {
				    JOptionPane.showMessageDialog( null,
						    "Can't follow link to "
						    + event.getURL().toExternalForm(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}// try-catch()
			    }// if()
			}// hyperlinkUpdate()
		    }// HyperlinkListener()
		    );// addHyperlinkListener

	    	    
		 } catch (IOException except){
		     // fehlermeldung falls datei nicht gelesen werden kann
		    JOptionPane.showMessageDialog(null,
			"Die Datei, welche die Kurzanleitung enthaelt, konnte nicht gelesen werden.","Dateifehler",
			JOptionPane.ERROR_MESSAGE );
		 } // try-catch()
	
		this.pack();
	} // dokuUI();


	public void pack() {
		getContentPane().setLayout(new BorderLayout(5,5));

		JPanel gridLayoutPanel = new JPanel();
		getContentPane().add((gridLayoutPanel),BorderLayout.CENTER);
		gridLayoutPanel.setLayout(new GridLayout(1,1));

		gridLayoutPanel.add(doku);
		gridLayoutPanel.add(new JScrollPane(doku));

		JPanel flowLayoutPanel = new JPanel();
		getContentPane().add((flowLayoutPanel),BorderLayout.SOUTH);
		flowLayoutPanel.setLayout(new FlowLayout());

		schliessenButton = new JButton("Schliessen");
		flowLayoutPanel.add(schliessenButton);

		this.schliessenButton.addActionListener(new schliessenListener());

		setSize(600, 400);
		setLocation((getToolkit().getScreenSize().width-600) / 2,
					(getToolkit().getScreenSize().height-400) / 2);
		setResizable(true);
		setVisible(true);
	} // pack()


	class schliessenListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			setVisible(false);
		} // actionPerformed(ActionEvent event)

		public void windowClosing(WindowEvent event){
			setVisible(false);
		} // windowClosing(WindowEvent event)
	} // schliessenListener

} // dokuUI