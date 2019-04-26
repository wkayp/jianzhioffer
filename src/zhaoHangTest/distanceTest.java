package zhaoHangTest;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class distanceTest {
//    private static final double EARTH_RADIUS = 6378.137;
//    private static double degTorad(double degree){//角度换算成弧度
//        return degree*Math.PI/180.0;
//    }
//    private static double radTodeg(double radian){//弧度换算成角度
//        return radian*180.0/Math.PI;
//    }
//    public static double GetDistance(double lat1, double lng1, double lat2, double lng2){
//        double radLat1 = degTorad(lat1);
//        double radLat2 = degTorad(lat2);
//        // a=lat1 – lat2 为两点纬度之差  b=lng1 -lng2 为两点经度之差；
//        double a = radLat1 - radLat2;
//        double b = degTorad(lng1) - degTorad(lng2);
//        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
//        s = s * EARTH_RADIUS;
//        //s = Math.round(s * 10000) / 10000;
//        return s;
//    }
    public static double add(double d1,double d2){
        BigDecimal b1=BigDecimal.valueOf(d1);
        BigDecimal b2=BigDecimal.valueOf(d2);
        return b1.add(b2).doubleValue();
    }

    public static void main(String[] args) throws Exception{
//        double lat1=22.5369548317,lng1=114.0225501220;
//        double lat2=39.9064024197,lng2=116.3624819407;
//        //
//        System.out.println(GetDistance(lat1,lng1,lat2,lng2));
//        Map<String,String> env=System.getenv();
//        for(String name:env.keySet()){
//            System.out.println(name+"---->"+env.get(name));
//        }
//        System.out.println(System.getenv("JAVA_HOME"));
//        System.out.println(System.currentTimeMillis()-1556088630248L);

//        String s1="hello ";
//        System.out.println(Math.toDegrees(Math.PI));
//        System.out.println(Math.toRadians(180.0));

//        System.out.println(System.identityHashCode(s1)+"---->"+System.identityHashCode(s2));

//        Runtime rt=Runtime.getRuntime();
//        System.out.println("处理器数量："+rt.availableProcessors());
//        System.out.println("空闲内存数："+rt.freeMemory());
//        System.out.println("总内存数："+rt.totalMemory());
//        System.out.println("可用最大内存数："+rt.maxMemory());
//        User u1=new User(29);
//        User u2=u1.clone();
//        int[] a=new int[10];
//        int[] b=(int[]) a.clone();
//        Random random=new Random(20);
//        System.out.println(random.nextInt());
//        System.out.println(random.nextDouble());
//        System.out.println(random.nextBoolean());
//        Random random1=new Random(21);
//        System.out.println(random1.nextInt());
//        System.out.println(random1.nextDouble());
//        System.out.println(random1.nextBoolean());
//        System.out.println(u1==u2);
//        System.out.println(u1.address==u2.address);
//        System.out.println(a);

//        BigDecimal f1=new BigDecimal("0.05");
//        BigDecimal f2=BigDecimal.valueOf(0.01);
//        BigDecimal f3=new BigDecimal(0.05);
//
//        System.out.println("使用String作为BigDecimal构造器参数： ");
//        System.out.println("0.05+0.01= "+f1.add(f2));
//        System.out.println("0.05-0.01= "+f1.subtract(f2));
//        System.out.println("0.05*0.01= "+f1.multiply(f2));
//        System.out.println("0.05/0.01= "+f1.divide(f2));
//
//        System.out.println("使用Double作为BigDecimal构造器参数： ");
//        System.out.println("0.05+0.01= "+f3.add(f2));
//        System.out.println("0.05-0.01= "+f3.subtract(f2));
//        System.out.println("0.05*0.01= "+f3.multiply(f2));
//        System.out.println("0.05/0.01= "+f3.divide(f2));

//        System.out.println(0.01+0.05);
//        System.out.println(add(0.01,0.05));
        Calendar c=Calendar.getInstance();
        System.out.println(c.getTime());
    }
}
