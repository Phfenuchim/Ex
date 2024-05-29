
package view;

import java.util.*;

import model.CpMinado;

public class jogar {
    private Scanner scanner;
    Camp campo = new Camp();
    Scanner scan = new Scanner(System.in);

    public void iniciar() {
        campo.addMinas();
        CpMinado[][] matriz = campo.getMatriz();

        do {
            exibirTabuleiro(matriz);
            System.out.println("Digite a linha e a coluna que deseja verificar:");
            int linha = scan.nextInt();
            int coluna = scan.nextInt();
            
            // Verifique as bombas ao redor
            int bombasAoRedor = contarBombasAoRedor(linha, coluna, matriz);

            // Atualize o tabuleiro visual
            matriz[linha][coluna].setValor((char) ('0' + bombasAoRedor));

            // Mostre o resultado
            if (matriz[linha][coluna].minar()) {
                System.out.println("BOOM! Você encontrou uma bomba!");
                break;
            }
        } while (true);
    }

    private void exibirTabuleiro(CpMinado[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j].getValor() + " ");
            }
            System.out.println();
        }
    }

    private int contarBombasAoRedor(int linha, int coluna, CpMinado[][] matriz) {
        int bombasAoRedor = 0;
        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[i].length) {
                    if (matriz[i][j].minar()) {
                        bombasAoRedor++;
                    }
                }
            }
        }
        return bombasAoRedor;
    }
}