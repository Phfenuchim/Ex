package controller;

import java.sql.DriverManager; // Driver para abrir Conexão
import java.sql.SQLException; // Tratamento de Erros SQL
import java.sql.Connection; // Armazena a Conexão Aberta
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import model.User;

public class ConectarDAO {
    public Connection con = null;
    public String sql = null;
    public PreparedStatement ps;

    public void ConectarDao() {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Topagro1");
            this.criarBanco();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão com o MySQL ...\n" + err.getMessage());
        }
    }

    public void criarBanco() {

        try {

            ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS cpminado");
            ps.execute();

            ps = con.prepareStatement("USE cpminado");
            ps.execute();

            sql = "CREATE TABLE IF NOT EXISTS ganhadores("
                    + "id_winers INT UNSIGNED NOT NULL AUTO_INCREMENT ,"
                    + "nome VARCHAR(50) NOT NULL,"
                    + "pontuacao INT UNSIGNED NOT NULL,"
                    + "primary key (id_winers));";
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados " + err.getMessage());
        }
    }

    public void mostarWinners() {
        sql = "SELECT * FROM ganhadores ORDER BY pontuacao DESC;";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet resul = ps.executeQuery();
            while (resul.next()) {
                int id = resul.getInt("id_winers");
                String nome = resul.getString("nome");
                int pontuacao = resul.getInt("pontuacao");
                System.out.println("ID: " + id + ", Nome: " + nome + ", Pontuação: " + pontuacao);
            }  
        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    public void incluir(User obj) {
        sql = "INSERT INTO ganhadores VALUES (null,?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, User.getNome());
            ps.setInt(2, User.getPontuacao());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir usuário!" + err.getMessage());
        }

    }
}