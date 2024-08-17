/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciador;
import Modelo.Secretaria;
import Modelo.Paciente;
import Modelo.Medico;
import Modelo.Consulta;

import Colecao.ColecaoConsultas;
import Colecao.ColecaoMedicos;
import Colecao.ColecaoPacientes;
import java.time.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 *
 * @author jeanm
 */
public class GerenciadorSecretarias {
    
    private ColecaoConsultas colecaoConsultas;
    private ColecaoMedicos colecaoMedicos; 
    private ColecaoPacientes colecaoPacientes;
    private Secretaria secretaria;
    private int idConsultaControle = 0;
    private int idPacienteControle = 0;
    
    public GerenciadorSecretarias(ColecaoConsultas colecaoConsultas, ColecaoMedicos colecaoMedicos, ColecaoPacientes colecaoPacientes){
        this.colecaoConsultas = colecaoConsultas;
        this.colecaoMedicos = colecaoMedicos;
        this.colecaoPacientes = colecaoPacientes;
    }
    
    private Scanner read = new Scanner(System.in);
    
    public Secretaria getSecretaria(){
        return this.secretaria;
    }
    
    public void setSecretaria(Secretaria secretaria){
        this.secretaria = secretaria;
    }
    
    public void cadastrarConsulta() {
        System.out.println("+------------------------------+");
        System.out.println("       CADASTRAR CONSULTA       ");
        System.out.println("+------------------------------+");

        // Coleta de dados
        LocalDate dataConsulta = null;
        LocalTime horarioConsulta = null;
        boolean dataValida = false;
        boolean horaValida = false;
        
        while (!dataValida) {
            System.out.print("Informe a data da consulta (formato: DD/MM/YYYY): ");
            String data = read.nextLine();

            try {
                int dia = Integer.parseInt(data.substring(0, 2));
                int mes = Integer.parseInt(data.substring(3, 5));
                int ano = Integer.parseInt(data.substring(6, 10));
                dataConsulta = LocalDate.of(ano, mes, dia);

                if (dataConsulta.isBefore(LocalDate.now())) {
                    System.out.println("A data da consulta não pode ser anterior à data atual.");
                } else {
                    dataValida = true;
                }
            } catch (Exception e) {
                System.out.println("Data inválida. Por favor, use o formato DD/MM/YYYY.");
            }
        }
        
        while (!horaValida) {
            System.out.print("Informe o horário da consulta (formato: HH:MM): ");
            String horario = read.nextLine();

            try {
                int hora = Integer.parseInt(horario.substring(0, 2));
                int minuto = Integer.parseInt(horario.substring(3, 5));
                horarioConsulta = LocalTime.of(hora, minuto);

                // Combina data e hora para comparar com o momento atual
                LocalDateTime dataHoraConsulta = LocalDateTime.of(dataConsulta, horarioConsulta);
                if (dataHoraConsulta.isBefore(LocalDateTime.now())) {
                    System.out.println("O horário da consulta não pode ser anterior ao horário atual.");
                } else {
                    horaValida = true;
                }
            } catch (Exception e) {
                System.out.println("Horário inválido. Por favor, use o formato HH:MM.");
            }
        }
        

        //Listar os medicos
        this.listarMedicos();
        
        System.out.print("Informe o ID do médico:");
        int idMedico = read.nextInt();
        read.nextLine();
        
        Medico medico = colecaoMedicos.getMedicoById(idMedico);
        
        
        //Listar os pacientes
        this.listarPacientes();
        
        System.out.print("Informe o ID do paciente:");
        int idPaciente = read.nextInt();
        read.nextLine();
        
        Paciente paciente = colecaoPacientes.getPacienteById(idPaciente);
        
        // Tipo da consulta
        System.out.print("Informe o tipo da consulta(Normal/Retorno): ");
        String tipoStr = read.nextLine();
        while (!tipoStr.equalsIgnoreCase("Normal") && !tipoStr.equalsIgnoreCase("Retorno")) {
            System.out.println("Tipo inválido. Por favor, informe 'Normal' ou 'Retorno'.");
            System.out.print("Informe o tipo da consulta (Normal/Retorno): ");
            tipoStr = read.nextLine();
        }
        
        // Cria a consulta
        Consulta consulta = new Consulta(dataConsulta, horarioConsulta);
        this.idConsultaControle += 1;
        consulta.setId(idConsultaControle);
        consulta.setMedicoId(medico);
        consulta.setPacienteId(paciente);
        consulta.setTipo(tipoStr.toUpperCase());
        consulta.setConsutaFinalizada(false);
        
        // Adiciona a consulta à coleção
        colecaoConsultas.add(consulta);

        System.out.println("+==================================+");
        System.out.println("  CONSULTA CADASTRADA COM SUCESSO!  ");
        System.out.println("+==================================+");
    }
    
