package com.persoonlijk.backendpersoonlijk.controllers;

import com.persoonlijk.backendpersoonlijk.DatabaseModels.TextMessageDTO;
import com.persoonlijk.backendpersoonlijk.services.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketTextController {

    @Autowired
    private WebSocketService webSocketService;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody TextMessageDTO textMessageDTO) {
        webSocketService.sendLogMessage("Server log: Sending message");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/sendMessage")
    public void receiveMessage(@Payload TextMessageDTO textMessageDTO) {
        webSocketService.sendLogMessage("Server log: Received message");
        // receive message from client
    }

    @SendTo("/topic/message")
    public TextMessageDTO broadcastMessage(@Payload TextMessageDTO textMessageDTO) {
        webSocketService.sendLogMessage("Server log: Broadcasting message");
        return textMessageDTO;
    }
}