package com.utils;


import org.apache.log4j.Logger;

public class LoggerHandler {
    public static Logger logger = Logger.getLogger(LoggerHandlerLogging.class.getName());

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void debug(String msg) {
        logger.debug(msg);
    }

}
