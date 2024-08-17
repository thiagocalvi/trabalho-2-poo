package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        // URL de conexão com o banco de dados Derby
        String url = "jdbc:derby://localhost:1527/segundo-trabalho-poo;create=true";
        // Usuário e senha para o banco de dados
        String user = "adm";
        String password = "admin";
        
        // Testar a conexão
        try {
            // Carregar o driver JDBC do Derby
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            // Estabelecer a conexão
            Connection connection = DriverManager.getConnection(url, user, password);
            
            // Se a conexão for bem-sucedida
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            
            // Fechar a conexão
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do Derby não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Falha ao conectar com o banco de dados.");
            e.printStackTrace();
        }
    }
}
