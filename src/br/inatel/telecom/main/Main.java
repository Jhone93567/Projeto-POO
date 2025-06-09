package br.inatel.telecom.main;
import br.inatel.telecom.planos.PrePago;
import br.inatel.telecom.user.Cliente;
import br.inatel.telecom.utilidades.Menu;

import java.util.ArrayList;
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
            Menu.mostraMenu(cliente);
            while (true) { // verifica se a opção escolhida está entre 1 e 9
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

                    cliente = Menu.cadastraCliente(cliente, clientes, sc, id);
                    id++;
                    break;

                case 2: // adicionar consumo

                    if (cliente == null) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }
                    Menu.addConsumo(cliente, sc);
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
                    Menu.atualizaDadosCliente(cliente, sc);
                    break;

                case 6: // recarregar saldo
                    if (cliente == null) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }
                    else if (!(cliente.getPlano() instanceof PrePago)) {
                        System.out.println("Recarregamento disponível apenas para planos pré-pagos.");
                        break;
                    }
                    else
                        Menu.recarregaSaldo(cliente, sc);
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

                    PrePago aux = (PrePago) cliente.getPlano();
                    aux.verificarLimites();
                    break;

                case 8: // mostra clientes
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        cliente = Menu.selecionaCliente(cliente, clientes, sc);
                    }
                    break;
            }
        } while (opcao != 9);
        sc.close();
    }
}
