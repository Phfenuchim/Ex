package model;

import java.util.Scanner;

import view.jogar;

public class Dificuldade {
    public void escolher(){
        Bomb bo = new Bomb();
        jogar Jogar = new jogar();
        Scanner scan = new Scanner(System.in);
        int escolha = 0;
            
        
        do {
            System.out.println("Escolha a dificuldade: ");
            System.out.println("1. Facil");
            System.out.println("2. Medio");
            System.out.println("3. Dificil");
            System.out.println("-1. voltar");
            escolha = scan.nextInt();
            switch (escolha) {
                case 1:
                     bo.numMinas = 0.2;
                     Jogar.iniciar();
                     break;
                case 2:
                     bo.numMinas = 0.3;
                     Jogar.iniciar();
                     break;
                case 3:
                     bo.numMinas = 0.5;
                     Jogar.iniciar();
                     break;
                default:
                    break;
            }
        } while (escolha!=-1);
        
    }
}
