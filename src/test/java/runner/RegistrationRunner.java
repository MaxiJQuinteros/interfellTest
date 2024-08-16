package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/registration.feature",
        glue = "src/test/java/stepDef",
        plugin = "pretty"
)
public class RegistrationRunner {
}
