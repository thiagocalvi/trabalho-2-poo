/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Colecao.*;
import java.util.Scanner;




/**
 *
 * @author thiago
 */
public class Main {
    public static void temporizador(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public static void limpaTela() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
        
    public static void main(String[] args){
        // Inicializa a conexão com o banco de dados
        
        
        
        
        
//**************************************************************************************************//
        
        
        
        
        //Inicializando as coleções
        ColecaoConsultas colecaoConsultas = new ColecaoConsultas();
        ColecaoPacientes colecaoPacientes = new ColecaoPacientes();
        ColecaoProntuarios colecaoProntuarios = new ColecaoProntuarios();
        ColecaoMedicos colecaoMedicos = new ColecaoMedicos();
        ColecaoSecretarias colecaoSecretarias = new ColecaoSecretarias();
        ColecaoDadosMedicos colecaoDadosMedicos = new ColecaoDadosMedicos();
        
        //Inicializando os menus
        MenuAdm menuAdm = new MenuAdm(colecaoMedicos, colecaoSecretarias);
        MenuSecretaria menuSecretaria = new MenuSecretaria(colecaoMedicos, colecaoPacientes, colecaoConsultas, colecaoSecretarias);
        MenuMedico menuMedico = new MenuMedico(colecaoConsultas, colecaoPacientes, colecaoProntuarios, colecaoMedicos, colecaoDadosMedicos);
        
        boolean firstInit = true;
        
        if(firstInit){
            System.out.println("Na primeira inicialização do sistema é necessario logar como Administrador para fazer as devidas configurações.\n");
            firstInit = false;
            System.out.print("Redirecionando para página do Administrador\n");
            Main.temporizador(2000);
            menuAdm.usuarioAdm();
            
        }
        
        Scanner read = new Scanner(System.in);
        int option;
               
         do {
            System.out.println("");
            System.out.println("TELA INICIAL");
            System.out.println("");
            System.out.println("+-------+------------------+");
            System.out.println("| Opção |      Tipo        |");
            System.out.println("+-------+------------------+");
            System.out.println("|   1   |  Administrador   |");
            System.out.println("|   2   |    Secretária    |");
            System.out.println("|   3   |      Médico      |");
            System.out.println("+-------+------------------+");        
            System.out.println("|   4   | Sair do Programa |");
            System.out.println("+-------+------------------+");
            System.out.println("");
            System.out.print("Qual usuário você vai logar (Opção): ");
            option = read.nextInt();

            int option1 = 0;
            switch (option) {
                case 1:
                    while (option1 != 3) {
                      option1 = menuAdm.usuarioAdm();
                      limpaTela();
                    }
                    break;

                case 2:                    
                    while (option1 != 2){
                        option1 = menuSecretaria.usuarioSecretaria();
                        limpaTela();
                    }                  
                    break;

                case 3:          
                    while (option1 != 2){
                        option1 = menuMedico.usuarioMedico();
                        limpaTela();
                    }       
                    break;
                    
                case 4:
                    System.out.println("Você realmente deseja 'SAIR' do programa?");
                    System.out.println("[1] Para sim \n[2] Para não");
                    System.out.print("Opção: ");
                    int resp = read.nextInt();
                    
                    if (resp == 2){
                        option = 0;
                    } else if (resp == 1) {
                        System.out.println("");
                        System.out.println("Saindo do programa...");
                        temporizador(2000);
                    }
                    break;
                    
                default:
                    System.out.println("OPÇÃO INVÁLIDA, DIGITE UMA DAS OPÇÕES!");
                    Main.temporizador(2000);
                    break;
            }
        } while (option != 4);
    }      
}  