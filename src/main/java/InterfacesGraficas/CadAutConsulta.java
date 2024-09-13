package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Tela de cadastro e atualização de consultas.
 * Esta classe é responsável por permitir o agendamento e atualização de consultas, 
 * incluindo seleção de pacientes, médicos e definição de tipo de consulta.
 * 
 * @author matheus
 */
public class CadAutConsulta extends javax.swing.JFrame {
    private Secretaria secretaria;
    private EntityManager em;
    private GerenciadorAdm gerenciadorAdm;
    private Consulta consulta = null;
    private String Cad_Atu = "Cadastrar";
   
   /**
     * Cria uma nova instância da tela de cadastro e atualização de consultas.
     *
     * @param secretaria A instância da secretaria que gerencia os pacientes e médicos.
     * @param gerenciadorAdm O gerenciador de administração.
     * @param em O EntityManager usado para interações com o banco de dados.
     */

    public CadAutConsulta(Secretaria secretaria, GerenciadorAdm gerenciadorAdm, EntityManager em) {
        initComponents();
        this.secretaria = secretaria;
        this.gerenciadorAdm = gerenciadorAdm;
        this.em = em;
        setMedPac();
        setLocationRelativeTo(null);
    }
    
    /**
     * Inicializa as listas de médicos e pacientes nos respectivos combo boxes.
     */
    public void setMedPac(){
        paciente_consulta.removeAllItems();
        paciente_consulta.addItem("Selecione um paciente");
        paciente_consulta.setSelectedItem("Selecione um paciente");
        
        for(Paciente paciente : this.secretaria.getAllPacientes()){
            paciente_consulta.addItem(paciente.getNome());
        }
        

        
        medico_consulta.removeAllItems();
        medico_consulta.addItem("Selecione um medico");
        medico_consulta.setSelectedItem("Selecione um medico");
        
        
        for(Medico medico : this.secretaria.listarMedicos()){
            medico_consulta.addItem(medico.getNome());
        }
        
    }
    
    /**
     * Define a consulta a ser editada e atualiza a interface com os detalhes da consulta.
     *
     * @param consulta A consulta a ser editada.
     */
    public void setConsulta(Consulta consulta){
        this.consulta = consulta;
        this.Cad_Atu = "Atualizar Consulta";
        jLabel4.setText(Cad_Atu);
        jButton3.setText(Cad_Atu);
        this.setTitle(this.Cad_Atu);
        setValues();
    }

