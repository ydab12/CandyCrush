/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.MatrizCambios;
import modelo.MatrizJuego;
import vista.VentanaPrincipal;

/**
 *
 * @author yonathan
 */
public class ControladorJuego {
    
    VentanaPrincipal ventanaprincipal;
    MatrizJuego matrizjuego;
    MatrizCambios matrizcambios;
    
    public ControladorJuego(MatrizJuego matriz,VentanaPrincipal ventana){
        
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
    
    
}
