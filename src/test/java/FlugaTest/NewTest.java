package FlugaTest;

import FlugaOnline.Offline;
import Logic.Booking;
import Logic.Login;
import Logic.OperationOrder;
import Packing.ExcelUtil;
import Packing.RandomNumber;
import PagePo.MenuBar;
import PagePo.OfflinePage;
import PagePo.OnlinePage;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewTest {

    @Test
    public void Exceltest() {
        Random random=new Random();
        String a[]={RandomNumber.RandomString(5),RandomNumber.RandomString(4),RandomNumber.RandomString(3)};
        List<List<String>> infos =new ArrayList<>();
        List<String> list1=new ArrayList();
        list1.add("姓名");
        list1.add("性别");
        list1.add("分数");
        List<String> list2=new ArrayList();
        list2.add("张三");
        list2.add("男");
        list2.add(String.valueOf(random.nextInt(100)));
        List<String> list3=new ArrayList();
        list3.add("李四");
        list3.add("女");
        list3.add(String.valueOf(random.nextInt(100)));
        infos.add(list1);
        infos.add(list2);
        infos.add(list3);
        int b=infos.get(1).size();
        //ExcelUtil.CreatExcel("D:\\文档\\ExcelTest.xls");
        //ExcelUtil.CreateFile("D:\\文档\\ExcelTest.xls","date",a);
        //ExcelUtil.WriteInfoToExcel("D:\\文档\\ExcelTest1.xls","数据",infos);
        //ExcelUtil.WriteInfoToExcelByCell("D:\\文档\\ExcelTest1.xls","数据",4,list1);
        //List<List<Row>> row= ExcelUtil.readExcels("D:\\文档\\ExcelTest1.xls");
        ExcelUtil.readFromExcel("D:\\文档\\ExcelTest1.xls","数据","");

    }


}