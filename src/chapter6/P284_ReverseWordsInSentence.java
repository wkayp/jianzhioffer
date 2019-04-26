package chapter6;

public class P284_ReverseWordsInSentence {
    public static String reverse(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        reverseSubString(stringBuilder,0,stringBuilder.length()-1);//第一次整体翻转
        int start = 0,end = stringBuilder.indexOf(" ");//返回第一次出现空格在该字符串中的索引。如果它不是作为一个子字符串出现，则返回 -1。
        while (start<stringBuilder.length()&&end!=-1){
            reverseSubString(stringBuilder,start,end-1);//注意点1：end返回值时空格对应的索引，减去1才是非空格的末尾
            start = end+1;//从翻转过后的下一个单词开始
            end = stringBuilder.indexOf(" ",start);//从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。
        }

        if(start<stringBuilder.length())//
            reverseSubString(stringBuilder,start,stringBuilder.length()-1);

        return stringBuilder.toString();//注意点2：在传递之前需要转换成字符串类型
    }
    //翻转stringBuilder[start,end]
    //由于Java没有运算符重载，没有[ ] 方便调用，必须显示调用数组。
    public static void reverseSubString(StringBuilder stringBuilder,int start,int end){//注意点1：声明为String型字符串不能完成交换操作
        for(int i=start;i<=start+(end-start)>>1;i++) {
            char temp=stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, stringBuilder.charAt(end-i+start));//注意点3：end-i+start所代表的含义必须搞明白
            stringBuilder.setCharAt(end-i+start,temp);
        }
    }

    public static void main(String[] args){
        System.out.println(reverse("I am a student."));
    }
}
