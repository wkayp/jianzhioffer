package chapter6;

public class P267_IntegerIdenticalToIndex {
    public static int getNumberSameAsIndex(int[] data){
        int left=0,right=data.length-1;
        while (left<=right){//
            int mid=left+(right-left)/2;
            if(data[mid]==mid)
                return mid;
            else if(data[mid]>mid){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {//psvm
        int[] data={-1,0,1,3,4,5,6};
        int[] data1={0};
        System.out.println(getNumberSameAsIndex(data));//sout
        System.out.println(getNumberSameAsIndex(data1));
    }
}
