package com.ait.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementDemoWebShop {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementDyCssSelectors(){
        //register link
        driver.findElement(By.cssSelector("[href='/register']"));
        //search input
        driver.findElement(By.cssSelector("#small-searchterms"));
        //header menu
        driver.findElement(By.cssSelector(".top-menu [href='/books']"));
        //side panel menu
        driver.findElement(By.cssSelector(".listbox [href='/books']"));
        //add to cart "Button"(first)
        driver.findElement(By.cssSelector(".item-box:nth-child(2) .buttons [type='button']"));
    }
}



