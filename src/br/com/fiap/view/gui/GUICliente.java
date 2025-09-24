package br.com.fiap.view.gui;

import br.com.fiap.controller.ClienteController;

import javax.swing.*; // Importa componentes Swing para interface gráfica
import javax.swing.event.ListSelectionEvent; // Importa classe para eventos de seleção de lista
import javax.swing.event.ListSelectionListener; // Importa interface para listener de seleção
import java.awt.*; // Importa classes para layout e eventos
import java.awt.event.ActionEvent; // Importa classe para eventos de ação
import java.awt.event.ActionListener; // Importa interface para listener de eventos
import java.util.regex.Matcher; // Importa classe para expressões regulares
import java.util.regex.Pattern; // Importa classe para padrões regex

public class GUICliente extends JPanel { // Classe que herda de JPanel para criar painel de cliente
    // Declaração dos componentes da interface gráfica
    private JLabel lbNome, lbPlaca, lbAvatar, lbImagem; // Labels para identificar os campos
    private JTextField tfNome, tfPlaca; // Campos de texto para entrada de dados
    private JButton btPesquisa, btNovo, btAtualiza, btApaga, btCancelar; // Botões para ações CRUD
    private JList<String> liAvatar; // Lista para seleção de avatares
    private ImageIcon imagem1; // ImageIcon para armazenar imagem do avatar
    private JScrollPane sp; // ScrollPane para a lista de avatares

    public GUICliente() { // Construtor da classe
        inicializarComponentes(); // Chama método para criar os componentes
        definirEventos(); // Chama método para definir eventos dos botões
    }

    private void inicializarComponentes() { // Método para criar e configurar componentes
        setLayout(null); // Define layout absoluto para posicionamento manual
        setBackground(Color.cyan); // Define cor de fundo ciano

        // Criação dos labels com alinhamento à direita
        lbNome = new JLabel("Nome:", JLabel.RIGHT); // Label para campo Nome
        lbPlaca = new JLabel("Placa:", JLabel.RIGHT); // Label para campo Placa
        lbAvatar = new JLabel("Avatar:", JLabel.RIGHT); // Label para campo Avatar

        // Criação dos campos de texto
        tfNome = new JTextField(); // Campo de texto para nome
        tfPlaca = new JTextField(); // Campo de texto para placa

        // Criação da lista de avatares disponíveis (similar às cores do GUICarro)
        String[] avatares = {"Masculino", "Feminino"}; // Array com tipos de avatar
        liAvatar = new JList<>(avatares); // Cria lista com avatares
        sp = new JScrollPane(liAvatar); // Adiciona scrollpane à lista
        imagem1 = new ImageIcon(); // Inicializa ImageIcon para avatar
        lbImagem = new JLabel(imagem1); // Label para mostrar imagem do avatar selecionado

        // Criação dos botões com ícones
        btPesquisa = new JButton(new ImageIcon(getClass().getResource("images/search_icon.png"))); // Botão pesquisar
        btNovo = new JButton(new ImageIcon(getClass().getResource("images/new_icon.png"))); // Botão novo
        btAtualiza = new JButton(new ImageIcon(getClass().getResource("images/update_icon.png"))); // Botão atualizar
        btApaga = new JButton(new ImageIcon(getClass().getResource("images/delete_icon.png"))); // Botão apagar
        btCancelar = new JButton(new ImageIcon(getClass().getResource("images/exit_icon.png"))); // Botão cancelar

        // Definição das posições e tamanhos dos componentes (ajustado sem campo ID)
        lbNome.setBounds(10, 30, 80, 25); // Posiciona label Nome
        tfNome.setBounds(100, 30, 200, 25); // Posiciona campo texto Nome
        lbPlaca.setBounds(10, 75, 80, 25); // Posiciona label Placa
        tfPlaca.setBounds(100, 75, 200, 25); // Posiciona campo texto Placa
        lbAvatar.setBounds(310, 30, 80, 25); // Posiciona label Avatar
        sp.setBounds(310, 65, 100, 80); // Posiciona lista de avatares
        lbImagem.setBounds(420, 30, 128, 128); // Posiciona imagem do avatar

        // Posicionamento dos botões em linha horizontal
        btPesquisa.setBounds(50, 200, 60, 40); // Posiciona botão pesquisa
        btNovo.setBounds(120, 200, 60, 40); // Posiciona botão novo
        btAtualiza.setBounds(190, 200, 60, 40); // Posiciona botão atualizar
        btApaga.setBounds(260, 200, 60, 40); // Posiciona botão apagar
        btCancelar.setBounds(330, 200, 60, 40); // Posiciona botão cancelar

        // Adição dos componentes ao painel (sem campo ID)
        add(lbNome); // Adiciona label Nome
        add(tfNome); // Adiciona campo texto Nome
        add(lbPlaca); // Adiciona label Placa
        add(tfPlaca); // Adiciona campo texto Placa
        add(lbAvatar); // Adiciona label Avatar
        add(sp); // Adiciona lista de avatares
        add(lbImagem); // Adiciona label da imagem
        add(btPesquisa); // Adiciona botão pesquisa
        add(btNovo); // Adiciona botão novo
        add(btAtualiza); // Adiciona botão atualizar
        add(btApaga); // Adiciona botão apagar
        add(btCancelar); // Adiciona botão cancelar
    }

