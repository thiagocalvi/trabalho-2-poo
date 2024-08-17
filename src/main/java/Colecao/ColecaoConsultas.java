/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecao;

import Modelo.Consulta;
import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class ColecaoConsultas{
    private ArrayList<Consulta> consultas = new ArrayList();
    
    public ArrayList<Consulta> getConsultas(){
        return consultas;
    }
    
    public void add(Consulta consulta){
        consultas.add(consulta);
    }
    
    public void remove(Consulta consulta){
        consultas.remove(consulta);
    }
    
    public void removeById(int id){
        Consulta consulta = this.getConsultaById(id);
        if (consulta != null){
            this.remove(consulta);
        }
        
    }
    
    public Consulta getConsultaById(int id){
        for(Consulta consulta : consultas){
            if(id == consulta.getId()){
                return consulta;
            }
        }
        
        return null;
    }
    
    public int size(){
        return consultas.size();
    }
}
