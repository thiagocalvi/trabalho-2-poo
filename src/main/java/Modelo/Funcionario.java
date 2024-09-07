/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import javax.persistence.*;

/**
 * A classe {@code Funcionario} representa um funcionário genérico em um sistema.
 * Ela serve como uma superclasse mapeada para outras entidades que compartilham
 * atributos comuns, como nome, data de nascimento, gênero, telefone, e email.
 * <p>
 * Esta classe é uma {@code MappedSuperclass} no JPA, o que significa que suas
 * propriedades serão herdadas por outras classes de entidade, mas a própria
 * {@code Funcionario} não será uma entidade persistida diretamente.
 * </p>
 * 
 * <p>Os funcionários podem incluir diferentes tipos de usuários dentro de um sistema,
 * como médicos, secretárias, ou outros tipos de funcionários que compartilham esses
 * atributos básicos.</p>
 * 
 * @author thiago
 */
@MappedSuperclass
public class Funcionario {

    /**
     * Identificador único do funcionário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nome do funcionário.
     */
    @Column(name = "nome")
    private String nome;

    /**
     * Data de nascimento do funcionário.
     */
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    /**
     * Gênero do funcionário.
     */
    @Column(name = "genero")
    private String genero;

    /**
     * Telefone de contato do funcionário.
     */
    @Column(name = "telefone")
    private String telefone;

    /**
     * Endereço de email do funcionário.
     */
    @Column(name = "email")
    private String email;

    /**
     * Construtor padrão da classe {@code Funcionario}.
     */
    public Funcionario() {}

    /**
     * Construtor da classe {@code Funcionario} que inicializa o funcionário com 
     * os dados fornecidos.
     * 
     * @param nome O nome do funcionário.
     * @param dataNascimento A data de nascimento do funcionário.
     * @param telefone O telefone de contato do funcionário.
     * @param email O endereço de email do funcionário.
     * @param genero O gênero do funcionário.
     */
    public Funcionario(String nome, LocalDate dataNascimento, String telefone, String email, String genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
    }

    /**
     * Retorna o identificador único do funcionário.
     * 
     * @return O identificador único do funcionário.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do funcionário.
     * 
     * @return O nome do funcionário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do funcionário.
     * 
     * @param nome O nome do funcionário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a data de nascimento do funcionário.
     * 
     * @return A data de nascimento do funcionário.
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento do funcionário.
     * 
     * @param dataNascimento A data de nascimento do funcionário.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna o gênero do funcionário.
     * 
     * @return O gênero do funcionário.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Define o gênero do funcionário.
     * 
     * @param genero O gênero do funcionário.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Retorna o telefone de contato do funcionário.
     * 
     * @return O telefone de contato do funcionário.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone de contato do funcionário.
     * 
     * @param telefone O telefone de contato do funcionário.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o endereço de email do funcionário.
     * 
     * @return O endereço de email do funcionário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do funcionário.
     * 
     * @param email O endereço de email do funcionário.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
