/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfaceSecretaria;

import Gerenciador.GerenciadorAdm;
import Modelo.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Tela de gerenciamento de pacientes para a Secretaria.
 * Esta classe representa a interface gráfica para exibir e gerenciar os pacientes associados à secretaria,
 * permitindo a visualização, atualização e exclusão dos pacientes.
 * 
 * @author matheus
 */
public class MenuSecretariaPaciente extends javax.swing.JFrame {
    private List<Paciente> allPacientes; // Lista completa de pacientes
    private GerenciadorAdm gerenciadorAdm; // Gerenciador de administração para operações com o banco de dados
    private EntityManager em; // Gerenciador de entidades para operações com o banco de dados
    private Secretaria secretaria; // Secretaria associada

    /**
     * Construtor da classe MenuSecretariaPaciente.
     * Inicializa os componentes da interface gráfica e define os dados da secretaria.
     * 
     * @param secretaria A secretaria associada aos pacientes.
     * @param gerenciadorAdm O gerenciador de administração para operações com o banco de dados.
     * @param em O EntityManager para realizar operações com o banco de dados.
     */
    public MenuSecretariaPaciente(Secretaria secretaria, GerenciadorAdm gerenciadorAdm, EntityManager em) {
        initComponents();
        this.secretaria = secretaria;
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        this.renderPacientes(secretaria.getAllPacientes());
        setupSearchField();
        lblNomeSecretaria.setText(" " + secretaria.getNome());
        setLocationRelativeTo(null);
    }

