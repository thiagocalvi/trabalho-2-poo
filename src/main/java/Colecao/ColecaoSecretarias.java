/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecao;

import Modelo.Secretaria;
import java.util.ArrayList;
/**
 *
 * @author thiago
 */
public class ColecaoSecretarias {
    private ArrayList<Secretaria> secretarias = new ArrayList();

    public  ArrayList<Secretaria> getSecretarias() {
        return secretarias;
    }
    
    public void add(Secretaria secretaria){
        secretarias.add(secretaria);
    }
    
    public void remove(Secretaria secretaria){
        secretarias.remove(secretaria);
    }
    
    public void removeById(int id){
        Secretaria secretaria = this.getSecretariaById(id);
        if (secretaria != null){
            this.remove(secretaria);
        }
        
    }
    
    public Secretaria getSecretariaById(int id){
        for(Secretaria secretaria : secretarias){
            if(id == secretaria.getId()){
                return secretaria;
            }
        }
        
        return null;
    }
    
    public int size(){
        return secretarias.size();
    }
}