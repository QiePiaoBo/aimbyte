package learncollection.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * @author Dylan
 * @Date : Created in 10:20 2021/5/18
 * @Description :
 * @Function :
 */
public class Test {

    public static void main(String[] args) {
        GenericTest<Student> s = new GenericTest<>();
        s.a(new Student());
        List list = new ArrayList<Worker>();
    }
}
