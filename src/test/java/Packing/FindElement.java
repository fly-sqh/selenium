package Packing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindElement extends SeleniumWebDriver {
    public static WebElement findElement(final By by){
       try{
           WebDriverWait wait=new WebDriverWait(dr,10);
           wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
       }catch (Exception e){
           System.out.println("元素"+by+"查找超时");
           e.printStackTrace();

        }
       return dr.findElement(by);

    }
    public static List<WebElement> findElements(final By by){
        List<WebElement> list=null;
        try{
            WebDriverWait wait=new WebDriverWait(dr,10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
