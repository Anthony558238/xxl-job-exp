package com.example.xxljobexp.utils;

import javafx.scene.control.Alert;

import java.net.URI;
import java.net.URISyntaxException;

public class URLParser {
    static Alert alert;

    public static boolean checkTheURL(String weburl) {
        if (!weburl.startsWith("http")) {
            alert.setTitle("提示:");
            alert.setHeaderText("URL检查");
            alert.setContentText("URL格式不符合要求，示例：http://127.0.0.1:9999");
            alert.showAndWait();
        }

        return weburl.startsWith("http");
    }

    public static String resetURL(String weburl) {
        try {
            URI uri = new URI(weburl);
            String protocol = uri.getScheme();
            String host = uri.getHost();
            int port = uri.getPort();
            if (port == -1) {
                if ("http".equalsIgnoreCase(protocol)) {
                    port = 80;
                } else if ("https".equalsIgnoreCase(protocol)) {
                    port = 443;
                }
            }

            weburl = protocol + "://" + host + ":" + port;
            return weburl;
        } catch (URISyntaxException var5) {
            var5.printStackTrace();
            return null;
        }
    }
}
