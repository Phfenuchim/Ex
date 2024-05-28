package controller;

import java.sql.DriverManager; // Driver para abrir Conexão
import java.sql.SQLException; // Tratamento de Erros SQL
import java.sql.Connection; // Armazena a Conexão Aberta
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConectarDAO {
    public Connection con = null;
    public String sql = null;
    public PreparedStatement ps;

    public ConectarDao() {

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
                    +"id_winers INT UNSIGNED NOT NULL AUTO_INCREMENT ,"
                    +"nome VARCHAR(50) NOT NULL,"
                    +"pontuacao INT UNSIGNED NOT NULL) ";
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados " + err.getMessage());
        }
    }


}
