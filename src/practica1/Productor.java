/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import java.util.Random;

/**
 *
 * @author Antonio
 */
public class Productor extends Thread {

    private IPila pila;
    int n;
    Random r = new Random();

    public Productor(IPila p, int n) {
        this.pila = p;
        this.n = n;
    }

    public void producir() {
        r.setSeed(System.nanoTime());
        int num;
        for (int i = 0; i < 10; i++) {
            try {
                num = r.nextInt(100);
                pila.Apila(num);
                System.out.println("El hilo: "+ getId()+ " Apila: "+ num);
            } catch (Exception e) {
                System.out.println("El hilo: "+ getId()+ " Error: " + e.getMessage());
            }

        }
    }

    @Override
    public void run() {
        producir();
    }
}
