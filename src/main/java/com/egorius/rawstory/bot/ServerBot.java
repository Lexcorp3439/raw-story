package com.egorius.rawstory.bot;

import java.util.*;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.logging.BotLogger;

public class ServerBot extends TelegramLongPollingBot {
    private static final String BOT_NAME = "Raw Server Bot";
    private static final String BOT_USERNAME = "raw_server_bot";
    private static final String BOT_TOKEN = "955749705:AAEcVXkLTjiiiNrmDynyPsMyUGtin8B9Igw";
    private static final String RAW_BOT_TOKEN = "876212460:AAFXA1t7epiicYunoWbnZnbvxwMaNhX4PCg";
    private static String TOKEN = BOT_TOKEN;
    private static final String TAG = "HandBot message";

    public static final ServerBot serverBot = new ServerBot();

    private Set<Long> chatIds = new HashSet<>();

    public void addChatId(long id) {
        chatIds.add(id);
    }

    public void sendMsg(String text) {
        TOKEN = RAW_BOT_TOKEN;
        for (Long id: chatIds) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(id);
            sendMessage.setText(text);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                BotLogger.error("Could not send message", TAG, e);
            }
        }
        TOKEN = BOT_TOKEN;
    }

    public String downloadImg(String id) {
        try {
            String resource = "L:\\IdeaProjects\\raw-story\\src\\main\\resources\\static";
            TOKEN = RAW_BOT_TOKEN;
            File file = execute(new GetFile().setFileId(id));
            System.out.println(file.getFileUrl(getBotToken()));
            java.io.File fileI = downloadFile(file);
            TOKEN = BOT_TOKEN;
            String filePath = resource.concat("/" + id + ".jpg");
            java.io.File f = new java.io.File(filePath);
            if (fileI.renameTo(f)) {
                System.out.println("Файл успешно перемещён!");
                return filePath;
            } else {
                if (fileI.delete()){
                    System.out.println("Файл был успешно удален");
                    return filePath;
                } else {
                    System.out.println("Файл НЕ УДАЛЕН");
                }
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}
