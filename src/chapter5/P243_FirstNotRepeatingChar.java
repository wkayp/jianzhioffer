package chapter5;

public class P243_FirstNotRepeatingChar {
    public static char firstNotRepeatingChar(String str){
        if(str==null||str.length()==0) return '\77';//'\77'表示？字符
        int[] map=new int[256];
        for(int i=0;i<str.length();i++){
            map[str.charAt(i)]++;
        }
        for (int i=0;i<str.length();i++){
            if(map[str.charAt(i)]==1){
                return str.charAt(i);
            }
        }
        return '\77';
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("abaccdeff"));
        System.out.println(firstNotRepeatingChar("aavvcc"));
    }
}
