package bethaCode.javaspringideaparcelamentoonLine.telegramBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MainClassTelegram {
    public static void main(String[]args){
      try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
             botsApi.registerBot(new BethaCodeBot());
          //System.out.println(botsApi.registerBot(new BethaCodeBot()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
}
