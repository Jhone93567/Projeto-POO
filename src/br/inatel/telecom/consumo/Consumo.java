package br.inatel.telecom.consumo;
import java.util.Date;

public abstract class Consumo {
    // variáveis de Consumo
    protected int idConsumo;
    protected Date dataHora;
    protected double custo;

    // método abstrato (deve ser implementado em Chamada, DadosMoveis e SMS)
    public abstract double calcularCusto(double taxa);
}