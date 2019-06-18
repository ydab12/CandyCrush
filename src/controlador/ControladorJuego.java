/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import modelo.MatrizCambios;
import modelo.MatrizJuego;
import modelo.Niveles;
import vista.VentanaPrincipal;

/**
 *
 * @author yonathan
 */
public class ControladorJuego  {
    
    VentanaPrincipal ventanaprincipal;
    ControladorCambios cambios;
    MatrizJuego matrizjuego;
    MatrizCambios matrizcambios;
    JButton[] botones;
    Niveles nivel;
  
    public ControladorJuego(MatrizJuego matriz, VentanaPrincipal ventana,JButton[] botones) throws IOException {
        ventanaprincipal=ventana;
         matrizjuego=matriz;
         nivel = new Niveles();
         nivel.nive1();
         
         matrizjuego.caramelosIniciales();
         this.botones=botones;
         matrizcambios=new MatrizCambios(matrizjuego.getMatrizJuego());
         cambios = new ControladorCambios(matrizjuego.getMatrizJuego(),this.botones,ventanaprincipal.getCaramelos(),ventanaprincipal,nivel); 
       
    }
   
   
    
    public void iniciar() throws InterruptedException{
       ventanaprincipal.setMovimientos(String.valueOf(nivel.getMovimientos()));
       ventanaprincipal.setObjetivo(String.valueOf(nivel.getObjetivo()));
       ventanaprincipal.setVida(String.valueOf(nivel.getVidas()));
       ventanaprincipal.setNivel(String.valueOf(nivel.getNivel()));
       ventanaprincipal.actualizar(matrizjuego.iniciarJuego(matrizjuego.getMatrizJuego()));

       while(this.cambios()){}
  
    }
    
    public boolean cambios() throws InterruptedException{
       boolean validar;
        validar=matrizcambios.cambios();
        System.out.println(" cambios="+validar);
        cambios.cambiosIniciales(matrizcambios.getMatrizCambios());
        Thread.sleep (1000);
        ventanaprincipal.actualizar(matrizjuego.iniciarJuego(matrizjuego.getMatrizJuego()));
        matrizcambios.reiniciarMatriz();
       
        
      return validar;
    }
    
    public void efectoClick(int boton){
        int fila=boton/9;
        int columna =boton-(fila*9);
        int[][] matriz=matrizjuego.getMatrizJuego();
        botones[boton].setIcon(ventanaprincipal.getCaramelosClick().get(matriz[fila][columna]));
        
    
    }
    public void error(){
    ventanaprincipal.actualizar(matrizjuego.iniciarJuego(matrizjuego.getMatrizJuego()));
    }
    
    public void efectoClickError(int boton){
        int fila=boton/9;
        int columna =boton-(fila*9);
        int[][] matriz=matrizjuego.getMatrizJuego();
        
          botones[boton].setIcon(ventanaprincipal.getCaramelos().get(matriz[fila][columna]));
        
    
    }
   
    
    
    public int cambiar(int posicion1, int posicion2) throws InterruptedException{
        int verificar=2;
        int fila1=posicion1/9;
        int columna1 =posicion1-(fila1*9);
        
        int fila2=posicion2/9;
        int columna2 =posicion2-(fila2*9);
        
        if(columna2-columna1 !=0 &&  fila2-fila1 !=0){
            this.efectoClickError( posicion1);
            this.efectoClick(posicion2);
            verificar=0;
        } 
        
        if( columna2-columna1 ==0 ){
            if( fila2-fila1 >1|| fila2-fila1 < -1){
                this.efectoClickError( posicion1);
                this.efectoClick(posicion2);
                verificar=0;
            
            }
        }
        
        if( fila2-fila1 ==0 ){
            if( columna2-columna1 >1 || columna2-columna1<-1){
                this.efectoClickError( posicion1);
                this.efectoClick(posicion2);
                verificar=0;
            }
        }
        
        if(posicion1!=posicion2){
      
            if(fila2-fila1==0 &&columna2-columna1==1||columna2-columna1==-1){ 
               
               verificar=cambios.cambia(fila1,fila2,columna1,columna2,posicion1,posicion2);
               
                   
            }
        
            if(columna2-columna1==0 && fila2-fila1==1|| fila2-fila1==-1){
                
                verificar=cambios.cambia(fila1,fila2,columna1,columna2,posicion1,posicion2);
               
            }
   
            
        }
        
        
        
        
        return verificar;
    }
    
    
}
