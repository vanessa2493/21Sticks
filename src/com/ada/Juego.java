package com.ada;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    private int palitosTotal=21;
    private int palitosElegidos;
    private String turno;
    private Random opcionPC = new Random();
    Scanner sc = new Scanner(System.in);


    public void turnoUsuario() {
        turno= "usuario";
        do {
            System.out.println("¿Cúantos palitos quieres sacar? (1 o 2)\n");
            palitosElegidos = sc.nextInt();
        } while (palitosElegidos < 1 | palitosElegidos > 2);
        palitosTotal -= palitosElegidos;
        System.out.println("Quedan " + palitosTotal + " palitos");
    }

    public void turnoPc() {
        turno = "pc";
        palitosElegidos = opcionPC.nextInt(2) + 1;
        System.out.println("La PC eligió " + palitosElegidos + " palitos");
        palitosTotal -= palitosElegidos;
        System.out.println("Quedan " + palitosTotal + " palitos");
    }

    public void jugarFacil(){
        if(palitosTotal == 3 | palitosTotal == 2 && turno=="pc"){
            palitosElegidos=4-palitosTotal;
            System.out.println("La PC eligió " + palitosElegidos + " palitos");
            palitosTotal -= palitosElegidos;
            System.out.println("Quedan " + palitosTotal + " palitos");
            turnoUsuario();
        }
        else if(palitosTotal == 1 && turno=="pc"){
            //palitosElegidos=1;
            //System.out.println("La PC eligió " + palitosElegidos + " palito");
            System.out.println("Has ganado");
        }
        else if(palitosTotal == 0 && turno=="pc"){
            System.out.println("Has ganado");
        }
        else if(palitosTotal == 0 && turno=="usuario"){
            System.out.println("Has perdido");
        }
        else{
            turnoUsuario();
        }
    }

    public void jugarDificil(){
        if(palitosTotal == 3 | palitosTotal == 2 && turno=="pc"){
            palitosElegidos=palitosTotal-1;
            System.out.println("La PC eligió " + palitosElegidos + " palitos");
            palitosTotal -= palitosElegidos;
            System.out.println("Quedan " + palitosTotal + " palitos");
            System.out.println("Has perdido");;
        }
        else if(palitosTotal == 1 && turno=="pc"){
            System.out.println("Has ganado");
        }
        else if(palitosTotal == 0 && turno=="pc"){
            System.out.println("Has ganado");
        }
        else if(palitosTotal == 0 && turno=="usuario"){
            System.out.println("Has perdido");
        }
        else{
            turnoUsuario();
        }
    }

    public void jugar(int opcion, int dificultad) {
        while (palitosTotal > 3) {
            if (opcion == 1) {
                turnoUsuario();
                if(palitosTotal>3) {
                    turnoPc();
                }
            } else {
                if(palitosTotal>3) {
                    turnoPc();
                }
                turnoUsuario();
            }
        }
        //Cambio de turno cuando el palitosTotal es menor que 3
        if (turno == "usuario") {
            turno = "pc";
        } else {
            turno = "usuario";
        }
        if(dificultad==1){//Facil
            jugarFacil();
        }else{jugarDificil();}
    }
}
