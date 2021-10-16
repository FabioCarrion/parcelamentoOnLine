package bethaCode.javaspringideaparcelamentoonLine.model;

import bethaCode.javaspringideaparcelamentoonLine.enterprise.AbstractRegion;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Logradouro extends AbstractRegion {
    @ManyToOne
    @JoinColumn(name = "I_BAIRRO", referencedColumnName = "ID")
    private Bairro bairro;

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
}