/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vista.VentanaPrincipal;

/**
 *
 * @author yonathan
 */
public class ControladorEventos implements ActionListener{
    
    VentanaPrincipal eventobotones;
  
    private JButton[] boton = new JButton[81];
    
    public ControladorEventos(VentanaPrincipal evento){
        this.eventobotones=evento;
    
    }
    
    public void setBotones(JButton[] boton){this.boton=boton;}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0;i<81;i++){
             if(e.getSource()== boton[i]){System.out.print("soy el boton"+i);}
         }
    }
    
}
