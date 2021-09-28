/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Adyacencia extends JPanel{
    ArrayList<JTextField> listaAdyacencia=null;
    ArrayList<JLabel> ListaNodos= null;
    
    public Adyacencia(){
        setListaAdyacencia(new ArrayList<>());
        setListaNodos(new ArrayList<>());
    }
    
    public void Actualizar(int tam){
        Limpiar();
        setListaAdyacencia(new ArrayList<>());
        setListaNodos(new ArrayList<>());
        System.out.println(getListaAdyacencia());
        System.out.println(getListaNodos());
        for(int i=1;i<=tam;i++){
            String data = String.valueOf(i);
            getListaNodos().add(new JLabel(data+"->"));
        }
        for(int j=0;j<tam;j++){
            for(int i=0;i<tam;i++){
                getListaAdyacencia().add(new JTextField());
            }
        }
        
    }
    
    public void Posicionar(){
        int tam =getListaNodos().size();
        for(int i=0;i<tam;i++){
            int y1=(i+1)*20;
            getListaNodos().get(i).setBounds(10,y1,30,30);
            this.add(getListaNodos().get(i));
        }
    
        int y=25,x=40;
        for(int j=0;j<tam*tam;j++){
            if(j%tam==0 && j!=0){
            x = 40;
            y= y+20;
            }

            (getListaAdyacencia().get(j)).setBounds(x,y,30,20);
            x = x+32;
            this.add(getListaAdyacencia().get(j));
            
        }        
    }
    
    
    public void Limpiar(){
        if(listaAdyacencia!= null || ListaNodos!=null){
            for(int i=0;i<listaAdyacencia.size();i++){
                this.remove(listaAdyacencia.get(i));
            }
            for(int i=0;i<ListaNodos.size();i++){
                this.remove(ListaNodos.get(i));
            }
        }
        listaAdyacencia = null;
        ListaNodos = null;
    } 
   // 
    //public int validar(){
        
  //  }
//

    public ArrayList<JTextField> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public void setListaAdyacencia(ArrayList<JTextField> listaAdyacencia) {
        this.listaAdyacencia = listaAdyacencia;
    }


    public ArrayList<JLabel> getListaNodos() {
        return ListaNodos;
    }

    public void setListaNodos(ArrayList<JLabel> ListaNodos) {
        this.ListaNodos = ListaNodos;
    }
    
    
    
}
