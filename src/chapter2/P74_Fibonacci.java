package chapter2;

public class P74_Fibonacci {
    public static long fibonacci1(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return fibonacci1(n-1)+fibonacci1(n-2);
    }
    public static long fibonacci2(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        int a=0,b=1,f=0;
        for(int i=2;i<=n;i++){
            f=b+a;
            a=b;//先与下一步
            b=f;
        }
        return f;
    }
    public static void main(String[] args) {

        long start,end;
        start=System.currentTimeMillis();
        long value=fibonacci2(40);
        end=System.currentTimeMillis();
        System.out.println(value);
        System.out.println(end-start);

//        System.out.println(fibonacci2(13));
//        System.out.println(fibonacci3(13));
//        System.out.println(fibonacci4(13));
    }
}
