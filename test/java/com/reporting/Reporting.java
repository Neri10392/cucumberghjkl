package com.reporting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJvmReport(String jsonFile) {
	
	File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\OMRBranchAdactinAutomation\\target");
	Configuration configuration = new Configuration(file, "Adactin Hotel Automation");
	configuration.addClassifications("Browser", "Chrome");
	configuration.addClassifications("BrowserVersion", "105");
	configuration.addClassifications("Os", "win10");
	configuration.addClassifications("Sprint", "34");
	
	List<String> jsonFiles = new ArrayList<String>();
	jsonFiles.add(jsonFile);
	ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
	builder.generateReports();
	
	
          
}
}