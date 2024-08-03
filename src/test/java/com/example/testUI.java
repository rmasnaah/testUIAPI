package com.example;

import java.io.IOException;

import java.util.Properties;

 

import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.testng.annotations.BeforeMethod;

 

import com.microsoft.playwright.Browser;

import com.microsoft.playwright.BrowserContext;

import com.microsoft.playwright.Page;

import com.microsoft.playwright.Playwright;

//import io.github.cdimascio.dotenv.Dotenv;

import action.*;

 

public class testUI {

    static Playwright playwright;

    static Browser browser;

    static App app;

   

    BrowserContext context;

    Page page;

 

    protected test test;


 

    @BeforeAll

    static void launchBrowser() {

        app = new App(false);

        playwright = app.playwright;

        browser = app.launchBrowser();

    }

 

    @AfterAll

    static void closeBrowser() {

        playwright.close();

    }

 

    @BeforeEach

    void createContextAndPage() {

        context = app.createContext(browser);

        page = context.newPage();

        page.navigate("https://www.kilwins.com/");

        test = new test(page);
 

    }

 

    @AfterEach

    void closeContext() {

        context.close();

    }


    
    @Test

    public void test() {
    
        test.testScreen();
    }
}