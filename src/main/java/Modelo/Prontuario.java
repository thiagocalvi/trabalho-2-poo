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
public class Prontuario {
    //Atributos
    private int id; // gerar id
    private int pacienteId;
    private LocalDate dataConsulta;
    private String sintomas;
    private String diagnostico;
    private String tratamento;
    
    //Construtor

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

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Paciente paciente){
        this.pacienteId = paciente.getId();
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