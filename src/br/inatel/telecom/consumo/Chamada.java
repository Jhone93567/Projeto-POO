package br.inatel.telecom.consumo;

public class Chamada implements Consumo {

    // variável específica de Chamada
    private final int duracao;

    // construtor
    public Chamada(int duracao) {
        this.duracao = duracao;
    }

    // getter
    public int getDuracao() {
        return duracao;
    }

    // método sobrescrito de Consumo
    @Override
    public double calcularCusto(double taxa) {
        return duracao * taxa;
    }
}