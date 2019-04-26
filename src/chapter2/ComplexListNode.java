package chapter2;

public  class ComplexListNode{
    public int val;
    public ComplexListNode next;
    public ComplexListNode random;

    public ComplexListNode(int val) {
        this.val = val;
        //this.next=null;
    }
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ComplexListNode cur = this;
        while(cur!=null) {
            ret.append(cur.val);
            if(cur.random!=null)
                ret.append("("+cur.random.val+")");
            else{
                ret.append("(_)");
            }
            ret.append('\t');
            cur = cur.next;
        }
        return ret.toString();
    }
}


