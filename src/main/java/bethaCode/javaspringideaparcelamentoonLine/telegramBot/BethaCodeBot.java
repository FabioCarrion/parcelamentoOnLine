package bethaCode.javaspringideaparcelamentoonLine.telegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
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
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());
        String contato = update.getMessage().getFrom().getFirstName();
        Long idContato = update.getMessage().getFrom().getId();
        Boolean grupoMsg =  update.getMessage().getFrom().getCanReadAllGroupMessages();
        SendMessage message = new SendMessage() ;
        String command=update.getMessage().getText();

      int verificaCpfCnpj = command.length();
      Boolean controlaSolicitacao = false ;
      String verificaLancamento;

        System.out.println("id = " + idContato);
        System.out.println("id = " + grupoMsg);

      if (verificaCpfCnpj == 11) {
          message.setText("Que otimo "+ contato + " você digitou um cpf valido, vou checar seus debitos.. aguarde" );
          message.setText(contato + " você possui um debito  IPTU, vamos parcelar ? temos otimas opções, digite 'Sim' para prosseguir" );
          controlaSolicitacao = true;
        }

      if(controlaSolicitacao == false) {
          message.setText("Olá " + contato + " bem vindo ao parcelamento On-line , por favor digite seu cpf ou cnpj e aguarde enquanto consultamos seu dados");
      }

      if (command.equals("/meucpf")){
          System.out.println(update.getMessage().getFrom().getFirstName());
          message.setText("Olá " + update.getMessage().getFrom().getFirstName() + " Inicie informando seu cpf para a consulta");
      }

        System.out.println("controlaSolicitacao = "  + controlaSolicitacao + "  command " + command);

      if (command.equals("Sim") && controlaSolicitacao == true){
            message.setText(contato + " você possui um debito de R$ 1200,00 de IPTU,  posso parcelar em.....");
        }



       message.setChatId(String.valueOf(update.getMessage().getChatId()));

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}


