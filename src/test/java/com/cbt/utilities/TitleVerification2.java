package com.cbt.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://walmart.com", "https://westelm.com");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (String eachURL : urls) {
            driver.get(eachURL);
            String title = driver.getTitle().replace(" ", "").toLowerCase();
            String urlName = eachURL.replace("https://", "").replace(".com", "");
            if (title.contains(urlName)) {
                System.out.println("TEST PASSED "+title+" contains "+urlName);
            }else if(title.equals("Privacy error")){
                driver.findElement(By.xpath("//button[@id='details-button']")).click();
                driver.findElement(By.id("final-paragraph")).click();
                title = driver.getTitle().replace(" ", "").toLowerCase();
                urlName = eachURL.replace("https://", "").replace(".com", "");
                if (title.contains(urlName)) {
                    System.out.println("TEST PASSED "+title+" contains "+urlName);
                }
            }else{
                System.out.println("TEST FAILED ! "+title+" should contain "+urlName);
            }
        }

        driver.quit();



    }
}
