package chapter7;

public class StringToInt {
    public static int StrToInt(String str) {
        if(str.length()==0)
            return 0;
        str=str.trim();
        int flag=0;
        if(str.charAt(0)=='+')
            flag=1;
        else if(str.charAt(0)=='-')
            flag=2;
        int start=flag>0?1:0;
        long res=0;
        while(start<str.length()){
            if(str.charAt(start)<'0'||str.charAt(start)>'9'){
                return 0;
            }
            res=res*10+(str.charAt(start)-'0');
            start++;
        }
        return flag==2?-(int)res:(int)res;
    }
    public static void main(String[] args){
        System.out.println(StrToInt(" 100")); //100
        System.out.println(StrToInt(" -100")); //-100
    }
}
