package bethaCode.javaspringideaparcelamentoonLine.model;

public class ControlaSolicitacao {
   public int passo;
   public String contato ;

   public String mensagemBotPasso1() {
         return ("Olá " + contato +"  seja, bem vindo ao parcelamento On-line , por favor digite seu cpf ou cnpj e aguarde enquanto consultamos seu dados");
}

    public String mensagemBotPasso2() {
        return (contato + " você possui um debito  IPTU, vamos parcelar ? temos otimas opções, digite 'Sim' para prosseguir" );
    }




}


