package br.inatel.telecom.planos;

import br.inatel.telecom.servico.Consumo;
import java.util.ArrayList;
import java.util.List;

public abstract class Plano {

    // variáveis de Plano
    protected int idPlano;
    protected String nome;
    protected double valorMensal;
    protected int usoMinutos = 0;
    protected int usoSMS = 0;
    protected int usoDados = 0;
    protected boolean status = false;

    // composição Consumo -> Plano
    protected List<Consumo> consumos = new ArrayList<>(); // a cada plano está associada uma lista de consumos

    // getters e setters

    public String getNome() {
        return nome;
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

    // função pública para ativar o plano (quando ela for chamada o plano é ativado)
    public void ativarPlano() {
        this.status = true;
    }

    // método abstrato (deve ser implementado em PosPago e PrePago)
    public abstract void addConsumo(Consumo consumo);
}