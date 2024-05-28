package view;
import java.util.*;

import controller.ConectarDAO;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ConectarDAO ConectarDAO = new ConectarDAO();
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
                    jogar();
                    break;
                case 2:
                    dificuldade();
                    break;
                case 3:
                    ();
                    break;
            

                default:
                    break;
            }

        } while (menu!=-1);
    }
}
