package com.ezequiel.training.java8.pluralsight.coreplatform;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by ezequiel on 07/08/16.
 */
public class LogSystems {

    public static final String SEVERE = "Severe!!!";

//    public static LogManager logManager = LogManager.getLogManager();

//    public static Logger pkgLogger = logManager.getLogger("LogSystem");

    public static Logger pkgLogger  = Logger.getLogger("com.ezequiel.training.java8.pluralsight.coreplatform");
    public static Logger logger     = Logger.getLogger("com.ezequiel.training.java8.pluralsight.coreplatform.LogSystems");


    /**
     * we need to capture app activity
     */

    public static void main(String[] args) {
//        Level severe = Level.SEVERE;
//        pkgLogger.setLevel(severe);
//        pkgLogger.log(severe, SEVERE);
//        pkgLogger.log(severe, "{0} is my favorite", "Java");
//        pkgLogger.severe(SEVERE);
//        doWork();
        naming();
    }

    static void  doWork() {
//        pkgLogger.entering();
        Handler h = new ConsoleHandler();
        h.setLevel(Level.ALL);
        Formatter f = new SimpleFormatter();
        h.setFormatter(f);

        pkgLogger.addHandler(h);
        pkgLogger.setLevel(Level.ALL);
        pkgLogger.log(Level.INFO, "We're logging");
    }


    void seila(){
        /**
         * java -Djava.util.logging.SimpleFormatter.format
         *
         * java.util.logging.config.file
         * */


        //create a substitution pattern
        /***
         * foo_%g.log rotating
         *
         * */

        try {
            Handler fileHandler = new FileHandler("%h/myapp_%g.log", 1000, 4);
            fileHandler.setFormatter(new SimpleFormatter());

            pkgLogger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        pkgLogger.exiting();

    }

    static void naming(){
        logger.entering("com.ezequiel.training.java8.pluralsight.coreplatform", "naming");

        logger.log(Level.INFO, "We're Logging");

        logger.exiting("com.ezequiel.training.java8.pluralsight.coreplatform", "naming");
    }

}
