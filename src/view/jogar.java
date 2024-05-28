
package view;

import java.util.*;

import model.CpMinado;

public class jogar {
    public void iniciar() { 
        Camp c = new Camp();
        CpMinado cp = new CpMinado();
        c.addMinas();
        CpMinado[][] matriz = c.getMatriz();
        Scanner scanner = new Scanner(System.in);
    
        do {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + "*");
                }
                System.out.println('*');
            }
            
            System.out.println("Digite a linha e a coluna que deseja verificar:");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();
    
            CpMinado campo = matriz[linha][coluna];
            if (cp.clickar()==-1) { // Verifica se o campo está minado
                System.out.println("O campo tem uma mina! Fim de jogo.");
                break;
            } else {
                System.out.println("O campo não tem uma mina.");
            }
        } while (cp.clickar()==-1); 
    }   
}
