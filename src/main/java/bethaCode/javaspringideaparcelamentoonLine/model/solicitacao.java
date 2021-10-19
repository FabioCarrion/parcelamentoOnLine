package bethaCode.javaspringideaparcelamentoonLine.model;

import java.util.Date;

public class solicitacao  {

    private Long idSolicitacao ;
    private Long idContato ;
    private int etapa ;
    private char situacao; /* A- Aberta P- Pendente C-Concluida*/
    private String cpfCnpj ;
    private Date dataSolicitacao ;
    private String nome ;

    public void cliente() {

    }

    public solicitacao(Long idSolicitacao, Long idContato, int etapa, char situacao, String cpfCnpj, Date dataSolicitacao) {
        this.idSolicitacao = idSolicitacao;
        this.idContato = idContato;
        this.etapa = etapa;
        this.situacao = situacao;
        this.cpfCnpj = cpfCnpj;
        this.dataSolicitacao = dataSolicitacao;
    }

    public Long getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(Long idSolicitacao) {
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

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
