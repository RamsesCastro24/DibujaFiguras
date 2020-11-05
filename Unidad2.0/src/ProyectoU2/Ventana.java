/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoU2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ramses
 */
public class Ventana extends JPanel implements ActionListener {

    // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;

    // declarar la figura
    private Punto[] figura;
    
    public JMenuBar arc;
    public JMenu uno;
   public JMenuItem u1,u2;
    
    public Ventana(String titulo, Punto[] figura) {

        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        arc = new JMenuBar();
        uno = new JMenu("Acciones");
        uno.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        u1 = new JMenuItem("Trasladar",new javax.swing.ImageIcon(getClass().getResource("flecha.png")));
        add(arc);
        arc.add(uno);
        uno.add(u1);
        uno.add(u2);
        u1.addActionListener(this);
        u2.addActionListener(this);
        
        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        // definiendo la figura
        this.figura = figura;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //dibujar figura
        g.setColor(Color.black);
        this.dibujar(g);

//        //escalamiento
//        g.setColor(Color.green);
//        this.escalar(0.5 , 0.5);
//        this.dibujar(g);
//        
//        //traslacion
//        g.setColor(Color.red);
//        this.traslacion(100, 80);
//        this.dibujar(g);
//        
//        
//        //rotacion (+)
//        g.setColor(Color.blue);
//        this.rotacion(400);
//        this.dibujar(g);
//        
//        //rotacion (-)
//        g.setColor(Color.MAGENTA);
//        this.rotacion2(400);
//        this.dibujar(g);
        
       
        //reflexion(x)
        g.setColor(Color.ORANGE);
        this.reflexion();
        this.traslacion(200, 200);
        this.escalar(.5f, .5f);
        this.dibujar(g);
    }
        //reflexion(y)
        
        
        //reflexion(x , y)
            
        
        //deformacion
        
        //metodo de reflexion eje y
    
    //metodo de reflexio x, y
    private void reflexion_xy(){
    int tx =figura[0].getX();
    int ty = figura [0].getY();
    
        for (Punto punto : figura) {
            punto.setX (-(punto.getX() -tx)+tx);
            
            punto.setY(-(punto.getY() -ty)+ty);
        }
    
    }
    
        private void reflexion_y(){
            
            int tx = figura[0].getX();
            int ty = figura[0].getY();
            for (Punto punto : figura) {
                punto.setX((punto.getX() - tx)+tx);
            
            punto.setY((punto.getY() - ty) +ty);
            }
            
            
            
            
        
        }



    private void dibujar(Graphics g) {
        for (int i = 0; i < this.figura.length - 1; i++) {
            g.drawLine(figura[i].getX(),
                    figura[i].getY(),
                    figura[i + 1].getX(),
                    figura[i + 1].getY());
        }

    }

    private void escalar(double fx, double fy) {
       int tx =figura[0].getX();
       int ty =figura[0].getY();
       
       for (Punto punto : figura) {
       // nueva x: ((a-tx)* fx)+tx
       // nueva y: ((a-ty)* fy)+ty    
           punto.setX((int)((punto.getX() - tx)* fx)+tx);
          
           punto.setY((int)((punto.getY() - ty)* fy)+ty);
        }
    
     

    }
    
    private void traslacion(double xf, double yf){
        for (Punto punto : figura) {
            punto.setX(
                    (int) (punto.getX() + xf));
            
            punto.setY(
                    (int) (punto.getY() + yf));
        }
        
    }
    private void rotacion (double angulo){
       int tx =figura[0].getX();
       int ty =figura[0].getY();
       
       for (Punto punto : figura) {
           
           punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        } 
        
    }
    
     private void rotacion2 (double angulo){
       int tx =figura[0].getX();
       int ty =figura[0].getY();
       
       for (Punto punto : figura) {
           
           punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))+(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
           punto.setY((int)((-1)*(punto.getX() - tx)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        } 
        
    }
     private void reflexion(){
       int tx =figura[0].getX();
       int ty =figura[0].getY();
         
        for (Punto punto : figura) {
          
           punto.setX(-(punto.getX() - tx)+tx);
          
           punto.setY(-(punto.getY() - ty)+ty);
       
     }
     }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==u1){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.traslacion(x,y);
            ventana.repaint();   
    }
        if (e.getSource()==u2) {
           double angulo;
           angulo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
           this.rotacion(angulo);
           ventana.repaint();
        }

}
    }
