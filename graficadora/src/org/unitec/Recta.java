package org.unitec;

import java.awt.*;

public class Recta extends Canvas{

    public static float a;
    public static float b;
    
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
        
        //Estas variables servirán para la cuadrícula
        int x = -getWidth()/2;
        int y = -getHeight()/2;
        
        //Estas variables servirán para indicar el primer punto
        float xP1 = -getWidth()/2;
        float yP1;
        
        //Estas variables servirán para indicar el segundo punto
        float xP2 = -getWidth()/2 + 1;
        float yP2;
        
        //Multiplicamos por 30 para mover la recta en 1 cm por 30 pixeles
        b *= 30;
        
        //Para graficar usamos el ciclo for
        for(int i = 0; i < getWidth(); i++){
            //Sustituyendo en el primer punto la ecuación
            yP1 = -(a * xP1 + b);
            
            //Sustituyendo el segundo punto en la ecuación
            yP2 = -(a * xP2 + b);
            
            //Dibujamos la gráfica
            g.drawLine((int)xP1, (int)yP1, (int)xP2, (int)yP2);
            
            //Incrementamos el valor de x para el punto 1 y 2
            xP1++;
            xP2++;
            
            //Nos desplazamos en el eje de X y Y para la cuadrícula
            x++;
            y++;
            
            //Se dibuja una linea e inserta número cada 30 pixeles desplazados en el eje de X
            if(x % 30 == 0 && x / 30 != 0){
                String num = String.valueOf(x/30);
                g.drawLine(x, getHeight()/2 + (-getHeight()/2) + 5, x, getHeight()/2 + (-getHeight()/2) + 5 - 10);
                g.drawString(num, x - 2, getHeight()/2 + (-getHeight()/2) + 16);
            }
            
            //Se dibuja una linea e inserta número cada 30 pixeles desplazados en el eje de Y
            if(y % 30 == 0 && y / 30 != 0){
                String num = String.valueOf(y/30);
                g.drawLine(getWidth()/2 + (-getWidth()/2) + 5, y, getWidth()/2 + (-getWidth()/2) + 5 - 10, y);
                g.drawString(num, getWidth()/2 + (-getWidth()/2) + 10 , y + 4);
            }
        }
    }
}
