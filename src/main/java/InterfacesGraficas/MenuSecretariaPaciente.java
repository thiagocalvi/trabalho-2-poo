/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

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
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *Descrição generica
 * 
 * @author matheus
 */
public class MenuSecretariaPaciente extends javax.swing.JFrame {
    private List<Paciente> allPacientes;
    private GerenciadorAdm gerenciadorAdm; //É necessariao pois estamos dando um dispose nas telas
    private EntityManager em;
    private Secretaria secretaria;
    /**
     * Creates new form RelatorioMensalMedico
     */
    public MenuSecretariaPaciente(Secretaria secretaria, GerenciadorAdm gerenciadorAdm, EntityManager em) {
        initComponents();
        this.secretaria = secretaria;
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        this.renderPacientes(secretaria.getAllPacientes());
        setupSearchField();
        
        setLocationRelativeTo(null);
    }

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

        String[] labels = {"ID:", "Nome:", "Idade" , "Genero:", "Data nascimento:", "Telefone:", "Email:", "Endereço:", "Convenio:"};
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
            JLabel value = new JLabel(values[i]);

            gbc.gridx = 0;
            gbc.gridy = i;
            infoPanel.add(label, gbc);

            gbc.gridx = 1;
            gbc.weightx = 1;
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
        jTextField1 = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        cadastrarPaciente = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        box_pacientes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
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

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cadastrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(cadastrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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

    private void backMenuPrincipalSecretaria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backMenuPrincipalSecretaria
        MenuPrincipalSecretaria menuPrincipalSecretaira = new MenuPrincipalSecretaria(secretaria, gerenciadorAdm, em);
        menuPrincipalSecretaira.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMenuPrincipalSecretaria

        
    private void renderPacientes(List<Paciente> pacientesToRender) {

        // Configurar o layout do box_medicos para vertical
        this.box_pacientes.setLayout(new BoxLayout(this.box_pacientes, BoxLayout.Y_AXIS));

        // Definir um tamanho preferido para o box_medicos
        this.box_pacientes.setPreferredSize(new Dimension(780, pacientesToRender.size() * 50));

        // Limpar o painel antes de adicionar novos médicos
        this.box_pacientes.removeAll();

        if (pacientesToRender.isEmpty()) {
            JLabel noMedicosLabel = new JLabel("Não há pacientes cadastrados.");
            this.box_pacientes.add(noMedicosLabel);
        } else {
            for (Paciente paciente : pacientesToRender) {
                JPanel card_paciente = new JPanel();
                card_paciente.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
                card_paciente.setMaximumSize(new Dimension(780, 40));

                JLabel nameLabel = new JLabel("Nome: " + paciente.getNome());
                
                JButton updateButton = new JButton("Atualizar");
                JButton deleteButton = new JButton("Deletar");
                JButton infoButton = new JButton("Informações");

                
                infoButton.addActionListener(e -> {
                    showInformationPaciente(paciente);
                });                
                
                //TO-DO
                //Leva para pagina de atualização
                //o objeto paciente que vai ser atualuzado é passado como parametro
                updateButton.addActionListener(e -> {
                    CadAutPaciente cadastrarPaciente = new CadAutPaciente(secretaria, gerenciadorAdm, em);
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
                    
                    if (dialogResult == JOptionPane.YES_OPTION){
                        String result = this.secretaria.removerPaciente(paciente.getId());
                        if (result.equals("Paciente removido!")) {
                            updateSearch(); // Atualiza a lista após a exclusão
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            System.out.println(result);
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                        }
                    }
                
                });

                card_paciente.add(nameLabel);
                //card_paciente.add(specialtyLabel);
                card_paciente.add(updateButton);
                card_paciente.add(deleteButton);
                card_paciente.add(infoButton);


                this.box_pacientes.add(card_paciente);
                this.box_pacientes.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre cards
            }
        }

        // Revalidar e repintar para atualizar o JScrollPane
        this.box_pacientes.revalidate();
        this.box_pacientes.repaint();
    }
    
    
     private void updateSearch() {
        //Isso não é nenhum pouco eficiente!
        String searchText = jTextField1.getText().toLowerCase();
        this.allPacientes = this.secretaria.getAllPacientes();
        List<Paciente> filteredPacientes = allPacientes.stream()
            .filter(paciente -> 
                paciente.getNome().toLowerCase().contains(searchText))
            .collect(Collectors.toList());
        renderPacientes(filteredPacientes);
    }
     
     
     private void setupSearchField(){
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
    
    private void goCadastrarPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goCadastrarPaciente
        // TODO add your handling code here:
        CadAutPaciente cadastrarPaciente = new CadAutPaciente(secretaria, gerenciadorAdm, em);
        cadastrarPaciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goCadastrarPaciente


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box_pacientes;
    private java.awt.Button cadastrarPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
