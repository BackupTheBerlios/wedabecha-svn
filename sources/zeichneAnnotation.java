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
import java.lang.Math;

public class zeichneAnnotation extends JComponent{

}// zeichneAnnotation


class zeichneLinie extends JComponent{
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    
    public zeichneLinie(int startXP, int startYP, int endXP, int endYP){
	startX = startXP;
	startY = startYP;
	endX = endXP;
	endY = endYP;
	this.setSize(700, 500);
    }// zeichneLinie()
    
    
    public void paintComponent(Graphics linie){
	    linie.drawLine(startX, startY, endX, endY);
    }// paintComponent(GGraphics linie)
}// zeichneLinie


class zeichnePfeil extends JComponent{
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int spitze1X; // X-Koordinate Pfeilspitze oben
    private int spitze1Y; // Y-Koordinate Pfeilspitze oben
    private int spitze2X; // X-Koordinate Pfeilspitze unten
    private int spitze2Y; // Y-Koordinate Pfeilspitze unten
    private double winkel; // Winkel der Linie zur X-Achse
    
    public zeichnePfeil(int startXP, int startYP, int endXP, int endYP){
	startX = startXP;
	startY = startYP;
	endX = endXP;
	endY = endYP;
	this.setSize(700, 500);
    }// zeichneLinie()
    
    
    public void paintComponent(Graphics pfeil){
	// Berechnung der Koordinaten für die Pfeilspitze
	winkel = Math.toDegrees(Math.tan((endY-startY)/(endX-startX)));
	spitze1X = (int)Math.sqrt((Math.pow(20,2))/(2*Math.pow( (Math.tan(20)+winkel),2 )))+endX;
	spitze1Y = (int)(endY+((spitze1X-endX)*Math.tan(winkel+20)));
	spitze2X = (int)Math.sqrt((Math.pow(20,2))/(2*Math.pow((Math.tan(-20)+winkel),2)))+endX;
	spitze2Y = (int)(endY+((spitze1X-endX)*Math.tan(winkel-20)));
	System.out.println(startX+" "+startY+" "+endX+" "+endY);
	System.out.println(winkel);
	pfeil.drawLine(startX, startY, endX, endY);
	pfeil.drawLine(spitze1X, spitze1Y, endX, endY);
	pfeil.drawLine(spitze2X, spitze2Y, endX, endY);	
    }// paintComponent(Graphics pfeil)
}// zeichnePfeil


class zeichneText extends JComponent{
    private int startX;
    private int startY;
    private String text;
    
    
    public zeichneText(String textP, int startXP, int startYP){
	text = textP;
	startX = startXP;
	startY = startYP;
	this.setSize(700, 500);
    }// zeichneText()
    
    
    public void paintComponent(Graphics text){
	    text.drawString(this.text, this.startX, this.startY);
    }// paintComponent(Graphics text)    
}// zeichneText