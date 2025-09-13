package br.com.fiap.view;

import br.com.fiap.controller.ClienteController;

import javax.swing.*;

public class ClienteView {
    public static void main(String[] args) {
        String placa, nomeCliente;
        int idCliente, op;
        String[] escolha = { "Inserir", "Alterar", "Excluir", "Listar"};
        ClienteController clienteController = new ClienteController();
        do{
            try {
                op = JOptionPane.showOptionDialog(null, "Escolha umas das opções abaixo para manipular um Cliente", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);

                switch (op){
                    case 0:
                        nomeCliente = JOptionPane.showInputDialog("Informe o Nome do Cliente:");
                        placa = JOptionPane.showInputDialog("Informe a Placa do Carro do Cliente:");
                        JOptionPane.showMessageDialog(null, clienteController.inserirCliente(nomeCliente, placa));
                        break;
                    case 1:
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Cliente:"));
                        nomeCliente = JOptionPane.showInputDialog("Informe o novo Nome do Cliente:");
                        placa = JOptionPane.showInputDialog("Informe a nova Placa do Carro do Cliente:");
                        JOptionPane.showMessageDialog(null, clienteController.alterarCliente(idCliente, nomeCliente, placa));
                        break;
                    case 2:
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Cliente:"));
                        JOptionPane.showMessageDialog(null, clienteController.excluirCliente(idCliente));
                        break;
                    case 3:
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Cliente:"));
                        JOptionPane.showMessageDialog(null, clienteController.listarUmCliente(idCliente));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa!");
    }
}
