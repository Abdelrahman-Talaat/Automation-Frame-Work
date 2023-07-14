package Listners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class IAnnotationTransforme implements IAnnotationTransformer {
    int counter=3;
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(IRetryAnalyzerClass.class);


        /** override testng annotations **/
        if(testMethod.getName().equals("changeInvocationCountOfMethod")){
            annotation.setInvocationCount(counter);
            annotation.setPriority(2);
        }
        if (testMethod.getName().equals("changePriority")){
            annotation.setInvocationCount(1);
            annotation.setPriority(1);
        }
    }
}
