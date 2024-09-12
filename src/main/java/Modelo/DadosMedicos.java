/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import javax.persistence.*;

/**
 * A classe {@code DadosMedicos} representa os dados médicos de um paciente. 
 * Ela contém informações relevantes 
 * para o acompanhamento médico, como histórico de cirurgias, alergias, hábitos 
 * como fumar e beber, além de condições de saúde específicas.
 * <p>
 * Esta classe é uma entidade JPA mapeada para a tabela "dados_medico" no banco de dados.
 * </p>
 * 
 * <p>Os dados médicos estão relacionados a um {@link Paciente} e incluem várias 
 * características importantes para o monitoramento da saúde do paciente.</p>
 * 
 * @author MatheusConsoni
 */
@Entity
@Table(name = "dados_medico")
public class DadosMedicos {

    /**
     * Identificador único dos dados médicos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Paciente ao qual estes dados médicos estão associados.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    /**
     * Indica se o paciente fuma.
     */
    @Column(name = "fuma")
    private boolean fuma;

    /**
     * Indica se o paciente bebe álcool.
     */
    @Column(name = "bebe")
    private boolean bebe;

    /**
     * Nível de colesterol do paciente.
     */
    @Column(name = "nivel_colesterol")
    private String colesterol;

    /**
     * Indica se o paciente é diabético.
     */
    @Column(name = "diabete")
    private boolean diabete;

    /**
     * Indica se o paciente tem alguma doença cardíaca.
     */
    @Column(name = "doenca_cardiaca")
    private boolean doencaCardiaca;

    /**
     * Peso do paciente em quilogramas.
     */
    @Column(name = "peso")
    private float peso;

    /**
     * Lista de cirurgias que o paciente já realizou.
     */
    @ElementCollection
    private List<String> cirurgias;

    /**
     * Lista de alergias que o paciente possui.
     */
    @ElementCollection
    private List<String> alergias;

    /**
     * Construtor padrão da classe {@code DadosMedicos}.
     */
    public DadosMedicos() {}

    /**
     * Construtor da classe {@code DadosMedicos} que inicializa os dados médicos 
     * com base nos parâmetros fornecidos.
     * 
     * @param paciente O paciente ao qual os dados médicos pertencem.
     * @param fuma Indica se o paciente fuma.
     * @param bebe Indica se o paciente bebe.
     * @param colesterol Nível de colesterol do paciente.
     * @param diabete Indica se o paciente é diabético.
     * @param doencaCardiaca Indica se o paciente tem doença cardíaca.
     * @param cirurgias Lista de cirurgias que o paciente já realizou.
     * @param alergias Lista de alergias que o paciente possui.
     */
    public DadosMedicos(Paciente paciente, boolean fuma, boolean bebe, String colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias) {
        this.paciente = paciente;
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterol = colesterol;
        this.diabete = diabete;
        this.doencaCardiaca = doencaCardiaca;
        this.cirurgias = cirurgias;
        this.alergias = alergias;
    }

    /**
     * Retorna o identificador único dos dados médicos.
     * 
     * @return O identificador dos dados médicos.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Retorna o peso do paciente em quilogramas.
     * 
     * @return O peso do paciente.
     */
    public float getPeso() {
        return this.peso;
    }
    
    /**
     * Define o peso do paciente em quilogramas.
     * 
     * @param peso O peso do paciente.
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    /**
     * Retorna se o paciente fuma.
     * 
     * @return {@code true} se o paciente fuma, caso contrário {@code false}.
     */
    public boolean isFuma() {
        return fuma;
    }

    /**
     * Define se o paciente fuma.
     * 
     * @param fuma {@code true} se o paciente fuma, caso contrário {@code false}.
     */
    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    /**
     * Retorna se o paciente bebe álcool.
     * 
     * @return {@code true} se o paciente bebe, caso contrário {@code false}.
     */
    public boolean isBebe() {
        return bebe;
    }

    /**
     * Define se o paciente bebe álcool.
     * 
     * @param bebe {@code true} se o paciente bebe, caso contrário {@code false}.
     */
    public void setBebe(boolean bebe) {
        this.bebe = bebe;
    }

    /**
     * Retorna o nível de colesterol do paciente.
     * 
     * @return O nível de colesterol do paciente.
     */
    public String getColesterol() {
        return colesterol;
    }

    /**
     * Define o nível de colesterol do paciente.
     * 
     * @param colesterol O nível de colesterol do paciente.
     */
    public void setColesterol(String colesterol) {
        this.colesterol = colesterol;
    }

    /**
     * Retorna se o paciente é diabético.
     * 
     * @return {@code true} se o paciente é diabético, caso contrário {@code false}.
     */
    public boolean isDiabete() {
        return diabete;
    }

    /**
     * Define se o paciente é diabético.
     * 
     * @param diabete {@code true} se o paciente é diabético, caso contrário {@code false}.
     */
    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    /**
     * Retorna se o paciente tem doença cardíaca.
     * 
     * @return {@code true} se o paciente tem doença cardíaca, caso contrário {@code false}.
     */
    public boolean isDoencaCardiaca() {
        return doencaCardiaca;
    }

    /**
     * Define se o paciente tem doença cardíaca.
     * 
     * @param doencaCardiaca {@code true} se o paciente tem doença cardíaca, caso contrário {@code false}.
     */
    public void setDoencaCardiaca(boolean doencaCardiaca) {
        this.doencaCardiaca = doencaCardiaca;
    }

    /**
     * Retorna a lista de cirurgias que o paciente já realizou.
     * 
     * @return Uma lista de cirurgias realizadas pelo paciente.
     */
    public List<String> getCirurgias() {
        return cirurgias;
    }

    /**
     * Define a lista de cirurgias que o paciente já realizou.
     * 
     * @param cirurgias Uma lista de cirurgias realizadas pelo paciente.
     */
    public void setCirurgias(List<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    /**
     * Retorna a lista de alergias que o paciente possui.
     * 
     * @return Uma lista de alergias que o paciente possui.
     */
    public List<String> getAlergias() {
        return alergias;
    }

    /**
     * Define a lista de alergias que o paciente possui.
     * 
     * @param alergias Uma lista de alergias que o paciente possui.
     */
    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }
}