    private void definirEventos() { // Método para definir eventos dos botões
        // Evento do botão cancelar - encerra aplicação
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Encerra a aplicação
            }
        });

        // Evento da lista de avatares - atualiza imagem quando selecionado (CORRIGIDO - movido para fora do btCancelar)
        liAvatar.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!liAvatar.isSelectionEmpty()) { // Verifica se há seleção
                    imagem1 = new ImageIcon(getClass().getResource("avatars/"
                            + liAvatar.getSelectedValue() + ".png")); // Carrega imagem do avatar
                    lbImagem.setIcon(imagem1); // Define imagem no label
                }
            }
        });

        // Evento do botão apagar - exclui cliente pelo ID
        btApaga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteController clienteController = new ClienteController();
                try {
                    // Solicita ID via dialog
                    String idInput = JOptionPane.showInputDialog("Digite o ID do cliente para excluir:");
                    if (idInput != null && !idInput.trim().equals("")) {
                        int id = Integer.parseInt(idInput);
                        JOptionPane.showMessageDialog(null, clienteController.excluirCliente(id));
                        // Limpa os campos após exclusão
                        tfNome.setText("");
                        tfPlaca.setText("");
                        lbImagem.setIcon(null);
                        liAvatar.clearSelection();
                    }
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "ID deve ser um número válido");
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage());
                }
            }
        });

        // Evento do botão atualizar - modifica dados do cliente
        btAtualiza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteController clienteController = new ClienteController();
                try {
                    // Solicita ID via dialog
                    String idInput = JOptionPane.showInputDialog("Digite o ID do cliente para alterar:");
                    if (idInput != null && !idInput.trim().equals("")) {
                        // Verifica se todos os outros campos estão preenchidos
                        if (tfNome.getText().equals("") || tfPlaca.getText().equals("") || liAvatar.isSelectionEmpty()) {
                            JOptionPane.showMessageDialog(null, "Preencha Nome, Placa e selecione um avatar");
                        } else {
                            int id = Integer.parseInt(idInput);
                            String nome = tfNome.getText();
                            String placa = tfPlaca.getText();
                            String avatar = liAvatar.getSelectedValue();
                            JOptionPane.showMessageDialog(null, clienteController.alterarCliente(id, nome, placa, avatar));
                            // Limpa os campos após alteração
                            tfNome.setText("");
                            tfPlaca.setText("");
                            lbImagem.setIcon(null);
                            liAvatar.clearSelection();
                        }
                    }
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "ID deve ser um número válido");
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage());
                }
            }
        });

        // Evento do botão novo - insere novo cliente
        btNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteController clienteController = new ClienteController();
                try {
                    // Verifica se campos nome, placa e avatar estão preenchidos (ID é auto-incremento)
                    if (tfNome.getText().equals("") || tfPlaca.getText().equals("") || liAvatar.isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha Nome, Placa e selecione um Avatar");
                    } else {
                        String nome = tfNome.getText();
                        String placa = tfPlaca.getText();
                        String avatar = liAvatar.getSelectedValue();
                        JOptionPane.showMessageDialog(null, clienteController.inserirCliente(nome, placa, avatar));
                        // Limpa os campos após inserção
                        tfNome.setText("");
                        tfPlaca.setText("");
                        lbImagem.setIcon(null);
                        liAvatar.clearSelection();
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage());
                }
            }
        });

        // Evento do botão pesquisar - busca cliente por ID
        btPesquisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteController clienteController = new ClienteController();
                try {
                    // Solicita ID via dialog
                    String idInput = JOptionPane.showInputDialog("Digite o ID do cliente para pesquisar:");
                    if (idInput != null && !idInput.trim().equals("")) {
                        int id = Integer.parseInt(idInput);
                        String cliente = clienteController.listarUmCliente(id);

                        // Extrai informação do avatar da resposta
                        Pattern pattern = Pattern.compile("Avatar: (.*)");
                        Matcher matcher = pattern.matcher(cliente);
                        String avatar;
                        if (matcher.find()) {
                            avatar = matcher.group(1);
                        } else {
                            avatar = null;
                        }

                        // Cria ícone do avatar para mostrar no diálogo
                        ImageIcon icone = new ImageIcon();
                        if (avatar != null) {
                            if (avatar.equals("masculino")) {
                                icone = new ImageIcon(getClass().getResource("avatars/masculino.png"));
                            } else if (avatar.equals("feminino")) {
                                icone = new ImageIcon(getClass().getResource("avatars/feminino.png"));
                            } else {
                                icone = null;
                            }
                        }

                        JOptionPane.showMessageDialog(null, cliente, "Cliente", JOptionPane.INFORMATION_MESSAGE, icone);
                        // Limpa os campos após consulta
                        tfNome.setText("");
                        tfPlaca.setText("");
                        lbImagem.setIcon(null);
                        liAvatar.clearSelection();
                    }
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "ID deve ser um número válido");
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage());
                }
            }
        });
    }
}
