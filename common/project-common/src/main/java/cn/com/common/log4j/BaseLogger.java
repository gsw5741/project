package cn.com.common.log4j;

import org.apache.log4j.Logger;

public class BaseLogger {
	private static Logger log = Logger.getLogger(BaseLogger.class);

	public static void debug(Object message) {
		if (log.isDebugEnabled()) {
			log.debug(message);
		}
	}

	public static void error(Object message) {
		log.error(message);
	}
	public static void error(String message) {
		log.error(message);
	}
	public static void warn(Object message) {
		log.warn(message);
	}

	public static void info(Object message) {
		if (log.isInfoEnabled()) {
			log.info(message);
		}
	}
}
