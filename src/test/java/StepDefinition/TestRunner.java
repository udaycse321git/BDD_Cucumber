package StepDefinition;


import org.junit.runner.RunWith;   
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;  
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/login1.feature",glue= {"StepDefinition"},
tags = "@Regression",
monochrome = true,
//plugin = { "pretty", "html:target/HtmlReports/report.html"})
plugin = { "pretty", "html:target/HtmlReports/report.html","json:target/JSon_Report/report.json","junit:target/JUnit_Report/report.xml" })
//plugin = { "pretty", "html:target/HtmlReports"})
//plugin = { "pretty", "json:target/reports/cucumber.json"},
//plugin = { "pretty",  "junit:target/reports/cucumber.xml"}
public class TestRunner {
	

}

//monochrome = true
//
//
//}
//
//
//tags="@smoketest"
