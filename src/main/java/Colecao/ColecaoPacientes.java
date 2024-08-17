/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecao;

import Modelo.Paciente;
import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class ColecaoPacientes {
    private ArrayList<Paciente> pacientes = new ArrayList();
    
     public  ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
    public void add(Paciente paciente){
        pacientes.add(paciente);
    }
    
    public void remove(Paciente paciente){
        pacientes.remove(paciente);
    }
    
    public void removeById(int id){
        Paciente paciente = this.getPacienteById(id);
        if (paciente != null){
            this.remove(paciente);
        }
        
    }
    
    public Paciente getPacienteById(int id){
        for(Paciente paciente : pacientes){
            if(id == paciente.getId()){
                return paciente;
            }
        }
        
        return null;
    }
    
    public int size(){
        return pacientes.size();
    }
    
}
