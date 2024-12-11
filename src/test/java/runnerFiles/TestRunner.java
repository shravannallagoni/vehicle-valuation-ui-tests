package runnerFiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = {"pretty", "me.jvt.cucumber.report.PrettyReports:Reports"},
        glue = {"stepDefs"},
        tags = "@test")

public class TestRunner {

}
