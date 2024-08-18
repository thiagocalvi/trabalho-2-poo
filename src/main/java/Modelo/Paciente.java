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
@Table(name = "paciente")
public class Paciente{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name = "dados_medicos_id")
    //private int dadosMedicosId = 0; //0 indica que o paciente não tem nenhum dado medico cadastrado
    private DadosMedicos dadosMedicos; 
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "endereco")
    private String endereco;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_convenio")
    private tipoConvenio tipoConvenio;
    
    //Tipo convenio do paciente
    public enum tipoConvenio{
        PARTICULAR,
        PLANOSAUDE
    };
 
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

    public void setDadosMedicos(DadosMedicos dadosMedicos){
        this.dadosMedicos = dadosMedicos;
    }
    
    public DadosMedicos getDadosMedicos() {
        return this.dadosMedicos;
    }
    
    public int getId() {
        return id;
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