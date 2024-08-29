/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
    
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Gerenciador.GerenciadorAdm;

import InterfacesGraficas.*;

import java.util.List;
import Modelo.*;
import java.time.LocalDate;

/**
 *
 * @author thiago
 */
public class Main {    
    public static void main(String[] args){
        
        GerenciadorAdm gerenciadorAdm = new GerenciadorAdm();
        
        //IDEIA BEM INICIAL E PREMATURA DE COMO FAZER A NAVEGAÇÃO ENTRE AS TELAS
    
        //Criar todas as instancias das telas aqui
        MenuMedicosAdm menuMedicosAdm = new MenuMedicosAdm();
        MenuSecretariasAdm menuSecretariasAdm = new MenuSecretariasAdm();
        MenuPrincipalAdm menuPrincipalAdm = new MenuPrincipalAdm();
        
        // Criando a EntityManagerFactory e o EntityManager
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("segundo-trabalho-poo");
        EntityManager em = emf.createEntityManager();
        
        
        //Sets das telas
        menuMedicosAdm.setMenuPrincipalAdm(menuPrincipalAdm);
        menuSecretariasAdm.setMenuPrincipalAdm(menuPrincipalAdm);
        menuPrincipalAdm.setMenuMedicosAdm(menuMedicosAdm);
        menuPrincipalAdm.setMenuSecretariasAdm(menuSecretariasAdm);
        
        gerenciadorAdm.setEm(em);
        
        menuMedicosAdm.setGerenciadorAdm(gerenciadorAdm);
        
        
        
        //gerenciadorAdm.cadastarSecretaria("Maria Aparecida", LocalDate.of(1990, 5, 15), "123123", "maAp@gmail.com", "Feminino");
        
        gerenciadorAdm.removerSecretaria(2);
        
        //secretaria.cadastrarPaciente("Teste01", LocalDate.of(1990, 5, 15), "12322222", "teste@@", "fdsfdsf", "PARTICULAR", 20, "Maculino");
        
        menuPrincipalAdm.setVisible(true);
        
        em.close();
        emf.close();
        
        
        
        /*
        
        try {
            // Iniciando uma transação
            em.getTransaction().begin();

            Paciente novoPaciente = new Paciente();
            novoPaciente.setNome("João da Silva");
            novoPaciente.setDataNascimento(LocalDate.of(1990, 5, 15));
            
            em.persist(novoPaciente);
            
            em.getTransaction().commit();

            System.out.println("Paciente adicionado com sucesso!");
            

            // Criando a consulta
            String jpql = "SELECT p FROM Paciente p";
            List<Paciente> pacientes = em.createQuery(jpql, Paciente.class).getResultList();
            
            System.out.println("TESTE");
            
            // Processando os resultados
            for (Paciente paciente : pacientes) {
                System.out.println(paciente.getNome());
            }

            // Commit da transação (se necessário)
            em.getTransaction().commit();
        } catch (Exception e) {
            // Rollback em caso de erro
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Fechando o EntityManager
            em.close();
            emf.close();
        }
    
    */
    }
}
 