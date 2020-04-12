package FlugaTest;

import Packing.Actions;
import Packing.FindElement;
import Packing.SeleniumWebDriver;
import PagePo.AgentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumTest {

        @Test
        public void test(){
        WebDriver dr= SeleniumWebDriver.open("chrome");
        dr.manage().window().maximize();
        dr.get("https://www.baidu.com");
        Actions.Sendkeys(By.id("kw"),"selenium");
        Actions.DoubleClick(By.id("su"));
        FindElement.findElement(AgentPage.agentsearch);
        }
}
