package chapter2;

public class P79_quickSort {
    public static void quicksort(int[] data){
        sort(data,0,data.length-1);
    }
    public static void sort(int[] data,int left,int right){
        if(left>=right) return;
        int index=partition(data,left,right);
        sort(data,left,index-1);
        sort(data,index+1,right);
    }
    public static int partition(int[] data,int lo,int hi){
        int i=lo,j=hi+1;
        int v=data[lo];
        while (true){
            while (less(data[++i],v)) if(i>=hi) break;
            while (less(v,data[--j])) if(j<=lo) break;
            if(i>=j) break;
            swap(data,i,j);
        }
        swap(data,j,lo);
        return j;
    }
    public static boolean less(int a,int b){
        return a<b;
    }
    public static void swap(int[] data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }

    public static void main(String[] args) {
        int[] data={2,4,6,8,1,3,5,7};
        quicksort(data);
        for(int num:data){
            System.out.print(num+" ");
        }
    }
}
