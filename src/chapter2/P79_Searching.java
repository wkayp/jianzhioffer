package chapter2;

public class P79_Searching {
    //二分查找，要求data数组有序，找到返回下标，未找到返回-1.
    public static int binarySearch(int[] data,int target){
        int left=0,right=data.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(data[mid]<target)
                left=mid+1;
            else if(data[mid]>target)
                right=mid-1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] data={1,3,4,5,6,7,8};
        int target=5;
        System.out.println(binarySearch(data,target));
    }
}
