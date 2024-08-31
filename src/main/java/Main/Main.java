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
        // Criar todas as instâncias das telas aqui
        TelaInicial telaInicial = new TelaInicial();
        
        
        
        
        MenuPrincipalAdm menuPrincipalAdm = new MenuPrincipalAdm();

        // Criar a EntityManagerFactory e o EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("segundo-trabalho-poo");
        EntityManager em = emf.createEntityManager();

        GerenciadorAdm gerenciadorAdm = new GerenciadorAdm(em);

        // Configurar as telas
        MenuMedicosAdm menuMedicosAdm = new MenuMedicosAdm(gerenciadorAdm);
        MenuSecretariasAdm menuSecretariasAdm = new MenuSecretariasAdm(gerenciadorAdm);

        menuMedicosAdm.setMenuPrincipalAdm(menuPrincipalAdm);
        menuSecretariasAdm.setMenuPrincipalAdm(menuPrincipalAdm);
        menuPrincipalAdm.setMenuMedicosAdm(menuMedicosAdm);
        menuPrincipalAdm.setMenuSecretariasAdm(menuSecretariasAdm);
        
        telaInicial.setMenuPrincipalAdm(menuPrincipalAdm);
        menuPrincipalAdm.setTelaInicial(telaInicial);

        // Mostrar a interface gráfica
        telaInicial.setVisible(true);
        //menuPrincipalAdm.setVisible(false);
        

        // Adicionar um listener para garantir que o EntityManager e EntityManagerFactory sejam fechados ao encerrar a aplicação
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            em.close();
            emf.close();
        }));
    }
}

    /*
    public static void main(String[] args){
        //IDEIA BEM INICIAL E PREMATURA DE COMO FAZER A NAVEGAÇÃO ENTRE AS TELAS
    
        //Criar todas as instancias das telas aqui
       
        MenuSecretariasAdm menuSecretariasAdm = new MenuSecretariasAdm();
        MenuPrincipalAdm menuPrincipalAdm = new MenuPrincipalAdm();
        
        // Criando a EntityManagerFactory e o EntityManager
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("segundo-trabalho-poo");
        EntityManager em = emf.createEntityManager();
        
        GerenciadorAdm gerenciadorAdm = new GerenciadorAdm(em);
        
        //gerenciadorAdm.cadastrarMedico("Dr. João Silva", LocalDate.of(1980, 5, 15), "1234-5678", "joao.silva@example.com", "Cardiologia", 12345, "Masculino");
        //gerenciadorAdm.cadastrarMedico("Dra. Maria Oliveira", LocalDate.of(1975, 11, 20), "2345-6789", "maria.oliveira@example.com", "Neurologia", 23456, "Feminino");
        //gerenciadorAdm.cadastrarMedico("Dr. Pedro Santos", LocalDate.of(1988, 2, 10), "3456-7890", "pedro.santos@example.com", "Pediatria", 34567, "Masculino");




//Sets das telas
        MenuMedicosAdm menuMedicosAdm = new MenuMedicosAdm(gerenciadorAdm);
        //menuMedicosAdm.setGerenciadorAdm(gerenciadorAdm);
        menuMedicosAdm.setMenuPrincipalAdm(menuPrincipalAdm);
        menuSecretariasAdm.setMenuPrincipalAdm(menuPrincipalAdm);
        menuPrincipalAdm.setMenuMedicosAdm(menuMedicosAdm);
        menuPrincipalAdm.setMenuSecretariasAdm(menuSecretariasAdm);
        
               
        
        
        
        
        //gerenciadorAdm.cadastarSecretaria("Maria Aparecida", LocalDate.of(1990, 5, 15), "123123", "maAp@gmail.com", "Feminino");
        
        //gerenciadorAdm.removerSecretaria(2);
        
        //secretaria.cadastrarPaciente("Teste01", LocalDate.of(1990, 5, 15), "12322222", "teste@@", "fdsfdsf", "PARTICULAR", 20, "Maculino");
        
        menuPrincipalAdm.setVisible(true);
        
        em.close();
        emf.close();
        
        
        
       
        
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
 
    }
}
    
    */