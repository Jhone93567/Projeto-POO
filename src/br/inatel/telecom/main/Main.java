package br.inatel.telecom.main;

import br.inatel.telecom.planos.*;
import br.inatel.telecom.servico.*;
import br.inatel.telecom.user.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int id = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcao;
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null; //cliente atual

        do {
            System.out.println();
            System.out.println("---SISTEMA DE GERENCIAMENTO DE PLANOS---");
            if (cliente != null)
                System.out.println("Cliente selecionado: " + cliente.getNome());
            System.out.println("1. Cadastrar cliente e plano");
            System.out.println("2. Adicionar consumo");
            System.out.println("3. Consultar consumo");
            System.out.println("4. Consultar fatura");
            System.out.println("5. Atualizar dados do cliente");
            System.out.println("6. Recarregar saldo");
            System.out.println("7. Verificar limites");
            System.out.println("8. Selecionar cliente");
            System.out.println("9. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            while (true) { // verifica se a opção escolhida está entre 1 e 8

                try {
                    opcao = sc.nextInt();
                    sc.nextLine();

                    if (opcao >= 1 && opcao <= 9) {
                        break; // entrada válida, sai do loop
                    } else {
                        System.out.print("Opção inválida. Digite um número de 1 a 9: ");
                    }

                } catch (Exception e) { // captura de exceção causada por entrada não numérica
                    System.out.print("Entrada inválida. Digite um número de 1 a 9: ");
                    sc.nextLine();
                }
            }

            switch (opcao) { // irá mostrar todas as opções do gerenciamento

                case 1: // cadastrar cliente e plano

                    System.out.println("Cadastro do cliente");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    while (!cpf.matches("[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}")) {
                            System.out.println("CPF inválido, tente novamente.");
                            System.out.print("CPF: ");
                            cpf = sc.nextLine();
                    }
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    while(!telefone.matches("(\\([0-9]{2,3}\\))?[0-9]+")){
                        System.out.print("Telefone: ");
                        System.out.println("Telefone inválido, tente novamente.");
                        telefone = sc.nextLine();
                    }
                    cliente = new Cliente(id++, nome, cpf, endereco, telefone); // ID fixo por enquanto

                    clientes.add(cliente);

                    int tipoPlano;
                    System.out.print("Digite 1 para pós-pago e 2 para pré-pago: ");

                    while (true) { // verifica se a entrada é 1 ou 2
                        try {
                            tipoPlano = sc.nextInt();
                            sc.nextLine();
                            if (tipoPlano == 1 || tipoPlano == 2) break; // entrada válida, sai do loop
                            else System.out.print("Opção inválida. Digite 1 ou 2: ");
                        } catch (Exception e) { // captura de exceção causada por entrada não numérica
                            System.out.print("Entrada inválida. Digite 1 ou 2: ");
                            sc.nextLine();
                        }
                    }

                    if (tipoPlano == 1) {
                        System.out.print("Nome do plano: ");
                        String nomePlano = sc.nextLine();
                        System.out.print("Taxa por MB: ");
                        double taxa;
                        while (true) { // verifica se taxa é válida
                            try {
                                taxa = sc.nextDouble();
                                sc.nextLine();
                                break;
                            } catch (Exception e) { // captura a exceção causada por entrada não numérica
                                System.out.print("Entrada inválida. Digite um número: ");
                                sc.nextLine();
                            }
                        }

                        PosPago pos_pago = new PosPago(nomePlano, taxa);
                        pos_pago.ativarPlano();
                        cliente.addPlano(pos_pago);
                        System.out.println("Cliente e plano pós-pago cadastrados.");

                    } else {
                        System.out.print("Nome do plano: ");
                        String nomePlano = sc.nextLine();
                        System.out.print("Valor mensal: ");
                        double valor;
                        while (true) {
                            try {
                                valor = sc.nextDouble();
                                sc.nextLine();
                                break;
                            } catch (Exception e) {
                                System.out.print("Entrada inválida. Digite um número: ");
                                sc.nextLine();
                            }
                        }

                        System.out.print("Limite de minutos: ");
                        int min;
                        while (true) {
                            try {
                                min = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (Exception e) { // captura a exceção causada por entrada não numérica
                                System.out.print("Entrada inválida. Digite um número: ");
                                sc.nextLine();
                            }
                        }

                        System.out.print("Limite de SMS: ");
                        int sms;
                        while (true) {
                            try {
                                sms = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (Exception e) { // captura a exceção causada por entrada não numérica
                                System.out.print("Entrada inválida. Digite um número: ");
                                sc.nextLine();
                            }
                        }

                        System.out.print("Limite de dados (MB): ");
                        int dados;
                        while (true) {
                            try {
                                dados = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (Exception e) { // captura a exceção causada por entrada não numérica
                                System.out.print("Entrada inválida. Digite um número: ");
                                sc.nextLine();
                            }
                        }

                        PrePago pre_pago = new PrePago(nomePlano, valor, min, sms, dados);
                        pre_pago.ativarPlano();
                        cliente.addPlano(pre_pago);
                        System.out.println("Cliente e plano pré-pago cadastrados.");
                    }
                    break;

                case 2: // adicionar consumo

                    if (cliente == null) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }

                    System.out.println("1. Chamada");
                    System.out.println("2. SMS");
                    System.out.println("3. Dados móveis");
                    System.out.print("Escolha o consumo que deseja adicionar: ");
                    int tipoConsumo;
                    while (true) {
                        try {
                            tipoConsumo = sc.nextInt();
                            sc.nextLine();
                            break;
                        } catch (Exception e) { // captura a exceção causada por entrada não numérica
                            System.out.print("Entrada inválida. Digite um número: ");
                            sc.nextLine();
                        }
                    }

                    Consumo consumo = null;

                    switch (tipoConsumo) { // irá mostrar todas as opções de consumo

                        case 1: // chamada
                            System.out.print("Duração da chamada (minutos): ");
                            int duracao;
                            while (true) {
                                try {
                                    duracao = sc.nextInt();
                                    sc.nextLine();
                                    break;
                                } catch (Exception e) { // captura a exceção causada por entrada não numérica
                                    System.out.print("Entrada inválida. Digite um número: ");
                                    sc.nextLine();
                                }
                            }
                            consumo = new Chamada(duracao);
                            break;

                        case 2: // SMS
                            System.out.print("Quantidade de SMS: ");
                            int qtd_SMS;
                            while (true) {
                                try {
                                    qtd_SMS = sc.nextInt();
                                    sc.nextLine();
                                    break;
                                } catch (Exception e) { // captura a exceção causada por entrada não numérica
                                    System.out.print("Entrada inválida. Digite um número: ");
                                    sc.nextLine();
                                }
                            }
                            SMS sms = new SMS();
                            sms.setQuantidadeSMS(qtd_SMS);
                            consumo = sms;
                            break;

                        case 3: // dados móveis
                            System.out.print("Quantidade de dados (MB): ");
                            int qtd_MB;
                            while (true) {
                                try {
                                    qtd_MB = sc.nextInt();
                                    sc.nextLine();
                                    break;
                                } catch (Exception e) { // captura a exceção causada por entrada não numérica
                                    System.out.print("Entrada inválida. Digite um número: ");
                                    sc.nextLine();
                                }
                            }
                            DadosMoveis dados = new DadosMoveis();
                            dados.setQuantidadeMB(qtd_MB);
                            consumo = dados;
                            break;

                        default:
                            System.out.println("Tipo de consumo inválido.");
                            break;
                    }

                    if (consumo != null) { // se o consumo for diferente de 0 adicionamos ele ao plano
                        try {
                            cliente.getPlano().addConsumo(consumo);
                            System.out.println("Consumo adicionado.");
                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar consumo: " + e.getMessage());
                        }
                    }
                    break;

                case 3: // consultar consumo

                    if (cliente == null) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        cliente.consultarConsumo();
                    }
                    break;

                case 4: // consultar fatura

                    if (cliente == null) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        cliente.consultarFatura(); // já imprime a fatura se houver
                    }
                    break;

                case 5: // atualizar dados do cliente
                    if (cliente == null) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("Atualização de dados do cliente");
                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();
                        System.out.print("Novo endereço: ");
                        String novoEndereco = sc.nextLine();
                        System.out.print("Novo telefone: ");
                        String novoTelefone = sc.nextLine();
                        System.out.print("Novo CPF: ");
                        String novoCpf = sc.nextLine();

                        cliente.atualizarDados(novoNome, novoEndereco, novoTelefone, novoCpf);
                    }
                    break;

                case 6: // recarregar saldo

                    if (cliente == null) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }

                    if (!(cliente.getPlano() instanceof PrePago)) {
                        System.out.println("Recarregamento disponível apenas para planos pré-pagos.");
                        break;
                    }

                    PrePago plano_pre = (PrePago) cliente.getPlano();

                    int tipoSaldo;
                    int valorRecarga;
                    System.out.println("1. Minutos");
                    System.out.println("2. SMS");
                    System.out.println("3. Dados móveis");
                    System.out.print("Escolha o tipo de saldo a recarregar: ");

                    while (true) {
                        try {

                            tipoSaldo = sc.nextInt();

                            System.out.print("Quantidade a recarregar: ");
                            valorRecarga = sc.nextInt();
                            sc.nextLine();

                            break;

                        } catch (InputMismatchException e) {
                            System.out.print("Entrada inválida. Digite apenas números: ");
                            sc.nextLine();
                        }
                    }

                    switch (tipoSaldo) {
                        case 1:
                            plano_pre.recarregarSaldoMinutos(valorRecarga);
                            break;
                        case 2:
                            plano_pre.recarregarSaldoSMS(valorRecarga);
                            break;
                        case 3:
                            plano_pre.recarregarSaldoDados(valorRecarga);
                            break;
                        default:
                            System.out.println("Tipo de saldo inválido.");
                    }

                    break;

                case 7: // verificar limites do plano pré-pago
                    if (cliente == null) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }

                    if (!(cliente.getPlano() instanceof PrePago)) {
                        System.out.println("Consulta de limites disponível apenas para planos pré-pagos.");
                        break;
                    }

                    PrePago planoPre2 = (PrePago) cliente.getPlano();
                    planoPre2.verificarLimites();
                    break;

                case 8:
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("Clientes cadastrados:");
                        for (Cliente c : clientes) {
                            System.out.println("ID: " + c.getIdCliente() + " - Nome: " + c.getNome());
                        }
                        System.out.print("Digite o ID do cliente que deseja selecionar: ");
                        int idSelecionado = sc.nextInt();
                        sc.nextLine();
                        cliente = null;
                        for (Cliente c : clientes) {
                            if (c.getIdCliente() == idSelecionado) {
                                cliente = c;
                                break;
                            }
                        }
                        if(cliente == null) {
                            System.out.println("Cliente com ID " + idSelecionado + " não encontrado.");
                        }
                    }
                    break;

            }

        } while (opcao != 9);

        sc.close();
    }
}