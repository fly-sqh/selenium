package Packing;

import com.sun.deploy.association.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Actions extends SeleniumWebDriver {

    //点击元素
    public static void Click(By by){
        FindElement.findElement(by).click();
    }
    //文本框输入值（先清空输入框）
    public static void Sendkeys(By by,String value){
        FindElement.findElement(by).clear();
        FindElement.findElement(by).sendKeys(value);
    }
    //获取某个元素的值
    public static String Gettext(By by){
        String getValue=FindElement.findElement(by).getText();
        System.out.println(getValue);
        return getValue;
      }
      //获取多个元素的值
    public static ArrayList Gettexts(By by){
       ArrayList array= new ArrayList();
       List<WebElement> list=FindElement.findElements(by);
       for (int i=0;i<list.size();i++){
           String getValues=list.get(i).getText();
           array.add(getValues);
       }
       return array;
    }
    //双击
    public static WebElement DoubleClick(By by){
        WebElement element=FindElement.findElement(by);
        org.openqa.selenium.interactions.Actions action=new org.openqa.selenium.interactions.Actions(dr);
        action.doubleClick(element).perform();
        return element;
    }
    //右键点击
    public static WebElement RightKey(By by){
        WebElement element=FindElement.findElement(by);
        org.openqa.selenium.interactions.Actions action=new org.openqa.selenium.interactions.Actions(dr);
        action.contextClick(element).perform();
        return element;
    }
    //鼠标悬停
    public static WebElement Hover(By by){
        WebElement element=FindElement.findElement(by);
        org.openqa.selenium.interactions.Actions action=new org.openqa.selenium.interactions.Actions(dr);
        action.moveToElement(element).perform();
        return element;
    }
}
