package br.inatel.telecom.servico;
import java.util.Date;

public abstract class Consumo {
    // Declarando variaveis
    protected int idConsumo;
    protected Date dataHora;
    protected double custo;

    // Getters e Setters
    public int getIdConsumo() {
        return idConsumo;
    }

    public Date getDataHora() {
        return dataHora;
    }


    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    // Funcoes publicas
    // retorna o custo do consumo
    public abstract double calcularCusto(double taxa);
}
