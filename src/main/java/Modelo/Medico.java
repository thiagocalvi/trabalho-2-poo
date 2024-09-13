/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Representa um médico que é um tipo de funcionário e possui informações
 * específicas como especialidade, CRM e uma secretaria associada.
 * 
 * <p>A classe {@code Medico} herda de {@code Funcionario} e fornece métodos
 * para gerenciar prontuários e dados médicos, bem como emitir receitas, atestados
 * e declarações de acompanhamento.</p>
 * 
 * @author MatheusConsoni
 */
@Entity
@Table(name = "medico")
public class Medico extends Funcionario {
    
    @Column(name = "especialidade")
    private String especialidade;
    
    @Column(name = "crm")
    private int crm;
    
    @OneToOne
    @JoinColumn(name = "secretaria_id")
    private Secretaria secretaria;
    
    @Transient
    private EntityManager em;

    /**
     * Construtor padrão para a classe {@code Medico}.
     */
    public Medico() {
        // Construtor padrão
    }

    /**
     * Construtor para inicializar um médico com os dados fornecidos.
     * 
     * @param secretaria a secretaria associada ao médico
     * @param nome o nome do médico
     * @param dataNascimento a data de nascimento do médico
     * @param telefone o telefone do médico
     * @param email o email do médico
     * @param especialidade a especialidade do médico
     * @param crm o CRM do médico
     * @param genero o gênero do médico
     */
    public Medico(Secretaria secretaria, String nome, LocalDate dataNascimento, 
                  String telefone, String email, String especialidade, 
                  int crm, String genero) {
        super(nome, dataNascimento, telefone, email, genero);
        this.especialidade = especialidade;
        this.crm = crm;
        this.secretaria = secretaria;
    }
    
    /**
     * Define o {@code EntityManager} para a classe {@code Medico}.
     * 
     * @param em o {@code EntityManager} a ser definido
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    /**
     * Obtém a especialidade do médico.
     * 
     * @return a especialidade do médico
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Define a especialidade do médico.
     * 
     * @param especialidade a nova especialidade do médico
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * Obtém o CRM do médico.
     * 
     * @return o CRM do médico
     */
    public int getCrm() {
        return crm;
    }
    
    /**
     * Define o CRM do médico.
     * 
     * @param crm o novo CRM do médico
     */
    public void setCrm(int crm) {
        this.crm = crm;
    }
    
    /**
     * Obtém a secretaria associada ao médico.
     * 
     * @return a secretaria associada ao médico
     */
    public Secretaria getSecretaria() {
        return this.secretaria;
    }
    
    /**
     * Define a secretaria associada ao médico.
     * 
     * @param secretaria a nova secretaria associada ao médico
     */
    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
    
    /**
     * Cadastra um prontuário para o paciente associado à consulta atual.
     * 
     * @param paciente o paciente para o qual o prontuário será cadastrado
     * @param consulta a consulta associada ao prontuário
     * @param sintomas os sintomas do paciente
     * @param diagnostico o diagnóstico do paciente
     * @param tratamento o tratamento recomendado
     * @return uma mensagem indicando o sucesso ou a falha da operação
     */
    
    
    public String cadastrarProntuario(Paciente paciente, Consulta consulta, String sintomas, String diagnostico, String tratamento){
        //Cadastra um protuario para o paciente da consulta atual
        //Um prontuario só pode ser cadastrado dentro do contexto de uma consulta
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            Prontuario prontuario = new Prontuario(paciente, consulta, sintomas, diagnostico, tratamento);
            consulta.setProntuario(prontuario);
            em.persist(prontuario);
            transaction.commit();
            return "Prontuário cadastrado!";
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }
    
