package chapter6;

public class P310_AddTwoNumbers {
    //三步走：第一步，只做各位相加不进位；第二步，做进位；第三布，把前面两个结果加起来（涉及重复前面的步骤）。
    public static int add(int num1,int num2){
        int sum,carry;
        do{
            sum=num1^num2;
            carry=(num1&num2)<<1;
            num1=sum;
            num2=carry;
        }while (num2!=0);

        return num1;
    }
    public static int exch(int num1,int num2){
        num1=num1+num2;
        num2=num1-num2;
        num1=num1-num2;
        return num1;
    }
    public static void main(String[] args){
        System.out.println(add(3,5)); //8
        System.out.println(add(3,-5)); //-2
        System.out.println(add(0,1));  //1
        int a=3,b=5;
//        System.out.println("a= "+a+",b= "+b);
//        exch(a,b);
//        System.out.println("a= "+a+",b= "+b);
        System.out.println(exch(a,b));
    }
}