package najah.edu.acceptance;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( features = "Myfeatures",
 plugin = {"summary","html:target/cucumber/report.html"},
 snippets = SnippetType.CAMELCASE,
 glue = "najah.edu.acceptance")
public class AcceptanceTest {

}
