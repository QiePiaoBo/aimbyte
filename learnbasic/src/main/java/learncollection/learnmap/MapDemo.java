package learncollection.learnmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @Date : 2021/5/18 - 21:04
 * @Description :
 * @Function :
 */
public class MapDemo {

    public static void main(String[] args) {
        // 创建一个HashMap对象
        Map<Integer, String> hm = new HashMap<>();
        // 存储数据
        System.out.println(hm.put(12, "lili"));
        System.out.println(hm.put(7, "feifei"));
        System.out.println(hm.put(19, "lulu"));
        System.out.println(hm.put(12, "mingming"));
        System.out.println(hm.put(6, "yinying"));

        System.out.println("集合中的元素：" + hm);
        System.out.println("集合中的元素数量：" + hm.size());
    }

}
