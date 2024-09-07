/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import javax.persistence.EntityManager;

/**
 *Descrição generica
 * @author jeanm
 */
public class TelaInicial extends javax.swing.JFrame {
    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private EntityManager em;

    // Construtor
    public TelaInicial(GerenciadorAdm gerenciadorAdm, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMed = new javax.swing.JButton();
        btnAdm = new javax.swing.JButton();
        btnSec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(500, 400));

        btnMed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMed.setText("Médico");
        btnMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMed_Action(evt);
            }
        });

        btnAdm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdm.setText("Administrador");
        btnAdm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdm_Action(evt);
            }
        });

        btnSec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSec.setText("Secretária");
        btnSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSec_Action(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSec, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMed, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnMed, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnSec, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    // Ações
    private void btnMed_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMed_Action
        LoginMedSec loginMedico = new LoginMedSec(this.gerenciadorAdm, this.em);
        loginMedico.setSecMed("Medico");
        loginMedico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMed_Action

    private void btnAdm_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdm_Action
        MenuPrincipalAdm menuPrincipalAdm = new MenuPrincipalAdm(gerenciadorAdm, em);
        menuPrincipalAdm.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnAdm_Action

    private void btnSec_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSec_Action
        LoginMedSec loginSecretaria = new LoginMedSec(this.gerenciadorAdm, this.em);
        loginSecretaria.setSecMed("Secretaria");
        loginSecretaria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSec_Action


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdm;
    private javax.swing.JButton btnMed;
    private javax.swing.JButton btnSec;
    // End of variables declaration//GEN-END:variables
}
