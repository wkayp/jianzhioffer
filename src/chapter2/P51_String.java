package chapter2;

public class P51_String {
        //由于java的字符数组没有结束符，所以需要多传入个原始长度
        //先计算好替换后的位置，从后向前替换，时间复杂度o(n)
        public static void replaceBlank(char[] data,int length){
            int newLength = length;//不改变原有length的值
            for(int i=0;i<length;i++){
                if(data[i]==' ')
                    newLength += 2;//注意点1：加2不是3，原本有一个空格
            }
            for(int indexOfOld = length-1,indexOfNew=newLength-1;indexOfOld>=0 && indexOfOld!=indexOfNew;indexOfOld--,indexOfNew--){
                if(data[indexOfOld]==' '){
                    data[indexOfNew--] = '0';
                    data[indexOfNew--] = '2';
                    data[indexOfNew] = '%'; //indexOfNew不用再自减操作，填充了原来的空格
                }
                else{
                    data[indexOfNew] = data[indexOfOld];//注意点2：没有用另外的新数组，而是在原数组上移动，节省内存空间，且可不用返回数组。
                }
            }
        }
        public static void main(String[] args){
            //char[] preda=new char[]{'w',' ','a','r',' e',' ','h','a','p','p''y','.'};//注意点3：可以用原始的声明字符数组的方式，也可以用字符串转字符数组的方式。
            char[] predata = "We are happy.".toCharArray();//将String类型转化为Char[]类
            char[] data = new char[20];
            for(int i=0;i<predata.length;i++)
                data[i] = predata[i];
            System.out.println(data);
            replaceBlank(data,predata.length);
            System.out.println(data);
        }
}
