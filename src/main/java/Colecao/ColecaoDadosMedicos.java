/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecao;

import Modelo.DadosMedicos;
import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class ColecaoDadosMedicos{
    private ArrayList<DadosMedicos> dadosMedicos = new ArrayList();
    
    public ArrayList<DadosMedicos> getDadosMedicos(){
        return dadosMedicos;
    }
    
    public void add(DadosMedicos dadosMedico){
        dadosMedicos.add(dadosMedico);
    }
    
    public void remove(DadosMedicos dadosMedico){
        dadosMedicos.remove(dadosMedico);
    }
    
    public void removeById(int id){
        DadosMedicos dadosMedico = this.getDadosMedicosById(id);
        if (dadosMedico != null){
            this.remove(dadosMedico);
        }
        
    }
    
    public DadosMedicos getDadosMedicosById(int id){
        for(DadosMedicos dadosMedico : dadosMedicos){
            if(id == dadosMedico.getId()){
                return dadosMedico;
            }
        }
        
        return null;
    }

    public int size(){
        return dadosMedicos.size();
    }
}
