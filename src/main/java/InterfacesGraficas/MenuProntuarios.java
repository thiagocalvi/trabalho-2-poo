/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Medico;
import Modelo.Prontuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *Descrição generica
 * @author matheus
 */
public class MenuProntuarios extends javax.swing.JFrame {
    // Atríbutos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Consulta consulta;
    private EntityManager em;
    
    // Construtor
    public MenuProntuarios(GerenciadorAdm gerenciadorAdm, Medico medico, Consulta consulta, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.medico = medico;
        this.consulta = consulta;
        this.em = em;
        initComponents();
        setNome();
        listarProntuario();
        setLocationRelativeTo(null);
    }

    private void setNome(){
        lblPac.setText(" " + consulta.getPaciente().getNome());
        lblMed.setText(" " + medico.getNome());
    }
    
    private void listarProntuario(){
        
        String prontuario ="SELECT p FROM Prontuario p " +
                            "JOIN p.consulta c " +
                            "WHERE p.paciente = :paciente AND c.medico = :medico";
        
        TypedQuery<Prontuario> query = em.createQuery(prontuario, Prontuario.class);
        query.setParameter("paciente", consulta.getPaciente());
        query.setParameter("medico", consulta.getMedico());
    
        
        List<Prontuario> listProntuario = query.getResultList();
        renderProntuarios(listProntuario);
    }
    
    
    private void showInformationProntuario(Prontuario prontuario) {
        JDialog dialog = new JDialog(this, prontuario.getPaciente().getNome(), true);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(400, 250));
        
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] labels = {"ID:", "Paciente:", "Sintomas:", "Diagnostico:", "Tratamento:"};
        String[] values = {
            String.valueOf(prontuario.getId()),
            prontuario.getPaciente().getNome(),
            prontuario.getSintomas(),
            prontuario.getDiagnostico(),
            prontuario.getTratamento()
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
   
    
    private void renderProntuarios(List<Prontuario> prontuarioToRender){
        
        // Configurar o layout do boxProntuario para vertical
        this.boxProntuario.setLayout(new BoxLayout(this.boxProntuario, BoxLayout.Y_AXIS));
        
        // Definir um tamanho preferido para o box_medicos
        this.boxProntuario.setPreferredSize(new Dimension(780, prontuarioToRender.size() * 50));

        // Limpar o painel antes de adicionar novos médicos
        this.boxProntuario.removeAll();        
        
        if (prontuarioToRender.isEmpty()) {
            JLabel noProntuariosLabel = new JLabel("Não há prontuarios cadastrados.");
            this.boxProntuario.add(noProntuariosLabel);
        } else {       
            for (Prontuario prontuario : prontuarioToRender) {
                
                JPanel card_prontuario = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                card_prontuario.setMaximumSize(new Dimension(780, 40));

                // Configurar constraints para o nameLabel
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(5, 5, 5, 5);
                
                JLabel tipoLabel = new JLabel("Tipo: " + prontuario.getConsulta().getTipo().toString());
                tipoLabel.setPreferredSize(new Dimension(215, 20));             // Limitar o tamanho
                card_prontuario.add(tipoLabel, gbc);                
                
                gbc.gridx = 1;
                JLabel dataLabel = new JLabel("Data: " + prontuario.getConsulta().getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                dataLabel.setPreferredSize(new Dimension(215, 20));             // Limitar o tamanho
                card_prontuario.add(dataLabel, gbc);
                
                // Configurar constraints para o buttonPanel
                gbc.gridx = 2;                                                  // Mover para a terceira coluna
                gbc.weightx = 1.0;                                              // O botão empurrará o conteúdo para a esquerda
                gbc.anchor = GridBagConstraints.EAST;                           // Alinhar à direita
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
                
                JButton updateButton = new JButton("Atualizar");
                JButton deleteButton = new JButton("Deletar");
                JButton infoButton = new JButton("Informações");
         
                infoButton.addActionListener(e -> {
                    showInformationProntuario(prontuario);
                });                   
                
                updateButton.addActionListener(e -> {
                    CadAutProntuario cadAutProntuario = new CadAutProntuario(gerenciadorAdm, medico, consulta, em);
                    cadAutProntuario.setAtualizar("Atualizar");
                    cadAutProntuario.setVisible(true);
                    this.dispose();
                });
                
                deleteButton.addActionListener(e -> {
                    int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja deletar o prontuário? " , 
                        "Confirmar Exclusão", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                    
                    if (dialogResult == JOptionPane.YES_OPTION){
                        String result = medico.removerProntuario(prontuario.getId());
                        if (result.equals("Prontuario removido!")) {
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                            listarProntuario();
                            
                            this.em.getTransaction().begin();
                            consulta.setProntuario(null);
                            em.merge(consulta);
                            this.em.getTransaction().commit();
                            
                        }else {
                            System.out.println(result);
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });                

                
                if (consulta.getProntuario().equals(prontuario)){
                    buttonPanel.add(updateButton);
                    buttonPanel.add(deleteButton);
                    buttonPanel.add(infoButton);
                }
                else {
                    buttonPanel.add(deleteButton);
                    buttonPanel.add(infoButton);
                }   
                
                card_prontuario.add(buttonPanel, gbc);

                this.boxProntuario.add(card_prontuario);
                this.boxProntuario.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
        this.boxProntuario.revalidate();
        this.boxProntuario.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMed = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPac = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddPron = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        boxProntuario = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Médico - Prontuário");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        lblMed.setBackground(new java.awt.Color(255, 255, 255));
        lblMed.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMed.setForeground(new java.awt.Color(0, 0, 0));
        lblMed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMed.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMed, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMed, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Prontuário do paciente");
        jLabel5.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lblPac.setBackground(new java.awt.Color(255, 255, 255));
        lblPac.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPac.setForeground(new java.awt.Color(0, 0, 0));
        lblPac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPac.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Paciente:");

        btnAddPron.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddPron.setText("Adicionar prontuário");
        btnAddPron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPron_Action(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar_Action(evt);
            }
        });

        boxProntuario.setBackground(new java.awt.Color(255, 255, 255));
        boxProntuario.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout boxProntuarioLayout = new javax.swing.GroupLayout(boxProntuario);
        boxProntuario.setLayout(boxProntuarioLayout);
        boxProntuarioLayout.setHorizontalGroup(
            boxProntuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );
        boxProntuarioLayout.setVerticalGroup(
            boxProntuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(boxProntuario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lblPac, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAddPron, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPac, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddPron, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltar_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar_Action
        ConsultaDoPaciente consultaDoPaciente = new ConsultaDoPaciente(gerenciadorAdm, medico, consulta, em);
        consultaDoPaciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltar_Action

    private void btnAddPron_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPron_Action
        if (consulta.getProntuario() == null){
            CadAutProntuario cadAutProntuario = new CadAutProntuario(gerenciadorAdm, medico, consulta, em);
            cadAutProntuario.setVisible(true);
            this.dispose();
        } 
        else {
            JOptionPane.showMessageDialog(null, "Você já 'CADASTROU' um prontuário!\n Limite de 1 cadastro por consulta!", 
                                                "Aviso", 
                                                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddPron_Action


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boxProntuario;
    private javax.swing.JButton btnAddPron;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMed;
    private javax.swing.JLabel lblPac;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
