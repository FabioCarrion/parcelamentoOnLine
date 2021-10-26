package bethaCode.javaspringideaparcelamentoonLine.model;

public class ControlaSolicitacao {
   public int passo;
   public String contato ;

   public String mensagemBotPasso1() {
         return ("Olá " + contato +"  seja, bem vindo ao parcelamento On-line , por favor digite seu cpf ou cnpj e aguarde enquanto consultamos seu dados");
}

    public String mensagemBotPasso2() {
        return (contato + " você possui um debito  IPTU, vamos parcelar ? temos otimas opções, digite 'Sim' para prosseguir, ou Não para sair" );
    }

    public String mensagemBotPasso3() {
        return (contato + " ,digite '1' para 1x 300, '2' para 2x 150, '3' para 3x de 100 ou 'Sair' para não aceitar o parcelamento " );
    }

    public String mensagemBotPasso4() {
        return (contato + " ,que pena, caso mude de opinião entre em contato " );
    }

    public String mensagemBotPasso5() {
        return ("Não entendi !!! ainda estou aprendendo  " + contato + ", digite Sim ou Não  !" );
    }

    public String mensagemBotPasso6() {
        return ("Opss !!! " + contato + " você digitou um cpf inválido tente novamente !");
    }



}


