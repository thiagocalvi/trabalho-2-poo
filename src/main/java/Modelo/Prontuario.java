/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.persistence.*;

/**
 * A classe {@code Prontuario} representa o prontuário médico de um paciente,
 * armazenando informações sobre os sintomas, diagnóstico e tratamento
 * relacionados a uma consulta específica.
 * 
 * <p>Esta classe é uma entidade JPA mapeada para a tabela "prontuario" no banco de dados.
 * Um prontuário está associado a um paciente e a uma consulta específica.</p>
 * 
 * @author MatheusConsoni
 */
@Entity
@Table(name = "prontuario")
public class Prontuario {

    /**
     * Identificador único do prontuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * O paciente associado a este prontuário.
     */
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    /**
     * A consulta associada a este prontuário.
     */
    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    /**
     * Os sintomas relatados pelo paciente.
     */
    @Column(name = "sintoma")
    private String sintomas;

    /**
     * O diagnóstico dado ao paciente.
     */
    @Column(name = "diagnostico")
    private String diagnostico;

    /**
     * O tratamento prescrito ao paciente.
     */
    @Column(name = "tratamento")
    private String tratamento;

    /**
     * Construtor padrão da classe {@code Prontuario}.
     */
    public Prontuario() {}

    /**
     * Construtor da classe {@code Prontuario} que inicializa o prontuário com os dados fornecidos.
     * 
     * @param paciente O paciente associado ao prontuário.
     * @param consulta A consulta associada ao prontuário.
     * @param sintomas Os sintomas relatados pelo paciente.
     * @param diagnostico O diagnóstico dado ao paciente.
     * @param tratamento O tratamento prescrito ao paciente.
     */
    public Prontuario(Paciente paciente, Consulta consulta, String sintomas, String diagnostico, String tratamento) {
        this.paciente = paciente;
        this.consulta = consulta;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
    }

    /**
     * Retorna o identificador único do prontuário.
     * 
     * @return O identificador único do prontuário.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Retorna o paciente associado ao prontuário.
     * 
     * @return O paciente associado ao prontuário.
     */
    public Paciente getPaciente() {
        return this.paciente;
    }

    /**
     * Define o paciente associado ao prontuário.
     * 
     * @param paciente O paciente associado ao prontuário.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Retorna a consulta associada ao prontuário.
     * 
     * @return A consulta associada ao prontuário.
     */
    public Consulta getConsulta() {
        return consulta;
    }

    /**
     * Define a consulta associada ao prontuário.
     * 
     * @param consulta A consulta associada ao prontuário.
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    /**
     * Retorna os sintomas relatados pelo paciente.
     * 
     * @return Os sintomas relatados pelo paciente.
     */
    public String getSintomas() {
        return sintomas;
    }

    /**
     * Define os sintomas relatados pelo paciente.
     * 
     * @param sintomas Os sintomas relatados pelo paciente.
     */
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    /**
     * Retorna o diagnóstico dado ao paciente.
     * 
     * @return O diagnóstico dado ao paciente.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Define o diagnóstico dado ao paciente.
     * 
     * @param diagnostico O diagnóstico dado ao paciente.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Retorna o tratamento prescrito ao paciente.
     * 
     * @return O tratamento prescrito ao paciente.
     */
    public String getTratamento() {
        return tratamento;
    }

    /**
     * Define o tratamento prescrito ao paciente.
     * 
     * @param tratamento O tratamento prescrito ao paciente.
     */
    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
}
