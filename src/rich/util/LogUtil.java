/**
 * 
 */
package rich.util;

/**
 * @author rli
 *
 */
public class LogUtil {
	
	public static int LOG_LEVEL_DEBUG = 0;
	public static int LOG_LEVEL_INFO = 0;
	public static int LOG_LEVEL_ERROR = 0;
	
	
	public static int logLevel = LOG_LEVEL_DEBUG;
	
	/**
	 * @return the logLevel
	 */
	public static int getLogLevel() {
		return logLevel;
	}

	/**
	 * @param logLevel the logLevel to set
	 */
	public static void setLogLevel(int logLevel) {
		LogUtil.logLevel = logLevel;
	}

	public static void debug(String message){
		System.out.println("[debug]"+message);
	}
	
	public static void info(String message){
		System.out.println("[info]"+message);
	}
	
	public static void error(String message){
		System.out.println("[error]"+message);
	}	
}
