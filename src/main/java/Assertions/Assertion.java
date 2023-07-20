package Assertions;

import org.testng.Assert;

public class Assertion {

    public static void assertEquals(String actualResult,String expectedResult){
        Assert.assertEquals(actualResult,expectedResult);
    }

    public static void assertTrue(boolean status){
        Assert.assertTrue(status);
    }
}
