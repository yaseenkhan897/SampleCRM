package com.crm.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.util.Testutil;

public class TestcaseTracking implements ITestListener   {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("suite execution is ended :"+" "+arg0.getName());
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("suite execution is started :"+" "+arg0.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		Testutil.Takescreenshot();
		System.out.println("Testcase execution is Failed:"+" "+result.getName());
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Tc execution is skipped :"+" "+arg0.getName());
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Testcase execution is start :"+" "+arg0.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Tc execution is sucess :"+" "+arg0.getName());
		
	}

}