    public void atualizarConsulta() {
        
        System.out.println("+------------------------------+");
        System.out.println("       ATUALIZAR CONSULTA       ");
        System.out.println("+------------------------------+");

        this.listarConsultas();
        
        System.out.println("Informe o ID da consulta a ser atualizada:");
        try {
            int id = Integer.parseInt(read.nextLine());
            Consulta consulta = colecaoConsultas.getConsultaById(id);

            if (consulta == null) {
                System.out.println("Consulta não encontrada!");
                return;
            }

            System.out.println("Atualizar a data da consulta? (atual: " + consulta.getData() + ")");
            System.out.println("[0] - Para sim \n[1] - Para não");
            String resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("");
                System.out.println("Informe a nova data da consulta (formato: DD/MM/YYYY):");
                String data = read.nextLine();
                
                int dia = Integer.parseInt(data.substring(0, 2));
                int mes = Integer.parseInt(data.substring(3, 5));
                int ano = Integer.parseInt(data.substring(6, 10));
                
                LocalDate dataConsulta = LocalDate.of(ano, mes, dia);
                consulta.setData(dataConsulta);
            }

            System.out.println("Atualizar o horário da consulta? (atual: " + consulta.getHorario() + ")");
            System.out.println("[0] - Para sim \n[1] - Para não");
            resposta = read.nextLine();
            if (resposta.equals("0")) {
                System.out.println("");
                System.out.println("Informe o novo horário da consulta (formato: HH:MM):");
                String horario = read.nextLine();
                
                int hora = Integer.parseInt(horario.substring(0, 2));
                int minuto = Integer.parseInt(horario.substring(3, 5));
                
                LocalTime horarioConsulta = LocalTime.of(hora, minuto);
                consulta.setHorario(horarioConsulta);
            }
            
            System.out.println("Atualizar o médico? (atual: " + colecaoMedicos.getMedicoById(consulta.getMedicoId()).getNome() + ")");
            System.out.println("[0] - Para sim \n[1] - Para não");
            resposta = read.nextLine();
            if (resposta.equals("0")){
                this.listarMedicos();
                System.out.println("Informe o ID do médico:");
                int medicoId = Integer.parseInt(read.nextLine());
                Medico medico = colecaoMedicos.getMedicoById(medicoId);
                consulta.setMedicoId(medico);
            }
            
            System.out.println("+==================================+");
            System.out.println("  CONSULTA ATUALIZADA COM SUCESSO!  ");
            System.out.println("+==================================+");   
            
        } catch (NumberFormatException e) {
            System.out.println("+-------------------------------------+");
            System.out.println("   ERRO: O ID informado não é válido   ");
            System.out.println("+-------------------------------------+");
        }
    }
    
    public void removerConsulta() {
        System.out.println("----------------------------");
        System.out.println("      REMOVER CONSULTA      ");
        System.out.println("----------------------------");
        
        this.listarConsultas();
        
        System.out.println("Informe o ID da consulta a ser removida:");
        int id = Integer.parseInt(read.nextLine());
        Consulta consulta = colecaoConsultas.getConsultaById(id);

        if (consulta == null) {
            System.out.println("Consulta não encontrada!");
            return;
        }

        colecaoConsultas.remove(consulta);

        System.out.println("+==================================+");
        System.out.println("   CONSULTA REMOVIDA COM SUCESSO!   ");
        System.out.println("+==================================+");
        
    }
    
    public void listarConsultas() {
        
        ArrayList<Consulta> consultas = colecaoConsultas.getConsultas();
        System.out.println("\n");
        
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        
        System.out.println("+----------------------------+");
        System.out.println("      LISTA DE CONSULTAS      ");
        System.out.println("+----------------------------+");

        for (Consulta consulta : consultas) {
            if(colecaoMedicos.getMedicoById(consulta.getMedicoId()).getSecretariaId() == secretaria.getId()){
                System.out.println("ID: " + consulta.getId());
                System.out.println("Data: " + consulta.getData());
                System.out.println("Horário: " + consulta.getHorario());
                System.out.println("Médico ID: " + consulta.getMedicoId());
                System.out.println("Médico: " + colecaoMedicos.getMedicoById(consulta.getMedicoId()).getNome());
                System.out.println("Paciente ID: " + consulta.getPacienteId());
                System.out.println("Paciente: " + colecaoPacientes.getPacienteById(consulta.getPacienteId()).getNome());
                System.out.println((consulta.getConsutaFinalizada()) ? "Consulta realizada: Sim" : "Consulta realizada: Não");
                System.out.println("+----------------------------------+");
                
            }
        }
        System.out.println("\n");
    }
    
    public void cadastrarPaciente(){
        System.out.println("+----------------------------+");
        System.out.println("      CADASTRAR PACIENTE      ");
        System.out.println("+----------------------------+");
        
        System.out.println("Informe o nome do paciente:");
        String nome = read.nextLine();
        
        System.out.println("Informe a data de nascimento (formato: DD/MM/YYYY):");
        String data = read.nextLine();
        
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));
        
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        
        System.out.println("Informe o telefone do paciente:");
        String telefone = read.nextLine();

        while(telefone.isEmpty()){
            System.out.println("Informe o telefone do paciente (essa informação é obrigatoria):");
            telefone = read.nextLine();
        }
        
        System.out.println("Informe o e-mail do paciente:");
        String email = read.nextLine();

        System.out.println("Informe o endereço do paciente:");
        String endereco = read.nextLine();

        System.out.println("Informe o tipo de convênio (PARTICULAR ou PLANOSAUDE):");
        Paciente.tipoConvenio tipoConvenio = Paciente.tipoConvenio.valueOf(read.nextLine().toUpperCase());

        Paciente paciente = new Paciente(tipoConvenio, nome, dataNascimento, endereco, telefone, email);
        this.idPacienteControle += 1;
        paciente.setId(idPacienteControle);
        colecaoPacientes.add(paciente);
            
        System.out.println("+==================================+");
        System.out.println("  PACIENTE CADASTRADO COM SUCESSO!  ");
        System.out.println("+==================================+");     
        
    }
    
    public void atualizarPaciente(){
        
        System.out.println("+----------------------------+");
        System.out.println("      ATUALIZAR PACIENTE      ");
        System.out.println("+----------------------------+");

        this.listarPacientes();
        
        System.out.println("Informe o ID do paciente a ser atualizado:");
        int id = Integer.parseInt(read.nextLine());
        Paciente paciente = colecaoPacientes.getPacienteById(id);

        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        System.out.println("Atualizar nome do paciente? (atual: " + paciente.getNome() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        if (read.nextLine().equals("0")) {
            System.out.println("Informe o novo nome:");
            paciente.setNome(read.nextLine());
        }

        System.out.println("Atualizar data de nascimento? (atual: " + paciente.getDataNascimento() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        if (read.nextLine().equals("0")) {
            System.out.println("Informe a nova data de nascimento (formato: DD/MM/YYYY):");
            String data = read.nextLine();
        
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3, 5));
            int ano = Integer.parseInt(data.substring(6, 10));    
            LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
            
            paciente.setDataNascimento(dataNascimento);
        }

        System.out.println("Atualizar telefone? (atual: " + paciente.getTelefone() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        if (read.nextLine().equals("0")) {
            System.out.println("Informe o novo telefone:");
            paciente.setTelefone(read.nextLine());
        }

        System.out.println("Atualizar e-mail? (atual: " + paciente.getEmail() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        if (read.nextLine().equals("0")) {
            System.out.println("Informe o novo e-mail:");
            paciente.setEmail(read.nextLine());
        }

        System.out.println("Atualizar endereço? (atual: " + paciente.getEndereco() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        if (read.nextLine().equals("0")) {
            System.out.println("Informe o novo endereço:");
            paciente.setEndereco(read.nextLine());
        }

        System.out.println("Atualizar tipo de convênio? (atual: " + paciente.getTipoConvenio() + ")");
        System.out.println("[0] - Para sim \n[1] - Para não");
        if (read.nextLine().equals("0")) {
            System.out.println("Informe o novo tipo de convênio (PARTICULAR ou PLANOSAUDE):");
            paciente.setTipoConvenio(Paciente.tipoConvenio.valueOf(read.nextLine().toUpperCase()));
        }


        System.out.println("+==================================+");
        System.out.println("  PACIENTE ATUALIZADO COM SUCESSO!  ");
        System.out.println("+==================================+"); 
        
    }
    
    public void removerPaciente(){
        
        this.listarPacientes();
        
        System.out.println("+----------------------------+");
        System.out.println("       REMOVER PACIENTE       ");
        System.out.println("+----------------------------+");

        System.out.println("Informe o ID do paciente a ser removido:");
        int id = Integer.parseInt(read.nextLine());
        Paciente paciente = colecaoPacientes.getPacienteById(id);

        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        colecaoPacientes.remove(paciente);
        
        System.out.println("+==================================+");
        System.out.println("   PACIENTE REMOVIDO COM SUCESSO!   ");
        System.out.println("+==================================+");   
    }
    
    public void listarPacientes(){
        
        System.out.println("\n");
        ArrayList<Paciente> pacientes = colecaoPacientes.getPacientes();
        
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        
        System.out.println("+----------------------------+");
        System.out.println("      LISTA DE PACIENTES      ");
        System.out.println("+----------------------------+");

        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId());
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Data de Nascimento: " + paciente.getDataNascimento());
            System.out.println("Telefone: " + paciente.getTelefone());
            System.out.println("E-mail: " + paciente.getEmail());
            System.out.println("Endereço: " + paciente.getEndereco());
            System.out.println("Tipo de Convênio: " + paciente.getTipoConvenio());
            System.out.println("------------------------------");
        }
        System.out.println("\n");
    }
    
    public void listarMedicos(){
        
        ArrayList<Medico> medicos = colecaoMedicos.getMedicos();
        System.out.println("\n");
        
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }
        
        System.out.println("+----------------------------+");
        System.out.println("       LISTA DE MÉDICOS       ");
        System.out.println("+----------------------------+");
        
        for (Medico medico : medicos) {
            
            if (medico.getSecretariaId() == secretaria.getId()) {
                System.out.println("ID: " + medico.getId());
                System.out.println("Nome: " + medico.getNome());
                System.out.println("Data de Nascimento: " + medico.getDataNascimento());
                System.out.println("Telefone: " + medico.getTelefone());
                System.out.println("Email: " + medico.getEmail());
                System.out.println("Especialidade: " + medico.getEspecialidade());
                System.out.println("CRM: " + medico.getCrm());
                System.out.println("ID da Secretaria: " + medico.getSecretariaId());
                System.out.println("------------------------------");
            }
        }
        System.out.println("\n");
    }
    
    public void gerarRelatorioConsultasDiaSeguinte() {
        System.out.println("+----------------------------------------+");
        System.out.println("  RELATÓRIO DE CONSULTAS DO DIA SEGUINTE  ");
        System.out.println("+----------------------------------------+");

        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);

        ArrayList<Consulta> consultas = colecaoConsultas.getConsultas();
        
        boolean temConsultas = false;

        for (Consulta consulta : consultas) {
            if (consulta.getData().equals(amanha) && 
                colecaoMedicos.getMedicoById(consulta.getMedicoId()).getSecretariaId() == secretaria.getId()) {
                temConsultas = true;
                System.out.println("ID: " + consulta.getId());
                System.out.println("Data: " + consulta.getData());
                System.out.println("Horário: " + consulta.getHorario());
                System.out.println("Médico: " + colecaoMedicos.getMedicoById(consulta.getMedicoId()).getNome());
                System.out.println("Paciente: " + colecaoPacientes.getPacienteById(consulta.getPacienteId()).getNome());
        System.out.println("+----------------------------------------+");
                
            }
        }

        if (!temConsultas) {
            System.out.println("Nenhuma consulta marcada para o dia seguinte.");
            }
    }

    
    public void enviarMensagensConsultasDiaSeguinte(){
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);
        
        ArrayList<Consulta> consultas = colecaoConsultas.getConsultas();
        ArrayList<Consulta> consultasNextDay = new ArrayList<Consulta>();
        
        
        for (Consulta consulta : consultas) {
            if (consulta.getData().equals(amanha) && 
                colecaoMedicos.getMedicoById(consulta.getMedicoId()).getSecretariaId() == secretaria.getId()) {
                consultasNextDay.add(consulta);
            }
        }
        
        
        if(consultasNextDay.isEmpty()){
            System.out.println("Nenhuma consulta marcada para o dia seguinte.");
        }
        else{
            for(Consulta consulta : consultasNextDay){
                Paciente paciente = colecaoPacientes.getPacienteById(consulta.getPacienteId());
                Medico medico = colecaoMedicos.getMedicoById(consulta.getMedicoId());
                System.out.println("+==============================================================================================================================+");
                System.out.println((paciente.getEmail().isEmpty()) ? "Mensagem de confirmação envida para telefone: " + paciente.getTelefone() : "Mensagem de confirmação envida para telefone: " + paciente.getTelefone() + " e email: " + paciente.getEmail() );
                System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
                System.out.println("Confirmação de Consulta Médica");
                System.out.println("Prezado(a)" + paciente.getNome() + ",");
                System.out.println("Existe uma consulta médica agendada para " + consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " em seu nome. Aqui estão os detalhes da sua consulta:");
                System.out.println("Data: " + consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Hora: " + consulta.getHorario());
                System.out.println("Médico: Dr(a). " + medico.getNome());
                System.out.println("Especialidade: " + medico.getEspecialidade());
                System.out.println("\nAgradecemos por escolher nossa clínica e estamos à disposição para qualquer dúvida.");
                System.out.println("Atenciosamente,");
                System.out.println(secretaria.getNome());
                
            }
        }
    }

    
    public void cadastroPacientesInterno(){
        String[] nomes = {
            "Ana Clara Silva", "Carlos Alberto Souza", "Mariana Lima", "João Pedro Rocha", 
            "Fernanda Gomes", "Rafael Oliveira", "Julia Carvalho", "Lucas Fernandes", 
            "Amanda Costa", "Felipe Santos", "Isabela Souza", "Ricardo Lima", 
            "Tatiana Rodrigues", "Thiago Barros", "Letícia Araujo", "Pedro Martins", 
            "Gabriela Nunes", "Marcos Vieira", "Patrícia Almeida", "Rodrigo Pereira"
        };

        LocalDate[] datasNascimento = {
            LocalDate.of(1990, 5, 12), LocalDate.of(1985, 8, 23), LocalDate.of(1992, 11, 5), 
            LocalDate.of(1978, 3, 15), LocalDate.of(2000, 6, 21), LocalDate.of(1989, 9, 30), 
            LocalDate.of(1995, 7, 18), LocalDate.of(1982, 10, 8), LocalDate.of(1994, 2, 25), 
            LocalDate.of(1987, 12, 12), LocalDate.of(1991, 1, 4), LocalDate.of(1979, 11, 28), 
            LocalDate.of(1983, 5, 17), LocalDate.of(1998, 8, 24), LocalDate.of(1986, 4, 11), 
            LocalDate.of(1993, 9, 1), LocalDate.of(1997, 12, 22), LocalDate.of(1981, 6, 6), 
            LocalDate.of(1984, 7, 14), LocalDate.of(1977, 3, 9)
        };

        String[] telefones = {
            "(11) 91234-5678", "(21) 98765-4321", "(31) 99876-5432", "(41) 96543-2109", 
            "(51) 91234-7890", "(61) 93456-7812", "(71) 91234-5678", "(81) 94321-6789", 
            "(91) 98765-4321", "(11) 95678-4321", "(21) 93456-7890", "(31) 98765-4321", 
            "(41) 93421-0987", "(51) 98765-4321", "(61) 91234-5678", "(71) 94567-8901", 
            "(81) 97654-3210", "(91) 93456-7890", "(11) 98765-4321", "(21) 97654-3210"
        };

        String[] emails = {
            "ana.clara@gmail.com", "carlos.alberto@outlook.com", "mariana.lima@yahoo.com", 
            "joao.pedro@live.com", "fernanda.gomes@gmail.com", "rafael.oliveira@gmail.com", 
            "julia.carvalho@gmail.com", "lucas.fernandes@hotmail.com", "amanda.costa@outlook.com", 
            "felipe.santos@gmail.com", "isabela.souza@gmail.com", "ricardo.lima@hotmail.com", 
            "tatiana.rodrigues@gmail.com", "thiago.barros@outlook.com", "leticia.araujo@gmail.com", 
            "pedro.martins@gmail.com", "gabriela.nunes@gmail.com", "marcos.vieira@gmail.com", 
            "patricia.almeida@hotmail.com", "rodrigo.pereira@gmail.com"
        };

        String[] enderecos = {
            "Rua das Flores, 123", "Avenida Brasil, 45", "Rua do Comércio, 89", "Rua das Oliveiras, 456", 
            "Avenida Central, 200", "Rua dos Pinheiros, 78", "Rua das Palmeiras, 15", "Avenida Atlântica, 789", 
            "Rua do Lago, 123", "Avenida Paulista, 300", "Rua das Acácias, 100", "Rua do Sol, 456", 
            "Rua das Américas, 678", "Rua do Mar, 234", "Avenida São João, 500", "Rua das Hortênsias, 789", 
            "Rua do Campo, 345", "Avenida Independência, 678", "Rua do Bosque, 123", "Avenida Presidente, 345"
        };

        String[] tiposConvenio = {
            "PARTICULAR","PLANOSAUDE","PLANOSAUDE","PARTICULAR", 
            "PLANOSAUDE", "PARTICULAR","PLANOSAUDE","PLANOSAUDE", 
            "PARTICULAR", "PLANOSAUDE","PARTICULAR","PLANOSAUDE", 
            "PARTICULAR", "PLANOSAUDE","PLANOSAUDE","PARTICULAR", 
            "PARTICULAR", "PLANOSAUDE","PARTICULAR","PLANOSAUDE"
        };
        
        for(int i = 0; i < nomes.length; i++){
            Paciente.tipoConvenio tipoConvenio = Paciente.tipoConvenio.valueOf(tiposConvenio[i]);
            
            Paciente paciente = new Paciente(tipoConvenio,nomes[i], datasNascimento[i], enderecos[i], telefones[i], emails[i]);
            
            
            this.idPacienteControle += 1;
            paciente.setId(idPacienteControle);
            colecaoPacientes.add(paciente);
        }   
    }    
    
    public static LocalTime gerarHorarioAleatorio(LocalTime inicio, LocalTime fim) {
        Random random = new Random();

        // Verifica se o intervalo é suficientemente grande
        Duration intervalo = Duration.between(inicio, fim);
        if (intervalo.toHours() < 1) {
            throw new IllegalArgumentException("O intervalo entre início e fim deve ser de pelo menos 1 hora.");
        }

        // Ajusta o horário final para garantir que o intervalo seja de pelo menos 1 hora
        LocalTime fimAjustado = fim.minusHours(1);

        // Converte os horários em segundos desde o início do dia
        long inicioEmSegundos = inicio.toSecondOfDay();
        long fimAjustadoEmSegundos = fimAjustado.toSecondOfDay();
        
        // Gera um valor aleatório entre o início e o fim ajustado
        long intervaloEmSegundos = fimAjustadoEmSegundos - inicioEmSegundos;
        if (intervaloEmSegundos <= 0) {
            throw new IllegalArgumentException("O intervalo entre início e fim ajustado deve ser positivo.");
        }
        
        long horarioAleatorioEmSegundos = inicioEmSegundos + random.nextLong() % intervaloEmSegundos;
        if (horarioAleatorioEmSegundos < 0) {
            horarioAleatorioEmSegundos += intervaloEmSegundos;
        }

        // Converte de volta para LocalTime
        return LocalTime.ofSecondOfDay(horarioAleatorioEmSegundos);
    }
    
    
    
    public void cadastroConsultasInterno(){
        //Esse método é somente para fins de teste, os código a seguir não seguem as definições do projeto
        //Esse método cadastra 20 consultas (os 20 pacientes devem ser criados previamente)
        //Serão cadastrados 10 consultas para 2 médicos com os respectivos id's 1 e 2
        //3 consultas serão para o dia atual
        //2 consultas serão para o dia seguinte
        //5 consultas serão para dois dias a frente
        
        
        LocalTime inicio = LocalTime.of(8, 0);  // 08:00
        LocalTime fim = LocalTime.of(18, 0);    // 18:00
        
        int idPaciente = 1;
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);
        LocalDate doisDias = hoje.plusDays(2);
        //LocalTime horaConsulta = LocalTime.of(13, 30);

        for(int i = 1; i < 3; i++){
            Medico medico = colecaoMedicos.getMedicoById(i);

            //3 consultas para o dia atual
            for(int j = 0; j < 3; j++){
                LocalTime horaConsulta = gerarHorarioAleatorio(inicio, fim);
                Paciente paciente = colecaoPacientes.getPacienteById(idPaciente);
                Consulta consulta = new Consulta(hoje, horaConsulta);
                this.idConsultaControle += 1;
                consulta.setId(idConsultaControle);
                consulta.setMedicoId(medico);
                consulta.setPacienteId(paciente);
                consulta.setTipo("NORMAL");
                consulta.setConsutaFinalizada(false);
                colecaoConsultas.add(consulta);
                idPaciente += 1;
            }
                
            //2 consultas para o dia seguinte
            for(int j = 0; j < 2; j++){
                LocalTime horaConsulta = gerarHorarioAleatorio(inicio, fim);
                Paciente paciente = colecaoPacientes.getPacienteById(idPaciente);
                Consulta consulta = new Consulta(amanha, horaConsulta);
                this.idConsultaControle += 1;
                consulta.setId(idConsultaControle);
                consulta.setMedicoId(medico);
                consulta.setPacienteId(paciente);
                consulta.setTipo("NORMAL");
                consulta.setConsutaFinalizada(false);
                colecaoConsultas.add(consulta);
                idPaciente += 1;
            }
                            
            //5 consultas para o dois dias a frente
            for(int j = 0; j < 5; j++){
                LocalTime horaConsulta = gerarHorarioAleatorio(inicio, fim);
                Paciente paciente = colecaoPacientes.getPacienteById(idPaciente);
                Consulta consulta = new Consulta(doisDias, horaConsulta);
                this.idConsultaControle += 1;
                consulta.setId(idConsultaControle);
                consulta.setMedicoId(medico);
                consulta.setPacienteId(paciente);
                consulta.setTipo("NORMAL");
                consulta.setConsutaFinalizada(false);
                colecaoConsultas.add(consulta);
                idPaciente += 1;
            }
        }
        
    }
}