/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Antonio
 */
public class Consumidor implements Runnable {

    private IPila pila;
    Random r = new Random();

    public Consumidor(IPila p) {
        this.pila = p;
    }

    public void consumir() {
        r.setSeed(System.nanoTime());
        try {
            for (int i = 0; i < 15; i++) {
                sleep((r.nextInt(3)+1) * 1000);
                System.out.println("El hilo: " + Thread.currentThread().getId() + " Desapilo: " + this.pila.Desapila());
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo: " + Thread.currentThread().getId() + " Error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Hilo " + Thread.currentThread().getId() + " consumidor termina por no poder extraer");
        }

    }

    @Override
    public void run() {
        consumir();
    }

}
