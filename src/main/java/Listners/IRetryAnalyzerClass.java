package Listners;

import org.testng.ITestResult;
/** After implementing the retry class we will aplly it to the desired test to execute it **/
/** @Test (retryAnalyzaer=package name Of retry class.retry class name.class)**/

public class IRetryAnalyzerClass implements org.testng.IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

}
