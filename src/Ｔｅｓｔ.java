import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Ｔｅｓｔ {
    public static void print(int num,Object obj){
        System.out.println(String.format("{%d}-----(%s)",num,obj.toString()));
    }
    public static void testDateTime(){
        Calendar cal=Calendar.getInstance();
        LocalDateTime dt=LocalDateTime.now();
        print(1,cal.get(Calendar.DATE));
        print(2,cal.get(Calendar.HOUR));
        print(3,dt.getHour());
    }
    public static void testDateFormat(){
        SimpleDateFormat oldFormatter=new SimpleDateFormat("yyyy/MM/dd");
        Date date1=new Date();
        print(1,oldFormatter.format(date1));
        DateTimeFormatter newFormatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2=LocalDate.now();
        print(2,date2.format(newFormatter));
        LocalDateTime today=LocalDateTime.now();
        print(3,today);
        print(3,today.minusDays(1));
    }
    public static void main(String[] args) {
        //testDateTime();
        testDateFormat();
    }
}
