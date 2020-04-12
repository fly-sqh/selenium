package PagePo;

import org.openqa.selenium.By;

public class OfflinePage {
    public static By chageflight=By.id("chargeFlight");//offline订单列表修改航班按钮
    public static By flightdate=By.id("flightDate");//修改航班弹窗的航班日期输入框
    public static By flightno=By.id("flightNo");//修改航班弹窗的航班号输入框
    public  static By pointoftransfer=By.id("transferDestCode");//修改航班弹窗的中转点输入框
    public static By confirm=By.id("saveFlight");//修改航班弹窗的确定按钮
    public static By blank=By.xpath("//*[@id=\"chargeFlightModal\"]/div/div/div[1]");//点击空白处
    public static By offlinecancel=By.xpath("//*[@id=\"dataTables\"]/tbody/tr/td[21]/button[1]");//offline取消订单
    public static By offlinecomfirm=By.xpath("//*[@id=\"dataTables\"]/tbody/tr[1]/td[21]/button[1]");//offline接受订单
    public static By offlineflightdate=By.id("depDate");//offline航班日期输入框
    public static By offlineflightdateto=By.id("depDateTo");//offline至航班日期输入框
}
