package com.example.xxljobexp.utils;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public Logger() {
    }

    public static void logInfo(TextArea outputBox, String message) {
        if (outputBox != null) {
            String timestamp = getTimestamp();
            Platform.runLater(() -> {
                outputBox.appendText(timestamp + " : " + message + "\n\n");
            });
        } else {
            System.out.println(message);
        }

    }

    private static String getTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}