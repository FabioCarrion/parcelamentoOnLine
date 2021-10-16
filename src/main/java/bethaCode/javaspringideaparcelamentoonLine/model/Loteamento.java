package bethaCode.javaspringideaparcelamentoonLine.model;

import bethaCode.javaspringideaparcelamentoonLine.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loteamento extends AbstractRegion {
    @ManyToOne
    @JoinColumn(name = "I_BAIRRO", referencedColumnName = "ID")
    private Bairro bairro;

    @Column(name= "AREA_COMUM")
    private Double areaComum;

    @Column(name= "AREA_TOT")
    private Double areaTotal;

    @Column(name= "AREA_REM")
    private Double areaRemanescente;


    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Double getAreaComum() {
        return areaComum;
    }

    public void setAreaComum(Double areaComum) {
        this.areaComum = areaComum;
    }

    public Double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(Double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public Double getAreaRemanescente() {
        return areaRemanescente;
    }

    public void setAreaRemanescente(Double areaRemanescente) {
        this.areaRemanescente = areaRemanescente;
    }

}