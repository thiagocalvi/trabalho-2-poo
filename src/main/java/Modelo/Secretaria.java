/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author MatheusConsoni
 */

@Entity
@Table(name = "secretaria")
public class Secretaria extends Funcionario{

    @OneToMany(mappedBy = "secretaria")
    private List<Medico> medicos;
    
    public Secretaria(String nome, LocalDate dataNascimento, String telefone, String email) {
        super(nome, dataNascimento, telefone, email);
        
    }
    
    //*************************************************************//
    public Consulta cadastrarConsulta(Paciente paciente, Medico medico, LocalDate dataConsulta, LocalTime horarioConsulta, String tipoConsulta){
        //Cadastra uma consulta para os medico que gerencia
        
        Consulta consulta = new Consulta();
        
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setData(dataConsulta);
        consulta.setHorario(horarioConsulta);
        
        try {
            Consulta.Tipo tipo = Consulta.Tipo.valueOf(tipoConsulta.toUpperCase());
            consulta.setTipo(tipo);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de consulta inválido: " + tipoConsulta);
            return null; // ou lance uma exceção, ou outro tratamento adequado
        }
        
        return consulta;
        
    }
    
    public Consulta atualizarConsulta(Consulta consulta, Paciente paciente, Medico medico, LocalDate dataConsulta, LocalTime horarioConsulta, String tipoConsulta){
        //Atualiza uma consulta que ainda não foi finalizada
        if(!consulta.getConsultaFinalizada()){
            consulta.setPaciente(paciente);
            consulta.setMedico(medico);
            consulta.setData(dataConsulta);
            consulta.setHorario(horarioConsulta);

            try {
                Consulta.Tipo tipo = Consulta.Tipo.valueOf(tipoConsulta.toUpperCase());
                consulta.setTipo(tipo);

            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de consulta inválido: " + tipoConsulta);
                return null; // ou lance uma exceção, ou outro tratamento adequado
            }
        }
                    
        return consulta;
    }
    
    public void removerConsulta(){
        //Remove uma consulta
    }
    
    public Paciente cadastrarPaciente(String nome, LocalDate dataNascimento, String telefone, String email, String endereco, String tipoConvenio){
        //Cadastra um paciente
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setEndereco(endereco);
        
        try{
            Paciente.tipoConvenio tipo = Paciente.tipoConvenio.valueOf(tipoConvenio.toUpperCase());
            paciente.setTipoConvenio(tipo);
        }catch (IllegalArgumentException e) {
            System.out.println("Tipo de consulta inválido: " + tipoConvenio);
            return null; // ou lance uma exceção, ou outro tratamento adequado
        }
        
        return paciente;
    }
    
    public Paciente atualizarPaciente(Paciente paciente, String nome, LocalDate dataNascimento, String telefone, String email, String endereco, String tipoConvenio){
        //Atualiza um paciente
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setEndereco(endereco);
        
        try{
            Paciente.tipoConvenio tipo = Paciente.tipoConvenio.valueOf(tipoConvenio.toUpperCase());
            paciente.setTipoConvenio(tipo);
        }catch (IllegalArgumentException e) {
            System.out.println("Tipo de consulta inválido: " + tipoConvenio);
            return null; // ou lance uma exceção, ou outro tratamento adequado
        }
        
        return paciente;
    }
    
    public void removerPaciente(){
        //Remove um paciente
    }
    
    public void listarMedicos(){
        //Lista todos os medicos que a secretaria gerencia
    }
    
    public void gerarRelatorioConsultasDiaSeguinte(){
        //Gera relatorio de consultas para o dia seguinte
    }
    
    public void enviarMensagensConsultasDiaSeguinte(){
        //Envia mensagem para os paciente que tem consulta para o dia seguinte
    }
}