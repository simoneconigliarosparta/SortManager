package com.sparta.sc.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class SortManagerLogger {

    private final static Logger logger = Logger.getLogger("SortManagerLogger");

    public static Logger getLogger() {
        return logger;
    }

    public static void setupLogger(){

        try {
            Handler fileHandler = new FileHandler("src/main/java/com/sparta/sc/logger/sort_manager.log");
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new CustomFormatter());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
