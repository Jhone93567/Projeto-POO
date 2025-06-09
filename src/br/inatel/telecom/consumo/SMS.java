package br.inatel.telecom.consumo;

public class SMS implements Consumo{

    // variável específica de Consumo
    private int quantidadeSMS;

    // Construtor
    public SMS(int quantidadeSMS) {
        this.quantidadeSMS = quantidadeSMS;
    }

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