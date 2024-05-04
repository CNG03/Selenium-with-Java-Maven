package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tt\\Downloads\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        WebElement searchBox = driver.findElement(By.name("q"));

        //1. Nhập từ khóa tìm kiếm
        searchBox.sendKeys("selenium easy");

        // 2. Submit form để bắt đầu tìm kiếm
        searchBox.submit();


        // Đợi một chút để trang tìm kiếm được tải

        Thread.sleep(3000);


        // 3. Tìm và nhấp vào kết quả đầu tiên trong danh sách kết quả
        WebElement firstResult = driver.findElement(By.xpath("//div[@class='g']//a/h3"));
        firstResult.click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int windowHeight = Integer.parseInt(js.executeScript("return window.innerHeight").toString());
        long documentHeight = (long) js.executeScript("return document.body.scrollHeight");
        long scrollHeight = 0;

        // 4. Cuon trang
        while (scrollHeight < documentHeight) {
            scrollHeight += windowHeight;
            js.executeScript("window.scrollTo(0, " + scrollHeight + ");");

            Thread.sleep(1000); // Chờ 1 giây giữa mỗi lần cuộn
        }
        // Tìm thẻ div có class là "footer-right"
        WebElement footerDiv = driver.findElement(By.className("footer-right"));
        java.util.List<WebElement> links = footerDiv.findElements(By.tagName("a"));

        if (!links.isEmpty()) {
            // 5. Click button Home o cuoi trang
            links.get(0).click();
            System.out.println("Đã click vào liên kết đầu tiên trong div.");
        }

        // 6. Click button Selenium o dau trang
        WebElement link = driver.findElement(By.linkText("Selenium"));
        link.click();
        Thread.sleep(1000);
        // 7. Chọn Selenium with Java
        link = driver.findElement(By.linkText("Selenium with Java"));
        link.click();
        Thread.sleep(1000);
        // 8. Chọn Selenium with Python
        link = driver.findElement(By.linkText("Selenium"));
        link.click();
        Thread.sleep(1000);
        link = driver.findElement(By.linkText("Selenium with Python"));
        link.click();
        Thread.sleep(1000);
        // 9. Chọn Selenium with Python
        link = driver.findElement(By.linkText("Playwright"));
        link.click();
        // 10. Chọn TestNG
        Thread.sleep(1000);
        link = driver.findElement(By.linkText("TestNG"));
        link.click();
        Thread.sleep(1000);
        // 11. Chọn Maven
        link = driver.findElement(By.linkText("Maven"));
        link.click();
        Thread.sleep(1000);
        // 12. Chọn Jenkins
        link = driver.findElement(By.linkText("Jenkins"));
        link.click();
        Thread.sleep(1000);
        // 13. Chọn Protractor
        link = driver.findElement(By.linkText("Protractor"));
        link.click();
        Thread.sleep(1000);
        // 14. Chọn Appium
        link = driver.findElement(By.linkText("Appium"));
        link.click();
        Thread.sleep(1000);
        // 15. Chọn Apache Poi
        link = driver.findElement(By.linkText("Apache Poi"));
        link.click();
        Thread.sleep(1000);


        WebElement inputElement = driver.findElement(By.id("edit-search-block-form--2"));
        //16. Nhập vào ô tìm kiếm
        inputElement.sendKeys("Maven Selenium");
        Thread.sleep(2000);
        //17. Click vào button tìm kiếm
        WebElement buttonElement = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        buttonElement.click();
        Thread.sleep(1000);
        scrollHeight = 0;
        while (scrollHeight < documentHeight) {
            scrollHeight += windowHeight;
            js.executeScript("window.scrollTo(0, " + scrollHeight + ");");
            Thread.sleep(1000);
        }

        driver.quit();
    }
}