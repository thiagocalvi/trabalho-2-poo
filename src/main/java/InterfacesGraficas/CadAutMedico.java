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
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
/**
 *Descrição generica
 * @author matheus
 */
/**
 * Classe responsável pela interface gráfica para cadastro e atualização de médicos.
 * Permite cadastrar um novo médico ou atualizar um médico existente, incluindo a seleção de uma secretaria.
 * 
 * @author matheus
 */
public class CadAutMedico extends javax.swing.JFrame {
    
    private GerenciadorAdm gerenciadorAdm;
    private EntityManager em;
    private String Cad_Atu = "Cadastrar";
    private Medico medico;
    List<Secretaria> allSecretarias;
    
    /**
     * Construtor da classe.
     * Inicializa o gerenciador de administração e o EntityManager, carrega todas as secretarias e configura os componentes da interface.
     * 
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações de CRUD
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public CadAutMedico(GerenciadorAdm gerenciadorAdm, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        this.allSecretarias = this.gerenciadorAdm.getAllSecretarias();
        initComponents();
        setSecretarias();
    }

    /**
     * Define o texto do botão e ajusta o título da janela para refletir a operação (Cadastrar ou Atualizar).
     * 
     * @param Cad_Atu o texto que será exibido no botão (Cadastrar ou Atualizar)
     */
    public void setBtnText(String Cad_Atu){
        this.Cad_Atu = Cad_Atu;
        BtnCadastrar.setText(Cad_Atu);
        jLabel4.setText("Atualizar Médico");
        setTitle("Atualizar Médico");
        setValues();
    } 
            
    /**
     * Define o médico que será atualizado.
     * 
     * @param medico o objeto Medico que será atualizado
     */
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
        setTitle("Cadastar Médico");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(525, 150));
        setMaximumSize(new java.awt.Dimension(780, 500));
        setMinimumSize(new java.awt.Dimension(780, 500));
        setResizable(false);

        panel1.setPreferredSize(new java.awt.Dimension(780, 500));

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
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma secretaria", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setToolTipText("");

        BtnCadastrar.setBackground(new java.awt.Color(0, 204, 0));
        BtnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        genero_m_medico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genero_m_medico.setText("Masculino");

        buttonGroup1.add(genero_f_medico);
        genero_f_medico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genero_f_medico.setText("Feminino");

        especialidade_medico.setBackground(new java.awt.Color(204, 204, 204));
        especialidade_medico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        especialidade_medico.setForeground(new java.awt.Color(0, 0, 0));

        voltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_Action(evt);
            }
        });

        nome_medico.setBackground(new java.awt.Color(204, 204, 204));
        nome_medico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nome_medico.setForeground(new java.awt.Color(0, 0, 0));

        telefone_medico.setBackground(new java.awt.Color(204, 204, 204));
        telefone_medico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telefone_medico.setForeground(new java.awt.Color(0, 0, 0));

        email_medico.setBackground(new java.awt.Color(204, 204, 204));
        email_medico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email_medico.setForeground(new java.awt.Color(0, 0, 0));

        crm_medico.setBackground(new java.awt.Color(204, 204, 204));
        crm_medico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crm_medico.setForeground(new java.awt.Color(0, 0, 0));

        dataNascimento_medico.setBackground(new java.awt.Color(204, 204, 204));
        dataNascimento_medico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataNascimento_medico.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(email_medico, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                            .addComponent(telefone_medico)
                            .addComponent(crm_medico)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nome_medico, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                                    .addComponent(especialidade_medico)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(dataNascimento_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(411, 411, 411))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(genero_m_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(genero_f_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(470, 470, 470)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(BtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(nome_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(especialidade_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(telefone_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(email_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(crm_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataNascimento_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genero_m_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genero_f_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Navega de volta para a janela do menu de médicos.
     * 
     * @param evt o evento de clique do botão
     */
    private void voltarJanela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarJanela
        MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(gerenciadorAdm, em);
        menuMedicoAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarJanela

    /**
     * Cadastra ou atualiza um médico com base nas informações fornecidas nos campos da interface gráfica.
     * 
     * @param evt o evento de clique do botão
     */
    
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

        MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(gerenciadorAdm, em);
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

    private void voltar_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_Action
        MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(gerenciadorAdm, em);
        menuMedicoAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltar_Action

   
    // Métodos
    /**
     * Configura a lista de secretarias no JComboBox.
     * Adiciona todas as secretarias ao JComboBox para seleção.
     */
    private void setSecretarias(){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Selecione uma secretaria");
        jComboBox1.setSelectedItem("Selecione uma secretaria");
        
        for(Secretaria secretaria : this.allSecretarias){
            jComboBox1.addItem(secretaria.getNome());
        }
    }
    
    /**
     * Preenche os campos da interface com os dados do médico quando a operação é de atualização.
     * Configura os valores dos campos baseados no objeto Medico fornecido.
     */
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
