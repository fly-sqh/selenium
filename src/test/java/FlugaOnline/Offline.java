package FlugaOnline;

import Logic.Login;
import Packing.LoggerControler;
import Packing.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Offline extends SeleniumWebDriver {
    final static LoggerControler log=LoggerControler.getLog(Offline.class);

    @AfterTest
    public void tearDown(){

        dr.quit();
    }
    @Test
    public void OfflineOrder() throws InterruptedException, IOException {
        SeleniumWebDriver.open("chrome");
        dr.manage().window().maximize();
        dr.get("https://www.fluga.com/#/page");
        Login.Login(dr,"megacap","dD2w74W");
        log.Info("登录成功");

//        dr.findElement(By.xpath("//*[@id='nav-accordion']/li[3]/a/span[1]")).click();//点击订单管理
//        Thread.sleep(2000);
//        dr.findElement(By.id("submenu-20301")).click();//点击订单online
//        Thread.sleep(2000);
//        dr.switchTo().frame("content-iframe");
//        dr.findElements(By.id("add-btn")).get(1).click();//点击批量上传
//        Thread.sleep(2000);
//        dr.findElement(By.id("input-b9")).sendKeys("C:\\Users\\admin\\Documents\\Automation\\offline下单.xlsx");//上传文件
//        Thread.sleep(2000);
//        dr.findElement(By.id("batchUploadBtn")).click();//点击提交
//        Thread.sleep(3000);
//        dr.switchTo().defaultContent();
//        String ordermassge=dr.findElement(By.id("infoMsg")).getAttribute("innerHTML");
//        Assert.assertEquals(ordermassge,"上传成功","下单失败");
//        System.out.println(ordermassge);

    }



}
