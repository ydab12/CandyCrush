
import controlador.ControladorJuego;
import java.io.IOException;
import modelo.MatrizJuego;
import vista.VentanaPrincipal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yonathan
 */
public class Main {
 
     public static void main(String[] args) throws IOException {
         VentanaPrincipal ventana = new VentanaPrincipal();
         MatrizJuego matrizjuego=new MatrizJuego();
         ControladorJuego juego = new ControladorJuego(matrizjuego,ventana);
         juego.iniciar();
           
    }
}
