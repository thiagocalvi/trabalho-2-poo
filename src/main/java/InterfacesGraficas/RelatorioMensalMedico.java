package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Medico;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Classe que representa a janela de relatório mensal de consultas atendidas por um médico.
 * Exibe um relatório das consultas finalizadas no mês atual, incluindo informações do paciente, tipo de convênio e data.
 * Permite a navegação de volta ao menu principal do médico.
 * 
 * @author matheus
 */
public class RelatorioMensalMedico extends javax.swing.JFrame {
    
    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private EntityManager em;
    
    /**
     * Construtor da classe. Inicializa o JFrame com os dados do gerente, médico e EntityManager.
     * 
     * @param gerenciadorAdm O gerenciador de administração responsável por operações no sistema.
     * @param medico O médico para o qual o relatório de consultas será gerado.
     * @param em O EntityManager usado para realizar consultas no banco de dados.
     */
    public RelatorioMensalMedico(GerenciadorAdm gerenciadorAdm, Medico medico, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.medico = medico;
        this.em = em;
        initComponents();
        mesAtual();
        exibeRelatorio();
        setLocationRelativeTo(null);
    }

    /**
     * Configura o rótulo do mês atual na interface gráfica.
     */
    private void mesAtual(){
        LocalDate mesAtual = LocalDate.now();
        Month mes = mesAtual.getMonth();
        
        lblMes.setText("Mês atual: " + mes);
    }
    
    /**
     * Lista as consultas finalizadas do mês atual para o médico especificado.
     * Preenche a tabela com as informações das consultas e atualiza o total de consultas.
     */
    private void exibeRelatorio(){
        List<Consulta> listConsulta = medico.relatorioMensal();
        
        DefaultTableModel model = (DefaultTableModel)tableRelatorio.getModel(); 
        
        model.setRowCount(0); 
        for (Consulta consulta : listConsulta){
            if (consulta.getPaciente() == null){
                Object[] linha = {"Paciente removido", consulta.getTipo(),
                    consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()};
                model.addRow(linha);            }
            else {
                Object[] linha = {consulta.getPaciente().getNome(), consulta.getTipo(),
                    consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()};
                model.addRow(linha);
            }
        }
        
        lblTotal.setText("Total: " + listConsulta.size());
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tableRelatorio.setRowSorter(sorter);          
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRelatorio = new javax.swing.JTable();

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Relatório mensal dos clientes atendidos");
        jLabel5.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Médico - Relatório");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(650, 610));
        setResizable(false);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Relatório mensal dos clientes atendidos");
        jLabel2.setOpaque(true);

        lblMes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMes.setForeground(new java.awt.Color(0, 0, 0));
        lblMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMes.setText("Mês: Atual");

        lblTotal.setBackground(new java.awt.Color(204, 204, 204));
        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("Total: XX");
        lblTotal.setToolTipText("");
        lblTotal.setOpaque(true);

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuPrincipalMedico(evt);
            }
        });

        tableRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableRelatorio.setForeground(new java.awt.Color(0, 0, 0));
        tableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Tipo da consulta", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableRelatorio.setShowGrid(true);
        jScrollPane3.setViewportView(tableRelatorio);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(446, 446, 446)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ação do botão "Voltar". Fecha a janela atual e abre o menu principal do médico.
     * 
     * @param evt O evento de ação do botão "Voltar".
     */
    private void back_menuPrincipalMedico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuPrincipalMedico
        MenuPrincipalMedico menuPrincipalMedico = new MenuPrincipalMedico(gerenciadorAdm, medico, em);
        menuPrincipalMedico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_menuPrincipalMedico

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblTotal;
    private java.awt.Panel panel1;
    private javax.swing.JTable tableRelatorio;
    // End of variables declaration//GEN-END:variables
}