    /**
     * Preenche os campos da tela com os valores da consulta.
     */
    public void setValues(){
        data_consulta.setText(this.consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        horario_consulta.setText(this.consulta.getHorario().toString());
        
        if(this.consulta.getTipo().equals(Consulta.Tipo.NORMAL)){
            normal.setSelected(true);
        }
        else{
            retorno.setSelected(true);
        }
        
        paciente_consulta.removeAllItems();
        
        for(Paciente paciente : this.secretaria.getAllPacientes()){
            paciente_consulta.addItem(paciente.getNome());
        }
        paciente_consulta.setSelectedItem(this.consulta.getPaciente().getNome());

        
        medico_consulta.removeAllItems();
        
        for(Medico medico : this.secretaria.listarMedicos()){
            medico_consulta.addItem(medico.getNome());
        }
        
        medico_consulta.setSelectedItem(this.consulta.getMedico().getNome());

    }
    
    private void cadAutConsulta(){
        String nomeMedico_c, nomePaciente_c, tipo_c, horario_consulta_c, data_consulta_c;

        horario_consulta_c = horario_consulta.getText();
        data_consulta_c = data_consulta.getText();
        
        Medico medicoObj = null;
        Paciente pacienteObj  = null;
        
        if(normal.isSelected()){
            tipo_c = "NORMAL";
        }
        else{
            tipo_c = "RETORNO";
        }
        
        nomeMedico_c = (String) medico_consulta.getSelectedItem();
        nomePaciente_c = (String) paciente_consulta.getSelectedItem();
        
        
        if (!("Selecione um medico".equals(nomeMedico_c))) {
            // Busca o medico correspondente
            for (Medico medico : this.secretaria.listarMedicos()) {
                if (medico.getNome().equals(nomeMedico_c)) {
                    medicoObj = medico;
                    break;  // Encontre o medico e saia do loop

                }
            }
        }
        
        if (!("Selecione um paciente".equals(nomePaciente_c))) {
            // Busca o paciente correspondente
            for (Paciente paciente : this.secretaria.getAllPacientes()) {
                if (paciente.getNome().equals(nomePaciente_c)) {
                    pacienteObj = paciente;
                    break;  // Encontre o paciente e saia do loop

                }
            }
        }
        
        
        if(this.consulta == null){
            int dialogResult = JOptionPane.showConfirmDialog(this,
                        "Tem certeza que deseja agendar a consulta?",
                        "Confirmar Agendamento",
                        JOptionPane.YES_NO_OPTION);
            
            if (dialogResult == JOptionPane.YES_OPTION){
                        this.secretaria.cadastrarConsulta(pacienteObj, medicoObj, LocalDate.parse(data_consulta_c, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse(horario_consulta_c, DateTimeFormatter.ofPattern("HH:mm:ss")), tipo_c);
                        MenuSecretariaConsulta menuSecretariaConsulta = new MenuSecretariaConsulta(secretaria, gerenciadorAdm, em);
                        menuSecretariaConsulta.setVisible(true);
                        this.dispose();
                    }
        }else{
            int dialogResult = JOptionPane.showConfirmDialog(this,
                        "Tem certeza que deseja atualizar a consulta?",
                        "Confirmar Atualização",
                        JOptionPane.YES_NO_OPTION);
            
            if (dialogResult == JOptionPane.YES_OPTION){
                        this.secretaria.atualizarConsulta(this.consulta, pacienteObj, medicoObj, LocalDate.parse(data_consulta_c, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse(horario_consulta_c, DateTimeFormatter.ofPattern("HH:mm:ss")), tipo_c);
                        MenuSecretariaConsulta menuSecretariaConsulta = new MenuSecretariaConsulta(secretaria, gerenciadorAdm, em);
                        menuSecretariaConsulta.setVisible(true);
                        this.dispose();
                    }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoConsulta = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        medico_consulta = new javax.swing.JComboBox<>();
        data_consulta_label = new java.awt.Label();
        data_consulta = new javax.swing.JTextField();
        horario_consulta_label = new java.awt.Label();
        horario_consulta = new javax.swing.JTextField();
        paciente_consulta = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        normal = new javax.swing.JRadioButton();
        retorno = new javax.swing.JRadioButton();
        tipo_consulta_label = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agendamento de cosulta");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setBackground(new java.awt.Color(255, 204, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agendar Consulta");
        jLabel4.setOpaque(true);

        medico_consulta.setBackground(new java.awt.Color(255, 255, 255));
        medico_consulta.setForeground(new java.awt.Color(0, 0, 0));
        medico_consulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o medico", "Item 2", "Item 3", "Item 4" }));
        medico_consulta.setToolTipText("");

        data_consulta_label.setText("Data da consulta (dd/mm/aaaa):");

        horario_consulta_label.setText("Horario da consulta (hh:mm:ss):");

        paciente_consulta.setBackground(new java.awt.Color(255, 255, 255));
        paciente_consulta.setForeground(new java.awt.Color(0, 0, 0));
        paciente_consulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o paciente", "Item 2", "Item 3", "Item 4" }));
        paciente_consulta.setToolTipText("");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backMenuSecretariaConsulta(evt);
            }
        });

        jButton3.setText("Cadastrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadAutConsultaBtn(evt);
            }
        });

        tipoConsulta.add(normal);
        normal.setText("Normal");

        tipoConsulta.add(retorno);
        retorno.setText("Retorno");

        tipo_consulta_label.setText("Tipo consulta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(data_consulta_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(data_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(horario_consulta_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tipo_consulta_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(horario_consulta)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(medico_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(paciente_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(normal)
                                                .addGap(60, 60, 60)
                                                .addComponent(retorno)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(281, 281, 281))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(346, 346, 346))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(data_consulta_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horario_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horario_consulta_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(normal)
                        .addComponent(retorno))
                    .addComponent(tipo_consulta_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(paciente_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(medico_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        horario_consulta_label.getAccessibleContext().setAccessibleName("Horario da consulta (hh:mm:ss):");

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

    private void cadAutConsultaBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadAutConsultaBtn
        // TODO add your handling code here:
        cadAutConsulta();
    }//GEN-LAST:event_cadAutConsultaBtn

    private void backMenuSecretariaConsulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backMenuSecretariaConsulta
        // TODO add your handling code here:
        MenuSecretariaConsulta menuSecretariaConsulta = new MenuSecretariaConsulta(secretaria, gerenciadorAdm, em);
        menuSecretariaConsulta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMenuSecretariaConsulta


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField data_consulta;
    private java.awt.Label data_consulta_label;
    private javax.swing.JTextField horario_consulta;
    private java.awt.Label horario_consulta_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> medico_consulta;
    private javax.swing.JRadioButton normal;
    private javax.swing.JComboBox<String> paciente_consulta;
    private javax.swing.JRadioButton retorno;
    private javax.swing.ButtonGroup tipoConsulta;
    private java.awt.Label tipo_consulta_label;
    // End of variables declaration//GEN-END:variables
}
