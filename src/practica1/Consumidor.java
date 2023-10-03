/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author Antonio
 */
public class Consumidor implements Runnable {

    private IPila pila;

    public Consumidor(IPila p) {
        this.pila = p;
    }

    public void consumir() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("El hilo: " + Thread.currentThread().getId() + " Desapilo: " + this.pila.Desapila());
            } catch (Exception e) {
                System.out.println("El hilo: " + Thread.currentThread().getId() + " Error: " + e.getMessage());
            }
        }

    }

    @Override
    public void run() {
        consumir();
    }

}
