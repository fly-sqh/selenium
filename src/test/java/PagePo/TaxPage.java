package PagePo;

import org.openqa.selenium.By;

public class TaxPage {
    public static By addTax= By.id("addTaxRates");//新增税表
    public static By selectproduct=By.id("airlineProductId");//选择产品
    public static By comfirm=By.id("addSaveBtn");//确认
    public static By startdate=By.id("startDate");//生效时间
    public static By enddate=By.id("endDate");//失效时间
    public static By taxupload=By.id("showUploadFileModal");//导入税率详情按钮
    public static By taxselectfile=By.id("inputFile");//选择文件
    public static By taxsubmit=By.id("uploadBtn");//提交
    public static By save=By.id("saveBtn");//保存按钮

}
