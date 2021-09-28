/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class NodoA {
    private ArrayList<NodoA> hijos;
    private int valor;
    private NodoA padre;
    
    public NodoA(){
        hijos = new ArrayList<>();
        valor = 0;
        padre = null;
    }
    public NodoA(int valor, NodoA padre){
        this.hijos = new ArrayList<>();
        this.valor = valor;
        this.padre = padre;
    }
    
    public NodoA(ArrayList<NodoA> hijos,int valor, NodoA padre){
        this.hijos = hijos;
        this.valor = valor;
        this.padre = padre;
    }

    public ArrayList<NodoA> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<NodoA> hijos) {
        this.hijos = hijos;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoA getPadre() {
        return padre;
    }

    public void setPadre(NodoA padre) {
        this.padre = padre;
    }
    
}
