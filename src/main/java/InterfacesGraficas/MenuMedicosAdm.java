package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Medico;
import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Tela de interface gráfica para a administração de médicos.
 * Permite visualizar, atualizar, deletar e obter informações detalhadas dos médicos cadastrados.
 * Também oferece a funcionalidade de buscar médicos por nome ou especialidade.
 * 
 * @author thiago
 */
public class MenuMedicosAdm extends javax.swing.JFrame {
    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private EntityManager em;
    private List<Medico> allMedicos;
    
    /**
     * Construtor da classe.
     * Inicializa os componentes da interface e configura as informações iniciais.
     * 
     * @param gerenciadorAdm o gerenciador de administração para operações de CRUD
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public MenuMedicosAdm(GerenciadorAdm gerenciadorAdm, EntityManager em) {
        initComponents();
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        this.renderMedicos(gerenciadorAdm.getAllMedicos());
        setupSearchField();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        cadastrarMedico = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        box_medicos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adm - alterações");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Médicos");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuPrincipalAdm(evt);
            }
        });

        cadastrarMedico.setBackground(new java.awt.Color(153, 153, 153));
        cadastrarMedico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cadastrarMedico.setLabel("Adicionar Médico");
        cadastrarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goCadastrarMedico(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label2.setText("Pesquisar por Nome/Especialidade:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        box_medicos.setMaximumSize(new java.awt.Dimension(797, 0));
        box_medicos.setMinimumSize(new java.awt.Dimension(797, 0));
        box_medicos.setName("box_medicos"); // NOI18N
        box_medicos.setPreferredSize(new java.awt.Dimension(797, 0));
        box_medicos.setLayout(new javax.swing.BoxLayout(box_medicos, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(box_medicos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cadastrarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(320, 320, 320))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(cadastrarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exibe um diálogo com informações detalhadas sobre o médico selecionado.
     * 
     * @param medico o médico cujas informações serão exibidas
     */
    private void showInformationMedico(Medico medico) {
        JDialog dialog = new JDialog(this, medico.getNome(), true);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(400, 300));
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] labels = {"ID:", "Secretaria:", "Nome:", "Genero:", "Data nascimento:", "CRM:", "Especialidade:", "Telefone:", "Email:"};
        String[] values = {
            String.valueOf(medico.getId()),
            (medico.getSecretaria() == null ? "Sem secretaria" : medico.getSecretaria().getNome()),
            medico.getNome(),
            medico.getGenero(),
            medico.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            Integer.toString(medico.getCrm()),
            medico.getEspecialidade(),
            medico.getTelefone(),
            medico.getEmail()
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
            
            JLabel value = new JLabel("<html>" + value1 + "</html>");  // Habilitar HTML para permitir quebra de linha
            value.setPreferredSize(new Dimension(200, 20));  // Ajustar a largura dos valores
            value.setVerticalAlignment(JLabel.TOP);  // Alinhar o texto ao topo
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
     * Renderiza a lista de médicos no painel.
     * 
     * @param medicosToRender a lista de médicos a serem exibidos
     */
    private void renderMedicos(List<Medico> medicosToRender) {
        // Configurar o layout do box_medicos para vertical
        this.box_medicos.setLayout(new BoxLayout(this.box_medicos, BoxLayout.Y_AXIS));

        // Definir um tamanho preferido para o box_medicos
        this.box_medicos.setPreferredSize(new Dimension(780, medicosToRender.size() * 50));

        // Limpar o painel antes de adicionar novos médicos
        this.box_medicos.removeAll();

        if (medicosToRender.isEmpty()) {
            JLabel noMedicosLabel = new JLabel("Não há médicos cadastrados.");
            this.box_medicos.add(noMedicosLabel);
        } else {
            for (Medico medico : medicosToRender) {
                
                JPanel card_medico = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                card_medico.setMaximumSize(new Dimension(780, 40));

                // Configurar constraints para o nameLabel
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(5, 5, 5, 5);
                
                JLabel nameLabel = new JLabel("Nome: " + medico.getNome());
                nameLabel.setPreferredSize(new Dimension(215, 20));             // Limitar o tamanho
                nameLabel.setToolTipText(medico.getNome());                     // Mostrar nome completo ao passar o mouse
                card_medico.add(nameLabel, gbc);
                
                // Configurar constraints para o specialtyLabel
                gbc.gridx = 1;
                JLabel specialtyLabel = new JLabel("Especialidade: " + medico.getEspecialidade());
                specialtyLabel.setPreferredSize(new Dimension(215, 20));        // Limitar o tamanho
                specialtyLabel.setToolTipText(medico.getEspecialidade());       // Mostrar especialidade completa ao passar o mouse
                card_medico.add(specialtyLabel, gbc);
                
                // Configurar constraints para o buttonPanel
                gbc.gridx = 2;                                  // Mover para a terceira coluna
                gbc.weightx = 1.0;                              // O botão empurrará o conteúdo para a esquerda
                gbc.anchor = GridBagConstraints.EAST;           // Alinhar à direita
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
                
                JButton updateButton = new JButton("Atualizar");
                JButton deleteButton = new JButton("Deletar");
                JButton infoButton = new JButton("Informações");
                
                infoButton.addActionListener(e -> {
                    showInformationMedico(medico);
                });
                
                updateButton.addActionListener(e -> {
                    CadAutMedico cadastrarMedico = new CadAutMedico(gerenciadorAdm, em);
                    cadastrarMedico.setMedico(medico);
                    cadastrarMedico.setBtnText("Atualizar");
                    cadastrarMedico.setVisible(true);
                    this.dispose();
                });
                
                deleteButton.addActionListener(e -> {
                    int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja deletar o médico " + medico.getNome() + "?", 
                        "Confirmar Exclusão", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                    
                    if (dialogResult == JOptionPane.YES_OPTION){
                        String result = this.gerenciadorAdm.removerMedico(medico.getId());
                        if (result.equals("Médico removido!")) {
                            updateSearch(); // Atualiza a lista após a exclusão
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                        } else {
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
                card_medico.add(buttonPanel, gbc);

                this.box_medicos.add(card_medico);
                this.box_medicos.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre cards
            }
        }

        // Revalidar e repintar para atualizar o JScrollPane
        this.box_medicos.revalidate();
        this.box_medicos.repaint();
    }
    
    /**
     * Volta para a tela principal de administração.
     * 
     * @param evt o evento de clique do botão
     */
    private void back_menuPrincipalAdm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuPrincipalAdm
        MenuPrincipalAdm menuPrincipalAdm = new MenuPrincipalAdm(gerenciadorAdm, em);
        menuPrincipalAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_menuPrincipalAdm

    /**
     * Abre a tela para cadastrar um novo médico.
     * 
     * @param evt o evento de clique do botão
     */
    private void goCadastrarMedico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goCadastrarMedico
        CadAutMedico cadastrarMedico = new CadAutMedico(gerenciadorAdm, em);
        cadastrarMedico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goCadastrarMedico
    
    /**
     * Atualiza a lista de médicos com base no texto de busca.
     */
    private void updateSearch() {
        String searchText = jTextField1.getText().trim();
        List<Medico> filteredMedicos;
        if (searchText.isEmpty()) {
            filteredMedicos = gerenciadorAdm.getAllMedicos();
        } else {
            filteredMedicos = gerenciadorAdm.buscarMedicos(searchText);
            System.out.println(filteredMedicos);
        }
        renderMedicos(filteredMedicos);
    }
    
    /**
     * Configura o campo de busca para atualizar a lista de médicos quando o texto é alterado.
     */
    private void setupSearchField() {
        jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
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
    
    // Variáveis de declaração - não modificar
    private javax.swing.JPanel box_medicos;
    private java.awt.Button cadastrarMedico;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // Fim da declaração de variáveis
}