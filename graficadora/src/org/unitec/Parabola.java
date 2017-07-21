/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author T-
 */
public class Parabola extends Canvas{
    
    public static float a;
    public static float b;
    public static float c;

    @Override
    public void paint(Graphics g) {
           //Dibujamos un cuadro blanco y ocupara todo el panel de gráfica
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //Agregamos ejes coordenados
        g.setColor(Color.black);
        
        //Eje x
        g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        
        //Eje y
        g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        
        //Movemos el punto de origen
        g.translate(getWidth()/2, getHeight()/2);
        
        float x0 = -getWidth();
        float y0;
    } 
}
