package com.persoonlijk.backendpersoonlijk.services;

import com.persoonlijk.backendpersoonlijk.DatabaseModels.TextMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendLogMessage(String logMessage) {
        TextMessageDTO logDTO = new TextMessageDTO();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        logDTO.setTime(timeStamp);
        logDTO.addLog(logMessage);
        template.convertAndSend("/topic/message", logDTO);
    }
}
