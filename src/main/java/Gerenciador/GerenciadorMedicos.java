/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciador;
import Colecao.ColecaoConsultas;
import Colecao.ColecaoPacientes;
import Colecao.ColecaoProntuarios;
import Colecao.ColecaoDadosMedicos;

import Modelo.Paciente;
import Modelo.Consulta;
import Modelo.Prontuario;
import Modelo.DadosMedicos;
import Modelo.Medico;

import Main.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author jeanm
 */
public class GerenciadorMedicos {
    
    // Atributos
    private ColecaoConsultas colecaoConsultas;
    private ColecaoPacientes colecaoPacientes;
    private ColecaoProntuarios colecaoProntuarios;
    private ColecaoDadosMedicos colecaoDadosMedicos;
    private Medico medico;
    private Paciente paciente = null;
    private Consulta consultaAtual = null;
    private ArrayList<Consulta> consultasDoDia = new ArrayList();
    private int idDadosMedicosControle = 0;
    private int idProtuarioControle = 0;

    // Constructor
    public GerenciadorMedicos(ColecaoConsultas colecaoConsultas, ColecaoPacientes colecaoPacientes, ColecaoProntuarios colecaoProntuarios, ColecaoDadosMedicos colecaoDadosMedicos){
        this.colecaoConsultas = colecaoConsultas;
        this.colecaoPacientes = colecaoPacientes;
        this.colecaoProntuarios = colecaoProntuarios;
        this.colecaoDadosMedicos = colecaoDadosMedicos;
        
    }
    
    
    public Paciente getPaciente() {
        return paciente;
    }

    private void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Medico getMedico(){
        return this.medico;
    }
    
    public void setMedico(Medico medico){
        this.medico = medico;
    }
    
    public Consulta getConsultaAtual(){
        return this.consultaAtual;
    }
    
    public void setConsultaAtual(){
        Consulta consulta = this.consultasDoDia.get(0);
        this.consultasDoDia.remove(consulta);
        this.consultaAtual = consulta;
        this.setPaciente(colecaoPacientes.getPacienteById(consultaAtual.getPacienteId()));
    }
    
    public void resetConsultaAtual(){
        this.consultaAtual.setConsutaFinalizada(true);
        
        this.consultaAtual = null;
        this.paciente = null;
    }
    
    public ArrayList<Consulta> getConsultasDoDia(){
        return this.consultasDoDia;
    }
    
    public void setConsultasDoDia(){
        ArrayList<Consulta> consultas = colecaoConsultas.getConsultas();
        
        LocalDate dataAtual = LocalDate.now();
        
        for (Consulta consulta : consultas){
            if(consulta.getMedicoId() == medico.getId() && consulta.getData().equals(dataAtual) && !consulta.getConsutaFinalizada()){
                if(!consultasDoDia.contains(consulta)){
                    this.consultasDoDia.add(consulta);    
                }
            }
        }
        
        Collections.sort(this.consultasDoDia, new Comparator<Consulta>() {
            
            @Override
            public int compare(Consulta c1, Consulta c2) {
                return c1.getHorario().compareTo(c2.getHorario());
           }
        });
    }
    

    public void resetConsultasDoDia(){
        this.consultasDoDia = new ArrayList<Consulta>();
    }
            
    public void listaConsultasDoDia(){
        if (this.consultasDoDia.isEmpty()) {
            System.out.println("Nenhuma consulta para hoje.");
            return;        
            
        }
       
        System.out.println("+----------------------------------+");
        System.out.println("         LISTA DE CONSULTAS         ");
        System.out.println("+----------------------------------+");

        for (Consulta consulta : consultasDoDia) {
            System.out.println("ID: " + consulta.getId());
            System.out.println("Data: " + consulta.getData());
            System.out.println("Horário: " + consulta.getHorario());
            System.out.println("Paciente: " + colecaoPacientes.getPacienteById(consulta.getPacienteId()).getNome());
            System.out.println("+----------------------------------+");
        }
    }
    
    Scanner read = new Scanner(System.in);
    
