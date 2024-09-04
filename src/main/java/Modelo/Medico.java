/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author MatheusConsoni
 */

@Entity
@Table(name = "medico")
public class Medico extends Funcionario{
    @Column(name = "especialidade")
    private String especialidade;
    
    @Column(name = "crm")
    private int crm;
    
    @OneToOne
    @JoinColumn(name = "secretaria_id")
    private Secretaria secretaria;

    
    @Transient
    private EntityManager em;
    
    public Medico(){
        
    }
    
    public Medico(Secretaria secretaria, String nome, LocalDate dataNascimento, String telefone, String email, String especialidade, int crm, String genero) {
        super(nome, dataNascimento, telefone, email, genero);
        this.especialidade = especialidade;
        this.crm = crm;
        this.secretaria = secretaria;
    }
    
    public void setEm(EntityManager em){
        this.em = em;
    }
    
    
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getCrm() {
        return crm;
    }
    
    public void setCrm(int crm){
        this.crm = crm;
    }
    
    public Secretaria getSecretaria(){
        return this.secretaria;
    }
    
    public void setSecretaria(Secretaria secretaria){
        this.secretaria = secretaria;
    }
        
    //********************************************************//
    public String cadastrarProntuario(Paciente paciente, Consulta consulta, String sintomas, String diagnostico, String tratamento){
        //Cadastra um protuario para o paciente da consulta atual
        //Um prontuario só pode ser cadastrado dento do contexto de uma consulta
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            Prontuario prontuario = new Prontuario(paciente, consulta, sintomas, diagnostico, tratamento);
            em.persist(prontuario);
            transaction.commit();
            return "Prontuario cadastrado";
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }
    
    public String atualizarProntuario(Prontuario prontuario, Paciente paciente, Consulta consulta, String sintomas, String diagnostico, String tratamento){
        //Atualiza um prontuario
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            prontuario.setPacienteId(paciente);
            prontuario.setConsulta(consulta);
            prontuario.setSintomas(sintomas);
            prontuario.setDiagnostico(diagnostico);
            prontuario.setTratamento(tratamento);
            em.merge(prontuario);
            transaction.commit();
            return "Prontuario Atualizado";
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }
    
    public String removerProntuario(int prontuarioId) {
        //Deleta um prontuario
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Prontuario prontuario = em.find(Prontuario.class, prontuarioId);
            if (prontuario != null) {
                em.remove(prontuario);
                transaction.commit();
                return "Prontuario removida!";
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
    
    public String cadastrarDados(Paciente paciente, boolean fuma, boolean bebe, String colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias){
        //Cadastra dados medico de um paciente
        EntityTransaction transaction = em.getTransaction();
        try {
            if(paciente.getDadosMedicos() != null){
                return "O paciente já possui dados medicos cadastrado!";
            }
            
            transaction.begin();
            DadosMedicos dadosMedicos = new DadosMedicos(paciente,fuma, bebe,colesterol, diabete, doencaCardiaca, cirurgias, alergias);
            paciente.setDadosMedicos(dadosMedicos);
            em.persist(dadosMedicos);
            transaction.commit();
            return "Dados medicos cadastrado!";
            
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }
    
    public String  atualizarDados(DadosMedicos dadosMedico, boolean fuma, boolean bebe, String colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias){
        //Atualiza os dados medico de um paciente, paciente do dados medico não pode ser alterado
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            dadosMedico.setFuma(fuma);
            dadosMedico.setBebe(bebe);
            dadosMedico.setColesterol(colesterol);
            dadosMedico.setDiabete(diabete);
            dadosMedico.setDoencaCardiaca(doencaCardiaca);
            dadosMedico.setCirurgias(cirurgias);
            dadosMedico.setAlergias(alergias);
            em.merge(dadosMedico);
            transaction.commit();
            return "Dados medicos Atualizado";
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }
    
    public String removerDados(int dadosMedicoId){
        //Deleta o dados medico de um paciente
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            DadosMedicos dadosMedico = em.find(DadosMedicos.class, dadosMedicoId);
            if (dadosMedico != null) {
                em.remove(dadosMedico);
                transaction.commit();
                return "Dados medico removida!";
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
    
    public String receitaMedica(Consulta consulta){
        //Emite um receita medica
        return "Receita emitida";
    }
    
    public String atestadoMedico(Consulta consulta){
        //Emite um atestado medico
        return "Atestado emitido";
    }
    
    public String declaracaoAcompanhamento(Consulta consulta){
        //Emite uma declaração de aconpanhamento
        return "Declaração de acompanhamento emitida";
    }
    
    public void relatorioMensal(){
        //Emite um relatoria mensal sobre as consultas atendidas no mês
        //Buscar todas as consultas associadas ao medico
        //Filtrar por consulta finalizada
        //E pela data da consulta
    }
}