/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Cambios;
import modelo.MatrizJuego;
import modelo.Niveles;
import vista.VentanaPrincipal;

/**
 *
 * @author yonathan
 */
public class ControladorCambios {
    
    private int[][] matriz;
    private final JButton[] botones;
    private final ArrayList<ImageIcon> caramelos;
    ArrayList<ImageIcon> punto = new ArrayList();
    private final Cambios cambio;
    MatrizJuego matrizjuego;
    Random generadorAleatorios = new Random();
    VentanaPrincipal ventanaprincipal;
    Niveles nivel;
    
    
    public ControladorCambios(int[][] matriz,JButton[] botones, ArrayList<ImageIcon> caramelo,VentanaPrincipal ventana,Niveles nivel){
        
        this.matriz=matriz;
        this.nivel=nivel;
        this.botones=botones;
        this.caramelos=caramelo;
        this.cambio= new Cambios();
        this.ventanaprincipal=ventana;
        ImageIcon f50 =new ImageIcon("src/vista/imagenes/fondo50.png");
        punto.add(f50);
        ImageIcon f100 =new ImageIcon("src/vista/imagenes/fondo100.png");
        punto.add(f100);
        ImageIcon f200 =new ImageIcon("src/vista/imagenes/fondo200.png");
        punto.add(f200);
    }
    
    public void originalCaramelos() {
        
        for(int f = 0; f< 9; f++){
            for(int c = 0; c< 9; c++){
                int numeroboton=((f+1)-1)*9+(c);
                botones[numeroboton].setIcon(caramelos.get(matriz[f][c]));
            }

        }
     
      if(cambio.verificar(matriz)==true){
          this.actualiza();
      }
    }
  
    public void actualiza() {
        int [][] matriztemporalcambios = cambio.matrizCambios(matriz);
        int sumaF=0;
        int sumaC=0;
        int puntos=0;
        
        for(int f = 0; f< 9; f++){
            sumaF=0;
            for(int c = 0; c< 9; c++){
                sumaF+=matriztemporalcambios[f][c];
                if(c==8){
                    if(sumaF >0){
                        for(int i=0;i<9;i++){
                            if(matriztemporalcambios[f][i]==1){
                                int numeroboton=((f+1)-1)*9+(i);
                                int numeroAleatorio = generadorAleatorios.nextInt(6);
                                matriz[f][i]=numeroAleatorio;
                                if(sumaF==3){
                                  botones[numeroboton].setIcon(punto.get(0));
                                  puntos=50;
                                }
                                if(sumaF==4){
                                  botones[numeroboton].setIcon(punto.get(1));
                                  puntos=100;
                                }
                                if(sumaF==5){
                                  botones[numeroboton].setIcon(punto.get(2));
                                  puntos=200;
                                }
                                
                            }
                        }
                    }
                }

            }
        }
        
        for(int c = 0; c< 9; c++){
            sumaC=0;
            for(int f = 0; f< 9; f++){
                sumaC+=matriztemporalcambios[f][c];
                if(f==8){
                    if(sumaC >0){
                        for(int i=0;i<9;i++){
                            if(matriztemporalcambios[i][c]==1){
                                int numeroboton=((i+1)-1)*9+(c);
                                int numeroAleatorio = generadorAleatorios.nextInt(6);
                                matriz[i][c]=numeroAleatorio;
                                if(sumaC==3){
                                  botones[numeroboton].setIcon(punto.get(0));
                                  puntos=50;
                                }
                                if(sumaC==4){
                                  botones[numeroboton].setIcon(punto.get(1));
                                  puntos=100;
                                }
                                if(sumaC==5){
                                  botones[numeroboton].setIcon(punto.get(2));
                                  puntos=200;
                                }
                                 
                                
                            }
                        }
                    }
                }

            }
        }
         sumaC=0;
         sumaF=0;
        this.originalCaramelos();
        this.actualizaTablero(puntos);
     
    }
    
    public void actualizaTablero(int puntos){
        int progreso;
        int num = Integer.valueOf(ventanaprincipal.getMovimientos());
        num=num-1;
        ventanaprincipal.setMovimientos(String.valueOf(num));
        
        int puntosf=Integer.valueOf(ventanaprincipal.getPuntos());
        puntosf=puntosf+puntos;
        ventanaprincipal.setPuntos(String.valueOf(puntosf));
        progreso = ventanaprincipal.getProgreso();
        progreso = progreso+(puntosf*100/Integer.valueOf(ventanaprincipal.getObjetivo()));
        ventanaprincipal.setProgreso(progreso);
        if(num<1){
            int vida = Integer.valueOf(ventanaprincipal.getVida());
            vida--;
            ventanaprincipal.setVida(String.valueOf(vida));
            ventanaprincipal.setMovimientos("3");
            
        }
        if(Integer.valueOf(ventanaprincipal.getVida())<1){
            JOptionPane.showMessageDialog(null, "Game over");
            System.exit(0);
            
        }
        
        if(Integer.valueOf(ventanaprincipal.getObjetivo())==Integer.valueOf(ventanaprincipal.getPuntos())){
            JOptionPane.showMessageDialog(null, "felicitaciones has pasado el nivel");
            System.exit(0);
            
        }
        
     
    }
    
    public int cambia(int fila1,int fila2,int columna1,int columna2,int boton1,int boton2) throws InterruptedException {
        
        int validar=0;
        int [][] matriztemporal = matriz;
        
        int cambio1 =matriz[fila1][columna1];
        int cambio2=matriz[fila2][columna2];
        
        matriztemporal[fila2][columna2]=cambio1;
        matriztemporal[fila1][columna1]=cambio2;
        
        
        if(cambio.verificar(matriztemporal)==true){
          botones[boton1].setIcon(caramelos.get(cambio2));
          botones[boton2].setIcon(caramelos.get(cambio1));
          matriz=matriztemporal;
          this.actualiza();
          
       
          validar=2;
        }else{
            matriz[fila1][columna1]=cambio1;
            matriz[fila2][columna2]=cambio2;
            validar=3;
            
         
        }
      
        return validar;
    }
    
    public void cambiosIniciales(int[][] matrizcambios){
        
        final int FILA=9;
        final int COLUMNA=9;
        
        for(int f = 0; f< FILA; f++){
            for(int c = 0; c< COLUMNA; c++){
                if(matrizcambios[f][c]==1){
                    int numeroAleatorio = generadorAleatorios.nextInt(6);
                    matriz[f][c]=numeroAleatorio;
                }
               
               

            }

        }
    
    }
    
    
    
}
