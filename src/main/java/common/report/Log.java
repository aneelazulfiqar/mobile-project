package common.report;

import java.util.logging.Logger;

public class Log {
    private static final Logger logger = Logger.getLogger(Log.class.getName());

    public static void info(String message) {
        logger.info(message);
    }
}
