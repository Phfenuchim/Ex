package model;

public class User {
    private static String nome;
    private static int pontuacao;

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        User.nome = nome;
    }

    public static int getPontuacao() {
        return pontuacao;
    }

    public static void setPontuacao(int pontuacao) {
        User.pontuacao = pontuacao;
    }
}
