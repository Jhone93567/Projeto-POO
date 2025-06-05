package br.inatel.telecom.servico;

public class DadosMoveis extends Consumo{
    // Declarando variaveis
    private int quantidadeMB;

    // Getter
    public int getQuantidadeMB() {
        return quantidadeMB;
    }

    // Funcoes publicas
    @Override
    public double calcularCusto(double taxa) {
        return (double)quantidadeMB * taxa;
    }
}
