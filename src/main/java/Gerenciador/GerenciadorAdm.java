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

/**
 * Gerenciador de operações relacionadas às entidades {@link Secretaria} e {@link Medico}.
 * Fornece métodos para criar, atualizar, remover e listar secretarias e médicos.
 * 
 * <p>Descrição genérica: Gerenciador de uso exclusivo do Administrador para CRUD dos objetos Secretaria e Médico.</p>
 * 
 * @author thiago
 */
public class GerenciadorAdm {

    private EntityManager em;

    /**
     * Construtor da classe {@link GerenciadorAdm}.
     * 
     * @param em O {@link EntityManager} usado para as operações de banco de dados.
     */
    public GerenciadorAdm(EntityManager em) {
        this.em = em;
    }

    /**
     * Cadastra uma nova secretaria no banco de dados.
     * 
     * @param nome Nome da secretaria.
     * @param dataNascimento Data de nascimento da secretaria.
     * @param telefone Telefone da secretaria.
     * @param email Email da secretaria.
     * @param genero Gênero da secretaria.
     * @return Mensagem indicando o resultado da operação.
     */
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

    /**
     * Atualiza as informações de uma secretaria existente.
     * 
     * @param secretaria A secretaria a ser atualizada.
     * @param nome Novo nome da secretaria.
     * @param dataNascimento Nova data de nascimento da secretaria.
     * @param telefone Novo telefone da secretaria.
     * @param email Novo email da secretaria.
     * @param genero Novo gênero da secretaria.
     * @return Mensagem indicando o resultado da operação.
     */
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

    /**
     * Remove uma secretaria existente do banco de dados.
     * 
     * @param secretariaId ID da secretaria a ser removida.
     * @return Mensagem indicando o resultado da operação.
     */
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

    /**
     * Cadastra um novo médico no banco de dados.
     * 
     * @param secretaria Secretaria associada ao médico.
     * @param nome Nome do médico.
     * @param dataNascimento Data de nascimento do médico.
     * @param telefone Telefone do médico.
     * @param email Email do médico.
     * @param especialidade Especialidade do médico.
     * @param crm CRM do médico.
     * @param genero Gênero do médico.
     * @return Mensagem indicando o resultado da operação.
     */
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

    /**
     * Atualiza as informações de um médico existente.
     * 
     * @param medico O médico a ser atualizado.
     * @param secretaria Secretaria associada ao médico.
     * @param nome Novo nome do médico.
     * @param dataNascimento Nova data de nascimento do médico.
     * @param telefone Novo telefone do médico.
     * @param email Novo email do médico.
     * @param especialidade Nova especialidade do médico.
     * @param crm Novo CRM do médico.
     * @param genero Novo gênero do médico.
     * @return Mensagem indicando o resultado da operação.
     */
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

    /**
     * Remove um médico existente do banco de dados.
     * 
     * @param medicoId ID do médico a ser removido.
     * @return Mensagem indicando o resultado da operação.
     */
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

    /**
     * Obtém a lista de todos os médicos cadastrados.
     * 
     * @return Lista de médicos.
     */
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
    
    /**
     * Obtém a lista de todas as secretarias cadastradas.
     * 
     * @return Lista de secretarias.
     */
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
            throw new RuntimeException("Erro ao listar secretarias: " + e.getMessage(), e);
        }
    }
    
   
    public List<Medico> buscarMedicos(String texto) {  
        
        // Executa a consulta e retorna a lista de médicos encontrados
        Query query = this.em.createQuery("SELECT m FROM Medico m WHERE m.nome LIKE :texto OR m.especialidade LIKE :texto", Medico.class);
        query.setParameter("texto", "%"+texto+"%");
        
        return query.getResultList();
    }
    
    public List<Secretaria> buscarSecretarias(String texto) {  
        
        // Executa a consulta e retorna a lista de secretarias encontrados
        Query query = this.em.createQuery("SELECT s FROM Secretaria s WHERE s.nome LIKE :texto", Secretaria.class);
        query.setParameter("texto", "%"+texto+"%");
        
        return query.getResultList();
    }
    
    
    public void cadastroEmMassa(){
        
        this.cadastrarSecretaria("João Paulo", LocalDate.of(1985, 5, 15), "555-1234", "joao.silva@example.com", "Maculino");   

        List<Secretaria> secretaria = this.buscarSecretarias("João Paulo");
        
// Dataset
        // Médicos
        String[] nomes = {"João Silva", "Maria Oliveira", "Carlos Souza", "Ana Santos", "Pedro Lima"};
        String[] generos = {"Masculino", "Feminino","Masculino", "Feminino","Masculino"};
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

        
        
        for(int i = 0; i < nomes.length; i++){
            this.cadastrarMedico(secretaria.get(0), nomes[i], datasNascimento[i], telefones[i], emails[i], especialidades[i], crms[i], generos[i]);
        }
        
    }
    
    
}
