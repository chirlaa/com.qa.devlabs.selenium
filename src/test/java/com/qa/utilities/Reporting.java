package com.qa.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	ExtentHtmlReporter htmlreport;
	ExtentTest xTest;
	ExtentReports xReport;
	 
	  public void onStart(ITestContext testContext) {
		  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName="Test-Report-"+timeStamp+".html";
			
			
			
			htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		  //htmlreport = new ExtentHtmlReporter("C:\\Users\\chirlaa\\eclipse-workspace\\com.qa.devlabs.selenium\\test-output\\myreport.html");
		  htmlreport.config().setDocumentTitle("Automation Test Report");
		  htmlreport.config().setReportName("Functional Testing");
		  htmlreport.config().setTheme(Theme.DARK);
		  htmlreport.config().setAutoCreateRelativePathMedia(true);
		  xReport = new ExtentReports();
		  xReport.attachReporter(htmlreport);
		  xReport.setSystemInfo("OS", "WINDOWS");
		  xReport.setSystemInfo("Browser", "Chrome");
		  xReport.setSystemInfo("QA Name", "Anil");
	   
	  }
	 
	  public void onFinish(ITestContext testContext) {
			xReport.flush();
	  }
	  public void onTestSkipped(ITestResult tr) {
		  xTest = xReport.createTest(tr.getName()); // create an entry into extent report...
		  }
	  public void onTestSuccess(ITestResult tr) {
		  xTest = xReport.createTest(tr.getName()); // create an entry into extent report...
		  }

	
	public void onTestFailure(ITestResult tr) {
		xTest = xReport.createTest(tr.getName()); // create an entry into extent report...
		  }
	 
	
}
