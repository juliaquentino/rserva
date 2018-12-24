package rserva;

import java.util.Scanner;
import java.util.logging.Logger;
public class Reserva {
    private String data;
    private String hora;
    private String nome_professor;
    private int numero_sala;
    private String stts;
    private int id;
    Scanner entra=new Scanner(System.in);

    public Reserva(String data, String hora, String nome_professor, int numero_sala, String stts, int id) {
        this.data = data;
        this.hora = hora;
        this.nome_professor = nome_professor;
        this.numero_sala = numero_sala;
        this.stts = stts;
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getNome_professor() {
        return nome_professor;
    }

    public int getNumero_sala() {
        return numero_sala;
    }

    public String getStts() {
        return stts;
    }

    public int getId() {
        return id;
    }

    public Scanner getEntra() {
        return entra;
    }
    
}
