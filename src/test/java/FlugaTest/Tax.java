package FlugaTest;

import Logic.Login;
import PagePo.MenuBar;
import PagePo.OnlinePage;
import PagePo.TaxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tax {
    WebDriver dr = null;

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        dr.quit();
    }
    public void TaxDate(String productid,String filename){
        Select s1=new Select(dr.findElement(TaxPage.selectproduct));
        s1.selectByValue(productid);//选择产品
        dr.findElement(TaxPage.selectproduct).sendKeys(filename);
    }
    @DataProvider(name="ProductDate")
    public Object[][] TaxData(){
        return new Object[][]{
                {"7","C:\\Users\\admin\\Documents\\转移文件\\税率表\\ET-PVG税表详情.xlsx"},//ET-PVG税表
                {"23","C:\\Users\\admin\\Documents\\转移文件\\税率表\\ET-CAN税表详情.xlsx"},//ET-CAN税表
                {"41","C:\\Users\\admin\\Documents\\转移文件\\税率表\\ET-CGO税表详情.xlsx"},//ET-CGO税表
                {"65","C:\\Users\\admin\\Documents\\转移文件\\税率表\\ET-CKG税表详情.xlsx"},//ET-CKG税表
                {"24","C:\\Users\\admin\\Documents\\转移文件\\税率表\\ET-CTU税表详情.xlsx"},//ET-CTU税表
                {"9","C:\\Users\\admin\\Documents\\转移文件\\税率表\\ET-PEK税表详情.xlsx"}

        };

    }
    @Test(dataProvider = "TaxData")
    public void TaxUplod(String productid,String filename) throws InterruptedException {
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("http://47.100.163.174:9030/#/page");
        Login.Login(dr,"megacap","mg35ch");
        dr.findElement(MenuBar.general).click();//点击通用
        Thread.sleep(1000);
        dr.findElement(MenuBar.tax).click();//点击税率管理
        Thread.sleep(3000);
        dr.switchTo().frame("content-iframe");
        dr.findElement(TaxPage.addTax).click();//点击新增税表
        Thread.sleep(1000);
        TaxDate(productid,filename);
        Thread.sleep(1000);
        dr.findElement(TaxPage.comfirm).click();//点击确定
        Thread.sleep(2000);
        dr.findElement(TaxPage.startdate).sendKeys("2020-01-01");//输入起始时间
        dr.findElement(TaxPage.enddate).sendKeys("2020-02-29");//输入结束时间
        Thread.sleep(1000);
        dr.findElement(TaxPage.taxupload).click();
        Thread.sleep(2000);
        dr.findElement(TaxPage.taxselectfile).sendKeys
                ("C:\\Users\\admin\\Documents\\转移文件\\税率表\\ET-PVG税表详情.xlsx");
        Thread.sleep(2000);
        dr.findElement(TaxPage.taxsubmit).click();
        Thread.sleep(2000);
        dr.findElement(TaxPage.save).click();
        Thread.sleep(2000);
        dr.switchTo().defaultContent();
        String Massage=dr.findElement(OnlinePage.massge).getAttribute("innerHTML");
        System.out.println(Massage);
        Assert.assertEquals(Massage,"保存成功","税表上传失败");

    }
}
