package view;
import java.util.*;

import controller.ConectarDAO;
import model.Dificuldade;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ConectarDAO ConectarDAO = new ConectarDAO();
        Jogar Jogar = new Jogar();
        Dificuldade dificuldade = new 
        int menu;
        ConectarDAO.ConectarDao();
        
        
        System.out.println("Bem vindo!");
        do {
            System.out.println("---Menu---");
            System.out.println("1. Jogar");
            System.out.println("2. Dificuldade");
            System.out.println("3. Score");
            menu = scan.nextInt();
            switch (menu) {
                case 1:
                    Jogar.jogar();
                    break;
                case 2:
                    dificuldade();
                    break;
                case 3:
                    ConectarDAO.mostarWinners();
                    break;
            

                default:
                    break;
            }

        } while (menu!=-1);
    }
}
