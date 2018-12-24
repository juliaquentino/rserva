/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class SalaDAO {
    public void salvar(Sala c) {

        String sql = "INSERT INTO lab(numero, tipo, num_lugares) VALUES (?,?,?)";

        try {

            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, c.getNumero());
            pst.setString(2, c.getTipo());
            pst.setInt(3, c.getNumero_lugares());
            pst.execute();

            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void atualizar(Sala c) {
        String sql = "UPDATE lab SET TIPO=?, NUM_LUGARES=? WHERE NUMERO=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, c.getTipo());
            pst.setInt(2, c.getNumero_lugares());
            pst.executeUpdate();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Sala> consultarTudo() {

        String sql = "SELECT * FROM sala";
        ArrayList<Sala> s = new ArrayList<>();
        
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int numero = rs.getInt("NUMERO");
                String tipo = rs.getString("TIPO");
                int num_lugares = rs.getInt("NUM_LUGARES");

                s.add(new Sala(numero, tipo, num_lugares));
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return s;
    }

    
}
