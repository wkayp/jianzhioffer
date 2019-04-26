package chapter5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P209_KLeastNumbers {
    public static int partition(int[] nums,int lo,int hi){
        //将数组切分为a[lo...i-1],a[i],a[i+1...hi]
        int i=lo,j=hi+1;//左右扫面指针
        int v=nums[lo];//切分元素
        while (true){
            //扫描左右，检查扫描是否结束并交换元素
            while (less(nums[++i],v)) if(i>=hi) break;
            while (less(v,nums[--j])) if(j<=lo) break;
            if(i>=j) break;
            swap(nums,i,j);
        }
        swap(nums,lo,j);//将v=nums[j]放入正确的位置
        return j;//a[lo...j-1]<=a[j]<=a[j+1...hi]达成
    }
    public static boolean less(int a,int b){
        if(a<b) return true;
        else return false;
    }
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static int[] findKth(int[] nums,int[] out,int k){
        int lo=0,hi=nums.length-1;
        int index=partition(nums,lo,hi);
        while(index!=k-1){
            if(index>k-1){
                hi=index-1;
                index=partition(nums,lo,hi);
            }else {
                lo=index+1;
                index=partition(nums,lo,hi);
            }
        }
        for(int i=0;i<k;i++){
            out[i]=nums[i];
        }
        return out;
    }
    public static int findKthLargest(int[] nums,int k){
        int lo=0,hi=nums.length-1;
        int index=partition(nums,lo,hi);
        while(index!=k-1){
            if(index>k-1){
                hi=index-1;
                index=partition(nums,lo,hi);
            }else {
                lo=index+1;
                index=partition(nums,lo,hi);
            }
        }
        return nums[k-1];
    }

    public static void sort(int[] nums){
        sort(nums,0,nums.length-1);
    }
    public static void sort(int[] nums,int lo,int hi){
        if(lo>=hi) return;
        int index=partition(nums,lo,hi);//用partition函数切分
        sort(nums,lo,index-1);//将左半部分a[lo...j-1]排序
        sort(nums,index+1,hi);//将右半部分a[j+1...hi]排序
    }


    //解法二：不改变原始数组，使用优先队列，时间复杂度O(nlogk)，适合海量数据
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || k > input.length || k<=0) return result;
        //优先队列的作用是能保证每次取出的元素都是队列中权值最小的（Java的优先队列每次取最小元素，C++的优先队列每次取最大元素）
        //元素大小的评判可以通过元素本身的自然顺序（natural ordering），也可以通过构造时传入的比较器（Comparator，类似于C++的仿函数）
        PriorityQueue<Integer> maxQueue = new PriorityQueue(k,new Comparator<Integer>(){//使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。
            @Override
            public int compare(Integer o1,Integer o2){
                return o2.compareTo(o1);//将先前Integer中的自然排序（从小到大）反过来，实现从大到小；
            }
        });
        //PriorityQueue的peek()和element操作是常数时间，add(), offer(), 无参数的remove()以及poll()方法的时间复杂度都是log(N)。
        for(int i =0;i<input.length;i++){
            if(maxQueue.size() != k ){
                maxQueue.offer(input[i]);
            }else if(maxQueue.peek() > input[i]){
                maxQueue.poll();//必须先去除队列头部的数据,以保证队列长度
                maxQueue.offer(input[i]);
            }
        }
        for(Integer i : maxQueue){
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args){
        int k=4;
        int[] n={4,5,1,6,2,7,3,8};
        int[] o=new int[k];
//        findKth(n,o,k);
        System.out.println(GetLeastNumbers_Solution(n,k));
//        sort(n);
//        for(int num:n){
//            System.out.println(num);
//        }
    }
}
