package InterfacesGraficas;

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

        btnMed = new javax.swing.JButton();
        btnAdm = new javax.swing.JButton();
        btnSec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);

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
    
    //+++++++++++++++++++++++++++++++++++++++++++++
    //Ação somente para fins de teste
        public void cadMassa(){
            int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Um pré cadastro de medicos e secretarias está disponivel, gostaria de usar? \n"
                                + "se usar mais de uma vez vai cadastrar geristros duplicados!", 
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
    private void btnMed_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMed_Action
        LoginMedSec loginMedico = new LoginMedSec(this.gerenciadorAdm, this.em);
        loginMedico.setSecMed("Medico");
        loginMedico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMed_Action

    /**
     * Ação do botão "Administrador". Abre a tela principal do administrador, executa o pré-cadastro em massa e fecha a tela inicial.
     * 
     * @param evt O evento de ação do botão "Administrador".
     */
    private void btnAdm_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdm_Action
        MenuPrincipalAdm menuPrincipalAdm = new MenuPrincipalAdm(gerenciadorAdm, em);
        this.cadMassa();
        menuPrincipalAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdm_Action

    /**
     * Ação do botão "Secretária". Abre a tela de login para secretárias e fecha a tela inicial.
     * 
     * @param evt O evento de ação do botão "Secretária".
     */
    private void btnSec_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSec_Action
        LoginMedSec loginSecretaria = new LoginMedSec(this.gerenciadorAdm, this.em);
        loginSecretaria.setSecMed("Secretaria");
        loginSecretaria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSec_Action

    // Declaração das variáveis da interface gráfica
    private javax.swing.JButton btnAdm;
    private javax.swing.JButton btnMed;
    private javax.swing.JButton btnSec;
}
