package InterfaceAdministrador;

import Gerenciador.GerenciadorAdm;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Classe que representa a tela inicial do sistema. Oferece opções para acessar diferentes áreas de usuário: Médico, Administrador e Secretária.
 * Fornece botões para navegar para a tela de login específica para cada tipo de usuário.
 * 
 * @author jeanm
 */
public class TelaInicial extends javax.swing.JFrame {

    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private EntityManager em;

    /**
     * Construtor da classe. Inicializa o JFrame com o gerenciador de administração e o EntityManager.
     * 
     * @param gerenciadorAdm O gerenciador de administração responsável por operações no sistema.
     * @param em O EntityManager usado para realizar consultas no banco de dados.
     */
    public TelaInicial(GerenciadorAdm gerenciadorAdm, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMed = new javax.swing.JButton();
        btnAdm = new javax.swing.JButton();
        btnSec = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(600, 470));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnMed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMed.setText("Médico");
        btnMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_usuarioMedico(evt);
            }
        });

        btnAdm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdm.setText("Administrador");
        btnAdm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_usuarioAdministrador(evt);
            }
        });

        btnSec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSec.setText("Secretária");
        btnSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_usuarioSecretaria(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Usuários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSec, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMed, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(btnAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnMed, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnSec, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //+++++++++++++++++++++++++++++++++++++++++++++
    //Ação somente para fins de teste
        public void cadMassa(){
            int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Um pré cadastro de medicos e secretarias está disponivel, gostaria de usar? \n"
                                + "se usar mais de uma vez vai cadastrar registros duplicados!", 
                        "Pre cadastro", 
                        JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION){
                    gerenciadorAdm.cadastroEmMassa();
                } 
        }
    
    /**
     * Ação do botão "Médico". Abre a tela de login para médicos e fecha a tela inicial.
     * 
     * @param evt O evento de ação do botão "Médico".
     */
    private void go_usuarioMedico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_usuarioMedico
        LoginMedSec loginMedico = new LoginMedSec(this.gerenciadorAdm, this.em);
        loginMedico.setSecMed("Medico");
        loginMedico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_go_usuarioMedico

    /**
     * Ação do botão "Administrador". Abre a tela principal do administrador, executa o pré-cadastro em massa e fecha a tela inicial.
     * 
     * @param evt O evento de ação do botão "Administrador".
     */
    private void go_usuarioAdministrador(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_usuarioAdministrador
        MenuPrincipalAdm menuPrincipalAdm = new MenuPrincipalAdm(gerenciadorAdm, em);
        this.cadMassa();
        menuPrincipalAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_go_usuarioAdministrador

    /**
     * Ação do botão "Secretária". Abre a tela de login para secretárias e fecha a tela inicial.
     * 
     * @param evt O evento de ação do botão "Secretária".
     */
    private void go_usuarioSecretaria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_usuarioSecretaria
        LoginMedSec loginSecretaria = new LoginMedSec(this.gerenciadorAdm, this.em);
        loginSecretaria.setSecMed("Secretaria");
        loginSecretaria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_go_usuarioSecretaria

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdm;
    private javax.swing.JButton btnMed;
    private javax.swing.JButton btnSec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
