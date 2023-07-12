package Listners;

import utilities.Screenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class iTestListener extends Screenshot implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Start");
    }

    @Override
    public void onFinish(ITestContext context) {

        try {
            Runtime.getRuntime().exec("generateAllureReport.bat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Fails-ScreenShot Is Captured");
        try {
            getScreenShot(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }

