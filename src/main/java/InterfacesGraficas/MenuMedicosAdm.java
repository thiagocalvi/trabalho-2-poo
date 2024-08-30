/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;
import Gerenciador.GerenciadorAdm;
import javax.swing.*;
import java.awt.*;

import java.util.List;

import Modelo.Medico;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
/**
 *
 * @author thiago
 */
public class MenuMedicosAdm extends javax.swing.JFrame {
    
    private MenuPrincipalAdm menuPrincipalAdm;
    private GerenciadorAdm gerenciadorAdm;
    private List<Medico> allMedicos;
    
    public MenuMedicosAdm(GerenciadorAdm gerenciadorAdm) {
        initComponents();
        this.gerenciadorAdm = gerenciadorAdm; 
        this.renderMedicos(gerenciadorAdm.getAllMedicos());
        setupSearchField();
    }
    
    
    
    public void setMenuPrincipalAdm(MenuPrincipalAdm menuPrincipalAdm){
        this.menuPrincipalAdm = menuPrincipalAdm;
    }
    
    public void setGerenciadorAdm(GerenciadorAdm gerenciadorAdm){
        this.gerenciadorAdm = gerenciadorAdm;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        button1 = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        box_medicos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Médicos");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Médicos");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuPrincipalAdm(evt);
            }
        });

        button1.setBackground(new java.awt.Color(153, 153, 153));
        button1.setLabel("Adicionar Médico");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label2.setText("Pesquisar por Nome/CRM/Especialidade:");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(320, 320, 320))))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void renderMedicos(List<Medico> medicosToRender) {
        //this.allMedicos = this.gerenciadorAdm.getAllMedicos();

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
                JPanel card_medico = new JPanel();
                card_medico.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
                card_medico.setMaximumSize(new Dimension(780, 40));

                JLabel nameLabel = new JLabel("Nome: " + medico.getNome());
                JLabel specialtyLabel = new JLabel("Especialidade: " + medico.getEspecialidade());

                JButton updateButton = new JButton("Atualizar");
                JButton deleteButton = new JButton("Deletar");
                JButton infoButton = new JButton("Informações");

                
                infoButton.addActionListener(e -> {
                    showInformationMedico(medico);
                });                
                
                //TO-DO
                //Leva para pagina de atualização
                //o objeto medico que vai ser atualuzado é passado como parametro
                updateButton.addActionListener(e -> System.out.println("Atualizar médico com ID: " + medico.getId()));
                
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
                        }else {
                            System.out.println(result);
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                        }
                    }
                
                });

                card_medico.add(nameLabel);
                card_medico.add(specialtyLabel);
                card_medico.add(updateButton);
                card_medico.add(deleteButton);
                card_medico.add(infoButton);


                this.box_medicos.add(card_medico);
                this.box_medicos.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre cards
            }
        }

        // Revalidar e repintar para atualizar o JScrollPane
        this.box_medicos.revalidate();
        this.box_medicos.repaint();
    }
     
    
    private void back_menuPrincipalAdm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuPrincipalAdm

        this.setVisible(false);
        this.menuPrincipalAdm.setVisible(true);        
    }//GEN-LAST:event_back_menuPrincipalAdm

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed
    
 
    private void updateSearch() {
        //Isso não é nenhum pouco eficiente!
        String searchText = jTextField1.getText().toLowerCase();
        this.allMedicos = gerenciadorAdm.getAllMedicos();
        List<Medico> filteredMedicos = allMedicos.stream()
            .filter(medico -> 
                medico.getNome().toLowerCase().contains(searchText) ||
                Integer.toString(medico.getCrm()).contains(searchText) ||
                medico.getEspecialidade().toLowerCase().contains(searchText))
            .collect(Collectors.toList());
        renderMedicos(filteredMedicos);
    }
    
    /*
    Assim não funciona corretamente, o textFild fica bugado
    O sentidod da escrita é invertido
    private void updateSearch() {
        String searchText = jTextField1.getText().trim();
        List<Medico> filteredMedicos;
        if (searchText.isEmpty()) {
            filteredMedicos = gerenciadorAdm.getAllMedicos();
        } else {
            filteredMedicos = gerenciadorAdm.buscarMedicos(searchText);
        }
        renderMedicos(filteredMedicos);
    }
    */
    
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box_medicos;
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
