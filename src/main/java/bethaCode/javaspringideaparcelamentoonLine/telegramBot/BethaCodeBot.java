package bethaCode.javaspringideaparcelamentoonLine.telegramBot;

import bethaCode.javaspringideaparcelamentoonLine.model.ControlaSolicitacao;
import bethaCode.javaspringideaparcelamentoonLine.model.Dividas;
import bethaCode.javaspringideaparcelamentoonLine.model.Solicitacao;
import bethaCode.javaspringideaparcelamentoonLine.repository.DividasRepository;
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
         String nomeContatoFull;
        String contato = update.getMessage().getFrom().getFirstName();
        if (update.getMessage().getFrom().getLastName() == null) {
            nomeContatoFull = contato + " " + update.getMessage().getFrom().getLastName();
        } else {
            nomeContatoFull = contato;
        }


        Long idContato = update.getMessage().getFrom().getId();
        String command = update.getMessage().getText();
        Integer idMessage = update.getUpdateId();

        String mensagemCpfCnpj = null;
        int etapa;
        String mensagemSituacao = "A";
        String aceitaParc = command;
        //Fim captura

        //Envia contato para classe que contém mensagens
        mensagem.contato = contato;
        //Fim

        //Temp para demonstrar quando não entrar no if do try abaixo
        message.setText(nomeContatoFull);

        try {
            Solicitacao solicitacao = SolicitacaoRepository.findById(idContato);


            if (solicitacao == null) {
                etapa = 0;
            } else {
                etapa = solicitacao.getEtapa();
            }

            if (etapa == 0) {
                String mensagem1 = mensagem.mensagemBotPasso1();
                message.setText(mensagem1);
                Solicitacao criaSolicitacao = new Solicitacao();
                criaSolicitacao.setIdContato(idContato);
                criaSolicitacao.setIdSolicitacao(idMessage);
                criaSolicitacao.setDataSolicitacao(null);
                criaSolicitacao.setEtapa(1);
                criaSolicitacao.setCpfCnpj(mensagemCpfCnpj);
                criaSolicitacao.setSituacao(mensagemSituacao);
                criaSolicitacao.setNome(nomeContatoFull);
                SolicitacaoRepository.create(criaSolicitacao);

            }

            if (etapa == 1) {

                if (command.length() <= 8 ) {
                    String mensagem6 = mensagem.mensagemBotPasso6();
                    message.setText(mensagem6);
                }else {
                    ValidaCpf validaCpf = new ValidaCpf();
                    validaCpf.cpfContato = command;
                    boolean valido = validaCpf.valido();
                    if (valido) {
                        String cpfCnpj = command.replace(".", "");
                        cpfCnpj = cpfCnpj.replace("-", "");
                        cpfCnpj = cpfCnpj.replace("/", "");
                        System.out.println("cpfCnpj " + cpfCnpj);
                        Dividas divida = DividasRepository.findBycpfcnpj(cpfCnpj);
                        if (divida == null) {
                            String mensagem7 = mensagem.mensagemBotPasso7();
                            message.setText(mensagem7);
                            Solicitacao deletaSolicitacao = new Solicitacao();
                            deletaSolicitacao.setIdContato(idContato);
                            SolicitacaoRepository.delete(deletaSolicitacao);

                        } else {
                            String mensagem2 = mensagem.mensagemBotPasso2();
                            message.setText(mensagem2);
                            Solicitacao atualizaSolicitacao = new Solicitacao();
                            atualizaSolicitacao.setIdSolicitacao(idMessage);
                            atualizaSolicitacao.setEtapa(2);
                            atualizaSolicitacao.setCpfCnpj(cpfCnpj);
                            atualizaSolicitacao.setIdContato(idContato);
                            SolicitacaoRepository.update(atualizaSolicitacao);
                        }
                    } else {
                        message.setText(mensagem.mensagemBotPasso6());
                    }
                }
            }

            if (etapa == 2) {
               aceitaParc = aceitaParc.toLowerCase().replaceAll("ã", "a");
               if (aceitaParc.equals("sim")) {
                    String mensagem3 = mensagem.mensagemBotPasso3();
                    message.setText(mensagem3);
                    Solicitacao atualizaSolicitacaoPasso3 = new Solicitacao();
                    atualizaSolicitacaoPasso3.setIdSolicitacao(idMessage);
                    atualizaSolicitacaoPasso3.setEtapa(3);
                    atualizaSolicitacaoPasso3.setIdContato(idContato);
                    SolicitacaoRepository.updatePasso3(atualizaSolicitacaoPasso3);
                } else if (aceitaParc.equals("nao")) {
                    String mensagem4 = mensagem.mensagemBotPasso4();
                    message.setText(mensagem4);
                    Solicitacao deletaSolicitacao = new Solicitacao();
                    deletaSolicitacao.setIdContato(idContato);
                    SolicitacaoRepository.delete(deletaSolicitacao);
                } else {
                    String mensagem5 = mensagem.mensagemBotPasso5();
                    message.setText(mensagem5);
                }
            }

            if (etapa == 3) {
                aceitaParc = aceitaParc.toLowerCase();
                if (aceitaParc.equals("sair")) {
                    String mensagem4 = mensagem.mensagemBotPasso4();
                    message.setText(mensagem4);
                    Solicitacao deletaSolicitacao = new Solicitacao();
                    deletaSolicitacao.setIdContato(idContato);
                    SolicitacaoRepository.delete(deletaSolicitacao);
                }
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("id = " + idContato);
        System.out.println("contato= " + contato);
        System.out.println("idMessage= " + idMessage);
        System.out.println("contatoFull = " + nomeContatoFull);


        if (command.equals("/meucpf")) {
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText("Olá " + update.getMessage().getFrom().getFirstName() + " Inicie informando seu cpf para a consulta");
        }

        message.setChatId(String.valueOf(update.getMessage().getChatId()));

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}


