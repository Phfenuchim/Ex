package view;


    public class Tabuleiro {
        private Celula[][] celulas;
        private int tamanho;
    
        public Tabuleiro(int tamanho) {
            this.tamanho = tamanho;
            celulas = new Celula[tamanho][tamanho];
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    celulas[i][j] = new Celula();
                }
            }
        }
    
        public Celula getCelula(int linha, int coluna) {
            return celulas[linha][coluna];
        }
    
        public int getTamanho() {
            return tamanho;
        }
    }

