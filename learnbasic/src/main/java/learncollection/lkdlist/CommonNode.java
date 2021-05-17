package learncollection.lkdlist;

/**
 * @author Dylan
 * @Date : 2021/5/17 - 21:02
 * @Description :
 * @Function :
 */
public class CommonNode {

    // 三个属性
    // 上一个元素的地址。当前存入的元素。下一个元素的地址
    CommonNode pre;
    Object obj;
    CommonNode next;


    public CommonNode getPre() {
        return pre;
    }

    public void setPre(CommonNode pre) {
        this.pre = pre;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public CommonNode getNext() {
        return next;
    }

    public void setNext(CommonNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "pre=" + pre +
                ", obj=" + obj +
                ", next=" + next +
                '}';
    }
}
