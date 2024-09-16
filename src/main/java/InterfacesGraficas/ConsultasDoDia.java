package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Medico;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Tela que exibe as consultas agendadas para o dia atual para um médico.
 * Oferece opções para visualizar a consulta e retornar ao menu principal do médico.
 * 
 * @author matheus
 */
public class ConsultasDoDia extends javax.swing.JFrame {

    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private EntityManager em;
    private Consulta proxConsulta;

    /**
     * Construtor da classe.
     * Inicializa os atributos e configura os componentes da interface.
     * 
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações
     * @param medico o médico cujas consultas serão exibidas
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public ConsultasDoDia(GerenciadorAdm gerenciadorAdm, Medico medico, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.medico = medico;
        this.em = em;
        initComponents();
        listarConsultas();
        setLocationRelativeTo(null);
        lblNomeMedico.setText(" " + medico.getNome());
    }

    /**
     * Lista as consultas do dia para o médico na tabela.
     * Obtém as consultas do banco de dados e as exibe na tabela.
     */
    private void listarConsultas(){
        LocalDate dataAtual = LocalDate.now();
        
        String cons = "SELECT c FROM Consulta c WHERE c.medico = :medico AND "
                     + "c.consultaFinalizada = false AND c.data = :data ORDER BY c.horario";
        
        TypedQuery<Consulta> query = em.createQuery(cons, Consulta.class);
        query.setParameter("medico", medico);
        query.setParameter("data", dataAtual);
        
        List<Consulta> consultasDoDia = query.getResultList();
        DefaultTableModel model = (DefaultTableModel)tableConsultas.getModel(); 

        model.setRowCount(0); 
        for (Consulta consulta : consultasDoDia){
            Object[] linha = {consulta.getPaciente().getNome(), 
                              consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
                              consulta.getHorario()};
            model.addRow(linha);
        }
 
        if (!consultasDoDia.isEmpty()) {
            this.proxConsulta = consultasDoDia.get(0);
        }
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tableConsultas.setRowSorter(sorter);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNomeMedico = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnYes = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableConsultas = new javax.swing.JTable();

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Relatório mensal dos clientes atendidos");
        jLabel5.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Médico - Consultas");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        lblNomeMedico.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeMedico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNomeMedico.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomeMedico.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Consultas do dia");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Iniciar a próxima consulta?");

        btnYes.setBackground(new java.awt.Color(204, 204, 204));
        btnYes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnYes.setForeground(new java.awt.Color(0, 0, 0));
        btnYes.setText("SIM");
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYes_Action(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuPrincipalMedico(evt);
            }
        });

        tableConsultas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Data", "Horário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableConsultas);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ação do botão "Sim".
     * Abre a tela para visualizar a consulta do paciente selecionado, se houver uma consulta marcada para hoje.
     * Caso contrário, exibe uma mensagem informando que não há consultas marcadas.
     * 
     * @param evt o evento de clique do botão
     */
    private void btnYes_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYes_Action
        if (this.proxConsulta == null){
            JOptionPane.showMessageDialog(null, 
                                          "Nenhuma consulta marcada para hoje!", 
                                          "Aviso", 
                                          JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            ConsultaDoPaciente consultaDoPaciente = new ConsultaDoPaciente(gerenciadorAdm, medico, this.proxConsulta, em);
            consultaDoPaciente.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnYes_Action

    /**
     * Ação do botão "Voltar".
     * Retorna ao menu principal do médico.
     * 
     * @param evt o evento de clique do botão
     */
    private void back_menuPrincipalMedico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuPrincipalMedico
        MenuPrincipalMedico menuPrincipalMedico = new MenuPrincipalMedico(gerenciadorAdm, medico, em);
        menuPrincipalMedico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_menuPrincipalMedico

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnYes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNomeMedico;
    private java.awt.Panel panel1;
    private javax.swing.JTable tableConsultas;
    // End of variables declaration//GEN-END:variables
}