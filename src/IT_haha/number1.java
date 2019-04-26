package IT_haha;

public class number1 {
    public static boolean find(int[][] nums,int target){
        if(nums==null||nums.length==0) return false;
        int row=0,col=nums[0].length-1;
        while (row<nums.length&&col>=0){
            if(nums[row][col]==target) return true;
            else if(nums[row][col]<target)
                row++;
            else
                col--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 8;
        System.out.println(find(nums, target));
    }
}
