/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.swing.JButton;
import modelo.MatrizCambios;
import modelo.MatrizJuego;
import vista.VentanaPrincipal;

/**
 *
 * @author yonathan
 */
public class ControladorJuego  {
    
    VentanaPrincipal ventanaprincipal;
    MatrizJuego matrizjuego;
    MatrizCambios matrizcambios;
  
    public ControladorJuego(MatrizJuego matriz, VentanaPrincipal ventana) throws IOException {
        ventanaprincipal=ventana;
         matrizjuego=matriz;
         matrizjuego.caramelosIniciales();
         matrizcambios=new MatrizCambios(matrizjuego.getMatrizJuego());
       
    }
   
    public void iniciar(){
       ventanaprincipal.actualizar(matrizjuego.iniciarJuego(matrizjuego.getMatrizJuego()));
       this.cambios();
     
    }
    
    public void cambios(){
       
        matrizcambios.cambiosH();
        matrizcambios.cambiosV();
   
    }
    
    public void efectoClick(JButton[] botones,int boton){
        int fila=boton/9;
        int columna =boton-(fila*9);
        int[][] matriz=matrizjuego.getMatrizJuego();
        
          botones[boton].setIcon(ventanaprincipal.getCaramelosClick().get(matriz[fila][columna]));
        
    
    }
    
    public void efectoClickError(JButton[] botones,int boton){
        int fila=boton/9;
        int columna =boton-(fila*9);
        int[][] matriz=matrizjuego.getMatrizJuego();
        
          botones[boton].setIcon(ventanaprincipal.getCaramelos().get(matriz[fila][columna]));
        
    
    }
    
    public int cambiar(JButton[] botones,int posicion1, int posicion2){
        int verificar=2;
        int fila1=posicion1/9;
        int columna1 =posicion1-(fila1*9);
        
        int fila2=posicion2/9;
        int columna2 =posicion2-(fila2*9);
        
        if(posicion1!=posicion2){
            if(fila2-fila1==0 &&columna2-columna1<=1&&columna2-columna1>=-1){
               this.efectoClick(botones, posicion2);
               verificar=3;
     
                 System.out.println("una"+posicion2);
            }
        
            if(columna2-columna1==0 && fila2-fila1<=1&& fila2-fila1>=-1){
           
                this.efectoClick(botones, posicion2);
                 verificar=3;
            
            
             System.out.println("dos"+posicion2);
            }
   
        
        }
        
        
        if(fila2-fila1 >1 ||columna2-columna1 >1 ||fila2-fila1 <-1 ||columna2-columna1 <-1){
            this.efectoClickError(botones, posicion1);
            this.efectoClick(botones, posicion2);
            verificar=0;
        }
        
        return verificar;
    }
    
    
}
