package bethaCode.javaspringideaparcelamentoonLine.model;

public class Dividas  {
     private Long idDividas;
     private Long idPessoas;
     private String receita;
     private Float valor;
     private Integer ano ;
     private char situacao;

     public Dividas() {
          this.idDividas = idDividas;
          this.idPessoas = idPessoas;
          this.receita = receita;
          this.valor = valor;
          this.ano = ano;
          this.situacao = situacao;
     }

     public Long getIdDividas() {
          return idDividas;
     }

     public void setIdDividas(Long idDividas) {
          this.idDividas = idDividas;
     }

     public Long getIdPessoas() {
          return idPessoas;
     }

     public void setIdPessoas(Long idPessoas) {
          this.idPessoas = idPessoas;
     }

     public String getReceita() {
          return receita;
     }

     public void setReceita(String receita) {
          this.receita = receita;
     }

     public Float getValor() {
          return valor;
     }

     public void setValor(Float valor) {
          this.valor = valor;
     }

     public Integer getAno() {
          return ano;
     }

     public void setAno(Integer ano) {
          this.ano = ano;
     }

     public char getSituacao() {
          return situacao;
     }

     public void setSituacao(char situacao) {
          this.situacao = situacao;
     }
}
