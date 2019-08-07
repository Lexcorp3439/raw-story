package com.egorius.rawstory.controllers;

import com.egorius.rawstory.bot.ServerBot;
import org.glassfish.grizzly.http.HttpHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class TelegramBotController {

    @PutMapping("/{id}")
    public ResponseEntity<String> setChatId(@PathVariable String id) {
        try {
            ServerBot.serverBot.addChatId(Long.parseLong(id));
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("error: L", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
