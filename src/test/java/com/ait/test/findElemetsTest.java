package com.ait.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class findElemetsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");

        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(900, 400));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Test
    public void findElementsTestByTagNameTest() {
        //FIND BY ELEMENT (ONE)

        //by tagName h1
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        // by tag h2
        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());

        // by tag a

        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());

        // by tag label

        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());

        //FIND BY ELEMENT (MULTIPLY)
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());
    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getDomAttribute("id"));

        WebElement date = driver.findElement(By.id("dates"));
        System.out.println(date.getDomAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement search = driver.findElement(By.className("navigation-link"));
        System.out.println(search.getDomAttribute("class"));
    }

    @Test
    public void findElementByLinkedText() {
        WebElement linkText = driver.findElement(By.linkText("Let car work"));
        System.out.println(linkText.getText());

        WebElement linkText2 = driver.findElement(By.linkText("Rome"));
        System.out.println(linkText2.getText());
    }

    @Test
    public void findElementByPartialLinkedText() {
        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
//        driver.findElement(By.tagName("h1"));
        // tag name "h1" -> "h1"
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("h2"));

//        driver.findElement(By.id("city"));
        //id='city -> #city
        driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.cssSelector("#dates"));

        //driver.findElement(By.className("telephone"));
//class='telephone'-> ccs .telephone
        driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.cssSelector(".navigation-link"));

        //driver.findElement(By.partialLinkText("work"));
        //partialLinkText
        //contains-> *
        driver.findElement(By.cssSelector("[class*='fa-bars']"));
        //start->^
        driver.findElement(By.cssSelector("[class^='fa-solid']"));
        //ena to->$
        driver.findElement(By.cssSelector("[class$='fa-bars']"));

        //[key='value']
        driver.findElement(By.cssSelector("[class*='mobile']"));
        driver.findElement(By.cssSelector("[for='dates']"));
        driver.findElement(By.cssSelector("[href='/let-car-work']"));

        //composite cssSelector
        //tag+class+pare
        driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));

        //>one step below
        driver.findElement(By.cssSelector(".logo>img"));

        //<space> one or more steps below
        driver.findElement(By.cssSelector(".feedback-page .banner-left"));

        //<tag> or <class> or<id> :nth-child(n)
        WebElement feedback = driver.findElement(By.cssSelector(".feedback-card:nth-child(6)"));
        System.out.println(feedback.getText());
        WebElement search = driver.findElement(By.cssSelector(".navigation-link:nth-child(2)"));
        System.out.println(search.getText());
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
