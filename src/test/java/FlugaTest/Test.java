package FlugaTest;

import FlugaOnline.Offline;
import Logic.Booking;
import Logic.Login;
import Logic.OperationOrder;
import PagePo.MenuBar;
import PagePo.OfflinePage;
import PagePo.OnlinePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class Test {
    WebDriver dr = null;

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.firefox.bin", "C:\\grid\\geckodriver.exe");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        dr.quit();
    }

    @org.testng.annotations.Test
    public void FlightSelectBug() throws InterruptedException {
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("http://47.100.163.174:9030/#/page");
        Login.Login(dr,"megacap","mg35ch");
        dr.findElement(MenuBar.booking).click();
        Thread.sleep(1000);
        dr.findElement(MenuBar.offline).click();
        dr.switchTo().frame("content-iframe");
        Thread.sleep(3000);
        dr.findElement(OnlinePage.unfold).click();
        Thread.sleep(1000);
        dr.findElement(OnlinePage.awbno).sendKeys("TRM-90223944");
        dr.findElement(OnlinePage.search).click();
        Thread.sleep(2000);
        OperationOrder.OfflineChangeFlight(dr,"2019-12-23","HX231","HKG");
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");
        OperationOrder.OfflineCancel(dr,"CSHI");
    }
}