    public void cadastrarProntuario(){
        
        if(consultaAtual.getProtuarioId() != 0){
            System.out.println("Consulta já possui um prontuario cadastrado");
            
        }
        else{
            System.out.println("+----------------------------------+");
            System.out.println("        CADASTRAR PRONTUÁRIO        ");
            System.out.println("+----------------------------------+");

            LocalDate dataConsulta = consultaAtual.getData();

            System.out.println("Informe os sintomas:");
            String sintomas = read.nextLine();

            System.out.println("Informe o diagnóstico:");
            String diagnostico = read.nextLine();

            System.out.println("Informe o tratamento:");
            String tratamento = read.nextLine();

            // Cria um novo prontuário com os dados coletados
            Prontuario prontuario = new Prontuario(dataConsulta, sintomas, diagnostico, tratamento);

            // Adiciona o prontuário à coleção de prontuários
            this.idProtuarioControle += 1;
            prontuario.setId(idProtuarioControle);
            prontuario.setPacienteId(colecaoPacientes.getPacienteById(consultaAtual.getPacienteId()));

            consultaAtual.setProtuarioId(prontuario);
            colecaoProntuarios.add(prontuario);

            System.out.println("");
            System.out.println("+====================================+");
            System.out.println("  PRONTUARIO CADASTRADO COM SUCESSO!  ");
            System.out.println("+====================================+");     
        }
    }
    
