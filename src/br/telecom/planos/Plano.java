package br.telecom.planos;

public abstract class Plano {

    // Declarando variaveis
    protected int idPlano;
    protected String nome;
    protected double valorMensal;
    protected int limiteMinutos;
    protected int limiteSMS;
    protected int limiteDados;

    // Getters e Setters
    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int getLimiteMinutos() {
        return limiteMinutos;
    }

    public void setLimiteMinutos(int limiteMinutos) {
        this.limiteMinutos = limiteMinutos;
    }

    public int getLimiteSMS() {
        return limiteSMS;
    }

    public void setLimiteSMS(int limiteSMS) {
        this.limiteSMS = limiteSMS;
    }

    public int getLimiteDados() {
        return limiteDados;
    }

    public void setLimiteDados(int limiteDados) {
        this.limiteDados = limiteDados;
    }

    // Funcoes publicas
    public void ativarPlano() {

    }

    public void calcularTarifa() {

    }

    public void verificarLimites() {

    }
}
