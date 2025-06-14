package br.inatel.telecom.planos;

import br.inatel.telecom.consumo.Chamada;
import br.inatel.telecom.consumo.Consumo;
import br.inatel.telecom.consumo.DadosMoveis;
import br.inatel.telecom.consumo.SMS;

public class PrePago extends Plano{

    // variáveis específicas de PrePago
    private int limiteMinutos;
    private int limiteSMS;
    private int limiteDados;

    // construtor
    public PrePago(String nome, double valorMensal, int limiteMinutos, int limiteSMS, int limiteDados) {
        this.nome = nome;
        this.valorMensal = valorMensal;
        this.limiteMinutos = limiteMinutos;
        this.limiteSMS = limiteSMS;
        this.limiteDados = limiteDados;
    }

    // metodo privado que desconta o consumo (é chamada apenas internamente para controlar o consumo do plano)
    private void descontarConsumo(Consumo consumo) {
        if (consumo instanceof DadosMoveis) {
            int qtd = ((DadosMoveis) consumo).getQuantidadeMB();
            if (this.limiteDados < qtd)
                throw new RuntimeException("Limite de dados excedido.");
            else
                this.limiteDados -= qtd; // subtrai o consumo diretamente do limite

        } else if (consumo instanceof SMS) {
            int qtd = ((SMS) consumo).getQuantidadeSMS();
            if (this.limiteSMS < qtd)
                throw new RuntimeException("Limite de SMS excedido.");
            else
                this.limiteSMS -= qtd;

        } else if (consumo instanceof Chamada) {
            int duracao = ((Chamada) consumo).getDuracao();
            if (this.limiteMinutos < duracao)
                throw new RuntimeException("Limite de minutos excedido.");
            else
                this.limiteMinutos -= duracao;
        }

    }
    // caso o uso de dados/SMS/minutos ultrapasse o limite, o código lança uma excessão que é capturada no bloco try catch dentro do método addConsumo

    // metodo público que recarrega o saldo para minutos de chamada
    public void recarregarSaldoMinutos(int valor) {
        if (this.status) {
            this.limiteMinutos += valor;
            System.out.println("Seu novo saldo atual: " + this.limiteMinutos + " minutos");
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
        }
    }

    // método público que recarrega o saldo para SMS
    public void recarregarSaldoSMS(int valor) {
        if (this.status) {
            this.limiteSMS += valor;
            System.out.println("Seu novo saldo atual: " + this.limiteSMS + " sms");
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
        }
    }

    // método público que recarrega o saldo para dados móveis
    public void recarregarSaldoDados(int valor) {
        if (this.status) {
            this.limiteDados += valor;
            System.out.println("Seu novo saldo atual: " + this.limiteDados + " Mb");
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
        }
    }

    // método público que exibe quanto limite de minutos, SMS e dados o cliente ainda tem
    public void verificarLimites() {
        System.out.println("Limite de minutos: " + limiteMinutos + " minutos");
        System.out.println("Limite de sms: " + limiteSMS + " sms");
        System.out.println("Limite de dados moveis: " + limiteDados + "Mb");
    }

    // método sobrescrito de Plano
    @Override
    public void addConsumo(Consumo consumo) {
        if (this.status) {
            descontarConsumo(consumo); // subtrai do limite

            // atualiza os valores de consumo após o desconto
            if (consumo instanceof Chamada) {
                this.usoMinutos += ((Chamada) consumo).getDuracao(); // atualiza minutos
            } else if (consumo instanceof SMS) {
                this.usoSMS += ((SMS) consumo).getQuantidadeSMS(); // atualiza SMS
            } else if (consumo instanceof DadosMoveis) {
                this.usoDados += ((DadosMoveis) consumo).getQuantidadeMB(); // atualiza dados
            }
            consumos.add(consumo); // adiciona o consumo à lista
        } else {
            System.out.println("Seu plano está inativo. Ative seu plano e tente novamente.");
        }
    }
}
