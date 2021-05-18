package learncollection.generic;

/**
 * @author Dylan
 * @Date : Created in 10:19 2021/5/18
 * @Description :
 * @Function :
 */
public class GenericTest<T extends Person> {

    public void a(T t){
        t.b();
    }
}