    public void atualizarProntuario() {
        
        System.out.println("+----------------------------------+");
        System.out.println("        ATUALIZAR PRONTUÁRIO        ");
        System.out.println("+----------------------------------+");
        
        if(this.listarProntuarios() == 0){
            return;
        }
               
        System.out.println("Informe o ID do prontuário a ser atualizado:");
        int id = Integer.parseInt(read.nextLine());

        Prontuario prontuario = colecaoProntuarios.getProntuarioById(id);

        if (prontuario == null) {
            System.out.println("Prontuário não encontrado!");
            return;
        }

        String resposta = read.nextLine();
        
        //System.out.println("Atualizar a data da consulta? (atual: " + prontuario.getDataConsulta() + ")");
        //System.out.println("[0] - Para sim \n[1] - Para não");
        //String resposta = read.nextLine();
        //if (resposta.equals("0")) {
        //    System.out.println("Informe a nova data da consulta (formato: YYYY-MM-DD):");
        //    LocalDate dataConsulta = LocalDate.parse(read.nextLine());
        //    prontuario.setDataConsulta(dataConsulta);
        //}

        System.out.println("Atualizar os sintomas? (atual: " + prontuario.getSintomas() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.println("Informe os novos sintomas:");
            String sintomas = read.nextLine();
            prontuario.setSintomas(sintomas);
        }

        System.out.println("Atualizar o diagnóstico? (atual: " + prontuario.getDiagnostico() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.println("Informe o novo diagnóstico:");
            String diagnostico = read.nextLine();
            prontuario.setDiagnostico(diagnostico);
        }

        System.out.println("Atualizar o tratamento? (atual: " + prontuario.getTratamento() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        resposta = read.nextLine();
        if (resposta.equals("0")) {
            System.out.println("Informe o novo tratamento:");
            String tratamento = read.nextLine();
            prontuario.setTratamento(tratamento);
        }

        System.out.println("+====================================+");
        System.out.println("  PRONTUARIO ATUALIZADO COM SUCESSO!  ");
        System.out.println("+====================================+"); 
    }
    
    
    public void removerProntuario() {
        
        System.out.println("+----------------------------------+");
        System.out.println("         REMOVER PRONTUÁRIO         ");
        System.out.println("+----------------------------------+");

        if(this.listarProntuarios() == 0){
            return;
        }
        
        System.out.println("Informe o ID do prontuário a ser removido:");
        int id = read.nextInt();
        read.nextLine();

        Prontuario prontuario = colecaoProntuarios.getProntuarioById(id);
        System.out.println(prontuario.getId());
            
        if (prontuario == null) {
            System.out.println("Prontuário não encontrado!");
            return;
        }

        for(Consulta consulta : colecaoConsultas.getConsultas()){
            if(consulta.getProtuarioId() == id){
                consulta.setProtuarioId();
                colecaoProntuarios.remove(prontuario);
            }
        }
            
        //consultaAtual.setProtuarioId();

        System.out.println("+==================================+");
        System.out.println("  PRONTUARIO REMOVIDO COM SUCESSO!  ");
        System.out.println("+==================================+"); 

    }

    
    public int listarProntuarios(){
        
        int cont = 0;
        
        for(Prontuario prontuario : colecaoProntuarios.getProntuarios()){
            if(prontuario.getPacienteId() == consultaAtual.getPacienteId()){
                cont += 1;
                System.out.println("+-------------------------------------------------+");
                System.out.println("ID: " + prontuario.getId());
                System.out.println("Data consulta: " + prontuario.getDataConsulta());
                System.out.println("Sintomas: " + prontuario.getSintomas());
                System.out.println("Diagnostico: " + prontuario.getDiagnostico());
                System.out.println("Tratamento: " + prontuario.getTratamento());
            }
        }
        System.out.println("+-------------------------------------------------+");
        System.out.println("");
        if(cont == 0){
            System.out.println("Nenhum prontuario cadastrado");
        }
        return cont;
    }
    
        
    public void cadastrarDados(){
        Paciente paciente  = colecaoPacientes.getPacienteById(consultaAtual.getPacienteId());
        
        if(paciente.getDadosMedicosId() != 0){
            System.out.println("O paciente " + paciente.getNome() + " já possui dados médicos cadastrados");
        }
        else{
            
            System.out.println("+----------------------------------+");
            System.out.println("      CADRASTRAR DADOS MÉDICOS      ");
            System.out.println("+----------------------------------+");

            System.out.println("O paciente fuma? \n[1] Para sim \n[2] Para não");
            int resp = read.nextInt();
            boolean fuma = (resp == 1);

            System.out.println("O paciente bebe? \n[1] Para sim \n[2] Para não");
            int resp1 = read.nextInt();
            read.nextLine();
            boolean bebe = (resp1 == 1);

            System.out.println("Nível de colesterol:");
            String colesterol = read.nextLine();

            System.out.println("O paciente é diabético? \n[1] Para sim \n[2] Para não");
            int resp2 = read.nextInt();
            boolean diabete = (resp2 == 1);

            System.out.println("O paciente tem doença cardíaca? \n[1] Para sim \n[2] Para não");
            int resp3 = read.nextInt();
            read.nextLine();
            boolean doencaCardiaca = (resp3 == 1);
            
            System.out.println("Informe as cirurgias realizadas (separadas por vírgula):");
            List<String> cirurgias = List.of(read.nextLine().split(","));

            System.out.println("Informe as alergias (separadas por vírgula):");
            List<String> alergias = List.of(read.nextLine().split(","));

            DadosMedicos dadosMedicos = new DadosMedicos(fuma, bebe, colesterol, diabete, doencaCardiaca, cirurgias, alergias);
            this.idDadosMedicosControle += 1;
            dadosMedicos.setId(idDadosMedicosControle);
            paciente.setDadosMedicosId(dadosMedicos);
            colecaoDadosMedicos.add(dadosMedicos);


            System.out.println("+=======================================+");
            System.out.println("  DADOS MÉDICOS CADASTRADO COM SUCESSO!  ");
            System.out.println("+=======================================+");    
        }
    }
    
    
    public void  atualizarDados(){
        
        Paciente paciente  = colecaoPacientes.getPacienteById(consultaAtual.getPacienteId());
        
        if(paciente.getDadosMedicosId() == 0){
            System.out.println("Não existe dados médicos cadastrado!");
        }
        else{
            System.out.println("+----------------------------------+");
            System.out.println("       ATUALIZAR DADOS MÉDICOS      ");
            System.out.println("+----------------------------------+");

            DadosMedicos dadosMedicos = colecaoDadosMedicos.getDadosMedicosById(paciente.getDadosMedicosId());
            
            System.out.println("Dados atuais:");
            System.out.println("Fuma: " + dadosMedicos.isFuma());
            System.out.println("Bebe: " + dadosMedicos.isBebe());
            System.out.println("Colesterol: " + dadosMedicos.getColesterol());
            System.out.println("Diabete: " + dadosMedicos.isDiabete());
            System.out.println("Doença Cardíaca: " + dadosMedicos.isDoencaCardiaca());
            System.out.println("Cirurgias: " + String.join(", ", dadosMedicos.getCirurgias()));
            System.out.println("Alergias: " + String.join(", ", dadosMedicos.getAlergias()));
            System.out.println("+----------------------------------+");
            System.out.println("");
            
            System.out.println("Atualizar fumar? - Atual: " + dadosMedicos.isFuma());
            System.out.println("[0] - Para sim \n[1] - Para não");
            String resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("O paciente fuma? \n[1] Para sim \n[2] Para não");
                int resp = read.nextInt();
                read.nextLine();
                boolean fuma = (resp == 1);
                dadosMedicos.setFuma(fuma);
            }

            System.out.println("Atualizar bebe? - Atual: " + dadosMedicos.isBebe());
            System.out.println("[0] - Para sim \n[1] - Para não");
            resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("O paciente bebe? \n[1] Para sim \n[2] Para não");
                int resp = read.nextInt();
                read.nextLine();
                boolean bebe = (resp == 1);
                dadosMedicos.setBebe(bebe);
            }

            System.out.println("Atualizar colesterol - Atual: " + dadosMedicos.getColesterol());
            System.out.println("[0] - Para sim \n[1] - Para não");
            resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("Informe o novo nível de colesterol:");
                String colesterol = read.nextLine();
                dadosMedicos.setColesterol(colesterol);
            }

