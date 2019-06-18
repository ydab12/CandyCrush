/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JButton;

/**
 *
 * @author yonathan
 */
public class Cambios {
     
    
    public Cambios(){
        
    }
    
    
    public boolean verificar(int[][] matriz) {
     
        boolean v=false;
        MatrizCambios verificar=new MatrizCambios(matriz);
        
        if(verificar.cambios()==true){
            v=true;
            
            
        }
 
        return v;
    }
    
   public int[][] matrizCambios(int[][] matriz){
       MatrizCambios verificar=new MatrizCambios(matriz);
       verificar.cambios();
       
       return verificar.getMatrizCambios();
   
   }
    
    public void efectoCambiar(){
    
    }
    
}
