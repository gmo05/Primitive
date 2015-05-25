package com.gmo.util;



import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import com.gmo.core.util.PropertiesUtil;

public class LoggerUtil {

   
    public static Logger getLoggerByName(String name) {
    	String path = PropertiesUtil.confProperties.getProperty("user.trace.logger.path");
        // 生成新的Logger
        // 如果已經有了一個Logger實例返回現有的
        Logger logger = Logger.getLogger(name);
        // 清空Appender。特別是不想使用現存實例時一定要初期化
        logger.removeAllAppenders();
        // 設定Logger級別。
        String lelTypecof = PropertiesUtil.confProperties.getProperty("user.trace.logger.level");

        Level levelType =getLevelType(lelTypecof);
        logger.setLevel(levelType);
        // 設定是否繼承父Logger。
        // 默認為true。繼承root輸出。
        // 設定false後將不輸出root。
        logger.setAdditivity(true);
        // 生成新的Appender
        FileAppender appender = new RollingFileAppender();
        PatternLayout layout = new PatternLayout();
        // log的输出形式
        String conversionPattern = PropertiesUtil.confProperties.getProperty("user.trace.logger.ConversionPattern");
        layout.setConversionPattern(conversionPattern);
        appender.setLayout(layout);
        // log输出路径
        // 这里使用了环境变量[catalina.home]，只有在tomcat环境下才可以取到
        String tomcatPath = java.lang.System.getProperty("catalina.home");
        appender.setFile(path + name);
        // log的文字码
        appender.setEncoding(PropertiesUtil.confProperties.getProperty("user.trace.logger.Encoding"));
        // true:在已存在log文件后面追加 false:新log覆盖以前的log
        appender.setAppend(true);
        // 适用当前配置
        appender.activateOptions();
        // 将新的Appender加到Logger中
        logger.addAppender(appender);
        return logger;
    }
    
    public static Level getLevelType(String lelTypecof) {
    	Level levelType =null;
    	if(lelTypecof.equalsIgnoreCase("DEBUG")) {
        	levelType = Level.DEBUG;
        } else if(lelTypecof.equalsIgnoreCase("INFO")) {
        	levelType = Level.INFO;
        } else if(lelTypecof.equalsIgnoreCase("ALL")) {
        	levelType = Level.ALL;
        } else if(lelTypecof.equalsIgnoreCase("ERROR")) {
        	levelType = Level.ERROR;
        } else if(lelTypecof.equalsIgnoreCase("FATAL")) {
        	levelType = Level.FATAL;
        } else if(lelTypecof.equalsIgnoreCase("OFF")) {
        	levelType = Level.OFF;
        } else if(lelTypecof.equalsIgnoreCase("TRACE")) {
        	levelType = Level.TRACE;
        } else if(lelTypecof.equalsIgnoreCase("WARN")) {
        	levelType = Level.WARN;
        } else {
        	levelType = Level.DEBUG;
        }
    	return levelType;
    }
}
