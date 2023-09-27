package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.devtools.v85.applicationcache.ApplicationCache;
import org.openqa.selenium.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

public class TestBase {
    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        app.ftp().upload(new File("src/test/resoursec/config_inc.php"), "config_inc.php", "config_inc.php.bak")
    }

    @AfterSuite
    public void tearDown() {
        app.ftp().restore("config_inc.php.bak", "config_inc.php");
        app.stop();    }
}
