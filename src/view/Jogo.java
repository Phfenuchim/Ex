package view;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Scanner scanner;

    public Jogo(int tamanho) {
        tabuleiro = new Tabuleiro(tamanho);
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        // Coloque bombas aleatoriamente no tabuleiro
        Random random = new Random();
        int numeroDeBombas = (int) (tabuleiro.getTamanho() * tabuleiro.getTamanho() * 0.2); // 20% das células terão bombas
        for (int i = 0; i < numeroDeBombas; i++) {
            int linha = random.nextInt(tabuleiro.getTamanho());
            int coluna = random.nextInt(tabuleiro.getTamanho());
            tabuleiro.getCelula(linha, coluna).colocarBomba();
        }

        // Jogo principal
        while (true) {
            // Exiba o tabuleiro visual
            exibirTabuleiro();

            // Peça ao usuário para escolher uma posição
            System.out.print("Digite a linha (0 a " + (tabuleiro.getTamanho() - 1) + "): ");
            int linha = scanner.nextInt();
            System.out.print("Digite a coluna (0 a " + (tabuleiro.getTamanho() - 1) + "): ");
            int coluna = scanner.nextInt();

            // Verifique se a célula escolhida tem uma bomba
            if (tabuleiro.getCelula(linha, coluna).temBomba()) {
                System.out.println("BOOM! Você encontrou uma bomba!");
                break;
            } else {
                // Contar bombas ao redor e atualizar o valor da célula
                int bombasAoRedor = contarBombasAoRedor(linha, coluna);
                tabuleiro.getCelula(linha, coluna).setValor((char) ('0' + bombasAoRedor));
                tabuleiro.getCelula(linha, coluna).revelar(); // Revela a célula após ser selecionada
            }
        }
    }

    private void exibirTabuleiro() {
        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {
                if (tabuleiro.getCelula(i, j).estaRevelada()) {
                    System.out.print(tabuleiro.getCelula(i, j).getValor() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private int contarBombasAoRedor(int linha, int coluna) {
        int bombasAoRedor = 0;
        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                if (i >= 0 && i < tabuleiro.getTamanho() && j >= 0 && j < tabuleiro.getTamanho()) {
                    if (tabuleiro.getCelula(i, j).temBomba()) {
                        bombasAoRedor++;
                    }
                }
            }
        }
        return bombasAoRedor;
    }
}
