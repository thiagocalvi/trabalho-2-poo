package InterfacesGraficas;


import Gerenciador.GerenciadorAdm;
import Modelo.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

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
        setLocationRelativeTo(null);
    }

    /**
     * Define o texto do botão e ajusta o título da janela para refletir a operação (Cadastrar ou Atualizar).
     * 
     * @param Cad_Atu o texto que será exibido no botão (Cadastrar ou Atualizar)
     */
    public void configureDisplay(String Cad_Atu){
        this.Cad_Atu = Cad_Atu;
        btnRegister.setText(Cad_Atu);
        lblSubTitulo.setText("Atualizar médico");
        setTitle("Administrador - Atualizar médico");
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
    
       /**
     * Configura a lista de secretarias no JComboBox.
     * Adiciona todas as secretarias ao JComboBox para seleção.
     */
    private void setSecretarias(){
        CBoxSecretaria.removeAllItems();
        CBoxSecretaria.addItem("Selecione uma secretaria");
        CBoxSecretaria.setSelectedItem("Selecione uma secretaria");
        
        for(Secretaria secretaria : this.allSecretarias){
            CBoxSecretaria.addItem(secretaria.getNome());
        }
    }
    
    /**
     * Preenche os campos da interface com os dados do médico quando a operação é de atualização.
     * Configura os valores dos campos baseados no objeto Medico fornecido.
     */
    private void setValues(){
        CBoxSecretaria.removeAllItems();
        CBoxSecretaria.addItem("Selecione uma secretaria");

        nome_medico.setText(this.medico.getNome());

        especialidade_medico.setText(this.medico.getEspecialidade());

        telefone_medico.setText(this.medico.getTelefone());

        email_medico.setText(this.medico.getEmail());

        crm_medico.setText(Integer.toString(this.medico.getCrm()));

        dataNascimento_medico.setText(this.medico.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        if (this.medico.getGenero().equals("Masculino")) {
            genero_m_medico.setSelected(true);
        } else {
            genero_f_medico.setSelected(true);
        }

        for (Secretaria secretaria : this.allSecretarias) {
            CBoxSecretaria.addItem(secretaria.getNome());
        }

        if (this.medico.getSecretaria() == null) {
            CBoxSecretaria.setSelectedItem("Selecione uma secretaria");
        } else {
            CBoxSecretaria.setSelectedItem(medico.getSecretaria().getNome());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        lblSubTitulo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CBoxSecretaria = new javax.swing.JComboBox<>();
        btnRegister = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        genero_m_medico = new javax.swing.JRadioButton();
        genero_f_medico = new javax.swing.JRadioButton();
        especialidade_medico = new javax.swing.JTextPane();
        btnBack = new javax.swing.JButton();
        nome_medico = new javax.swing.JTextPane();
        telefone_medico = new javax.swing.JTextPane();
        email_medico = new javax.swing.JTextPane();
        crm_medico = new javax.swing.JTextPane();
        dataNascimento_medico = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador - Cadastrar médico");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(780, 500));
        setMinimumSize(new java.awt.Dimension(780, 500));
        setResizable(false);

        panel1.setPreferredSize(new java.awt.Dimension(780, 500));

        lblSubTitulo.setBackground(new java.awt.Color(255, 204, 102));
        lblSubTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblSubTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubTitulo.setText("Cadastrar médico");
        lblSubTitulo.setOpaque(true);

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
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("CRM:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Email:");

        CBoxSecretaria.setBackground(new java.awt.Color(255, 255, 255));
        CBoxSecretaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CBoxSecretaria.setForeground(new java.awt.Color(0, 0, 0));
        CBoxSecretaria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma secretaria", "Item 2", "Item 3", "Item 4" }));
        CBoxSecretaria.setToolTipText("");

        btnRegister.setBackground(new java.awt.Color(0, 204, 0));
        btnRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Cadastar");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_Cad_Atu_medico(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Gênero:");

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

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuMedicosAdm(evt);
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
                        .addContainerGap(124, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(email_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefone_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crm_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
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
                                    .addComponent(nome_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(especialidade_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(CBoxSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(lblSubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(CBoxSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     * Cadastra ou atualiza um médico com base nas informações fornecidas nos campos da interface gráfica.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_Cad_Atu_medico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_Cad_Atu_medico
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

        nomeSecretaria = (String) CBoxSecretaria.getSelectedItem();

        if (!("Selecione uma secretaria".equals(nomeSecretaria))) {
            // Busca a secretaria correspondente
            for (Secretaria secretaria : this.allSecretarias) {
                if (secretaria.getNome().equals(nomeSecretaria)) {
                    secretariaObj = secretaria;
                    break;  // Encontre a secretaria e saia do loop
                }
            }
        }

        if (this.Cad_Atu.equals("Atualizar")){
            if(secretariaObj == null){
                int dialogResultSecNull = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja deixar o médico 'SEM' secretaria?",
                    "Confirmar Ação",
                    JOptionPane.YES_NO_OPTION);
                if(dialogResultSecNull == JOptionPane.YES_OPTION){
                    int dialogResult = JOptionPane.showConfirmDialog(this,
                        "Tem certeza que deseja 'ATUALIZAR' o médico " + this.medico.getNome() + "?",
                        "Confirmar Atualização",
                        JOptionPane.YES_NO_OPTION);

                    if (dialogResult == JOptionPane.YES_OPTION){
                        this.gerenciadorAdm.atualizarMedico(this.medico, secretariaObj, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, especialidade, Integer.parseInt(crm), genero);
                        MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(gerenciadorAdm, em);
                        menuMedicoAdm.setVisible(true);
                        this.dispose();
                    }
                }
            } else {
                int dialogResult = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja 'ATUALIZAR' o médico " + this.medico.getNome() + "?",
                    "Confirmar Atualização",
                    JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION){
                    this.gerenciadorAdm.atualizarMedico(this.medico, secretariaObj, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, especialidade, Integer.parseInt(crm), genero);
                    MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(gerenciadorAdm, em);
                    menuMedicoAdm.setVisible(true);
                    this.dispose();
                }
            }
        } else {
            if(secretariaObj == null){
                int dialogResultSecNull = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja deixar o médico 'SEM' secretaria?",
                    "Confirmar Ação",
                    JOptionPane.YES_NO_OPTION);
                if(dialogResultSecNull == JOptionPane.YES_OPTION){
                    int dialogResult = JOptionPane.showConfirmDialog(this,
                        "Tem certeza que deseja 'CADASTRAR' o médico Dr. "+ nome +"?",
                        "Confirmar Cadastro",
                        JOptionPane.YES_NO_OPTION);

                    if (dialogResult == JOptionPane.YES_OPTION){
                        this.gerenciadorAdm.cadastrarMedico(secretariaObj, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, especialidade, Integer.parseInt(crm), genero);
                        MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(gerenciadorAdm, em);
                        menuMedicoAdm.setVisible(true);
                        this.dispose();
                    }
                }
            } else {
                int dialogResult = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja 'CADASTRAR' o médico Dr. "+ nome +"?",
                    "Confirmar Cadastro",
                    JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION){
                    this.gerenciadorAdm.cadastrarMedico(secretariaObj, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, especialidade, Integer.parseInt(crm), genero);
                    MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(gerenciadorAdm, em);
                    menuMedicoAdm.setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_go_Cad_Atu_medico

    /**
     * Navega de volta para a janela do menu de médicos.
     * 
     * @param evt o evento de clique do botão
     */
    private void back_menuMedicosAdm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuMedicosAdm
        MenuMedicosAdm menuMedicoAdm = new MenuMedicosAdm(gerenciadorAdm, em);
        menuMedicoAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_menuMedicosAdm

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBoxSecretaria;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextPane crm_medico;
    private javax.swing.JTextPane dataNascimento_medico;
    private javax.swing.JTextPane email_medico;
    private javax.swing.JTextPane especialidade_medico;
    private javax.swing.JRadioButton genero_f_medico;
    private javax.swing.JRadioButton genero_m_medico;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JTextPane nome_medico;
    private java.awt.Panel panel1;
    private javax.swing.JTextPane telefone_medico;
    // End of variables declaration//GEN-END:variables
}
