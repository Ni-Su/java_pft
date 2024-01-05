package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    private final Browser browser;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;


    public ApplicationManager(Browser browser) {
        this.browser = browser;
    }

    public void init () {
         if (browser.equals( Browser.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(Browser.CHROME)){
            wd = new ChromeDriver();
        } else if (browser.equals(Browser.IE)) {
            wd = new InternetExplorerDriver();
        }
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop () {
        wd.quit();
    }

    public GroupHelper getGroupHelper () {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper () {
        return navigationHelper;
    }

    public ContactHelper getContactHelper () { return contactHelper;
    }
}
