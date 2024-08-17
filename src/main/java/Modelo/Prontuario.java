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
@Table(name = "prontuario")
public class Prontuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @Column(name = "data_consulta")
    private LocalDate dataConsulta;
    
    @Column(name = "sintoma")
    private String sintomas;
    
    @Column(name = "diagnostico")
    private String diagnostico;
    
    @Column(name = "tratamento")
    private String tratamento;

    public Prontuario(){

    }

    public Prontuario(LocalDate dataConsulta, String sintomas, String diagnostico, String tratamento) {
        this.dataConsulta = dataConsulta;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
    }

    //Gets e Sets
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPacienteId(Paciente paciente){
        this.paciente = paciente;
    }
    
    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
    
}