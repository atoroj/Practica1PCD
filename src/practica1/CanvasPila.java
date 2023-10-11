/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Antonio
 */
public class CanvasPila extends Canvas {

    private int cima;
    private int capacidad;
    private int numelementos;
    private Object[] datos;
    private String mensaje;

    public CanvasPila(int height, int width, int capacidad) {
        this.setSize(width, height);
        this.setBackground(Color.DARK_GRAY);
        this.cima = 0;
        this.capacidad = capacidad;
        this.numelementos = 0;
        this.datos = new Object[capacidad];
        this.mensaje = "";
    }

    @Override
    public void paint(Graphics g) {
        Font f1 = new Font("Candara", Font.BOLD, 30);
        Font f2 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);

        Image img = createImage(this.getWidth(), this.getHeight());
        Graphics og = img.getGraphics();

        og.setFont(f1);
        og.setColor(Color.white);
        og.drawRect(200, 20, 100, 50*this.capacidad);
        for (int i = 0; i < this.capacidad; i++) {
            og.drawLine(200, 20+50*(i), 300, 20+50*(i));
            if (i < this.numelementos) {
                og.drawString(""+datos[i]+"", 240, (15+50*this.capacidad)-50*i);
            }
        }
//        og.setFont(f2);
//        og.setColor(Color.red);
//        if(this.numelementos == this.capacidad){
//            og.drawString("Pila llena", 100, 60*this.capacidad);
//        }else if (this.numelementos == 0) {
//            og.drawString("Pila vacia", 300, 60*this.capacidad);
//        }        
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void avisa(String mensaje) {
        this.mensaje = mensaje;
        repaint();
    }

    public void representa(Object[] elemento, int cima, int numelementos) {
        this.datos = elemento;
        this.cima = cima;
        this.numelementos = numelementos;
        repaint();
    }
}
