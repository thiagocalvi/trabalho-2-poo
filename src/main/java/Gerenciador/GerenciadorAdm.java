/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciador;

import Colecao.ColecaoMedicos;
import Colecao.ColecaoSecretarias;

import Modelo.Medico;
import Modelo.Secretaria;


import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author thiago
 */

// Gerenciador de uso exclusivo do Administrador
// CRUD dos objetos Secretaria e Médico

public class GerenciadorAdm {
    
    private final ColecaoMedicos colecaoMedicos;
    private final ColecaoSecretarias colecaoSecretarias;
    private int idMedicoControle = 0;
    private int idSecretariaControle = 0;
    
    
    public GerenciadorAdm(ColecaoMedicos colecaoMedicos, ColecaoSecretarias colecaoSecretarias){
        this.colecaoMedicos = colecaoMedicos;
        this.colecaoSecretarias = colecaoSecretarias;
    }
    
    Scanner read = new Scanner(System.in);
    
    //METODOS MEDICO
    public void cadastroMedicosInterno(){
        
        Random random = new Random();
            
        String[] nomes = {"João Silva", "Maria Oliveira", "Carlos Souza", "Ana Santos", "Pedro Lima"};
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
            Medico medico = new Medico(nomes[i], datasNascimento[i], telefones[i], emails[i], especialidades[i], crms[i]);
            this.idMedicoControle += 1;
            medico.setId(this.idMedicoControle);
            
            int rIdSecretaria = random.nextInt(2)+1;
            Secretaria secretaria = this.colecaoSecretarias.getSecretariaById(rIdSecretaria);
            
            medico.setSecretariaId(secretaria);
            this.colecaoMedicos.add(medico);
        }
           
