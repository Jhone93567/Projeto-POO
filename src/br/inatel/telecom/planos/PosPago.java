package br.inatel.telecom.planos;
import br.inatel.telecom.servico.*;
import br.inatel.telecom.user.Fatura;
import java.time.LocalDate;
import java.time.Month;

public class PosPago extends Plano{

    // variável específica de PosPago
    private final double taxaPorMB;
    private final double taxaPorSMS;
    private final double taxaPorMinutos;
    private static int idFatura = 0;

    // construtor
    public PosPago(String nome, double taxaPorMB) {
        this.nome = nome;
        this.taxaPorMB = taxaPorMB;
        this.taxaPorSMS = taxaPorMB * 0.05;
        this.taxaPorMinutos = taxaPorMB * 0.1;

    }

    // função pública que gera fatura
    public Fatura gerarFatura() {
        if(this.status) { // caso o plano esteja ativo
            double total = 0;
            for (Consumo consumo : consumos) { // consumo está referenciando todos os objetos da lista consumos
                if(consumo instanceof DadosMoveis)
                    total += consumo.calcularCusto(taxaPorMB);
                else if(consumo instanceof Chamada)
                    total += consumo.calcularCusto(taxaPorMinutos);
                else if(consumo instanceof SMS)
                    total += consumo.calcularCusto(taxaPorSMS);
            }

            // código para pegar o mês atual
            Month mesAtual = LocalDate.now().getMonth();
            idFatura++;
            return new Fatura(idFatura,mesAtual.getValue(), total); // retorna uma nova fatura (idfatura, mesReferencia, valorTotal)
        }
        else { // caso o plano não esteja ativo
            System.out.println("Seu plano está inativo. Ative seu plano e tente novamente.");
            return null;
        }
    }

    // método sobrescrito de Plano
    @Override
    public void addConsumo(Consumo consumo) {
        if (this.status) {

            consumos.add(consumo);

            if (consumo instanceof Chamada) {
                this.usoMinutos += ((Chamada) consumo).getDuracao();
            } else if (consumo instanceof SMS) {
                this.usoSMS += ((SMS) consumo).getQuantidadeSMS();
            } else if (consumo instanceof DadosMoveis) {
                this.usoDados += ((DadosMoveis) consumo).getQuantidadeMB();
            }

        } else {
            System.out.println("Seu plano está inativo. Ative seu plano e tente novamente.");
        }
    }
}