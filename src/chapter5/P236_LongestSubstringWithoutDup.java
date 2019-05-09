package chapter5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P236_LongestSubstringWithoutDup {
    //动态规划
    //dp[i]表示以下标为i的字符结尾不包含重复字符的最长子字符串长度
    public static int longestSubstringWithoutDup(String str){
        if(str==null || str.length()==0)
            return 0;

        //position数组用于记录26个字符（a~z）上一次出现在字符串中位置的下标。该数组所有元素初始化为-1，负数表示该元素对应的字符在字符串中还没有出现。
        int[] position = new int[26];
        for(int i=0;i<str.length();i++) {
            position[i]=-1;
        }

        int curLength=0;
        int maxLength=0;  //注意点1：需要用到变量是才声明，有助于阅读
        for(int i = 1;i<str.length();i++){
            //i最终会停在重复字符或者-1的位置,要注意i的结束条件
            int preIndex = position[str.charAt(i)-'a'];
            int distance=i-preIndex;////当前字符与它上次出现位置之间的距离
            if(preIndex<0||distance>curLength)//i处字符之前未出现过，或者d>f(i-1)
                ++curLength;//f(i)=f(i-1)+1
            else {
                if(curLength>maxLength)
                    maxLength=curLength;

                curLength=distance;//d<=f(i-1),f(i)=d
            }
            position[str.charAt(i)-'a']=i;//注意点2：一定要每次刷新当前字符的位置
        }
        if(curLength>maxLength)
            maxLength=curLength;

        return maxLength;
    }

    //第二种解法：
    public static int longestSubstringWithoutDup2(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);//调用库函数初始化数组。
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);//i-left包含了两种情况
        }
        return res;
    }

    //
    public static int longestSubstringWithoutDup3(String str){
        int left=-1,res=0,n=str.length();
        Map<Character,Integer> m=new HashMap<Character, Integer>();
        for(int i=0;i<n;i++){
            m.put(str.charAt(i),i);
        }
        for(int i=0;i<n;i++){
            if(m.containsKey(str.charAt(i))&&(m.get(str.charAt(i))>left)){
                left=m.get(str.charAt(i));
            }
            res=Math.max(res,i-left);
        }
        return res;
    }
    //
    public static int longestSubstringWithoutDup4(String str){
        int left=-1,res=0,n=str.length();
        int[] m=new int[256];
        for(int i=0;i<n;i++){
            m[str.charAt(i)]=i;
        }
        for(int i=0;i<n;i++){
            if((m[str.charAt(i)]>left)){
                left=m[str.charAt(i)];
            }
            res=Math.max(res,i-left);
        }
        return res;
    }

    //
    public static int longestSubstringWithoutDup5(String str){
        int left=-1,res=0;
        int[] m=new int[26];
        for(int i=0;i<str.length();i++){
            left=Math.max(left,m[str.charAt(i)-'a']);
            m[str.charAt(i)-'a']=i;
            res=Math.max(res,i-left);
        }
        return res;
    }

    public static void main(String[] args){
//        System.out.println(longestSubstringWithoutDup("arabcacfr"));//4
//        System.out.println(longestSubstringWithoutDup("abcdefaaa"));//6
//        System.out.println(longestSubstringWithoutDup2("arabcacfr"));//4
//        System.out.println(longestSubstringWithoutDup2("abcdefaaa"));//6
        System.out.println(longestSubstringWithoutDup5("arabcacfr"));//4
        System.out.println(longestSubstringWithoutDup5("abcdefaaa"));//6



    }
}
