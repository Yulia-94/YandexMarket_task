package com.tayahatum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HelperYandex {
    WebDriver driver;

    public HelperYandex(WebDriver driver) {
        this.driver = driver;
    }

    Logger logger = LoggerFactory.getLogger(HelperYandex.class);


    public void selectedComputer() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//span[.='Компьютеры']")).click();
        logger.info("Computer section selected!");
    }


    public void selectTablets() {
        driver.findElement(By.xpath("//a[contains(@href,'/catalog--planshety/54545/list?hid=6427100')]")).click();
        logger.info("Tablets section selected!");
    }

    public void setPriceRange(double min, double max) {
        type(By.id("glpricefrom"), String.valueOf(min));
        type(By.id("glpriceto"), String.valueOf(max));
        logger.info("Price boundaries were set!" + ": " + min + "->" + max);
    }

    public void selectProducer(String text) {
        driver.findElement(By.xpath(String.format("//span[.='%s']", text))).click();
        logger.info("Selected manufacture -->" + text);
        pause(2000);
    }


    public boolean varifySearchResult() {

        String text = driver.findElement(By.xpath("//article[2]//h3/a/span")).getText();
        System.out.println(text);
        type(By.id("header-search"), text);
        driver.findElement(By.xpath("//button[.='Найти']")).click();
        System.out.println("*******");
        pause(2000);

        String text2 = driver.findElement(By.xpath("//article[1]//img")).getAttribute("alt");
        System.out.println(text2);
        logger.info("Was checked tablet -->" + text);
        logger.info("Test Passed");
        return text.equals(text2);
    }

    public void navigateToMarket() {
        driver.findElement(By.xpath("//div[@class='services-new__item-title'][.='Маркет']")).click();
    }
    public void type (By locator, String text){
        if(text!=null) {
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }

    }
    public void pause(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