            System.out.println("Atualizar diabete? - Atual: " + dadosMedicos.isDiabete());
            System.out.println("[0] - Para sim \n[1] - Para não");
            resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("O paciente é diabético? \n[1] Para sim \n[2] Para não");
                int resp = read.nextInt();
                read.nextLine();
                boolean diabete = (resp == 1);
                dadosMedicos.setDiabete(diabete);
            }

            System.out.println("Atualizar doença cardíaca? - Atual: " + dadosMedicos.isDoencaCardiaca());
            System.out.println("[0] - Para sim \n[1] - Para não");
            resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("O paciente tem doença cardíaca? \n[1] Para sim \n[2] Para não");
                int resp = read.nextInt();
                read.nextLine();
                boolean doencaCardiaca = (resp == 1);
                dadosMedicos.setDoencaCardiaca(doencaCardiaca);
            }

            System.out.println("Atualizar cirurgias (separadas por vírgula) - Atual: " + String.join(", ", dadosMedicos.getCirurgias()));
            System.out.println("[0] - Para sim \n[1] - Para não");
            resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("Informe as novas cirurgias (separadas por vírgula):");
                List<String> cirurgias = List.of(read.nextLine().split(","));
                dadosMedicos.setCirurgias(cirurgias);
            }

            System.out.println("Atualizar alergias (separadas por vírgula) - Atual: " + String.join(", ", dadosMedicos.getAlergias()));
            System.out.println("[0] - Para sim \n[1] - Para não");
            resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("Informe as novas alergias (separadas por vírgula):");
                List<String> alergias = List.of(read.nextLine().split(","));
                dadosMedicos.setAlergias(alergias);
            }

            System.out.println("+=======================================+");
            System.out.println("  DADOS MÉDICOS ATUALIZADO COM SUCESSO!  ");
            System.out.println("+=======================================+");
        }
           
    }
    
    public void removerDados(){
        
        Paciente paciente  = colecaoPacientes.getPacienteById(consultaAtual.getPacienteId());

        //Vericar se o paciente da consulta atual tem dados medicos já cadastrados
        
        if (paciente.getDadosMedicosId() == 0) {
            System.out.println("O paciente não possui dados medicos cadastrados!");
            return;
        }
        else{
            colecaoDadosMedicos.removeById(paciente.getDadosMedicosId());

            paciente.setDadosMedicosId();

            System.out.println("+=====================================+");
            System.out.println("  DADOS MÉDICOS REMOVIDO COM SUCESSO!  ");
            System.out.println("+=====================================+");
        }
    }

    
    public void listarDados() {
        
        Paciente paciente  = colecaoPacientes.getPacienteById(consultaAtual.getPacienteId());
        
        if(paciente.getDadosMedicosId() == 0){
            System.out.println("O paciente " + paciente.getNome() + " não possui dados médicos cadastrados");
        }
        else{
            System.out.println("+----------------------------------+");
            System.out.println("        LISTAR DADOS MÉDICOS        ");
            System.out.println("+----------------------------------+");

            DadosMedicos dadosMedicos = colecaoDadosMedicos.getDadosMedicosById(paciente.getDadosMedicosId());

            System.out.println("ID: " + dadosMedicos.getId());
            System.out.println("Fuma: " + dadosMedicos.isFuma());
            System.out.println("Bebe: " + dadosMedicos.isBebe());
            System.out.println("Colesterol: " + dadosMedicos.getColesterol());
            System.out.println("Diabete: " + dadosMedicos.isDiabete());
            System.out.println("Doença Cardíaca: " + dadosMedicos.isDoencaCardiaca());
            System.out.println("Cirurgias: " + String.join(", ", dadosMedicos.getCirurgias()));
            System.out.println("Alergias: " + String.join(", ", dadosMedicos.getAlergias()));
            System.out.println("+----------------------------------+");
        }
    }

    
    public void listarAllConsultas(){
        //Listas todas as consultas associadas ao medico
        ArrayList<Consulta> allConsultas = colecaoConsultas.getConsultas();
        for(Consulta consulta : allConsultas){
            if(consulta.getMedicoId() == medico.getId()){
                System.out.println("ID: " + consulta.getId());
                System.out.println("Data: " + consulta.getData());
                System.out.println("Horário: " + consulta.getHorario());
                System.out.println("Tipo: " + consulta.getTipo());
                System.out.println("Paciente: " + colecaoPacientes.getPacienteById(consulta.getPacienteId()).getNome());
                System.out.println("+----------------------------------+");
            }
        }
    }
    
    
    public void receitaMedica() {

        System.out.println("Separe os medicamentos por virgula(',')!");
        System.out.print("Informe os medicamentos para colocar na receita: ");
        String medicamentos = read.nextLine();
        String[] arrayMedicamentos = medicamentos.split(",");
        System.out.println("");        

        System.out.println("Gerando receita... ");
        Main.temporizador(3000);

        System.out.println("");
        System.out.println("+=========================================+");
        System.out.println("              RECEITA MÉDICA               ");
        System.out.println("+=========================================+");
        System.out.println("Consultório: +Melhor");
        System.out.println("Doutor: " + medico.getNome());
        System.out.println("Data: " + LocalDate.now()); 
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("");
        System.out.println("Medicamentos: ");

        for (String medicamento : arrayMedicamentos){
            System.out.println("         " + medicamento);
        }

        System.out.println("+=========================================+");
    }
    
    public void atestadoMedico() {


        System.out.print("Motivo da ausência: ");
        String ausencia = read.nextLine();

        System.out.print("Quantos dias de afastamento?");
        int afastamento = read.nextInt();
        read.nextLine();

        System.out.println("Gerando atestado...");
        Main.temporizador(3000);

        System.out.println("+=========================================+");
        System.out.println("             ATESTADO MÉDICO               ");
        System.out.println("+=========================================+");
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Data: " + LocalDate.now());
        System.out.println("Dias de repouso: " + afastamento);
        System.out.println("Médico responsável: " + medico.getNome());
        System.out.println("+=========================================+");
    }
    
    public void declaracaoAcompanhamento(){
        System.out.print("Nome do acompanhante: ");
        String acompanhante = read.nextLine();

        System.out.print("Motivo do acompanhante: ");
        String motivo = read.nextLine();

        System.out.println("Gerando declaraçao de acompanhamento...");
        Main.temporizador(3000);

        System.out.println("+=========================================+");
        System.out.println("        DECLARAÇÃO DE ACOMPANHAMENTO       ");
        System.out.println("+=========================================+");
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Acompanhante: " + acompanhante);
        System.out.println("Motivo do acompanhante: " + motivo);
        System.out.println("");
        System.out.println("Data: " + LocalDate.now());
        System.out.println("Médico responsável: " + medico.getNome());
        System.out.println("+=========================================+");

    }
    
    public void relatorioMensal(){
        
        int totalClientes = 0;
        
        System.out.println("+=========================================+");
        System.out.println("        RELATÓRIO MENSAL DE CLIENTES       ");
        System.out.println("+=========================================+");
        
        int mesAtual = LocalDate.now().getMonthValue();
        for (Consulta consulta : colecaoConsultas.getConsultas()){
            if (consulta.getMedicoId() == medico.getId())
                if (consulta.getConsutaFinalizada()){
                    if (consulta.getData().getMonthValue() == mesAtual){
                        totalClientes ++;

                        System.out.println(colecaoPacientes.getPacienteById(consulta.getPacienteId()).getNome());
                        System.out.println(colecaoPacientes.getPacienteById(consulta.getPacienteId()).getTipoConvenio());
                        System.out.println("+------------------------------------------+");
                    }
                }
        }
        System.out.println("+=========================================+");
        System.out.println("Total de Clientes atendidos nesse mês: " + totalClientes);
        
    }
}