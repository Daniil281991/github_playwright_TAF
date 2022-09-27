package com.utils;

public class EnvVariablesManager {

    public String getEnvironmentVariable(String variableName) {
        return System.getenv(variableName);
    }
}
