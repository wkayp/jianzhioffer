package chapter6;

public class P263_NumberOfK {
    public static int findnumbersofk(int[] data,int target){
        int left=0,right=data.length-1;
        int[] res=new int[2];
        while (left<right){
            int mid=left+(right-left)/2;
            if(data[mid]<target)
                left=mid+1;
            else
                right=mid;
        }
        if(data[left]!=target) return 0;
        res[0]=left;
        right=data.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if(data[mid]<=target)
                left=mid+1;
            else
                right=mid;
        }
        res[1]=left-1;
        return  res[1]-res[0]+1;

    }
    public static void main(String[] args){
        int target=3;
        int[] data={1,2,3,3,3,3,4,5};
        int[] data1={1,2,4,5};
        int[] data2={3,3,3,3,3,3};
        System.out.println(findnumbersofk(data,target));
        System.out.println(findnumbersofk(data1,target));
        System.out.println(findnumbersofk(data2,target));
    }
}
