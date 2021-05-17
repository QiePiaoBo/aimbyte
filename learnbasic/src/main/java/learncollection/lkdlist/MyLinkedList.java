package learncollection.lkdlist;

/**
 * @author Dylan
 * @Date : 2021/5/17 - 21:06
 * @Description :
 * @Function :
 */
public class MyLinkedList {

    // 链中一定有一个首节点和一个尾节点
    Node first;
    Node last;
    // 计数器
    int count = 0;

    public MyLinkedList() {
    }

    public void add(Object o){
        if (first == null){
            // first为Null时说明这是第一个节点
            // 将传入的元素封装成一个Node对象并赋值给first
            Node node = new Node();
            node.setPre(null);
            node.setObj(o);
            node.setNext(null);
            // 当前链中第一个节点变为node,最后一个节点也变成node
            first = node;
            last = node;
        }else {
            // 已经不是第一个节点了
            Node node = new Node();
            node.setPre(last); // node的上一个节点肯定是当前链中的last
            node.setObj(o);
            node.setNext(null);
            // 当前链中的last的下一个节点设置为node
            last.setNext(node);
            // 将最后一个节点变为node
            last = node;
        }
        count ++;
    }
    // 得到集合中元素的数量
    public int getSize(){
        return count;
    }
    // 通过下标得到元素
    public Object get(int index){
        // 首先获取链表的头元素
        Node n = new Node();
        if (first != null){
            n = first;
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
        }
        return n.getObj();
    }

}
class Node {

    // 三个属性
    // 上一个元素的地址。当前存入的元素。下一个元素的地址
    Node pre;
    Object obj;
    Node next;


    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
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
class Test{
    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.add("aa");
        ml.add("bb");
        ml.add("cc");
        System.out.println(ml.getSize());
        System.out.println(ml.get(0));
    }
}
