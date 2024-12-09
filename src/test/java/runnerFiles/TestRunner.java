package runnerFiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "me.jvt.cucumber.report.PrettyReports:Reports"},
        glue = {"src/test/java/stepDefs"},
        tags = "@test")

public class TestRunner {

}
