/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Gerenciador.GerenciadorSecretarias;

import Colecao.ColecaoConsultas;
import Colecao.ColecaoMedicos;
import Colecao.ColecaoPacientes;
import Colecao.ColecaoSecretarias;

import Modelo.Secretaria;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author jeanm
 */
public class MenuSecretaria {
    
    private ColecaoPacientes colecaoPacientes;
    private ColecaoSecretarias colecaoSecretarias;
    private GerenciadorSecretarias gerenciadorSecretarias;
    
    public MenuSecretaria(ColecaoMedicos colecaoMedicos, ColecaoPacientes colecaoPacientes, ColecaoConsultas colecaoConsultas, ColecaoSecretarias colecaoSecretarias){
        this.colecaoPacientes = colecaoPacientes;
        this.colecaoSecretarias = colecaoSecretarias; 
        this.gerenciadorSecretarias = new GerenciadorSecretarias(colecaoConsultas, colecaoMedicos, colecaoPacientes);
    }

    Scanner read = new Scanner(System.in);
    
    public int chamaConsulta() {
        System.out.println("");
        System.out.println("USUÁRIO: SECRETÁRIA");
        System.out.println("Secretária: " + gerenciadorSecretarias.getSecretaria().getNome());
        System.out.println("");
        System.out.println("+-------+---------------------------------------------+");
        System.out.println("| Opção |                  Tipo                       |");
        System.out.println("+-------+---------------------------------------------+");
        System.out.println("|   1   |              Marcar consulta                |");
        System.out.println("|   2   |             Atualizar consulta              |");
        System.out.println("|   3   |              Remover consulta               |");
        System.out.println("|   4   |             Lista de consultas              |");        
        System.out.println("|   5   | Gerar relatório de consulta do dia seguinte |");
        System.out.println("+-------+---------------------------------------------+");
        System.out.println("|   6   |         Voltar para menu anterior           |");
        System.out.println("|   7   |          Voltar para tela inicial           |");
        System.out.println("+-------+---------------------------------------------+");
        System.out.println("");
        System.out.print("Escolha a opção: ");
        int option = read.nextInt();
        
        Main.limpaTela();
        switch (option){
            case 1:
                // Cadastrar consulta
                gerenciadorSecretarias.cadastrarConsulta();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 2:
                // Atualizar consulta
                gerenciadorSecretarias.atualizarConsulta();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 3:
                // Remover Consulta
                gerenciadorSecretarias.removerConsulta(); 
                Main.temporizador(3000);
                Main.limpaTela();                
                break;
                
            case 4:
                // Lista de consultas
                gerenciadorSecretarias.listarConsultas();
                Main.temporizador(4000);
                break;
                
            case 5:
                // Gera Relatorios do dia seguintes
                gerenciadorSecretarias.gerarRelatorioConsultasDiaSeguinte();
                Main.temporizador(4000);
                break;
                
            case 6:
                break;
                
            case 7:
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                
                break;   
        }
        return option;    
    }
    
    
    public int chamaPaciente() {
        System.out.println("");
        System.out.println("USUÁRIO: SECRETÁRIA");
        System.out.println("Secretária: " + gerenciadorSecretarias.getSecretaria().getNome());
        System.out.println("");
        System.out.println("+-------+-------------------------------+");
        System.out.println("| Opção |             Tipo              |");
        System.out.println("+-------+-------------------------------+");
        System.out.println("|   1   |       Cadastrar paciente      |");
        System.out.println("|   2   |       Atualizar paciente      |");
        System.out.println("|   3   |        Remover paciente       |");
        System.out.println("|   4   |       Lista de pacientes      |");
        System.out.println("+-------+-------------------------------+");
        System.out.println("|   5   |  Voltar para menu anterior    |");
        System.out.println("|   6   |   Voltar para tela inicial    |");
        System.out.println("+-------+-------------------------------+");
        System.out.println("");
        System.out.print("Escolha a opção: ");
        int option = read.nextInt();
        
        Main.limpaTela();
        switch (option){
            case 1:
                // Cadastrar paciente
                gerenciadorSecretarias.cadastrarPaciente();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 2:
                // Atualizar paciente
                gerenciadorSecretarias.atualizarPaciente();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 3:
                // Remover paciente
                gerenciadorSecretarias.removerPaciente();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 4:
                // Listar paciente
                gerenciadorSecretarias.listarPacientes();
                Main.temporizador(4000);
                break;
             
            case 5:
                break;
                
            case 6:
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                break;   
        }
        return option;    
        
    }
    
