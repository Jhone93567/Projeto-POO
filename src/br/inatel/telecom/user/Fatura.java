package br.inatel.telecom.user;

public class Fatura {
    // Declarando variaveis
    private int idFatura;
    private int mesReferencia;
    private double valorTotal;
    private String status = "Aberta";

    // Construtor
    public Fatura(int idFatura, int mesReferencia, double valorTotal) {
        this.idFatura = idFatura;
        this.mesReferencia = mesReferencia;
        this.valorTotal = valorTotal;
    }

    // Geters e Setters
    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public int getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(int mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public double getvalorTotal() {
        return valorTotal;
    }

    public void setvalorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Funcoes publicas
    public void gerarArquivo() {

    }

    public void consultarFatura() {

    }

    public void pagarFatura() {

    }
}