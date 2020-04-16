package Packing;

public class RandomNumber {
    //随机数
    public static String RandomString(int length){
        String val="";
        java.util.Random random=new java.util.Random();
        for(int i =0;i<length;i++){
            String a=random.nextInt(10)%2==0?"char" : "num";
            if(a.equals("char")){
                int b=random.nextInt(10)%2==0?65 :97 ;
                val+=(char)(random.nextInt(26)+b);
            }
            if (a.equals("num")){
                val+=random.nextInt(10);
            }

        }
        //System.out.println(val);
        return val;
    }
}
