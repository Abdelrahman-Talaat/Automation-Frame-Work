package Listners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class IMethodInterceptListener implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methodInstance, ITestContext TestContext) {

        List<IMethodInstance> result=new ArrayList<IMethodInstance>();
        for(IMethodInstance method:methodInstance){
            Test testMethod=method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
            if (testMethod.priority()==1){
                result.add(method);
            }
        }
        return result;
    }
}
