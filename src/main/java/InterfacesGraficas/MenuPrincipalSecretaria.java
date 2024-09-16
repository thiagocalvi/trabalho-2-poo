/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Secretaria;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Tela principal do menu da secretaria.
 * Esta classe representa a interface gráfica que é exibida para a secretaria.
 * Contém botões para acessar diferentes funcionalidades, como listar médicos, 
 * gerenciar pacientes e consultas, e sair da conta.
 * 
 * @author matheus
 */
public class MenuPrincipalSecretaria extends javax.swing.JFrame {

    // Atributos
    private Secretaria secretaria; // Instância da secretaria
    private EntityManager em; // Gerenciador de entidades para operações com o banco de dados
    private GerenciadorAdm gerenciadorAdm; // Gerenciador de administração

    /**
     * Construtor da classe MenuPrincipalSecretaria.
     * Inicializa os componentes da interface gráfica e define o nome da secretaria no rótulo.
     * 
     * @param secretaria A instância da secretaria que está usando o menu.
     * @param gerenciadorAdm O gerenciador de administração para operações com o banco de dados.
     * @param em O EntityManager para realizar operações com o banco de dados.
     */
    public MenuPrincipalSecretaria(Secretaria secretaria, GerenciadorAdm gerenciadorAdm, EntityManager em) {
        this.secretaria = secretaria;
        this.em = em;
        this.gerenciadorAdm = gerenciadorAdm;
        initComponents();
        lblNome.setText("  " + secretaria.getNome()); // Define o nome da secretaria na interface
        setLocationRelativeTo(null); // Centraliza a janela
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Relatório mensal dos clientes atendidos");
        jLabel5.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Secretaria");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(670, 450));
        setResizable(false);

        panel1.setPreferredSize(new java.awt.Dimension(800, 450));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Consultas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goMenuSecretariaConsulta(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Pacientes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goMenuSecretariaPaciente(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Lista de Médicos");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goListarMedicos(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setText("Enviar Mensagens");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarMensagems(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Secretaria:");

        lblNome.setBackground(new java.awt.Color(255, 255, 255));
        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNome.setForeground(new java.awt.Color(0, 0, 0));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNome.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Sair da conta");
        jButton1.setAutoscrolls(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_Login(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(132, 132, 132))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /**
     * Ação do botão para acessar o menu de pacientes.
     * Abre o menu de gerenciamento de pacientes e fecha a tela atual.
     * 
     * @param evt O evento de ação do botão.
     */
    private void goMenuSecretariaPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goMenuSecretariaPaciente
        MenuSecretariaPaciente menuSecretariaPaciente = new MenuSecretariaPaciente(secretaria, gerenciadorAdm, em);
        menuSecretariaPaciente.setVisible(true); // Mostra o menu de pacientes
        this.dispose(); // Fecha a tela atual
    }//GEN-LAST:event_goMenuSecretariaPaciente

    /**
     * Ação do botão para acessar o menu de consultas.
     * Abre o menu de gerenciamento de consultas e fecha a tela atual.
     * 
     * @param evt O evento de ação do botão.
     */
    private void goMenuSecretariaConsulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goMenuSecretariaConsulta
        MenuSecretariaConsulta menuSecretariaConsulta = new MenuSecretariaConsulta(secretaria, gerenciadorAdm, em);
        menuSecretariaConsulta.setVisible(true); // Mostra o menu de consultas
        this.dispose(); // Fecha a tela atual
    }//GEN-LAST:event_goMenuSecretariaConsulta

    /**
     * Ação do botão para enviar mensagens sobre consultas do dia seguinte.
     * Exibe uma caixa de diálogo com as mensagens das consultas do dia seguinte.
     * 
     * @param evt O evento de ação do botão.
     */
    private void enviarMensagems(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarMensagems
        // Mostra uma caixa de diálogo com as mensagens das consultas do dia seguinte
        JOptionPane.showMessageDialog(null, this.secretaria.enviarMensagensConsultasDiaSeguinte(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_enviarMensagems

    /**
     * Ação do botão para listar médicos.
     * Abre a tela que exibe a lista de médicos e fecha a tela atual.
     * 
     * @param evt O evento de ação do botão.
     */
    private void goListarMedicos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goListarMedicos
        ListaMedicosSecretaria listaMedicosSecretaria = new ListaMedicosSecretaria(secretaria, em, gerenciadorAdm);
        listaMedicosSecretaria.setVisible(true); // Mostra a lista de médicos
        this.dispose(); // Fecha a tela atual
    }//GEN-LAST:event_goListarMedicos

    /**
     * Ação do botão de sair da conta.
     * Abre a tela de login e fecha a tela atual.
     * 
     * @param evt O evento de ação do botão.
     */
    private void back_Login(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_Login
        LoginMedSec loginSecretaria = new LoginMedSec(gerenciadorAdm, em);
        loginSecretaria.setSecMed("Secretaria"); // Define o tipo de usuário
        loginSecretaria.setVisible(true); // Mostra a tela de login
        this.dispose(); // Fecha a tela atual
    }//GEN-LAST:event_back_Login
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNome;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}