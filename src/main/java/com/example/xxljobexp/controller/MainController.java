package com.example.xxljobexp.controller;

import com.example.xxljobexp.entity.Vulnerability;
import com.example.xxljobexp.service.VulExploitTask;
import com.example.xxljobexp.service.VulScanTask;
import com.example.xxljobexp.utils.ExpList;
import com.example.xxljobexp.utils.URLParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private TextField txt_target_url;
    @FXML
    private Tab tab_vul_check;
    @FXML
    private ComboBox<String> comboBox_vul;
    @FXML
    private TextArea txt_vul_check;
    @FXML
    private Tab tab_vul_desc;
    @FXML
    private TextArea txt_vul_desc;

    @FXML
    void clear(ActionEvent event) {
        this.txt_vul_desc.setText("");
        this.txt_vul_check.setText("");
    }


    public void initialize() {
        this.comboBox_vul.setValue("XXL-JOB api unauth");
        this.comboBox_vul.getItems().addAll(ExpList.get_exp());
        this.txt_vul_desc.setEditable(false);
        this.txt_vul_check.setEditable(false);
    }

    @FXML
    void vul_scan(ActionEvent event) {
        Button vulScanButton = (Button)event.getSource();
        vulScanButton.setDisable(true);
        String url = this.txt_target_url.getText();
        boolean standard = URLParser.checkTheURL(url);
        if (standard) {
            TabPane tabPane = this.tab_vul_check.getTabPane();
            tabPane.getSelectionModel().select(this.tab_vul_check);
            this.txt_target_url.setText(url);
            VulScanTask vulscan = new VulScanTask(this.comboBox_vul, this.txt_target_url, this.txt_vul_check);
            (new Thread(vulscan)).start();
            vulScanButton.setDisable(false);
        }

    }

    @FXML
    void vul_attack(ActionEvent event) {
        Button vulAttackButton = (Button)event.getSource();
        vulAttackButton.setDisable(true);
        String url = this.txt_target_url.getText();
        boolean standard = URLParser.checkTheURL(url);
        if (standard) {
            TabPane tabPane = this.tab_vul_check.getTabPane();
            tabPane.getSelectionModel().select(this.tab_vul_check);
            this.txt_target_url.setText(url);
            VulExploitTask vulscan = new VulExploitTask(this.comboBox_vul, this.txt_target_url, this.txt_vul_check);
            (new Thread(vulscan)).start();
            vulAttackButton.setDisable(false);
        }
    }


    @FXML
    void get_vul_description(ActionEvent event) {
        TabPane tabPane = this.tab_vul_desc.getTabPane();
        tabPane.getSelectionModel().select(this.tab_vul_desc);
        String vul_name = (String)this.comboBox_vul.getSelectionModel().getSelectedItem();
            Vulnerability vul = ExpList.getPayload(vul_name);
            this.txt_vul_desc.setText("\n" + vul.getInfo());
    }

}
