/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.time.LocalDate;

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
    
    public Medico(String nome, LocalDate dataNascimento, String telefone, String email, String especialidade, int crm, String genero) {
        super(nome, dataNascimento, telefone, email, genero);
        this.especialidade = especialidade;
        this.crm = crm;
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
    public void cadastrarProntuario(){
        //Cadastra um protuario para o paciente da consulta atual
    }
    
    public void atualizarProntuario(){
        //Atualiza um prontuario
    }
    
    public void removerProntuario() {
        //Deleta um prontuario
    }
    
    public void cadastrarDados(){
        //Cadastra dados medico de um paciente
    }
    
    public void  atualizarDados(){
        //Atualiza os dados medico de um paciente
    }
    
    public void removerDados(){
        //Deleta o dados medico de um paciente
    }
    
    public void receitaMedica(){
        //Emite um receita medica
    }
    
    public void atestadoMedico(){
        //Emite um atestado medico
    }
    
    public void declaracaoAcompanhamento(){
        //Emite uma declaração de aconpanhamento
    }
    
    public void relatorioMensal(){
        //Emite um relatoria mensal sobre as consultas atendidas no mês
    }
}