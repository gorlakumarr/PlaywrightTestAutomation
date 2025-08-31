package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class FirstScript {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        Page page = browser.newPage();

        page.navigate("https://playwright.dev");
        System.out.println(page.title());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("playwright.png")));

        page.close();
        browser.close();
        playwright.close();
    }
}