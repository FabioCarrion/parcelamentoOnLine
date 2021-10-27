package bethaCode.javaspringideaparcelamentoonLine.model;

import java.sql.Timestamp;

public class Solicitacao {

    private Integer idSolicitacao;
    private Long idContato;
    private int etapa;
    private String situacao; /* A- Aberta P- Pendente C-Concluida*/
    private String cpfCnpj;
    private String nome;
    private Timestamp dataSolicitacao ;

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

    public Timestamp getDataSolicitacao() {

          return dataSolicitacao;
    }

    public void setDataSolicitacao(Timestamp dataSolicitacao) {

          this.dataSolicitacao = dataSolicitacao;
    }
}


