package com.persoonlijk.backendpersoonlijk.websockets;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // This method will be called whenever a new WebSocket message arrives.
        String payload = message.getPayload(); // Get the text from the message
        System.out.println("Received message: " + payload);

        // You can also send a message to the client from here if needed.
        // session.sendMessage(new TextMessage("Message received!"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("Connection established");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("Connection closed. Status: " + status);
    }
}
