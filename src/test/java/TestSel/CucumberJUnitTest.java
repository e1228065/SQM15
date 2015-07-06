package TestSel;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


/**
 * Connects Cucumber .feature-files and JUnit Runner and
 * allows to run all scenarios that are annotated with @Sample
 * or @Lab as JUnit4 test.
 */

@RunWith(Cucumber.class)

@CucumberOptions(features={"src/test/resources/CucumberFeatures"}, 
				 glue= {"gluecode"}, 
				 format = {"html:target/cucumber-html-report","json:target/cucumber-json-report.json"}
)

public class CucumberJUnitTest {
}