    /**
     * Exibe um diálogo com informações detalhadas sobre um paciente.
     * 
     * @param paciente O paciente cujas informações serão exibidas.
     */
    private void showInformationPaciente(Paciente paciente) {
        JDialog dialog = new JDialog(this, paciente.getNome(), true);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(400, 300));
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] labels = {"ID:", "Nome:", "Idade:", "Genero:", "Data nascimento:", "Telefone:", "Email:", "Endereço:", "Convenio:"};
        String[] values = {
            String.valueOf(paciente.getId()),
            paciente.getNome(),
            Integer.toString(paciente.getIdade()),
            paciente.getSexo(),
            paciente.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            paciente.getTelefone(),
            paciente.getEmail(),
            paciente.getEndereco(),
            (paciente.getTipoConvenio().equals(Paciente.tipoConvenio.PARTICULAR) ? "PARTICULAR" : "PLANO DE SAUDE")
        };

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);

            gbc.gridx = 0;
            gbc.gridy = i;
            infoPanel.add(label, gbc);
            
            String value1 = values[i];
            if (value1.length() > 30) {
                value1 = value1.substring(0, 30) + "...";
            }
            
            JLabel value = new JLabel("<html>" + value1 + "</html>");    // Habilitar HTML para permitir quebra de linha
            value.setPreferredSize(new Dimension(200, 20));              // Ajustar a largura dos valores
            value.setVerticalAlignment(JLabel.TOP);                      // Alinhar o texto ao topo
            value.setToolTipText(values[i]);

            gbc.gridx = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            infoPanel.add(value, gbc);
        }

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> dialog.dispose());

        dialog.add(infoPanel, BorderLayout.CENTER);
        dialog.add(closeButton, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        label2 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        pesquisar = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        cadastrarPaciente = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        box_pacientes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNomeSecretaria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Secretária - Gestão de pacientes");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));

        panel1.setPreferredSize(new java.awt.Dimension(800, 600));

        label2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label2.setText("Pesquisar por Nome:");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backMenuPrincipalSecretaria(evt);
            }
        });

        pesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Pacientes");

        cadastrarPaciente.setBackground(new java.awt.Color(153, 153, 153));
        cadastrarPaciente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cadastrarPaciente.setLabel("Adicionar Paciente");
        cadastrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goCadastrarPaciente(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        box_pacientes.setMaximumSize(new java.awt.Dimension(797, 0));
        box_pacientes.setMinimumSize(new java.awt.Dimension(797, 0));
        box_pacientes.setName("box_pacientes"); // NOI18N
        box_pacientes.setPreferredSize(new java.awt.Dimension(797, 0));
        box_pacientes.setLayout(new javax.swing.BoxLayout(box_pacientes, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(box_pacientes);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Secretária:");

        lblNomeSecretaria.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeSecretaria.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNomeSecretaria.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeSecretaria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomeSecretaria.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblNomeSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(lblNomeSecretaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cadastrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pesquisar)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(cadastrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ação do botão Voltar.
     * Fecha a tela atual e abre o menu principal da Secretaria.
     * 
     * @param evt Evento de ação do botão.
     */
    private void backMenuPrincipalSecretaria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backMenuPrincipalSecretaria
        MenuPrincipalSecretaria menuPrincipalSecretaria = new MenuPrincipalSecretaria(secretaria, gerenciadorAdm, em);
        menuPrincipalSecretaria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMenuPrincipalSecretaria

    /**
     * Renderiza a lista de pacientes na interface gráfica.
     * 
     * @param pacientesToRender Lista de pacientes a serem exibidos.
     */
    private void renderPacientes(List<Paciente> pacientesToRender) {
        this.box_pacientes.setLayout(new BoxLayout(this.box_pacientes, BoxLayout.Y_AXIS));
        this.box_pacientes.setPreferredSize(new Dimension(780, pacientesToRender.size() * 50));
        this.box_pacientes.removeAll();

        if (pacientesToRender.isEmpty()) {
            JLabel noPacientesLabel = new JLabel("Não há pacientes cadastrados.");
            this.box_pacientes.add(noPacientesLabel);
        } else {
            for (Paciente paciente : pacientesToRender) {
                JPanel card_paciente = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                card_paciente.setMaximumSize(new Dimension(780, 40));

                // Configurar constraints para o nameLabel
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(5, 5, 5, 5);
                
                JLabel nameLabel = new JLabel("Nome: " + paciente.getNome());
                nameLabel.setPreferredSize(new Dimension(220, 20));             
                nameLabel.setToolTipText(paciente.getNome());  
                card_paciente.add(nameLabel, gbc);
                
                gbc.gridx = 1;
                JLabel tipoLabel = new JLabel("Tipo de convênio: " + paciente.getTipoConvenio());
                tipoLabel.setPreferredSize(new Dimension(220, 20));
                card_paciente.add(tipoLabel, gbc);
                
                // Configurar constraints para o buttonPanel
                gbc.gridx = 2;                                  // Mover para a terceira coluna
                gbc.weightx = 1.0;                              // O botão empurrará o conteúdo para a esquerda
                gbc.anchor = GridBagConstraints.EAST;           // Alinhar à direita
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
                
                
                JButton updateButton = new JButton("Atualizar");
                JButton deleteButton = new JButton("Deletar");
                JButton infoButton = new JButton("Informações");

                infoButton.addActionListener(e -> {
                    showInformationPaciente(paciente);
                });
                
                updateButton.addActionListener(e -> {
                    CadAtuPaciente cadastrarPaciente = new CadAtuPaciente(secretaria, gerenciadorAdm, em);
                    cadastrarPaciente.setPaciente(paciente);
                    cadastrarPaciente.setVisible(true);
                    this.dispose();
                });

                deleteButton.addActionListener(e -> {
                    int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja deletar o paciente " + paciente.getNome() + "?", 
                        "Confirmar Exclusão", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                    
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        String result = this.secretaria.removerPaciente(paciente.getId());
                        if (result.equals("Paciente removido com sucesso!")) {
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                            updateSearch();                         // Atualiza a lista após a exclusão
                                                        
                        } else {
                            System.out.println(result);
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                buttonPanel.add(updateButton);
                buttonPanel.add(deleteButton);
                buttonPanel.add(infoButton);
                card_paciente.add(buttonPanel, gbc);

                this.box_pacientes.add(card_paciente);
                this.box_pacientes.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre cards
            }
        }

        this.box_pacientes.revalidate();
        this.box_pacientes.repaint();
    }

    /**
     * Atualiza a lista de pacientes exibida na interface.
     * Filtra os pacientes com base no texto de pesquisa atual.
     */
    private void updateSearch() {
        String searchText = pesquisar.getText().trim();
        List<Paciente> filteredPaciente;
        
        if (searchText.isEmpty()) {
            filteredPaciente = secretaria.getAllPacientes();
        
        } 
        else {
            filteredPaciente = secretaria.buscarPaciente(searchText);
            
        }
        this.renderPacientes(filteredPaciente);
    }
                                        
    /**
     * Configura o campo de pesquisa para atualizar a lista de pacientes
     * sempre que o texto for modificado.
     */
    private void setupSearchField() {
        pesquisar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateSearch();
            }
        });
    }
    
    /**
     * Ação do botão Cadastrar Paciente.
     * Abre a tela de cadastro/atualização de paciente.
     * 
     * @param evt Evento de ação do botão.
     */
    private void goCadastrarPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goCadastrarPaciente
        CadAtuPaciente cadastrarPaciente = new CadAtuPaciente(secretaria, gerenciadorAdm, em);
        cadastrarPaciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goCadastrarPaciente

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box_pacientes;
    private java.awt.Button cadastrarPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel lblNomeSecretaria;
    private java.awt.Panel panel1;
    private javax.swing.JTextField pesquisar;
    // End of variables declaration//GEN-END:variables
}