package com.ada;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Juego sticks = new Juego();

        Scanner sc = new Scanner(System.in);
        System.out.println("***********");
        System.out.println("*21 Sticks*");
        System.out.println("***********\n");
        Random dificultadAleatoria = new Random();

        // opcion de dificultad
        int dificultad = 0;
        do {
            System.out.println("¿Qué dificultad quieres? 1)Fácil, 2)Difícil");
            dificultad = sc.nextInt();
            if (dificultad==1){
                if (dificultadAleatoria.nextDouble()>0.8){
                    dificultad=2;
                }else{dificultad=1;}
            }else{
                if (dificultadAleatoria.nextDouble()>0.2){
                    dificultad=2;
                }else{dificultad=1;}
            }
        } while (dificultad < 1 | dificultad > 2);

        // opcion de numero turno
        int opcion = 0;
        do {
            System.out.println("¿Quieres jugar primero? 1)Si, 2)No");
            opcion = sc.nextInt();
        } while (opcion < 1 | opcion > 2);

        sticks.jugar(opcion, dificultad);
    }


}
