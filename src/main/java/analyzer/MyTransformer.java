package analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransformer implements IAnnotationTransformer{
	//override transform method
	public void transform(ITestAnnotation annotation,Class testclass,Constructor testconstructor,Method testmethod)
	{//ITestAnnotation parameter
		//class parameter
		//method parameter
		//constructor parameter
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
