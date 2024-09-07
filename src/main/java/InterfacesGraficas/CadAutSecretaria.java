/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;
import Gerenciador.GerenciadorAdm;
import Modelo.Secretaria;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
/**
 *Descrição generica
 * @author matheus
 */
public class CadAutSecretaria extends javax.swing.JFrame {
    
    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private EntityManager em;
    private String Cad_Atu = "Cadastrar";
    private Secretaria secretaria;
    
    /**
     * Construtor da classe.
     * Inicializa o gerenciador de administração e o EntityManager, e configura os componentes da interface.
     * 
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações de CRUD
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public CadAutSecretaria(GerenciadorAdm gerenciadorAdm, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        lblTitulo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        genero_m_secretaria = new javax.swing.JRadioButton();
        genero_f_secretaria = new javax.swing.JRadioButton();
        voltar = new javax.swing.JButton();
        nome_secretaria = new javax.swing.JTextPane();
        telefone_secretaria = new javax.swing.JTextPane();
        email_secretaria = new javax.swing.JTextPane();
        dataNascimento_secretaria = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Secretaria");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(525, 150));
        setMaximumSize(new java.awt.Dimension(780, 500));
        setMinimumSize(new java.awt.Dimension(780, 500));
        setPreferredSize(new java.awt.Dimension(780, 500));
        setResizable(false);

        lblTitulo.setBackground(new java.awt.Color(255, 204, 102));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar Secretaria");
        lblTitulo.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nome:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Telefone:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Email:");

        btnCadastrar.setBackground(new java.awt.Color(0, 204, 0));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar ");
        btnCadastrar.setPreferredSize(new java.awt.Dimension(89, 25));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarSecretaria(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Genero:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Data nascimento (dd/mm/aaaa):");

        buttonGroup1.add(genero_m_secretaria);
        genero_m_secretaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genero_m_secretaria.setText("Masculino");

        buttonGroup1.add(genero_f_secretaria);
        genero_f_secretaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genero_f_secretaria.setText("Feminino");

        voltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarJanela(evt);
            }
        });

        nome_secretaria.setBackground(new java.awt.Color(204, 204, 204));
        nome_secretaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nome_secretaria.setForeground(new java.awt.Color(0, 0, 0));

        telefone_secretaria.setBackground(new java.awt.Color(204, 204, 204));
        telefone_secretaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telefone_secretaria.setForeground(new java.awt.Color(0, 0, 0));

        email_secretaria.setBackground(new java.awt.Color(204, 204, 204));
        email_secretaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email_secretaria.setForeground(new java.awt.Color(0, 0, 0));

        dataNascimento_secretaria.setBackground(new java.awt.Color(204, 204, 204));
        dataNascimento_secretaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataNascimento_secretaria.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nome_secretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(telefone_secretaria)
                                    .addComponent(email_secretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascimento_secretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(genero_m_secretaria)
                                .addGap(18, 18, 18)
                                .addComponent(genero_f_secretaria)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nome_secretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telefone_secretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(email_secretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataNascimento_secretaria)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genero_m_secretaria)
                    .addComponent(genero_f_secretaria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Define o texto do botão e ajusta o título da janela para refletir a operação (Cadastrar ou Atualizar).
     * 
     * @param Cad_Atu o texto que será exibido no botão (Cadastrar ou Atualizar)
     */
    public void setBtnText(String Cad_Atu){
        this.Cad_Atu = Cad_Atu;
        btnCadastrar.setText(Cad_Atu);
        lblTitulo.setText("Atualizar Secretaria");
        setTitle("Atualizar Secretaria");
        setValues();
    } 
    
    /**
     * Define a secretária que será atualizada.
     * 
     * @param secretaria o objeto Secretaria que será atualizado
     */
    public void setSecretaria(Secretaria secretaria){
        this.secretaria = secretaria;
    }
    
    /**
     * Navega de volta para a janela do menu de secretárias.
     * 
     * @param evt o evento de clique do botão
     */
    private void voltarJanela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarJanela
        MenuSecretariasAdm menuSecretariaAdm = new MenuSecretariasAdm(gerenciadorAdm, em);
        menuSecretariaAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarJanela

    /**
     * Cadastra ou atualiza uma secretária com base nas informações fornecidas nos campos da interface gráfica.
     * 
     * @param evt o evento de clique do botão
     */
    private void cadastrarSecretaria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarSecretaria
        // TODO add your handling code here:
        String nome, telefone, email, dataNascimento, genero = null;
       
       
        nome = nome_secretaria.getText();
        telefone = telefone_secretaria.getText();  
        email = email_secretaria.getText();
        dataNascimento = dataNascimento_secretaria.getText();
        
        
        if (genero_m_secretaria.isSelected()) {
            genero = "Masculino";
        } else if (genero_f_secretaria.isSelected()) {
            genero = "Feminino";
        }
        
        MenuSecretariasAdm menuSecretariaAdm = new MenuSecretariasAdm(gerenciadorAdm, em);
        if (this.Cad_Atu.equals("Cadastrar")){
            int dialogResult = JOptionPane.showConfirmDialog(this, 
                    "Tem certeza que deseja cadastrar secretaria" + nome + "?", 
                    "Confirmar Cadastro", 
                    JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                this.gerenciadorAdm.cadastrarSecretaria(nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, genero);
                menuSecretariaAdm.setVisible(true);
                this.dispose();
            }
            
        } else if (this.Cad_Atu.equals("Atualizar")){
            int dialogResult = JOptionPane.showConfirmDialog(this, 
                    "Tem certeza que deseja atualizar a secretaria " + this.secretaria.getNome() + "?", 
                    "Confirmar Atualização", 
                    JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                this.gerenciadorAdm.atualizarSecretaria(this.secretaria, nome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), telefone, email, genero);
                menuSecretariaAdm.setVisible(true);
                this.dispose();
            }        
        }
    }//GEN-LAST:event_cadastrarSecretaria
    
    /**
     * Preenche os campos da interface com os dados da secretária quando a operação é de atualização.
     * Configura os valores dos campos baseados no objeto Secretaria fornecido.
     */
    private void setValues(){
        if (this.Cad_Atu.equals("Atualizar")){
            nome_secretaria.setText(this.secretaria.getNome());

            telefone_secretaria.setText(this.secretaria.getTelefone());

            email_secretaria.setText(this.secretaria.getEmail());

            dataNascimento_secretaria.setText(this.secretaria.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            if(this.secretaria.getGenero().equals("Masculino")){
                genero_m_secretaria.setSelected(true);

            }else{
                genero_f_secretaria.setSelected(true);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextPane dataNascimento_secretaria;
    private javax.swing.JTextPane email_secretaria;
    private javax.swing.JRadioButton genero_f_secretaria;
    private javax.swing.JRadioButton genero_m_secretaria;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextPane nome_secretaria;
    private java.awt.Panel panel1;
    private javax.swing.JTextPane telefone_secretaria;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
