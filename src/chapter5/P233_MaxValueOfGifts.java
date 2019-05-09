package chapter5;

public class P233_MaxValueOfGifts {
    //方法一：动态规划
    public static int getMaxVaule(int[][] data){
        if(data.length==0||data[0].length==0)
            return 0;
        int[][] dp = new int[data.length][data[0].length];
        dp[0][0]=data[0][0];
        for(int i=1;i<data.length;i++){//左边界，只能往下
            dp[i][0]=dp[i-1][0]+data[i][0];
        }
        for(int j=1;j<data[0].length;j++){//上边界，只能往右
            dp[0][j]=dp[0][j-1]+data[0][j];
        }
        for(int i=1;i<data.length;i++){
            for(int j=1;j<data[0].length;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+data[i][j];//状态转移方式
            }
        }
        return dp[data.length-1][data[0].length-1];
    }

    public static void main(String[] args){
        int[][] data = {
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}};
        System.out.println(getMaxVaule(data));
    }
}
