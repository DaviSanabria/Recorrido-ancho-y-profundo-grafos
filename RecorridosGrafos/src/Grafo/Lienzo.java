/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafo;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Lienzo extends JPanel implements MouseListener{
    private int numero=1;
    ArrayList<Nodo> listaNodos=null;
    ArrayList<Arista> listaAristas=null;
    
    public Lienzo(){
        setListaNodos(new ArrayList<>());
        setListaAristas(new ArrayList<>());
        addMouseListener(this);
    } 
    
    public void paint(Graphics g){
        super.paint(g);
        for(Nodo objNodo : getListaNodos()){
            objNodo.pintar(g);
        }
        for(Arista objArista : getListaAristas()){
            objArista.pintar(g);
        }
    }
    public ArrayList<Nodo> getListaNodos() {
        return listaNodos;
    }

    public void setListaNodos(ArrayList<Nodo> listaNodos) {
        this.listaNodos = listaNodos;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Arista> getListaAristas() {
        return listaAristas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setListaAristas(ArrayList<Arista> listaAristas) {
        this.listaAristas = listaAristas;
    }
    
    
    public void Limpiar(){
        this.listaNodos.clear();
        this.listaAristas.clear();
        this.numero= 1;
        repaint();
        
    }
    public void Repintar(){
        repaint();      
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton() == 1 && this.numero<= 9){
            String n = String.valueOf(this.numero);
            getListaNodos().add(new Nodo(me.getX(), me.getY(),n));
            this.numero = this.numero + 1; 
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
