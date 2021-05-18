package learncollection.learnset;

import java.util.HashSet;

/**
 * @author Dylan
 * @Date : Created in 12:39 2021/5/18
 * @Description :
 * @Function :
 */
public class TestString {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("apple");
        hs.add("banana");
        hs.add("com");
        hs.add("css");
        hs.add("html");
        hs.add("apple");
        System.out.println(hs);
    }
}
