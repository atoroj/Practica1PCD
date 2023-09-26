/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author usuario
 */
public class Pila implements IPila{
    int cima;
    int capacidad;
    int numelementos;
    Object datos[] = new Object[10];
    public Pila(int capacidad){
        this.capacidad = capacidad;
    }

    @Override
    public int GetNum() {
        return numelementos;
    }

    @Override
    public void Apila(Object elemento) {
        
    }

    @Override
    public Object Desapila() {
        return null;
    }

    @Override
    public Object Primero() {
        return null;
    }
    
    
}
