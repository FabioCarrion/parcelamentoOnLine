package bethaCode.javaspringideaparcelamentoonLine.model;

import bethaCode.javaspringideaparcelamentoonLine.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Municipio extends AbstractRegion {
    @ManyToOne
    @JoinColumn(name = "I_ESTADOS", referencedColumnName = "ID")
    private Estado estado;

    @Size(max = 8)
    @Column(name= "CEP_GERAL")
    private String cepGeral;


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCepGeral() {
        return cepGeral;
    }

    public void setCepGeral(String cepGeral) {
        this.cepGeral = cepGeral;
    }
}