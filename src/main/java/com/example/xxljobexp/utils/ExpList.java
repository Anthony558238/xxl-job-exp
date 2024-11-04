package com.example.xxljobexp.utils;

import com.example.xxljobexp.entity.Vulnerability;
import com.example.xxljobexp.exploit.api_unauth;
import com.example.xxljobexp.exploit.executor_unauth_212_230;
import com.example.xxljobexp.exploit.executor_unauth_high230;
import com.example.xxljobexp.exploit.executor_unauth_low212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpList {
    private static final Map<String, Vulnerability> vulMap = new HashMap();

    public ExpList() {
    }

    public static List<String> get_exp() {
        List<String> list = new ArrayList();
        list.add("XXL-JOB api unauth");
        list.add("executor-unauth version<2.1.2");
        list.add("executor-unauth 2.2.0<=version<2.3.0");
        list.add("executor-unauth version>=2.3.0");

        return list;
    }

    public static Vulnerability getPayload(String select) {
        return (Vulnerability)vulMap.get(select);
    }

    static {
        vulMap.put("XXL-JOB api unauth", new api_unauth());
        vulMap.put("executor-unauth version<2.1.2", new executor_unauth_low212());
        vulMap.put("executor-unauth 2.2.0<=version<2.3.0", new executor_unauth_212_230());
        vulMap.put("executor-unauth version>=2.3.0", new executor_unauth_high230());

    }
}