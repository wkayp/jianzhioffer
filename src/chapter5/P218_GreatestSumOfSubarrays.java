package chapter5;

public class P218_GreatestSumOfSubarrays {
    //动态规划，递归公式：dp[i] =  data[i]          i=0或dp[i-1]<=0
    //                dp[i-1]+data[i]           i!=0且dp[i-1]>0
    //由于只需知道前一个情况的dp值，因此可省去dp数组，申请个变量记录即可
    public static int findGreatestSumOfSumArrays(int[] data){
        if(data==null || data.length==0)
            return 0;
        int curSum=0;
        int res=Integer.MIN_VALUE;//当数组全部为负时
        for(int num:data){
            curSum=Math.max(num,num+curSum);
            res=Math.max(res,curSum);
        }
        return res;
    }
    public static void main(String[] args){
        int[] data = {1,-2,3,10,-4,7,2,-5};
        int[] data1={-2,-1,-3,-4};
        System.out.println(findGreatestSumOfSumArrays(data));
        System.out.println(findGreatestSumOfSumArrays(data1));
    }
}
