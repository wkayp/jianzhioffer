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
    public static void exch(int[] nums,int i,int j){
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
    }
    public static void main(String[] args){
        System.out.println(add(3,5)); //8
        System.out.println(add(3,-5)); //-2
        System.out.println(add(0,1));  //1
    }
}