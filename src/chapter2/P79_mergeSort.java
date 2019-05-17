package chapter2;

public class P79_mergeSort {
    public static void sort(int[] arr){
        if(arr==null||arr.length<2)
            return;
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr,int l,int r){
        if(l==r) return;
        int mid=l+((r-l)>>1);//() is very important.
        mergeSort(arr,l,mid);//sort left part
        mergeSort(arr,mid+1,r);//sort right part
        merge(arr,l,mid,r);
    }

    public static void merge(int[] arr,int l,int m,int r){
        int[] help=new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=m+1;
        while (p1<=m&&p2<=r){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=m){
            help[i++]=arr[p1++];
        }
        while (p2<=r){
            help[i++]=arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[l+i]=help[i];//start at l !!!
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5,7,9,2,4,6,8};
        sort(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
