package chapter2;

public class P82_MinNumberInRotatedArray {
    //在旋转数组中查找target，找到返回下标，未找到返回-1.
    public static int searchinrotatedarray(int[] data,int target){
        int left=0,right=data.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(data[mid]==target) return mid;
            else if(data[mid]<data[right]){
                if(data[mid]<target&&target<=data[right])
                    left=mid+1;
                else
                    right=mid-1;
            }else if(data[mid]>data[right]){
                if(data[left]<=target&&target<data[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }else//有重复值的情况
                --right;
        }
        return -1;
    }
    //在旋转数组中查找最小数字，找到返回数组的最小值.
    public static int findMin(int[] data){
        int left=0,right=data.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(data[mid]<data[right])
                right=mid;
            else if(data[mid]>data[right]){
                left=mid+1;
            }else if(data[mid]==data[right]){
                --right;
            }
        }
        return data[left];
    }

    public static void main(String[] args){
        int[] data3={2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] data1={1,1,3,1,1,1,1};
        int[] data={5,6,7,1,2,3,4};
        int target=3;
        System.out.println(searchinrotatedarray(data,target));
        System.out.println(findMin(data));
        System.out.println(findMin(data1));
    }
}
