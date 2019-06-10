/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import modelo.Cambios;
import modelo.MatrizJuego;
import vista.VentanaPrincipal;

/**
 *
 * @author yonathan
 */
public class ControladorEventos  implements ActionListener{
    
    VentanaPrincipal ventanaprincipal;
    MatrizJuego matrizjuego;
    ControladorJuego controlador;
    int interaccion;
    int posicion1;
    int posicion2;
    private JButton[] boton = new JButton[81];
    
    public ControladorEventos() throws IOException{
      interaccion=1; 
      ventanaprincipal= new VentanaPrincipal(this);
      matrizjuego=new MatrizJuego();
      controlador= new ControladorJuego(matrizjuego,ventanaprincipal);
      controlador.iniciar();
    }
    
    public void setBotones(JButton[] boton){this.boton=boton;}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(interaccion==2){
            for(int i=0;i<81;i++){
                if(e.getSource()== boton[i]){
                    
                    if(controlador.cambiar(boton,posicion1, i)==3){
                      interaccion=3;
                      posicion1=0;
                       
                   }
                   if(controlador.cambiar(boton,posicion1, i)==2){
                      interaccion=2;
                     
                       
                   }
                   if(controlador.cambiar(boton,posicion1, i)==0){
                       posicion1=i;
                   }
                   
                   
                   
                }
            }
        }
         
        if(interaccion==1){
            for(int i=0;i<81;i++){
                if(e.getSource()== boton[i]){
                    interaccion=2;
                    controlador.efectoClick(boton,i);
                    posicion1=i;
                }
            }
        }
        
       
                
    }
    
}
