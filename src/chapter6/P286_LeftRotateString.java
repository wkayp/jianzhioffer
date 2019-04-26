package chapter6;

public class P286_LeftRotateString {
 /*   public static String revers(String string,int n){
        StringBuilder stringBuilder=new StringBuilder(string);
        if(stringBuilder==null||n<=0)
            return null;
        if(n>stringBuilder.length())
            n=n%stringBuilder.length();

        subrever(stringBuilder,0,n-1);
        subrever(stringBuilder,n,stringBuilder.length()-1);
        subrever(stringBuilder,0,stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static void subrever(StringBuilder stringBuilder,int start,int end){
        int mid=start+(end-start)/2;
        for(int i=start;i<=mid;i++){
            char temp=stringBuilder.charAt(i);
            stringBuilder.setCharAt(i,stringBuilder.charAt(end-i+start));
            stringBuilder.setCharAt(end-i+start,temp);
        }
    }

    public static void main(String[] args){
        String str="abcdefg";
        int n=9;
        System.out.println(revers(str,n));
    }*/

 public static String LeftRotateString(String str,int k) {
     if(str==null||k<0)
         return str;//注意点1：特殊情况直接返回原字符串
     if(k>str.length())//注意点2：当长度超过字符串长度时，可以认为移动整数倍的长度相当于没有移动
         k=k%str.length();
     StringBuilder string=new StringBuilder(str);//需要构造StringBuilder，可以在字符串的指定位置插入元素，而String没有此功能
     reverse(string,0,k-1);//转置前k个字符
     reverse(string,k,str.length()-1);//转置K以后的字符
     reverse(string,0,str.length()-1);//整体转置
     return string.toString();
 }

    //翻转string[start,end]
    public static void reverse(StringBuilder string,int start,int end) {
        for(int i=start;i<=start+(end-start)>>1;i++) {
            char temp=string.charAt(i);
            string.setCharAt(i, string.charAt(end-i+start));
            string.setCharAt(end-i+start, temp);
        }
    }

    public static void main(String[] args) {
        int k=2;
        String st=LeftRotateString(new String("abcdefg"),k);
        System.out.print(st);
    }
}
