package br.inatel.telecom.servico;

public class Chamada extends Consumo {

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