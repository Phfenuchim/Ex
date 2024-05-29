package view;

public class Celula {
    private boolean bomba;
    private boolean revelada;
    private int bombasProximas;
    private char valor;

    public Celula() {
        bomba = false;
        revelada = false;
        bombasProximas = 0;
    }

    public boolean temBomba() {
        return bomba;
    }

    public void colocarBomba() {
        bomba = true;
    }

    public boolean estaRevelada() {
        return revelada;
    }

    public void revelar() {
        revelada = true;
    }

    public int getBombasProximas() {
        return bombasProximas;
    }

    public void incrementarBombasProximas() {
        bombasProximas++;
    }
    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }
}
