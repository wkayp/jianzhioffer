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
        res[0]=left;
        right=data.length;//??
        while (left<right){
            int mid=left+(right-left)/2;
            if(data[mid]<=target)
                left=mid+1;
            else
                right=mid;
        }
        res[1]=left;
        return  res[1]-res[0];

    }
    public static void main(String[] args){
        int[] data={1,2,3,3,3,3,4,5};
        System.out.println(findnumbersofk(data,3));
    }
}
