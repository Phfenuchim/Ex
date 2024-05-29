package view;

import java.util.Random;

import model.Bomb;
import model.CpMinado;
import model.Dificuldade;

public class Camp {
    Bomb Bomb = new Bomb();
    Dificuldade Dif = new Dificuldade();
    CpMinado [] [] matriz;

    public Camp(){
        matriz = new CpMinado[Bomb.numLinha][Bomb.numColuna];
        for (int i = 0; i < Bomb.numLinha; i++) {
            for (int j = 0; j < Bomb.numColuna; j++) {
                matriz [i][j] = new CpMinado();
            }
        }
       
    }
        
public CpMinado[][] getMatriz() {
        return matriz;
    } 
public void addMinas(){
        // Crie o tabuleiro com bombas aleatórias
        boolean[][] matriz = new boolean[Bomb.numLinha][Bomb.numColuna];
        for (int i = 0; i < Bomb.numLinha; i++) {
            for (int j = 0; j < Bomb.numColuna; j++) {
                matriz[i][j] = Math.random() < Bomb.numMinas; // 20% de chance de ter uma bomba
            }
        }   
 }
  
 public String toString(){
    String str = "";
    for (int i = 0; i < Bomb.numLinha; i++){
        for (int j = 0; j < Bomb.numColuna; j++){
            str = str + matriz[i][j] +" ";

    }
    str += "\n";
 }
 return str;

 }
}