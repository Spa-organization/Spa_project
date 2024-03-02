package najah.edu.acceptance;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions( features = "Myfeatures",
 plugin = {"summary","html:target/cucumber/report.html"},
 snippets = SnippetType.CAMELCASE,
 glue = "najah.edu.acceptance")

public class AcceptanceTest {

}
