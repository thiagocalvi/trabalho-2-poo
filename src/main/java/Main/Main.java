package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Gerenciador.GerenciadorAdm;
import InterfacesGraficas.TelaInicial;

/**
 * Classe principal do sistema que inicializa a aplicação e configura a interface gráfica.
 * 
 * <p>A classe {@code Main} é responsável por criar a instância do {@link EntityManagerFactory} e do {@link EntityManager}, 
 * configurar o {@link GerenciadorAdm} e exibir a tela inicial do sistema. Também adiciona um listener para fechar 
 * os recursos de forma adequada quando a aplicação é encerrada.</p>
 * 
 * @author thiago
 */
public class Main {

    /**
     * Método principal que inicializa a aplicação.
     * 
     * <p>Cria a {@link EntityManagerFactory} e o {@link EntityManager} para interagir com o banco de dados, 
     * cria uma instância de {@link GerenciadorAdm} e configura a interface gráfica principal {@link TelaInicial}.
     * O método também adiciona um hook para garantir o fechamento dos recursos ao encerrar a aplicação.</p>
     * 
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Criar a EntityManagerFactory e o EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("segundo-trabalho-poo");
        EntityManager em = emf.createEntityManager();

        // Criar as instâncias de Secretaria, Medico e GerenciadorAdm
        GerenciadorAdm gerenciadorAdm = new GerenciadorAdm(em);

        // Cria a instância da tela inicial
        TelaInicial telaInicial = new TelaInicial(gerenciadorAdm, em);
        
        // Mostrar a interface gráfica
        telaInicial.setVisible(true);

        // Adicionar um listener para garantir que o EntityManager e EntityManagerFactory sejam fechados ao encerrar a aplicação
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            em.close();
            emf.close();
        }));
    }
}