    /**
     * Atualiza um prontuário existente com os novos dados fornecidos.
     * 
     * @param prontuario o prontuário a ser atualizado
     * @param paciente o paciente associado ao prontuário
     * @param consulta a consulta associada ao prontuário
     * @param sintomas os novos sintomas do paciente
     * @param diagnostico o novo diagnóstico do paciente
     * @param tratamento o novo tratamento recomendado
     * @return uma mensagem indicando o sucesso ou a falha da operação
     */
    public String atualizarProntuario(Prontuario prontuario, Paciente paciente, Consulta consulta, String sintomas, String diagnostico, String tratamento){
        //Atualiza um prontuario
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            prontuario.setPaciente(paciente);
            prontuario.setConsulta(consulta);
            prontuario.setSintomas(sintomas);
            prontuario.setDiagnostico(diagnostico);
            prontuario.setTratamento(tratamento);
            em.merge(prontuario);
            transaction.commit();
            return "Prontuário atualizado!";
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }
    
    /**
     * Remove um prontuário com base no ID fornecido.
     * 
     * @param prontuarioId o ID do prontuário a ser removido
     * @return uma mensagem indicando o sucesso ou a falha da operação
     */
    public String removerProntuario(int prontuarioId) {
        //Deleta um prontuario
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Prontuario prontuario = em.find(Prontuario.class, prontuarioId);
            if (prontuario != null) {
                prontuario.setConsulta(null);
                prontuario.setPaciente(null);
                em.remove(prontuario);
                transaction.commit();
                return "Prontuario removido!";
            } else {
                transaction.commit();
                return "Prontuario não encontrada";
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    
    }
    
    /**
     * Cadastra dados médicos para um paciente específico.
     * 
     * @param paciente o paciente para o qual os dados médicos serão cadastrados
     * @param fuma indica se o paciente fuma
     * @param bebe indica se o paciente bebe
     * @param colesterol o nível de colesterol do paciente
     * @param diabete indica se o paciente tem diabete
     * @param doencaCardiaca indica se o paciente tem doença cardíaca
     * @param cirurgias uma lista de cirurgias anteriores do paciente
     * @param alergias uma lista de alergias do paciente
     * @return uma mensagem indicando o sucesso ou a falha da operação
     */
    public String cadastrarDados(Paciente paciente, boolean fuma, boolean bebe, String colesterol, boolean diabete, boolean doencaCardiaca, float peso, List<String> cirurgias, List<String> alergias){
        //Cadastra dados medico de um paciente
        EntityTransaction transaction = em.getTransaction();
        try {
            if(paciente.getDadosMedicos() != null){
                return null;
            }
            
            transaction.begin();
            DadosMedicos dadosMedicos = new DadosMedicos(paciente,fuma, bebe,colesterol, diabete, doencaCardiaca, peso, cirurgias, alergias);
            paciente.setDadosMedicos(dadosMedicos);
            dadosMedicos.setPaciente(paciente);
            em.persist(dadosMedicos);
            transaction.commit();
            return "Dados médicos cadastrados!";
            
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }
    
    /**
     * Atualiza os dados médicos de um paciente existente.
     * 
     * @param dadosMedico os dados médicos a serem atualizados
     * @param fuma indica se o paciente fuma
     * @param bebe indica se o paciente bebe
     * @param colesterol o nível de colesterol do paciente
     * @param diabete indica se o paciente tem diabete
     * @param doencaCardiaca indica se o paciente tem doença cardíaca
     * @param cirurgias uma lista de cirurgias anteriores do paciente
     * @param alergias uma lista de alergias do paciente
     * @return uma mensagem indicando o sucesso ou a falha da operação
     */
    public String atualizarDados(DadosMedicos dadosMedico, boolean fuma, boolean bebe, String colesterol, boolean diabete, boolean doencaCardiaca, float peso, List<String> cirurgias, List<String> alergias){
        //Atualiza os dados medico de um paciente, paciente do dados medico não pode ser alterado
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            dadosMedico.setFuma(fuma);
            dadosMedico.setBebe(bebe);
            dadosMedico.setColesterol(colesterol);
            dadosMedico.setDiabete(diabete);
            dadosMedico.setDoencaCardiaca(doencaCardiaca);
            dadosMedico.setPeso(peso);
            
//            List<String> cirurgiasAtualizadas = (cirurgias != null) ? new ArrayList<>(cirurgias) : new ArrayList<>();
//            List<String> alergiasAtualizadas = (alergias != null) ? new ArrayList<>(alergias) : new ArrayList<>();
//            
            dadosMedico.setCirurgias(cirurgias);
            dadosMedico.setAlergias(alergias);
            em.merge(dadosMedico);
            transaction.commit();
            return "Dados medicos Atualizado";
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            
            System.out.println("DEU ERRO!");
            e.printStackTrace();
            return "Erro: " + e.getMessage();
        }
    }
    
    /**
     * Remove os dados médicos de um paciente com base no ID fornecido.
     * 
     * @param dadosMedicoId o ID dos dados médicos a serem removidos
     * @return uma mensagem indicando o sucesso ou a falha da operação
     */
    public String removerDados(int dadosMedicoId){
        //Deleta o dados medico de um paciente
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            DadosMedicos dadosMedico = em.find(DadosMedicos.class, dadosMedicoId);
            if (dadosMedico != null) {
                dadosMedico.getPaciente().setDadosMedicos(null);
                dadosMedico.setPaciente(null);
                em.remove(dadosMedico);
                transaction.commit();
                return "Dados médico removido!";
            } else {
                transaction.commit();
                return "Dados medico não encontrada";
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }
    
    /**
     * Emite uma receita médica para a consulta fornecida.
     * 
     * @param consulta a consulta associada à receita médica
     * @return uma mensagem indicando o sucesso da emissão da receita
     */
    public String receitaMedica(Consulta consulta){
        //Emite um receita medica
        return "Receita emitida";
    }
    
     /**
     * Emite um atestado médico para a consulta fornecida.
     * 
     * @param consulta a consulta associada ao atestado médico
     * @return uma mensagem indicando o sucesso da emissão do atestado
     */
    public String atestadoMedico(Consulta consulta){
        //Emite um atestado medico
        return "Atestado emitido";
    }
    
    /**
     * Emite uma declaração de acompanhamento para a consulta fornecida.
     * 
     * @param consulta a consulta associada à declaração de acompanhamento
     * @return uma mensagem indicando o sucesso da emissão da declaração
     */
    public String declaracaoAcompanhamento(Consulta consulta){
        //Emite uma declaração de aconpanhamento
        return "Declaração de acompanhamento emitida";
    }
    
    /**
     * Gera um relatório mensal sobre as consultas atendidas no mês.
     * <p>
     * O relatório deve buscar todas as consultas associadas ao médico,
     * filtrar por consultas finalizadas e pela data da consulta.
     * </p>
     */
    public void relatorioMensal(){
        //Emite um relatoria mensal sobre as consultas atendidas no mês
        //Buscar todas as consultas associadas ao medico
        //Filtrar por consulta finalizada
        //E pela data da consulta
    }
    
    public List<Prontuario> listarProntuario(Paciente paciente, Medico medico) {
        try {
            // Inicia a transação
            this.em.getTransaction().begin();

            // Executa a query e obtém diretamente a lista de prontuários
            List<Prontuario> listProntuario = this.em.createQuery(
                "SELECT p FROM Prontuario p JOIN p.consulta c WHERE p.paciente = :paciente AND " 
                        + "c.medico = :medico ORDER BY c.data DESC, c.horario DESC", 
                Prontuario.class)
                .setParameter("paciente", paciente)
                .setParameter("medico", medico)
                .getResultList();

            // Finaliza a transação
            this.em.getTransaction().commit();

            // Retorna a lista de prontuários
            return listProntuario;
        } catch (Exception e) {
            // Em caso de erro, faz rollback da transação e lança a exceção
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw new RuntimeException("Erro ao listar prontuários.", e);
        }
    }
}

   