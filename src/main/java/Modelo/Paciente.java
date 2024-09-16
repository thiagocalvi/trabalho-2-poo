/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import javax.persistence.*;

/**
 * A classe {@code Paciente} representa um paciente. 
 * Ela armazena os dados pessoais do paciente, suas informações
 * de contato, endereço, dados médicos associados, e o tipo de convênio que ele possui.
 * 
 * <p>Os pacientes podem ter diferentes tipos de convênios (particular ou plano de saúde)
 * e podem estar associados a uma instância da classe {@link DadosMedicos}, que armazena
 * informações médicas adicionais.</p>
 * 
 * <p>Esta classe é uma entidade JPA mapeada para a tabela "paciente" no banco de dados.</p>
 * 
 * @author MatheusConsoni
 */
@Entity
@Table(name = "paciente")
public class Paciente {

    /**
     * Identificador único do paciente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Dados médicos associados ao paciente.
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dados_medicos_id")
    private DadosMedicos dadosMedicos;

    /**
     * Nome do paciente.
     */
    @Column(name = "nome")
    private String nome;

    /**
     * Data de nascimento do paciente.
     */
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    /**
     * Telefone de contato do paciente.
     */
    @Column(name = "telefone")
    private String telefone;

    /**
     * Endereço de email do paciente.
     */
    @Column(name = "email")
    private String email;

    /**
     * Endereço residencial do paciente.
     */
    @Column(name = "endereco")
    private String endereco;

    /**
     * Tipo de convênio do paciente (particular ou plano de saúde).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_convenio")
    private tipoConvenio tipoConvenio;

    /**
     * Sexo do paciente.
     */
    @Column(name = "sexo")
    private String sexo;

    /**
     * Idade do paciente.
     */
    @Column(name = "idade")
    private int idade;

    /**
     * Enumeração para os tipos de convênio do paciente.
     */
    public enum tipoConvenio {
        PARTICULAR,
        PLANOSAUDE
    }

    /**
     * Construtor padrão da classe {@code Paciente}.
     */
    public Paciente() {}

    /**
     * Construtor da classe {@code Paciente} que inicializa o paciente com os dados fornecidos.
     * 
     * @param tipoConvenio O tipo de convênio do paciente.
     * @param nome O nome do paciente.
     * @param dataNascimento A data de nascimento do paciente.
     * @param endereco O endereço residencial do paciente.
     * @param telefone O telefone de contato do paciente.
     * @param email O endereço de email do paciente.
     */
    public Paciente(tipoConvenio tipoConvenio, String nome, LocalDate dataNascimento, String endereco, String telefone, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.tipoConvenio = tipoConvenio;
    }

    /**
     * Define a idade do paciente.
     * 
     * @param idade A idade do paciente.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna a idade do paciente.
     * 
     * @return A idade do paciente.
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * Define o sexo do paciente.
     * 
     * @param sexo O sexo do paciente.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Retorna o sexo do paciente.
     * 
     * @return O sexo do paciente.
     */
    public String getSexo() {
        return this.sexo;
    }

    /**
     * Define os dados médicos associados ao paciente.
     * 
     * @param dadosMedicos Os dados médicos do paciente.
     */
    public void setDadosMedicos(DadosMedicos dadosMedicos) {
        this.dadosMedicos = dadosMedicos;
    }

    /**
     * Retorna os dados médicos associados ao paciente.
     * 
     * @return Os dados médicos do paciente.
     */
    public DadosMedicos getDadosMedicos() {
        return this.dadosMedicos;
    }

    /**
     * Retorna o identificador único do paciente.
     * 
     * @return O identificador único do paciente.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do paciente.
     * 
     * @return O nome do paciente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do paciente.
     * 
     * @param nome O nome do paciente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a data de nascimento do paciente.
     * 
     * @return A data de nascimento do paciente.
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento do paciente.
     * 
     * @param dataNascimento A data de nascimento do paciente.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna o telefone de contato do paciente.
     * 
     * @return O telefone de contato do paciente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone de contato do paciente.
     * 
     * @param telefone O telefone de contato do paciente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o endereço de email do paciente.
     * 
     * @return O endereço de email do paciente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do paciente.
     * 
     * @param email O endereço de email do paciente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o endereço residencial do paciente.
     * 
     * @return O endereço residencial do paciente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço residencial do paciente.
     * 
     * @param endereco O endereço residencial do paciente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o tipo de convênio do paciente.
     * 
     * @return O tipo de convênio do paciente.
     */
    public tipoConvenio getTipoConvenio() {
        return tipoConvenio;
    }

    /**
     * Define o tipo de convênio do paciente.
     * 
     * @param tipoConvenio O tipo de convênio do paciente.
     */
    public void setTipoConvenio(tipoConvenio tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }
}
