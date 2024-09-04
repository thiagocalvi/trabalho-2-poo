/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

/**
 *
 * @author MatheusConsoni
 */

@Entity
@Table(name = "consulta")
public class Consulta {
    public enum Tipo{
        NORMAL,
        RETORNO
    };
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_consulta")
    private LocalDate data;

    @Column(name = "horario_consulta")
    private LocalTime horario;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;
    
    @Column(name = "consulta_finalizada")
    private boolean consultaFinalizada = false;
    
    
    public Consulta(){}
    
    //Construtor
    public Consulta(LocalDate data, LocalTime horario) {
        this.data = data;
        this.horario = horario;
    }
    
    //Gets e Sets
    public boolean getConsultaFinalizada() {
        return consultaFinalizada;
    }

    public void setConsultaFinalizada(boolean consultaFinalizada) {
        this.consultaFinalizada = consultaFinalizada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }   
}