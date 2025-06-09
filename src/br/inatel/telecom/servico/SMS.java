package br.inatel.telecom.servico;

public class SMS extends Consumo{

    // variável específica de Consumo
    private int quantidadeSMS;

    // getter
    public int getQuantidadeSMS() {
        return quantidadeSMS;
    }

    // setter
    public void setQuantidadeSMS(int quantidadeSMS) {
        this.quantidadeSMS = quantidadeSMS;
    }

    // método sobrescrito de Consumo
    @Override
    public double calcularCusto(double taxa) {
        return quantidadeSMS * taxa;
    }
}