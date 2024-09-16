package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Medico;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Tela de consulta do paciente.
 * Esta classe exibe informações sobre uma consulta específica e permite acessar diferentes funcionalidades relacionadas a essa consulta.
 * 
 * @author matheus
 */
public class ConsultaDoPaciente extends javax.swing.JFrame {

    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Consulta consulta;
    private EntityManager em;

    /**
     * Construtor da classe.
     * Inicializa os atributos e configura os componentes da interface.
     * 
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações
     * @param medico o médico associado à consulta
     * @param consulta a consulta a ser exibida
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public ConsultaDoPaciente(GerenciadorAdm gerenciadorAdm, Medico medico, Consulta consulta, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.medico = medico;
        this.consulta = consulta;
        this.em = em;
        initComponents();
        setNome();
        setLocationRelativeTo(null);
    }

    /**
     * Define os nomes do paciente e do médico nos rótulos da interface.
     */
    private void setNome(){
        lblNomePaciente.setText(" " + consulta.getPaciente().getNome());
        lblNomeMedico.setText(" " + medico.getNome());
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        btnDados = new javax.swing.JButton();
        btnProntuario = new javax.swing.JButton();
        btnLaudo = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblNomePaciente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNomeMedico = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Médico - Consulta paciente");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(744, 532));
        setMinimumSize(new java.awt.Dimension(744, 532));
        setResizable(false);

        panel2.setBackground(new java.awt.Color(153, 153, 153));

        btnDados.setBackground(new java.awt.Color(255, 255, 255));
        btnDados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDados.setForeground(new java.awt.Color(0, 0, 0));
        btnDados.setText("Dados adicionais");
        btnDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_dados_adicionais(evt);
            }
        });

        btnProntuario.setBackground(new java.awt.Color(255, 255, 255));
        btnProntuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProntuario.setForeground(new java.awt.Color(0, 0, 0));
        btnProntuario.setText("Prontuário");
        btnProntuario.setToolTipText("");
        btnProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_prontuario(evt);
            }
        });

        btnLaudo.setBackground(new java.awt.Color(255, 255, 255));
        btnLaudo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLaudo.setForeground(new java.awt.Color(0, 0, 0));
        btnLaudo.setText("Laudos médicos");
        btnLaudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_laudos_medicos(evt);
            }
        });

        btnFinalizar.setBackground(new java.awt.Color(255, 255, 255));
        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinalizar.setForeground(new java.awt.Color(0, 0, 0));
        btnFinalizar.setText("Finalizar consulta");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_finalizar_consulta(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Paciente:");

        lblNomePaciente.setBackground(new java.awt.Color(255, 255, 255));
        lblNomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomePaciente.setForeground(new java.awt.Color(0, 0, 0));
        lblNomePaciente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomePaciente.setOpaque(true);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(btnProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(btnDados, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblNomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDados, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Consulta do Paciente");
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        lblNomeMedico.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeMedico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomeMedico.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomeMedico.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }// </editor-fold>//GEN-END:initComponents

    
     /**
     * Abre a tela de prontuários do paciente.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_prontuario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_prontuario
        MenuProntuarios menuProntuarios = new MenuProntuarios(gerenciadorAdm, medico, consulta, em);
        menuProntuarios.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_go_prontuario

    /**
     * Abre a tela de laudos médicos.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_laudos_medicos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_laudos_medicos
        MenuMedicoLaudos menuMedicoLaudos = new MenuMedicoLaudos(gerenciadorAdm, medico, consulta, em);
        menuMedicoLaudos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_go_laudos_medicos

    /**
     * Finaliza a consulta e atualiza o estado no banco de dados.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_finalizar_consulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_finalizar_consulta
        int option = JOptionPane.showConfirmDialog(null, 
                                               "Deseja 'FINALIZAR' a consulta?!", 
                                               "Aviso", 
                                               JOptionPane.YES_NO_OPTION, 
                                               JOptionPane.WARNING_MESSAGE);
        
        if (option == JOptionPane.YES_OPTION){
            // Iniciar a transação
            em.getTransaction().begin();

            // Alterar o estado da consulta dentro da transação
            consulta.setConsultaFinalizada(true);
            em.merge(consulta);                          // Atualizar a consulta no banco
            em.getTransaction().commit();                // Confirmar a transação para salvar no banco
            
            ConsultasDoDia consultasDoDia = new ConsultasDoDia(gerenciadorAdm, medico, em);
            consultasDoDia.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_go_finalizar_consulta

    /**
     * Abre a tela de dados médicos da consulta.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_dados_adicionais(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_dados_adicionais
        MenuDadosMedicos menuDadosMedicos = new MenuDadosMedicos(gerenciadorAdm, medico, consulta, em);
        menuDadosMedicos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_go_dados_adicionais

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDados;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnLaudo;
    private javax.swing.JButton btnProntuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNomeMedico;
    private javax.swing.JLabel lblNomePaciente;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}