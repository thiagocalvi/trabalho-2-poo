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
public class Paciente{
    //Atributos
    private int id; //gerar id
    private int dadosMedicosId = 0; //0 indica que o paciente não tem nenhum dado medico cadastrado
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String endereco;
    private tipoConvenio tipoConvenio;
    
    //tipoConvenio
    public enum tipoConvenio{
        PARTICULAR,
        PLANOSAUDE
    };
    
    //Construtor

    public Paciente(){

    }

    public Paciente(tipoConvenio tipoConvenio, String nome, LocalDate dataNascimento, String endereco, String telefone, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.tipoConvenio = tipoConvenio;
    }

    public void setDadosMedicosId(){
        this.dadosMedicosId = 0;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getDadosMedicosId() {
        return dadosMedicosId;
    }
    
    public void setDadosMedicosId(DadosMedicos dadosMedicos) {
        this.dadosMedicosId = dadosMedicos.getId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public tipoConvenio getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(tipoConvenio tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }
    
}