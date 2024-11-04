package com.example.xxljobexp.service;

import com.example.xxljobexp.entity.ExecutionResult;
import com.example.xxljobexp.entity.Vulnerability;
import com.example.xxljobexp.utils.ExpList;
import com.example.xxljobexp.utils.Logger;
import javafx.concurrent.Task;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.naming.InitialContext;
import java.util.ArrayList;
import java.util.Iterator;

public class VulScanTask extends Task<Void> {
    private final ComboBox<String> comboBox;
    private final TextField txt_target_url;
    private final TextArea infores_txt;

    public VulScanTask(ComboBox<String> comboBox, TextField txt_target_url, TextArea infores_txt) {
        this.comboBox = comboBox;
        this.txt_target_url = txt_target_url;
        this.infores_txt = infores_txt;
    }

    protected Void call() throws Exception {
        this.check_vul();
        return null;
    }

    public void check_vul() throws Exception {
        String url = this.txt_target_url.getText();
        String vul_name = (String)this.comboBox.getSelectionModel().getSelectedItem();
        Logger.logInfo(this.infores_txt, "===========================================================================================================\n开始检测 " + vul_name + " ! ! !");
        Vulnerability bp = ExpList.getPayload(vul_name);
        ExecutionResult vul = bp.check(url);
        if (vul.getMessage() != null) {
            Logger.logInfo(this.infores_txt, "[ ! ] 需要人工确认" + vul.getVuln() + "\n" + vul.getMessage());
        } else if (vul.getResult()) {
            Logger.logInfo(this.infores_txt, "[+] 存在" + vul.getVuln() + "\n" + vul.getResponse());
        } else {
            Logger.logInfo(this.infores_txt, "[-] 不存在" + vul.getVuln());
        }

    }
}
