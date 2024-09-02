/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Gerenciador;

import javax.persistence.*;

import Modelo.Medico;
import Modelo.Secretaria;

import java.util.List;


import java.time.LocalDate;

 
 // @author thiago
 

// Gerenciador de uso exclusivo do Administrador
// CRUD dos objetos Secretaria e Médico

public class GerenciadorAdm {
    
    private EntityManager em;
    
    
    public GerenciadorAdm(EntityManager em){
        this.em = em;
    }
    
     public String cadastrarSecretaria(String nome, LocalDate dataNascimento, String telefone, String email, String genero) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Secretaria secretaria = new Secretaria(nome, dataNascimento, telefone, email, genero);
            em.persist(secretaria);
            transaction.commit();
            return "Secretaria cadastrada!";
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }

    public String atualizarSecretaria(Secretaria secretaria, String nome, LocalDate dataNascimento, String telefone, String email, String genero) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if (secretaria != null) {
                secretaria.setNome(nome);
                secretaria.setDataNascimento(dataNascimento);
                secretaria.setTelefone(telefone);
                secretaria.setEmail(email);
                secretaria.setGenero(genero);
                em.merge(secretaria);
                transaction.commit();
                return "Secretaria atualizada!";
            } else {
                transaction.commit();
                return "Secretaria não encontrada";
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }

    public String removerSecretaria(int secretariaId) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Secretaria secretaria = em.find(Secretaria.class, secretariaId);
            if (secretaria != null) {
                em.remove(secretaria);
                transaction.commit();
                return "Secretaria removida!";
            } else {
                transaction.commit();
                return "Secretaria não encontrada";
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }

    public String cadastrarMedico(Secretaria secretaria, String nome, LocalDate dataNascimento, String telefone, String email, String especialidade, int crm, String genero) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Medico medico = new Medico(secretaria, nome, dataNascimento, telefone, email, especialidade, crm, genero);
            em.persist(medico);
            transaction.commit();
            return "Médico cadastrado!";
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }

    public String atualizarMedico(Medico medico, Secretaria secretaria, String nome, LocalDate dataNascimento, String telefone, String email, String especialidade, int crm, String genero) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if(medico != null) {
                medico.setNome(nome);
                medico.setDataNascimento(dataNascimento);
                medico.setTelefone(telefone);
                medico.setEmail(email);
                medico.setEspecialidade(especialidade);
                medico.setCrm(crm);
                medico.setGenero(genero);
                medico.setSecretaria(secretaria);
                
                em.merge(medico);
                transaction.commit();
                return "Médico atualizado!";
            } else {
                transaction.commit();
                return "Médico não encontrado";
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }

    public String removerMedico(int medicoId) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Medico medico = em.find(Medico.class, medicoId);
            if (medico != null) {
                em.remove(medico);
                transaction.commit();
                return "Médico removido!";
            } else {
                transaction.commit();
                return "Médico não encontrado";
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro: " + e.getMessage();
        }
    }

    public List<Medico> getAllMedicos() {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Medico> query = em.createQuery("SELECT m FROM Medico m", Medico.class);
            List<Medico> medicos = query.getResultList();
            transaction.commit();
            return medicos;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao listar médicos: " + e.getMessage(), e);
        }
    }
    
    public List<Secretaria> getAllSecretarias() {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Secretaria> query = em.createQuery("SELECT m FROM Secretaria m", Secretaria.class);
            List<Secretaria> secretarias = query.getResultList();
            transaction.commit();
            return secretarias;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao listar médicos: " + e.getMessage(), e);
        }
    }
    
    
    public List<Medico> buscarMedicos(String texto) {
        // Prepara o texto para a busca, adicionando '%' para correspondência parcial
        String searchText = "%" + texto + "%";
        
        // Cria a consulta HQL com correspondência parcial
        String hql = "SELECT m FROM Medico m WHERE m.nome LIKE :texto OR m.crm LIKE :texto OR m.especialidade LIKE :texto";
        TypedQuery<Medico> query = em.createQuery(hql, Medico.class);
        query.setParameter("texto", searchText);
        
        // Executa a consulta e retorna a lista de médicos encontrados
        return query.getResultList();
    }
    
    
    
    //Dataset
    //Médicos
    String[] nomes = {"João Silva", "Maria Oliveira", "Carlos Souza", "Ana Santos", "Pedro Lima"};
        String[] especialidades = {"Cardiologia", "Dermatologia", "Neurologia", "Pediatria", "Ortopedia"};
        String[] telefones = {"(11) 91234-5678", "(21) 98765-4321", "(31) 99876-5432", "(41) 91234-5678", "(51) 98765-4321"};
        String[] emails = {"joao.silva@exemplo.com", "maria.oliveira@exemplo.com", "carlos.souza@exemplo.com", "ana.santos@exemplo.com", "pedro.lima@exemplo.com"};
        int[] crms = {123456, 234567, 345678, 456789, 567890};
        LocalDate[] datasNascimento = {
                LocalDate.of(1980, 1, 1),
                LocalDate.of(1975, 5, 20),
                LocalDate.of(1990, 8, 15),
                LocalDate.of(1985, 3, 10),
                LocalDate.of(1995, 12, 25)};
    
    //Secretaria
    String[] nomes2 = {"João Silva", "Maria Oliveira"};
    LocalDate[] datasNascimento2 = {LocalDate.of(1985, 5, 15), LocalDate.of(1990, 8, 20)};
    String[] telefones2 = {"555-1234", "555-5678"};
    String[] emails2 = {"joao.silva@example.com", "maria.oliveira@example.com"};
}
