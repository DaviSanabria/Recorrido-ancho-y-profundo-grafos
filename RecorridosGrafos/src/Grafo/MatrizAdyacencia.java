/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author David
 */
public class MatrizAdyacencia {
    int[][] matriz;
    
    public MatrizAdyacencia(int tam){
        matriz = new int[tam][tam];
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    
    public int[][] getMatriz() {
        return matriz;
    }
    

}
