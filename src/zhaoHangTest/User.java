package zhaoHangTest;

public class User implements Cloneable {
    int age;
    Address address;
    public User(int age){
        this.age=age;
        address=new Address("成都天府");
    }
    public User clone() throws CloneNotSupportedException{
        return (User)super.clone();
    }
}
