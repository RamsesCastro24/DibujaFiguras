/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transformaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ramses
 */
public class Ventana extends JPanel{
     // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    
    //declarar la figura
    private Punto []figura;
    /**
     * Crear una ventana para representar la figura
     * @param titulo Titulo de la ventana
     * @param figura Figura representada por puntos
     */
    public Ventana(String titulo, Punto[] figura){
    // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        
        this.figura= figura;
    
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
   //dibujar la figura
   g.setColor(Color.red);
   this.dibujar(g);
//   //trasladar la figura
//   this.trasladar(200, 200);
//   g.setColor(Color.blue);
//   this.dibujar(g);
//   
//   //escalar la figura con matriz
////   this.escalar(.9f, .9f);
////    g.setColor(Color.green);
////   this.dibujar(g);
//    
//     
//   //escalar la figura con escalar
//    this.escalar(.9f);
//    g.setColor(Color.green);
//   this.dibujar(g);
//   
//   //Rotacion
//  this.rotacion(20);
//   g.setColor(Color.black);
//  this.dibujar(g);
//  
//     //Escalamiento por un punto
//  this.escalamientoPunto(figura, 1.5f, 200, 200);
//   g.setColor(Color.black);
//  this.dibujar(g);
//  
//  //escalamiento por punto fijo con 2 escales
//      this.escalamientoPunto2( 200, 200, 1.1f,1.6f);
//   g.setColor(Color.black);
//  this.dibujar(g);
  
  //rotacion punto fijo
  this.ultimo(20, 200, 200);
  g.setColor(Color.orange);
  this.dibujar(g);
    }
    
    public void trasladar(int factor_x, int factor_y){
        for (Punto punto : figura) {
            punto.setX(punto.getX() + factor_x);
            punto.setY(punto.getY() + factor_y);
            
        }
    }
         public void escalar(float factor_x, float factor_y){
        for (Punto punto : figura) {
            punto.setX((int)(punto.getX() * factor_x));
            punto.setY((int)(punto.getY() * factor_y));
            
        }
    }
    private void dibujar(Graphics g){
        for (int i = 0; i < figura.length - 1; i++) {
            g.drawLine(this.figura[i].getX(), 
                        this.figura[i].getY(), 
                        this.figura[i + 1].getX(), 
                        this.figura[i + 1].getY());
        }
        
    }
    private void escalar (float factor){
         for (Punto punto : figura) {
            punto.setX((int)(punto.getX() * factor));
            punto.setY((int)(punto.getY() * factor));
    }
}
    
    
    private void rotacion(float angulo){
        
        for (Punto punto : figura) {
             punto.setX((int)(punto.getX()*Math.cos(Math.toRadians(angulo))- (punto.getY()*Math.sin(Math.toRadians(angulo)))));
             punto.setY((int)(punto.getX()*Math.sin(Math.toRadians(angulo))+ (punto.getY()*Math.cos(Math.toRadians(angulo)))));
        
    }
}
    
    private void escalamientoPunto(Punto [] points, float scale, int fx, int fy){
        for (int i = 0; i < points.length; i++) {
              //Vector * escalar
            points[i].setX((int)(fx+((points[i].getX() - fx))*scale));
            points[i].setY((int)(fy+((points[i].getY() - fy))*scale));
        }
    }
 
 private void escalamientoPunto2(int xf, int yf, float escalarX, float escalarY){
     for (Punto punto : figura) {
         punto.setX((int )(xf + ((punto.getX() - xf)* escalarX)));
         
         punto.setY((int )(yf + ((punto.getY() - yf)* escalarY)));
     }
        }
 
 private void ultimo(int angulo, int xf , int yf){
     this.trasladar(-xf, -yf);
     this.rotacion(angulo);
     this.trasladar(xf, yf);
 }
        
    }
