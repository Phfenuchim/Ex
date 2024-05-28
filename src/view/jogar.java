
package view;

import java.util.*;

import model.Bomb;
import model.CpMinado;

public class jogar {
    public void iniciar() {
        Camp c = new Camp();
        CpMinado cp = new CpMinado();
        Bomb Bomb = new Bomb();
        c.addMinas();
        CpMinado[][] matriz = c.getMatriz();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" * ");
            }
            System.out.println(" * ");
        }
        do {

            System.out.println("Digite a linha e a coluna que deseja verificar:");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            // Peça ao usuário para escolher uma posição

            // Verifique as bombas ao redor
            int bombasAoRedor = 0;
            for (int i = Bomb.numLinha - 1; i <= Bomb.numLinha + 1; i++) {
                for (int j = Bomb.numColuna - 1; j <= Bomb.numColuna + 1; j++) {
                    if (i >= 0 && i < Bomb.numLinha && j >= 0 && j < Bomb.numColuna) {
                        if (matriz[i][j]) {
                            bombasAoRedor++;
                            break;
                        }
                    }
                }
            }
            // Atualize o tabuleiro visual
            matriz[linha][coluna] = (char) ('0' + bombasAoRedor);

            // Mostre o resultado
            if (matriz[linha][coluna]) {
                System.out.println("BOOM! Você encontrou uma bomba!");
                break;
        } while (cp.clickar() == -1);
    }
}