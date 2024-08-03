package com.example;

import com.microsoft.playwright.*;

public class App {

    public Playwright playwright;

    boolean setHeadless;

    public App(boolean setHeadless) {

        this.playwright = Playwright.create();

        this.setHeadless = setHeadless;

    }

    public Browser launchBrowser() {

        return playwright.chromium()

                .launch(

                        new BrowserType.LaunchOptions()

                                .setHeadless(setHeadless)

                                .setSlowMo(500));

    }

    public BrowserContext createContext(Browser browser) {

        return browser.newContext(

                new Browser.NewContextOptions()

                        .setViewportSize(1600, 900)

                        .setAcceptDownloads(true));

    }

}
