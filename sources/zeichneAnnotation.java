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

public class zeichneAnnotation extends JComponent{

}// zeichneAnnotation


class zeichneLinie extends JComponent{
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;
    
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

/*
class zeichnePfeil extends JComponent{
    public void paintComponent(Graphics pfeil){
	    pfeil.drawLine(startx,starty,endx,endy);
	    
    }// paintComponent(Graphics pfeil)
}// zeichnePfeil
*/

class zeichneText extends JComponent{
    private static int startX;
    private static int startY;
    private static String text;
    
    
    public zeichneText(String textP, int startXP, int startYP){
	text = textP;
	startX = startXP;
	startY = startYP;
	this.setSize(text.length(), 14);
    }// zeichneText()
    
    
    public void paintComponent(Graphics text){
	    text.drawString(this.text, this.startX,this.startY);
    }// paintComponent(Graphics text)    
}// zeichneText