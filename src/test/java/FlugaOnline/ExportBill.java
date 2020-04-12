package FlugaOnline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.io.IOException;

public class ExportBill {//导出航司账单
    WebDriver dr=null;
    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");

    }

    @AfterMethod
    public void tearDown() throws Exception {
       // dr.quit();
    }


    @Test
     public void Exportbill() throws InterruptedException, IOException {
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("https://www.fluga.com/#/page");
        dr.findElement(By.xpath("//*[@id='root']/section/div/div/div[3]/a[2]/div")).click();
        Thread.sleep(2000);
        dr.findElement(By.id("username")).sendKeys("megacap");//输入账号
        dr.findElement(By.id("password")).sendKeys("mg35ch");//输入密码
        dr.findElement(By.xpath("//*[@id='root']/section/section/main/div/div/div[2]/div[3]/div/button[2]")).click();//点击登录
        Thread.sleep(5000);
        //*[@id="nav-accordion"]/li[6]/a/span[1]
        dr.findElement(By.xpath("//*[@id='nav-accordion']/li[6]/a/span[1]")).click();//点击财务/结算
        Thread.sleep(2000);
        dr.findElement(By.id("submenu-20501")).click();//点击航司账单
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");//切换iframe
        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(1000);
     /* 1*/  Select s1=new Select(dr.findElement(By.id("billAlId")));
        s1.selectByValue("3");//选择AM航司
        Select s2=new Select(dr.findElement(By.id("billStationId")));
        s2.selectByValue("2");//选择CAN站点
        dr.findElement(By.id("billStartDate")).sendKeys("2019-12-01");//填写起始时间
        dr.findElement(By.id("billEndDate")).sendKeys("2019-12-15");//填写结束时间
        dr.findElement(By.id("add-modal-title")).click();//点击空白处将时间弹窗消除
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(20000);
        //String massge1=dr.findElement(By.id("infoMsg")).getAttribute("innerHTML");
        //System.out.println(massge1);
        //Assert.assertEquals(massge1,"生成账单成功","账单导出失败");
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        dr.switchTo().frame("content-iframe");//切换iframe
         Thread.sleep(4000);

        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(2000);
        s1.selectByValue("6");//选择LY航司
        s2.selectByValue("1");//选择PVG站点
        /*dr.findElement(By.id("billStartDate")).sendKeys("2019-11-16");//填写起始时间
        dr.findElement(By.id("billEndDate")).sendKeys("2019-11-30");//填写结束时间
        dr.findElement(By.id("add-modal-title")).click();//点击空白处将时间弹窗消除*/
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");//切换iframe
        Thread.sleep(2000);
        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(2000);
        s1.selectByValue("48");//选择6E航司
        s2.selectByValue("11");//选择CTU站点
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        Thread.sleep(2000);

       dr.switchTo().frame("content-iframe");//切换iframe
       Thread.sleep(2000);
       dr.findElement(By.id("exportBill")).click();//点击导出按钮
       Thread.sleep(2000);
       s1.selectByValue("49");//选择KU航司
       s2.selectByValue("2");//选择CAN站点
       dr.findElement(By.id("exportBtn")).click();;//点击生成账单
       Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");//切换iframe
        Thread.sleep(2000);

        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(2000);
        s1.selectByValue("47");//选择KA航司
        s2.selectByValue("2");//选择CAN站点
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(200000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");//切换iframe
        Thread.sleep(4000);

        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(2000);
        s1.selectByValue("8");//选择IT航司
        s2.selectByValue("4");//选择MFM站点
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(500000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");//切换iframe
        Thread.sleep(4000);

        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(2000);
        s1.selectByValue("43");//选择IT航司
        s2.selectByValue("1");//选择MFM站点
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(500000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");//切换iframe
        Thread.sleep(4000);

        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(2000);
        s1.selectByValue("11");//选择GA航司
        s2.selectByValue("1");//选择PVG站点
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(500000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");//切换iframe
        Thread.sleep(4000);

        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(2000);
        s1.selectByValue("1");//选择ET航司
        s2.selectByValue("2");//选择CAN站点
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(150000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定


    }


}
