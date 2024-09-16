package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Medico;
import javax.persistence.EntityManager;

/**
 * Tela de interface gráfica para o menu de laudos médicos.
 * Permite ao médico emitir atestados, receitas e declarações de acompanhamento para um paciente específico.
 * 
 * @author matheus
 */
public class MenuMedicoLaudos extends javax.swing.JFrame {

    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Consulta consulta;
    private EntityManager em;
    
    /**
     * Construtor da classe.
     * Inicializa os componentes da interface e configura as informações iniciais.
     * 
     * @param gerenciadorAdm o gerenciador de administração para operações de CRUD
     * @param medico o médico associado à consulta
     * @param consulta a consulta atual
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public MenuMedicoLaudos(GerenciadorAdm gerenciadorAdm, Medico medico, Consulta consulta, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.medico = medico;
        this.consulta = consulta;
        this.em = em;
        initComponents();
        setNome();
        setLocationRelativeTo(null);
    }

    /**
     * Configura os rótulos com o nome do paciente e do médico.
     */
    private void setNome() {
        lblNomePaciente.setText(" " + consulta.getPaciente().getNome());
        lblNomeMedico.setText(" " + medico.getNome());
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        btnReceita = new javax.swing.JButton();
        btnAtestado = new javax.swing.JButton();
        btnDeclaracao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        lblNomePaciente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNomeMedico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Médico - Menu laudos");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(700, 450));
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 550));
        setResizable(false);

        panel2.setBackground(new java.awt.Color(204, 204, 204));

        btnReceita.setBackground(new java.awt.Color(255, 255, 255));
        btnReceita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReceita.setForeground(new java.awt.Color(0, 0, 0));
        btnReceita.setText("Receita médica");
        btnReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_receita(evt);
            }
        });

        btnAtestado.setBackground(new java.awt.Color(255, 255, 255));
        btnAtestado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtestado.setForeground(new java.awt.Color(0, 0, 0));
        btnAtestado.setText("Atestado médico");
        btnAtestado.setToolTipText("");
        btnAtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_atestado(evt);
            }
        });

        btnDeclaracao.setBackground(new java.awt.Color(255, 255, 255));
        btnDeclaracao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDeclaracao.setForeground(new java.awt.Color(0, 0, 0));
        btnDeclaracao.setText("Declaração de acompanhamento");
        btnDeclaracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_declaracao(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Paciente:");

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_consultaDoPaciente(evt);
            }
        });

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
                .addGap(186, 186, 186)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeclaracao, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblNomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(btnReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnDeclaracao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Laudos médicos");
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        lblNomeMedico.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeMedico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomeMedico.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomeMedico.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblNomeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
     * Abre a tela para emitir um atestado para o paciente atual.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_atestado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_atestado
        EmitirAtestado emitirAtestado = new EmitirAtestado(gerenciadorAdm, medico, consulta, em);
        emitirAtestado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_go_atestado

    /**
     * Abre a tela para emitir uma receita para o paciente atual.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_receita(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_receita
        EmitirReceita emitirReceita = new EmitirReceita(gerenciadorAdm, medico, consulta, em);
        emitirReceita.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_go_receita

    /**
     * Abre a tela para emitir uma declaração de acompanhamento para o paciente atual.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_declaracao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_declaracao
        EmitirDeclaraçãoAcomponhamento emitirDec = new EmitirDeclaraçãoAcomponhamento(gerenciadorAdm, medico, consulta, em);
        emitirDec.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_go_declaracao

    /**
     * Volta para a tela de consulta do paciente.
     * 
     * @param evt o evento de clique do botão
     */
    private void back_consultaDoPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_consultaDoPaciente
        ConsultaDoPaciente consultaDoPaciente = new ConsultaDoPaciente(gerenciadorAdm, medico, consulta, em);
        consultaDoPaciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_consultaDoPaciente

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtestado;
    private javax.swing.JButton btnDeclaracao;
    private javax.swing.JButton btnReceita;
    private javax.swing.JButton btnVoltar;
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

