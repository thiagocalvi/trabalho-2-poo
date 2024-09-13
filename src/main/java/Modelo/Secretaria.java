/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Representa uma Secretaria, que é uma extensão de {@link Funcionario}.
 * Esta classe é responsável por gerenciar consultas e pacientes, e interage com a base de dados através de um {@link EntityManager}.
 * 
 * @author MatheusConsoni
 */
@Entity
@Table(name = "secretaria")
public class Secretaria extends Funcionario {

    @OneToMany(mappedBy = "secretaria", cascade = CascadeType.ALL)
    private List<Medico> medicos;

    @Transient
    private EntityManager em;

    /**
     * Construtor padrão da classe {@link Secretaria}.
     */
    public Secretaria() {}

    /**
     * Construtor da classe {@link Secretaria} com parâmetros para inicializar os atributos herdados.
     * 
     * @param nome Nome do secretário.
     * @param dataNascimento Data de nascimento do secretário.
     * @param telefone Telefone do secretário.
     * @param email Email do secretário.
     * @param genero Gênero do secretário.
     */
    public Secretaria(String nome, LocalDate dataNascimento, String telefone, String email, String genero) {
        super(nome, dataNascimento, telefone, email, genero);
    }

    /**
     * Define o {@link EntityManager} para a instância da secretaria.
     * 
     * @param em O {@link EntityManager} a ser definido.
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Cadastra uma nova consulta no sistema.
     * 
     * @param paciente O paciente associado à consulta.
     * @param medico O médico associado à consulta.
     * @param dataConsulta A data da consulta.
     * @param horarioConsulta O horário da consulta.
     * @param tipoConsulta O tipo da consulta, que deve ser um valor válido de {@link Consulta.Tipo}.
     * @return Uma mensagem indicando o resultado da operação.
     */
    public String cadastrarConsulta(Paciente paciente, Medico medico, LocalDate dataConsulta, LocalTime horarioConsulta, String tipoConsulta) {
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

    /**
     * Atualiza uma consulta existente, desde que a mesma ainda não tenha sido finalizada.
     * 
     * @param consulta A consulta a ser atualizada.
     * @param paciente O paciente associado à consulta.
     * @param medico O médico associado à consulta.
     * @param dataConsulta A nova data da consulta.
     * @param horarioConsulta O novo horário da consulta.
     * @param tipoConsulta O novo tipo da consulta, que deve ser um valor válido de {@link Consulta.Tipo}.
     * @return Uma mensagem indicando o resultado da operação.
     */
    public String atualizarConsulta(Consulta consulta, Paciente paciente, Medico medico, LocalDate dataConsulta, LocalTime horarioConsulta, String tipoConsulta) {
        if (!consulta.getConsultaFinalizada()) {
            consulta.setPaciente(paciente);
            consulta.setMedico(medico);
            consulta.setData(dataConsulta);
            consulta.setHorario(horarioConsulta);

            try {
                Consulta.Tipo tipo = Consulta.Tipo.valueOf(tipoConsulta.toUpperCase());
                consulta.setTipo(tipo);
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de consulta inválido: " + tipoConsulta);
                return null; // ou lance uma exceção
            }
        }

        this.em.getTransaction().begin();
        this.em.merge(consulta);
        this.em.getTransaction().commit();

        return "Consulta atualizada!";
    }

    /**
     * Remove uma consulta existente do sistema.
     * 
     * @param consultaId O ID da consulta a ser removida.
     * @return Uma mensagem indicando o resultado da operação.
     */
    public String removerConsulta(int consultaId) {
        try {
            this.em.getTransaction().begin();
            Consulta consulta = em.find(Consulta.class, consultaId);
            if (consulta != null) {
                // Setando 'null' para tirar o relaciomento entre as tabelas.
//                consulta.setMedico(null);
//                consulta.setPaciente(null);
//                consulta.getProntuario().setConsulta(null);
//                consulta.getProntuario().setPaciente(null);
                this.em.remove(consulta);
                this.em.getTransaction().commit();
                return "Consulta removida!";
            } else {
                return "Consulta não encontrada";
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().commit();
            
        }
        return "Erro";
    }

    /**
     * Cadastra um novo paciente no sistema.
     * 
     * @param nome Nome do paciente.
     * @param dataNascimento Data de nascimento do paciente.
     * @param telefone Telefone do paciente.
     * @param email Email do paciente.
     * @param endereco Endereço do paciente.
     * @param tipoConvenio Tipo de convênio do paciente, que deve ser um valor válido de {@link Paciente.tipoConvenio}.
     * @param idade Idade do paciente.
     * @param sexo Sexo do paciente.
     * @return Uma mensagem indicando o resultado da operação.
     */
    public String cadastrarPaciente(String nome, LocalDate dataNascimento, String telefone, String email, String endereco, String tipoConvenio, int idade, String sexo) {
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setEndereco(endereco);
        paciente.setIdade(idade);
        paciente.setSexo(sexo);

        try {
            Paciente.tipoConvenio tipo = Paciente.tipoConvenio.valueOf(tipoConvenio.toUpperCase());
            paciente.setTipoConvenio(tipo);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de convênio inválido: " + tipoConvenio);
            return null; // ou lance uma exceção, ou outro tratamento adequado
        }

        this.em.getTransaction().begin();
        this.em.persist(paciente);
        this.em.getTransaction().commit();

        return "Paciente cadastrado!";
    }

    /**
     * Atualiza as informações de um paciente existente.
     * 
     * @param paciente O paciente a ser atualizado.
     * @param nome O novo nome do paciente.
     * @param dataNascimento A nova data de nascimento do paciente.
     * @param telefone O novo telefone do paciente.
     * @param email O novo email do paciente.
     * @param endereco O novo endereço do paciente.
     * @param tipoConvenio O novo tipo de convênio do paciente, que deve ser um valor válido de {@link Paciente.tipoConvenio}.
     * @param idade A nova idade do paciente.
     * @param sexo O novo sexo do paciente.
     * @return Uma mensagem indicando o resultado da operação.
     */
    public String atualizarPaciente(Paciente paciente, String nome, LocalDate dataNascimento, String telefone, String email, String endereco, String tipoConvenio, int idade, String sexo) {
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setEndereco(endereco);
        paciente.setIdade(idade);
        paciente.setSexo(sexo);

        try {
            Paciente.tipoConvenio tipo = Paciente.tipoConvenio.valueOf(tipoConvenio.toUpperCase());
            paciente.setTipoConvenio(tipo);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de convênio inválido: " + tipoConvenio);
            return null; // ou lance uma exceção
        }

        this.em.getTransaction().begin();
        this.em.merge(paciente);
        this.em.getTransaction().commit();

        return "Paciente atualizado!";
    }

    /**
     * Remove um paciente existente do sistema.
     * 
     * @param pacienteId O ID do paciente a ser removido.
     * @return Uma mensagem indicando o resultado da operação.
     */
    public String removerPaciente(int pacienteId) {
        try {
            this.em.getTransaction().begin();

            // Buscar o paciente pelo ID
            Paciente paciente = em.find(Paciente.class, pacienteId);
            if (paciente != null) {

                // Remover consultas relacionadas ao paciente, se necessário
                // Descomente essa parte se não houver CascadeType.REMOVE ou CascadeType.ALL no relacionamento
                // em.createQuery("DELETE FROM Consulta c WHERE c.paciente = :p")
                //   .setParameter("p", paciente)
                //   .executeUpdate();

                // Remover DadosMedicos relacionados ao paciente, se necessário
                if (paciente.getDadosMedicos() != null) {
                    em.remove(paciente.getDadosMedicos());
                }

                // Remover o paciente
                em.remove(paciente);

                // Commit da transação
                this.em.getTransaction().commit();
                return "Paciente removido!";
            } else {
                return "Paciente não encontrado.";
            }
        } catch (Exception e) {
            // Em caso de erro, reverter a transação
            if (this.em.getTransaction().isActive()) {
                this.em.getTransaction().rollback();
            }
            e.printStackTrace();
            return "Erro ao remover o paciente.";
        }
    }

    /**
     * Lista todos os médicos que a secretaria gerencia.
     * 
     * @return Uma lista contendo todos os médicos gerenciados pela secretaria.
     */
    public List<Medico> listarMedicos() {
        try {
            this.em.getTransaction().begin();
            List<Medico> medicos = this.em.createQuery("SELECT m FROM Medico m WHERE m.secretaria = :secretaria", Medico.class)
                                          .setParameter("secretaria", this)
                                          .getResultList();

        
            // Finaliza a transação
            this.em.getTransaction().commit();

            // Retorna a lista de médicos
            return medicos;
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw new RuntimeException("Erro ao listar médicos.", e);
        }
    }

    /**
     * Gera um relatório de consultas agendadas para o dia seguinte.
     * 
     * Este método recupera todas as consultas que estão agendadas para o dia seguinte (em relação ao dia atual) e 
     * que pertencem aos médicos gerenciados pela secretaria. A lista de consultas é obtida usando a consulta JPQL
     * que filtra as consultas com base na data e nos médicos associados.
     * 
     * @return Uma lista de objetos {@link Consulta} representando as consultas agendadas para o dia seguinte. 
     *         Se não houver consultas para o dia seguinte, a lista retornada será vazia.
     * 
     * @throws IllegalStateException Se o {@link EntityManager} não estiver definido.
     * @throws RuntimeException Se ocorrer um erro ao gerar o relatório de consultas.
     */
    public List<Consulta> gerarRelatorioConsultasDiaSeguinte() {
         try {
             // Define a data para o dia seguinte
             LocalDate hoje = LocalDate.now();
             LocalDate diaSeguinte = hoje.plusDays(1);
             
             // Recupera a lista de médicos gerenciados pela secretaria
             List<Medico> medicos = this.listarMedicos();
             
             this.em.getTransaction().begin();

             // Consulta para obter todas as consultas agendadas para o dia seguinte
             List<Consulta> consultas = this.em.createQuery(
                        "SELECT c FROM Consulta c WHERE c.medico IN :medicos AND c.data = :diaSeguinte", Consulta.class)
                        .setParameter("medicos", medicos)
                        .setParameter("diaSeguinte", diaSeguinte)
                        .getResultList();

             this.em.getTransaction().commit();
             
             return consultas;
             
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw new RuntimeException("Erro ao gerar relatório de consultas.", e);
        }
    }

    /**
    * Envia mensagens para os pacientes que têm consulta agendada para o dia seguinte.
    * 
    * Este método utiliza o método {@link #gerarRelatorioConsultasDiaSeguinte()} para obter a lista de consultas
    * agendadas para o dia seguinte. Se houver consultas, uma mensagem é enviada para cada paciente associado. 
    * Caso contrário, uma mensagem informando que não há consultas para o dia seguinte é retornada.
    * 
    * @return Uma mensagem indicando o resultado da operação. Se não houver consultas para o dia seguinte, 
    *         retorna "Sem consultas para o dia seguinte". Caso contrário, retorna uma mensagem indicando o 
    *         número de pacientes para os quais a mensagem foi enviada.
    */
    public String enviarMensagensConsultasDiaSeguinte() {
        List<Consulta> consultas = this.gerarRelatorioConsultasDiaSeguinte();
        
        if(consultas.isEmpty()){
            return "Sem consultas para o dia seguinte";
        }else{
            return "Mensagem enviada para" + consultas.size() + " pacientes";
        }
    }
    
    /**
     * Obtém a lista de todos os pacientes cadastradas.
     * 
     * @return Lista de pacientes.
     */
    public List<Paciente> getAllPacientes(){
        try {
            this.em.getTransaction().begin();
            List<Paciente> pacientes = this.em.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();

        
            // Finaliza a transação
            this.em.getTransaction().commit();

            // Retorna a lista de pacientes
            return pacientes;
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw new RuntimeException("Erro ao listar pacientes.", e);
        }
    }
    
    
    
    public List<Consulta> getAllConsultas(){
        try {
             
            List<Medico> medicos = this.listarMedicos(); // Chame listarMedicos fora da consulta
            if (medicos == null || medicos.isEmpty()) {
                return List.of(); // Retorna uma lista vazia se não houver médicos
            }

            this.em.getTransaction().begin();
            List<Consulta> consultas = this.em.createQuery("SELECT c FROM Consulta c WHERE c.medico IN :medicos", Consulta.class)
                          .setParameter("medicos", medicos)
                          .getResultList();
            
            this.em.getTransaction().commit();
            return consultas;
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw new RuntimeException("Erro ao listar consultas.", e);
        }
    }
    
    
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void cadastrarPacientesEmMassa() {
        String[] nomes = {"João Silva", "Maria Souza", "Carlos Pereira", "Ana Santos", "Paula Lima"};
        LocalDate[] datasNascimento = {
            LocalDate.of(1985, 3, 10), 
            LocalDate.of(1990, 7, 25), 
            LocalDate.of(1978, 2, 18), 
            LocalDate.of(2001, 9, 5), 
            LocalDate.of(1995, 12, 15)
        };
        String[] enderecos = {"Rua A, 123", "Rua B, 456", "Rua C, 789", "Rua D, 321", "Rua E, 654"};
        String[] telefones = {"11987654321", "11987654322", "11987654323", "11987654324", "11987654325"};
        String[] emails = {"joao.silva@example.com", "maria.souza@example.com", "carlos.pereira@example.com", "ana.santos@example.com", "paula.lima@example.com"};
        Paciente.tipoConvenio[] tiposConvenio = {
            Paciente.tipoConvenio.PARTICULAR, 
            Paciente.tipoConvenio.PLANOSAUDE, 
            Paciente.tipoConvenio.PARTICULAR, 
            Paciente.tipoConvenio.PLANOSAUDE, 
            Paciente.tipoConvenio.PARTICULAR
        };
        String[] sexos = {"Masculino", "Feminino", "Masculino", "Feminino", "Feminino"};
        int[] idades = {45,25,56,47,78};
    
        
        for(int x = 0; x < nomes.length; x++){
            this.cadastrarPaciente(nomes[x], datasNascimento[x], telefones[x], emails[x], enderecos[x], tiposConvenio[x].toString(), idades[x], sexos[x]);
        }
    }
}
