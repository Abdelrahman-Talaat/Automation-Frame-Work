package Listners;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.testng.Reporter;
import utilities.Screenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.allure.AllureReportHelper;

import java.io.File;
import java.io.IOException;



public class iTestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        AllureReportHelper.cleanAllureReport();
        Reporter.log("Method Name is :"+result.getName());
        System.out.println("Test Starting");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Status Of Execution is "+result.getStatus());
    }

    @Override
    public void onFinish(ITestContext context) {
     /*   try {
            Runtime.getRuntime().exec("generateAllureReport.bat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("Test Finishing");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Fails-ScreenShot Is Captured");
        try {
           Screenshot.getScreenShot(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Reporter.log("<a href=\"E:\\testing\\java\\projects\\nopCommerceFrameWork\\Screenshots\">ScreenShot</a>");

    }

    }

