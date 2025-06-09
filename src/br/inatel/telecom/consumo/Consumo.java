package br.inatel.telecom.consumo;
import java.util.Date;

public interface Consumo {
    // método abstrato (deve ser implementado em Chamada, DadosMoveis e SMS)
    public abstract double calcularCusto(double taxa);
}