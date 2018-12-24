package rserva;

import java.sql.*; // importando pacote de linguagem sql
public class Conexao {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        //final String driver = "oracle.jdbc.driver.OracleDriver";
        //final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        
        final String driver = "com.mysql.jdbc.Driver";  
        final String url = "jdbc:mysql://localhost/Loja";
         
        String usuario = "root";
        String senha = "12345678";

        Class.forName(driver);
        System.out.println("carregou o driver");

        return DriverManager.getConnection(url, usuario, senha);


    }
}
