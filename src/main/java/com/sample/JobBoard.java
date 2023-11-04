package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobBoard {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public JobBoard() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void loadURL(String url) {
        try {
            driver.navigate().to(url);
            driver.manage().deleteAllCookies();
            Thread.sleep(2000);
        } catch (Exception exp) {
            System.out.println("The url is not valid!");
            driver.navigate().to("https://www.indeed.com/");
        }
    }

    public void inputTilteLocation(String title, String location) {
        driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys(title);
        WebElement locationInput = driver.findElement(By.xpath("//input[@name=\"l\"]"));
        for (int i = 0; i < 15; i++) {
            locationInput.sendKeys(Keys.BACK_SPACE);
        }
        locationInput.sendKeys(location);

        driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
        driver.findElement(By.xpath("//button[@id='filter-dateposted']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Last 24 hours')]")).click();

    }




}
