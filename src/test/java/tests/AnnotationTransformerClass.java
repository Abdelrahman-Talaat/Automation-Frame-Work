package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AnnotationTransformerClass {
    @Test(invocationCount = 5,priority = 1)
    public void changeInvocationCountOfMethod(){
        System.out.println("Hello");

    }

    @Test(invocationCount = 3,priority = 2)
    public void changePriority(){
        System.out.println("Hi");

    }
}
