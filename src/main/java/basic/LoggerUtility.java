package basic;

import java.util.logging.*;
public class LoggerUtility {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    private static Logger logger;



    private LoggerUtility() {throw new IllegalStateException("Utility class");}

    public static Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(LoggerUtility.class.getName());
            setupLogger();
        }
        return logger;
    }

    private static void setupLogger() {
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                String color = RESET;
                if (logRecord.getLevel().equals(Level.SEVERE)) {
                    color = RED;
                } else if (logRecord.getLevel().equals(Level.WARNING)) {
                    color = YELLOW;
                } else if (logRecord.getLevel().equals(Level.INFO)) {
                    color = GREEN;
                } else if (logRecord.getLevel().equals(Level.FINE)) {
                    color = BLUE;
                }

                return color + formatMessage(logRecord) + RESET ;
            }
        });

        logger.addHandler(consoleHandler);
    }
}
