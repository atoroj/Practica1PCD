/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import java.util.Random;

/**
 *
 * @author usuario
 */
public class UsaPila {
    public static void main(String[] args) {
        Pila p = new Pila(10);
        Random r = new Random(System.currentTimeMillis());
        System.out.println(r.nextInt(100));
        if (r.nextInt(100) % 2 == 0) {
            //p.Apila(null);
            System.out.println("Es par");
        }else{
            System.out.println("Es impar");
            //p.Desapila();
        }
    }
}
