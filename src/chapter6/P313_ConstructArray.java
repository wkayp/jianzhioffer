package chapter6;

public class P313_ConstructArray {
    public static int[] multiply(int[] data){
        if(data==null||data.length<2)
            return null;
        int N=data.length;
        //int[] fwd=new int[N],bwd=new int[N];
        int[] result=new int[N];
        result[0]=1;
        int bwd=1;
        for(int i=1;i<N;i++){
            result[i]=result[i-1]*data[i-1];
        }
        for(int i=N-1;i>=0;i--){
            result[i]*=bwd;
            bwd*=data[i];
        }
/*        for(int i=0;i<N;i++){
            result[i]=fwd[i]*result[i];
        }*/
        return result;
    }


    public static void main(String[] args){
        int[] data = new int[]{1,2,3,4,5};
        int[] result = multiply(data);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print("  ");
        }
    }
}