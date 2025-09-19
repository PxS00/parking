package br.com.fiap.view;

import br.com.fiap.controller.CarroController;
import br.com.fiap.controller.ClienteController;

import javax.swing.*;

public class ParkingView {
    public static void main(String[] args) {
        String[] escolha = {"Carro","Cliente"};
        int opcao;
        try {
            do {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Carro ou Cliente", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao) {
                    case 0:
                        String placa, cor, descricao;
                        String[] escolha1 = {"Inserir","Alterar","Excluir","Listar"};
                        int opcao1;
                        CarroController carroController = new CarroController();
                        try {
                            opcao1 = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Carro", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha1, escolha1[0]);
                            placa = JOptionPane.showInputDialog("Digite a placa do carro");
                            switch (opcao1) {
                                case 0:
                                    cor = JOptionPane.showInputDialog("Digite a cor do carro");
                                    descricao = JOptionPane.showInputDialog("Digite uma descrição para o carro");
                                    System.out.println(carroController.inserirCarro(placa, cor, descricao));
                                    break;
                                case 1:
                                    cor = JOptionPane.showInputDialog("Digite a NOVA cor do carro");
                                    descricao = JOptionPane.showInputDialog("Digite uma NOVA descrição para o carro");
                                    System.out.println(carroController.alterarCarro(placa, cor, descricao));
                                    break;
                                case 2:
                                    System.out.println(carroController.excluirCarro(placa));
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(null, carroController.listarUmCarro(placa));
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());;
                        }
                        break;
                    case 1:
                        String nome, placa1;
                        String[] escolha2 = {"Inserir","Alterar","Excluir","Listar"};
                        int id, opcao2;
                        ClienteController clienteController = new ClienteController();
                        try {
                            opcao2 = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Cliente", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha2, escolha2[0]);
                            switch (opcao2) {
                                case 0:
                                    nome = JOptionPane.showInputDialog("Digite o nome do cliente");
                                    placa1 = JOptionPane.showInputDialog("Digite a placa do carro");
                                    System.out.println(clienteController.inserirCliente(nome, placa1));
                                    break;
                                case 1:
                                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente"));
                                    nome = JOptionPane.showInputDialog("Digite o NOVO nome do cliente");
                                    placa1 = JOptionPane.showInputDialog("Digite a NOVA placa do carro");
                                    System.out.println(clienteController.alterarCliente(id, nome, placa1));
                                    break;
                                case 2:
                                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente"));
                                    System.out.println(clienteController.excluirCliente(id));
                                    break;
                                case 3:
                                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente"));
                                    JOptionPane.showMessageDialog(null, clienteController.listarUmCliente(id));
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
            JOptionPane.showMessageDialog(null, "Fim de Programa");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());;
        }
    }
}
