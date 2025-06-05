package br.inatel.telecom.planos;

import br.inatel.telecom.servico.Consumo;

import java.util.ArrayList;
import java.util.List;

public abstract class Plano {
    protected static int idFatura = 0;

    // Declarando variaveis
    protected int idPlano;
    protected String nome;
    protected double valorMensal;
    protected int usoMinutos = 0;
    protected int usoSMS = 0;
    protected int usoDados = 0;
    protected boolean status = false;

    // Composicao Consumo -> Plano
    protected List<Consumo> consumos = new ArrayList<>();

    // Getters e Setters
    public int getIdPlano() {
        return idPlano;
    }

    public String getNome() {
        return nome;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public boolean getStatus() {
        return status;
    }

    public int getUsoMinutos() {
        return usoMinutos;
    }

    public int getUsoSMS() {
        return usoSMS;
    }

    public int getUsoDados() {
        return usoDados;
    }

    // Funcoes publicas
    public void ativarPlano() {
        this.status = true;
    }
    public abstract void addConsumo(Consumo consumo);
}
