/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;
import Gerenciador.GerenciadorAdm;
import Modelo.Medico;
import Modelo.Secretaria;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author matheus
 */
public class CadastrarMedico extends javax.swing.JFrame {
    private GerenciadorAdm gerenciadorAdm; 
    private String Cad_Atu = "Cadastrar";
    private Medico medico;
    List<Secretaria> allSecretarias;
    
  
    // Construtor
    public CadastrarMedico(GerenciadorAdm gerenciadorAdm) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.allSecretarias = this.gerenciadorAdm.getAllSecretarias();
        initComponents();
        setSecretarias();
    }

    // Métodos set's
    public void setBtnText(String Cad_Atu){
        this.Cad_Atu = Cad_Atu;
        BtnCadastrar.setText(Cad_Atu);
        jLabel4.setText("Atualizar Médico");
        setTitle("Atualizar Médico");
        setValues();
    } 
            
    public void setMedico(Medico medico){
        this.medico = medico;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        BtnCadastrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        genero_m_medico = new javax.swing.JRadioButton();
        genero_f_medico = new javax.swing.JRadioButton();
        especialidade_medico = new javax.swing.JTextPane();
        voltar = new javax.swing.JButton();
        nome_medico = new javax.swing.JTextPane();
        telefone_medico = new javax.swing.JTextPane();
        email_medico = new javax.swing.JTextPane();
        crm_medico = new javax.swing.JTextPane();
        dataNascimento_medico = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastar Medico");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jLabel4.setBackground(new java.awt.Color(255, 204, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cadastrar Médico");
        jLabel4.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nome:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Especialidade:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Telefone:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CRM:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Email:");

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma secretaria", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setToolTipText("");

        BtnCadastrar.setBackground(new java.awt.Color(0, 204, 0));
        BtnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnCadastrar.setText("Cadastar");
        BtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastarMedico(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Genero:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Data nascimento (dd/mm/aaaa):");

        buttonGroup1.add(genero_m_medico);
        genero_m_medico.setText("Masculino");

        buttonGroup1.add(genero_f_medico);
        genero_f_medico.setText("Feminino");

        especialidade_medico.setBackground(new java.awt.Color(204, 204, 204));

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarJanela(evt);
            }
        });

        nome_medico.setBackground(new java.awt.Color(204, 204, 204));

        telefone_medico.setBackground(new java.awt.Color(204, 204, 204));

        email_medico.setBackground(new java.awt.Color(204, 204, 204));

        crm_medico.setBackground(new java.awt.Color(204, 204, 204));

        dataNascimento_medico.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascimento_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genero_m_medico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genero_f_medico)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(crm_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(especialidade_medico))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefone_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(72, Short.MAX_VALUE))))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(BtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltar)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nome_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(especialidade_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(telefone_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(email_medico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crm_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataNascimento_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genero_m_medico)
                    .addComponent(genero_f_medico))
                .addGap(47, 47, 47)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(voltar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Ações
    private void voltarJanela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarJanela
        MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(this.gerenciadorAdm);
        menuMedicoAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarJanela

    private void cadastarMedico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastarMedico

        String nome, especialidade, telefone, email, crm, dataNascimento, genero = null, nomeSecretaria;
        Secretaria secretariaObj = null;
        
        nome = nome_medico.getText();
        especialidade = especialidade_medico.getText();
        telefone = telefone_medico.getText();  
        email = email_medico.getText();        
        crm = crm_medico.getText();
        dataNascimento = dataNascimento_medico.getText();
        
        
        if (genero_m_medico.isSelected()) {
            genero = "Masculino";
        } else if (genero_f_medico.isSelected()) {
            genero = "Feminino";
        }
        
        
        nomeSecretaria = (String) jComboBox1.getSelectedItem();
        
        
        if (!("Selecione uma secretaria".equals(nomeSecretaria))) {
            // Busca a secretaria correspondente
            for (Secretaria secretaria : this.allSecretarias) {
                if (secretaria.getNome().equals(nomeSecretaria)) {
                    secretariaObj = secretaria;
                    break;  // Encontre a secretaria e saia do loop

                }
            }
        }
        
        MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(this.gerenciadorAdm);
        if (this.Cad_Atu.equals("Atualizar")){
            if(secretariaObj == null){
                int dialogResultSecNull = JOptionPane.showConfirmDialog(this, 
                            "Tem certeza que deseja deixar o médico sem secretaria?", 
                            "Confirmar Ação", 
                            JOptionPane.YES_NO_OPTION);
                if(dialogResultSecNull == JOptionPane.YES_OPTION){
                    int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja atualizar o médico " + this.medico.getNome() + "?", 
                        "Confirmar Atualização", 
                    JOptionPane.YES_NO_OPTION);

                    if (dialogResult == JOptionPane.YES_OPTION){
                        this.gerenciadorAdm.atualizarMedico(this.medico, secretariaObj, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, especialidade, Integer.parseInt(crm), genero);
                        menuMedicoAdm.setVisible(true);
                        this.dispose();
                    }
                }

            }else{
                int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja atualizar o médico " + this.medico.getNome() + "?", 
                        "Confirmar Atualização", 
                    JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION){
                    this.gerenciadorAdm.atualizarMedico(this.medico, secretariaObj, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, especialidade, Integer.parseInt(crm), genero);
                    menuMedicoAdm.setVisible(true);
                    this.dispose();
                }
            }
        } else {
            if(secretariaObj == null){
                int dialogResultSecNull = JOptionPane.showConfirmDialog(this, 
                            "Tem certeza que deseja deixar o médico sem secretaria?", 
                            "Confirmar Ação", 
                            JOptionPane.YES_NO_OPTION);
                if(dialogResultSecNull == JOptionPane.YES_OPTION){
                    int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja cadastrar o médico Dr. "+ nome +"?", 
                        "Confirmar Cadastro", 
                        JOptionPane.YES_NO_OPTION);

                    if (dialogResult == JOptionPane.YES_OPTION){
                        this.gerenciadorAdm.cadastrarMedico(secretariaObj, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, especialidade, Integer.parseInt(crm), genero);
                        menuMedicoAdm.setVisible(true);
                        this.dispose();
                    }
                }

            }else{
                int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja cadastrar o médico Dr. "+ nome +"?", 
                        "Confirmar Cadastro", 
                        JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION){
                    this.gerenciadorAdm.cadastrarMedico(secretariaObj, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, especialidade, Integer.parseInt(crm), genero);
                    menuMedicoAdm.setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_cadastarMedico
    
    // Métodos
    private void setSecretarias(){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Selecione uma secretaria");
        jComboBox1.setSelectedItem("Selecione uma secretaria");
        
        for(Secretaria secretaria : this.allSecretarias){
            jComboBox1.addItem(secretaria.getNome());
        }
    }
    
    private void setValues(){
        if (this.Cad_Atu.equals("Atualizar")){
            jComboBox1.removeAllItems();
            jComboBox1.addItem("Selecione uma secretaria");
        
            nome_medico.setText(this.medico.getNome());

            especialidade_medico.setText(this.medico.getEspecialidade());

            telefone_medico.setText(this.medico.getTelefone());
        
            email_medico.setText(this.medico.getEmail());

            crm_medico.setText( Integer.toString(this.medico.getCrm()));

            dataNascimento_medico.setText(this.medico.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            if(this.medico.getGenero().equals("Masculino")){
                genero_m_medico.setSelected(true);

            }else{
                genero_f_medico.setSelected(true);
            }

            for(Secretaria secretaria : this.allSecretarias){
                jComboBox1.addItem(secretaria.getNome());
            }

            if(this.medico.getSecretaria() == null){
                jComboBox1.setSelectedItem("Selecione uma secretaria");

            }else{
                jComboBox1.setSelectedItem(medico.getSecretaria().getNome());

            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextPane crm_medico;
    private javax.swing.JTextPane dataNascimento_medico;
    private javax.swing.JTextPane email_medico;
    private javax.swing.JTextPane especialidade_medico;
    private javax.swing.JRadioButton genero_f_medico;
    private javax.swing.JRadioButton genero_m_medico;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextPane nome_medico;
    private java.awt.Panel panel1;
    private javax.swing.JTextPane telefone_medico;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
