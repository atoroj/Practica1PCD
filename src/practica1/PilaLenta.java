/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author usuario
 */
public class PilaLenta implements IPila {

    private int cima;
    private final int capacidad;
    private int numelementos;
    private Object datos[];

    public PilaLenta(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new Object[capacidad];
        this.numelementos = 0;
        this.cima = 0;
    }

    @Override
    public int GetNum() {
        return numelementos;
    }

    @Override
    public synchronized void Apila(Object elemento) throws Exception {
        if (!pilaLlena()) {
            this.datos[cima] = elemento;
            Thread.sleep(100);
            this.cima++;
            Thread.sleep(100);
            this.numelementos++;
            System.out.println("Se ha APILADO el dato " + elemento);
        } else {
            throw new Exception("Error: La pila esta llena");
        }

    }

    @Override
    public synchronized Object Desapila() throws Exception {

        if (pilaVacia()) {
            throw new Exception("Error: La pila esta vacia");
        } else {
            Object elemento = null;
            elemento = this.datos[cima - 1];
            Thread.sleep(100);
            this.cima--;
            Thread.sleep(100);
            this.numelementos--;
            System.out.println("Se ha DESAPILADO el dato " + elemento);
            return elemento;
        }
    }

    @Override
    public Object Primero() throws Exception {
        if (pilaVacia()) {
            throw new Exception("La pila esta vacia");
        }
        return datos[cima];
    }

    public boolean pilaLlena() {
        boolean llena = false;
        if (numelementos == capacidad) {
            llena = true;
        }
        return llena;
    }

    public boolean pilaVacia() {
        boolean vacia = false;
        if (numelementos == 0) {
            vacia = true;
        }
        return vacia;
    }

}
