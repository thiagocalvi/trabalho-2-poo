/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
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
    public void cadastrarConsulta(){
        //Cadastra uma consulta para os medico que gerencia
    }
    
    public void atualizarConsulta(){
        //Atualiza uma consulta que ainda não foi finalizada
    }
    
    public void removerConsulta(){
        //Remove uma consulta
    }
    
    public void cadastrarPaciente(){
        //Cadastra um paciente
    }
    
    public void atualizarPaciente(){
        //Atualiza um paciente
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