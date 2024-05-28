package view;

import model.Bomb;
import model.CpMinado;

public class Camp {
    Bomb Bomb = new Bomb();
    CpMinado [] [] matriz;

    public Camp(){
        matriz = new CpMinado[Bomb.numLinha][Bomb.numColuna];
        for (int i = 0; i < Bomb.numLinha; i++) {
            for (int j = 0; j < Bomb.numColuna; j++) {
                matriz [i][j] = new CpMinado();
            }
        }
        for (int i = 0; i < Bomb.numLinha; i++) {
            for (int j = 0; j < Bomb.numColuna; j++) {
                if(i>0){
                    if(j>0)matriz [i][j].addVizinhos(matriz[i-1][j-1]);
                    matriz [i][j].addVizinhos(matriz[i-1][j]);
                    if(j<Bomb.numColuna-1)matriz [i][j].addVizinhos(matriz[i-1][j+1]);
                }
                
                if(j>0)matriz [i][j].addVizinhos(matriz[i][j+1]);
                if(j<Bomb.numColuna-1)matriz [i][j].addVizinhos(matriz[i][j-1]);

                if(i<Bomb.numLinha-){
                    if(j>0)matriz [i][j].addVizinhos(matriz[i+1][j-1]);
                    matriz [i][j].addVizinhos(matriz[i+1][j]);
                    if(j<Bomb.numColuna-1)matriz [i][j].addVizinhos(matriz[i+1][j+1]);
                }
            }
        }

    } 
    public addMinas(){

    }
}
