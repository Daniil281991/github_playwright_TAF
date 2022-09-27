package com.utils;

import constants.AppConstants;

import java.io.IOException;
import java.util.logging.*;

public class LoggerHandler {
    String filename;

    public LoggerHandler() {
        this.filename = "logs.log";
    }

    public LoggerHandler(String filename) {
        this.filename = filename;
    }

    public Logger setupLogger() {
        Logger logger = Logger.getLogger(LoggerHandler.class.getName());

        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        logger.addHandler(consoleHandler);

        try {
            FileHandler fileHandler = new FileHandler(
                    AppConstants.LOGS_FOLDER_PATH + this.filename, true);
            logger.addHandler(fileHandler);
        } catch (
                IOException e) {
            logger.log(Level.SEVERE, "Something wrong with log file", e);
            throw new RuntimeException(e);
        }

        return logger;
    }
}
