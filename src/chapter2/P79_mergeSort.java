package chapter2;

public class P79_mergeSort {
    public static int[] aux;
    public static void mergesort(int[] a){
        aux=new int[a.length];
        sort(a,0,a.length-1);
    }
    public static void sort(int[] a,int lo,int hi){
        if(lo>=hi) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);//将左边排序
        sort(a,mid+1,hi);//将右边排序
        merge(a,lo,mid,hi);
    }
    public static void merge(int[] a,int lo,int mid,int hi){
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }
        for(int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }
    public static boolean less(int a,int b){
        return a<b;
    }

    public static void main(String[] args) {
        int[] a={2,4,6,8,1,3,5,7};
        mergesort(a);
        for(int num:a){
            System.out.print(num+" ");
        }
    }
}
