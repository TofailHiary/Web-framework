package io.cucumber.skeleton;


import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
//import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import com.cucumber.listener.Reporter;
//import cucumber.api.junit.Cucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;

@RunWith(ExtendedCucumber.class)
@CucumberOptions(
        features = "src/test/resources/General/Login/test.feature",
        plugin = {"pretty", "io.qameta.allure.cucumberjvm.AllureCucumberJvm", "junit:target/surefire-reports/Cucumber.xml", "html:target", "com.cucumber.listener.ExtentCucumberFormatter:./Reports/index.html"},
        //tags = {"@JO"},
       // tags = {"@Test"},
        glue = {"io.cucumber.skeleton"},
       dryRun=false,
       monochrome = true
)

public class RunCukesTest {


}
