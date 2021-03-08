import com.tayahatum.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {


    protected static Config config = new Config(System.getProperty("browser",BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m){
        logger.info("Start test - >" +m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m){
        logger.info("End of test -> "+m.getName() + "\n************************************");
    }
    @BeforeClass
    public void setUp() throws IOException {
       config.start();


    }

    @AfterClass
    public void tearDown(){
     config.stop();


    }
}
