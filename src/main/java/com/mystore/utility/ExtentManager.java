package com.mystore.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	protected static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	
	public static void initReport() throws IOException {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("test-output\\ExtentReport\\Spark.html");
		spark.loadXMLConfig("extent-config.xml");
		extent.attachReporter(spark);
	}
	
	public static void closeReport() {
		extent.flush();
	}
}