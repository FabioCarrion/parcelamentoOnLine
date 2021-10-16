package bethaCode.javaspringideaparcelamentoonLine.model;

import bethaCode.javaspringideaparcelamentoonLine.enterprise.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pessoa extends AbstractEntity {
    @Column(name= "TIPO_PESSOA")
    private TipoPessoa tipoPessoa;

    @NotNull(message = "O nome não pode ser nulo!")
    @Size(max = 155)
    @Column(name= "NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "I_LOGRADOURO", referencedColumnName = "ID")
    private Logradouro logradouro;

    @ManyToOne
    @JoinColumn(name = "I_BAIRRO", referencedColumnName = "ID")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "I_LOTEAMENTO", referencedColumnName = "ID")
    private Loteamento loteamento;

    @ManyToOne
    @JoinColumn(name = "I_DISTRITO", referencedColumnName = "ID")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "I_CEP", referencedColumnName = "ID")
    private Cep cep;

    @Size(max = 4)
    @Column(name= "BLOCO")
    private String bloco;

    @Size(max = 4)
    @Column(name= "APTO")
    private String apto;

    @Size(max = 200)
    @Column(name= "COMPLEMENTO")
    private String complemento;

    @Size(max = 4)
    @Column(name= "NUMERO")
    private Double numero;

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Loteamento getLoteamento() {
        return loteamento;
    }

    public void setLoteamento(Loteamento loteamento) {
        this.loteamento = loteamento;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
