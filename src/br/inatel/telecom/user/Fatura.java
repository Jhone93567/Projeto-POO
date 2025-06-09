package br.inatel.telecom.user;

import br.inatel.telecom.utilidades.Arquivos;
import java.util.List;
import java.text.DateFormatSymbols;
public class Fatura {

    // variáveis de Fatura
    private final int idFatura;
    private final int mesReferencia;
    private double valorTotal;
    private String status = "Aberta";
    private String mesString;


    // construtor
    public Fatura(int idFatura, int mesReferencia, double valorTotal) {
        this.idFatura = idFatura;
        this.mesReferencia = mesReferencia;
        this.valorTotal = valorTotal;
        // pegando o mes
        mesString = new DateFormatSymbols().getMonths()[mesReferencia - 1];
    }

    // getters e setters

    public double getValorTotal() {
        return valorTotal;
    }

    // método para gerar arquivo da fatura
    public void gerarArquivo() {
        // informações sobre o arquivo e o conteúdo
        String pasta = "faturas";
        String nomeArq = "fatura_" + idFatura + ".txt";

        Arquivos.criarPasta(pasta);

        List<String> linhas = List.of(
                "Fatura " + idFatura,
                "Valor Total: " + String.format("%.2f", valorTotal),
                "Status: " + status,
                "Mes: " + mesString
        );

        // usa a classe Arquivos para criar a pasta (se necessário) e escreve o arquivo
        Arquivos.Escrever(pasta, nomeArq, linhas);
        System.out.println("Arquivo de fatura gerado.");
    }
}