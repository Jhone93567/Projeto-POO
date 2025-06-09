package br.inatel.telecom.consumo;

public class DadosMoveis extends Consumo {

    // variável específica de DadosMoveis
    private int quantidadeMB;

    // construtor
    public DadosMoveis(int quantidadeMB) {
        this.quantidadeMB = quantidadeMB;
    }

    // getter
    public int getQuantidadeMB() {
        return quantidadeMB;
    }

    // setter
    public void setQuantidadeMB(int quantidadeMB) {
        this.quantidadeMB = quantidadeMB;
    }

    // método sobrescrito de Consumo
    @Override
    public double calcularCusto(double taxa) {
        return quantidadeMB * taxa;
    }
}