/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;
import java.awt.Image;
import javax.swing.ImageIcon;
import Gerenciador.GerenciadorAdm;
import Modelo.Medico;
import Modelo.Secretaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author MatheusConsoni
 */
public class LoginMedSec extends javax.swing.JFrame {
    // Atríbutos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Secretaria secretaria;
    private EntityManager em;
    private String login_med_sec;
    
    // Construtor
    public LoginMedSec(GerenciadorAdm gerenciadorAdm, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEntrar = new javax.swing.JButton();
        CBoxFunci = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login ");
        setLocation(new java.awt.Point(525, 150));
        setMinimumSize(new java.awt.Dimension(480, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(70, 73, 75));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(CBoxFunci, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnEntrar)
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(CBoxFunci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar)
                .addGap(32, 32, 32))
        );

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Login Médico");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_telaInicial(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Métodos
    public void setSecMed(String sec){
        this.login_med_sec = sec;
        seleciona_allMed_allSec();
    }
    
    private void seleciona_allMed_allSec(){
        if (login_med_sec.equals("Medico")){
            setListMedicos(this.gerenciadorAdm.getAllMedicos());
        
        } else if (login_med_sec.equals("Secretaria")){
            label1.setText("Login Secretária");
            setListSecretarias(this.gerenciadorAdm.getAllSecretarias());
        
        }
    }
    
    private void setListMedicos(List<Medico> listMedico){
        CBoxFunci.addItem("Selecione um médico");
        CBoxFunci.setSelectedItem("Selecione um médico");
        
        for (Medico medico : listMedico){
            CBoxFunci.addItem(medico.getNome());
        }
    }
    
    private void setListSecretarias(List<Secretaria> listSecretaria){
        CBoxFunci.addItem("Selecione uma secretaria");
        CBoxFunci.setSelectedItem("Selecione uma sercretaria");
        
        for (Secretaria secretaria : listSecretaria){
            CBoxFunci.addItem(secretaria.getNome());
        }
    }
    
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        
        String texto = CBoxFunci.getSelectedItem().toString();
        
        if(texto.equals("Selecione um médico")){
            JOptionPane.showMessageDialog(null, "Selecione o médico que vai fazer login", "Erro: entrada invalida", JOptionPane.ERROR_MESSAGE);

        }
        else if (texto.equals("Selecione uma secretaria")){
            JOptionPane.showMessageDialog(null, "Selecione a secretaria que vai fazer login", "Erro: entrada invalida", JOptionPane.ERROR_MESSAGE);

        }
        else{
            if (this.login_med_sec.equals("Medico")){
                this.em.getTransaction().begin();

                this.medico = this.em.createQuery("SELECT m FROM Medico m WHERE m.nome = :nome", Medico.class)
                        .setParameter("nome", texto).getSingleResult();

                this.em.getTransaction().commit();

                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "Informações", JOptionPane.INFORMATION_MESSAGE);
                this.medico.setEm(em);
                MenuPrincipalMedico consultaRelatorio = new MenuPrincipalMedico(gerenciadorAdm, medico, em);
                consultaRelatorio.setVisible(true);
                this.dispose();
            }
            else if (this.login_med_sec.equals("Secretaria")){
                this.em.getTransaction().begin();
        
                this.secretaria = this.em.createQuery("SELECT s FROM Secretaria s WHERE s.nome = :nome", Secretaria.class)
                        .setParameter("nome", texto).getSingleResult();

                this.em.getTransaction().commit();

                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "Informações", JOptionPane.INFORMATION_MESSAGE);
                this.secretaria.setEm(em);
                MenuPrincipalSecretaria menuPrincipalSecretaria = new MenuPrincipalSecretaria(this.secretaria, em);
                menuPrincipalSecretaria.setGerenciadorAdm(this.gerenciadorAdm);
                menuPrincipalSecretaria.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    
    private void back_telaInicial(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_telaInicial
        // TODO add your handling code here:
        TelaInicial telaInicial = new TelaInicial(this.gerenciadorAdm, em);
        telaInicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_telaInicial

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBoxFunci;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
