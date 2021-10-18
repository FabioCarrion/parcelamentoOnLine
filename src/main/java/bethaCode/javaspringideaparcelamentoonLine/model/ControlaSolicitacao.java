package bethaCode.javaspringideaparcelamentoonLine.model;

public class ControlaSolicitacao {
   public int passo;
   public String contato ;

   public String mensagemBotPasso1() {
         return ("Olá " + contato +"  seja, bem vindo ao parcelamento On-line , por favor digite seu cpf ou cnpj e aguarde enquanto consultamos seu dados");
}
}
