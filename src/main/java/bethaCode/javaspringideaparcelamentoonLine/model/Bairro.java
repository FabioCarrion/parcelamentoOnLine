package bethaCode.javaspringideaparcelamentoonLine.model;

import bethaCode.javaspringideaparcelamentoonLine.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Bairro extends AbstractRegion {
    @ManyToOne
    @JoinColumn(name = "I_DISTRITO", referencedColumnName = "ID")
    private Distrito distrito;

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}