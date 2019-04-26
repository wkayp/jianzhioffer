package IT_haha;

public class number2 {
    public static String replaceSpace(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String st="hello world";
        System.out.println(replaceSpace(st));
    }
}
