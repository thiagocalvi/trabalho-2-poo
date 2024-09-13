package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Medico;
import Modelo.Secretaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;

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
        // ... código gerado automaticamente pelo editor de formulários ...
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTable tabela_medicos;
    // End of variables declaration//GEN-END:variables
}
