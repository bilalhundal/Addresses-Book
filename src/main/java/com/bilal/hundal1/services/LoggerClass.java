package com.bilal.hundal1.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public  class LoggerClass {
	private static Logger logger=LoggerFactory.getLogger(LoggerClass.class);
	public static void info(String info) {
		logger.info(info);
		
	}
	public static void error(String error) {
		logger.error(error);
	}
	public static void trace(String trace) {
		logger.trace(trace);
	}
	public static void warn(String warn) {
		logger.warn(warn);
	}
	
	

}











