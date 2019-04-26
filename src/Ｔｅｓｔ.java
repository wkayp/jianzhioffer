import java.lang.reflect.Type;

public class Ｔｅｓｔ {
//    public static char[] reverse(char[] nums){
//        int lo=0,hi=nums.length-1;
//        while (lo<=hi){
//            swap(nums,lo,hi);
//            lo++;
//            hi--;
//        }
//        return nums;
//    }
//    public static void swap(char[] nums,int i,int j){
//        char temp=nums[i];
//        nums[i]=nums[j];
//        nums[j]=temp;
//    }
    public static void main(String[] args) {
//        String s="helloword";
//        System.out.println(reverse(s.toCharArray()));
        String s1=new String("xyz");
        String s2="xyz";
        String s3="xyz";
        StringBuilder s=new StringBuilder(s1);
        Integer a=Integer.parseInt("11");
        Integer b=Integer.valueOf("123");

        System.out.println(s.reverse());

    }
}
