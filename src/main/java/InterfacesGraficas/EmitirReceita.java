package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Medico;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Tela para emissão de receitas médicas.
 * Permite ao médico gerar uma receita médica para uma consulta específica,
 * preenchendo os campos necessários.
 * 
 * @author matheus
 */
public class EmitirReceita extends javax.swing.JFrame {

    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Consulta consulta;
    private EntityManager em;
    
    /**
     * Construtor da classe.
     * Inicializa os atributos e configura os componentes da interface.
     * 
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações
     * @param medico o médico que está emitindo a receita
     * @param consulta a consulta para a qual a receita será emitida
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public EmitirReceita(GerenciadorAdm gerenciadorAdm, Medico medico, Consulta consulta, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.medico = medico;
        this.consulta = consulta;
        this.em = em;
        initComponents();
        setNome();
        setLocationRelativeTo(null);
    }

    /**
     * Configura os nomes do paciente e do médico nos rótulos da interface.
     */
    private void setNome(){
        lblNomePaciente.setText(" " + consulta.getPaciente().getNome());
        lblNomeMedico.setText(" " + medico.getNome());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnGerar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblNomePaciente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMedicamentos = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNomeMedico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Receita");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(680, 560));
        setMinimumSize(new java.awt.Dimension(680, 560));
        setPreferredSize(new java.awt.Dimension(680, 560));
        setResizable(false);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Receita médica");
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnGerar.setBackground(new java.awt.Color(51, 204, 0));
        btnGerar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGerar.setForeground(new java.awt.Color(0, 0, 0));
        btnGerar.setText("Gerar receita");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_gerar(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuMedicosLaudos(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Informe os medicamentos que devem ser prescritos na receita (separados por vírgula):");
        jLabel6.setToolTipText("");

        lblNomePaciente.setBackground(new java.awt.Color(255, 255, 255));
        lblNomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomePaciente.setForeground(new java.awt.Color(0, 0, 0));
        lblNomePaciente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomePaciente.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Paciente:");

        txtMedicamentos.setBackground(new java.awt.Color(255, 255, 255));
        txtMedicamentos.setColumns(20);
        txtMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMedicamentos.setRows(5);
        jScrollPane1.setViewportView(txtMedicamentos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(btnGerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnGerar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnVoltar)))
                .addGap(41, 41, 41))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        lblNomeMedico.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeMedico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomeMedico.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomeMedico.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNomeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ação do botão "Gerar".
     * Gera e exibe uma receita médica se o campo de medicamentos estiver preenchido.
     * Caso contrário, exibe uma mensagem informando que o campo deve ser preenchido.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_gerar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_gerar
        if (!txtMedicamentos.getText().isEmpty()){
            String imprimir = medico.receitaMedica(consulta);
            JOptionPane.showMessageDialog(null, 
                                          imprimir, 
                                          "Receita", 
                                          JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, 
                                          "Preencha todos os campos!", 
                                          "Aviso!", 
                                          JOptionPane.WARNING_MESSAGE);            
        }
    }//GEN-LAST:event_go_gerar

    /**
     * Ação do botão "Voltar".
     * Retorna ao menu de laudos do médico.
     * 
     * @param evt o evento de clique do botão
     */
    private void back_menuMedicosLaudos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuMedicosLaudos
        MenuMedicoLaudos menuMedicoLaudos = new MenuMedicoLaudos(gerenciadorAdm, medico, consulta, em);
        menuMedicoLaudos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_menuMedicosLaudos

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNomeMedico;
    private javax.swing.JLabel lblNomePaciente;
    private java.awt.Panel panel1;
    private javax.swing.JTextArea txtMedicamentos;
    // End of variables declaration//GEN-END:variables
}