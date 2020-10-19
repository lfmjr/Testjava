package suporte;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Luiz Fernando\\eclipse-workspace\\cucumber\\features\\cenarioApi.feature",
	glue = { "" }, monochrome = true, dryRun = false)
public class cucumberTest {
}