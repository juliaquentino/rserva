package rserva;


import rserva.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProfessorDAO {


    public void salvar(Professor c) {

        String sql = "INSERT INTO professor(nome, senha, coordenacao, login) VALUES (?,?,?,?)";

        try {

            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, c.getNome());
            pst.setString(2, c.getSenha());
            pst.setString(3, c.getCoordenacacao());
            pst.setString(4, c.getLogin());
            pst.execute();

            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Professor c) {
        String sql = "UPDATE cliente SET NOME=?, SENHA=?, COORDENACAO=? WHERE LOGIN=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, c.getNome());
            pst.setString(2, c.getSenha());
            pst.setString(3, c.getCoordenacacao());
            pst.setString(4, c.getLogin());
            pst.executeUpdate();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void excluir(Professor c) {

        String sql = "DELETE FROM professor WHERE login=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, c.getLogin());
            pst.execute();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
             ex.printStackTrace();
        }
    }

    public Professor consultarPorLogin(String login) {

        String sql = "SELECT * FROM professor WHERE login=?";
        Professor c = new Professor("", "", "", "");// se n achar o login do cara vai ta vazia as string
        
        
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("NOME");
                String senha = rs.getString("SENHA");
                String coordenacao = rs.getString("COORDENAÇÃO");

               c = new Professor(nome, login, senha, coordenacao);
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return c;
    }

    public ArrayList<Professor> listarClientes() {

        String sql = "SELECT * FROM cliente";

        ArrayList<Professor> lista = new ArrayList<Professor>();

        try {

            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String login = rs.getString("LOGIN");
                String nome = rs.getString("NOME");
                String coordenacao = rs.getString("COORDENACAO");

                lista.add(new Professor(login, nome, coordenacao, ""));// nao vai listar a senha pq nao eh interessante!!!
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
             ex.printStackTrace();
        }


        return lista;
    }
}

