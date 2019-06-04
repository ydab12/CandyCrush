/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author yonathan
 */
public class MatrizCambios {
    private final int FILA=9;
    private final int COLUMNA=9;
   
    private int[][] matrizcambios;
    private int[][] matrizjuego;
    
    public MatrizCambios(int[][] matriz){
        
        matrizcambios = new int[FILA][COLUMNA];
        matrizjuego=matriz;
    }
    
    
    public int[][] getMatrizCambios(){return matrizcambios;}
    public void setMatrizCambios(int[][] matriz){this.matrizcambios=matriz;}
    
    private void guardarCambiosMatrizH(int ini,int fin,int fila){
  
        for(int inicial=ini;inicial<=fin;inicial++){
            matrizcambios[fila][inicial]=1;
        }
        
    }
    
    private void guardarCambiosMatrizV(int ini,int fin,int columna){
  
        for(int inicial=ini;inicial<=fin;inicial++){
            matrizcambios[inicial][columna]=1;
        }
        
    }
    
    public void cambiosH(){
       int combo=2;
       int pinicial =-1;
       int pfinal;
       
       int f=0;
        while (f<9){
            int c=0;
            while(c<8){
                if(matrizjuego[f][c]==matrizjuego[f][c+1]){
                    
                    switch(combo) {
           
                         case 2:combo=3;pinicial=c;break;
                         case 3:combo=4;pfinal=c+1;guardarCambiosMatrizH(pinicial,pfinal,f);break;
                         //case 4:combo=5;pfinal=c+1;guardarCambiosMatriz(pinicial,pfinal,f);break;
         
                    }
                }else{
                     combo=2;
                     pinicial=-1;
                     pfinal=-1;
                
                }
             c++;
            }
          f++;  
        }
       
    }
    
    
    public void cambiosV(){
       int combo=2;
       int pinicial =-1;
       int pfinal;
       
       int c=0;
        while (c<9){
            int f=0;
            while(f<8){
                if(matrizjuego[f][c]==matrizjuego[f+1][c]){
                    
                    switch(combo) {
           
                         case 2:combo=3;pinicial=f;break;
                         case 3:combo=4;pfinal=f+1;guardarCambiosMatrizV(pinicial,pfinal,c);break;
                         
         
                    }
                }else{
                     combo=2;
                     pinicial=-1;
                     pfinal=-1;
                
                }
             f++;
            }
          c++;  
        }
       
    }
    
    
}

