package FlugaOnline;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class MailOrder {
     WebDriver dr=null;
    @BeforeTest
    public void setUp(){
        dr = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
       //dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterTest
    public void tearDown(){

        dr.quit();
    }

    @Test
    public void  MailOrder() throws InterruptedException, IOException {
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("https://www.fluga.com/#/page");
        dr.findElement(By.xpath("//*[@id='root']/section/div/div/div[3]/a[2]/div")).click();
        Thread.sleep(2000);
        dr.findElement(By.id("username")).sendKeys("megacap");//输入账号
        dr.findElement(By.id("password")).sendKeys("mg35ch");//输入密码
        dr.findElement(By.xpath("//*[@id='root']/section/section/main/div/div/div[2]/div[3]/div/button[2]")).click();//点击登录
        Thread.sleep(5000);
        dr.findElement(By.xpath("//*[@id='nav-accordion']/li[3]/a/span[1]")).click();//点击订单管理
        Thread.sleep(2000);
        dr.findElement(By.id("submenu-20301")).click();//点击订舱单online
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");
        dr.findElement(By.xpath("//*[@id=\"main-content\"]/section/div[1]/div/section/header/span[3]/button")).click();//点击邮件批量上传
        Thread.sleep(2000);
        dr.findElement(By.id("batchMail")).sendKeys("C:\\Users\\admin\\Documents\\Automation\\邮件下单.xlsx");
        Thread.sleep(2000);
        dr.findElement(By.id("batchUploadMailBtn")).click();
        Thread.sleep(5000);
        dr.switchTo().defaultContent();
        String Massge=dr.findElement(By.id("infoMsg")).getAttribute("innerHTML");
        System.out.println(Massge);
        Assert.assertEquals(Massge,"上传成功","邮件下单失败");
        dr.switchTo().frame("content-iframe");
        WebDriverWait wait=new WebDriverWait(dr,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("fold")));//显示等待
        dr.findElement(By.id("fold")).click();//点击展开
        Thread.sleep(1000);
        dr.findElement(By.id("awbNo")).sendKeys("CSHICSHI001");//输入单号
        dr.findElement(By.id("search-btn")).click();//点击搜索
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"dataTables\"]/tbody/tr[1]/td[19]/button[3]")).click();//点击取消
        Thread.sleep(2000);
        dr.switchTo().defaultContent();
        dr.findElement(By.id("deleteConfirmBtn")).sendKeys(Keys.ENTER);//点击确定
        dr.switchTo().defaultContent();
        Thread.sleep(5000);
        String cancel=dr.findElement(By.id("infoMsg")).getAttribute("innerHTML");
        System.out.println(cancel);
        Assert.assertEquals(cancel,"操作成功","取消失败");

    }
}
