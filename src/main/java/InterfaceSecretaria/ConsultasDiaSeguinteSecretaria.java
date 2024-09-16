package InterfaceSecretaria;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Secretaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;

/**
 * Tela que exibe as consultas agendadas para o dia seguinte para a secretaria.
 * Esta classe apresenta uma tabela com as consultas e oferece a opção de voltar ao menu da secretaria.
 * 
 * @author thiago
 */
public class ConsultasDiaSeguinteSecretaria extends javax.swing.JFrame {

    private Secretaria secretaria;
    private EntityManager em;
    private GerenciadorAdm gerenciadorAdm;

    /**
     * Construtor da classe.
     * Inicializa os atributos e configura os componentes da interface.
     * 
     * @param secretaria a secretaria que está visualizando as consultas
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public ConsultasDiaSeguinteSecretaria(Secretaria secretaria, GerenciadorAdm gerenciadorAdm, EntityManager em) {
        initComponents();
        this.secretaria = secretaria;
        this.em = em;
        this.gerenciadorAdm = gerenciadorAdm;
        setTable();
        setLocationRelativeTo(null); // Centraliza a janela
    }

    /**
     * Inicializa os componentes da interface gráfica.
     * WARNING: Não modifique este código. O conteúdo deste método é sempre gerado pelo Editor de Formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_consulta = new javax.swing.JTable();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatório - Consultas do dia seguinte");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        tabela_consulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabela_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Paciente", "Horario", "Medico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_consulta);

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Consultas do Dia Seguinte");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backMenuSecretariaConsulta(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Preenche a tabela com as consultas agendadas para o dia seguinte.
     * Obtém as consultas através do método {@link Secretaria#gerarRelatorioConsultasDiaSeguinte()}.
     */
    public void setTable(){
        List<Consulta> consultas = this.secretaria.gerarRelatorioConsultasDiaSeguinte();
        
        DefaultTableModel model = (DefaultTableModel)tabela_consulta.getModel(); 
        model.setRowCount(0);
        for (Consulta consulta : consultas){
           Object[] linha = {consulta.getPaciente().getNome(), consulta.getHorario(), consulta.getMedico().getNome()};
           model.addRow(linha);
       }
    }
    
    /**
     * Volta para o menu de consultas da secretaria.
     * 
     * @param evt o evento de clique do botão
     */
    private void backMenuSecretariaConsulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backMenuSecretariaConsulta
        MenuSecretariaConsulta menuSecretariaConsulta = new MenuSecretariaConsulta(secretaria, gerenciadorAdm, em);
        menuSecretariaConsulta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMenuSecretariaConsulta

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTable tabela_consulta;
    // End of variables declaration//GEN-END:variables
}
