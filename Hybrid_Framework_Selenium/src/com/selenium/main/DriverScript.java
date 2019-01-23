package com.selenium.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

import com.selenium.config.*;
import com.selenium.dataTable.*;
import com.selenium.util.*;

public class DriverScript {

	public static Keyword key;
	public static Properties prop = new Properties();
	public static Method methods[];
	public static boolean result = true;

	public String testCaseID;
	public String runMode;
	public int testStep;
	public int lastTestStep;
	public String keyword;
	public String object;
	public String testdata;

	public DriverScript()
	{
		key = new Keyword();
		methods = key.getClass().getMethods();
	}

	public static void main(String[] args) throws Exception {
		
		//This is to start the Log4j logging in the test case
		 DOMConfigurator.configure("log4j2.xml");

		ReadTestCasesFile.setFilePath(Constants.testCases_path);

		File objectRepoFile = new File(Constants.objectRepo_path);

		FileInputStream objectRepoFileInput = null;

		try {
			objectRepoFileInput = new FileInputStream(objectRepoFile);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(objectRepoFileInput);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		DriverScript start = new DriverScript();
		start.execute_testCase();
	}
	

	public void execute_testCase() throws Exception
	{
		int totalNumberOfTestCases = ReadTestCasesFile.getRowCount(Constants.tc_controllerSheet);
		for(int i =1; i<totalNumberOfTestCases;i++)
		{
			testCaseID = ReadTestCasesFile.getExcelCellData(i, Constants.col_TestCase_ID, Constants.tc_controllerSheet);
			runMode = ReadTestCasesFile.getExcelCellData(i, Constants.col_RunMode, Constants.tc_controllerSheet);
			if(runMode.equals("Y"))
			{
				testStep = ReadTestCasesFile.getRowNumber(testCaseID, Constants.col_TestCase_ID, Constants.tc_testStepsSheet);
				lastTestStep = ReadTestCasesFile.getTestStepsCount(Constants.tc_testStepsSheet, testCaseID, testStep);
				Logs.startTestCase(testCaseID);
				for(;testStep<lastTestStep;testStep++ )
				{
					keyword=ReadTestCasesFile.getExcelCellData(testStep, Constants.col_Keyword, Constants.tc_testStepsSheet);
					object = ReadTestCasesFile.getExcelCellData(testStep, Constants.col_Oject, Constants.tc_testStepsSheet);
					testdata = ReadTestCasesFile.getExcelCellData(testStep, Constants.col_TestData, Constants.tc_testStepsSheet);
					execute_action();
				}
				Logs.endTestCase(testCaseID);
			}
		}
	}

	public void execute_action() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		for(int i=0; i<methods.length;i++)
		{
			if(methods[i].getName().equals(keyword))
			{
				methods[i].invoke(key, object, testdata);
				break;
			}
		}
	}
}
