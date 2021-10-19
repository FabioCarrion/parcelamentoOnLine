package bethaCode.javaspringideaparcelamentoonLine.telegramBot;

import bethaCode.javaspringideaparcelamentoonLine.model.ControlaSolicitacao;
import bethaCode.javaspringideaparcelamentoonLine.util.ValidaCpf;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BethaCodeBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "parcCode_bot";
    }

    @Override
    public String getBotToken() {
        return "1954985173:AAEjS4uCAQnBzgJOA4qsreOllCg5WZzB9JA";
    }

   @Override
    public void onUpdateReceived(Update update) {

       ControlaSolicitacao mensagem ;
       mensagem = new ControlaSolicitacao();
       mensagem.passo = 1 ;


        String contato = update.getMessage().getFrom().getFirstName();
        String contatoFull = update.getMessage().getFrom().getLastName();
        mensagem.contato = contato ;
        Long idContato = update.getMessage().getFrom().getId();
        String command=update.getMessage().getText();
        Integer idMessage =  update.getUpdateId() ;

      //  String teste =  update.toString(); retorna os dados da mensagem
       //  System.out.println("teste= " + teste);
       SendMessage message = new SendMessage() ;


      int verificaCpfCnpj = command.length();
      Boolean controlaSolicitacao = false ;

       ValidaCpf validaCpf;
       validaCpf = new ValidaCpf();

       if (verificaCpfCnpj == 11 || verificaCpfCnpj == 14 ) {
            validaCpf.cpfContato = command;
       }


        System.out.println("id = " + idContato);
        System.out.println("contato= " + contato);
        System.out.println("idMessage= " + idMessage);
       System.out.println("contatoFull = " + contatoFull);



     /*  if (verificaCpfCnpj == 11 || verificaCpfCnpj == 14 ) {
          message.setText("Que otimo "+ contato + ", vou checar seus debitos.. aguarde" );
          message.setChatId(String.valueOf(update.getMessage().getChatId()));
          message.setText(contato + " você possui um debito  IPTU, vamos parcelar ? temos otimas opções, digite 'Sim' para prosseguir" );
          message.setChatId(String.valueOf(update.getMessage().getChatId()));
          controlaSolicitacao = true;
        } */

   /*    if (validaCpf.valido()  == true ) {
           String mensagem1 = mensagem.mensagemBotPasso2();
           message.setText(mensagem1);
       }*/


       if(controlaSolicitacao == false) {
          String mensagem1 = mensagem.mensagemBotPasso1();
          message.setText(mensagem1);
      }

      if (command.equals("/meucpf")){
          System.out.println(update.getMessage().getFrom().getFirstName());
          message.setText("Olá " + update.getMessage().getFrom().getFirstName() + " Inicie informando seu cpf para a consulta");
      }

        System.out.println("controlaSolicitacao = "  + controlaSolicitacao + "  command " + command);

    /*  if (command.equals("Sim") && controlaSolicitacao == true){
            message.setText(contato + " você possui um debito de R$ 1200,00 de IPTU,  posso parcelar em.....");
        }*/


     //  System.out.println(update.getMessage().getChatId());
       message.setChatId(String.valueOf(update.getMessage().getChatId()));

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}