        System.out.println("Processo finalizado! Médicos cadastrados");
    }
    
    
    public void cadastrarMedico() {
        System.out.println("+----------------------------------+");
        System.out.println("          TELA DE CADASTRO          ");
        System.out.println("+----------------------------------+");
        
        System.out.print("Nome médico: ");
        
        String nome = read.nextLine();
        
        System.out.print("Data de nascimento (formato: DD/MM/YYYY): ");
        String data = read.nextLine();
        
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));    
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        
        System.out.print("Telefone: ");
        String telefone = read.nextLine();
        
        System.out.print("E-mail:");
        String email = read.nextLine();
        
        System.out.print("Especialidade: ");
        String especialidade = read.nextLine();
        
        System.out.print("CRM: ");
        int crm = read.nextInt();
        
        // Listar as secretárias
        this.listarSecretarias();
        
        System.out.println("");
        System.out.print("Informe o ID da secretaria: ");
        int idSecretaria = read.nextInt();
        read.nextLine();
        
        Secretaria secretaria = colecaoSecretarias.getSecretariaById(idSecretaria);
        
        Medico medico = new Medico(nome, dataNascimento, telefone, email, especialidade, crm);
        this.idMedicoControle += 1;
        medico.setId(this.idMedicoControle);
        medico.setSecretariaId(secretaria);
               
        colecaoMedicos.add(medico);
            
        System.out.println("+==================================+");
        System.out.println("    MÉDICO CADASTRO COM SUCESSO!    ");
        System.out.println("+==================================+");

    }
    
    public void listarMedicos(){
        System.out.println("");
        System.out.println("+----------------------------------------+");
        System.out.println("              LISTA MEDICOS               ");
        System.out.println("+----------------------------------------+");
        
        ArrayList<Medico> allMedicos = colecaoMedicos.getMedicos();
        
        int index = 1;
        
        for(Medico medico : allMedicos){

            System.out.printf("| Index: %-25s \n", index);
            System.out.printf("| Id: %-25s \n", medico.getId());
            System.out.printf("| Nome: %-25s \n", medico.getNome());
            System.out.printf("| Data de nascimento: %-10s \n", medico.getDataNascimento());
            System.out.printf("| Telefone: %-19s \n", medico.getTelefone());
            System.out.printf("| Email: %-22s \n", medico.getEmail());
            System.out.printf("| Especialidade: %-15s \n", medico.getEspecialidade());
            System.out.printf("| CRM: %-24d \n", medico.getCrm());
            System.out.printf("| Secretaria Id: %-25s \n", medico.getSecretariaId());
            System.out.println("+----------------------------------------+");

            index += 1;
        }   
        System.out.println("\n");
    }

    public void atualizarMedico(){

        System.out.println("+----------------------------------+");
        System.out.println("          ATUALIZAR MEDICO          ");
        System.out.println("+----------------------------------+");
        
        this.listarMedicos();
        
        System.out.println("Informe o id do médico que será atualizado: ");
        int id = read.nextInt();
        read.nextLine();
        
        Medico medico = colecaoMedicos.getMedicoById(id);
        
        if (medico == null) {
            System.out.println("Médico não encontrado!");
            return;
        }

        System.out.println("+----------------------------------------+");
        System.out.printf("| Id: %-25s \n", medico.getId());    
        System.out.printf("| Nome: %-25s \n", medico.getNome());
        System.out.printf("| Data de nascimento: %-10s \n", medico.getDataNascimento());
        System.out.printf("| Telefone: %-19s \n", medico.getTelefone());
        System.out.printf("| Email: %-22s \n", medico.getEmail());
        System.out.printf("| Especialidade: %-15s \n", medico.getEspecialidade());
        System.out.printf("| CRM: %-24d \n", medico.getCrm());
        System.out.printf("| Secretaria Id: %-24d \n", medico.getSecretariaId());
        System.out.println("+----------------------------------------+");
        System.out.println();
        
        System.out.println("Atualizar nome? (atual: " + medico.getNome() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        String resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.print("Nome médico: ");
            String nome = read.nextLine();
            if (!nome.equals(medico.getNome()) && !nome.isEmpty()) {
                medico.setNome(nome);
            }
        }
        
        System.out.println("Atualizar data de nascimento? (atual: " + medico.getDataNascimento() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.println("Data de nascimento DIA/MES/ANO: ");
            System.out.print("00/00/0000 : ");
            String data = read.nextLine();
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3, 5));
            int ano = Integer.parseInt(data.substring(6, 10));
            LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
            if (!dataNascimento.equals(medico.getDataNascimento())) {
                medico.setDataNascimento(dataNascimento);
            }
        }
        
        System.out.println("Atualizar telefone? (atual: " + medico.getTelefone() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.print("Telefone: ");
            String telefone = read.nextLine();
            if (!telefone.equals(medico.getTelefone()) && !telefone.isEmpty()) {
                medico.setTelefone(telefone);
            }
        }
        
        System.out.println("Atualizar email? (atual: " + medico.getEmail() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.print("E-mail: ");
            String email = read.nextLine();
            if (!email.equals(medico.getEmail()) && !email.isEmpty()) {
                medico.setEmail(email);
            }
        }

        System.out.println("Atualizar especialidade? (atual: " + medico.getEspecialidade() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.print("Especialidade: ");
            String especialidade = read.nextLine();
            if (!especialidade.equals(medico.getEspecialidade()) && !especialidade.isEmpty()) {
                medico.setEspecialidade(especialidade);
            }
        }
        
        System.out.println("Atualizar CRM? (atual: " + medico.getCrm() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.print("CRM: ");
            int crm = read.nextInt();
            read.nextLine();
            if (crm != medico.getCrm()) {
                medico.setCrm(crm);
            }
        }
        
        System.out.println("Atualizar secretaria? (atual: " + colecaoSecretarias.getSecretariaById(medico.getSecretariaId()).getNome() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            this.listarSecretarias();
            System.out.print("Informe o id da secretaria (deve ser informado um id): ");
            int idSecretaria = read.nextInt();
            read.nextLine();
            Secretaria secretaria = colecaoSecretarias.getSecretariaById(idSecretaria);
            if (secretaria != null) {
                medico.setSecretariaId(secretaria);
            }
        }
        
        System.out.println("+====================================+");
        System.out.println("    MÉDICO ATUALIZADO COM SUCESSO!    ");
        System.out.println("+====================================+");
        
    }
    
    public void removerMedico(){
        System.out.println("+----------------------------------+");
        System.out.println("           REMOVER MEDICO           ");
        System.out.println("+----------------------------------+");
        
        this.listarMedicos();
        
        System.out.println("Informe o id do médico que será removido: ");
        int id = read.nextInt();
        read.nextLine();
        
        colecaoMedicos.removeById(id);
        
        System.out.println("+==================================+");
        System.out.println("    MÉDICO REMOVIDO COM SUCESSO!    ");
        System.out.println("+==================================+");
    }
    
    
    //METODOS SECRETARIA
    public void cadastroSecretariaInterno(){
        
        String[] nomes = {"João Silva", "Maria Oliveira"};
        LocalDate[] datasNascimento = {LocalDate.of(1985, 5, 15), LocalDate.of(1990, 8, 20)};
        String[] telefones = {"555-1234", "555-5678"};
        String[] emails = {"joao.silva@example.com", "maria.oliveira@example.com"};
        
        for(int i = 0; i < nomes.length; i++){
            Secretaria secretaria = new Secretaria(nomes[i], datasNascimento[i], telefones[i], emails[i]);
            this.idSecretariaControle += 1;
            secretaria.setId(this.idSecretariaControle);
               
            colecaoSecretarias.add(secretaria);
            
        }
        
        System.out.println("Processo finalizado! Secretarias cadastradas");
    }
    
    
    public void cadastrarSecretaria(){
        System.out.println("+----------------------------------+");
        System.out.println("          TELA DE CADASTRO          ");
        System.out.println("+----------------------------------+");
        
        System.out.print("Nome da secretaria: ");
        String nome = read.nextLine();
        
        System.out.println("Data de nascimento DIA/MES/ANO: ");
        System.out.print("00/00/0000 : ");
        String data = read.nextLine();
        
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));    
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        
        System.out.print("Telefone: ");
        String telefone = read.nextLine();
        
        System.out.print("E-mail:");
        String email = read.nextLine();
        
        
        Secretaria secretaria = new Secretaria(nome, dataNascimento, telefone, email);
        this.idSecretariaControle += 1;
        secretaria.setId(idSecretariaControle);
        
        colecaoSecretarias.add(secretaria);
            
        System.out.println("+======================================+");
        System.out.println("   SECRETÁRIA CADASTRADO COM SUCESSO!   ");
        System.out.println("+======================================+");   
    }
       
    public void atualizarSecretaria(){
        System.out.println("+----------------------------------+");
        System.out.println("        ATUALIZAR SECRETARIA        ");
        System.out.println("+----------------------------------+");
        
        this.listarSecretarias();
        
        System.out.println("Informe o id da secretaria que será atualizado: ");
        int id = read.nextInt();
        read.nextLine();
        
        Secretaria secretaria = colecaoSecretarias.getSecretariaById(id);
        
        if (secretaria == null) {
        System.out.println("Secretaria não encontrada!");
        return;
        }

        System.out.println("+----------------------------------------+");
        System.out.printf("| Id: %-25s \n", secretaria.getId());    
        System.out.printf("| Nome: %-25s \n", secretaria.getNome());
        System.out.printf("| Data de nascimento: %-10s \n", secretaria.getDataNascimento());
        System.out.printf("| Telefone: %-19s \n", secretaria.getTelefone());
        System.out.printf("| Email: %-22s \n", secretaria.getEmail());
        System.out.println("+----------------------------------------+");
        System.out.println();
        
        System.out.println("Atualizar nome? (atual: " + secretaria.getNome() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        String resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.print("Nome secretaria: ");
            String nome = read.nextLine();
            if (!nome.equals(secretaria.getNome()) && !nome.isEmpty()) {
                secretaria.setNome(nome);
            }
        }
        
        System.out.println("Atualizar data de nascimento? (atual: " + secretaria.getDataNascimento() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.println("Data de nascimento DIA/MES/ANO: ");
            System.out.print("00/00/0000 : ");
            String data = read.nextLine();
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3, 5));
            int ano = Integer.parseInt(data.substring(6, 10));
            LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
            if (!dataNascimento.equals(secretaria.getDataNascimento())) {
                secretaria.setDataNascimento(dataNascimento);
            }
        }
        
        System.out.println("Atualizar telefone? (atual: " + secretaria.getTelefone() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.print("Telefone: ");
            String telefone = read.nextLine();
            if (!telefone.equals(secretaria.getTelefone()) && !telefone.isEmpty()) {
                secretaria.setTelefone(telefone);
            }
        }
        
        System.out.println("Atualizar email? (atual: " + secretaria.getEmail() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.print("E-mail: ");
            String email = read.nextLine();
            if (!email.equals(secretaria.getEmail()) && !email.isEmpty()) {
                secretaria.setEmail(email);
            }
        }

        System.out.println("+======================================+");
        System.out.println("   SECRETÁRIA ATUALIZADA COM SUCESSO!   ");
        System.out.println("+======================================+");
    }
    
    public void removerSecretaria(){
        System.out.println("+----------------------------------------+");
        System.out.println("            REMOVER SECRETARIA            ");
        System.out.println("+----------------------------------------+");
        
        this.listarSecretarias();
        
        System.out.println("Informe o id do secretaria que será removido: ");
        int id = read.nextInt();
        read.nextLine();
        
        colecaoSecretarias.removeById(id);
        
        System.out.println("+======================================+");
        System.out.println("    SECRETÁRIA REMOVIDA COM SUCESSO!    ");
        System.out.println("+======================================+");
    }

    public void listarSecretarias(){

        System.out.println("");
        System.out.println("+----------------------------------------+");
        System.out.println("            LISTA SECRETARIAS             ");
        System.out.println("+----------------------------------------+");
        
        ArrayList<Secretaria> allSecretarias = colecaoSecretarias.getSecretarias();
        
        int index = 1;
        
        for(Secretaria secretaria : allSecretarias){

            System.out.println("+----------------------------------------+");
            System.out.printf("| Id: %-25s \n", secretaria.getId());
            System.out.printf("| Nome: %-25s \n", secretaria.getNome());
            System.out.printf("| Data de nascimento: %-10s \n", secretaria.getDataNascimento());
            System.out.printf("| Telefone: %-19s \n", secretaria.getTelefone());
            System.out.printf("| Email: %-22s \n", secretaria.getEmail());
            System.out.println("+----------------------------------------+");

            index += 1;
        }       
        System.out.println("\n");
    }
}
