package bethaCode.javaspringideaparcelamentoonLine.enterprise;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class AbstractSolicitacao extends AbstractEntity{

    @Column(name="idSolicitacao")
    private Long idsolicitacao;

    @Column(name="idContato")
    private Long idcontato;

    @Column(name="etapa")
    private int etapa;

    @Column(name="situacao")
    private char situacao;

    @Column(name="cpfCnpj")
    private char cpfcnpj;

    public Long getIdsolicitacao() {
        return idsolicitacao;
    }

    public void setIdsolicitacao(Long idsolicitacao) {
        this.idsolicitacao = idsolicitacao;
    }

    public Long getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(Long idcontato) {
        this.idcontato = idcontato;
    }

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public char getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(char cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

}
