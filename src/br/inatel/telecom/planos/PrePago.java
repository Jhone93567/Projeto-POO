package br.inatel.telecom.planos;

import br.inatel.telecom.servico.Chamada;
import br.inatel.telecom.servico.Consumo;
import br.inatel.telecom.servico.DadosMoveis;
import br.inatel.telecom.servico.SMS;

public class PrePago extends Plano{
    // Declarando variaveis
    protected int limiteMinutos;
    protected int limiteSMS;
    protected int limiteDados;

    // Construtor
    public PrePago(int idPlano, String nome, double valorMensal, int limiteMinutos, int limiteSMS, int limiteDados, double saldo) {
        this.idPlano = idPlano;
        this.nome = nome;
        this.valorMensal = valorMensal;
        this.limiteMinutos = limiteMinutos;
        this.limiteSMS = limiteSMS;
        this.limiteDados = limiteDados;
    }

    // Getters
    public int getLimiteMinutos() {
        return limiteMinutos;
    }

    public int getLimiteSMS() {
        return limiteSMS;
    }

    public int getLimiteDados() {
        return limiteDados;
    }

    // Funcoes privadas
    private void descontarConsumo(Consumo consumo) {
        if (consumo instanceof DadosMoveis) {
            if (this.usoDados + ((DadosMoveis) consumo).getQuantidadeMB() > limiteDados)
                throw new RuntimeException("Limite de dados excedido.");
            else
                this.usoDados += ((DadosMoveis) consumo).getQuantidadeMB();
        } else if (consumo instanceof SMS) {
            if (this.usoSMS + 1 > limiteSMS)
                throw new RuntimeException("Limite de SMS excedido.");
            else
                this.usoSMS ++;
        } else if (consumo instanceof Chamada) {
            if (usoMinutos + ((Chamada) consumo).getDuracao() > limiteMinutos)
                throw new RuntimeException("Limite de minutos excedido.");
            else
                this.usoMinutos += ((Chamada) consumo).getDuracao();
        }
    }

    // Funcoes publicas
    public void recarregarSaldoMinutos(int valor) {
        if (this.status) {
            this.limiteMinutos += valor;
            System.out.println("Seu novo saldo atual: " + this.limiteMinutos + " minutos");
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
        }
    }

    public void recarregarSaldoSMS(int valor) {
        if (this.status) {
            this.limiteSMS += valor;
            System.out.println("Seu novo saldo atual: " + this.limiteSMS + " sms");
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
        }
    }

    public void recarregarSaldoDados(int valor) {
        if (this.status) {
            this.limiteDados += valor;
            System.out.println("Seu novo saldo atual: " + this.limiteDados + " Mb");
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
        }
    }

    public void verificarLimites() {
        System.out.println("Limite de minutos: " + limiteMinutos + " minutos");
        System.out.println("Limite de sms: " + limiteSMS + " sms");
        System.out.println("Limite de dados moveis: " + limiteDados + "Mb");
    }


    // Tratamento de erro usando try-catch
    @Override
    public void addConsumo(Consumo consumo) {
        if (this.status) {
            try {
                descontarConsumo(consumo);
                consumos.add(consumo);
            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
        }
    }
}
