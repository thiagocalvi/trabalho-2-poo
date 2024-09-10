/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.*;

/**
 * A classe {@code Consulta} representa uma consulta médica. 
 * Ela contém informações sobre a data, horário, tipo 
 * da consulta, bem como as associações com o médico, paciente e prontuário.
 * <p>
 * Esta classe é uma entidade JPA mapeada para a tabela "consulta" no banco de dados.
 * </p>
 * 
 * <p>Essa classe também utiliza uma enum {@link Tipo} para distinguir entre os 
 * diferentes tipos de consulta.</p>
 * 
 * @author thiagocalvi
 */
@Entity
@Table(name = "consulta")
public class Consulta {
    
    /**
     * Enumeração que define os tipos de consulta disponíveis: 
     * {@link Tipo#NORMAL} e {@link Tipo#RETORNO}.
     */
    public enum Tipo {
        NORMAL,  /**< Consulta normal. */
        RETORNO  /**< Consulta de retorno. */
    };
    
    /**
     * Identificador único da consulta.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Data em que a consulta será realizada.
     */
    @Column(name = "data_consulta")
    private LocalDate data;

    /**
     * Horário em que a consulta será realizada.
     */
    @Column(name = "horario_consulta")
    private LocalTime horario;

    /**
     * Tipo de consulta (NORMAL ou RETORNO).
     */
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    /**
     * Médico responsável pela consulta.
     */
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    /**
     * Paciente que será atendido na consulta.
     */
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    /**
     * Prontuário associado à consulta.
     */
    @OneToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;
    
    /**
     * Indica se a consulta foi finalizada.
     */
    @Column(name = "consulta_finalizada")
    private boolean consultaFinalizada = false;
    
    /**
     * Construtor padrão da classe {@code Consulta}.
     */
    public Consulta() {}

    /**
     * Construtor da classe {@code Consulta} que inicializa a data e o horário da consulta.
     * 
     * @param data A data da consulta.
     * @param horario O horário da consulta.
     */
    public Consulta(LocalDate data, LocalTime horario) {
        this.data = data;
        this.horario = horario;
    }
    
    /**
     * Retorna o status da consulta, indicando se ela foi finalizada ou não.
     * 
     * @return {@code true} se a consulta foi finalizada, caso contrário {@code false}.
     */
    public boolean getConsultaFinalizada() {
        return consultaFinalizada;
    }

    /**
     * Define o status da consulta.
     * 
     * @param consultaFinalizada Um valor booleano que indica se a consulta foi finalizada.
     */
    public void setConsultaFinalizada(boolean consultaFinalizada) {
        this.consultaFinalizada = consultaFinalizada;
    }

    /**
     * Retorna o identificador único da consulta.
     * 
     * @return O identificador da consulta.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a data da consulta.
     * 
     * @return A data da consulta.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Define a data da consulta.
     * 
     * @param data A data da consulta.
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Retorna o horário da consulta.
     * 
     * @return O horário da consulta.
     */
    public LocalTime getHorario() {
        return horario;
    }

    /**
     * Define o horário da consulta.
     * 
     * @param horario O horário da consulta.
     */
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    /**
     * Retorna o tipo da consulta (NORMAL ou RETORNO).
     * 
     * @return O tipo da consulta.
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da consulta.
     * 
     * @param tipo O tipo da consulta.
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o médico responsável pela consulta.
     * 
     * @return O médico da consulta.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Define o médico responsável pela consulta.
     * 
     * @param medico O médico da consulta.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Retorna o paciente que será atendido na consulta.
     * 
     * @return O paciente da consulta.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Define o paciente que será atendido na consulta.
     * 
     * @param paciente O paciente da consulta.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Retorna o prontuário associado à consulta.
     * 
     * @return O prontuário da consulta.
     */
    public Prontuario getProntuario() {
        return prontuario;
    }

    /**
     * Define o prontuário associado à consulta.
     * 
     * @param prontuario O prontuário da consulta.
     */
    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}
