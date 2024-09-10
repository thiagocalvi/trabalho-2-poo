/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Medico;
import Modelo.Prontuario;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *Descrição generica
 * @author matheus
 */
public class CadAutProntuario extends javax.swing.JFrame {
    // Atríbutos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Consulta consulta;
    private Prontuario prontuario;
    private EntityManager em;
    private String CadAut = "Cadastrar";

    // Construtor
    public CadAutProntuario(GerenciadorAdm gerenciadorAdm, Medico medico, Consulta consulta, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.prontuario = prontuario;
        this.medico = medico;
        this.consulta = consulta;
        this.em = em;        
        initComponents();
        setNome();
        setLocationRelativeTo(null);
    }

    private void setNome(){
        lblPac.setText(" " + consulta.getPaciente().getNome());
        lblMed.setText(" " + medico.getNome());
    }
    
    public void setAtualizar(String atualizar){
        this.CadAut = atualizar;
        setTitle("Atualizar prontuário");
        lblTitulo.setText("Atualizar prontuário");
        btnCadAut.setText(atualizar);
        setValues();
    }
    
    private void setValues(){
        txtDoe.setText(this.prontuario.getDiagnostico());
        txtSin.setText(this.prontuario.getSintomas());
        txtTrat.setText(this.prontuario.getTratamento());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMed = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPac = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCadAut = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDoe = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSin = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTrat = new javax.swing.JTextArea();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro prontuário");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(750, 690));
        setMinimumSize(new java.awt.Dimension(750, 690));
        setPreferredSize(new java.awt.Dimension(750, 690));
        setResizable(false);

        lblTitulo.setBackground(new java.awt.Color(204, 204, 204));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar prontuário");
        lblTitulo.setToolTipText("");
        lblTitulo.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        lblMed.setBackground(new java.awt.Color(255, 255, 255));
        lblMed.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMed.setForeground(new java.awt.Color(0, 0, 0));
        lblMed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMed.setMaximumSize(new java.awt.Dimension(720, 550));
        lblMed.setMinimumSize(new java.awt.Dimension(720, 550));
        lblMed.setOpaque(true);
        lblMed.setPreferredSize(new java.awt.Dimension(720, 550));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMed, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMed, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lblPac.setBackground(new java.awt.Color(255, 255, 255));
        lblPac.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPac.setForeground(new java.awt.Color(0, 0, 0));
        lblPac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPac.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Paciente:");

        btnCadAut.setBackground(new java.awt.Color(51, 255, 51));
        btnCadAut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadAut.setForeground(new java.awt.Color(0, 0, 0));
        btnCadAut.setText("Cadastrar");
        btnCadAut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadAut_Action(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sintomas:");

        txtDoe.setBackground(new java.awt.Color(255, 255, 255));
        txtDoe.setColumns(20);
        txtDoe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDoe.setRows(5);
        jScrollPane1.setViewportView(txtDoe);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Diagnóstico da doença:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Prescrição do tratamento:");

        txtSin.setBackground(new java.awt.Color(255, 255, 255));
        txtSin.setColumns(20);
        txtSin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSin.setRows(5);
        jScrollPane2.setViewportView(txtSin);

        txtTrat.setBackground(new java.awt.Color(255, 255, 255));
        txtTrat.setColumns(20);
        txtTrat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTrat.setRows(5);
        jScrollPane3.setViewportView(txtTrat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPac, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnCadAut, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadAut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar_Action(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadAut_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadAut_Action
        String sintomas, diagnostico, tratamento;

        sintomas = txtSin.getText();
        diagnostico = txtDoe.getText();
        tratamento = txtTrat.getText();

        if (this.CadAut.equals("Cadastrar")){
            int dialogResult = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja 'CADASTRAR' o prontuário?",
                "Confirmar Cadastro",
                JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION){
                prontuario = medico.cadastrarProntuario(consulta.getPaciente(), consulta, sintomas, diagnostico, tratamento);
                consulta.setProntuario(prontuario);
                MenuProntuarios menuProntuarios = new MenuProntuarios(gerenciadorAdm, medico, consulta, em);
                menuProntuarios.setVisible(true);
                this.dispose();
            }     
        }
        else if (this.CadAut.equals("Atualizar")){
            int dialogResult = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja 'ATUALIZAR' o prontuário?",
                "Confirmar Atualização",
                JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION){
                prontuario = medico.atualizarProntuario(prontuario, consulta.getPaciente(), consulta, sintomas, diagnostico, tratamento);
                consulta.setProntuario(prontuario);
                MenuProntuarios menuProntuarios = new MenuProntuarios(gerenciadorAdm, medico, consulta, em);
                menuProntuarios.setVisible(true);
                this.dispose();
            }  
        }
    }//GEN-LAST:event_btnCadAut_Action

    
    private void btnVoltar_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar_Action
        MenuProntuarios menuProntuarios = new MenuProntuarios(gerenciadorAdm, medico, consulta, em);
        menuProntuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltar_Action

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadAut;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMed;
    private javax.swing.JLabel lblPac;
    private javax.swing.JLabel lblTitulo;
    private java.awt.Panel panel1;
    private javax.swing.JTextArea txtDoe;
    private javax.swing.JTextArea txtSin;
    private javax.swing.JTextArea txtTrat;
    // End of variables declaration//GEN-END:variables
}
