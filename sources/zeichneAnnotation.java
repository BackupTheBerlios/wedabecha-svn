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
    
    protected void setGroesse(int breite, int hoehe){
	this.setSize(breite, hoehe);
    }//setGroesse()
	
	
    public void paintComponent(Graphics linie){
	    linie.drawLine(startX, startY, endX, endY);
    }// paintComponent(GGraphics linie)
}// zeichneLinie


class zeichnePfeil extends JComponent{
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Point st;
    private Point end;
    
    
    public zeichnePfeil(int startXP, int startYP, int endXP, int endYP){
	startX = startXP;
	startY = startYP;
	endX = endXP;
	endY = endYP;
	this.setSize(700, 500);
    }// zeichnePfeil()
        
    
    /*Algorithmus zum zeichnen des Pfeils zum größten teil aus dem Buch 
     "Profesional Java Fundamentals" entnommen */
    public void paintComponent(Graphics pfeil){
	st = new Point(startX, startY);
	end = new Point(endX, endY);
	Point upLine = new Point(0,0);
	Point downLine = new Point(0,0);
	int direction ;
	double theta;
	    if((end.y -st.y) >= 0) direction = -1;
		else direction = 1;

        // Rotate the point by 30 deg

        double angle = Math.atan((double)(end.x-st.x)/(double)(end.y-st.y));
        int len = 10;
        Point rel = new Point(len, len);

        angle += Math.PI/2;
        theta = -(angle + Math.PI/6);
        //Rotate the line up

        upLine.x =end.x -(int)( len* Math.cos(theta)*direction);
        upLine.y =end.y -(int)( len* Math.sin(theta)*direction);
        // Rotate the line down

        theta = -(angle - Math.PI/6);
        downLine.x =end.x -(int)( len* Math.cos(theta)*direction);
        downLine.y =end.y -(int)( len* Math.sin(theta)*direction);

        // Now the draw the arrow lines
        pfeil.drawLine(end.x, end.y, upLine.x, upLine.y);
        pfeil.drawLine(end.x, end.y, downLine.x, downLine.y);
	pfeil.drawLine(st.x, st.y, end.x, end.y);
   }
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