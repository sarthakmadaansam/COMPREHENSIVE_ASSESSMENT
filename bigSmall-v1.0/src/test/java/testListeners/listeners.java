package testListeners;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.driverClass;

public class listeners implements ITestListener{

	driverClass dc= new driverClass();
	

	public void onTestFailure(ITestResult result) {
		try {
			dc.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}



	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			dc.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}



	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

	

}
