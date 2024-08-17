/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecao;

import Modelo.Prontuario;
import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class ColecaoProntuarios {
    private ArrayList<Prontuario> prontuarios = new ArrayList();
    
    public ArrayList<Prontuario> getProntuarios() {
        return prontuarios;
    }
    
    public void add(Prontuario prontuario){
        prontuarios.add(prontuario);
    }
    
    public void remove(Prontuario prontuario){
        prontuarios.remove(prontuario);
    }
    
  
    public void removeById(int id){
        Prontuario prontuario = this.getProntuarioById(id);
        if (prontuario != null){
            this.remove(prontuario);
        }
        
    }
    
    public Prontuario getProntuarioById(int id){
        for(Prontuario prontuario : prontuarios){
            if(id == prontuario.getId()){
                return prontuario;
            }
        }
        
        return null;
    }
    
    public int size(){
        return prontuarios.size();
    }

}
