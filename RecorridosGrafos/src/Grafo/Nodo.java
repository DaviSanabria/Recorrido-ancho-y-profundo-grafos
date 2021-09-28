/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.awt.Graphics;

/**
 *
 * @author David
 */
public class Nodo {
    private int x=0, y=0;
    private String valor;
    
    public Nodo(int x,int y,String valor){
        setX(x);
        setY(y);
        setValor(valor);
        
    }
    
    public void pintar(Graphics g){
        //dibuja texto(texto,texto,x,y)
        g.drawString(getValor(), getX(), getY());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getValor() {
        return valor;
    }
    
    
}
