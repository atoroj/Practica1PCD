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
        int num;
        for (int i = 0; i < 10; i++) {
            num = r.nextInt(100);
            System.out.println("---------------------------------------");
            System.out.println("Se ha GENERADO el numero: " + num);
            try {
                if ((num % 2) == 0) {
                    p.Apila(num);
                } else {
                    p.Desapila();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
