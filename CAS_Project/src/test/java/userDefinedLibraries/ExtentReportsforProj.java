package userDefinedLibraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsforProj {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	public ExtentReports setExtentReport() {
		// Create an object of Extent Reports
		report = new ExtentReports();
		// specify location of the report
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/Acronym_App_Validation.html");
		report.attachReporter(spark);
		// Passing General information
		report.setSystemInfo("Host Name", "localhost");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Team 2");
		spark.config().setDocumentTitle("Automation Project Report");
		// Name of the report
		spark.config().setReportName("Acronym App Validation Report Version 1.1");
		// Dark Theme
		spark.config().setTheme(Theme.STANDARD);// only 2 themes available STANDARD and DARK
		return report;
	}

	public void endExtentReport() {
		// write results into the file
		report.flush();
		
	}
}