package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reporting.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun=true
,snippets= SnippetType.CAMELCASE,stepNotifications=true,plugin= {"pretty","json:target\\Output.json"}, features= "src\\test\\resources\\Features",glue= "com.stepdefinition")

public class TestRunnerClass {
	
	@AfterClass
	public static void afterClass() {
		 Reporting.generateJvmReport("C:\\Users\\Welcome\\eclipse-workspace\\OMRBranchAdactinAutomation\\target\\Output.json");
	}

}
