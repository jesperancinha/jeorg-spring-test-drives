package org.jesperancinha.std.flash19.transactional.cucumber;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.runner.RunWith;

@Cucumber
@CucumberOptions(features = {"classpath:/features/albums.save.feature"})
public class SpringFlash19CucumberLauncher {
}
