package Packing;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    final static LoggerControler log=LoggerControler.getLog(DateFormat.class);
    public static final String  A="yyyy-mm-dd hh:mm:ss";
    public static final String  B="yyy-mm-dd";
    public static String Format(String type){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(type);
        String date=simpleDateFormat.format(new Date());
        log.Info(date);
        return date;
    }
}
