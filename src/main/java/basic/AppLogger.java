package basic;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;


public class AppLogger {
    private AppLogger() {
        throw new IllegalStateException("Utility class");
    }


    public static void setLevel(Logger logger)
    {
        settleLogger(logger);
    }
    private static void settleLogger(Logger logger) {
        logger.setLevel(INFO);
    }

}

