package br.com.fiap.view;

import br.com.fiap.controller.CarroController;

import javax.swing.*;

public class CarroView {
    public static void main(String[] args) {
        String placa, cor, descricao;
        int op;
        String[] escolha = { "Inserir", "Alterar", "Excluir", "Listar"};
        CarroController carroController = new CarroController();
        do{
            try {
                op = JOptionPane.showOptionDialog(null, "Escolha umas das opções abaixo para manipular um Carro", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                placa = JOptionPane.showInputDialog("Informe a Placa do Carro:");
                switch (op){
                    case 0:
                        cor = JOptionPane.showInputDialog("Informe a Cor do Carro:");
                        descricao = JOptionPane.showInputDialog("Informe a Descrição do Carro:");
                        System.out.println(carroController.inserirCarro(placa, cor, descricao));
                        break;
                    case 1:
                        cor = JOptionPane.showInputDialog("Informe a nova Cor do Carro:");
                        descricao = JOptionPane.showInputDialog("Informe a nova Descrição do Carro:");
                        System.out.println(carroController.alterarCarro(placa, cor, descricao));
                        break;
                    case 2:
                        System.out.println(carroController.excluirCarro(placa));
                        break;
                    case 3:
                        System.out.println(carroController.listarUmCarro(placa));
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa!");
    }
}
