/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfaceAdministrador;

import InterfaceSecretaria.MenuPrincipalSecretaria;
import InterfaceMedico.MenuPrincipalMedico;
import Gerenciador.GerenciadorAdm;
import Modelo.Medico;
import Modelo.Secretaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela interface gráfica de login para médicos e secretárias.
 * Permite que médicos e secretárias façam login selecionando seu nome a partir de uma lista.
 * 
 * @author MatheusConsoni
 */
public class LoginMedSec extends javax.swing.JFrame {
    
    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Secretaria secretaria;
    private EntityManager em;
    private String login_med_sec;
    
    /**
     * Construtor da classe.
     * Inicializa o gerenciador de administração e o EntityManager, e configura os componentes da interface.
     * 
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações de CRUD
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public LoginMedSec(GerenciadorAdm gerenciadorAdm, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEnter = new javax.swing.JButton();
        CBoxFunci = new javax.swing.JComboBox<>();
        TituloLogin = new java.awt.Label();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login ");
        setLocation(new java.awt.Point(525, 150));
        setMinimumSize(new java.awt.Dimension(480, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        btnEnter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEnter.setText("Entrar");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_login(evt);
            }
        });

        CBoxFunci.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(CBoxFunci, 0, 280, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btnEnter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(CBoxFunci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        TituloLogin.setAlignment(java.awt.Label.CENTER);
        TituloLogin.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        TituloLogin.setText("Login Médico");

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
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
                        .addComponent(TituloLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Define o tipo de usuário (médico ou secretária) e configura a lista correspondente de opções.
     * 
     * @param sec o tipo de usuário que pode fazer login ("Medico" ou "Secretaria")
     */
    public void setSecMed(String med_sec){
        this.login_med_sec = med_sec;
        seleciona_allMed_allSec();
    }
    
    /**
     * Configura a lista de médicos ou secretárias com base no tipo de usuário definido.
     */
    private void seleciona_allMed_allSec(){
        if (login_med_sec.equals("Medico")){
            setListMedicos(this.gerenciadorAdm.getAllMedicos());
        
        } 
        else if (login_med_sec.equals("Secretaria")){
            TituloLogin.setText("Login Secretária");
            setListSecretarias(this.gerenciadorAdm.getAllSecretarias());
        
        }
    }
    
    /**
     * Preenche o JComboBox com a lista de médicos disponíveis.
     * 
     * @param listMedico a lista de médicos a serem exibidos no JComboBox
     */
    private void setListMedicos(List<Medico> listMedico){
        CBoxFunci.addItem("Selecione um médico");
        CBoxFunci.setSelectedItem("Selecione um médico");
        
        for (Medico medico : listMedico){
            CBoxFunci.addItem(medico.getNome());
        }
    }
    
    /**
     * Preenche o JComboBox com a lista de secretárias disponíveis.
     * 
     * @param listSecretaria a lista de secretárias a serem exibidas no JComboBox
     */
    private void setListSecretarias(List<Secretaria> listSecretaria){
        CBoxFunci.addItem("Selecione uma secretaria");
        CBoxFunci.setSelectedItem("Selecione uma secretaria");
        
        for (Secretaria secretaria : listSecretaria){
            CBoxFunci.addItem(secretaria.getNome());
        }
    }
    
    /**
     * Realiza o login do usuário selecionado e redireciona para a tela principal correspondente.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_login(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_login
        
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
                
                //Ação somente para fins de teste
                this.cadMassa();
                
                this.secretaria.setEm(em);
                MenuPrincipalSecretaria menuPrincipalSecretaria = new MenuPrincipalSecretaria(this.secretaria, this.gerenciadorAdm, this.em);
                menuPrincipalSecretaria.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_go_login

    //Ação somente para fins de teste
    public void cadMassa(){
                    int dialogResult = JOptionPane.showConfirmDialog(this, 
                                "Um pré cadastro de pacientes está disponivel, gostaria de usar? \n"
                                        + "se usar mais de uma vez vai cadastrar registros duplicados!", 
                                "Pre cadastro", 
                                JOptionPane.YES_NO_OPTION);
                        if (dialogResult == JOptionPane.YES_OPTION){
                            this.secretaria.cadastrarPacientesEmMassa();
                        } 
                }
    
    
    
    /**
     * Retorna à tela inicial.
     * 
     * @param evt o evento de clique do botão
     */
    private void back_telaInicial(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_telaInicial
        // TODO add your handling code here:
        TelaInicial telaInicial = new TelaInicial(this.gerenciadorAdm, em);
        telaInicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_telaInicial

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBoxFunci;
    private java.awt.Label TituloLogin;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEnter;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
