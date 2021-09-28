/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author David
 */
public class Graficar extends JFrame implements ActionListener{
    
    JLabel lblTitulo;
    JLabel lblMaxNodos;
    JLabel lblError;
    JButton btnBorrar,btnAdyacencia,btnRecorridos;
    JTextArea textArea;
    Adyacencia  pnlAdyacencia;
    Lienzo objLienzo;
    JPanel panel;
    Recorridos  pnlAncho,pnlProfundidad;
    JScrollPane scroll,scrAncho,scrProfundidad;
    MatrizAdyacencia matriz;
    
    public Graficar(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setTitle("RECORRIDOS DE GRAFOS");
        //setLayout(null);
        
        
        setLocationRelativeTo(null);
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        
        scroll = new JScrollPane();
        scroll.setBounds(40, 40, 1000, 1000);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        
        scrAncho = new JScrollPane();
        scrAncho.setBounds(10, 360, 460, 550);
        scrAncho.getVerticalScrollBar().setUnitIncrement(16);
        
        scrProfundidad = new JScrollPane();
        scrProfundidad.setBounds(490, 360, 460, 550);
        scrProfundidad.getVerticalScrollBar().setUnitIncrement(16);
        
        

        
        lblTitulo = new JLabel("Recorrido de grafos");
        lblTitulo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN,23));
        lblTitulo.setBounds(10, 14, 221, 51);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(10,76,89,23);
        btnBorrar.addActionListener(this);
        
        btnAdyacencia = new JButton("Lista Adyacencia");
        btnAdyacencia.setBounds(109,76,150,23);
        btnAdyacencia.addActionListener(this);
        
        btnRecorridos = new JButton("Dibujar");
        btnRecorridos.setBounds(280,76,80,23);
        btnRecorridos.addActionListener(this);
        
        objLienzo = new Lienzo();
        objLienzo.setBounds(10, 117, 370, 181);
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Lienzo") ;
        objLienzo.setBorder(bordejpanel);
        
        pnlAdyacencia = new Adyacencia();
        pnlAdyacencia.setBounds(400, 34, 550, 300);
        pnlAdyacencia.setLayout(null);
        Border bordejpanel2 = new TitledBorder(new EtchedBorder(), "Lista de adyacencia");
        pnlAdyacencia.setBorder(bordejpanel2);
        
        
        pnlAncho = new Recorridos();
        pnlAncho.setLayout(null);
        Border bordejpanel3 = new TitledBorder(new EtchedBorder(), "Recorrido a lo ancho");
        pnlAncho.setBorder(bordejpanel3);
        
        pnlProfundidad = new Recorridos();
        pnlProfundidad.setLayout(null);
        Border bordejpanel4 = new TitledBorder(new EtchedBorder(), "Recorrido a profundidad");
        pnlProfundidad.setBorder(bordejpanel4);
        
        
        lblMaxNodos = new JLabel("Puede insertar maximo 9 nodos");
        lblMaxNodos.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN,11));
        lblMaxNodos.setBounds(10, 300, 200, 20);
        
        lblError = new JLabel("Error:");
        lblError.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN,11));
        lblError.setForeground(Color.RED);
        lblError.setBounds(10, 320, 300, 40);
        lblError.setVisible(false);
        
        
        panel.setPreferredSize(new Dimension(960, 940));
        pnlAncho.setPreferredSize(new Dimension(440, 500));
        pnlProfundidad.setPreferredSize(new Dimension(440, 500));
        
        
        scroll.setViewportView(panel);
        scrAncho.setViewportView(pnlAncho);
        scrProfundidad.setViewportView(pnlProfundidad);
        
        
        
        panel.add(lblError);
        panel.add(lblMaxNodos);
        panel.add(lblTitulo);
        panel.add(btnBorrar);
        panel.add(btnAdyacencia);
        panel.add(btnRecorridos);
        panel.add(objLienzo);
        panel.add(pnlAdyacencia);
        panel.add(scrProfundidad);
        panel.add(scrAncho);
        add(scroll);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnBorrar){
            objLienzo.Limpiar();
            pnlAdyacencia.Limpiar();
            pnlAdyacencia.updateUI();
            pnlAncho.limpiar();
            pnlProfundidad.limpiar();
            
        }
        if(e.getSource()== btnAdyacencia){
            int tam = objLienzo.getListaNodos().size();
            if(tam>1){
                pnlAdyacencia.Actualizar(tam);
                pnlAdyacencia.updateUI();
                pnlAdyacencia.Posicionar();
                pnlAdyacencia.updateUI();
                lblError.setVisible(false);
            }else{
                lblError.setText("Error: debe ingresar más de un nodo");
                lblError.setVisible(true);
            }
                
        }
        if(e.getSource()==btnRecorridos){
            if(Dibujar())
                DibujarRecorridos();
        }
    }
    
    public void DibujarRecorridos(){
        
        int tam = objLienzo.getListaNodos().size();
        
        matriz= new MatrizAdyacencia(tam);
        System.out.println("Matriz"); 
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                System.out.print((matriz.getMatriz())[i][j]);
            }
            System.out.println("");
        }
        //actualiza matriz
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                for(int y=0; y<objLienzo.getListaAristas().size(); y++){
                    int n1 = objLienzo.getListaAristas().get(y).getN1();
                    int n2 = objLienzo.getListaAristas().get(y).getN2();
                    if((i+1==n1 && j+1==n2)||(j+1==n1 && i+1==n2)){
                        matriz.getMatriz()[i][j] = 1;
                    }
                    
                }
            }
        }
        System.out.println(" ");
        
        System.out.println("Matriz Actualizada"); 
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                System.out.print((matriz.getMatriz())[i][j]);
            }
            System.out.println("");
        }
        
        //declara cuantos Jpanel de arbol toca crear
        int x=10;
        int y=50;
        
        pnlAncho.limpiar();
        
        for(int cant=0;cant<objLienzo.getListaNodos().size(); cant++){
            Arbol aA = RecAncho(matriz,cant+1);
            JLabel titulo = new JLabel("Recorrido ancho. Origen"+(cant+1));
            titulo.setBounds(10, y-20, 200, 20);
            aA.setBounds(x, y, 150, 150);
            pnlAncho.add(titulo);
            pnlAncho.add(aA);
            y = y + 200; 
            //pnlAncho.ListaArboles.add(e);
        }
        x=10;
        y=50;
        // crea paneles de recorridos a profundidad
        pnlProfundidad.limpiar();
        for(int cant=0;cant<objLienzo.getListaNodos().size(); cant++){
            Arbol aP = RecProfundo(matriz,cant+1);
            JLabel titulo = new JLabel("Recorrido profundo. Origen"+(cant+1));
            titulo.setBounds(10, y-20, 200, 20);
            aP.setBounds(x, y, 150, 150);
            pnlProfundidad.add(titulo);
            pnlProfundidad.add(aP);
            y = y + 200; 
            //pnlAncho.ListaArboles.add(e);
        }
        
        
        pnlAncho.setPreferredSize(new Dimension(440, y));
        scrAncho.updateUI();
        pnlProfundidad.setPreferredSize(new Dimension(440, y));
        scrProfundidad.updateUI();
    
    }
    public Arbol RecProfundo(MatrizAdyacencia matriz, int origen){
        Arbol arbolProf = new Arbol();
        Arbol arbolProf01 = new Arbol();
        arbolProf.getListaNodos().add(new Nodo(10,10,"0"));
        arbolProf.getListaAristas().add(new Arista(12, 10, 12, 20, 0, origen));
        arbolProf.getListaNodos().add(new Nodo(10,30,Integer.toString(origen)));
        ArrayList<Integer> nodosVistos = new ArrayList<>();
      
        arbolProf01.setRaiz(new NodoA(origen, null));
        nodosVistos.add(origen);
        int[][] matrizTemp = matriz.getMatriz();
        arbolProf01 = llenarArbolProfundo(matrizTemp, nodosVistos, arbolProf01);
            
        arbolProf.setRaiz(arbolProf01.getRaiz());
        System.out.println("++++++++++ Profundo Raiz es:"+arbolProf.getRaiz().getValor());
        int x=10,y=30;
        posicionarHijosProf(arbolProf,x,y, new ArrayList<>());
        //for(int i=0;i <temporal[1].length;i++){
        //    if(i=)
        //}
        return arbolProf;
    }
    
    public Arbol RecAncho(MatrizAdyacencia matriz, int origen){
        ArrayList<Integer> nodosVistos = new ArrayList<>();
        Arbol arbolExpand01 = new Arbol();
        Arbol arbolExpand = new Arbol();
        arbolExpand.getListaNodos().add(new Nodo(10,10,"0"));
        arbolExpand.getListaAristas().add(new Arista(12, 10, 12, 20, 0, origen));
        arbolExpand.getListaNodos().add(new Nodo(10,30,Integer.toString(origen)));
        arbolExpand01.setRaiz(new NodoA(origen, null));
        nodosVistos.add(origen);
        int[][] matrizTemp = matriz.getMatriz();
        arbolExpand01 = llenarArbolAnchura(matrizTemp, nodosVistos, arbolExpand01);
            
        arbolExpand.setRaiz(arbolExpand01.getRaiz());
        int x=10,y=30;
        System.out.println("++++++++++ Ancho Raiz es:"+arbolExpand.getRaiz().getValor());
        posicionarHijosProf(arbolExpand,x,y,new ArrayList<>());
        
        //for(int i=0;i <temporal[1].length;i++){
//            for(int in=0;in <temporal[origen-1].length;in++){
//                if(matrizTemp[origen-1][in]==1){
//                   hijos.add(in);
//                }
//            }
//        //}
//        int x1=10;
//        for(int i=0;i<hijos.size();i++){
//            if (i==0){
//                arbolExpand.getListaAristas().add(new Arista(x1+2, 30, x1+2, 40, origen, hijos.get(i)));
//                arbolExpand.getListaNodos().add(new Nodo(x1,50,Integer.toString(hijos.get(i)+1)));
//            }else{
//                arbolExpand.getListaAristas().add(new Arista(x1+5, 45, x1+10, 45, hijos.get(i-1), hijos.get(i)));
//                arbolExpand.getListaNodos().add(new Nodo(x1+20,50,Integer.toString(hijos.get(i)+1)));
//                x1=x1+10;
//            }
//        }
        //arbolExpand.getListaAristas().add(new Arista(12, 40, 12, 50, origen, ma));
        
        
        return arbolExpand;
    }
    // posicionar en el arbol
    public void posicionarHijos(Arbol arb,int x, int y){
        Arbol tempA= arb;
        NodoA temp = arb.getRaiz();
        int cantHijos;
        
        //Nodo impreso
        Nodo tempN = new Nodo(x,y,String.valueOf(temp.getValor()));
        arb.getListaNodos().add(tempN);
        
        int xa=x;
        int ya=y;
        cantHijos= temp.getHijos().size();
        for(int arist = 0; arist<cantHijos; arist++){
            Arista a = new Arista(x, ya, xa, ya+15, temp.getValor(), 0);
            xa= xa+20;
            arb.getListaAristas().add(a);
        }

        for(int s=0; s<temp.getHijos().size();s++){
                tempA.setRaiz(temp.getHijos().get(s));
                posicionarHijos(tempA,x,y+25);
                x=x+20;
        }
    }
    
     public void posicionarHijosProf(Arbol arb,int x, int y, ArrayList<NodoA> nodosGraf){
        //arbol temporal, nodo temporal
        Arbol tempA= arb;
        NodoA temp = arb.getRaiz();
        
         System.out.println("---");
        System.out.println("Raiz"+arb.getRaiz().getValor());
        if(PasadoA(nodosGraf, arb.getRaiz()) == false){
             Nodo tempN = new Nodo(x,y,String.valueOf(temp.getValor()));
            arb.getListaNodos().add(tempN);
            nodosGraf.add(temp);           
        }
        
        if(arb.getRaiz().getPadre() != null){
            System.out.println("padre:"+arb.getRaiz().getPadre().getValor());
        }else{
            System.out.println("No tiene padre");
        }
        
        
        //Tomar raiz y coloarla
        
        System.out.println("cant hijos:"+arb.getRaiz().getHijos().size());
         System.out.println("---");
        //si tiene hijo
        if(arb.getRaiz().getHijos() != null && arb.getRaiz().getHijos().size() > 0){
            if(PasadoA(nodosGraf, arb.getRaiz().getHijos().get(0)) == false){
                Arista a = new Arista(x+2, y, x+2, y+20, 0, 0);
                arb.getListaAristas().add(a);
                arb.setRaiz(arb.getRaiz().getHijos().get(0));
                posicionarHijosProf(arb, x, y+30, nodosGraf);
            }
            
        } 
        //si tiene hermano
        if(arb.getRaiz().getPadre() != null){
            if(arb.getRaiz().getPadre().getHijos().size() > 1){
                int x1=x;
                int v=0;
                for(int i=0; i<arb.getRaiz().getPadre().getHijos().size(); i++){
                    if(arb.getRaiz().getValor() == arb.getRaiz().getPadre().getHijos().get(i).getValor()){
                        System.out.println("Nodo:"+arb.getRaiz().getPadre().getHijos().get(i).getValor()+"/Posicion:"+i);
                        v=i+1;
                        i = arb.getRaiz().getPadre().getHijos().size();
                    }
                }
                for(int u= 0;u<arb.getListaNodos().size(); u++){
                    if(arb.getRaiz().getPadre().getHijos().get(v-1).getValor() == Integer.valueOf(arb.getListaNodos().get(u).getValor())){
                        x1 = arb.getListaNodos().get(u).getX();
                    }
                }
                
                //System.out.println("Nodos pasados:"+nodosyapasados(nodosGraf));
                //System.out.println("Nodo actual:"+arb.getRaiz().getPadre().getHijos().get(v).getValor());
                if(v<arb.getRaiz().getPadre().getHijos().size()){
                    if(PasadoA(nodosGraf, arb.getRaiz().getPadre().getHijos().get(v)) == false){
                        Arista a = new Arista(x1+6, y-3, x+18, y-3, 0, 0);
                        arb.getListaAristas().add(a);
                        arb.setRaiz(arb.getRaiz().getPadre().getHijos().get(v));
                        posicionarHijosProf(arb, x+20, y, nodosGraf);
                    }
                }
                
                
            }
            //devuelve a padre si no encuentra hermano
            if(arb.getRaiz().getPadre() != null){
                y = y-30;
                arb.setRaiz(arb.getRaiz().getPadre());
                posicionarHijosProf(arb, x, y, nodosGraf);
            }
            
        }
        
        
        
     }
    public String nodosyapasados(ArrayList<NodoA> nodos){
        String s = "";
        if(nodos != null){
            for(int i=0; i< nodos.size(); i++){
                s= s +","+String.valueOf(nodos.get(i).getValor());
                }
   
            }   
        return s;
        
    } 
    
    public boolean PasadoA(ArrayList<NodoA> nodos, NodoA n){
        if(nodos != null){
            for(int i=0; i< nodos.size(); i++){
                if(n.getValor() == nodos.get(i).getValor()){
                    return true;
                }
            }   
        }
        
        return false;
    }
     
    // correcto llenado anchura
    public Arbol llenarArbolAnchura( int[][] m,ArrayList<Integer> nodosListos, Arbol a){
        ArrayList<Integer> nodosPasados = nodosListos;
        a.getRaiz();
        Arbol temp = new Arbol();
        
        
        for(int i=0; i<m.length;i++){
            //si la posicion x,y dde la matriz
           // System.out.println("nodoAEvaluar"+(i+1));
            
            if(m[a.getRaiz().getValor()-1][i] == 1 && pasado(nodosPasados,i+1) == false){
                nodosPasados.add(i+1);
                a.getRaiz().getHijos().add(new NodoA(i+1, a.getRaiz()));
                //System.out.println(i+1);
//                if(a.getRaiz() != null){
//                    System.out.println((i+1)+"padre:"+a.getRaiz().getValor());
//                }
            }
       }
        for(int s=0; s<a.getRaiz().getHijos().size();s++){
                temp.setRaiz(a.getRaiz().getHijos().get(s));
                llenarArbolAnchura(m,nodosPasados,temp);
        }
        
       return a;
    }
    
    public Arbol llenarArbolProfundo( int[][] m,ArrayList<Integer> nodosListos, Arbol a){
        ArrayList<Integer> nodosPasados = nodosListos;
        a.getRaiz();
        Arbol temp = new Arbol();

        for(int i=0; i<m.length;i++){
            //si la posicion x,y dde la matriz
           // System.out.println("nodoAEvaluar"+(i+1));
            
            if(m[a.getRaiz().getValor()-1][i] == 1 && pasado(nodosPasados,i+1) == false){
                nodosPasados.add(i+1);
                a.getRaiz().getHijos().add(new NodoA(i+1, a.getRaiz()));
                //System.out.println(i+1);
//                if(a.getRaiz() != null){
//                    System.out.println((i+1)+"padre:"+a.getRaiz().getValor());
//                }
            }
            for(int s=0; s<a.getRaiz().getHijos().size();s++){
                temp.setRaiz(a.getRaiz().getHijos().get(s));
                llenarArbolProfundo(m,nodosPasados,temp);
            }
       }
        
        
       return a;
    }
    
    
    public boolean pasado(ArrayList<Integer> i,int n){
        if(i != null){
            for(int in=0; in< i.size();in++){
                if(i.get(in) == n){
                    return true;
                }   
            }
        }else{
            return false;
        }
        
        
        return false;
    }
    
    
    
    
    

    public boolean Dibujar(){
        boolean correcto = true;
           if(objLienzo.getListaNodos() != null && pnlAdyacencia.getListaAdyacencia() != null && objLienzo.getListaNodos().size() == pnlAdyacencia.getListaNodos().size()){
                objLienzo.getListaAristas().clear();
                boolean compExistente =false;
                boolean compBucle=false , compBidireccion = false, compLetras =false, compFnodos =false, esta=false;
                int compAristas =0;
                int tam = objLienzo.getListaNodos().size();
                int nodoInicio =1;
                int x1,y1,x2,y2;
                
                //comprobar letra
                for(int h=0;h<pnlAdyacencia.getListaAdyacencia().size();h++){
                    String texto = pnlAdyacencia.getListaAdyacencia().get(h).getText();
                    if(comprobarTexto(texto)){
                        compLetras = true;
                    }
                }
                
                
                if(compLetras){
                    correcto=false;
                    lblError.setText("Error: la lista adyacencia no puede contener letras");
                    lblError.setVisible(true);
                    
                }else{
                    //comprobar falsos nodos 
                    for(int k=0;k<pnlAdyacencia.getListaAdyacencia().size();k++){
                        esta = false;
                        if(compFnodos){
                            k=pnlAdyacencia.getListaAdyacencia().size();
                        }else{
                            String texto = pnlAdyacencia.getListaAdyacencia().get(k).getText();
                            texto=texto.replaceAll(" ", "");
                            if(texto.length() != 0){
                                int number = Integer.parseInt(texto);  
                                for(int u=0; u< objLienzo.getListaNodos().size(); u++){
                                    objLienzo.getListaNodos().get(u);
                                    if(number == Integer.parseInt(objLienzo.getListaNodos().get(u).getValor())){
                                        esta = true;
                                    }
                                }
                            }else{
                                esta = true;
                            }
                            if(esta==false){
                                compFnodos = true;
                            }
                        } 
                    }
                    if(compFnodos){
                        correcto=false;
                        lblError.setText("Error: la lista adyacencia tiene nodos incorrectos");
                        lblError.setVisible(true);
                    }else{
                        for(int i=0; i<tam*tam; i++){
                        compExistente= false;
                        if(i%tam == 0 && i!=0){
                            nodoInicio = nodoInicio+1;
                        }
                        String nodofinString=pnlAdyacencia.getListaAdyacencia().get(i).getText();
                        nodofinString=nodofinString.replaceAll(" ", "");
                        if(nodofinString.length()!=0){
                            int nodoFin = Integer.parseInt(nodofinString);
                            x1=objLienzo.getListaNodos().get(nodoInicio-1).getX();
                            y1=objLienzo.getListaNodos().get(nodoInicio-1).getY();
                            x2=objLienzo.getListaNodos().get(nodoFin-1).getX();
                            y2=objLienzo.getListaNodos().get(nodoFin-1).getY();

                            //comprobantes graficos
                            if(x1<x2){
                                x1 = x1+6;
                            }
                            if(x1>x2){
                                x2=x2+6;
                            }

                            for(int n=0; n<objLienzo.getListaAristas().size(); n++){
                                Arista ev = objLienzo.getListaAristas().get(n);
                                //nodo Inicio Arista evaluada
                                int nodoInAev = ev.getN1();
                                int nodofinAev = ev.getN2();
                                if(nodoInicio == nodofinAev && nodoInAev == nodoFin){
                                    compExistente = true;
                                    compBidireccion=true;
                                }
                            }

                            if(nodoInicio == nodoFin){
                                compBucle=true;
                            }else{
                                if(compExistente==false){
                                    Arista arista = new Arista(x1, y1, x2, y2, nodoInicio, nodoFin);
                                    objLienzo.getListaAristas().add(arista);
                                    compAristas =1;
                                }
                            }



                        }

                    }
                    
                //comprobante de aristas    
                    if(compAristas==0){
                        lblError.setText("Error: debe ingresar aristas");
                        lblError.setVisible(true);
                        correcto=false;
                    }

                                    if(compBucle == true){
                        lblError.setText("Error: no puede tener aristas ciclicas");
                        lblError.setVisible(true);
                        correcto=false;
                    }

                    if(compAristas==1 && compBucle == false){
                        if(compBidireccion == true){
                        lblError.setText("Presenta bidirección");
                        lblError.setVisible(true);
                        }else{
                            lblError.setVisible(false);
                        }
                    }
                    } 
                }
                
                //actualización del lienzo
                if(correcto == false){
                    objLienzo.getListaAristas().clear();
                }
                objLienzo.Repintar();
            }else{
                lblError.setText("Error: debe ingresar aristas y nodos");
                lblError.setVisible(true);
                correcto = false;
            }
        
        return correcto;
    }
    
    public boolean comprobarTexto(String a){
        boolean result = false;
        char c;
        for(int i=0;i<a.length();i++){
            c=a.charAt(i);
            if(Character.isDigit(c) && result != true){
                
            }
            if(Character.isLetter(c)){
                result = true;
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graficar().setVisible(true);
            }
        });
    }
}
