package br.inatel.telecom.user;

import br.inatel.telecom.planos.Plano;
import br.inatel.telecom.planos.PosPago;

public class Cliente {

    // variáveis de Cliente
    private final int idCliente;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private Plano plano;

    // construtor
    public Cliente(int idCliente, String nome, String cpf, String endereco, String telefone, Plano plano) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.plano = plano; // composiçao Plano -> Cliente
    }

    // getters e setters
    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    // esse getter vai retornar o tipo de plano associado ao cliente (PosPago ou PrePago)
    public Plano getPlano() {
        return plano;
    }

    // função pública para atualizar os dados do cliente
    public void atualizarDados(String nome, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        System.out.println("Dados atualizados.");
    }

    // função pública para consultar o valor da fatura
    public void consultarFatura() {
        if (plano != null && plano.getStatus()) {
            // verifica se o plano é do tipo PosPago
            if (plano instanceof PosPago) {
                // faz cast para PosPago e chama o método gerarFatura
                Fatura fatura = ((PosPago) plano).gerarFatura();
                if (fatura != null) {
                    System.out.println("Fatura do plano " + plano.getNome() + ": " + String.format("%.2f", fatura.getValorTotal()));
                    fatura.gerarArquivo();
                }
            } else {
                System.out.println("Não foi possível gerar a fatura");
            }
        } else {
            System.out.println("Plano não ativo ou não atribuído ao cliente.");
        }
    }

    // função pública para consultar o valor do consumo
    public void consultarConsumo() {
        if (plano != null && plano.getStatus()) {
            // usa os getters de Plano para acessar os valores de usoMinutos, usoSMS e usoDados
            int minutos = plano.getUsoMinutos();
            int sms = plano.getUsoSMS();
            int dados = plano.getUsoDados();
            System.out.println("Consumo no plano " + plano.getNome() + ":");
            System.out.println("Minutos: " + minutos + ", SMS: " + sms + ", Dados: " + dados + " MB.");
        } else {
            System.out.println("Plano não ativo ou não atribuído ao cliente.");
        }
    }
}