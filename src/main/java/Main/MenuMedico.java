/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Colecao.ColecaoConsultas;
import Colecao.ColecaoPacientes;
import Colecao.ColecaoProntuarios;
import Colecao.ColecaoMedicos;
import Colecao.ColecaoDadosMedicos;

//import Modelo.Paciente;

import Gerenciador.GerenciadorMedicos;
import Modelo.Medico;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author jeanm
 */

public class MenuMedico { 
    
    private ColecaoMedicos colecaoMedicos;
    private GerenciadorMedicos gerenciadorMedicos;
    
    public MenuMedico(ColecaoConsultas colecaoConsultas, ColecaoPacientes colecaoPacientes, ColecaoProntuarios colecaoProntuarios, ColecaoMedicos colecaoMedicos, ColecaoDadosMedicos colecaoDadosMedicos){
        this.colecaoMedicos = colecaoMedicos;
        this.gerenciadorMedicos = new GerenciadorMedicos(colecaoConsultas, colecaoPacientes, colecaoProntuarios, colecaoDadosMedicos);
        
    }
    
    static Scanner read = new Scanner(System.in);
    
    public int menuDadosAdicionais() {
        System.out.println("");
        System.out.println("USUÁRIO: MÉDICO");
        System.out.println("Doutor(a): " + gerenciadorMedicos.getMedico().getNome());
        System.out.println("");
        System.out.println("+-------------------------------------+");
        System.out.println("|           DADOS ADICIONAIS          |");
        System.out.println("+-------+-----------------------------+");
        System.out.println("| Opção |            Tipo             |");
        System.out.println("+-------+-----------------------------+");
        System.out.println("|   1   |          Cadastrar          |");
        System.out.println("|   2   |          Atualizar          |");
        System.out.println("|   3   |           Remover           |");
        System.out.println("|   4   |           Listar            |");
        System.out.println("+-------+-----------------------------+");        
        System.out.println("|   5   | Voltar para a tela anterior |");
        System.out.println("+-------+-----------------------------+");        
        System.out.println("");
        System.out.println("Opção: ");
        int option = Integer.parseInt(read.next());
        
        Main.limpaTela();
        switch (option){
            case 1:
                // Implementar o cadastro dos dados adicionais
                gerenciadorMedicos.cadastrarDados();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 2:
                // Implementar o atualizar
                gerenciadorMedicos.atualizarDados();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 3:
                // Implementar o remover
                gerenciadorMedicos.removerDados();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 4:
                gerenciadorMedicos.listarDados();
                Main.temporizador(3000);
                
            case 5:
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                break;
        }
        return option;
    }
    
    
    public int menuProntuario() {
        System.out.println("");
        System.out.println("USUÁRIO: MÉDICO");
        System.out.println("Doutor(a): " + gerenciadorMedicos.getMedico().getNome());
        System.out.println("");       
        System.out.println("+-------------------------------------+");
        System.out.println("|              PRONTUÁRIO             |");
        System.out.println("+-------+-----------------------------+");
        System.out.println("| Opção |            Tipo             |");
        System.out.println("+-------+-----------------------------+");
        System.out.println("|   1   |          Cadastrar          |");
        System.out.println("|   2   |          Atualizar          |");
        System.out.println("|   3   |           Remover           |");
        System.out.println("|   4   |           Listar            |");
        System.out.println("+-------+-----------------------------+");        
        System.out.println("|   5   | Voltar para a tela anterior |");
        System.out.println("+-------+-----------------------------+");
        System.out.println("");
        System.out.println("Opção: ");
        int option = read.nextInt();
        
        Main.limpaTela();
        switch (option){
            case 1:
                // Implementar o cadastro
                gerenciadorMedicos.cadastrarProntuario();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 2:
                // Implementar o atualizar
                gerenciadorMedicos.atualizarProntuario();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 3:
               // Implementar o remover
               gerenciadorMedicos.removerProntuario();
               Main.temporizador(3000);
               Main.limpaTela();
               break;

            case 4:
                gerenciadorMedicos.listarProntuarios();
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
    
    public int menuLaudos() {
        
        System.out.println("");
        System.out.println("USUÁRIO: MÉDICO");
        System.out.println("Doutor(a): " + gerenciadorMedicos.getMedico().getNome());
        System.out.println("");
        System.out.println("========== LAUDOS MÉDICOS =========");
        System.out.println("");
        System.out.println("[1] - RECEITA MÉDICA ");
        System.out.println("[2] - ATESTADO MÉDICO ");
        System.out.println("[3] - DECLARAÇÃO DE ACOMPANHAMENTO ");
        System.out.println("");
        System.out.println("===================================");
        System.out.print("Escolha uma das opções (0 para sair): ");
        int option = read.nextInt();
        
        switch (option){
            case 1:
                // Gera uma receita médica
                gerenciadorMedicos.receitaMedica();
                Main.temporizador(4000);
                break;
                
            case 2:
                // Gera um atestado médico
                gerenciadorMedicos.atestadoMedico();
                Main.temporizador(4000);
                break;
                
            case 3:
                // Gera uma declaração de acompanhamento
                gerenciadorMedicos.declaracaoAcompanhamento();
                Main.temporizador(4000);
                break;
                
            case 0:
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                break;            
        }        
        return option;
    } 
    
    
    
    
    public int menuConsulta() {
        System.out.println("");
        System.out.println("USUÁRIO: MÉDICO");
        System.out.println("Doutor(a): " + gerenciadorMedicos.getMedico().getNome());
        System.out.println("");
        System.out.println("+------------------------------+");
        System.out.println("|            Consulta          |");
        System.out.println("+-------+----------------------+");
        System.out.println("| Opção |        Tipo          |");
        System.out.println("+-------+----------------------+");
        System.out.println("|   1   |   Dados adicionais   |");
        System.out.println("|   2   |      Prontuário      |");
        System.out.println("|   3   |    Laudos médicos    |");
        System.out.println("+-------+----------------------+");        
        System.out.println("|   4   |  Finalizar consulta  |");
        System.out.println("+-------+----------------------+");        
        System.out.println("");
        System.out.print("Opção: ");
        int option = read.nextInt();
        System.out.println("");

        if (option >= 1 && option <= 3){
            Main.limpaTela();
        }

        int option1 = -1;
        switch (option){
            case 1:
                while (option1 != 5){
                    option1 = menuDadosAdicionais();
                    Main.limpaTela();
                }
                break;
                
            case 2:
                while (option1 != 5){
                    option1 = menuProntuario();
                    Main.limpaTela();
                }
                break;
                
            case 3:
                // Implementar os gerenciadores de relatórios.
                while (option1 != 0){
                    option1 = menuLaudos();
                    Main.limpaTela();
                }
                break;
                
            case 4:
                System.out.println("Você realmente deseja 'FINALIZAR' a consulta?");
                System.out.println("[1] - Para sim \n[2] - Para não");
                int option2 = Integer.parseInt(read.next());
                
                if (option2 == 2){
                    System.out.println("CONSULTA NÃO FINALIZADA!");
                    option = 0;
                } else if (option2 == 1){
                    gerenciadorMedicos.resetConsultaAtual();
                    System.out.println("CONSULTA FINALIZADA!");
                }
                Main.temporizador(3000);
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                break;
        }
 
        return option;      
    }
    
    
    public int chamaConsultaMarcada() {
        
        System.out.println("");
        System.out.println("USUÁRIO: MÉDICO");
        System.out.println("Doutor(a): " + gerenciadorMedicos.getMedico().getNome());
        System.out.println("");
        System.out.println("+=====================================+");        
        System.out.println("Consultas do dia: ");
        System.out.println("");
        
        gerenciadorMedicos.setConsultasDoDia();
        
        if(gerenciadorMedicos.getConsultasDoDia().isEmpty()){
            System.out.println("Nenhuma consulta marcada para hoje");
            Main.temporizador(3000);
            return 2;
        }
        // Lista as consultas do dia referente ao login do médico
        gerenciadorMedicos.listaConsultasDoDia();
        
        System.out.println("+=====================================+");
        System.out.println("");
        System.out.println("Iniciar a próxima consulta ?"); 
        System.out.println("[1] - Para sim \n[2] - Para não");
        int option = read.nextInt();
        
        Main.limpaTela();
        
        int option1 = 0;
        switch (option){
            case 1:
                gerenciadorMedicos.setConsultaAtual();
                while (option1 != 4){
                    option1 = menuConsulta();
                    Main.limpaTela();
            }     
            case 2:
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
        System.out.println("USUÁRIO: MÉDICO");
        System.out.println("Doutor(a): " + gerenciadorMedicos.getMedico().getNome());
        System.out.println("");
        System.out.println("+-------+-----------------------------+");
        System.out.println("| Opção |            Tipo             |");
        System.out.println("+-------+-----------------------------+");
        System.out.println("|   1   |     Consultas marcadas      |");
        System.out.println("|   2   |  Relatório mensal/clientes  |");
        System.out.println("+-------+-----------------------------+");
        System.out.println("|   3   |        Sair da conta        |");
        System.out.println("+-------+-----------------------------+");
        System.out.println("");
        System.out.print("Opção: ");
        int option = read.nextInt();
        
        Main.limpaTela();
        int option1 = 0;
        switch (option){
            case 1:
                while (option1 != 2){
                    option1 = chamaConsultaMarcada();
                    Main.limpaTela();
                }
                break;
             
            case 2:
                // Gera os relatórios dos clientes atendidos no mês
                gerenciadorMedicos.relatorioMensal();
                Main.temporizador(3000);
                break;
                
            case 3:
                // Reseta a coleçãoDoDia quando o médico sai da conta 
                gerenciadorMedicos.resetConsultasDoDia();
                break;
                     
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                break;  
        }        
        return option;
    }
    
    
    public int usuarioMedico() {
        
        // Listar todos os médicos
        ArrayList<Medico> allMedicos = colecaoMedicos.getMedicos();
        
        Main.limpaTela();
        System.out.println("");
        System.out.println("+-----------------------------------------+");
        for(Medico medico : allMedicos){
            System.out.printf("| Identificador: %-25s \n", medico.getId());
            System.out.printf("| Nome: %-25s \n", medico.getNome());
            System.out.printf("| Especialidade: %-15s \n", medico.getEspecialidade());
            System.out.printf("| CRM: %-24d \n", medico.getCrm());
            System.out.println("+-----------------------------------------+");
        }

        System.out.println("\n \n");
        System.out.println("USUÁRIO: MÉDICO");
        System.out.println("");
        System.out.print("LOGIN DO MÉDICO (IDENTIFICADOR) ou (0 para sair):");
        int id = Integer.parseInt(read.next());
        System.out.println("");
        
        if(id == 0){
            return 2;
        }

        Medico medico = colecaoMedicos.getMedicoById(id);
        
        System.out.println("+---------------------------------------+");
        System.out.printf("| Nome: %-25s \n", medico.getNome());
        System.out.printf("| CRM: %-24d \n", medico.getCrm());
        System.out.println("+---------------------------------------+");
        System.out.println("[1] - Para entrar na conta \n[2] - Para voltar na tela inicial");
        System.out.println("+---------------------------------------+");  
        System.out.println("");
        System.out.print("Opção: ");
        int option = Integer.parseInt(read.next());
                
        Main.limpaTela();
        int option1 = 0;
        switch (option){
            case 1:
                gerenciadorMedicos.setMedico(medico);
                
                while (option1 != 3){
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