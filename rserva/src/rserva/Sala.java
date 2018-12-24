package rserva;

import java.util.Scanner;
public class Sala {
    private int numero;
    private String tipo;
    private int numero_lugares;
    Scanner in = new Scanner(System.in);

    public Sala(int numero, String tipo, int numero_lugares) {
        this.numero = numero;
        this.tipo = tipo;
        this.numero_lugares = numero_lugares;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumero_lugares() {
        return numero_lugares;
    }

    public Scanner getIn() {
        return in;
    }
    
    
}
