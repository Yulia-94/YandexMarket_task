package com.tayahatum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class Config {

    private WebDriver driver;
    HelperYandex yandex;
    private String browser;
    Logger logger= LoggerFactory.getLogger(Config.class);

    public Config(String browser) {
        this.browser=browser;
    }

    public void start() {
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
           driver = new EdgeDriver();
        }



        driver.navigate().to("https://yandex.ru");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        yandex = new HelperYandex(driver);
    }

    public void stop() {
        driver.quit();
    }

    public HelperYandex yandex() {
        return yandex;
    }
}
