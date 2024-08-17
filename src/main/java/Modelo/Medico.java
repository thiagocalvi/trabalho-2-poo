/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.time.LocalDate;

/**
 *
 * @author MatheusConsoni
 */
public class Medico extends Funcionario{
    private String especialidade;
    private int crm;
    private int secretariaId = 0; // 0 indica que o medico não tem nenhuma secretaria (cada medico terá somente uma secretaria)

    public Medico(String nome, LocalDate dataNascimento, String telefone, String email, String especialidade, int crm) {
        super(nome, dataNascimento, telefone, email);
        this.especialidade = especialidade;
        this.crm = crm;
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
    
    public int getSecretariaId(){
        return secretariaId;
    }
    
    public void setSecretariaId(Secretaria secretaria){
        this.secretariaId = secretaria.getId();
    }
        
    //********************************************************//
    public void cadastrarProntuario(){
        
    }
}