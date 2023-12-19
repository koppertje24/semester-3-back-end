package com.persoonlijk.backendpersoonlijk.DatabaseModels;

import java.util.ArrayList;
import java.util.List;

public class TextMessageDTO {

    private String time;
    private String message;
    private List<String> logs = new ArrayList<>();  // Changed from 'String log'

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getLogs() {  // Changed from 'String getLog()'
        return logs;
    }

    public void setLogs(List<String> logs) {  // Changed from 'void setLog(String log)'
        this.logs = logs;
    }

    // Add a method to add a single log message
    public void addLog(String log) {
        this.logs.add(log);
    }
}