    public int menuInicial() {
        System.out.println("");
        System.out.println("USUÁRIO: SECRETÁRIA");
        System.out.println("Secretária: " + gerenciadorSecretarias.getSecretaria().getNome());
        System.out.println("");
        System.out.println("+-------+---------------------------+");
        System.out.println("| Opção |           Tipo            |");
        System.out.println("+-------+---------------------------+");
        System.out.println("|   1   |         Consultas         |");
        System.out.println("|   2   |         Pacientes         |");
        System.out.println("|   3   |      Lista de médicos     |");
        System.out.println("|   4   |      Enviar mensagens     |");
        System.out.println("+-------+---------------------------+");
        System.out.println("|   5   |       Sair da conta       |");
        System.out.println("+-------+---------------------------+");
        System.out.println("");
        System.out.print("Escolha a opção: ");
        int option = read.nextInt();
        
        Main.limpaTela();
        int option1 = 0;
        switch (option){
            case 1:
                // Menu Consulta
                while (option1 != 6 && option1 != 7){
                    option1 = chamaConsulta();
                    if (option1 == 6){
                        option = 3;
                    }
                    Main.limpaTela();
                }
                break;
            
            case 2:
                // Menu Paciente
                while (option1 != 5 && option1 != 6){
                    option1 = chamaPaciente();
                    if (option1 == 6){
                        option = 3;
                    }    
                    Main.limpaTela();
                }
                break;
       
            case 3:
                // Exibir todos os médicos que estão na lista
                gerenciadorSecretarias.listarMedicos();
                Main.temporizador(4000);
                break;
                    
            case 4: 
                // Envia as mensagens para os clientes avisando sobre a consulta do dia seguinte
                gerenciadorSecretarias.enviarMensagensConsultasDiaSeguinte();
                Main.temporizador(3000);
                break;
                        
            case 5:
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                break;
                
        }
        return option;
    }
    
    
      
    public int usuarioSecretaria() {
        
        //Listar todas as secretarias
        ArrayList<Secretaria> allSecretarias = colecaoSecretarias.getSecretarias();
        
        Main.limpaTela();
        System.out.println("USUÁRIO: SECRETÁRIA");
        System.out.println("");
        System.out.println("+----------------------------------------+");
        for(Secretaria secretaria : allSecretarias){
            System.out.printf("| Identificador: %-25s \n", secretaria.getId());
            System.out.printf("| Nome: %-25s \n", secretaria.getNome());
            System.out.println("+----------------------------------------+");
        } 
        
        System.out.println("");
        System.out.print("LOGIN DA SECRETARIA (IDENTIFICADOR) ou (0 para sair):");
        int id = read.nextInt();
        System.out.println("");
        
        if(id == 0){
            return 2;
        }
        
        Secretaria secretaria = colecaoSecretarias.getSecretariaById(id);
        
        System.out.println("-----------------------------------------");
        System.out.printf("| Nome: %-25s \n", secretaria.getNome());
        System.out.println("-----------------------------------------");
        System.out.println("[1] - Para entrar na conta \n[2] - Para voltar na tela inicial");
        System.out.println("-----------------------------------------");  
        System.out.println("");
        System.out.print("Opção: ");
        int option = read.nextInt();
        read.nextLine();  
        
        Main.limpaTela();   
        int option1 = 0;
        switch (option){
            case 1:
                gerenciadorSecretarias.setSecretaria(secretaria);
                
                if(colecaoPacientes.size() == 0){ //Verificar se a colecao de consultas está vazia
                    int op;
                    System.out.println("Um pré cadastro de 20 pacientes está disponivel, gostaria de utilizalo?");
                    System.out.print("[1] - Sim\n[2] - Não\nOpção: ");
                    op = read.nextInt();
                    if(op == 1){
                        gerenciadorSecretarias.cadastroPacientesInterno();
                        System.out.println("20 Pacientes cadastrados!");
                        
                        //Start - A partir daqui não estara na versão final
                        
                        //Pedir se quer cadastrar 20 consultas
                        System.out.println("Um pré cadastro de 20 consultas para os medicos de Id's 1 e 2 está disponivel, gostaria de utilizalo?");
                        System.out.print("[1] - Sim\n[2] - Não\nOpção: ");
                        op = read.nextInt();
                        
                        if(op == 1){
                            //Codificar esse metodo no gerenciador secretaria
                            gerenciadorSecretarias.cadastroConsultasInterno();
                        }
                        //End - Até aqui não estara na versão final
                    }
                }
                
                while (option1 != 5){
                    option1 = menuInicial();
                    Main.limpaTela();
                }
                break;
            
            case 2:
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                break;
            
        }
        return option; 
    } 
}
