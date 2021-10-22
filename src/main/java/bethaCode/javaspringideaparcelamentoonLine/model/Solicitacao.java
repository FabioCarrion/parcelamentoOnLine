package bethaCode.javaspringideaparcelamentoonLine.model;

import java.sql.Date;

public class Solicitacao  {

    private Integer idSolicitacao ;
    private Long idContato ;
    private int etapa ;
    private String situacao; /* A- Aberta P- Pendente C-Concluida*/
    private String cpfCnpj ;
    private Date dataSolicitacao ;
    private String nome ;


  /*  public Solicitacao(Long idSolicitacao, Long idContato, int etapa, char situacao, String cpfCnpj, Date dataSolicitacao) {
        this.idSolicitacao = idSolicitacao;
        this.idContato = idContato;
        this.etapa = etapa;
        this.situacao = situacao;
        this.cpfCnpj = cpfCnpj;
        this.dataSolicitacao = dataSolicitacao;
    }*/

    public Integer getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Integer idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public String getSituacao() {
        return this.situacao;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}


