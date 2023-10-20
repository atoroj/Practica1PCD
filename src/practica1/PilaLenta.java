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
    private CanvasPila cp;

    public PilaLenta(int capacidad, CanvasPila cp) {
        this.capacidad = capacidad;
        this.datos = new Object[capacidad];
        this.numelementos = 0;
        this.cima = 0;
        this.cp = cp;
    }

    @Override
    public int GetNum() {
        return numelementos;
    }

    @Override
    public synchronized void Apila(Object elemento) throws InterruptedException, Exception {
        int numIntentos = 0;
        while (pilaLlena() && numIntentos < 3) {
            numIntentos++;
            System.out.println("Numero de intentos parar apilar: "+numIntentos+ " del hilo// "+Thread.currentThread().getId());
            this.wait();
        }
            if (!pilaLlena()) {
                this.datos[cima] = elemento;
                this.cima++;
                this.numelementos++;
                this.cp.representa(this.datos, this.cima, this.numelementos);
                notifyAll();
                System.out.println("Se ha APILADO el dato " + elemento);
            } else {
                this.cp.avisa("Pila llena");
                throw new java.lang.Exception("Error: La pila esta llena");
            }
    }

    @Override
    public synchronized Object Desapila() throws InterruptedException, Exception {
        Object elemento = null;
        int numIntentos = 0;
        while (pilaVacia() && numIntentos < 3) {
            wait();
            numIntentos++;
            System.out.println("Numero de intentos parar desapilar: "+numIntentos+ "// del hilo "+Thread.currentThread().getId());
        }
        if (!pilaVacia()) {
            elemento = this.datos[cima - 1];
            this.cima--;
            this.numelementos--;
            this.cp.representa(this.datos, this.cima, this.numelementos);
            notifyAll();
            System.out.println("Se ha DESAPILADO el dato " + elemento);

        } else {
            this.cp.avisa("Pila vacia");
            throw new java.lang.Exception("Error: La pila esta vacia");
        }
        return elemento;
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
