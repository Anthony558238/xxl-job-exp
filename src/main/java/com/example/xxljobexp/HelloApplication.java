package com.example.xxljobexp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("xxl-job-exp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280.0, 800.0);
        stage.setTitle("xxl-job 漏洞利用工具");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}