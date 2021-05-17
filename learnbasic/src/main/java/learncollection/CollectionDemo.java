package learncollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Dylan
 * @Date : Created in 14:01 2021/5/14
 * @Description :
 * @Function :
 */
public class CollectionDemo {

    public static void main(String[] args) {
        Collection<Integer> col0 = new ArrayList();
        col0.add(1);
        col0.add(2);
        Collection<Integer> son0 = new ArrayList();
        son0.add(3);
        son0.add(4);
        col0.addAll(son0);
        System.out.println("add/addAll : " + col0);
        System.out.println("size : " + col0.size());

        Iterator<Integer> iterator = col0.iterator();
        while (iterator.hasNext()){
                System.out.println("Iterator : " + iterator.next());
        }

        System.out.println("col0 contains : " + col0.contains(2));

        col0.remove(1);
        col0.removeAll(son0);
        System.out.println("remove/removeAll : " + col0);

        col0.clear();
        System.out.println("clear : " + col0);
        System.out.println("is empty : " + col0.isEmpty());


    }

}
