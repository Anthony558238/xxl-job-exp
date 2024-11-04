package com.example.xxljobexp.entity;

public class ExecutionResult {
    boolean result;
    String message;
    String response;
    String vuln;

    public ExecutionResult(boolean result, String vuln, String response, String message) {
        this.result = result;
        this.message = message;
        this.response = response;
        this.vuln = vuln;
    }

    public boolean getResult() {
        return this.result;
    }

    public String getVuln() {
        return this.vuln;
    }

    public String getResponse() {
        return this.response;
    }

    public String getMessage() {
        return this.message;
    }
}