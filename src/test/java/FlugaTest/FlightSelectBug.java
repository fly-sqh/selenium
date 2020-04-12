package FlugaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightSelectBug {
    WebDriver dr = null;

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        dr.quit();
    }
    @Test
    public void FlightSelectBug() throws InterruptedException {
        dr=new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("http://47.103.84.51/#/login");
        dr.findElement(By.xpath("//*[@id='root']/section/div/div/div[3]/a[2]/div")).click();
        Thread.sleep(2000);
        dr.findElement(By.id("username")).sendKeys("qihua.shen@feibeluga.com");//输入账号
        dr.findElement(By.id("password")).sendKeys("123456");//输入密码
        dr.findElement(By.xpath("//*[@id='root']/section/section/main/div/div/div[2]/div[3]/div/button[2]")).click();//点击登录
        Thread.sleep(3000);//等待页面加载时间
        dr.findElement(By.xpath("//*[@id='nav-accordion']/li[2]/a/span[1]")).click();//点击产品管理
        Thread.sleep(1000);
        dr.findElement(By.id("submenu-20405")).click();//点击航班管理
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe").findElement(By.id("flightNo")).sendKeys("CX074");//输入航班号
        dr.findElement(By.id("search-btn")).click();//点击搜索
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[12]/button[1]")).click();//点击编辑
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id='dataForm']/div[6]/div/div/div/label[5]/input")).click();//勾选可飞行日
        Thread.sleep(2000);
        dr.switchTo().defaultContent();
        //dr.findElement(By.xpath("//*[@id='errorModal']/div/div/div[3]/button")).click();
        String a=dr.findElement(By.id("errorMsg")).getText();
        System.out.println(a);
        Assert.assertEquals(a,"当前可飞行日不能取消!","提示信息有误");

    }

    public static class ExportBillNew {
        WebDriver  dr=null;
        @BeforeTest
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        }

        @AfterMethod
        public void tearDown() throws Exception {
            // dr.quit();
        }

        public void Login() throws InterruptedException {
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
        }
        public void ExportBill(String aircompany,String station){


        }

        /*@DataProvider(name="")
        public Object[][] EXportDate() throws InterruptedException {
                return new Object[][]{
                        {"11","22"},
                        {"33","44"}

        };*/

        public void Export() throws InterruptedException {
            Login();

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

        }


    }
}