package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

        WebDriver driverChr = BrowserFactory.getDriver("chrome");
        driverChr.get("http://google.com");
        BrowserUtils.wait(2);

        String titleG = driverChr.getTitle();
        System.out.println("titleG = " + titleG);

        driverChr.get("http://etsy.com");
        BrowserUtils.wait(2);

        String titleE = driverChr.getTitle();
        System.out.println("titleE = " + titleE);

        driverChr.navigate().back();
        BrowserUtils.wait(1);
        StringUtility.verifyEquals(titleE,titleG);
        driverChr.navigate().forward();
        BrowserUtils.wait(1);
        StringUtility.verifyEquals(titleE,titleE);


        BrowserUtils.wait(2);
        driverChr.quit();

//#################################


//        WebDriver driverEdg = BrowserFactory.getDriver("edge");
//        driverEdg.get("http://google.com");
//        BrowserUtils.wait(2);
//
//
//        BrowserUtils.wait(2);
//        driverEdg.quit();



    }
}
