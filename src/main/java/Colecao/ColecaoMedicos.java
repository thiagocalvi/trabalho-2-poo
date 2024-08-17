/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecao;

import Modelo.Medico;
import java.util.ArrayList;
/**
 *
 * @author thiago
 */
public class ColecaoMedicos {
    
    private ArrayList<Medico> medicos = new ArrayList();  

      
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }
    
    public void add(Medico medico){
        medicos.add(medico);
    }
    
    public void remove(Medico medico){
        medicos.remove(medico);
    }
    
  
    public void removeById(int id){
        Medico medico = this.getMedicoById(id);
        if (medico != null){
            this.remove(medico);
        }
        
    }
    
    public Medico getMedicoById(int id){
        for(Medico medico : medicos){
            if(id == medico.getId()){
                return medico;
            }
        }
        
        return null;
    }
    
    public int size(){
        return medicos.size();
    }


}
