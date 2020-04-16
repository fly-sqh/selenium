package FlugaTest;

import Logic.Login;
import PagePo.MenuBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;


public class ExportBillTest {
    WebDriver dr=null;

    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
        //dr = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws Exception {
         dr.quit();
    }

    public void AirDate(String aircompany ,String station){
        Select s1=new Select(dr.findElement(By.id("billAlId")));
        s1.selectByValue(aircompany);//选择航司
        Select s2=new Select(dr.findElement(By.id("billStationId")));
        s2.selectByValue(station);//选择站点
    }
    @DataProvider(name="productdate")
    public static Object[][] test(){
        return new Object[][]{
                {"1","2"},//ET-CAN
                {"1","1"},
                {"1","3"},
                {"1","11"},
                {"1","6"},
                {"1","19"},
                {"3","1"},//AM-PVG
                {"3","2"},//AM-CAN
                {"3","3"},
                {"6","3"},//LY-PEK
                {"6","1"},
                {"9","6"},//MH-CKG
                {"9","10"},
                {"9","9"},
                {"9","8"},//MH-HAK
                {"9","6"},
                {"7","1"},//5J-PVG
                {"7","3"},
                {"8","4"},//IT-MFM
                {"11","1"},//GA-PVG
                {"11","2"},
                {"11","3"},
                {"11","11"},
                {"13","2"},//BS-CAN
                {"14","8"},//3K-HAK
                {"14","12"},
                {"21","1"},//AR-PVG
                {"29","1"},//XW-PVG
                {"29","23"},
                {"29","21"},
                {"29","22"},
                {"29","9"},
                {"43","1"},//M7-PVG
                {"43","2"},
                {"44","1"},//CX-PVG
                {"47","2"},//KA-CAN
                {"48","11"},//6E-CTU
                {"48","2"},
                {"49","2"}//KU-CAN

        };
    }
    @Test(dataProvider ="productdate")
    public void Export(String aircompany ,String station) throws InterruptedException {
        dr=new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("http://47.100.161.111/#/page");
        Login.Login(dr,"megacap","mg35ch");
        dr.findElement(MenuBar.accounting).click();//点击财务&结算
        Thread.sleep(1000);
        dr.findElement(MenuBar.airliessales).click();
        dr.switchTo().frame("content-iframe");//切换iframe
        dr.findElement(By.id("exportBill")).click();//点击导出按钮
        Thread.sleep(1000);
        AirDate(aircompany,station);
        dr.findElement(By.id("billStartDate")).sendKeys("2019-12-01");//填写起始时间
        dr.findElement(By.id("billEndDate")).sendKeys("2019-12-31");//填写结束时间
        dr.findElement(By.id("add-modal-title")).click();//点击空白处将时间弹窗消除
        dr.findElement(By.id("exportBtn")).click();;//点击生成账单
        Thread.sleep(1000);
       /*Thread.sleep(100000);
        dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr[1]/td[13]/button[3]")).click();//点击删除账单
        Thread.sleep(1000);
        dr.switchTo().defaultContent();//切出iframe
        dr.findElement(By.id("deleteConfirmBtn")).click();//点击确定
        dr.switchTo().frame("content-iframe");//切换iframe
        Thread.sleep(4000);*/
    }
    }

