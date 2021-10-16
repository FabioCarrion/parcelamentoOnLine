package bethaCode.javaspringideaparcelamentoonLine.model;

import bethaCode.javaspringideaparcelamentoonLine.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Estado extends AbstractRegion {

    @ManyToOne
    @JoinColumn(name = "I_PAISES", referencedColumnName = "ID")
    private Pais IdPaises;

    @Size(max = 2)
    @Column(name= "SIGLA")
    private String sigla;

    public Pais getIdPaises() {
        return IdPaises;
    }

    public void setIdPaises(Pais idPaises) {
        this.IdPaises = idPaises;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}