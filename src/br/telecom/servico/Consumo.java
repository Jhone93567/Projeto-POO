package br.telecom.servico;

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

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    // Funcoes publicas
    public abstract void calcularCusto();
}
