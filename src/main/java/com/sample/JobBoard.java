package com.sample;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    public void searchByTilteLocation(String title, String location) {
        this.driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys(title);
        WebElement locationInput = driver.findElement(By.xpath("//input[@name=\"l\"]"));
        for (int i = 0; i < 15; i++) {
            locationInput.sendKeys(Keys.BACK_SPACE);
        }
        locationInput.sendKeys(location);
        this.driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
    }

    public void filterSelection() {
        this.driver.findElement(By.xpath("//button[@id='filter-dateposted']")).click();
        this.driver.findElement(By.xpath("//a[contains(text(),'Last 24 hours')]")).click();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public List<JobData> getJobPost() {
        List<WebElement> jobPosts = driver.findElements(By.cssSelector(".job_seen_beacon .resultContent"));
        List<JobData> jobDataList = new ArrayList<>();
        for(WebElement job: jobPosts) {
            JobData jobData = new JobData();
            WebElement jobTitleElement = job.findElement(By.cssSelector(".jobTitle a span"));
            WebElement jobCompanyElement = job.findElement(By.cssSelector(".job_seen_beacon .resultContent .company_location div span"));
            jobData.setTitle(jobTitleElement.getAttribute("title"));
            jobData.setCompany(jobCompanyElement.getText());
            try {
                WebElement jobSalaryElement = job.findElement(By.cssSelector(".job_seen_beacon .resultContent .salary-snippet-container div"));
                jobData.setSalary(jobSalaryElement.getText());
            } catch (NoSuchElementException exp) {
                jobData.setSalary("No data provided");
            }
            jobDataList.add(jobData);
        }
        return jobDataList;
    }

    public void clickElement() {
        WebElement tempClickPosition = driver.findElement(By.cssSelector(".job_seen_beacon .resultContent a"));
        tempClickPosition.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElement(By.id("jobDescriptionText")));
    }






}
