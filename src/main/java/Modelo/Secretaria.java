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

    @Transient
    private EntityManager em;
    
    public Secretaria(){}
    
    public Secretaria(String nome, LocalDate dataNascimento, String telefone, String email, String genero) {
        super(nome, dataNascimento, telefone, email, genero);
        
    }
    
    public void setEm(EntityManager em){
        this.em = em;
    }
    
    //*************************************************************//
    //Nas funcções de cadastro e atualizar, as entidades usadas na operação são recebidas como objeto por parametro
    //Seria mais adequado receber somente o id dessas entidades e dentro da função fazer uma busca no banco pelo id e recuperar esses objetos?
    public String cadastrarConsulta(Paciente paciente, Medico medico, LocalDate dataConsulta, LocalTime horarioConsulta, String tipoConsulta){
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
        
        this.em.getTransaction().begin();
        this.em.persist(consulta);
        this.em.getTransaction().commit();
        
        return "Consulta cadastrada!";
        
    }
    
    public String atualizarConsulta(Consulta consulta, Paciente paciente, Medico medico, LocalDate dataConsulta, LocalTime horarioConsulta, String tipoConsulta){
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
        
        this.em.getTransaction().begin();
        this.em.merge(consulta);
        this.em.getTransaction().commit();
                    
        return "Consulta atualizada!";
    }
    
    public String removerConsulta(int consultaId){
        //Remove uma consulta
        try{
            this.em.getTransaction().begin();
            Consulta consulta = em.find(Consulta.class, consultaId);
            if(consulta != null){
                em.remove(consulta);
                return "Consulta removida!";
            }else{
                return "Consulta não encontrada";
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return "Erro";
    }
    
    public String cadastrarPaciente(String nome, LocalDate dataNascimento, String telefone, String email, String endereco, String tipoConvenio, int idade, String sexo){
        //Cadastra um paciente
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setEndereco(endereco);
        paciente.setIdade(idade);
        paciente.setSexo(sexo);
        
        try{
            Paciente.tipoConvenio tipo = Paciente.tipoConvenio.valueOf(tipoConvenio.toUpperCase());
            paciente.setTipoConvenio(tipo);
        }catch (IllegalArgumentException e) {
            System.out.println("Tipo de consulta inválido: " + tipoConvenio);
            return null; // ou lance uma exceção, ou outro tratamento adequado
        }
        
        this.em.getTransaction().begin();
        this.em.persist(paciente);
        this.em.getTransaction().commit();
        
        return "Paciente cadastrado!";
    }
    
    public String atualizarPaciente(Paciente paciente, String nome, LocalDate dataNascimento, String telefone, String email, String endereco, String tipoConvenio, int idade, String sexo){
        //Atualiza um paciente
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setEndereco(endereco);
        paciente.setIdade(idade);
        paciente.setSexo(sexo);
        
        try{
            Paciente.tipoConvenio tipo = Paciente.tipoConvenio.valueOf(tipoConvenio.toUpperCase());
            paciente.setTipoConvenio(tipo);
        }catch (IllegalArgumentException e) {
            System.out.println("Tipo de consulta inválido: " + tipoConvenio);
            return null; // ou lance uma exceção, ou outro tratamento adequado
        }
        
        this.em.getTransaction().begin();
        this.em.merge(paciente);
        this.em.getTransaction().commit();
        
        return "Paciente atualizado!";
    }
    
    public String removerPaciente(int pacienteId){
        //Remove um paciente
        try{
            this.em.getTransaction().begin();
            Paciente paciente = em.find(Paciente.class, pacienteId);
            if(paciente != null){
                em.remove(paciente);
                return "Paciente removida!";
            }else{
                return "Paciente não encontrada";
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return "Erro";
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