package chapter6;

public class P266_getMissingNumber {
    public static int getMissingNumber(int[] data){
        int left=0,right=data.length-1;
        while (left<=right){//相等判断在循环一次
            int mid=left+(right-left)/2;
            if(data[mid]!=mid){
                if(mid==0||data[mid-1]==mid-1)
                    return mid;
                else
                    right=mid-1;
            }else {
                left=mid+1;
            }
        }
        if(left==data.length)
            return data.length;

        return -1;
    }

    public static void main(String[] args){
        int[] data={0,1,2,3,5,6,7,8};
        int[] data1={1,2,3};
        int[] data2={0,1,2,3,4};
        System.out.println(getMissingNumber(data));
        System.out.println(getMissingNumber(data1));
        System.out.println(getMissingNumber(data2));
    }
}
