package bethaCode.javaspringideaparcelamentoonLine.telegramBot;

import bethaCode.javaspringideaparcelamentoonLine.model.ControlaSolicitacao;
import bethaCode.javaspringideaparcelamentoonLine.model.Solicitacao;
import bethaCode.javaspringideaparcelamentoonLine.repository.SolicitacaoRepository;
import bethaCode.javaspringideaparcelamentoonLine.util.ValidaCpf;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;

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
        // Metodo do telegram para mensagens
        SendMessage message = new SendMessage();
        //Fim

        //Instancia a classe que contém mensagens
        ControlaSolicitacao mensagem;
        mensagem = new ControlaSolicitacao();
        //Fim

        // Captura  dados da mensagem e atribui a variavel
        String contato = update.getMessage().getFrom().getFirstName();
        String nomeContatoFull = contato + " " + update.getMessage().getFrom().getLastName();
        Long idContato = update.getMessage().getFrom().getId();
        String command = update.getMessage().getText();
        Integer idMessage = update.getUpdateId();
       // Date dataSolicitacao = new Date() ;
        String mensagemCpfCnpj = null ;
        int etapa = 1;
        String mensagemSituacao = "A" ;
        //Fim captura



        //Envia contato para classe que contém mensagens
          mensagem.contato = contato;
        //Fim

        //Temp para demonstrar quando não entrar no if do try abaixo
        message.setText(nomeContatoFull);

        try {
            Solicitacao solicitacao = SolicitacaoRepository.findById(idContato);
            // System.out.println(solicitacao.getEtapa());
            System.out.println("o que o banco retorna : " + solicitacao);
            if (solicitacao == null) {
                String mensagem1 = mensagem.mensagemBotPasso1();
                message.setText(mensagem1);
                Solicitacao criaSolicitacao = new Solicitacao();
                criaSolicitacao.setIdContato(idContato);
                criaSolicitacao.setIdSolicitacao(idMessage);
                criaSolicitacao.setDataSolicitacao(null);
                criaSolicitacao.setEtapa(etapa);
                criaSolicitacao.setCpfCnpj(mensagemCpfCnpj);
                criaSolicitacao.setSituacao(mensagemSituacao);
                criaSolicitacao.setNome(nomeContatoFull);
                SolicitacaoRepository.create(criaSolicitacao);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        int verificaCpfCnpj = command.length();
        Boolean controlaSolicitacao = false;

        ValidaCpf validaCpf;
        validaCpf = new ValidaCpf();

        if (verificaCpfCnpj == 11 || verificaCpfCnpj == 14) {
            validaCpf.cpfContato = command;
        }


        System.out.println("id = " + idContato);
        System.out.println("contato= " + contato);
        System.out.println("idMessage= " + idMessage);
        System.out.println("contatoFull = " + nomeContatoFull);


        if (command.equals("/meucpf")) {
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText("Olá " + update.getMessage().getFrom().getFirstName() + " Inicie informando seu cpf para a consulta");
        }

        System.out.println("controlaSolicitacao = " + controlaSolicitacao + "  command " + command);

        message.setChatId(String.valueOf(update.getMessage().getChatId()));

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}


