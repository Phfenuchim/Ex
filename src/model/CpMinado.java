package model;
import java.util.*;

public class CpMinado {
    private boolean minado;
    private boolean revelado;
    private boolean marcado;
    private boolean clickado;
    ArrayList<CpMinado> vizinhos;
    Bomb Bomb = new Bomb();

    public CpMinado(){
        this.minado = false;
        this.revelado = false;
        this.marcado = false;
        this.clickado = false;
        this.vizinhos = new ArrayList<CpMinado>();
    }

    public void addVizinhos(CpMinado e){
        this.vizinhos.add(e);
    }

    public boolean minar(){
        if (!this.minado){
            this.minado = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean marcar(){
        this.marcado = !this.marcado;
        return this.marcado;
    }

    // -1 mina
    // 0 vazio
    // n possui n minas em volta
    public int clickar(){
        this.clickado = true;
        if (this.minado==true){
            return -1;
        }else{
            return numMinaVizinhos();
        }
    }

    public int numMinaVizinhos(){
        int n = 0;
        for (CpMinado e: this.vizinhos) {
            if(e.minado) n++;
        }
        return n;
    }

    public void reset(){
        this.minado = false;
        this.revelado = false;
        this.marcado = false;
        this.clickado = false;
    }
    public String toString(){
        if(this.minado==true)
            return "-1";
        return "+" + this.numMinaVizinhos();
    }
}
