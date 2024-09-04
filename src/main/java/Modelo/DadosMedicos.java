/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.util.List;
import javax.persistence.*;
/**
 *
 * @author MatheusConsoni
 */

@Entity
@Table(name = "dados_medico")
public class DadosMedicos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @Column(name = "fuma")
    private boolean fuma;
    
    @Column(name = "bebe")
    private boolean bebe;
    
    @Column(name = "nivel_colesterol")
    private String colesterol;
    
    @Column(name = "diabete")
    private boolean diabete;
    
    @Column(name = "doenca_cardiaca")
    private boolean doencaCardiaca;
    
    @Column(name = "peso")
    private float peso;
    
    @ElementCollection
    private List<String> cirurgias;
    
    @ElementCollection
    private List<String> alergias;

    //Construtor
    
    public DadosMedicos(){}

    public DadosMedicos(Paciente paciente,boolean fuma, boolean bebe, String colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias) {
        this.paciente = paciente;
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterol = colesterol;
        this.diabete = diabete;
        this.doencaCardiaca = doencaCardiaca;
        this.cirurgias = cirurgias;
        this.alergias = alergias;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public float getPeso(){
        return this.peso;
    }
    
    public void setPeso(float peso){
        this.peso = peso;
    }
    
    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public boolean isBebe() {
        return bebe;
    }

    public void setBebe(boolean bebe) {
        this.bebe = bebe;
    }

    public String getColesterol() {
        return colesterol;
    }

    public void setColesterol(String colesterol) {
        this.colesterol = colesterol;
    }

    public boolean isDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean isDoencaCardiaca() {
        return doencaCardiaca;
    }

    public void setDoencaCardiaca(boolean doencaCardiaca) {
        this.doencaCardiaca = doencaCardiaca;
    }

    public List<String> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(List<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }
    
    

}