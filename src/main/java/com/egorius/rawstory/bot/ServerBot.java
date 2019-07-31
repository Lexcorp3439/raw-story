package com.egorius.rawstory.bot;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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
    private static final String BOT_TOKEN = "876212460:AAFXA1t7epiicYunoWbnZnbvxwMaNhX4PCg";
    private static final String RAW_BOT_TOKEN = "876212460:AAFXA1t7epiicYunoWbnZnbvxwMaNhX4PCg";
    private static String TOKEN;
    private static final String TAG = "HandBot message";

    public static ServerBot serverBot = new ServerBot();

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message.hasText()) {
            if (message.getText().equals("/help")) {
                sendMsg(message, "Hi, ma name is ".concat(BOT_NAME));
            } else {
                sendMsg(message, "Hello World");
            }
        }
    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
//        sendMessage.setReplyToMessageId(message.getMessageId()); // для пеересылки сообщения
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            BotLogger.error("Could not send message", TAG, e);
        }
    }

    private String resource = this.getClass().getResource("/static").getPath();

    public String downloadImg(String id) {
        try {
            TOKEN = RAW_BOT_TOKEN;
            File file = execute(new GetFile().setFileId(id));
            System.out.println(file.getFileUrl(getBotToken()));
            java.io.File fileI = downloadFile(file);
            TOKEN = BOT_TOKEN;
            java.io.File f = new java.io.File(resource.concat("/" + id + ".img"));
            if (fileI.renameTo(f)) {
                System.out.println("Файл успешно перемещён!");
                return f.getPath();
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("Файл неудалось переместить.");
        return null;
    }

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}