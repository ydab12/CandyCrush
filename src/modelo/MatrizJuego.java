/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.Random;


/**
 *
 * @author yonathan
 */
public class MatrizJuego {
    
    Random generadorAleatorios = new Random();
    private final int FILA=9;
    private final int COLUMNA=9;
    private int[][] matrizjuego;
    
    public MatrizJuego(){
        
        matrizjuego = new int[FILA][COLUMNA];
    
    }
    
    public int[][] getMatrizJuego(){return matrizjuego;}
    public void setMatrizJuego(int[][] matriz){this.matrizjuego=matriz;}
   
    public void caramelosIniciales(){
        
        for(int f = 0; f< FILA; f++){
            for(int c = 0; c< COLUMNA; c++){

               int numeroAleatorio = generadorAleatorios.nextInt(6);
               matrizjuego[f][c]=numeroAleatorio;

            }

        }
    }
    
    public int[][] iniciarJuego(int[][] matriz){
        
        int[][] iniciar = new int[81][2];
        
        for(int f = 0; f< FILA; f++){
            for(int c = 0; c< COLUMNA; c++){
                int numeroboton=((f+1)-1)*9+(c);
                iniciar[numeroboton][0]=numeroboton;
                iniciar[numeroboton][1]=matriz[f][c];
          
            }
          
        }
        return iniciar;
    }
    
    
}
