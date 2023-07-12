package allure;

import org.eclipse.aether.repository.RemoteRepository;
import ru.yandex.qatools.allure.report.AllureReportBuilder;
import ru.yandex.qatools.allure.report.AllureReportBuilderException;

import java.io.File;

public class allureReport {
    public static void generateAllureReport()  throws AllureReportBuilderException {
        new AllureReportBuilder("1.5.4", new File("target/allure-report")).unpackFace();
        new AllureReportBuilder("1.5.4", new File("target/allure-report")).processResults(new
                File("target/allure-results"));
    }
}
