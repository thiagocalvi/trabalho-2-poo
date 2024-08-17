/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Colecao.ColecaoMedicos;
import Colecao.ColecaoSecretarias;

import Gerenciador.GerenciadorAdm;

import java.util.Scanner;

/**
 *
 * @author geanm
 */
public class MenuAdm {
    
    private ColecaoMedicos colecaoMedicos;
    private ColecaoSecretarias colecaoSecretarias;
    private GerenciadorAdm gerenciadorAdm;
    
    public MenuAdm(ColecaoMedicos colecaoMedicos, ColecaoSecretarias colecaoSecretarias){
        this.colecaoMedicos = colecaoMedicos;
        this.colecaoSecretarias = colecaoSecretarias;
        this.gerenciadorAdm  = new GerenciadorAdm(this.colecaoMedicos, this.colecaoSecretarias); 
    }
    
    static Scanner read = new Scanner(System.in); 
    
    public int chamaMedico() {
                
        System.out.println("USUÁRIO: ADMINISTRADOR");
        System.out.println("");
        System.out.println("+-------+---------------------------+");
        System.out.println("| Opção |           Tipo            |");
        System.out.println("+-------+---------------------------+");
        System.out.println("|   1   |      Cadastrar médico     |");
        System.out.println("|   2   |      Atualizar médico     |");
        System.out.println("|   3   |       Remover médico      |");
        System.out.println("|   4   |      Lista de médicos     |");
        System.out.println("+-------+---------------------------+");
        System.out.println("|   5   | Voltar para menu anterior |");
        System.out.println("|   6   | Voltar para tela inicial  |");
        System.out.println("+-------+---------------------------+");
        System.out.println("");
        System.out.print("Opção: ");
        int option  = read.nextInt();
        
        Main.limpaTela();
        switch (option){
            case 1:
               //Cadastrar médico
                gerenciadorAdm.cadastrarMedico();  
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 2:
                //Atualizar médico
                gerenciadorAdm.atualizarMedico();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 3:
                //Remover médico
                gerenciadorAdm.removerMedico();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 4:
                //Listar médicos
                gerenciadorAdm.listarMedicos();
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
    
    public int chamaSecretaria() {
        
        System.out.println("USUÁRIO: ADMINISTRADOR");
        System.out.println("");
        System.out.println("+-------+---------------------------+");
        System.out.println("| Opção |           Tipo            |");
        System.out.println("+-------+---------------------------+");
        System.out.println("|   1   |    Cadastrar secretária   |");
        System.out.println("|   2   |    Atualizar secretária   |");
        System.out.println("|   3   |     Remover secretária    |");
        System.out.println("|   4   |     Lista de secretária   |");
        System.out.println("+-------+---------------------------+");
        System.out.println("|   5   | Voltar para menu anterior |");
        System.out.println("|   6   | Voltar para tela inicial  |");
        System.out.println("+-------+---------------------------+");
        System.out.println("");
        System.out.print("Escolha a opção: ");
        int option = read.nextInt();
        
        Main.limpaTela();
        switch (option){
            case 1:
                //Cadastrar secretaria
                gerenciadorAdm.cadastrarSecretaria();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 2:
                //Atualizar secretaria
                gerenciadorAdm.atualizarSecretaria();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 3:
                //Remover secretaria
                gerenciadorAdm.removerSecretaria();
                Main.temporizador(3000);
                Main.limpaTela();
                break;
                
            case 4:
                //Listar secretarias
                gerenciadorAdm.listarSecretarias();
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
   
    public int usuarioAdm() {
        
        Main.limpaTela();
        if(colecaoMedicos.size() == 0 && colecaoSecretarias.size() == 0){
            System.out.println("Atenção: Gostaria de inicializar com uma base de dados pré cadastrada? 5 Médicos e 2 Secretarias cadastrados:");
            System.out.print("[1] - Sim \n[2] - Não \nOpção: ");
            
            int op;
            op = read.nextInt();
            
            if(op == 1){
                gerenciadorAdm.cadastroSecretariaInterno();
                gerenciadorAdm.cadastroMedicosInterno();
                System.out.println("5 Médicos e 2 Secretarias cadastrados.");
                Main.temporizador(3000);
                }
            
            else{
                System.out.println("Cadastro manual, cadastre primeiro as secretarias para o correto funcionamento do sistema.");
                Main.temporizador(3000);
                
            }
        }
        
        System.out.println("");
        System.out.println("USUÁRIO: ADMINISTRADOR");
        System.out.println("");
        System.out.println("+-------+-------------------------+");
        System.out.println("| Opção |          Tipo           |");
        System.out.println("+-------+-------------------------+");
        System.out.println("|   1   |         Médicos         |");
        System.out.println("|   2   |       Secretárias       |");
        System.out.println("+-------+-------------------------+");
        System.out.println("|   3   | Volta para tela Inicial |");
        System.out.println("+-------+-------------------------+");
        System.out.println("");
        System.out.println("Qual dos funcionários você irá modificar ? :  ");
        System.out.print("Opção: ");
        int option = read.nextInt();

        Main.limpaTela();
        int option1 = 0;
        switch (option){
            case 1:
                while (option1 != 5 && option1 != 6){
                    option1 = chamaMedico();
                    if (option1 == 6){
                        option = 3;
                    }
                    if (option1 != 4){
                        Main.limpaTela();    
                    }
                }
                break;
            
            case 2:
                while (option1 != 5 && option1 != 6){
                    option1 = chamaSecretaria();
                    if (option1 == 6){
                        option = 3;
                    }
                    if (option1 != 4){
                        Main.limpaTela();    
                    }
                }
                break;
                
            case 3:
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                Main.temporizador(2000);
                break;
        }
        return option; 
    }
}