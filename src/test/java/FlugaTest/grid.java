package FlugaTest;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class grid {
    @DataProvider(name="data")
       public Object[][] test1(){
       return new Object[][]{
               {"chrome"},
               {"firefox"}};

    }
    @Test(dataProvider ="data")
    public void gridtest(String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc=null;
        if (browser.equals("chrome")){
            dc=DesiredCapabilities.chrome();
        }else if (browser.equals("firefox")){
            dc=DesiredCapabilities.firefox();
        }
        WebDriver dr=new RemoteWebDriver(new URL("http://192.168.217.1:4446/wd/hub"),dc);
        dr.get("http://www.baidu.com");
        Thread.sleep(1000);
        dr.quit();


    }
}
