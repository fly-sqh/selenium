package FlugaOnline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class ExportCBA {
   WebDriver dr=null;
    @BeforeMethod
    public void Wait(){
         dr=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown(){

        dr.quit();
    }
    @Test
    public void Order() throws InterruptedException, IOException {


        Thread.sleep(3000);//等待页面加载时间
        dr.findElement(By.xpath("//*[@id='nav-accordion']/li[3]/a/span[1]")).click();//点击订单管理
        Thread.sleep(2000);
        dr.findElement(By.id("submenu-20301")).click();//点击订舱单online
        //Thread.sleep(5000);
        dr.switchTo().frame("content-iframe");
        dr.findElement(By.id("flightNo")).sendKeys("GA893");
        dr.findElement(By.id("depDate")).sendKeys("2019-12-05");
        dr.findElement(By.id("search-btn")).click();
        //Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"flightDataTable\"]/tbody/tr/td[4]/div/a")).click();
        //Thread.sleep(1000);
        dr.findElement(By.id("cbaBtn")).click();
        String nowhandle=dr.getWindowHandle();
        for (String winhandle : dr.getWindowHandles()){
            if (winhandle.equals(nowhandle)){
                continue;
            }
            dr.switchTo().window(winhandle);
            break;
        }
        dr.manage().window().maximize();
        //Thread.sleep(1000);
        dr.findElement(By.id("exportCBA")).click();
        dr.findElement(By.id("menuitem-1048-itemEl")).click();




    }

}
