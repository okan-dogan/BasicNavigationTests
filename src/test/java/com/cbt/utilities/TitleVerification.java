package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");


        WebDriver driver = BrowserFactory.getDriver("chrome");
        String titleName = "";
        int counter=0;
        for (int i = 0; i <urls.size() ; i++) {
            driver.get(urls.get(i));
            if(!titleName.equals(driver.getTitle())){
                titleName=driver.getTitle();
                counter++;
            }
        }
        System.out.println(counter);
        if(counter>1){
            System.out.println("TEST FAILED");
        }else{
            System.out.println("TEST PASSED, ALL THE WEB PAGES HAVE THE SAME TITLE");
        }

        driver.quit();

    }
}
