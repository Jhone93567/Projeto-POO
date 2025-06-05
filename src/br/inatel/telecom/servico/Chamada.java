package br.inatel.telecom.servico;
import br.inatel.telecom.user.Cliente;


public class Chamada extends Consumo{
    // Declarando variaveis
    private int duracao;

    public Chamada(int duracao, Cliente remetente, Cliente destinatario) {
        this.duracao = duracao;
    }

    // Getters e Setters
    public int getDuracao() {
        return duracao;
    }

    // Funcoes publicas
    @Override
    public double calcularCusto(double taxa){
        return (double)duracao * taxa;
    }
}
