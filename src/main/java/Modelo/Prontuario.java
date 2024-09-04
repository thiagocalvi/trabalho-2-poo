/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



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
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;
    
    @Column(name = "sintoma")
    private String sintomas;
    
    @Column(name = "diagnostico")
    private String diagnostico;
    
    @Column(name = "tratamento")
    private String tratamento;

    public Prontuario(){

    }

    public Prontuario(Paciente paciente, Consulta consulta, String sintomas, String diagnostico, String tratamento) {
        this.consulta = consulta;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.paciente = paciente;
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
    
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
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