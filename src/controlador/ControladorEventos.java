/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import modelo.Cambios;
import modelo.MatrizJuego;
import vista.VentanaPrincipal;

/**
 *
 * @author yonathan
 */
public class ControladorEventos implements ActionListener {

    VentanaPrincipal ventanaprincipal;
    MatrizJuego matrizjuego;
    ControladorJuego controlador;
    int interaccion;
    int posicion1;
    int posicion2;
    private JButton[] boton = new JButton[81];

    public ControladorEventos() throws IOException, InterruptedException {
        interaccion = 1;
        ventanaprincipal = new VentanaPrincipal(this);
        matrizjuego = new MatrizJuego();
        controlador = new ControladorJuego(matrizjuego, ventanaprincipal, boton);
        controlador.iniciar();
    }

    public void setBotones(JButton[] boton) {
        this.boton = boton;
    }
    public void intereccion1(ActionEvent e){
        for (int i = 0; i < 81; i++) {
                if (e.getSource() == boton[i]) {
                    interaccion = 2;
                    
                    posicion1 = i;
                    controlador.efectoClick(i);
                   
                }
            }
    
    }
     public void intereccion2(ActionEvent e){
         for (int i = 0; i < 81; i++) {
                if (e.getSource() == boton[i]) {
                    
                    try {
                        switch (controlador.cambiar(posicion1, i)){
                            case 3:interaccion = 1;posicion1 = 0; controlador.error(); break;
                            case 2:interaccion = 1;posicion1 = 0; break;
                            case 0:posicion1 = i;break;
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ControladorEventos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
            switch (interaccion){
              case 1:this.intereccion1(e); break;
              case 2:this.intereccion2(e); break;
              
            }


    }

}
