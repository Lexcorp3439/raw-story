package com.egorius.rawstory;

import org.apache.catalina.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.egorius.rawstory.bot.ServerBot;
import com.egorius.rawstory.config.AppConfig;

@SpringBootApplication
public class RawstoryApplication {

    private static final String PROXY_PORT = "1080";
    private static final String PROXY_ADDRESS = "178.197.248.213";

    public static void main(String[] args) {
        SpringApplication.run(new Class[] {RawstoryApplication.class, AppConfig.class}, args);

        System.getProperties().put( "proxySet", "true" );
        System.getProperties().put( "socksProxyHost", PROXY_ADDRESS );
        System.getProperties().put( "socksProxyPort", PROXY_PORT );


        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(ServerBot.serverBot);
            System.out.println("Есть контакт");

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

}
