/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Recorridos extends JPanel{
    int cantidad;
    ArrayList<Arbol> ListaArboles;
    
    public Recorridos(){
        ListaArboles = new ArrayList<>();
        cantidad = 0; 
    }
    public Recorridos(int cant){
        ListaArboles = new ArrayList<>();
        cantidad = cant; 
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void limpiar(){
        if(ListaArboles != null){
            for(int i=0;i<ListaArboles.size();i++){
                ListaArboles.get(i).Limpiar();
            }
        }
        removeAll();
        updateUI();
    }
    
    
    
}
