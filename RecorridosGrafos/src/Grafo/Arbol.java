 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Arbol extends JPanel{
    private ArrayList<Nodo> listaNodos;
    private ArrayList<Arista> listaAristas;
    private NodoA raiz;
    public Arbol(){
        listaNodos= new ArrayList<>();
        listaAristas = new ArrayList<>();
        
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


    public ArrayList<Arista> getListaAristas() {
        return listaAristas;
    }


    public void setListaAristas(ArrayList<Arista> listaAristas) {
        this.listaAristas = listaAristas;
    }

    public void Limpiar(){
        this.listaNodos.clear();
        this.listaAristas.clear();
        repaint();
        
    }
    public void Repintar(){
        repaint();      
    }

    public NodoA getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoA raiz) {
        this.raiz = raiz;
    }
    
//    public NodoA buscar(NodoA nodo, Arbol a){
//        NodoA result=null; 
//        Arbol arb = a; 
//        NodoA raiz= arb.getRaiz();
//        if(nodo.getValor() == raiz.getValor()){
//            result = raiz;
//            return raiz;
//        }else{
//            if(arb.getRaiz().getHijos() != null){
//                for(int i=0; i<raiz.getHijos().size(); i++){
//                    if(result == null){
//                        arb.setRaiz(raiz.getHijos().get(i));   
//                        System.out.println(arb.raiz.getValor());
//                        buscar(nodo, arb);
//                    }
//                }
//            }
//            return result;
//        }
//    }
    
}
