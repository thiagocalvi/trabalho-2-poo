/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfaceMedico;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Tela para cadastro e atualização de dados médicos dos pacientes.
 * Permite ao usuário cadastrar novos dados médicos ou atualizar dados existentes.
 * 
 * @author matheus
 */
public class CadAtuDadosMedico extends javax.swing.JFrame {
    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Consulta consulta;
    private EntityManager em;
    private String Cad_Atu = "Cadastrar";

    /**
     * Construtor da tela de cadastro e atualização de dados médicos.
     * 
     * @param gerenciadorAdm O gerenciador de administração.
     * @param medico O médico associado.
     * @param consulta A consulta associada.
     * @param em O EntityManager para operações de banco de dados.
     */
    public CadAtuDadosMedico(GerenciadorAdm gerenciadorAdm, Medico medico, Consulta consulta, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.medico = medico;
        this.consulta = consulta;
        this.em = em;
        initComponents();
        setNome();
        setLocationRelativeTo(null);
    }

    /**
     * Define os nomes do paciente e médico na tela.
     */
    private void setNome(){
        lblNomePaciente.setText(" " + consulta.getPaciente().getNome());
        lblNomeMedico.setText(" " + medico.getNome());
    }

    /**
     * Configura a tela para cadastro ou atualização de dados médicos.
     * 
     * @param atualizar Define se a operação é de cadastro ou atualização.
     */
    public void configureDisplay(String atualizar){
        this.Cad_Atu = atualizar;
        setTitle("Atualizar dados médicos");
        lblSubTitulo.setText("Atualizar dados adicionais");
        btnCadAtu.setText(atualizar);
        setValues();
    }

