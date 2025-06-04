package br.telecom.user;

import br.telecom.planos.Plano;

public class Cliente {
    // Declarando variaveis
    private int idCliente;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    // Associcao Plano -> Cliente
    private Plano plano = null;

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Funcoes publicas
    public void cadastrar() {

    }

    public void atualizarDados() {

    }

    public void consultarFatura(){

    }

    public void consultarConsumo(){

    }

    public void addPlano(Plano plano){
        this.plano = plano;
    }
}
