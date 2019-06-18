/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEventos;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


/**
/**
 *
 * @author yonathan
 */
public class VentanaPrincipal extends JFrame {
    
     ControladorEventos evento;
     //Loop loop;
     ArrayList<ImageIcon> caramelos = new ArrayList();
     ArrayList<ImageIcon> caramelosclick = new ArrayList();
    public  JButton[] boton = new JButton[81];
     JPanel tableroJuego;
     JPanel menu;
     JLabel  objetivo;
     JLabel  vida;
     JLabel  tobjetivo;
     JLabel  tvida;
     static JProgressBar barra;
     JLabel puntos; 
     JLabel movimientos;
     JLabel nivel;
     JLabel tmovimientos;
     JLabel tnivel;
    
    public VentanaPrincipal(ControladorEventos eventos) throws IOException{
        this.evento=eventos;
        //this.loop=new Loop();
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
        
        ImageIcon c1_2 =new ImageIcon("src/vista/imagenes/click/c1_2.png");
        caramelosclick.add(c1_2 );
        ImageIcon c2_2 =new ImageIcon("src/vista/imagenes/click/c2_2.png");
        caramelosclick.add(c2_2 );
        ImageIcon c3_2 =new ImageIcon("src/vista/imagenes/click/c3_2.png");
        caramelosclick.add(c3_2 );
        ImageIcon c4_2 =new ImageIcon("src/vista/imagenes/click/c4_2.png");
        caramelosclick.add(c4_2 );
        ImageIcon c5_2 =new ImageIcon("src/vista/imagenes/click/c5_2.png");
        caramelosclick.add(c5_2 );
        ImageIcon c6_2 =new ImageIcon("src/vista/imagenes/click/c6_2.png");
        caramelosclick.add(c6_2 );
        
        FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/vista/imagenes/fondo.jpg")));
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        // inicializanda ventana 
        
        JFrame ventanaPrincipal = new JFrame( "Candy Crush" );
        JPanel ventan = new JPanel();
        ventanaPrincipal.setBounds(650,150,857,610);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLayout(new BorderLayout());
        JPanel ventanaP = (JPanel) ventanaPrincipal.getContentPane();
       
       
        ventan.setLayout(gridbag);
        ventan.setBorder(fondo);
        
        evento.setBotones(boton);
        
        tableroJuego = new JPanel();
        menu = new JPanel();
       
  
        barra = new JProgressBar();
        puntos = new JLabel("0");
        tmovimientos = new JLabel("     Movimientos ");
        tnivel = new JLabel("      Nivel ");
        movimientos = new JLabel("50");
        nivel = new JLabel("1");
         tobjetivo= new JLabel("       Objetivo ");
         tvida= new JLabel("  Vida  "); 
         objetivo= new JLabel ("1");
         vida= new JLabel ("5"); 
     

        tableroJuego.setLayout(new GridLayout(9,9));
        menu.setLayout(new FlowLayout());
       
        barra.setValue(0);
      
        
       for(int i=0;i<81;i++){
           
          boton[i]=new JButton();
          boton[i].setRolloverEnabled(false);
          boton[i].setFocusPainted(false);
          boton[i].setBorder(null);
          boton[i].setBorderPainted(false);
          boton[i].setBackground(new Color(0, 64, 128));
          boton[i].addActionListener(evento);
           tableroJuego.add(boton[i]);
       }
        
        
      
         
         menu.add(barra);
         menu.add(puntos);
         menu.add(tobjetivo);
         menu.add(objetivo);
         menu.add(tmovimientos);
         menu.add(movimientos);
         menu.add(tnivel);
         menu.add(nivel);
         menu.add(tvida);
         menu.add(vida);

       c.gridwidth = GridBagConstraints.RELATIVE;  
      
       
       c.gridwidth = 0;                   //resetea a los valores por defecto
       c.gridheight = 2;
       gridbag.setConstraints(tableroJuego, c);
       ventan.add(tableroJuego); 
       ventanaP.add(menu, BorderLayout.NORTH);
       ventanaP.add(ventan, BorderLayout.CENTER);
       
       
    }  
    
    public void setProgreso(int progreso){barra.setValue(progreso);}
    public void setVida(String vid){vida.setText(vid);}
    public void setObjetivo(String objetiv){objetivo.setText(objetiv);}
    public void setMovimientos(String movimient){movimientos.setText(movimient);}
    public void setPuntos(String punt){puntos.setText(punt);}
    public void setNivel(String niv){nivel.setText(niv);}
    public String getVida(){return vida.getText();}
    public String getObjetivo(){return objetivo.getText();}
    public String getMovimientos(){return movimientos.getText();}
    public String getPuntos(){return puntos.getText();}
    public String getNivel(){return nivel.getText();}
    public int getProgreso(){return barra.getValue();}
    
    public ArrayList<ImageIcon> getCaramelos(){return caramelos;}
    public ArrayList<ImageIcon> getCaramelosClick(){return caramelosclick;}
    
    public void actualizar(int[][] caramelo){
        
        for(int i=0;i<caramelo.length;i++){
            boton[caramelo[i][0]].setIcon(caramelos.get(caramelo[i][1]));
            
        }
        
     
    }
        
    
}
