package com.dylan.learnbasic.learnjdbc;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dylan
 * @Date : 2021/10/31 - 12:39
 * @Description :
 * @Function :
 */
public class MybatisTest01 {

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(MybatisTest01.class.getClassLoader(), new Class<?>[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                buildMethodArgNameMap(method, args);
                System.out.println(Arrays.toString(args));
                // 方法名
                System.out.println(method.getName());
                Select annotation = method.getAnnotation(Select.class);
                if (annotation != null) {
                    String[] values = annotation.value();
                    System.out.println(Arrays.toString(values));
                }
                return null;
            }
        });

        userMapper.selectUserList(1);
    }

    public static String parseSQL(String sql, Map<String, Object> nameArgMap){
        StringBuilder stringBuilder = new StringBuilder();
        int length = sql.length();
        for (int i = 0; i < length; i++) {

        }
        return "";
    }

    public static Map<String, Object> buildMethodArgNameMap(Method method, Object[] args) {
        Map<String, Object> nameArgMap = new ConcurrentHashMap<>();
        Parameter[] parameters = method.getParameters();
        int[] indexes = new int[]{0};
        // java的匿名类中对外部引用自动加了final修饰，无法直接对外部的基本数据类型直接进行修改
        // parallelStream可以在数据量大时对数据进行并行处理
        Arrays.asList(parameters).parallelStream().forEach(parameter -> {
            String name = parameter.getName();
            System.out.println(name);
            nameArgMap.put(name, args[indexes[0]]);
            indexes[0] ++;
        });

        return nameArgMap;
    }

}


interface UserMapper {
    @Select("Select * from user where id = #{id}")
    List<User> selectUserList(Integer id);
}