package InterfaceSecretaria;

import Gerenciador.GerenciadorAdm;
import Modelo.Medico;
import Modelo.Secretaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Tela que exibe uma lista de médicos para a secretária.
 * Permite visualizar os médicos cadastrados e retornar ao menu principal da secretária.
 * 
 * @author thiago
 */
public class ListaMedicosSecretaria extends javax.swing.JFrame {

    private Secretaria secretaria;
    private EntityManager em;
    private GerenciadorAdm gerenciadorAdm;

    /**
     * Construtor da classe.
     * Inicializa os atributos e configura a tabela com a lista de médicos.
     * 
     * @param secretaria a secretária associada à tela
     * @param em o EntityManager utilizado para interagir com o banco de dados
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações
     */
    public ListaMedicosSecretaria(Secretaria secretaria, EntityManager em, GerenciadorAdm gerenciadorAdm) {
        initComponents();
        this.secretaria = secretaria;
        this.em = em;
        this.gerenciadorAdm = gerenciadorAdm;
        setTableMedicos();
        setLocationRelativeTo(null);
    }

    /**
     * Inicializa os componentes da interface gráfica.
     * Não modifique este método, ele é gerado automaticamente pelo editor de formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_medicos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Secretária - Lista de médicos");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Médicos");

        tabela_medicos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabela_medicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Especialidade", "CRM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_medicos);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backMenuPrincipalSecretaria(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(331, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
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
     * Ação do botão "Voltar".
     * Retorna ao menu principal da secretária.
     * 
     * @param evt o evento de clique do botão
     */
    private void backMenuPrincipalSecretaria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backMenuPrincipalSecretaria
        MenuPrincipalSecretaria menuPrincipalSecretaria = new MenuPrincipalSecretaria(secretaria, gerenciadorAdm, em);
        menuPrincipalSecretaria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMenuPrincipalSecretaria

    /**
     * Configura a tabela com a lista de médicos.
     * Obtém os médicos cadastrados pela secretária e os exibe na tabela.
     */
    public void setTableMedicos(){
        List<Medico> medicos = this.secretaria.listarMedicos();
        
        DefaultTableModel model = (DefaultTableModel)tabela_medicos.getModel(); 
        model.setRowCount(0);
        for (Medico medico : medicos){
           Object[] linha = {medico.getNome(), medico.getEspecialidade(), Integer.toString(medico.getCrm())};
           model.addRow(linha);
       }
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tabela_medicos.setRowSorter(sorter);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTable tabela_medicos;
    // End of variables declaration//GEN-END:variables
}
