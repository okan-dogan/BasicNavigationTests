package com.cbt.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://walmart.com", "https://westelm.com");


        for (int i = 0; i <urls.size() ; i++) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(urls.get(i));
            String title = driver.getTitle().replace(" ", "").toLowerCase();
            String urlName = urls.get(i).replace("https://", "").replace(".com", "");
            if (title.contains(urlName)) {
                System.out.println("TEST PASSED "+title+" contains "+urlName);
            }else if(title.equals("Privacy error")){
                driver.findElement(By.xpath("//button[@id='details-button']")).click();
                driver.findElement(By.id("final-paragraph")).click();
                title = driver.getTitle().replace(" ", "").toLowerCase();
                urlName = urls.get(i).replace("https://", "").replace(".com", "");
                if (title.contains(urlName)) {
                    System.out.println("TEST PASSED "+title+" contains "+urlName);
                }
            }else{
                System.out.println("TEST FAILED ! "+title+" should contain "+urlName);
            }

            driver.quit();

        }



    }
}
