package Packing;

import java.io.File;

public class MyFile {
    public static Boolean FileExists(String filepath){
        Boolean tag=false;
        File file=new File(filepath);
        if (file.exists()){
            tag=true;
        }else if(!file.exists()){
            tag=false;
        }
        return tag;
    }
}
