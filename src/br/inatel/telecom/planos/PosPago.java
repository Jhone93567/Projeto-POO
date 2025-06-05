package br.inatel.telecom.planos;
import br.inatel.telecom.servico.Consumo;
import br.inatel.telecom.user.Fatura;
import java.time.LocalDate;
import java.time.Month;

public class PosPago extends Plano{
    // Declarando variaveis
    private double taxaPorMB;

    // Construtor
    public PosPago(int idPlano, String nome, double valorMensal, double taxaPorMB) {
        this.idPlano = idPlano;
        this.nome = nome;
        this.valorMensal = valorMensal;
        this.taxaPorMB = taxaPorMB;
    }

    // Getters e setters
    public double getTaxaPorMB() {
        return taxaPorMB;
    }

    public void setTaxaPorMB(float taxaPorMB) {
        this.taxaPorMB = taxaPorMB;
    }



    // Funcoes Publicas
    public Fatura gerarFatura() {
        if(this.status) {
            double total = 0;
            for (Consumo consumo : consumos) {
                total += consumo.calcularCusto(taxaPorMB);
            }

            // Codigo para pegar o mes atual
            LocalDate dataAtual = LocalDate.now();
            Month mesAtual = LocalDate.now().getMonth();
            idFatura++;
            return new Fatura(idFatura,mesAtual.getValue(), total);
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
            return null;
        }
    }

    @Override
    public void addConsumo(Consumo consumo) {
        if (this.status){
            consumos.add(consumo);
        }
        else {
            System.out.println("Seu plano esta inativo. Ative seu plano e tente novamente.");
        }
    }
}
