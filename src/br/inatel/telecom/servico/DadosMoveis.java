package br.inatel.telecom.servico;

public class DadosMoveis extends Consumo {

    // variável específica de DadosMoveis
    private int quantidadeMB;

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