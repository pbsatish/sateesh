package runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"D:\\DATADRIVEN\\Day2_Cucumber123\\Day2_Cucumber\\Cucumber_DataTable\\src\\test\\resources\\features\\Nationality.feature"},
glue= {"seleniumgluecode"},
plugin = {"pretty", "html:target/cucumber-html-report"},
tags = {}
)

public class testrunner {

}