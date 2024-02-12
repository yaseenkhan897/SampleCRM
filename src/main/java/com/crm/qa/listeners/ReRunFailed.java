package com.crm.qa.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRunFailed implements IRetryAnalyzer {
  int retryCount =0;
  int maxCount = 2;
	@Override
	public boolean retry(ITestResult arg0) {
		if (arg0.getStatus()==ITestResult.FAILURE&&retryCount<=maxCount) {
			System.out.println("Count is :"+retryCount+"Excecuting Tc is :"+arg0.getName());
			retryCount++;
			return true;
		}
		return false;
	}

}
