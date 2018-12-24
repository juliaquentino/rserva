package rserva;

import java.util.Scanner;
public class Professor {
    private String nome;
    private String login;
    private String senha;
    private String coordenacacao;
    Scanner entrada=new Scanner(System.in);
    
    public Professor(String nome, String login, String senha, String coordenacacao) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.coordenacacao = coordenacacao;
    }
    

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getCoordenacacao() {
        return coordenacacao;
    }

}
