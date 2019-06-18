/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author yonathan
 */

 
public class Icono extends javax.swing.JPanel{
    public Icono () {
this.setSize(60000, 40000); //se selecciona el tamaño del panel
}
 
//Se crea un método cuyo parámetro debe ser un objeto Graphics
 
    @Override
    public void paint(Graphics grafico) {
Dimension height = getSize();
 
 
ImageIcon Img; 
        Img = new ImageIcon(getClass().getResource("imagenes/objetivo.png"));
 
//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
grafico.drawImage(Img.getImage(), 1,1, height.width, height.height, null);
 
setOpaque(false);
super.paintComponent(grafico);
}
}
