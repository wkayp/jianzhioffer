package chapter2;

public class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public ListNode(T val){
        this.val = val;
        this.next = null;
    }
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        for(ListNode cur = this;;cur=cur.next){
            if(cur==null){
                //deleteCharAt(int index) 移除此序列指定位置上的 char。
                //lastIndexOf(String str, int fromIndex) 返回最后一次出现的指定子字符串在此字符串中的索引。
                ret.deleteCharAt(ret.lastIndexOf(" "));
                ret.deleteCharAt(ret.lastIndexOf(","));
                break;
            }
            ret.append(cur.val);
            ret.append(", ");
        }
        ret.append("]");
        return ret.toString();
    }
/*        ListNode<T> cur = this;
        T val = this.val;
        String st = "" + val;
        return st;
    }*/

}