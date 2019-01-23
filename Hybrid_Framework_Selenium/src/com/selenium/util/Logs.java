package com.selenium.util;

import org.apache.log4j.Logger;

public class Logs {

	private static Logger log = Logger.getLogger(Logs.class.getName());

	// Methods to Print log before start and after end of TC

	public static void startTestCase(String testCaseID)
	{
		log.info("********************************************");
		log.info("******** Starting "+testCaseID+" ***********");
		log.info("********************************************");
	}

	public static void endTestCase(String testCaseID)
	{
		log.info("********************************************");
		log.info("******** ENDing "+testCaseID+" ***********");
		log.info("********************************************");
	}

	public static void info(String message)
	{
		log.info(message);
	}

	public static void warn(String message)
	{
		log.warn(message);
	}

	public static void error(String message)
	{
		log.error(message);
	}

	public static void fatal(String message)
	{
		log.fatal(message);
	}

	public static void debug(String message)
	{
		log.debug(message);
	}
}
