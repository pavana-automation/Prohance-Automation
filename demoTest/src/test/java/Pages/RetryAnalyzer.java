package Pages;

import org.testng.IRetryAnalyzer;

import test.Login;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter = 0;
	int retryLimit = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		
		
		if(counter < retryLimit)
		{
			System.out.println("Retry the failed case"+result.getName() +" with status");
			counter++;
			return true;
		}
		return false;
	}
}


