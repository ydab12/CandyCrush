/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEventos;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
/**
 *
 * @author yonathan
 */
public class VentanaPrincipal extends JFrame {
    
     ControladorEventos evento = new ControladorEventos(this);
     ArrayList<ImageIcon> caramelos = new ArrayList();
     JButton[] boton = new JButton[81];
     JPanel tableroJuego;
     JPanel menu;
     JProgressBar barra;
     JLabel puntos;
     JLabel movimientos;
     JLabel nivel;
     JLabel tmovimientos;
     JLabel tnivel;
    
    public VentanaPrincipal() throws IOException{
        
        ImageIcon c1 =new ImageIcon("src/vista/imagenes/c1.png");
        caramelos.add(c1);
        ImageIcon c2 =new ImageIcon("src/vista/imagenes/c2.png");
        caramelos.add(c2);
        ImageIcon c3 =new ImageIcon("src/vista/imagenes/c3.png");
        caramelos.add(c3);
        ImageIcon c4 =new ImageIcon("src/vista/imagenes/c4.png");
        caramelos.add(c4);
        ImageIcon c5 =new ImageIcon("src/vista/imagenes/c5.png");
        caramelos.add(c5);
        ImageIcon c6 =new ImageIcon("src/vista/imagenes/c6.png");
        caramelos.add(c6);
        
        FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/vista/imagenes/fondo.jpg")));
        FondoSwing fondo2 = new FondoSwing(ImageIO.read(new File("src/vista/imagenes/fondo2.jpg")));
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        // inicializanda ventana 
        
        JFrame ventan = new JFrame( "Calculadora" );
        ventan.setBounds(650,150,857,610);
        ventan.setVisible(true);
        ventan.setResizable(false);
        ventan.setLayout(gridbag);
        JPanel ventana = (JPanel) ventan.getContentPane();
        ventana.setBorder(fondo);
       
        
        
        evento.setBotones(boton);
        
        tableroJuego = new JPanel();
        menu = new JPanel();
        barra = new JProgressBar();
        puntos = new JLabel("100");
        tmovimientos = new JLabel("            Movimientos ");
        tnivel = new JLabel("        Nivel ");
        movimientos = new JLabel("0");
        nivel = new JLabel("1");
       
        
        menu.setBackground(Color.PINK);
        
    
        
        tableroJuego.setLayout(new GridLayout(9,9));
      
        
    
        
        
        menu.setLayout(new FlowLayout());
        barra.setValue(10);
      
        
       for(int i=0;i<81;i++){
           
           boton[i]=new JButton();
           boton[i].setRolloverEnabled(false);
           //boton[i].setFocusPainted(false);
          boton[i].setBorder(null);
          boton[i].setBorderPainted(false);
          //boton[i].setBackground(new Color(0, 64, 128));
           boton[i].addActionListener(evento);
           tableroJuego.add(boton[i]);
       }
        
         menu.add(barra);
         menu.add(puntos);
         menu.add(tmovimientos);
         menu.add(movimientos);
         menu.add(tnivel);
         menu.add(nivel);
         

    
       
       
       //c.gridwidth = GridBagConstraints.RELATIVE;  
       c.gridwidth = 0;                   //resetea a los valores por defecto
       c.gridheight = 2;
       gridbag.setConstraints(tableroJuego, c);
       ventana.add(tableroJuego); 
        //ventana.add(menu,BorderLayout.NORTH);
       
       
    }  
    
    public void setProgreso(int progreso){barra.setValue(barra.getValue()+progreso);}
    
    public void actualizar(int[][] caramelo){
        
        for(int i=0;i<caramelo.length;i++){
            boton[caramelo[i][0]].setIcon(caramelos.get(caramelo[i][1]));
            
        }
        
     
    }
        
    
}
