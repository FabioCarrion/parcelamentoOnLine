package bethaCode.javaspringideaparcelamentoonLine.model;

import bethaCode.javaspringideaparcelamentoonLine.enterprise.AbstractEntity;
import bethaCode.javaspringideaparcelamentoonLine.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Cep extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "I_LOGRADOURO", referencedColumnName = "ID")
    private Logradouro logradouro;

    @Column(name= "CEP")
    private Long cep;

    @Size(max = 4)
    @Column(name= "NUM_INICIAL")
    private Double numInicial;

    @Size(max = 4)
    @Column(name= "NUM_FINAL")
    private Double numFinal;

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Double getNumInicial() {
        return numInicial;
    }

    public void setNumInicial(Double numInicial) {
        this.numInicial = numInicial;
    }

    public Double getNumFinal() {
        return numFinal;
    }

    public void setNumFinal(Double numFinal) {
        this.numFinal = numFinal;
    }

}