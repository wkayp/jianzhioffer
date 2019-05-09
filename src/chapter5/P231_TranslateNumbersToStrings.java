package chapter5;

public class P231_TranslateNumbersToStrings {
    public static int getTranslationCount(int number){
        if(number<0)
            return 0;
        if(number==1)
            return 1;
        return getTranslationCount(Integer.toString(number));//toString（）将整型数字转换为字符串类型
    }
    //动态规划，从右到左计算。
    //f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
    //如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0
    public static int getTranslationCount(String str){
        int f2=1,f1=1,n=str.length();
        for(int i=n-2;i>=0;i--){
            int g=Integer.parseInt(str.charAt(i)+""+str.charAt(i+1))<26?1:0;
            int temp=f2;
            f2=f2+g*f1;
            f1=temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(-10));  //0
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
    }
}
