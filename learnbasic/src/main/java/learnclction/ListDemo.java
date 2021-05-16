package learnclction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dylan
 * @Date : Created in 15:23 2021/5/14
 * @Description :
 * @Function :
 */
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add("asd");

        list.remove(2);
        for (Object o : list){
            System.out.println(o);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }



    }
}
