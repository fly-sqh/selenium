package Packing;


import com.sun.deploy.util.Property;
import okhttp3.internal.Internal;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.pattern.LoggerPatternConverter;
import org.testng.ReporterConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoggerControler {
     public static Logger logger=null;
     public static LoggerControler logg=null;
     public static LoggerControler getLog(Class<?> T){
          if(logger==null){
          Properties pro=new Properties();
          try {
               String path = System.getProperty("user.dir");
               String filepath = path + "/Config/log4j.properties";
               InputStream is=new FileInputStream(filepath);
               pro.load(is);
          }catch (IOException e){
              e.printStackTrace();
          }
          PropertyConfigurator.configure(pro);
          logger=Logger.getLogger(T);
          logg=new LoggerControler();
     }    return logg;


     }

     public void Debug(String msg){
          logger.debug(msg);
     }
     public void Info(String msg){
          logger.info(msg);
     }public void Warn(String msg){
          logger.warn(msg);
     }
     public void Error(String msg){
          logger.error(msg);
     }
}
