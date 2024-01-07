package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;



public class TestBase {
    protected final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", String.valueOf(Browser.FIREFOX)));
    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        //app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
    }

    @AfterSuite
    public void tearDown() {
        //app.ftp().restore("config_inc.php.bak", "config_inc.php");
        app.stop();    }
}
