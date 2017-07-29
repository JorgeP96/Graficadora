package org.unitec;

import java.awt.*;

public class Parabola extends Canvas{
    
    public static float a;
    public static float b;
    public static float c;
    
    @Override
    public void paint(Graphics g) {
        //Cambiamos color
        g.setColor(Color.white);
        
        //Dibujamos un cuadro blanco y ocupara todo el panel de gráfica
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
        a *= 30;
        b *= 30;
        c *= 30;
            
        //Graficamos la cuadricula y la recta
        for(int i = 0; i < getWidth(); i++){
            //Nos desplazamos en el eje de X y Y para la cuadrícula
            x++;
            y++;
            
            //Dibujamos la cuadrícula cada 30 px excepto cuando pasa por el eje de las Y
            if(x % 30 == 0 && x / 30 != 0){
                //Se divide el getwidth / 30 para obtener el número de línea vertical
                String num = String.valueOf(x/30);
                
                //Cambiamos color
                g.setColor(Color.lightGray);
                
                //Dibujamos línea vertical desde abajo hasta arriba
                g.drawLine(x, getHeight()/2, x, -getHeight()/2);
                
                //Cambiamos color
                g.setColor(Color.black);
                
                //Dibujamos las pequeñas líneas sobre eje de X con ancho de 10 px
                g.drawLine(x, getHeight()/2 + (-getHeight()/2) + 5, x, getHeight()/2 + (-getHeight()/2) + 5 - 10);
                
                //Dibujamos número de las pequeñas líneas sobre el eje de X
                g.drawString(num, x - 2, getHeight()/2 + (-getHeight()/2) + 16);
            }
            
            //Dibujamos la cuadrícula cada 30 px excepto cuando pasa por el eje de las X
            if(y % 30 == 0 && y / 30 != 0){
                //Se divide el getwidth / 30 para obtener el número de línea horizontal
                String num = String.valueOf(-y/30);
                
                //Cambiamos color
                g.setColor(Color.lightGray);
                
                ///Dibujamos línea horizontal desde la derecha hasta la izquierda
                g.drawLine(getWidth()/2, y, -getWidth()/2, y);
                
                //Cambiamos color
                g.setColor(Color.black);
                
                //Dibujamos las pequeñas líneas sobre eje de Y con ancho de 10 px
                g.drawLine(getWidth()/2 + (-getWidth()/2) + 5, y, getWidth()/2 + (-getWidth()/2) + 5 - 10, y);
                
                //Dibujamos número de las pequeñas líneas sobre el eje de Y
                g.drawString(num, getWidth()/2 + (-getWidth()/2) + 10 , y + 4);
            }
            
            //Se hace la gráfica si alguno de los valores es diferente de 0
            if(a != 0 || b != 0 || c != 0){
                //Sustituyendo en el primer punto la ecuación
                yP1 = -((a * (float)Math.pow(xP1, 2)/30)/30 + (b * xP1)/30 + c);

                //Sustituyendo el segundo punto en la ecuación
                yP2 = -((a * (float)Math.pow(xP2, 2)/30)/30 + (b * xP2)/30 + c);
                
                //Cambiamos color
                g.setColor(Color.red);
                
                //Dibujamos la gráfica
                g.drawLine((int)xP1, (int)yP1, (int)xP2, (int)yP2);

                //Incrementamos el valor de x para el punto 1 y 2
                xP1++;
                xP2++;
            }
        }
    } 
}
