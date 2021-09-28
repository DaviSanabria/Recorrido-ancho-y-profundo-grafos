/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author David
 */
public class Arista {
    private int x1,y1,x2,y2,n1,n2;

    public Arista(int x1, int y1,int x2,int y2, int n1, int n2){
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setN1(n1);
        setN2(n2);
    }
    
     public void pintar(Graphics g){
        //dibuja texto(texto,texto,x,y)
        g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);
    }
    
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
    
    
}