    /**
     * Preenche os campos da tela com os valores atuais dos dados médicos.
     */
    private void setValues(){
        // Define os valores dos campos de acordo com os dados médicos do paciente.
        if (consulta.getPaciente().getDadosMedicos().isBebe()) {
            BSim.setSelected(true);
        } else {
            BNao.setSelected(true);
        }

        if (consulta.getPaciente().getDadosMedicos().isFuma()) {
            FSim.setSelected(true);
        } else {
            FNao.setSelected(true);
        }

        if (consulta.getPaciente().getDadosMedicos().isDiabete()) {
            DiSim.setSelected(true);
        } else {
            DiNao.setSelected(true);
        }

        if (consulta.getPaciente().getDadosMedicos().isDoencaCardiaca()) {
            DoSim.setSelected(true);
        } else {
            DoNao.setSelected(true);
        }

        // Preenche os campos de texto com os valores dos dados médicos.
        txtColesterol.setText(consulta.getPaciente().getDadosMedicos().getColesterol());
        txtPeso.setText(String.valueOf(consulta.getPaciente().getDadosMedicos().getPeso()));
        txtCirurgias.setText(String.join(", ", consulta.getPaciente().getDadosMedicos().getCirurgias()));
        txtAlergias.setText(String.join(", ", consulta.getPaciente().getDadosMedicos().getAlergias())); 
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fuma = new javax.swing.ButtonGroup();
        diabete = new javax.swing.ButtonGroup();
        bebe = new javax.swing.ButtonGroup();
        doenca = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        btnCadAtu = new javax.swing.JButton();
        lblNomePaciente = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        BSim = new javax.swing.JRadioButton();
        BNao = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        FSim = new javax.swing.JRadioButton();
        FNao = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        DiSim = new javax.swing.JRadioButton();
        DiNao = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        DoSim = new javax.swing.JRadioButton();
        DoNao = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        txtColesterol = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCirurgias = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlergias = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNomeMedico = new javax.swing.JLabel();
        lblSubTitulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar dados médicos");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(830, 730));
        setResizable(false);

        panel2.setBackground(new java.awt.Color(204, 204, 204));

        btnCadAtu.setBackground(new java.awt.Color(51, 204, 0));
        btnCadAtu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadAtu.setForeground(new java.awt.Color(255, 255, 255));
        btnCadAtu.setText("Cadastrar");
        btnCadAtu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_Cad_Atu_dados(evt);
            }
        });

        lblNomePaciente.setBackground(new java.awt.Color(255, 255, 255));
        lblNomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNomePaciente.setForeground(new java.awt.Color(0, 0, 0));
        lblNomePaciente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomePaciente.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Pacente:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Bebe?");

        BSim.setBackground(new java.awt.Color(255, 255, 255));
        bebe.add(BSim);
        BSim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BSim.setForeground(new java.awt.Color(0, 0, 0));
        BSim.setText("Sim");

        BNao.setBackground(new java.awt.Color(255, 255, 255));
        bebe.add(BNao);
        BNao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BNao.setForeground(new java.awt.Color(0, 0, 0));
        BNao.setText("Não");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BSim, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BNao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(BSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BNao, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(153, 153, 153));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Fuma?");

        FSim.setBackground(new java.awt.Color(255, 255, 255));
        fuma.add(FSim);
        FSim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FSim.setForeground(new java.awt.Color(0, 0, 0));
        FSim.setText("Sim");

        FNao.setBackground(new java.awt.Color(255, 255, 255));
        fuma.add(FNao);
        FNao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FNao.setForeground(new java.awt.Color(0, 0, 0));
        FNao.setText("Não");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FSim, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FNao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(FSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FNao, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(153, 153, 153));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Diabete?");

        DiSim.setBackground(new java.awt.Color(255, 255, 255));
        diabete.add(DiSim);
        DiSim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiSim.setForeground(new java.awt.Color(0, 0, 0));
        DiSim.setText("Sim");

        DiNao.setBackground(new java.awt.Color(255, 255, 255));
        diabete.add(DiNao);
        DiNao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiNao.setForeground(new java.awt.Color(0, 0, 0));
        DiNao.setText("Não");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(DiSim, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DiNao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(DiSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DiNao, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setForeground(new java.awt.Color(153, 153, 153));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Doença cardiaca?");

        DoSim.setBackground(new java.awt.Color(255, 255, 255));
        doenca.add(DoSim);
        DoSim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DoSim.setForeground(new java.awt.Color(0, 0, 0));
        DoSim.setText("Sim");

        DoNao.setBackground(new java.awt.Color(255, 255, 255));
        doenca.add(DoNao);
        DoNao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DoNao.setForeground(new java.awt.Color(0, 0, 0));
        DoNao.setText("Não");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(DoSim, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DoNao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(DoSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DoNao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Nivel de colesterol:");

        txtColesterol.setBackground(new java.awt.Color(255, 255, 255));
        txtColesterol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Peso(kg):");

        txtPeso.setBackground(new java.awt.Color(255, 255, 255));
        txtPeso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Cirurgias(Separa-as por vírgula):");

        txtCirurgias.setBackground(new java.awt.Color(255, 255, 255));
        txtCirurgias.setColumns(20);
        txtCirurgias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCirurgias.setForeground(new java.awt.Color(0, 0, 0));
        txtCirurgias.setRows(5);
        txtCirurgias.setToolTipText("");
        jScrollPane1.setViewportView(txtCirurgias);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Alergias(Separa-as por vírgula):");

        txtAlergias.setBackground(new java.awt.Color(255, 255, 255));
        txtAlergias.setColumns(20);
        txtAlergias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAlergias.setForeground(new java.awt.Color(0, 0, 0));
        txtAlergias.setRows(5);
        txtAlergias.setToolTipText("");
        jScrollPane2.setViewportView(txtAlergias);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtColesterol, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(btnCadAtu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColesterol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadAtu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        lblNomeMedico.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeMedico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNomeMedico.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomeMedico.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblNomeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSubTitulo.setBackground(new java.awt.Color(204, 204, 204));
        lblSubTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSubTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblSubTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubTitulo.setText("Cadastrar dados adicionais");
        lblSubTitulo.setToolTipText("");
        lblSubTitulo.setOpaque(true);

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuDadosMedicos(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSubTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Realiza o cadastro ou atualização dos dados médicos ao clicar no botão.
     * 
     * @param evt O evento de clique do botão.
     */
    private void go_Cad_Atu_dados(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_Cad_Atu_dados
        // Obtém os valores selecionados nos campos de dados médicos.
        boolean fuma = FSim.isSelected();
        boolean bebe = BSim.isSelected();
        boolean diabete = DiSim.isSelected();
        boolean doenca = DoSim.isSelected();

        String colesterol = txtColesterol.getText();
        float peso = Float.parseFloat(txtPeso.getText().replace(",", "."));
        List<String> cirurgias = new ArrayList<>(List.of(txtCirurgias.getText().split("[,\\.]")));      
        List<String> alergias = new ArrayList<>(List.of(txtAlergias.getText().split("[,\\.]")));

        // Verifica se o usuário deseja cadastrar ou atualizar os dados médicos.        
        if (Cad_Atu.equals("Cadastrar")){
            int dialogResult = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja 'CADASTRAR' os Dados médicos?",
                "Confirmar Cadastro",
                JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                medico.cadastrarDados(consulta.getPaciente(), fuma, bebe, colesterol, diabete, doenca, peso, cirurgias, alergias);
                MenuDadosMedicos menuDadosMedicos = new MenuDadosMedicos(gerenciadorAdm, medico, consulta, em);
                menuDadosMedicos.setVisible(true);
                this.dispose();
            }
            
        } else if (Cad_Atu.equals("Atualizar")) {
            int dialogResult = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja 'ATUALIZAR' os Dados médicos?",
                "Confirmar Atualização",
                JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                medico.atualizarDados(consulta.getPaciente().getDadosMedicos(), fuma, bebe, colesterol, diabete, doenca, peso, cirurgias, alergias);
                MenuDadosMedicos menuDadosMedicos = new MenuDadosMedicos(gerenciadorAdm, medico, consulta, em);
                menuDadosMedicos.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_go_Cad_Atu_dados

    /**
     * Retorna para o menu de dados médicos ao clicar no botão "Voltar".
     * 
     * @param evt O evento de clique do botão "Voltar".
     */
    private void back_menuDadosMedicos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuDadosMedicos
        MenuDadosMedicos menuDadosMedicos = new MenuDadosMedicos(gerenciadorAdm, medico, consulta, em);
        menuDadosMedicos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_menuDadosMedicos

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BNao;
    private javax.swing.JRadioButton BSim;
    private javax.swing.JRadioButton DiNao;
    private javax.swing.JRadioButton DiSim;
    private javax.swing.JRadioButton DoNao;
    private javax.swing.JRadioButton DoSim;
    private javax.swing.JRadioButton FNao;
    private javax.swing.JRadioButton FSim;
    private javax.swing.ButtonGroup bebe;
    private javax.swing.JButton btnCadAtu;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup diabete;
    private javax.swing.ButtonGroup doenca;
    private javax.swing.ButtonGroup fuma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNomeMedico;
    private javax.swing.JLabel lblNomePaciente;
    private javax.swing.JLabel lblSubTitulo;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTextArea txtAlergias;
    private javax.swing.JTextArea txtCirurgias;
    private javax.swing.JTextField txtColesterol;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}