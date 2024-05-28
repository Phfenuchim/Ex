package model;

import java.util.Scanner;

public class Dificuldade {
    public void escolher(){
        Bomb bo = new Bomb();
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
                    bo.numMinas = 3;
                    break;
            
                case 2:
                    bo.numMinas = 5;
                    break;

                case 3:
                    bo.numMinas = 6;
                    break;
            
                
                default:
                    break;
            }
        } while (escolha!=-1);
        
    }
}
