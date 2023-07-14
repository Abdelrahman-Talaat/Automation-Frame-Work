package utilities.allure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Queue;

public class AllureReportHelper {

    private static final File allureReportDir = new File("target/allure-results");

    private AllureReportHelper() {

    }

    public static void cleanAllureReport(){
        if (allureReportDir.exists()) {
            File[] reportFiles = allureReportDir.listFiles();
            assert reportFiles != null;
            for (File file : reportFiles) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
    }

    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }


    }

