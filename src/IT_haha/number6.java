package IT_haha;

public class number6 {
    public static int minNumberInRotateArray(int[] nums){
        if(nums==null||nums.length==0) return 0;
        int index1=0,index2=nums.length-1;
        while(nums[index1]>=nums[index2]){
            if(index2-index1==1) return nums[index2];
            int mid=index1+(index2-index1)/2;
            if(nums[index1]==nums[index2]&&nums[index1]==nums[mid]){
                for(int i=index1;i<=index2;i++){
                    if(nums[i]<nums[index1]){
                        return nums[i];
                    }
                }
                return nums[mid];
            }
            if(nums[mid]>=nums[index2]){
                index1=mid;
            }else
                index2=mid;
        }
        return nums[0];
    }
}
