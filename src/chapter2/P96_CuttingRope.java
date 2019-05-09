package chapter2;

public class P96_CuttingRope {
    public static int maxCutting(int length){
        if(length<2) return 0;
        if(length==2)return 1;
        if(length==3)return 2;
        int[] dp = new int[length+1];
        dp[0]=0;//仅仅为后续迭代服务，看成单独长度，与上面返回的值不冲突
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=length;i++){
            for(int j=1;j<=i/2;j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[length];
    }
    public static void main(String[] args){
        for(int i=2;i<10;i++){
            System.out.println("长度为"+i+"的最大值->"+maxCutting(i));
        }
    }
}
