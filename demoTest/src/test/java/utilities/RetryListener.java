package utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import Pages.RetryAnalyzer;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,Method testMethod)
	{
		System.out.println("this part is executed");
		
		testannotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
