package br.com.fiap.view;

import br.com.fiap.controller.CarroController;
import br.com.fiap.controller.ClienteController;

import javax.swing.*;

public class ParkingView {
    public static void main(String[] args) {
        String[] opcoesMenu = {"Carro", "Cliente"};
        String[] opcoesAcao = {"Inserir", "Alterar", "Excluir", "Listar"};
        CarroController carroController = new CarroController();
        ClienteController clienteController = new ClienteController();
        int escolhaMenu, op;
        String placa, cor, descricao, nomeCliente;
        int idCliente;
        do {
            try {
                escolhaMenu = JOptionPane.showOptionDialog(null, "Quem deseja manipular?", "Menu Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
                switch (escolhaMenu) {
                    case 0: // Carro
                        op = JOptionPane.showOptionDialog(null, "Escolha uma ação para Carro", "Carro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesAcao, opcoesAcao[0]);
                        placa = JOptionPane.showInputDialog("Informe a Placa do Carro:");
                        switch (op) {
                            case 0:
                                cor = JOptionPane.showInputDialog("Informe a Cor do Carro:");
                                descricao = JOptionPane.showInputDialog("Informe a Descrição do Carro:");
                                JOptionPane.showMessageDialog(null, carroController.inserirCarro(placa, cor, descricao));
                                break;
                            case 1:
                                cor = JOptionPane.showInputDialog("Informe a nova Cor do Carro:");
                                descricao = JOptionPane.showInputDialog("Informe a nova Descrição do Carro:");
                                JOptionPane.showMessageDialog(null, carroController.alterarCarro(placa, cor, descricao));
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, carroController.excluirCarro(placa));
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, carroController.listarUmCarro(placa));
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida!");
                        }
                        break;
                    case 1: // Cliente
                        op = JOptionPane.showOptionDialog(null, "Escolha uma ação para Cliente", "Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesAcao, opcoesAcao[0]);
                        switch (op) {
                            case 0:
                                nomeCliente = JOptionPane.showInputDialog("Informe o Nome do Cliente:");
                                placa = JOptionPane.showInputDialog("Informe a Placa do Cliente:");
                                JOptionPane.showMessageDialog(null, clienteController.inserirCliente(nomeCliente, placa));
                                break;
                            case 1:
                                idCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Cliente a alterar:"));
                                nomeCliente = JOptionPane.showInputDialog("Informe o novo Nome do Cliente:");
                                placa = JOptionPane.showInputDialog("Informe a nova Placa do Cliente:");
                                JOptionPane.showMessageDialog(null, clienteController.alterarCliente(idCliente, nomeCliente, placa));
                                break;
                            case 2:
                                idCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Cliente a excluir:"));
                                JOptionPane.showMessageDialog(null, clienteController.excluirCliente(idCliente));
                                break;
                            case 3:
                                idCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Cliente a listar:"));
                                JOptionPane.showMessageDialog(null, clienteController.listarUmCliente(idCliente));
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida!");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa!");
    }
}
