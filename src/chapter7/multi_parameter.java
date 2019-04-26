package chapter7;

public class multi_parameter {
    public static void fun(int... nums){
        for(int num:nums)
            System.out.println(num);
    }
    public static void main(String[] args){
        fun(1,2,'a','A');
    }
}
