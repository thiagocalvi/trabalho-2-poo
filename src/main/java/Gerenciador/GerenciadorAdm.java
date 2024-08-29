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
    
    public void setEm(EntityManager em){
        this.em = em;
    }
    
    //Cadastrar secretaria
    public String cadastarSecretaria(String nome, LocalDate dataNascimento, String telefone, String email, String genero){
        Secretaria secretaria = new Secretaria(nome,dataNascimento, telefone, email, genero);
        
        try{
            em.getTransaction().begin();
            em.persist(secretaria);
            em.getTransaction().commit();

        }catch(Exception e){
            return "Erro:" + e;
        }
        
        return "Secretaria cadastrada!";
    }
    
    //Atualizar secretaria
    public String atualizarSecretaria(int secretariaId, String nome, LocalDate dataNascimento, String telefone, String email, String genero){
        try{
            em.getTransaction().begin();
            Secretaria secretaria = em.find(Secretaria.class, secretariaId);
            
            if(secretaria != null){
                secretaria.setNome(nome);
                secretaria.setDataNascimento(dataNascimento);
                secretaria.setTelefone(telefone);
                secretaria.setEmail(email);
                secretaria.setGenero(genero);
            }
            
            em.merge(secretaria);
            em.getTransaction().commit();

        }catch(Exception e){
            return "Erro:" + e;
        }
        
        return "Secetaria atualizada!";
    }
    
    //Remover secretaria
    public String removerSecretaria(int secretariaId){
        try{
            this.em.getTransaction().begin();
            Secretaria secretatia = em.find(Secretaria.class, secretariaId);
            if(secretatia != null){
                em.remove(secretatia);
                em.getTransaction().commit();
                return "Secretatia removida!";
            }else{
                return "Secretatia não encontrada";
            }
        }catch(Exception e){
             return "Erro" + e;
        }
        
    }
        
    
    //Cadastrar médico
    public String cadastarMedico(String nome, LocalDate dataNascimento, String telefone, String email, String especialidade, int crm, String genero){
       Medico medico = new Medico(nome, dataNascimento, telefone, email, especialidade, crm, genero);
       
       try{
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();

        }catch(Exception e){
            return "Erro:" + e;
        }
        
        return "Médico cadastrado!";
    }
    
    //Atualizar médico
    public String atualizarMedico(int medicoId, int secretariaId, String nome, LocalDate dataNascimento, String telefone, String email, String especialidade, int crm, String genero){
        try{
            em.getTransaction().begin();
            Medico medico = em.find(Medico.class, medicoId);
            
            if(medico != null){
                medico.setNome(nome);
                medico.setDataNascimento(dataNascimento);
                medico.setTelefone(telefone);
                medico.setEmail(email);
                medico.setEspecialidade(especialidade);
                medico.setEspecialidade(especialidade);
                medico.setCrm(crm);
                medico.setGenero(genero);
            }
            
            if(secretariaId != 0){
                Secretaria secretaria = em.find(Secretaria.class, secretariaId);
                if(secretaria != null){
                    medico.setSecretaria(secretaria);
                }
            }
            
            em.merge(medico);
            em.getTransaction().commit();

        }catch(Exception e){
            return "Erro:" + e;
        }
        
        return "Médico atualizada!";
    }
    
    //Remover médico
    public String removerMedico(int medicoId){
        try{
            this.em.getTransaction().begin();
            Medico medico = em.find(Medico.class, medicoId);
            if(medico != null){
                em.remove(medico);
                em.getTransaction().commit();
                return "Medico removida!";
            }else{
                return "Meidco não encontrada";
            }
        }catch(Exception e){
             return "Erro" + e;
        }
        
    }
    
    public List<Medico> getAllMedicos(){
        TypedQuery<Medico> query = em.createQuery("SELECT p FROM Medico p", Medico.class);
        
        em.getTransaction().begin();
        
        List<Medico> medicos = query.getResultList();
        
        em.getTransaction().commit();
        
        return medicos;
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
