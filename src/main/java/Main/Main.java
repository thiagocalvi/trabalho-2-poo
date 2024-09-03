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

/**
 *
 * @author thiago
 */
public class Main {       
    public static void main(String[] args){      
        // Criar a EntityManagerFactory e o EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("segundo-trabalho-poo");
        EntityManager em = emf.createEntityManager();

        // Criar as instâncias de Secretaria, Medico e GerenciadorAdm
        GerenciadorAdm gerenciadorAdm = new GerenciadorAdm(em);

        // Cria a instância da tela inicial
        TelaInicial telaInicial = new TelaInicial(gerenciadorAdm);
        telaInicial.setEm(em);
        
        
        // Mostrar a interface gráfica
        telaInicial.setVisible(true);
        

        // Adicionar um listener para garantir que o EntityManager e EntityManagerFactory sejam fechados ao encerrar a aplicação
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            em.close();
            emf.close();
        }));
    }
}
