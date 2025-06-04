package br.telecom.user;

import br.telecom.servico.Consumo;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    // Declarando variaveis
    private int idFatura;
    private String mesReferencia;
    private double valorToral;
    private String status;

    // Composicao Consumo -> Fatura
    List<Consumo> consumos;

    // Construtor
    public Fatura() {
        consumos = new ArrayList<Consumo>();
    }

    // Geters e Setters
    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public double getValorToral() {
        return valorToral;
    }

    public void setValorToral(double valorToral) {
        this.valorToral = valorToral;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Funcoes publicas
    public void gerarFatura() {

    }

    public void consultarFatura() {

    }

    public void pagarFatura() {

    }
}